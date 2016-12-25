package wailaixing.com.palmuniversity.module.common;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import wailaixing.com.palmuniversity.R;
import wailaixing.com.palmuniversity.base.RxBaseActivity;
import wailaixing.com.palmuniversity.module.entry.SettingFragment;
import wailaixing.com.palmuniversity.module.home.HomePageFragment;
import wailaixing.com.palmuniversity.utils.ToastUtil;

/**
 * Created by shiyanqi on 16/11/26.
 */

public class MainActivity extends RxBaseActivity implements NavigationView.OnNavigationItemSelectedListener {


	@BindView(R.id.container)
	FrameLayout container;
	@BindView(R.id.navigation_view)
	NavigationView navigationView;
	@BindView(R.id.drawer_layout)
	DrawerLayout drawerLayout;

	private int index;
	private Fragment[] fragments;
	private int currentTabIndex;
	private long exitTime;
	private HomePageFragment mHomePageFragment;

	@Override
	public int getLayoutId() {
		return R.layout.activity_main;
	}

	@Override
	public void initViews(Bundle savedInstanceState) {
		//fab.setImageDrawable();
		initFragment();
		initNavigationView();
	}

	@Override
	public void initToolBar() {
	}

	private void initFragment() {
		mHomePageFragment = HomePageFragment.getInstance();
		SettingFragment mSettingFragment = SettingFragment.getInstance();

		fragments = new Fragment[]{
				mHomePageFragment,
				mSettingFragment
		};

		// 添加显示第一个fragment
		getSupportFragmentManager()
				.beginTransaction()
				.add(R.id.container, mHomePageFragment)
				.show(mHomePageFragment).commit();
	}

	private void initNavigationView(){

	}


	@Override
	public boolean onNavigationItemSelected(@NonNull MenuItem item) {
		drawerLayout.closeDrawer(GravityCompat.START);
		switch (item.getItemId()){
			case R.id.itme_home:
				changeFragmentIndex(item, 0);
				return true;
			case R.id.item_settings:
				changeFragmentIndex(item, 1);
				return true;
			case R.id.item_class:

				return true;
			case R.id.item_message:

				return true;
		}
		return false;
	}

	public void toggleDrawer(){
		if(drawerLayout.isDrawerOpen(GravityCompat.START)){
			drawerLayout.closeDrawer(GravityCompat.START);
		}else {
			drawerLayout.openDrawer(GravityCompat.START);
		}
	}


	/**
	 * 切换Fragment
	 * @param item
	 * @param currentIndex
	 */
	private void changeFragmentIndex(MenuItem item, int currentIndex){
		index = currentIndex;
		switchFragment();
		item.setChecked(true);
	}


	private void switchFragment(){
		FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
		trx.hide(fragments[currentTabIndex]);
		if (!fragments[index].isAdded())
		{
			trx.add(R.id.container, fragments[index]);
		}
		trx.show(fragments[index]).commit();
		currentTabIndex = index;
	}



	/**
	 * 监听back键处理DrawerLayout
	 *
	 * @param keyCode
	 * @param event
	 * @return
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{

		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (drawerLayout.isDrawerOpen(drawerLayout.getChildAt(1))) {
				drawerLayout.closeDrawers();
			} else {
				exitApp();
			}
		}

		return true;
	}

	/**
	 * 双击退出App
	 */
	private void exitApp()
	{

		if (System.currentTimeMillis() - exitTime > 2000)
		{
			ToastUtil.ShortToast("再按一次退出");
			exitTime = System.currentTimeMillis();
		} else
		{
			//PreferenceUtils.remove(SWITCH_MODE_KEY);
			finish();
		}
	}

}
