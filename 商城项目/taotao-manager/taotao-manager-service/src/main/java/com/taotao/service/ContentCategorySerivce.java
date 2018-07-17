package com.taotao.service;



import java.util.List;

import com.taotao.commons.pojo.EasyuiDataCatResult;


public interface ContentCategorySerivce {
List<EasyuiDataCatResult> getContentCategory(long parentid);
}
