package com.managesite.tools;

import net.sf.json.JSONObject;
public class JsonTools {

	public JsonTools() {
		// TODO Auto-generated constructor stub
	}
//ת����Ϊjson��ʽ
public static String createJsonString(String key,Object value){
	JSONObject jsonObject=new JSONObject();
	jsonObject.put(key, value);
	return jsonObject.toString();
}
}
