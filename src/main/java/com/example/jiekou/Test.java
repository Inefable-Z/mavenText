package com.example.jiekou;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


/**
 * 接口测试
 * @author EDZ
 *
 */
public class Test {
	public static void main(String[] args) throws ClientProtocolException, IOException{
		//1. 发包，准备url
		String url = "http://demo.94php.com/?ct=app&ac=trade_buy&uid=961&t=1574241655706&sign=9bd6fea12ea2c798fbcc39b5a7a62ad3&type=1&goods_id=41&money=10.00";
		//2. 设置请求方法
		HttpGet get = new HttpGet(url);
		//HttpPost post = new HttpPost(url);
		//准备客户端
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//发包
		CloseableHttpResponse response = httpClient.execute(get);
		//验证响应头信息  HTTP/1.1 200 OK 
		StatusLine statusLine = response.getStatusLine();
		//获取协议版本
		ProtocolVersion httpversion = statusLine.getProtocolVersion();
		System.out.println(httpversion);
		//获取状态码
		int stateCode = statusLine.getStatusCode();
		System.out.println(stateCode);
		//遍历所有的头部信息
		Header[] allheaders = response.getAllHeaders();
		for(Header header : allheaders) {
			System.err.println(header.getName()+":"+header.getValue());
		}
		System.err.println();
		//响应体，toString方法可以将响应体转换成字符串
		String entityStr = EntityUtils.toString(response.getEntity());
		System.err.println(entityStr);
	}
}



















