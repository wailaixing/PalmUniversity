package wailaixing.com.palmuniversity.net;


import android.webkit.URLUtil;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import wailaixing.com.palmuniversity.AppException;

/**
 * Created by shiyanqi on 16/12/8.
 */

public class HttpUrlConnectionUtil {

	public static HttpURLConnection execute(Request request) throws AppException {
		if(! URLUtil.isNetworkUrl(request.getUrl())){
			throw new AppException(request.getUrl() + "is illegal");
		}
		switch (request.getMethod()){
			case GET:
				get(request);
				break;
			case POST:
				post(request);
				break;
		}
		return null;
	}


	public static HttpURLConnection get(Request request) throws AppException {
		HttpURLConnection connection = null;
		try{
			connection = (HttpURLConnection) new URL(request.getUrl()).openConnection();
			connection.setConnectTimeout(15*3000);
			connection.setReadTimeout(15*3000);

			addHeader(connection, request);
		}catch (Exception e){
			throw new AppException(e.getMessage());
		}
		return connection;
	}


	public static HttpURLConnection post(Request request) throws AppException {
		HttpURLConnection connection = null;
		try {
			connection = (HttpURLConnection) new URL(request.getUrl()).openConnection();
			connection.setConnectTimeout(15 * 3000);
			connection.setReadTimeout(15 * 3000);
			connection.setDoOutput(true);

			addHeader(connection, request);
		}catch (Exception e){
			throw  new AppException(e.getMessage());
		}
		return connection;
	}


	private static void addHeader(HttpURLConnection connection, Request request){
		if(request.getHeader() == null || request.getHeader().size()==0){
			return;
		}else {
			for (Map.Entry<String, String> entry : request.getHeader().entrySet()) {
				connection.setRequestProperty(entry.getKey(), entry.getValue());
			}
		}
	}
}
