package com.lvtu.controller.user;

import com.lvtu.entity.UserCollection;
import com.lvtu.response.CommonReturnType;
import com.lvtu.response.error.BusinessException;
import com.lvtu.service.user.UserCollectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XuMeiFeng
 * @create 2020/11/22 16:29
 * @description
 */
@RestController
@Api(
    value = "UserCollectionController",
    tags = {"攻略收藏模块"})
public class UserCollectionController {
  @Autowired private UserCollectionService userCollectionService;

  /*
   * @Author XuMeiFeng
   * @Description 收藏攻略
   * @Date 16:35 2020/11/22
   */
  @ApiOperation("收藏攻略")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "strategyCollections", value = "攻略当前收藏数", required = true),
    @ApiImplicitParam(name = "strategyId", value = "攻略ID", required = true),
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true)
  })
  @PostMapping("/collectionStrategy")
  public CommonReturnType collectionStrategy(
      @RequestParam("strategyCollections") Integer strategyCollections,
      @RequestParam("strategyId") Integer strategyId,
      @RequestParam("userId") Integer userId)
      throws BusinessException {
    UserCollection userCollection = new UserCollection();
    userCollection.setStrategyId(strategyId);
    userCollection.setUserId(userId);
    userCollectionService.collectionStrategy(strategyCollections, userCollection);
    return CommonReturnType.create(null);
  }

  /*
   * @Author XuMeiFeng
   * @Description 取消收藏
   * @Date 16:44 2020/11/22
   */
  @ApiOperation(value = "取消收藏", notes = "strategyCollections为攻略当前收藏数")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "strategyCollections", value = "攻略当前收藏数", required = true),
    @ApiImplicitParam(name = "collectionId", value = "收藏ID", required = true),
    @ApiImplicitParam(name = "strategyId", value = "攻略ID", required = true)
  })
  @PostMapping("/cancelCollection")
  public CommonReturnType cancelCollection(
      @RequestParam("strategyCollections") Integer strategyCollections,
      @RequestParam("collectionId") Integer collectionId,
      @RequestParam("strategyId") Integer strategyId)
      throws BusinessException {
    UserCollection userCollection = new UserCollection();
    userCollection.setStrategyId(strategyId);
    userCollection.setCollectionId(collectionId);
    userCollectionService.cancelCollection(strategyCollections, userCollection);
    return CommonReturnType.create(null);
  }
}
