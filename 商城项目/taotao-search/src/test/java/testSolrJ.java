import java.io.IOException;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class testSolrJ {
	
	SolrServer solrServer = new HttpSolrServer("http://192.168.25.135:8080/solr");
	
	@Test
	public void testdoc() {
		
		// 创建文档
		SolrInputDocument doc = new SolrInputDocument();
		//添加域
		doc.addField("id", "1405");
		doc.addField("name", "wz");
		try {
			//添加到索引库
			solrServer.add(doc);
			//提交
			solrServer.commit();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void query()throws Exception{
		//创建一个查询对象
		SolrQuery solrquery=new SolrQuery();
		//设置查询
		solrquery.set("*:*");
		//查询
	QueryResponse res=solrServer.query(solrquery);
	    //取结果
     SolrDocumentList sdl=res.getResults();
     for(SolrDocument s:sdl){
    	 System.out.println(s.get("id"));
    	 System.out.println(s.get("name"));
    	 
     }
	}

}
