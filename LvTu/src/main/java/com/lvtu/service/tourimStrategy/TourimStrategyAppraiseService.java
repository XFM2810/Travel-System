package com.lvtu.service.tourimStrategy;

import com.lvtu.entity.TourimStrategyAppraise;
import com.lvtu.response.error.BusinessException;

import java.util.List;

/**
 * @author XuMeiFeng
 * @create 2020/11/21 22:06
 * @description
 */
public interface TourimStrategyAppraiseService {
  public List<TourimStrategyAppraise> getStrategyAppraiseList(int id, int flag);

  public void releaseStrategyAppraiseList(TourimStrategyAppraise tourimStrategyAppraise);

  public void deleteStrategyAppraise(int userId, int appraiseId) throws BusinessException;
}
