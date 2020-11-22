package com.lvtu.response.error;

/** @Author XuMeiFeng @Create 2020/11/5 13:11 @Description */
public enum EmBusinessError implements CommonError {
  // 通用错误类型00001
  // 应以1开头，否则系统默认前n个0为无效值，00002将表示为2
  DEFAULT_ERROR(10000, ""),
  UNKNOWN_ERROR(10001, "An unknown error"),
  UNACCESS_TRANSFORM(10002, "非法转换"),
  // 20000开头商品有关
  GOODS_NOT_EXIST(200001, "商品不存在"),
  // 30000开头订单相关
  ORDER_NOT_EXIST(30001, "不存在该订单的信息"),
  ORDER_SET_FAIL(30002, "订单设置失败"),
  // 40000开头售后相关
  AFTER_STATUS_ERROR(40001, "传入的状态码有误"),
  REFUSE_ACCEPT_ERROR(40000, "同意/拒绝退货失败"),
  AFTER_SALE_CONFIRM_ERROR(40005, "确认收获失败"),
  AFTER_SALE_ORDER_NOT_FOUND(40002, "未传入服务单号");
  private int errCode;
  private String errMsg;

  private EmBusinessError(int errCode, String errMsg) {
    this.errCode = errCode;
    this.errMsg = errMsg;
  }

  @Override
  public int getErrCode() {
    return this.errCode;
  }

  @Override
  public String getErrMsg() {
    return this.errMsg;
  }

  @Override
  public CommonError setErrMsg(String errMsg) {
    // 设置DEFAULT_ERROR(自定义错误)的错误信息
    this.errMsg = errMsg;
    return this;
  }
}
