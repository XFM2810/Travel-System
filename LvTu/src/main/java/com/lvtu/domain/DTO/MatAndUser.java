package com.lvtu.domain.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author XuMeiFeng
 * @create 2020/12/9 11:09
 * @description
 */
@Data
public class MatAndUser {
  private Integer replyId;

  private Integer matId;

  private Integer userId;

  private String icon;

  private String replyContent;

  private Integer status;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;
}
