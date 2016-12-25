package wailaixing.com.palmuniversity.module.common;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import org.apache.commons.lang3.StringUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import wailaixing.com.palmuniversity.R;
import wailaixing.com.palmuniversity.base.RxBaseActivity;
import wailaixing.com.palmuniversity.module.TestActivity;
import wailaixing.com.palmuniversity.module.entry.SettingFragment;
import wailaixing.com.palmuniversity.utils.ConstantUtil;
import wailaixing.com.palmuniversity.utils.PreferenceUtil;

/**
 * Created by shiyanqi on 16/11/26.
 */

public class LoginActivity extends AppCompatActivity{

	@BindView(R.id.toolbar)
	Toolbar toolbar;

	@BindView(R.id.iv_icon_left)
	ImageView ivIconLeft;

	@BindView(R.id.iv_icon_right)
	ImageView ivIconRight;

	@BindView(R.id.btn_login)
	Button btnLogin;

	@BindView(R.id.delete_username)
	ImageButton deleteUsername;

	@BindView(R.id.et_username)
	EditText etUsername;

	@BindView(R.id.et_password)
	EditText etPassword;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

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

		setContentView(R.layout.activity_login);

		ButterKnife.bind(this);
		initViews(savedInstanceState);
		initToolBar();
	}

	public void initViews(Bundle savedInstanceState) {

		etUsername.setOnFocusChangeListener((view, hasFocus) -> {
			if (hasFocus && etUsername.getText().length() > 0)
				deleteUsername.setVisibility(View.VISIBLE);
			else
				deleteUsername.setVisibility(View.GONE);


			ivIconLeft.setImageResource(R.drawable.ic_22);
			ivIconRight.setImageResource(R.drawable.ic_33);
		});

		etPassword.setOnFocusChangeListener((view, hasFocu) -> {
			ivIconLeft.setImageResource(R.drawable.ic_22_hide);
			ivIconRight.setImageResource(R.drawable.ic_33_hide);
		});


		etUsername.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int before, int count) {
				// 如果用户名清空了 清空密码 清空记住密码选项
				etPassword.setText("");
				if (s.length() > 0)
				{
					// 如果用户名有内容时候 显示删除按钮
					deleteUsername.setVisibility(View.VISIBLE);
				} else
				{
					// 如果用户名有内容时候 显示删除按钮
					deleteUsername.setVisibility(View.GONE);
				}
			}

			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

			@Override
			public void afterTextChanged(Editable editable) {}
		});

	}

	public void initToolBar() {
		toolbar.setNavigationIcon(R.drawable.ic_cancle);
		toolbar.setTitle("登录");
		toolbar.setNavigationOnClickListener(view -> finish());
	}

	@OnClick(R.id.btn_login)
	void startlogin(){
		login();
	}

	@OnClick(R.id.delete_username)
	void delete(){
		etUsername.setText("");
		etPassword.setText("");
		deleteUsername.setVisibility(View.GONE);
		etUsername.setFocusable(true);
		etUsername.setFocusableInTouchMode(true);
		etUsername.requestFocus();
	}

	@OnTextChanged({R.id.et_username, R.id.et_password})
	void onHandlerTextChange(){
		btnLogin.setEnabled(etUsername.getText().toString().length()>0 && etPassword.getText().toString().length()>0);
		btnLogin.setClickable(etUsername.getText().toString().length()>0 && etPassword.getText().toString().length()>0);
	}


	private void login() {

		String name = etUsername.getText().toString();
		String password = etPassword.getText().toString();

		if (StringUtils.isBlank(name))
		{
			//ToastUtil.ShortToast("用户名不能为空");
			return;
		}

		if (TextUtils.isEmpty(password))
		{
			//ToastUtil.ShortToast("密码不能为空");
			return;
		}

		PreferenceUtil.putBoolean(ConstantUtil.KEY, true);
		startActivity(new Intent(LoginActivity.this, TestActivity.class));
		finish();
	}

}
