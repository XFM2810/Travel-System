package com.lvtu.service.match;

import com.lvtu.entity.Mat;

import java.util.Map;

/**
 * @author XuMeiFeng
 * @create 2020/11/22 19:54
 * @description
 */
public interface MatchService {
  public void releaseMatch(Mat mat);

  public void updateMatch(Mat mat);

  public void deleteMatch(int matId);

  public Map getMatchListOfUser(int userId, int currentPage, int pageSize, int flag);

  public Map getMatchOfCity(String city, int currentPage, int pageSize);

  public Map getMatchByKeyword(String keyword, int currentPage, int pageSize);

  public Mat getMatchInfo(int matId);
}
