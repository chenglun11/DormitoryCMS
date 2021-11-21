package com.lchnan.dormitory.utils;

import java.util.HashMap;
import java.util.Map;

public class Constant {

	//用户类型
	public static Map<Integer, String> typeString = new HashMap<>();


	static {
		typeString.put(0, "管理员");
		typeString.put(1, "宿管员");
	}

}


