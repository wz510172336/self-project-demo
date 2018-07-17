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
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.*;
import com.taotao.pojo.TbItemParamExample.Criteria;



@Service
public class ItemParamServiceImpl implements ItemParamService {
	@Autowired
	private TbItemParamMapper itemParamMapper;

	@Override
	public DataGirdResult selectTbItemParamList(Integer page,Integer row) {
	//设置分页条件
		PageHelper.startPage(page, row);
     // 开始查询
		TbItemParamExample tbItemParamExample=new TbItemParamExample(); 
		List<TbItemParam> paramlist=itemParamMapper.selectByExampleWithBLOBs(tbItemParamExample);
	// 取分页结果  
		DataGirdResult dataGridResult=new DataGirdResult();
	   PageInfo<TbItemParam> pageinfo=new PageInfo<>(paramlist);
	   
	   dataGridResult.setRows(paramlist);
	   dataGridResult.setTotal(pageinfo.getTotal());
	
		return dataGridResult;
	}

	@Override
	public TaotaoResult getItemParamResult(Long cid) {
		TbItemParamExample tbItemParamExample=new TbItemParamExample(); 
		Criteria criteria= tbItemParamExample.createCriteria();
		criteria.andItemCatIdEqualTo(cid);
		List<TbItemParam> list=itemParamMapper.selectByExampleWithBLOBs(tbItemParamExample);
		if(list!=null&&list.size()>0){
			TbItemParam tbItemParam =list.get(0);
			TaotaoResult taotaoResult=new TaotaoResult();
			taotaoResult.setData(tbItemParam);
			return TaotaoResult.ok(tbItemParam);
			
		}
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult insertItemParam(String paramData,Long cid) {
		TbItemParam tbItemParam=new TbItemParam();
		tbItemParam.setCreated(new Date());
		tbItemParam.setId(new IdUtil().getIdUtil());
		tbItemParam.setUpdated(new Date());
		tbItemParam.setItemCatId(cid);
		tbItemParam.setParamData(paramData);
		itemParamMapper.insert(tbItemParam);
		return TaotaoResult.ok();
	}

}
