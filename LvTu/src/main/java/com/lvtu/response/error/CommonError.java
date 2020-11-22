package com.lvtu.response.error;

/** @Author XuMeiFeng @Create 2020/11/5 13:10 @Description */
public interface CommonError {
  public int getErrCode();

  public String getErrMsg();

  public CommonError setErrMsg(String errMsg);
}
