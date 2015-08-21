package com.yll.http;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * *
 * <p>
 * HTTP公用类 所需包:Commons-httpclient.jar,commons-codec-1.3.jar 学习参见网址:
 * https://www.ibm.com/developerworks/cn/opensource/os-cn-crawler/
 * </p>
 * 
 * @author Yuelili
 * 
 */
public class HttpClientUtils {
	
	private static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);
	private static final int CONNECTTION_TIME_OUT = 5000;
	

	public static void main(String arg[]) throws Exception {
		
		String urlget  = "http://192.168.66.133:8080/api/v1/rewardcredits/ticket/userRewardDetails?language=en&currency=USD&customerId=1231&sid=fdc10825790b44049c2565be323dfcca&app_key=V06GF3A2&sign=9D24A9EBBD64E8A547B20E1EB47170D6";
		// getDoGetURL2(url,"utf-8");//测试ok
		//getDoGetURL(urlget,"utf-8");//测试ok
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ticketId", 123);
		map.put("customerId", 123131);
		/*map.put("snapshotId", 1231231312);
		map.put("sid", "fdc10825790b44049c2565be323dfcca");*/
		map.put("orderId", 980);
		map.put("rewardType", 120);
		map.put("currency", "en");
		map.put("rewardAmount", 100);
		map.put("limitAmount", 100);
		map.put("expiredTime", 100);
		map.put("limitSupplierId", 0);
		map.put("limitCategoryId", 0);
		
		String urlPost = "http://192.168.66.133:8080/api/v1/rewardcredits/ticket/recharge?sid=fdc10825790b44049c2565be323dfcca&app_key=V06GF3A2&sign=2BDDF09410C6E1EFEC4806F15056D964";
		getDoPostResponseDataByURL(urlPost, map, "utf-8"); // 测试ok
	}

	/**
	 * <p>
	 * httpClient的get请求方式
	 * </p>
	 * @param url = "https://www.99bill.com/webapp/receiveDrawbackAction.do";
	 * @param charset= "utf-8";
	 * @return
	 * @throws Exception
	 */
	public static String getDoGetURL(String url, String charset) throws Exception {

		HttpClient client = new HttpClient();
		GetMethod method1 = new GetMethod(url);

		if (null == url || !url.startsWith("http")) {
			throw new Exception("请求地址格式不对");
		}

		// 设置请求的编码方式
		if (null != charset) {
			method1.addRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=" + charset);
		} else {
			method1.addRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=" + "utf-8");
		}
		
		int statusCode = client.executeMethod(method1);

		if (statusCode != HttpStatus.SC_OK) {
			// 打印服务器返回的状态
			logger.info("Method failed: " + method1.getStatusLine());
		}
		// 返回响应消息
		byte[] responseBody = method1.getResponseBodyAsString().getBytes(
				method1.getResponseCharSet());
		// 在返回响应消息使用编码(utf-8或gb2312)
		String response = new String(responseBody, "utf-8");
		logger.info("------------------response:" + response);
		// 释放连接
		method1.releaseConnection();
		return response;
	}

	/**
	 * <p>
	 * httpClient的get请求方式2
	 * </p>
	 * 
	 * @param url
	 *            = "https://www.99bill.com/webapp/receiveDrawbackAction.do";
	 * @param charset
	 *            = ="utf-8";
	 * @return
	 * @throws Exception
	 */
	public static String getDoGetURL2(String url, String charset)
			throws Exception {
		/*
		 * 使用 GetMethod 来访问一个 URL 对应的网页,实现步骤: 1:生成一个 HttpClinet 对象并设置相应的参数。
		 * 2:生成一个 GetMethod 对象并设置响应的参数。 3:用 HttpClinet 生成的对象来执行 GetMethod 生成的Get
		 * 方法。 4:处理响应状态码。 5:若响应正常，处理 HTTP 响应内容。 6:释放连接。
		 */

		/* 1 生成 HttpClinet 对象并设置参数 */
		HttpClient httpClient = new HttpClient();
		// 设置 Http 连接超时为5秒
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(CONNECTTION_TIME_OUT);

		/* 2 生成 GetMethod 对象并设置参数 */
		GetMethod getMethod = new GetMethod(url);
		getMethod.addRequestHeader("Content-Type", "application/json; charset=utf-8");
		// 设置 get 请求超时为 5 秒
		getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, CONNECTTION_TIME_OUT);
		// 设置请求重试处理，用的是默认的重试处理：请求三次
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());

		String response = "";
		/* 3 执行 HTTP GET 请求 */
		try {
			int statusCode = httpClient.executeMethod(getMethod);
			/* 4 判断访问的状态码 */
			if (statusCode != HttpStatus.SC_OK) {
				logger.info("Method failed: "+ getMethod.getStatusLine());
			}

			/* 5 处理 HTTP 响应内容 */
			// HTTP响应头部信息，这里简单打印
			Header[] headers = getMethod.getResponseHeaders();
			for (Header h : headers)
				logger.info(h.getName() + "------------ " + h.getValue());

			// 读取 HTTP 响应内容，这里简单打印网页内容
			byte[] responseBody = getMethod.getResponseBody();// 读取为字节数组
			response = new String(responseBody, charset);
			System.out.println("----------response:" + response);

			// 读取为 InputStream，在网页内容数据量大时候推荐使用
			// InputStream response = getMethod.getResponseBodyAsStream();

		} catch (HttpException e) {
			// 发生致命的异常，可能是协议不对或者返回的内容有问题
			System.out.println("Please check your provided http address!");
			e.printStackTrace();
		} catch (IOException e) {
			// 发生网络异常
			e.printStackTrace();
		} finally {
			/* 6 .释放连接 */
			getMethod.releaseConnection();
		}
		return response;
	}

	/**
	 * <p>
	 * 执行一个HTTP POST请求，返回请求响应的HTML
	 * </p>
	 * @param url 请求的URL地址
	 * @param params 请求的查询参数,可以为null
	 * @param charset 字符集
	 * @param pretty 是否美化
	 * @return 返回请求响应的HTML
	 */
	public static String getDoPostResponseDataByURL(String url, Map<String, Object> params, String charset) {

		StringBuffer response = new StringBuffer();

		HttpClient client = new HttpClient();
		HttpMethod method = new PostMethod(url);
		method.addRequestHeader("Content-Type", "application/json; charset=utf-8");

		// 设置Http Post数据
		if (params != null) {
			HttpMethodParams p = new HttpMethodParams();
			for (Map.Entry<String, Object> entry : params.entrySet()) {
				p.setParameter(entry.getKey(), entry.getValue());
			}
			method.setParams(p);
		}
		try {
			
			int code = client.executeMethod(method);
			if (method.getStatusCode() == HttpStatus.SC_OK) {
				// 读取为 InputStream，在网页内容数据量大时候推荐使用
				BufferedReader reader = new BufferedReader( new InputStreamReader(method.getResponseBodyAsStream(), charset));
				String line;
				while ((line = reader.readLine()) != null) {
						response.append(line);
				}
				reader.close();
			} else {
				logger.info("执行HTTP Post请求" + url + "时，发生异常！ statusCode: " + method.getStatusCode());
			}
		} catch(HttpException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			logger.info("执行HTTP Post请求" + url + "时，发生异常！");
			e.printStackTrace();
		} finally {
			logger.info("释放连接...");
			method.releaseConnection();
		}
		System.out.println("--------------------" + response.toString());
		return response.toString();
	}

}