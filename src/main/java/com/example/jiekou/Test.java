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
 * �ӿڲ���
 * @author EDZ
 *
 */
public class Test {
	public static void main(String[] args) throws ClientProtocolException, IOException{
		//1. ������׼��url
		String url = "http://demo.94php.com/?ct=app&ac=trade_buy&uid=961&t=1574241655706&sign=9bd6fea12ea2c798fbcc39b5a7a62ad3&type=1&goods_id=41&money=10.00";
		//2. �������󷽷�
		HttpGet get = new HttpGet(url);
		//HttpPost post = new HttpPost(url);
		//׼���ͻ���
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//����
		CloseableHttpResponse response = httpClient.execute(get);
		//��֤��Ӧͷ��Ϣ  HTTP/1.1 200 OK 
		StatusLine statusLine = response.getStatusLine();
		//��ȡЭ��汾
		ProtocolVersion httpversion = statusLine.getProtocolVersion();
		System.out.println(httpversion);
		//��ȡ״̬��
		int stateCode = statusLine.getStatusCode();
		System.out.println(stateCode);
		//�������е�ͷ����Ϣ
		Header[] allheaders = response.getAllHeaders();
		for(Header header : allheaders) {
			System.err.println(header.getName()+":"+header.getValue());
		}
		System.err.println();
		//��Ӧ�壬toString�������Խ���Ӧ��ת�����ַ���
		String entityStr = EntityUtils.toString(response.getEntity());
		System.err.println(entityStr);
	}
}



















