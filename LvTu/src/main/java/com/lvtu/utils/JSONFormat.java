package com.lvtu.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author XuMeiFeng
 * @create 2020/12/4 12:56
 * @description
 */
public class JSONFormat {
  public static String jsonToString(Object json) {
    return JSONObject.toJSON(json).toString();
  }

  public static JSONArray stringToJson(Object string) {
    return JSONObject.parseArray((String) string);
  }
}
