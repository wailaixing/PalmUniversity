package wailaixing.com.palmuniversity.utils;

import android.webkit.URLUtil;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import wailaixing.com.palmuniversity.AppException;

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

	public Request getPostRequest(String url, RequestBody mRequestBody) {
		return new Request.Builder().post(mRequestBody).tag(this).url(url).build();
	}

	public Call getGetCall(String url) throws Exception {
		try {
			Request request = getGetRequest(url);
			return getOkHttpClient().newCall(getGetRequest(url));
		} catch (Exception e) {
			throw e;
		}
	}

}
