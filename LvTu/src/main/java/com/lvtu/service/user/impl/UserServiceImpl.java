package com.lvtu.service.user.impl;

import com.lvtu.mapper.UserMapper;
import com.lvtu.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XuMeiFeng
 * @create 2020/11/22 21:58
 * @description
 */
@Service
public class UserServiceImpl implements UserService {
  @Autowired private UserMapper userMapper;
}
