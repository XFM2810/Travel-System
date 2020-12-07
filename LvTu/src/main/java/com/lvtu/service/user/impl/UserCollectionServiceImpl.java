package com.lvtu.service.user.impl;

import com.lvtu.entity.TourimStrategy;
import com.lvtu.entity.UserCollection;
import com.lvtu.mapper.TourimStrategyMapper;
import com.lvtu.mapper.UserCollectionMapper;
import com.lvtu.service.user.UserCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author XuMeiFeng
 * @create 2020/11/22 16:30
 * @description
 */
@Service
public class UserCollectionServiceImpl implements UserCollectionService {
  @Autowired private UserCollectionMapper userCollectionMapper;
  @Autowired private TourimStrategyMapper tourimStrategyMapper;

  @Override
  public void collectionStrategy(int strategyCollections, UserCollection userCollection) {
    userCollection.setCreateTime(new Date());
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("strategyId", userCollection.getStrategyId());
    map.put("userId", userCollection.getUserId());
    if (userCollectionMapper.getCollectionId(map) + "" == "") {
      userCollectionMapper.insertSelective(userCollection);
      TourimStrategy tourimStrategy = new TourimStrategy();
      tourimStrategy.setStrategyId(userCollection.getStrategyId());
      tourimStrategy.setStrategyCollections(strategyCollections + 1);
      tourimStrategyMapper.updateByPrimaryKeySelective(tourimStrategy);
    }
  }

  @Override
  public void cancelCollection(int strategyCollections, UserCollection userCollection) {
    userCollectionMapper.deleteByPrimaryKey(userCollection.getCollectionId());
    TourimStrategy tourimStrategy = new TourimStrategy();
    tourimStrategy.setStrategyId(userCollection.getStrategyId());
    tourimStrategy.setStrategyCollections(strategyCollections - 1);
    tourimStrategyMapper.updateByPrimaryKeySelective(tourimStrategy);
  }
}
