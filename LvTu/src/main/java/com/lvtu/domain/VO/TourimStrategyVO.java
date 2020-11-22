package com.lvtu.domain.VO;

import lombok.Data;

import java.util.Date;

/**
 * @author XuMeiFeng
 * @create 2020/11/20 19:11
 * @description
 */
@Data
public class TourimStrategyVO {
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
}
