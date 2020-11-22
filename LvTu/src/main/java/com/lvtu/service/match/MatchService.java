package com.lvtu.service.match;

import com.lvtu.domain.VO.MatchListVO;
import com.lvtu.entity.Mat;

import java.util.List;

/**
 * @author XuMeiFeng
 * @create 2020/11/22 19:54
 * @description
 */
public interface MatchService {
  public void releaseMatch(Mat mat);

  public void updateMatch(Mat mat);

  public void deleteMatch(int matId);

  public List<MatchListVO> getMatchListOfUser(int userId, int currentPage, int pageSize, int flag);

  public List<MatchListVO> getMatchOfCity(String city, int currentPage, int pageSize);

  public List<MatchListVO> getMatchByKeyword(String keyword, int currentPage, int pageSize);

  public Mat getMatchInfo(int matId);
}
