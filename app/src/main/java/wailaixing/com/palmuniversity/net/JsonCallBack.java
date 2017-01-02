package wailaixing.com.palmuniversity.net;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import wailaixing.com.palmuniversity.AppException;

/**
 * Created by shiyanqi on 16/12/27.
 */

public abstract class JsonCallBack<T> extends AbsCallBack<T> {

	@Override
	protected T bindData(String result) throws AppException {
		try {
			JSONObject json = new JSONObject(result);
			JSONObject data = json.optJSONObject("data");
			Gson gson = new Gson();
			Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
			return gson.fromJson(data.toString(), type);
		} catch (JSONException e) {
			throw new AppException(AppException.ErrorType.JSON, e.getMessage());
		}
	}
}

