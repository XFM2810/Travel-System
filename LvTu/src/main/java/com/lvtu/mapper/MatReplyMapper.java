package com.lvtu.mapper;

import com.lvtu.domain.DTO.MatAndUser;
import com.lvtu.entity.MatReply;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MatReplyMapper {
  int deleteByPrimaryKey(Integer replyId);

  int insert(MatReply record);

  int insertSelective(MatReply record);

  MatReply selectByPrimaryKey(Integer replyId);

  int updateByPrimaryKeySelective(MatReply record);

  int updateByPrimaryKey(MatReply record);

  List<MatAndUser> getReplyList(Map<String, Integer> map);
}
