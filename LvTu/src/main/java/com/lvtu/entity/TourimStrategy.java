package com.lvtu.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TourimStrategy {
  private Integer strategyId;

  private Integer userId;

  private String strategyName;

  private String strategyContent;

  private String strategyWay;

  private String strategyPicture;

  private Integer isShow;

  private String city;

  private Integer strategyCollections;

  private Integer strategyShares;

  private Date createTime;

  private Date updateTime;
}
