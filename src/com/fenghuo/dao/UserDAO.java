package com.fenghuo.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class UserDAO {

	String path = "";
	//	��½

	public boolean login(String number,String pass) throws ClientProtocolException, IOException{

		List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();

		list.add(new BasicNameValuePair("input", number));
		list.add(new BasicNameValuePair("pcode", pass));



		HttpGet httpGet = new HttpGet(path+"?"+URLEncodedUtils.format(list, "utf-8"));

		HttpClient httpClient = new DefaultHttpClient();

		HttpResponse response = httpClient.execute(httpGet);
		int code1 = response.getStatusLine().getStatusCode();


		if(code1==200){
			return true;
			//			��½�ɹ������ص�������

		}
		return false;






	}

	//	ע��

	public boolean register(String number,String pass,String code) throws ClientProtocolException, IOException {


		List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();

		list.add(new BasicNameValuePair("input", number));
		list.add(new BasicNameValuePair("pcode", pass));
		list.add(new BasicNameValuePair("register", code));


		HttpGet httpGet = new HttpGet(path+"?"+URLEncodedUtils.format(list, "utf-8"));

		HttpClient httpClient = new DefaultHttpClient();

		HttpResponse response = httpClient.execute(httpGet);
		int code1 = response.getStatusLine().getStatusCode();


		if(code1==200){

			//			��½�ɹ������ص���½����
			return true;
		}
		return false;
	}









}
