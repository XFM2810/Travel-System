package com.lvtu.response;

/** @Author XuMeiFeng @Create 2020/11/5 13:08 @Description */
public class CommonReturnType {
  // 响应数据的状态码
  private int code;
  // 响应数据的提示信息
  private String msg;
  // 响应数据
  private Object data;

  // 请求处理无异常时调用
  public static CommonReturnType create(Object result) {
    return CommonReturnType.create(200, "成功", result);
  }
  // 请求处理发生异常时调用
  public static CommonReturnType create(int errCode, String errMsg) {
    return CommonReturnType.create(errCode, errMsg, "");
  }

  public static CommonReturnType create(int status, String msg, Object result) {
    CommonReturnType type = new CommonReturnType();
    type.setCode(status);
    type.setData(result);
    type.setMsg(msg);
    return type;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
}
