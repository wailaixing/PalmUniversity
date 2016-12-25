package wailaixing.com.palmuniversity.module.entry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.OnClick;
import wailaixing.com.palmuniversity.R;
import wailaixing.com.palmuniversity.base.RxBaseFragment;
import wailaixing.com.palmuniversity.module.common.AppIntroduceActivity;
import wailaixing.com.palmuniversity.module.common.MainActivity;
import wailaixing.com.palmuniversity.module.common.WaiLaiXingInfoActivity;

/**
 * Created by shiyanqi on 16/12/5.
 */

public class SettingFragment extends RxBaseFragment {

	@BindView(R.id.toolbar)
	Toolbar toolbar;
	@BindView(R.id.app_bar_layout)
	AppBarLayout appBarLayout;
	@BindView(R.id.about_me)
	RelativeLayout aboutMe;
	@BindView(R.id.about_app)
	RelativeLayout aboutApp;
	@BindView(R.id.btn_layout)
	Button btnLayout;

	@Override
	public int getLayoutResId() {
		return R.layout.fragment_setting;
	}

	@Override
	public void finishCreateView(Bundle state) {
		toolbar.setTitle("设置中心");
		toolbar.setNavigationIcon(R.drawable.ic_navigation_drawer);
		toolbar.setNavigationOnClickListener(v -> {
			Activity activity1 = getActivity();
			if(activity1 instanceof MainActivity){
				((MainActivity) activity1).toggleDrawer();
			}

		});

	}

	public static SettingFragment getInstance(){
		return new SettingFragment();
	}

	@OnClick(R.id.about_me)
	void aboutMe(){
		startActivity(new Intent(getActivity(), WaiLaiXingInfoActivity.class));
	}

	@OnClick(R.id.about_app)
	void aboutApp(){
		startActivity(new Intent(getActivity(), AppIntroduceActivity.class));
	}

	@OnClick(R.id.btn_layout)
	void logoutBtn(){

	}



}
