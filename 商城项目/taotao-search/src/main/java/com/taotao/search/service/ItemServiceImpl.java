package com.taotao.search.service;

//import java.util.ArrayList;
import java.util.List;

//import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.commons.pojo.TaotaoResult;
import com.taotao.search.mapper.ItemMapper;
import com.taotao.search.pojo.SeachItem;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private HttpSolrServer httpSolrServer;

	@Override
	public TaotaoResult getItemList() throws Exception{
		List<SeachItem> list = itemMapper.getList();
	
		for(SeachItem item:list){
			//创建文档对象
			SolrInputDocument sd=new SolrInputDocument();
			sd.addField("id", item.getId());
			sd.addField("item_title", item.getTitle());
			sd.addField("item_sell_point", item.getSell_point());
			sd.addField("item_image", item.getImage());
			sd.addField("item_price", item.getPrice());
			sd.addField("item_category_name", item.getCategory_name());
			sd.addField("item_desc", item.getItem_desc());
			//添加到索引库
			httpSolrServer.add(sd);
		}
		   httpSolrServer.commit();
		return TaotaoResult.ok();
	}

//	@Override
//	public TaotaoResult qureyItemList() throws Exception {
//		// 创建查询对象
//		SolrQuery query=new SolrQuery();
//		query.set("*:*");
//	    DocumentResponse res=httpSolrServer.query(params);
//		return null;
//	}

}
