package wailaixing.com.palmuniversity.module.home;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.flyco.tablayout.SlidingTabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wailaixing.com.palmuniversity.R;
import wailaixing.com.palmuniversity.adapter.pager.HomePageAdapter;
import wailaixing.com.palmuniversity.base.RxBaseFragment;
import wailaixing.com.palmuniversity.module.common.MainActivity;
import wailaixing.com.palmuniversity.widget.CircleImageView;
import wailaixing.com.palmuniversity.widget.NoScrollViewPager;

/**
 * Created by shiyanqi on 16/12/2.
 */

public class HomePageFragment extends RxBaseFragment {

	@BindView(R.id.navigation_layout)
	LinearLayout navigationLayout;
	@BindView(R.id.toolbar)
	Toolbar toolbar;
	@BindView(R.id.view_pager)
	NoScrollViewPager viewPager;
	@BindView(R.id.toolbar_user_avatar)
	CircleImageView toolbarUserAvatar;
	@BindView(R.id.sliding_tabs)
	SlidingTabLayout slidingTabs;


	@Override
	public int getLayoutResId() {
		return R.layout.fragment_home_page;
	}

	@Override
	public void finishCreateView(Bundle state) {
		initToolBar();
		initViewPager();
	}

	public static HomePageFragment getInstance() {
		return new HomePageFragment();
	}

	@OnClick(R.id.navigation_layout)
	void toggleDrawer() {
		Activity activity = getActivity();
		if (activity instanceof MainActivity) {
			((MainActivity) activity).toggleDrawer();
		}
	}


	private void initToolBar() {
		toolbar.setTitle("");
		((MainActivity) getActivity()).setSupportActionBar(toolbar);
	}


	private void initViewPager() {
		HomePageAdapter mHomeAdapter = new HomePageAdapter(getChildFragmentManager(), getApplicationContext());

		viewPager.setOffscreenPageLimit(5);
		viewPager.setAdapter(mHomeAdapter);
		slidingTabs.setViewPager(viewPager);
		viewPager.setCurrentItem(1);
	}


}
