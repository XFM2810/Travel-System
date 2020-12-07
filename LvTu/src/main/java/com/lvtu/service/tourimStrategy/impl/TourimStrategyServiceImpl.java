package com.lvtu.service.tourimStrategy.impl;

import com.github.pagehelper.PageHelper;
import com.lvtu.domain.VO.TourimStrategyListVO;
import com.lvtu.domain.VO.TourimStrategyVO;
import com.lvtu.entity.TourimStrategy;
import com.lvtu.mapper.TourimStrategyMapper;
import com.lvtu.mapper.UserCollectionMapper;
import com.lvtu.service.tourimStrategy.TourimStrategyService;
import com.lvtu.utils.MyPageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author XuMeiFeng
 * @create 2020/11/20 15:17
 * @description
 */
@Service
public class TourimStrategyServiceImpl implements TourimStrategyService {
  @Autowired private TourimStrategyMapper tourimStrategyMapper;
  @Autowired private UserCollectionMapper userCollectionMapper;

  @Override
  public void releaseStrategy(TourimStrategy tourimStrategy) {
    tourimStrategy.setCreateTime(new Date());
    tourimStrategy.setUpdateTime(new Date());
    tourimStrategyMapper.insertSelective(tourimStrategy);
  }

  @Override
  public void updateStrategy(TourimStrategy tourimStrategy) {
    tourimStrategyMapper.updateByPrimaryKeySelective(tourimStrategy);
  }

  @Override
  public void deleteStrategy(List<Integer> strategyIds) {
    for (int strategyId : strategyIds) {
      tourimStrategyMapper.deleteByPrimaryKey(strategyId);
    }
  }

  @Override
  public void hideStrategy(int strategyId) {
    Map<String, Integer> map = new LinkedHashMap<>();
    map.put("isShow", 0);
    map.put("strategyId", strategyId);
    tourimStrategyMapper.updateStrategyStatus(map);
  }

  @Override
  public void showStrategy(int strategyId) {
    Map<String, Integer> map = new LinkedHashMap<>();
    map.put("isShow", 1);
    map.put("strategyId", strategyId);
    tourimStrategyMapper.updateStrategyStatus(map);
  }

  @Override
  public Map getStrategyListByAddress(String city, int currentPage, int pageSize) {
    PageHelper.startPage(currentPage, pageSize);
    Map map = new LinkedHashMap();
    map.put("city", city);
    List<TourimStrategy> tourimStrategyList = tourimStrategyMapper.getStrategyListByAddress(map);
    return MyPageHelper.returnPage(
        tourimStrategyList, convert(tourimStrategyList), "tourimStrategyList");
  }

  @Override
  public List<TourimStrategyListVO> getStrategyListOfUserRelease(int userId) {
    return convert(tourimStrategyMapper.getStrategyListOfUserRelease(userId));
  }

  @Override
  public List<TourimStrategyListVO> getStrategyListOfUserCollection(int userId) {
    return convert(tourimStrategyMapper.getStrategyListOfUserCollection(userId));
  }

  @Override
  public Map getStrategyInfo(Map map) {
    TourimStrategyVO tourimStrategyVO = new TourimStrategyVO();
    TourimStrategy tourimStrategy =
        tourimStrategyMapper.selectByPrimaryKey((Integer) map.get("strategyId"));
    BeanUtils.copyProperties(tourimStrategy, tourimStrategyVO);
    Map<String, Object> returnMap = new LinkedHashMap<>();
    returnMap.put("tourimStrategy", tourimStrategyVO);
    Integer collectionId;
    try {
      collectionId = userCollectionMapper.getCollectionId(map);
    } catch (Exception e) {
      collectionId = null;
    }
    returnMap.put("collectionId", collectionId);
    return returnMap;
  }

  @Override
  public void shareStrategy(TourimStrategy tourimStrategy) {
    tourimStrategy.setStrategyShares(tourimStrategy.getStrategyShares() + 1);
    tourimStrategyMapper.updateByPrimaryKeySelective(tourimStrategy);
  }

  @Override
  public Map queryStrategy(Map map, int currentPage, int pageSize) {
    PageHelper.startPage(currentPage, pageSize);
    List<TourimStrategy> tourimStrategyList = tourimStrategyMapper.getStrategyListByAddress(map);
    return MyPageHelper.returnPage(
        tourimStrategyList, convert(tourimStrategyList), "tourimStrategyList");
  }

  private List<TourimStrategyListVO> convert(List<TourimStrategy> tourimStrategyList) {
    List<TourimStrategyListVO> tourimStrategyListVOS = new ArrayList<>();
    for (TourimStrategy tourimStrategy : tourimStrategyList) {
      TourimStrategyListVO tourimStrategyListVO = new TourimStrategyListVO();
      BeanUtils.copyProperties(tourimStrategy, tourimStrategyListVO);
      tourimStrategyListVOS.add(tourimStrategyListVO);
    }
    return tourimStrategyListVOS;
  }
}
