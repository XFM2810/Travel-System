package com.lvtu.service.tourimStrategy;

import com.lvtu.domain.VO.TourimStrategyListVO;
import com.lvtu.domain.VO.TourimStrategyVO;
import com.lvtu.entity.TourimStrategy;

import java.util.List;

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

  public List<TourimStrategyListVO> getStrategyListByAddress(
      String city, int currentPage, int pageSize);

  public List<TourimStrategyListVO> getStrategyListOfUserRelease(int userId);

  public List<TourimStrategyListVO> getStrategyListOfUserCollection(int userId);

  public TourimStrategyVO getStrategyInfo(int strategyId);

  public void shareStrategy(TourimStrategy tourimStrategy);
}
