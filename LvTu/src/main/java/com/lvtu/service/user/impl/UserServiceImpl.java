package com.lvtu.service.user.impl;

import com.lvtu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XuMeiFeng
 * @create 2020/11/22 21:58
 * @description
 */
@Service
public class UserServiceImpl {
  @Autowired private UserMapper userMapper;
}
