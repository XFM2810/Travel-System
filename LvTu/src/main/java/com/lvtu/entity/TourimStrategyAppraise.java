package com.lvtu.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TourimStrategyAppraise {
  private Integer appraiseId;

  private Integer userId;

  private Integer strategyId;

  private String content;

  private Date createTime;
}
