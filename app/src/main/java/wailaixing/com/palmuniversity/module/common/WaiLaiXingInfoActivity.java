package wailaixing.com.palmuniversity.module.common;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.orhanobut.logger.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import butterknife.BindView;
import wailaixing.com.palmuniversity.R;
import wailaixing.com.palmuniversity.base.RxBaseActivity;

/**
 * Created by shiyanqi on 16/11/27.
 */

public class WaiLaiXingInfoActivity extends RxBaseActivity {


	@BindView(R.id.toolbar)
	Toolbar mToolbar;

	@Override
	public int getLayoutId() {
		return R.layout.activity_wailaixing;
	}

	@Override
	public void initViews(Bundle savedInstanceState) {

	}

	@Override
	public void initToolBar() {

		mToolbar.setTitle("关于我");
		setSupportActionBar(mToolbar);
		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null)
			actionBar.setDisplayHomeAsUpEnabled(true);
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{

		if (item.getItemId() == android.R.id.home)
			onBackPressed();
		return super.onOptionsItemSelected(item);
	}



}
