package com.lvtu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTime;
}
