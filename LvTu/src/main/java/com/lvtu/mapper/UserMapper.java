package com.lvtu.mapper;

import com.lvtu.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
  int deleteByPrimaryKey(Integer userId);

  int insert(User record);

  int insertSelective(User record);

  User selectByPrimaryKey(Integer userId);

  int updateByPrimaryKeySelective(User record);

  int updateByPrimaryKey(User record);

  User getUser(String openId);
}
