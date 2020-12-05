package com.lvtu.controller.user;

import com.lvtu.response.CommonReturnType;
import com.lvtu.response.error.BusinessException;
import com.lvtu.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XuMeiFeng
 * @create 2020/11/22 21:58
 * @description
 */
@RestController
@Api(
    value = "UserController",
    tags = {"用户模块"})
public class UserController {
  @Autowired private UserService userService;
  /*
   * @Author XuMeiFeng
   * @Description 用户登录
   * @Date 17:49 2020/12/5
   */
  @ApiOperation("用户登录")
  @PostMapping("/login")
  public CommonReturnType login() throws BusinessException {
    return CommonReturnType.create(null);
  }

  /*
   * @Author XuMeiFeng
   * @Description 用户注册
   * @Date 17:50 2020/12/5
   */
  @ApiOperation("用户注册")
  @PostMapping("/register")
  public CommonReturnType register() throws BusinessException {
    return CommonReturnType.create(null);
  }
}
