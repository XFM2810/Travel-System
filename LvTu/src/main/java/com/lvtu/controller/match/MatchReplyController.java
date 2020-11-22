package com.lvtu.controller.match;

import com.lvtu.entity.MatReply;
import com.lvtu.response.CommonReturnType;
import com.lvtu.response.error.BusinessException;
import com.lvtu.service.match.MatchReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author XuMeiFeng
 * @create 2020/11/22 21:08
 * @description
 */
@RestController
public class MatchReplyController {
  @Autowired private MatchReplyService matchReplyService;
  /*
   * @Author XuMeiFeng
   * @Description 发出申请
   * @Date 21:10 2020/11/22
   */
  @PostMapping("/commitReply")
  public CommonReturnType commitReply(@RequestBody MatReply matReply) throws BusinessException {
    matchReplyService.commitReply(matReply);
    return CommonReturnType.create(null);
  }

  /*
   * @Author XuMeiFeng
   * @Description 删除申请
   * @Date 21:14 2020/11/22
   */
  @PostMapping("/deleteReply")
  public CommonReturnType deleteReply(@RequestParam("matReplyId") int matReplyId)
      throws BusinessException {
    matchReplyService.deleteReply(matReplyId);
    return CommonReturnType.create(null);
  }

  /*
   * @Author XuMeiFeng
   * @Description 获取申请列表(我发出的)
   * @Date 21:16 2020/11/22
   */
  @GetMapping("/getReplyListOfUser")
  public CommonReturnType getReplyListOfUser(@RequestParam("uerId") int uerId)
      throws BusinessException {
    List<MatReply> matReplyList = matchReplyService.getReplyList(uerId, 0);
    return CommonReturnType.create(matReplyList);
  }
  /*
   * @Author XuMeiFeng
   * @Description 获取申请列表(当前攻略已通过)
   * @Date 21:35 2020/11/22
   */
  @GetMapping("/getReplyListPassed")
  public CommonReturnType getReplyListPassed(@RequestParam("matId") int matId)
      throws BusinessException {
    List<MatReply> matReplyList = matchReplyService.getReplyList(matId, 1);
    return CommonReturnType.create(matReplyList);
  }

  /*
   * @Author XuMeiFeng
   * @Description 获取申请列表(当前攻略未处理)
   * @Date 21:42 2020/11/22
   */
  @GetMapping("/getReplyListUntreated")
  public CommonReturnType getReplyListUntreated(@RequestParam("matId") int matId)
      throws BusinessException {
    List<MatReply> matReplyList = matchReplyService.getReplyList(matId, 2);
    return CommonReturnType.create(matReplyList);
  }
}
