package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.commons.pojo.EasyuiDataCatResult;
import com.taotao.pojo.TbContentCategory;
import com.taotao.service.ContentCategorySerivce;

@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {
@Autowired
private ContentCategorySerivce contentCategorySerivce;
@RequestMapping("/list")
@ResponseBody
public List<EasyuiDataCatResult> getResult(@RequestParam(value="id",defaultValue="0")long parentid){
	 return contentCategorySerivce.getContentCategory(parentid);
}
}
