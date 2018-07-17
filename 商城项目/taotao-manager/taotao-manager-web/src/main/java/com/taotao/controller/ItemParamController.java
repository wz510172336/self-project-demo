package com.taotao.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.util.IdUtil;
import com.taotao.commons.pojo.DataGirdResult;
import com.taotao.commons.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;
import com.taotao.service.ItemParamService;

@Controller
@RequestMapping("/item/param")
public class ItemParamController {
	@Autowired 
	private ItemParamService itemParamService;
	
	@RequestMapping("/list")
	@ResponseBody
	public DataGirdResult getParamList(@RequestParam(value="page",defaultValue="1")Integer page,@RequestParam(value="row",defaultValue="10")Integer row){
	
		return itemParamService.selectTbItemParamList(page,row);
	}
	
	@RequestMapping("/query/itemcatid/{cid}")
	@ResponseBody
	public TaotaoResult getItemCatBycid(@PathVariable Long cid){
		TaotaoResult taotaoResult=itemParamService.getItemParamResult(cid);
		return taotaoResult;
	}
	//保存模板
	@RequestMapping("/save/{cid}")
	@ResponseBody
	public TaotaoResult insertItemParam(String paramData,@PathVariable Long cid){
		
		TaotaoResult taotaoResult=itemParamService.insertItemParam( paramData,cid);
		return taotaoResult;
	}
	
}
