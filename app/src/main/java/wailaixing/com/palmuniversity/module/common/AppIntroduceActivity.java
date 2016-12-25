package wailaixing.com.palmuniversity.module.common;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.BindView;
import wailaixing.com.palmuniversity.R;
import wailaixing.com.palmuniversity.base.RxBaseActivity;

/**
 * Created by shiyanqi on 16/11/29.
 */

public class AppIntroduceActivity extends RxBaseActivity {


	@BindView(R.id.toolbar)
	Toolbar toolbar;
	@BindView(R.id.collapsing_toolbar)
	CollapsingToolbarLayout mCollapsingToolbarLayout;

	@Override
	public int getLayoutId() {
		return R.layout.activity_app_introduce;
	}

	@Override
	public void initViews(Bundle savedInstanceState) {}

	@Override
	public void initToolBar() {
		setSupportActionBar(toolbar);
		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null)
			actionBar.setDisplayHomeAsUpEnabled(true);

		mCollapsingToolbarLayout.setTitle("关于掌上校园"+getVersion());

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case android.R.id.home:
				onBackPressed();
				return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private String getVersion(){
		try {
			PackageInfo pi = getPackageManager().getPackageInfo(getPackageName(), 0);
			return pi.versionName;
		} catch (PackageManager.NameNotFoundException e) {
			e.printStackTrace();
			return "V 1.0";
		}
	}
}
