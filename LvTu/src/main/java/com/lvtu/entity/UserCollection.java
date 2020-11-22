package com.lvtu.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserCollection {
  private Integer collectionId;

  private Integer userId;

  private Integer strategyId;

  private Date createTime;
}
