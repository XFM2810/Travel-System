package com.lvtu.controller.user;

import com.lvtu.entity.UserCollection;
import com.lvtu.response.CommonReturnType;
import com.lvtu.response.error.BusinessException;
import com.lvtu.service.user.UserCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XuMeiFeng
 * @create 2020/11/22 16:29
 * @description
 */
@RestController
public class UserCollectionController {
  @Autowired private UserCollectionService userCollectionService;

  /*
   * @Author XuMeiFeng
   * @Description 收藏攻略
   * @Date 16:35 2020/11/22
   */
  @PostMapping("/collectionStrategy")
  public CommonReturnType collectionStrategy(
      @RequestParam("strategyCollections") int strategyCollections,
      @RequestBody UserCollection userCollection)
      throws BusinessException {
    userCollectionService.collectionStrategy(strategyCollections, userCollection);
    return CommonReturnType.create(null);
  }

  /*
   * @Author XuMeiFeng
   * @Description 取消收藏
   * @Date 16:44 2020/11/22
   */
  @PostMapping("/cancelCollection")
  public CommonReturnType cancelCollection(
      @RequestParam("strategyCollections") int strategyCollections,
      @RequestBody UserCollection userCollection)
      throws BusinessException {
    userCollectionService.cancelCollection(strategyCollections, userCollection);
    return CommonReturnType.create(null);
  }
}
