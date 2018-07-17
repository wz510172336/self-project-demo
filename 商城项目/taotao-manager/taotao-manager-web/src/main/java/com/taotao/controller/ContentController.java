package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.util.HttpClientUtils;
import com.taotao.commons.pojo.DataGirdResult;
import com.taotao.commons.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;

@Controller
@RequestMapping("/content")
public class ContentController {
	@Autowired
	private ContentService contentService;
	@Value("${Rest_url}")
	private  String Rest_url;
	@Value("${Redis_Content_url}")
	private  String Redis_Content_url;

	@RequestMapping("/query/list")
	@ResponseBody
	public DataGirdResult getResult(Integer page, Integer rows) {
		DataGirdResult dataGirdResult = contentService.getContentList(page, rows);
		return dataGirdResult;
	}
	
	@RequestMapping(value="/save")
	@ResponseBody
	public TaotaoResult getResult(TbContent tbcontent){
		TaotaoResult taotaoResult=contentService.insertContent(tbcontent);
		HttpClientUtils.doGet(Rest_url+Redis_Content_url+tbcontent.getCategoryId());
	          return taotaoResult;
		
	}
}
