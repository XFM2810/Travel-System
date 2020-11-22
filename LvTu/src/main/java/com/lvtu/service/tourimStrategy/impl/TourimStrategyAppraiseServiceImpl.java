package com.lvtu.service.tourimStrategy.impl;

import com.lvtu.entity.TourimStrategyAppraise;
import com.lvtu.mapper.TourimStrategyAppraiseMapper;
import com.lvtu.response.error.BusinessException;
import com.lvtu.response.error.EmBusinessError;
import com.lvtu.service.tourimStrategy.TourimStrategyAppraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author XuMeiFeng
 * @create 2020/11/21 22:06
 * @description
 */
@Service
public class TourimStrategyAppraiseServiceImpl implements TourimStrategyAppraiseService {
  @Autowired private TourimStrategyAppraiseMapper tourimStrategyAppraiseMapper;

  @Override
  public List<TourimStrategyAppraise> getStrategyAppraiseList(int id, int flag) {
    Map<String, Integer> map = new LinkedHashMap<>();
    map.put("id", id);
    map.put("flag", flag);
    List<TourimStrategyAppraise> tourimStrategyAppraiseList =
        tourimStrategyAppraiseMapper.getStrategyAppraiseList(map);
    return tourimStrategyAppraiseList;
  }

  @Override
  public void releaseStrategyAppraiseList(TourimStrategyAppraise tourimStrategyAppraise) {
    tourimStrategyAppraise.setCreateTime(new Date());
    tourimStrategyAppraiseMapper.insertSelective(tourimStrategyAppraise);
  }

  @Override
  public void deleteStrategyAppraise(int userId, int appraiseId) throws BusinessException {
    if (tourimStrategyAppraiseMapper.getStrategyAppraiseUserId(appraiseId) == userId) {
      tourimStrategyAppraiseMapper.deleteByPrimaryKey(appraiseId);
    } else {
      throw new BusinessException(EmBusinessError.DEFAULT_ERROR, "删除失败");
    }
  }
}
