package wailaixing.com.palmuniversity.adapter.pager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import wailaixing.com.palmuniversity.R;
import wailaixing.com.palmuniversity.module.home.focusnews.HomeFocusNewsFragment;
import wailaixing.com.palmuniversity.module.home.notice.HomeNoticeFragment;


/**
 * Created by shiyanqi on 16/12/7.
 */

public class HomePageAdapter  extends FragmentPagerAdapter {
	private final String[] TITLES;

	private Fragment[] fragments;

	public HomePageAdapter(FragmentManager fm, Context context) {

		super(fm);
		TITLES = context.getResources().getStringArray(R.array.sections);
		fragments = new Fragment[TITLES.length];
	}

	@Override
	public Fragment getItem(int position) {

		if (fragments[position] == null) {
			switch (position) {
				case 0:
					fragments[position] = HomeNoticeFragment.getInstance();
					break;
				case 1:
					fragments[position] = HomeFocusNewsFragment.getInstance();
			}
		}
		return fragments[position];
	}

	@Override
	public int getCount() {

		return TITLES.length;
	}

	@Override
	public CharSequence getPageTitle(int position){
		return TITLES[position];
	}

}