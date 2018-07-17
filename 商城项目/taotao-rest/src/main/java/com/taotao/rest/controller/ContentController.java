package com.taotao.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.commons.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.rest.service.ContentService;

@Controller
public class ContentController {
	@Autowired
	private ContentService contentService;

	@RequestMapping("/content/{categoryid}")
	@ResponseBody
	public TaotaoResult getResult(@PathVariable Long categoryid) {
		try {
			List<TbContent> result = contentService.getContentList(categoryid);
			return TaotaoResult.ok(result);
		
		} catch (Exception e) {
			e.getStackTrace();
			return TaotaoResult.build(500, e.getMessage());
		}
		
	}
	@RequestMapping("/content/snyc/{categoryid}")
	@ResponseBody
	public TaotaoResult snycContent(@PathVariable Long categoryid){
		TaotaoResult taotaoResult=contentService.snycContent(categoryid);
		return taotaoResult;
	}
	
}
