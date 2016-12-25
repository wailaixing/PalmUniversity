package wailaixing.com.palmuniversity.net;

import android.os.AsyncTask;

import java.net.HttpURLConnection;


/**
 * Created by shiyanqi on 16/12/8.
 */

public class RequestTask extends AsyncTask<Void, Integer, Object>{
	private iCallBack callBack;
	private Request request;

	public RequestTask(Request request){
		this.request = request;
	}

	public void setCallBack(iCallBack callBack){
		this.callBack = callBack;
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
	}

	@Override
	protected Object doInBackground(Void... voids) {
		try {
			HttpURLConnection connection = HttpUrlConnectionUtil.execute(request);
			if(request.enableProgressUpdate){
				return callBack.onParse(connection, new OnProgressUpdatedListener() {
					@Override
					public void onProgressUpdated(int curLen, int totalLen) {
						publishProgress(curLen, totalLen);

					}
				});
			}else{
				return callBack.onParse(connection);
			}

		} catch (Exception e) {
			return e;
		}
	}

	@Override
	protected void onPostExecute(Object o) {
		if (o instanceof Exception){
			callBack.onFailed((Exception) o);
		}else {
			callBack.onSuccess(o);
		}
		super.onPostExecute(o);
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		super.onProgressUpdate(values);
		callBack.onProgressUpdated(values[0], values[1]);
	}
}
