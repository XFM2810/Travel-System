package com.lvtu.entity;

import lombok.Data;

import java.util.Date;

@Data
public class MatReply {
  private Integer replyId;

  private Integer matId;

  private Integer userId;

  private String replyContent;

  private Date createTime;

  private Integer status;
}
