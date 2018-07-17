package com.taotao.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.util.IdUtil;
import com.taotao.commons.pojo.DataGirdResult;
import com.taotao.commons.pojo.TaotaoResult;
import com.taotao.mapper.*;
import com.taotao.pojo.*;


     @Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper itemMapper;
    @Autowired
    private TbItemDescMapper itemDescMapper;
	
    @Override
	public TbItem getTbItemById(long itemId) {
		
		TbItemExample example=new TbItemExample();
		//创建查询条件
		com.taotao.pojo.TbItemExample.Criteria criteria=example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list=itemMapper.selectByExample(example);
		TbItem tbitem=null;
		if(list!=null&&list.size()>0){
			tbitem=list.get(0);
			
		}
		
		return tbitem;
	}

	@Override
	public DataGirdResult getDataGridResult(int page, int rows) {
			PageHelper.startPage(page, rows);
		TbItemExample example=new TbItemExample();		
		List<TbItem> list=itemMapper.selectByExample(example);
		PageInfo<TbItem> pageInfo=new PageInfo<>(list);
		DataGirdResult dataGirdResult=new DataGirdResult();
		dataGirdResult.setRows(list);
		dataGirdResult.setTotal(pageInfo.getTotal());
	
		
		return dataGirdResult;
	}

	@Override
	public TaotaoResult addItem(TbItem item, String desc) {
	  
		long id=IdUtil.getIdUtil();
		item.setId(id);
		Date date=new Date();
		item.setCreated(date);
		item.setUpdated(date);
		item.setStatus((byte) 1);
		itemMapper.insert(item);
		TbItemDesc tbItemdesc=new TbItemDesc();
		tbItemdesc.setItemId(id);
		tbItemdesc.setCreated(date);
		tbItemdesc.setUpdated(date);
		tbItemdesc.setItemDesc(desc);	
		itemDescMapper.insert(tbItemdesc);
		return TaotaoResult.ok();
		
	}

}
