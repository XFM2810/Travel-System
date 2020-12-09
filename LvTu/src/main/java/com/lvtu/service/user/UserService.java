package com.lvtu.service.user;

import com.lvtu.domain.VO.UserVO;
import com.lvtu.response.error.BusinessException;

/**
 * @author XuMeiFeng
 * @create 2020/11/22 21:58
 * @description
 */
public interface UserService {
  public UserVO getUser(String openId) throws BusinessException;

  public void updateUser(UserVO userVO);
}
