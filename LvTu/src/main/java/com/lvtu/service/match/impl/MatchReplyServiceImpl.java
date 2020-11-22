package com.lvtu.service.match.impl;

import com.lvtu.entity.MatReply;
import com.lvtu.mapper.MatReplyMapper;
import com.lvtu.service.match.MatchReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author XuMeiFeng
 * @create 2020/11/22 21:09
 * @description
 */
@Service
public class MatchReplyServiceImpl implements MatchReplyService {
  @Autowired private MatReplyMapper matReplyMapper;

  @Override
  public void commitReply(MatReply matReply) {
    matReply.setCreateTime(new Date());
    matReplyMapper.insertSelective(matReply);
  }

  @Override
  public void deleteReply(int matReplyId) {
    matReplyMapper.deleteByPrimaryKey(matReplyId);
  }

  @Override
  public List<MatReply> getReplyList(int id, int flag) {
    Map<String, Integer> map = new LinkedHashMap<>();
    map.put("id", id);
    map.put("flag", flag);
    List<MatReply> matReplyList = matReplyMapper.getReplyList(map);
    return matReplyList;
  }
}
