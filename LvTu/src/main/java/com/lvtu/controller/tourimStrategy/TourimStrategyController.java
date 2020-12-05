package com.lvtu.controller.tourimStrategy;

import com.lvtu.domain.VO.TourimStrategyListVO;
import com.lvtu.domain.VO.TourimStrategyVO;
import com.lvtu.entity.TourimStrategy;
import com.lvtu.response.CommonReturnType;
import com.lvtu.response.error.BusinessException;
import com.lvtu.service.tourimStrategy.TourimStrategyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author XuMeiFeng
 * @create 2020/11/20 15:15
 * @description
 */
@RestController
@Api(
    value = "TourimStrategyController",
    tags = {"攻略模块"})
public class TourimStrategyController {
  @Autowired private TourimStrategyService tourimStrategyService;

  /*
   * @Author XuMeiFeng
   * @Description 发布攻略
   * @Date 15:18 2020/11/20
   */
  @ApiOperation("发布攻略")
  @PostMapping("/releaseStrategy")
  public CommonReturnType releaseStrategy(@RequestBody TourimStrategy tourimStrategy)
      throws BusinessException {
    tourimStrategyService.releaseStrategy(tourimStrategy);
    return CommonReturnType.create(null);
  }
  /*
   * @Author XuMeiFeng
   * @Description 修改攻略
   * @Date 16:20 2020/11/20
   */
  @ApiOperation("修改攻略")
  @PostMapping("/updateStrategy")
  public CommonReturnType updateStrategy(@RequestBody TourimStrategy tourimStrategy)
      throws BusinessException {
    tourimStrategyService.updateStrategy(tourimStrategy);
    return CommonReturnType.create(null);
  }

  /*
   * @Author XuMeiFeng
   * @Description 删除攻略
   * @Date 16:21 2020/11/20
   */
  @ApiOperation("删除攻略(可批量删除)")
  @PostMapping("/deleteStrategy")
  public CommonReturnType deleteStrategy(
      @RequestParam(name = "strategyIds") List<Integer> strategyIds) throws BusinessException {
    tourimStrategyService.deleteStrategy(strategyIds);
    return CommonReturnType.create(null);
  }

  /*
   * @Author XuMeiFeng
   * @Description 隐藏攻略
   * @Date 16:24 2020/11/20
   */
  @ApiOperation("隐藏攻略")
  @ApiImplicitParam(name = "strategyId", value = "攻略ID", required = true)
  @PostMapping("/hideStrategy")
  public CommonReturnType hideStrategy(@RequestParam(name = "strategyId") Integer strategyId)
      throws BusinessException {
    tourimStrategyService.hideStrategy(strategyId);
    return CommonReturnType.create(null);
  }
  /*
   * @Author XuMeiFeng
   * @Description 显示攻略
   * @Date 16:39 2020/11/20
   */
  @ApiOperation("显示攻略")
  @ApiImplicitParam(name = "strategyId", value = "攻略ID", required = true)
  @PostMapping("/showStrategy")
  public CommonReturnType showStrategy(@RequestParam(name = "strategyId") Integer strategyId)
      throws BusinessException {
    tourimStrategyService.showStrategy(strategyId);
    return CommonReturnType.create(null);
  }

  /*
   * @Author XuMeiFeng
   * @Description 获取攻略列表(依据所在城市)
   * @Date 16:41 2020/11/20
   */
  @ApiOperation("获取攻略列表(依据所在城市)")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "city", value = "城市名称", required = true),
    @ApiImplicitParam(name = "currentPage", value = "当前页", required = true),
    @ApiImplicitParam(name = "pageSize", value = "每页的条数", required = true)
  })
  @GetMapping("/getStrategyListByAddress")
  public CommonReturnType getStrategyListByAddress(
      @RequestParam(name = "city") String city,
      @RequestParam(name = "currentPage") Integer currentPage,
      @RequestParam(name = "pageSize") Integer pageSize)
      throws BusinessException {
    return CommonReturnType.create(
        tourimStrategyService.getStrategyListByAddress(city, currentPage, pageSize));
  }

  /*
   * @Author XuMeiFeng
   * @Description  获取攻略列表(用户个人发布)
   * @Date 17:11 2020/11/20
   */
  @ApiOperation("获取攻略列表(用户个人发布)")
  @ApiImplicitParam(name = "userId", value = "用户ID", required = true)
  @GetMapping("/getStrategyListOfUserRelease")
  public CommonReturnType getStrategyListOfUserRelease(
      @RequestParam(name = "userId") Integer userId) throws BusinessException {
    List<TourimStrategyListVO> data = tourimStrategyService.getStrategyListOfUserRelease(userId);
    return CommonReturnType.create(data);
  }

  /*
   * @Author XuMeiFeng
   * @Description  获取攻略列表(用户个人收藏)
   * @Date 17:20 2020/11/20
   */
  @ApiOperation("获取攻略列表(用户个人收藏)")
  @ApiImplicitParam(name = "userId", value = "用户ID", required = true)
  @GetMapping("/getStrategyListOfUserCollection")
  public CommonReturnType getStrategyListOfUserCollection(
      @RequestParam(name = "userId") Integer userId) throws BusinessException {
    List<TourimStrategyListVO> data = tourimStrategyService.getStrategyListOfUserCollection(userId);
    return CommonReturnType.create(data);
  }

  /*
   * @Author XuMeiFeng
   * @Description 获取攻略列表(排行榜：前15)
   * @Date 17:28 2020/11/20
   */
  @ApiOperation("获取攻略列表(排行榜：前15)")
  @ApiImplicitParam(name = "city", value = "城市名称", required = true)
  @GetMapping("/getStrategyHotList")
  public CommonReturnType getStrategyHotList(@RequestParam(name = "city") String city)
      throws BusinessException {
    return CommonReturnType.create(tourimStrategyService.getStrategyListByAddress(city, 1, 15));
  }

  /*
   * @Author XuMeiFeng
   * @Description 获取攻略详细信息
   * @Date 19:10 2020/11/20
   */
  @ApiOperation("获取攻略详细信息")
  @ApiImplicitParam(name = "strategyId", value = "攻略ID", required = true)
  @GetMapping("/getStrategyInfo")
  public CommonReturnType getStrategyInfo(@RequestParam(name = "strategyId") Integer strategyId)
      throws BusinessException {
    TourimStrategyVO data = tourimStrategyService.getStrategyInfo(strategyId);
    return CommonReturnType.create(data);
  }

  /*
   * @Author XuMeiFeng
   * @Description 分享攻略
   * @Date 17:12 2020/11/22
   */
  @ApiOperation("分享攻略")
  @PostMapping("/shareStrategy")
  public CommonReturnType shareStrategy(@RequestBody TourimStrategy tourimStrategy)
      throws BusinessException {
    tourimStrategyService.shareStrategy(tourimStrategy);
    return CommonReturnType.create(null);
  }
}
