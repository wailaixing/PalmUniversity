package wailaixing.com.palmuniversity.net;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;
import wailaixing.com.palmuniversity.utils.OkHttpUtil;

/**
 * Created by shiyanqi on 16/12/22.
 */

public class DoParseOnSub {
	private String url;
	private iOnParse mIOnParse;

	public DoParseOnSub(String url){
		this.url = url;
	}

	public void setIOnParse(iOnParse mIOnParse){
		this.mIOnParse = mIOnParse;
	}

	public void Parse(){
		OkHttpUtil okHttpUtil = new OkHttpUtil();
		Call call = okHttpUtil.getGetCall(url);
		Observable.create(new Observable.OnSubscribe<Call>() {
			@Override
			public void call(Subscriber<? super Call> subscriber) {
				subscriber.onNext(call);
			}
		}).subscribeOn(Schedulers.io())
				.observeOn(Schedulers.newThread())
				.subscribe(new Subscriber<Call>() {
					@Override
					public void onNext(Call htmlEle) {
						call.enqueue(new Callback() {
							@Override
							public void onFailure(Call call, IOException e) {

							}

							@Override
							public void onResponse(Call call, Response response) throws IOException {
								String htmlEle = response.body().string();
								mIOnParse.onParse(htmlEle);
							}
						});
					}

					@Override
					public void onCompleted() {
					}

					@Override
					public void onError(Throwable e) {

					}
				});
	}

}
