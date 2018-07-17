package com.taotao.rest.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.json.JSONUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.taotao.common.util.JsonUtils;
import com.taotao.rest.pojo.ItemCatResult;
import com.taotao.rest.service.ItemCatService;

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
	@Autowired
	private ItemCatService itemCatService;

	@RequestMapping(value="/list",produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	@ResponseBody
	public String getResult(String callback) throws JsonProcessingException {
		ItemCatResult itemCatResult = itemCatService.getItemCatResult();
		
		if(StringUtils.isBlank(callback)){
		String s=JsonUtils.ObjectToJson(itemCatResult);
	
		return s;
		}
		String json=JsonUtils.ObjectToJson(itemCatResult);
		return callback+"("+json+");";
		
	}
}
