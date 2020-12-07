package com.lvtu.service.tourimStrategy;

import com.lvtu.domain.VO.TourimStrategyListVO;
import com.lvtu.entity.TourimStrategy;

import java.util.List;
import java.util.Map;

/**
 * @author XuMeiFeng
 * @create 2020/11/20 15:16
 * @description
 */
public interface TourimStrategyService {
  public void releaseStrategy(TourimStrategy tourimStrategy);

  public void updateStrategy(TourimStrategy tourimStrategy);

  public void deleteStrategy(List<Integer> strategyIds);

  public void hideStrategy(int strategyId);

  public void showStrategy(int strategyId);

  public Map getStrategyListByAddress(String city, int currentPage, int pageSize);

  public List<TourimStrategyListVO> getStrategyListOfUserRelease(int userId);

  public List<TourimStrategyListVO> getStrategyListOfUserCollection(int userId);

  public Map getStrategyInfo(Map map);

  public void shareStrategy(TourimStrategy tourimStrategy);

  public Map queryStrategy(Map map, int currentPage, int pageSize);
}
