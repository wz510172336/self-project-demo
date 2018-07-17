package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.commons.pojo.DataGirdResult;
import com.taotao.commons.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

import com.taotao.service.ItemService;

@Controller
public class ItemController {

	@Autowired
private ItemService itemService;


  @RequestMapping("/item/{itemId}")
  @ResponseBody
  public TbItem getTbItemById(@PathVariable long itemId){
	  TbItem item= itemService.getTbItemById(itemId);
	  return item;
  }

  @RequestMapping("/item/list")
  @ResponseBody
  public DataGirdResult getDataGridResult(Integer page, Integer rows){
	  DataGirdResult result= itemService.getDataGridResult(page,rows);
	  return result;
  } 
@RequestMapping(value="/item/save",method=RequestMethod.POST)  
@ResponseBody
public TaotaoResult addItem(TbItem item,String desc){
	TaotaoResult taotaoResult =itemService.addItem(item, desc);
	return taotaoResult;
}
  

}
