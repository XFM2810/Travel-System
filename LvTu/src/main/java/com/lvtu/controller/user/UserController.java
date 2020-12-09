package com.lvtu.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.lvtu.controller.BaseController;
import com.lvtu.domain.VO.UserVO;
import com.lvtu.response.CommonReturnType;
import com.lvtu.response.error.BusinessException;
import com.lvtu.service.user.UserService;
import com.lvtu.utils.HttpClientUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XuMeiFeng
 * @create 2020/11/22 21:58
 * @description
 */
@RestController
@Api(
    value = "UserController",
    tags = {"用户模块"})
public class UserController extends BaseController {
  @Autowired private UserService userService;
  /*
   * @Author XuMeiFeng
   * @Description 用户登录
   * @Date 17:49 2020/12/5
   */
  @ApiOperation("用户登录")
  @PostMapping("/login")
  public CommonReturnType login(String code) throws BusinessException {
    // 登录凭证校验,通过 wx.login 接口获得临时登录凭证 code 后传到开发者服务器调用此接口完成登录流程

    String url = "https://api.weixin.qq.com/sns/jscode2session";
    Map<String, String> param = new HashMap<>();
    param.put("appid", "wxa9632572e61de1c4");
    param.put("secret", "f91816f3831f1b765585e5ab4be8ee94");
    param.put("js_code", code);
    param.put("grant_type", "authorization_code");

    // 发起get请求
    // String wxResult = HttpClientUtil.doGet(url, param);
    // System.out.println(wxResult);
    JSONObject jsonResult = JSONObject.parseObject(HttpClientUtil.doGet(url, param));
    // System.out.println(jsonResult);
    // if (jsonResult.get("openId") != null) System.out.println(jsonResult.get("openId"));
    return CommonReturnType.create(userService.getUser((String) jsonResult.get("openid")));
  }

  /*
   * @Author XuMeiFeng
   * @Description 修改用户信息
   * @Date 17:50 2020/12/
   */
  @ApiOperation("修改用户信息")
  @PostMapping("/updateUer")
  public CommonReturnType updateUer(@RequestBody UserVO userVO) throws BusinessException {
    userService.updateUser(userVO);
    return CommonReturnType.create(null);
  }
}
