package com.taotao.portal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.taotao.common.util.HttpClientUtils;
import com.taotao.common.util.JsonUtils;
import com.taotao.commons.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.portal.pojo.IndexAd1;

@Service
public class ContentServiceImpl implements ContentService {
	@Value("${base_rest_url}")
	private String base_rest_url;
	@Value("${rest_Content_url}")
	private String rest_Content_url;
	@Value("${rest_content_ad1}")
	private String rest_content_ad1;

	@Override
	public String getList() throws JsonProcessingException {
	String json=HttpClientUtils.doGet(base_rest_url+rest_Content_url+rest_content_ad1);
		TaotaoResult taotaoResult=TaotaoResult.formatToList(json, TbContent.class);
		@SuppressWarnings("unchecked")
		List<TbContent> list=(List<TbContent>)taotaoResult.getData();
		List<IndexAd1> ilist=new ArrayList<>();
		for(TbContent t:list){
			IndexAd1 indexAd1=new IndexAd1();
			indexAd1.setAlt(t.getSubTitle());
			indexAd1.setHref(t.getUrl());
			
			indexAd1.setHeight(240);
			indexAd1.setWidth(670);
			indexAd1.setSrc(t.getPic());
			
			indexAd1.setHeightB(240);
			indexAd1.setWidthB(500);
	        indexAd1.setSrcB(t.getPic2());
			
			ilist.add(indexAd1);
		}
	return JsonUtils.ListToJson(ilist);
	}

}
