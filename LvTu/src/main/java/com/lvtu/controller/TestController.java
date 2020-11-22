package com.lvtu.controller;

import com.lvtu.mapper.UserMapper;
import com.lvtu.response.CommonReturnType;
import com.lvtu.response.error.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
  @Autowired private UserMapper userMapper;

  @GetMapping("/test")
  public CommonReturnType test() throws BusinessException {
    // Controller层与Service层发生异常则抛出BusinessException，由BaseController统一处理

    return CommonReturnType.create(userMapper.selectByPrimaryKey(1));
  }
}
