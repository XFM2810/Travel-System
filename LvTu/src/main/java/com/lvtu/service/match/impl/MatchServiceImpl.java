package com.lvtu.service.match.impl;

import com.github.pagehelper.PageHelper;
import com.lvtu.domain.VO.MatchListVO;
import com.lvtu.entity.Mat;
import com.lvtu.mapper.MatMapper;
import com.lvtu.service.match.MatchService;
import com.lvtu.utils.MyPageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author XuMeiFeng
 * @create 2020/11/22 19:55
 * @description
 */
@Service
public class MatchServiceImpl implements MatchService {
  @Autowired private MatMapper matMapper;

  @Override
  public void releaseMatch(Mat mat) {
    mat.setCreateTime(new Date());
    mat.setUpdateTime(new Date());
    matMapper.insertSelective(mat);
  }

  @Override
  public void updateMatch(Mat mat) {
    matMapper.updateByPrimaryKeySelective(mat);
  }

  @Override
  public void deleteMatch(int matId) {
    matMapper.deleteByPrimaryKey(matId);
  }

  @Override
  public Map getMatchListOfUser(int userId, int currentPage, int pageSize, int flag) {
    PageHelper.startPage(currentPage, pageSize);
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("userId", userId);
    map.put("flag", flag);
    List<Mat> matList = matMapper.getMatchList(map);
    return MyPageHelper.returnPage(matList, convert(matList), "matList");
  }

  @Override
  public Map getMatchOfCity(String city, int currentPage, int pageSize) {
    PageHelper.startPage(currentPage, pageSize);
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("city", city);
    map.put("flag", 2);
    List<Mat> matList = matMapper.getMatchList(map);
    return MyPageHelper.returnPage(matList, convert(matList), "matList");
  }

  @Override
  public Map getMatchByKeyword(String keyword, int currentPage, int pageSize) {
    PageHelper.startPage(currentPage, pageSize);
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("keyword", keyword);
    map.put("flag", 3);
    List<Mat> matList = matMapper.getMatchList(map);
    return MyPageHelper.returnPage(matList, convert(matList), "matList");
  }

  @Override
  public Mat getMatchInfo(int matId) {
    Mat mat = matMapper.selectByPrimaryKey(matId);
    return mat;
  }

  private List<MatchListVO> convert(List<Mat> matList) {
    List<MatchListVO> matchListVOList = new ArrayList<>();
    for (Mat mat : matList) {
      MatchListVO matchListVO = new MatchListVO();
      BeanUtils.copyProperties(mat, matchListVO);
      matchListVOList.add(matchListVO);
    }
    return matchListVOList;
  }
}
