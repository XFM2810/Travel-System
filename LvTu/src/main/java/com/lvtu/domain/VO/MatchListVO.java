package com.lvtu.domain.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author XuMeiFeng
 * @create 2020/11/22 20:24
 * @description
 */
@Data
public class MatchListVO {
  private Integer matId;

  private Integer userId;

  private String matName;

  private String matPlace;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;
}
