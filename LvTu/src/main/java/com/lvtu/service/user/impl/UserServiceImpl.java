package com.lvtu.service.user.impl;

import com.lvtu.domain.VO.UserVO;
import com.lvtu.entity.User;
import com.lvtu.mapper.UserMapper;
import com.lvtu.response.error.BusinessException;
import com.lvtu.response.error.EmBusinessError;
import com.lvtu.service.user.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author XuMeiFeng
 * @create 2020/11/22 21:58
 * @description
 */
@Service
public class UserServiceImpl implements UserService {
  @Autowired private UserMapper userMapper;

  @Override
  public UserVO getUser(String openId) throws BusinessException {
    if (openId != null) {
      User user;
      try {
        user = userMapper.getUser(openId);
      } catch (Exception e) {
        user = null;
      }
      if (user == null) {
        user = new User();
        user.setOpenId(openId);
        user.setCreateTime(new Date());
        userMapper.insertSelective(user);
        user = userMapper.getUser(openId);
      }
      UserVO userVO = new UserVO();
      BeanUtils.copyProperties(user, userVO);
      return userVO;
    } else {
      throw new BusinessException(EmBusinessError.DEFAULT_ERROR, "登录失败");
    }
  }

  @Override
  public void updateUser(UserVO userVO) {
    User user = new User();
    BeanUtils.copyProperties(userVO, user);
    userMapper.updateByPrimaryKeySelective(user);
  }
}
