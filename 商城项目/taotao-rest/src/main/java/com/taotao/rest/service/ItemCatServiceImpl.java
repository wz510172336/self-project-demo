package com.taotao.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.*;
import com.taotao.pojo.TbContentExample.Criteria;
import com.taotao.rest.pojo.*;

@Service
public class ItemCatServiceImpl implements ItemCatService {
	@Autowired
	private TbItemCatMapper itemCatMapper;

	@Override
	public ItemCatResult getItemCatResult() {
		List l = getItemCatResult((long) 0);
		ItemCatResult itemCatResult = new ItemCatResult();
		itemCatResult.setData(l);
		return itemCatResult;
	}

	public List getItemCatResult(Long parentId) {
		TbItemCatExample itemCatExample = new TbItemCatExample();
		com.taotao.pojo.TbItemCatExample.Criteria criteria = itemCatExample.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list = itemCatMapper.selectByExample(itemCatExample);
		List alist = new ArrayList();
		int index = 0;
		for (TbItemCat tbitemCat : list) {
			if (index >= 14)
				{break;}
			if (tbitemCat.getIsParent()) {
				ItemCat itemCat = new ItemCat();
				// itemCat.setItem(getItemCatResult(tbitemCat.getId()));
				itemCat.setUrl("/products/" + tbitemCat.getId() + ".html");
				if (tbitemCat.getParentId() == 0) {
					itemCat.setNode(
							"<a href='/products/" + tbitemCat.getId() + ".html'>" + tbitemCat.getName() + "</a>");
				} else {
					itemCat.setNode(tbitemCat.getName());
				}
				itemCat.setItem(getItemCatResult(tbitemCat.getId()));
				alist.add(itemCat);
				
			} else {
				String s = "/products/" + tbitemCat.getId() + ".html|" + tbitemCat.getName();
				alist.add(s);
			}
			index++;
		}

		return alist;
	}
}
