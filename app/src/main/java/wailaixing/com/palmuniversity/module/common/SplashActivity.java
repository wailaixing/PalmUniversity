package wailaixing.com.palmuniversity.module.common;

import android.content.Intent;
import android.os.Bundle;

import com.orhanobut.logger.Logger;
import com.trello.rxlifecycle.components.RxActivity;

import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import wailaixing.com.palmuniversity.R;
import wailaixing.com.palmuniversity.base.RxBaseActivity;
import wailaixing.com.palmuniversity.utils.ConstantUtil;
import wailaixing.com.palmuniversity.utils.PreferenceUtil;

/**
 * Created by shiyanqi on 16/11/26.
 */

public class SplashActivity extends RxActivity {

	private Unbinder bind;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		bind = ButterKnife.bind(this);
		//SystemUiVisibilityUtil.hideStatusBar(getWindow(), true);
		setUpSplash();
	}


	private void setUpSplash()
	{

		Observable.timer(2000, TimeUnit.MILLISECONDS)
				.compose(bindToLifecycle())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(aLong -> {
					finishTask();
				});
	}

	private void finishTask()
	{

		boolean isLogin = PreferenceUtil.getBoolean(ConstantUtil.KEY, false);
		if (isLogin)
			startActivity(new Intent(SplashActivity.this, LoginActivity.class));
		else
			startActivity(new Intent(SplashActivity.this, LoginActivity.class));

		SplashActivity.this.finish();
	}


	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		bind.unbind();
	}
}



