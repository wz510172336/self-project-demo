package com.taotao.common.util;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taotao.commons.pojo.TaotaoResult;

public class JsonUtils {
	private static final ObjectMapper objectMapper = new ObjectMapper();

	public static String ObjectToJson(Object object) throws JsonProcessingException {

		return objectMapper.writeValueAsString(object);

	}

	public static String ListToJson(List<?> list) {
		String s = JSON.toJSONString(list);
		return s;
	}
	

}
