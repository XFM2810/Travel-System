package com.lvtu.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Mat {
  private Integer matId;

  private Integer userId;

  private String matName;

  private String matContent;

  private String matPlace;

  private Date createTime;

  private Date updateTime;
}
