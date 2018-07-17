package com.taotao.service;

import java.util.List;

import com.taotao.commons.pojo.DataGirdResult;
import com.taotao.commons.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;

public interface ItemParamService {
	
public DataGirdResult selectTbItemParamList(Integer page,Integer row); 
       TaotaoResult getItemParamResult(Long cid);
       TaotaoResult insertItemParam(String paramData,Long cid);
       
}
