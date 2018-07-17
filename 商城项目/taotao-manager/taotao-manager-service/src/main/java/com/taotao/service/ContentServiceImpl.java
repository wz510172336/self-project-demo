package com.taotao.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.commons.pojo.DataGirdResult;
import com.taotao.commons.pojo.TaotaoResult;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
@Service
public class ContentServiceImpl implements ContentService {
@Autowired
private TbContentMapper tbContentMapper;
	@Override
	public DataGirdResult getContentList(Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
	TbContentExample tbContentExample=new TbContentExample();
	 List<TbContent> clist=tbContentMapper.selectByExample(tbContentExample);
	 PageInfo<TbContent> info =new PageInfo<>(clist);
	 DataGirdResult  dataGirdResult = new DataGirdResult();
	 dataGirdResult.setTotal(info.getTotal());
	 dataGirdResult.setRows(clist);
	 
		return dataGirdResult;
	}
	@Override
	public TaotaoResult insertContent(TbContent tbcontent) {
		tbcontent.setCreated(new Date());
		tbcontent.setUpdated(new Date());
		tbContentMapper.insert(tbcontent);
	
		return TaotaoResult.ok();
	}

}
