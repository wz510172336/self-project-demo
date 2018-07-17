package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.commons.pojo.EasyuiDataCatResult;
import com.taotao.service.CatService;

@Controller
@RequestMapping("item/cat")
public class ItemCatController {
@Autowired
private CatService catService;

@RequestMapping("/list")
@ResponseBody
public List<EasyuiDataCatResult> getCat(@RequestParam(value="id",defaultValue="0") Long parentId){
	List<EasyuiDataCatResult> list=catService.getCatResult(parentId);
	return list;
}
}
