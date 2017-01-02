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
import wailaixing.com.palmuniversity.AppException;
import wailaixing.com.palmuniversity.net.OnGlobalExceptionListener;

/**
 * Created by shiyanqi on 16/11/26.
 */

public abstract class RxBaseActivity extends RxAppCompatActivity implements OnGlobalExceptionListener{

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

		setContentView(getLayoutId());
		bind = ButterKnife.bind(this);
		initViews(savedInstanceState);
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

	@Override
	public boolean handleException(AppException e) {
		if(e.responseCode == 403){
			if("token invalid".equals(e.getMessage())){
				//handler
				return true;
			}
		}
		return false;
	}
}
