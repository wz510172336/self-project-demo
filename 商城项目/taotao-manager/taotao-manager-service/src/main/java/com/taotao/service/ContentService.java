package com.taotao.service;

import java.util.List;

import com.taotao.commons.pojo.DataGirdResult;
import com.taotao.commons.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

public interface ContentService {
DataGirdResult getContentList(Integer page,Integer rows);
TaotaoResult insertContent(TbContent tbcontent);
}
