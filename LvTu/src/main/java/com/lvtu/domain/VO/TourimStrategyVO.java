package com.lvtu.domain.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
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

  private Object strategyWay;

  private String strategyPicture;

  private Integer isShow;

  private String city;

  private Integer strategyCollections;

  private Integer strategyShares;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;
}
