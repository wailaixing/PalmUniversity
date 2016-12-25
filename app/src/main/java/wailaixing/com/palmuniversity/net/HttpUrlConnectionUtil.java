package wailaixing.com.palmuniversity.net;


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Created by shiyanqi on 16/12/8.
 */

public class HttpUrlConnectionUtil {

	public static HttpURLConnection execute(Request request) throws Exception {
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


	public static HttpURLConnection get(Request request) throws Exception {
		HttpURLConnection connection = null;
		try{
			connection = (HttpURLConnection) new URL(request.getUrl()).openConnection();
			connection.setConnectTimeout(15*3000);
			connection.setReadTimeout(15*3000);

			addHeader(connection, request);
		}catch (Exception e){
			throw new Exception();
		}
		return connection;
	}


	public static HttpURLConnection post(Request request) throws Exception {
		HttpURLConnection connection = null;
		try {
			connection = (HttpURLConnection) new URL(request.getUrl()).openConnection();
			connection.setConnectTimeout(15 * 3000);
			connection.setReadTimeout(15 * 3000);
			connection.setDoOutput(true);

			addHeader(connection, request);
		}catch (Exception e){
			throw  new Exception();
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
