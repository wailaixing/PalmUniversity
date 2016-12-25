package wailaixing.com.palmuniversity.base;

import android.app.ActivityManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by shiyanqi on 16/11/26.
 */

public abstract class RxBaseActivity extends RxAppCompatActivity {

	private Unbinder bind;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);

		/*
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			Window window = getWindow();
			window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
					| WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
			window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
					| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
					| View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
			window.setStatusBarColor(Color.TRANSPARENT);
		}
		*/


		//设置布局内容
		setContentView(getLayoutId());
		//初始化黄油刀控件绑定框架
		bind = ButterKnife.bind(this);
		//初始化控件
		initViews(savedInstanceState);
		//初始化ToolBar
		initToolBar();
	}

	public abstract int getLayoutId();

	public abstract void initViews(Bundle savedInstanceState);

	public abstract void initToolBar();

	public void loadData() {}

	public void showProgressBar() {}

	public void hideProgressBar() {}

	public void initRecyclerView() {}

	public void initRefreshLayout() {}

	public void finishTask() {}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		bind.unbind();
	}

	/*
	@Override
	public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState)
	{

		super.onPostCreate(savedInstanceState);
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
		{
			Window window = getWindow();
			window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			window.setStatusBarColor(ThemeUtils.getColorById(this, R.color.theme_color_primary_dark));
			ActivityManager.TaskDescription description = new ActivityManager.TaskDescription(null, null,
					ThemeUtils.getThemeAttrColor(this, android.R.attr.colorPrimary));
			setTaskDescription(description);
		}
	}
	*/
}
