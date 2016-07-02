package com.ideal.spdb.utils;
import java.io.IOException;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;




public class HttpClientUtil {

	private static Logger logger=Logger.getLogger(HttpClientUtil.class);
	
	/**
	 * post方法
	 * @param url http请求url连接地址和url传参
	 * @param 表单传参
	 * @author 
	 */
	public static String postParams(String url,JSONObject json){
		CloseableHttpClient clientLocal = HttpClients.createDefault();
		String body = null;
		HttpPost post = null;
	    CloseableHttpResponse httpresponse = null;
		try {
			//连接时间60s
        	//数据传输时间60s
        	RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(60000).setConnectTimeout(60000).build();
        	logger.info("请求地址:"+url);
        	//对URL地址进行判断
			if(url.isEmpty() || url== "" || !url.startsWith("http")){
				 logger.error("请求地址格式不正确:"+url);
				 
		    }
			post = new HttpPost(url);
			//设置超时时间
			post.setConfig(requestConfig);
			    StringEntity uefEntity = new StringEntity(json.toString(),"GBK");
				uefEntity.setContentType("application/json");
				post.setEntity(uefEntity);  
			// 发送请求
			httpresponse = clientLocal.execute(post);
				int statusCode = httpresponse.getStatusLine().getStatusCode();
				if (HttpStatus.SC_OK == statusCode) {
					// 获取返回数据
					HttpEntity entity = httpresponse.getEntity();
					if(entity!=null){
						body = EntityUtils.toString(entity);
						
						EntityUtils.consume(entity);
					}
				}else{
					logger.error("http请求状态码:"+statusCode);
				}
			} catch (Exception e) {	
				e.printStackTrace();
				logger.error("http请求失败:"+url);
				logger.error(e);
			}finally {
				if(httpresponse!=null){
					try {
						httpresponse.close();
						clientLocal.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(post!=null&&!post.isAborted()){
					post.releaseConnection();
				}
			}
		    return body;
	}
	
	public static String postParams(String url,String json){
		CloseableHttpClient clientLocal = HttpClients.createDefault();
		String body = null;
		HttpPost post = null;
	    CloseableHttpResponse httpresponse = null;
		try {
			//连接时间60s
        	//数据传输时间60s
        	RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(60000).setConnectTimeout(60000).build();
        	logger.info("请求地址:"+url);
        	//对URL地址进行判断
			if(url.isEmpty() || url== "" || !url.startsWith("http")){
				 logger.error("请求地址格式不正确:"+url);
				 
		    }
			post = new HttpPost(url);
			//设置超时时间
			post.setConfig(requestConfig);
			    StringEntity uefEntity = new StringEntity(json.toString(),"UTF-8");
				uefEntity.setContentType("application/json");
				post.setEntity(uefEntity);  
			// 发送请求
			httpresponse = clientLocal.execute(post);
				int statusCode = httpresponse.getStatusLine().getStatusCode();
				if (HttpStatus.SC_OK == statusCode) {
					// 获取返回数据
					HttpEntity entity = httpresponse.getEntity();
					if(entity!=null){
						body = EntityUtils.toString(entity);
						
						EntityUtils.consume(entity);
					}
				}else{
					logger.error("http请求状态码:"+statusCode);
				}
			} catch (Exception e) {	
				e.printStackTrace();
				logger.error("http请求失败:"+url);
				logger.error(e);
			}finally {
				if(httpresponse!=null){
					try {
						httpresponse.close();
						clientLocal.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(post!=null&&!post.isAborted()){
					post.releaseConnection();
				}
			}
		    return body;
	}
	
	//main方法测试

	public static void main(String[] args) {
     String url = AppConfigFile.getInstance().getValue("SHE_BAO_URL");
     JSONObject json = new JSONObject();
        json.put("appId", "490304445301");
		json.put("appName", "");
		json.put("documentNo", "");
		json.put("cityCode", "");
		json.put("outType", "1");
		json.put("method", "querySS");//调用方法名
		long start = System.currentTimeMillis();
        String body = HttpClientUtil.postParams(url, json);
        long end = System.currentTimeMillis();
        System.out.println(body);
        System.out.println(end-start);
	
}
}