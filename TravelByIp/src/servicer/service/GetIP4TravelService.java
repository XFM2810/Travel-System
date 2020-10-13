package servicer.service;

import java.net.URLEncoder;

import org.apache.commons.codec.digest.DigestUtils;

import com.alibaba.fastjson.JSONObject;

import servicer.model.jsonObject.Ad_Info;
import servicer.model.jsonObject.IPResult;
import servicer.model.jsonObject.Result;

public class GetIP4TravelService {

	private static final String key = "D2CBZ-SCNWV-NBCPF-UTDRB-GP3MS-FFFCW";

	private static final String sKey = "WWbTPagyfHanpMxkQqCIIcPU9GVBuc";

	/**
	 * MD5方法
	 * 
	 * @param text 明文
	 * @param key  密钥
	 * @return 密文
	 * @throws Exception
	 */
	private static String md5(String text, String key) throws Exception {
		// 加密后的字符串
		String encodeStr = DigestUtils.md5Hex(text + key);
//		System.out.println("MD5加密后的字符串为:encodeStr=" + encodeStr);
		return encodeStr;
	}


	public static String getIP4Travel(String ip) {

		try {
			//根据IP获取所在城市
			String url = Constant.TENCENT_MAP_URL + Constant.GET_IP;
			String result = "";
			String u = "";
			if (ip != null && !"".equals(ip.trim())) {
				String sig = md5(Constant.GET_IP + "?ip=" + ip + "&key=" + key, sKey);
				u = url + "?ip=" + ip + "&key=" + key + "&sig=" + sig;
			} else {
				String sig = md5(Constant.GET_IP + "?key=" + key, sKey);
				u = url + "?key=" + key + "&sig=" + sig;
			}

			result = HttpURLConnectionHelper.sendRequest(u, "GET");

			System.out.println(u);
			System.out.println(result);
			
			IPResult iPResult = JSONObject.parseObject(result, IPResult.class);
			Result r = iPResult.getResult();
			Ad_Info i = r.getAd_info();
			String city = i.getCity();

//			System.out.println(city);

			//搜索城市景点
			String url1 = Constant.TENCENT_MAP_URL + Constant.SEARCH;

			String _sig = md5(Constant.SEARCH + "?boundary=region(" + city + ",0)&key=" + key + "&keyword=景点", sKey);
			String temp = url1 + "?boundary=region(" + URLEncoder.encode(city, "utf-8") + ",0)&key=" + key + "&keyword="
					+ URLEncoder.encode("景点", "utf-8") + "&sig=" + _sig;
			result = HttpURLConnectionHelper.sendRequest(temp, "GET");
			System.out.println(temp);
			System.out.println(result);
			
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "调用失败！";

	}

}
