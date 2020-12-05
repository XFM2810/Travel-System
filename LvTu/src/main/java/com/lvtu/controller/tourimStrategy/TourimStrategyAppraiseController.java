package com.lvtu.controller.tourimStrategy;

import com.lvtu.entity.TourimStrategyAppraise;
import com.lvtu.response.CommonReturnType;
import com.lvtu.response.error.BusinessException;
import com.lvtu.service.tourimStrategy.TourimStrategyAppraiseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author XuMeiFeng
 * @create 2020/11/21 22:04
 * @description 攻略评价
 */
@RestController
@Api(
    value = "TourimStrategyAppraiseController",
    tags = {"攻略评价模块"})
public class TourimStrategyAppraiseController {
  @Autowired private TourimStrategyAppraiseService tourimStrategyAppraiseService;

  /*
   * @Author XuMeiFeng
   * @Description 获取攻略评论
   * @Date 22:09 2020/11/21
   */
  @ApiOperation("获取攻略评论")
  @ApiImplicitParam(name = "strategyId", value = "攻略ID", required = true)
  @PostMapping("/getStrategyAppraiseListOfStrategy")
  public CommonReturnType getStrategyAppraiseListOfStrategy(
      @RequestParam(name = "strategyId") Integer strategyId) throws BusinessException {
    List<TourimStrategyAppraise> data =
        tourimStrategyAppraiseService.getStrategyAppraiseList(strategyId, 0);
    return CommonReturnType.create(data);
  }
  /*
   * @Author XuMeiFeng
   * @Description 获取我的评论
   * @Date 22:28 2020/11/21
   */
  @ApiOperation("获取我的评论")
  @ApiImplicitParam(name = "userId", value = "用户ID", required = true)
  @PostMapping("/getStrategyAppraiseListOfUser")
  public CommonReturnType getStrategyAppraiseListOfUser(
      @RequestParam(name = "userId") Integer userId) throws BusinessException {
    List<TourimStrategyAppraise> data =
        tourimStrategyAppraiseService.getStrategyAppraiseList(userId, 1);
    return CommonReturnType.create(data);
  }
  /*
   * @Author XuMeiFeng
   * @Description 发布评价
   * @Date 22:30 2020/11/21
   */
  @ApiOperation("发布评价")
  @PostMapping("/releaseStrategyAppraise")
  public CommonReturnType releaseStrategyAppraise(
      @RequestBody TourimStrategyAppraise tourimStrategyAppraise) throws BusinessException {
    tourimStrategyAppraiseService.releaseStrategyAppraiseList(tourimStrategyAppraise);
    return CommonReturnType.create(null);
  }

  /*
   * @Author XuMeiFeng
   * @Description 删除评论
   * @Date 22:38 2020/11/21
   */
  @ApiOperation("删除评论")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true),
    @ApiImplicitParam(name = "appraiseId", value = "评价ID", required = true),
  })
  @PostMapping("/deleteStrategyAppraise")
  public CommonReturnType deleteStrategyAppraise(
      @RequestParam(name = "userId") Integer userId,
      @RequestParam(name = "appraiseId") Integer appraiseId)
      throws BusinessException {
    tourimStrategyAppraiseService.deleteStrategyAppraise(userId, appraiseId);
    return CommonReturnType.create(null);
  }
}
