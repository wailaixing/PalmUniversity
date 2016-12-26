package wailaixing.com.palmuniversity.net;

import java.io.IOException;
import java.net.HttpURLConnection;

import wailaixing.com.palmuniversity.AppException;

/**
 * Created by shiyanqi on 16/12/8.
 */

public interface iCallBack<T> {
	public void onSuccess(T result);
	public void onFailed(Exception e);
	T onParse(HttpURLConnection connection, OnProgressUpdatedListener listener) throws AppException;
	T onParse(HttpURLConnection connection) throws AppException;
	void onProgressUpdated(int curLen, int totalLen);
}
