package com.lvtu.domain.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author XuMeiFeng
 * @create 2020/11/20 16:55
 * @description
 */
@Data
public class TourimStrategyListVO {
  private Integer strategyId;

  private String strategyName;

  private String strategyContent;

  private Integer strategyCollections;

  private Integer strategyShares;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;
}
