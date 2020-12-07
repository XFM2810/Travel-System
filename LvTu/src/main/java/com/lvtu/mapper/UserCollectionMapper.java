package com.lvtu.mapper;

import com.lvtu.entity.UserCollection;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserCollectionMapper {
  int deleteByPrimaryKey(Integer collectionId);

  int insert(UserCollection record);

  int insertSelective(UserCollection record);

  UserCollection selectByPrimaryKey(Integer collectionId);

  int updateByPrimaryKeySelective(UserCollection record);

  int updateByPrimaryKey(UserCollection record);

  int getCollectionId(Map map);
}
