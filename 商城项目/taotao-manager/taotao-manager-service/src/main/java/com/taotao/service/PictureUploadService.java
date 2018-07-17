package com.taotao.service;

import org.springframework.web.multipart.MultipartFile;

import com.taotao.commons.pojo.PictureResult;

public interface PictureUploadService {
	

	PictureResult uploadFile(MultipartFile picFile) throws Exception;

}
