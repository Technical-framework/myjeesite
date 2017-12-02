/**
 * Project Name:hotelfront
 * File Name:HttpTools.java
 * Package Name:com.iman.tool
 * Date:2015年11月4日下午1:23:51
 * Copyright (c) 1999 - 2015,iman, Inc or its affiliates. All Rights Reserved. 
*/

package com.thinkgem.jeesite.common.utils;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClassName:HttpTools <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年11月4日 下午1:23:51 <br/>
 * 
 * @author haoxi
 */
public class HttpTools {
	private static final Logger LOGGER = LoggerFactory.getLogger(HttpTools.class);

	public static String doPost(String url, String data) {
		// 使用连接池创建连接
		PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(poolingHttpClientConnectionManager)
				.build();
		CloseableHttpResponse response = null;
		try {
			HttpPost post = new HttpPost(url);
			// 设置请求和传输超时时间
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(10000)
					.build();
			post.setConfig(requestConfig);
			ContentType contentType = ContentType.create(ContentType.APPLICATION_JSON.getMimeType(),
					Charset.forName("UTF-8"));
			post.setEntity(new StringEntity(data, contentType));
			response = httpClient.execute(post, HttpClientContext.create());
			int statusCode = response.getStatusLine().getStatusCode();
			if (200 == statusCode) {
				HttpEntity entity = response.getEntity();
				String s = EntityUtils.toString(entity);
				// 关闭httpEntity流
				EntityUtils.consume(entity);
				return s;
			}
		} catch (ConnectTimeoutException e) {
			LOGGER.error("Connect Timeout.");
		} catch (SocketTimeoutException e) {
			LOGGER.error("Socket Timeout.");
		} catch (Exception e) {
			LOGGER.error("doPost Exception : ", e);
		} finally {
			if (null != response) {
				try {
					// 关闭response
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
