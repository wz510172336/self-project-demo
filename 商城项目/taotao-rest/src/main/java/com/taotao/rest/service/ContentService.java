package com.taotao.rest.service;

import java.util.List;

import com.taotao.commons.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

public interface ContentService {
List<TbContent> getContentList(Long categoryId);
TaotaoResult snycContent(Long categoryId);
	

}
