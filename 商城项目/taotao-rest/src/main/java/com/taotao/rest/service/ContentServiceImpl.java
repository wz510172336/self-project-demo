package com.taotao.rest.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.taotao.common.util.JsonUtils;
import com.taotao.commons.pojo.TaotaoResult;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;

import com.taotao.pojo.TbContentExample;
import com.taotao.pojo.TbContentExample.Criteria;
import com.taotao.rest.component.Jedisimp;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper tbContentMapper;
	@Autowired
	private Jedisimp jedisimp;
	@Value("${Redis_Content_Key}")
	private String Redis_Content_Key;

	@Override
	public List<TbContent> getContentList(Long categoryId) {
		try {
			String s = jedisimp.hget(Redis_Content_Key, categoryId + "");
			if (!StringUtils.isBlank(s)) {
				List<TbContent> list = JSON.parseArray(s, TbContent.class);
				return list;
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		TbContentExample tbContentExample = new TbContentExample();
		Criteria criteria = tbContentExample.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		List<TbContent> tlist = tbContentMapper.selectByExampleWithBLOBs(tbContentExample);
		try {
			jedisimp.hset(Redis_Content_Key, categoryId + "", JsonUtils.ListToJson(tlist));

		} catch (Exception e) {
			// TODO: handle exception
		}
		return tlist;
	}

	@Override
	public TaotaoResult snycContent( Long categoryId) {
		 Long lon=jedisimp.hdel(Redis_Content_Key, categoryId+"");
		return TaotaoResult.ok();
	}

}
