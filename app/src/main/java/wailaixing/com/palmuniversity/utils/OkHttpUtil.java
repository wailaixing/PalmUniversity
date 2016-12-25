package wailaixing.com.palmuniversity.utils;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by shiyanqi on 16/12/2.
 */

public class OkHttpUtil {

	private static OkHttpClient mOkHttpClient;

	public static OkHttpClient getOkHttpClient(){
		if (mOkHttpClient == null) {
			synchronized (OkHttpClient.class) {
				if (mOkHttpClient == null) {
					mOkHttpClient = new OkHttpClient();
				}
			}
		}
		return mOkHttpClient;
	}


	public Request getGetRequest(String url) {
		return new Request.Builder().url(url).build();
	}

	public Request getPostRequest(String url, RequestBody mRequestBody){
		return new Request.Builder().post(mRequestBody).tag(this).url(url).build();
	}

	public Call getGetCall(String url) {
		return getOkHttpClient().newCall(getGetRequest(url));
	}

	public Call getGetCall(Request request) {
		return getOkHttpClient().newCall(request);
	}


}
