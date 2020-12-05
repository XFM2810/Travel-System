package com.lvtu.utils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MyPageHelper extends PageHelper {

  public static <E> Map returnPage(List list, List returnList, String listName) {
    PageInfo<E> pageInfo = new PageInfo<>(list);
    Map<String, Object> returnMap = new LinkedHashMap<>();
    returnMap.put(listName, returnList);
    returnMap.put("total", pageInfo.getTotal());
    return returnMap;
  }
}
