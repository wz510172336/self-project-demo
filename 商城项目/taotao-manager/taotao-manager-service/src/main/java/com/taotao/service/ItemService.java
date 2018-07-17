package com.taotao.service;

import com.taotao.commons.pojo.DataGirdResult;
import com.taotao.commons.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

public interface ItemService {
 TbItem getTbItemById(long itemId);
 DataGirdResult getDataGridResult(int page,int rows);
 TaotaoResult  addItem(TbItem item,String desc);
}
