package com.lvtu.service.match;

import com.lvtu.domain.DTO.MatAndUser;
import com.lvtu.entity.MatReply;

import java.util.List;

/**
 * @author XuMeiFeng
 * @create 2020/11/22 21:08
 * @description
 */
public interface MatchReplyService {
  public void commitReply(MatReply matReply);

  public void deleteReply(int matReplyId);

  public List<MatAndUser> getReplyList(int id, int flag);

  public void updateReplyStatus(int replyId, int flag);
}
