package com.lvtu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class User {
  private Integer userId;

  private String userName;

  private String openId;

  private String password;

  private String telephone;

  private String description;

  private String icon;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTime;
}
