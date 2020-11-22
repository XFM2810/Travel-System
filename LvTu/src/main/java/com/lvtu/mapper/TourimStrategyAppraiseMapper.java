package com.lvtu.mapper;

import com.lvtu.entity.TourimStrategyAppraise;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TourimStrategyAppraiseMapper {
  int deleteByPrimaryKey(Integer appraiseId);

  int insert(TourimStrategyAppraise record);

  int insertSelective(TourimStrategyAppraise record);

  TourimStrategyAppraise selectByPrimaryKey(Integer appraiseId);

  int updateByPrimaryKeySelective(TourimStrategyAppraise record);

  int updateByPrimaryKey(TourimStrategyAppraise record);

  List<TourimStrategyAppraise> getStrategyAppraiseList(Map<String, Integer> map);

  int getStrategyAppraiseUserId(Integer appraiseId);
}
