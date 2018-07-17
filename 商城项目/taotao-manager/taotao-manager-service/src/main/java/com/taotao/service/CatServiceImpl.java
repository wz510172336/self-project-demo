package com.taotao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.commons.pojo.EasyuiDataCatResult;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;

@Service
public class CatServiceImpl implements CatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;

	@Override
	public List<EasyuiDataCatResult> getCatResult(long parentId) {
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		List<EasyuiDataCatResult> catResult = new ArrayList<>();
		for (TbItemCat tbItemCat : list) {
			EasyuiDataCatResult easyuiDataCatResult=new EasyuiDataCatResult();
			easyuiDataCatResult.setId(tbItemCat.getId());
			easyuiDataCatResult.setText(tbItemCat.getName());
			easyuiDataCatResult.setState(tbItemCat.getIsParent()? "closed":"open");
			catResult.add(easyuiDataCatResult);			
		}
		return catResult;
	}

}
