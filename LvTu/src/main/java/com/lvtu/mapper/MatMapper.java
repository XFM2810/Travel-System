package com.lvtu.mapper;

import com.lvtu.entity.Mat;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MatMapper {
  int deleteByPrimaryKey(Integer matId);

  int insert(Mat record);

  int insertSelective(Mat record);

  Mat selectByPrimaryKey(Integer matId);

  int updateByPrimaryKeySelective(Mat record);

  int updateByPrimaryKey(Mat record);
  // flag: 0通过uerId查询用户发布，1通过uerId查询用户参与，2通过city查询，3通过关键字查询
  List<Mat> getMatchList(Map<String, Object> map);
}
