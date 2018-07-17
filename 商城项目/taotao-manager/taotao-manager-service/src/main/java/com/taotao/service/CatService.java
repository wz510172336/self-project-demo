package com.taotao.service;

import java.util.List;

import com.taotao.commons.pojo.EasyuiDataCatResult;

public interface CatService {
  List<EasyuiDataCatResult> getCatResult(long parentId);
  
}
