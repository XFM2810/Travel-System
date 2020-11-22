package com.lvtu.controller;

import com.lvtu.response.CommonReturnType;
import com.lvtu.response.error.BusinessException;
import com.lvtu.response.error.EmBusinessError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/** @Author XuMeiFeng @Create 2020/11/5 13:05 @Description */
public class BaseController {
  // 定义exceptionhandler解决未被controller层吸收的exception
  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody // 返回ResponseBody
  public Object handlerException(HttpServletRequest request, Exception ex) {
    if (ex instanceof BusinessException) {
      BusinessException businessException = (BusinessException) ex; // 对Exception执行类型强转换
      return CommonReturnType.create(businessException.getErrCode(), businessException.getErrMsg());
    } else {
      // 返回自定义异常以外的异常
      return CommonReturnType.create(
          EmBusinessError.UNKNOWN_ERROR.getErrCode(), EmBusinessError.UNKNOWN_ERROR.getErrMsg());
    }
  }
}
