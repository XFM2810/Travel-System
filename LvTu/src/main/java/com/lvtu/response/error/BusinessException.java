package com.lvtu.response.error;

/** @Author XuMeiFeng @Create 2020/11/5 13:09 @Description */
public class BusinessException extends Exception {
  private CommonError commonError;

  // 直接接收EmBusinessError的传参用于构造业务异常
  public BusinessException(CommonError commonError) {
    super(); // 千万注意
    this.commonError = commonError;
  }

  // 接收自定义errMsg的方式构造业务异常
  public BusinessException(CommonError commonError, String errMsg) {
    super();
    this.commonError = commonError;
    this.commonError.setErrMsg(errMsg);
  }

  public int getErrCode() {
    return this.commonError.getErrCode();
  }

  public String getErrMsg() {
    return this.commonError.getErrMsg();
  }
}
