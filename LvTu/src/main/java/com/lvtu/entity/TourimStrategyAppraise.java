package com.lvtu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class TourimStrategyAppraise {
  private Integer appraiseId;

  private Integer userId;

  private Integer strategyId;

  private String content;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;
}
