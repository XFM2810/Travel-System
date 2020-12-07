package com.lvtu.mapper;

import com.lvtu.entity.TourimStrategy;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TourimStrategyMapper {
  int deleteByPrimaryKey(Integer strategyId);

  int insertSelective(TourimStrategy record);

  TourimStrategy selectByPrimaryKey(Integer strategyId);

  int updateByPrimaryKeySelective(TourimStrategy record);

  int updateStrategyStatus(Map<String, Integer> map);

  List<TourimStrategy> getStrategyListByAddress(Map map);

  List<TourimStrategy> getStrategyListOfUserRelease(int userId);

  List<TourimStrategy> getStrategyListOfUserCollection(int userId);
}
