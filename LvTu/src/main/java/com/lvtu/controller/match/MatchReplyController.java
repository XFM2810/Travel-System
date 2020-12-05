package com.lvtu.controller.match;

import com.lvtu.entity.MatReply;
import com.lvtu.response.CommonReturnType;
import com.lvtu.response.error.BusinessException;
import com.lvtu.service.match.MatchReplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author XuMeiFeng
 * @create 2020/11/22 21:08
 * @description
 */
@RestController
@Api(
    value = "MatchReplyController",
    tags = {"结伴游申请模块"})
public class MatchReplyController {
  @Autowired private MatchReplyService matchReplyService;
  /*
   * @Author XuMeiFeng
   * @Description 发出申请
   * @Date 21:10 2020/11/22
   */
  @ApiOperation("发出申请")
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
  @ApiOperation("删除申请")
  @ApiImplicitParam(name = "matReplyId", value = "结伴游申请ID", required = true)
  @PostMapping("/deleteReply")
  public CommonReturnType deleteReply(@RequestParam("matReplyId") Integer matReplyId)
      throws BusinessException {
    matchReplyService.deleteReply(matReplyId);
    return CommonReturnType.create(null);
  }

  /*
   * @Author XuMeiFeng
   * @Description 获取申请列表(我发出的)
   * @Date 21:16 2020/11/22
   */
  @ApiOperation("获取申请列表(我发出的)")
  @ApiImplicitParam(name = "userId", value = "用户ID", required = true)
  @GetMapping("/getReplyListOfUser")
  public CommonReturnType getReplyListOfUser(@RequestParam("userId") Integer userId)
      throws BusinessException {
    List<MatReply> matReplyList = matchReplyService.getReplyList(userId, 0);
    return CommonReturnType.create(matReplyList);
  }
  /*
   * @Author XuMeiFeng
   * @Description 获取申请列表(当前攻略已通过)
   * @Date 21:35 2020/11/22
   */
  @ApiOperation("获取申请列表(当前攻略已通过)")
  @ApiImplicitParam(name = "matId", value = "结伴游ID", required = true)
  @GetMapping("/getReplyListPassed")
  public CommonReturnType getReplyListPassed(@RequestParam("matId") Integer matId)
      throws BusinessException {
    List<MatReply> matReplyList = matchReplyService.getReplyList(matId, 1);
    return CommonReturnType.create(matReplyList);
  }

  /*
   * @Author XuMeiFeng
   * @Description 获取申请列表(当前攻略未处理)
   * @Date 21:42 2020/11/22
   */
  @ApiOperation("获取申请列表(当前攻略未处理)")
  @ApiImplicitParam(name = "matId", value = "结伴游ID", required = true)
  @GetMapping("/getReplyListUntreated")
  public CommonReturnType getReplyListUntreated(@RequestParam("matId") Integer matId)
      throws BusinessException {
    List<MatReply> matReplyList = matchReplyService.getReplyList(matId, 2);
    return CommonReturnType.create(matReplyList);
  }

  /*
   * @Author XuMeiFeng
   * @Description 同意申请
   * @Date 17:23 2020/12/5
   */
  @ApiOperation("同意申请")
  @ApiImplicitParam(name = "replyId", value = "申请ID", required = true)
  @PostMapping("/passReply")
  public CommonReturnType passReply(@RequestParam("replyId") Integer replyId)
      throws BusinessException {
    matchReplyService.updateReplyStatus(replyId, 1);
    return CommonReturnType.create(null);
  }

  /*
   * @Author XuMeiFeng
   * @Description 拒绝申请
   * @Date 17:23 2020/12/5
   */
  @ApiOperation("拒绝申请")
  @ApiImplicitParam(name = "replyId", value = "申请ID", required = true)
  @PostMapping("/rejectReply")
  public CommonReturnType rejectReply(@RequestParam("replyId") Integer replyId)
      throws BusinessException {
    matchReplyService.updateReplyStatus(replyId, 2);
    return CommonReturnType.create(null);
  }
}
