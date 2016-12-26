package wailaixing.com.palmuniversity.net;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import wailaixing.com.palmuniversity.AppException;

/**
 * Created by shiyanqi on 16/12/10.
 */

public abstract  class AbsCallBack<T> implements iCallBack<T> {

	private String path = null;

	@Override
	public T onParse(HttpURLConnection connection) throws AppException {
		return onParse(connection, null);
	}

	@Override
	public T onParse(HttpURLConnection connection, OnProgressUpdatedListener listener) throws AppException {
		try {
			int responseCode = connection.getResponseCode();
			if (responseCode == 200) {
				if (path != null) {
					FileOutputStream fop = new FileOutputStream(path);
					InputStream is = connection.getInputStream();
					byte[] buffer = new byte[2048];
					int len;
					int currLen = 0;
					int totalLen = connection.getContentLength();


					while ((len = is.read(buffer)) != -1) {
						fop.write(buffer, 0, len);
						currLen += len;
						listener.onProgressUpdated(currLen, totalLen);
					}
					is.close();
					fop.flush();
					fop.close();
					return bindData(path);
				} else {
					ByteArrayOutputStream out = new ByteArrayOutputStream();
					InputStream is = connection.getInputStream();

					byte[] buffer = new byte[2048];
					int len;
					while ((len = is.read(buffer)) != -1) {
						out.write(buffer, 0, len);
					}

					is.close();
					out.flush();
					out.close();
					String result = new String(out.toByteArray());
					return bindData(result);
				}
			} else {
				throw new AppException(responseCode, connection.getResponseMessage());
			}
		}catch (Exception e){
			throw new AppException(e.getMessage());
		}
	}

	public void setFilePath(String path){
		this.path = path;
	}

	protected abstract T bindData(String result);
}
