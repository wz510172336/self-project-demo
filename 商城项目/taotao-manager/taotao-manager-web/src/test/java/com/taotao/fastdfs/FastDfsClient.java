package com.taotao.fastdfs;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

public class FastDfsClient {
	@Test
public void upload()throws Exception{
	ClientGlobal.init("D:\\eclipse\\workspace\\taotao-manager\\taotao-manager-web\\src\\main\\resources\\properties\\fastdfs_client.conf");
	TrackerClient trackerClient=new TrackerClient();
	TrackerServer trackerServer = trackerClient.getConnection();
	StorageServer storageServer=null;
	StorageClient storageClient=new StorageClient(trackerServer,storageServer);
	String[] s=storageClient.upload_file("G:\\91ef.jpg", "jpg", null);
	for(String strings:s){System.out.println(strings);}
	
}
}