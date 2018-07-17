package com.taotao.service;






import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.commons.pojo.PictureResult;
import com.taotao.util.FastDFSClient;
 @Service
public class PictureUploadServiceImpl implements PictureUploadService{
  @Value("${base_url}")
  private String base_url;
	@Override
	public PictureResult uploadFile(MultipartFile picFile) throws Exception {
		PictureResult pictureResult=new PictureResult(); 
		if(picFile.isEmpty()){
			pictureResult.setError(1);
			pictureResult.setMessage("图片为空");
			return pictureResult;
		}
		try {
			//取图片扩展名
			String originalFilename = picFile.getOriginalFilename();
			//取扩展名不要“.”
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
			FastDFSClient client = new FastDFSClient("classpath:properties/fastdfs_client.conf");
			String url = client.uploadFile(picFile.getBytes(), extName);
			//把url响应给客户端
			url=base_url+url;
			pictureResult.setError(0);
			pictureResult.setUrl(url);
		} catch (Exception e) {
			e.printStackTrace();
			pictureResult.setError(1);
			pictureResult.setMessage("图片上传失败");
		}
		return pictureResult;
	}
		
	   
		
//		ClientGlobal.init("D:\\eclipse\\workspace\\taotao-manager\\taotao-manager-web\\src\\main\\resources\\properties\\fastdfs_client.conf");
//		TrackerClient trackerClient=new TrackerClient();
//		TrackerServer trackerServer = trackerClient.getConnection();
//		StorageServer storageServer=null;
//		StorageClient storageClient=new StorageClient(trackerServer,storageServer);
//		storageClient.upload_file(file,"jpg", null);
		}
		
	
		


