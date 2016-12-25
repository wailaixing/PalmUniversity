package wailaixing.com.palmuniversity.net;

/**
 * Created by shiyanqi on 16/12/20.
 */

public abstract class StringCallBack extends AbsCallBack<String> {
	@Override
	protected String bindData(String result) {
		return result;
	}
}
