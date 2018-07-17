package com.taotao.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.commons.pojo.EasyuiDataCatResult;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.pojo.TbContentCategoryExample.Criteria;
@Service
public class ContentCategoryImpl implements ContentCategorySerivce {
@Autowired
private TbContentCategoryMapper contentCategoryMapper;
	@Override
	public List<EasyuiDataCatResult> getContentCategory(long parentid) {
		TbContentCategoryExample tbContentCategoryExample =new TbContentCategoryExample();
		Criteria criteria =tbContentCategoryExample.createCriteria();
		criteria.andParentIdEqualTo(parentid);
		List<TbContentCategory> list=contentCategoryMapper.selectByExample(tbContentCategoryExample);
		List alist=new ArrayList();
		for(TbContentCategory tcc:list){
			EasyuiDataCatResult easyuiDataCatResult=new EasyuiDataCatResult();
			easyuiDataCatResult.setState(tcc.getIsParent()?"closed":"open");
			easyuiDataCatResult.setText(tcc.getName());
			easyuiDataCatResult.setId(tcc.getId());
			alist.add(easyuiDataCatResult);
		}
		return alist;
	}
	

}
