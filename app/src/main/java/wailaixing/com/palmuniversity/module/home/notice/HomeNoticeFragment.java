package wailaixing.com.palmuniversity.module.home.notice;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import wailaixing.com.palmuniversity.base.RxBaseFragment;

/**
 * Created by shiyanqi on 16/12/7.
 */

public class HomeNoticeFragment extends RxBaseFragment{
	@Override
	public int getLayoutResId() {
		return 0;
	}

	@Override
	public void finishCreateView(Bundle state) {

	}


	public static Fragment getInstance() {
		return new HomeNoticeFragment();
	}
}
