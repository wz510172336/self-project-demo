package com.taotao.pagehelpertest;



import java.util.List;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.junit.Test;


public class Pagehelper1 {
	@Test
	public void testPagehelper() throws Exception{
//		获得mapper对象
//		分页
//		执行查新
//		取分页后的结果
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext*.xml"); 
	    TbItemMapper itemMapper=applicationContext.getBean(TbItemMapper.class);
	    PageHelper.startPage(1, 30);
	    TbItemExample example=new TbItemExample();
	    List<TbItem> list=itemMapper.selectByExample(example);
	    PageInfo<TbItem> pageinfo=new PageInfo<TbItem>(list);
	    long total=pageinfo.getTotal(); 
	    int page=pageinfo.getPages();
	    System.out.println("总数量和总页数：" +total+"|"+page);
	}
 
}
