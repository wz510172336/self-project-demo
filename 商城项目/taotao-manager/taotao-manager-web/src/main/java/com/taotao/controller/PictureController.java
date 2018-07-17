package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.commons.pojo.PictureResult;
import com.taotao.service.PictureUploadService;

@Controller
public class PictureController {
	@Autowired
	private PictureUploadService pictureUploadService;

	@RequestMapping("/pic/upload")
	@ResponseBody
	public PictureResult upload( MultipartFile uploadFile) throws Exception {
		PictureResult pictureResult= pictureUploadService.uploadFile(uploadFile);
		return pictureResult;

	}

}
