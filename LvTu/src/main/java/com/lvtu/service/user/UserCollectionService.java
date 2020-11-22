package com.lvtu.service.user;

import com.lvtu.entity.UserCollection;

/**
 * @author XuMeiFeng
 * @create 2020/11/22 16:30
 * @description
 */
public interface UserCollectionService {
  public void collectionStrategy(int strategyCollections, UserCollection userCollection);

  public void cancelCollection(int strategyCollections, UserCollection userCollection);
}
