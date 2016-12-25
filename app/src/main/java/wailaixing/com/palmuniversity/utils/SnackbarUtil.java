package wailaixing.com.palmuniversity.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by shiyanqi on 16/12/2.
 */

/**
 * Snackbar工具类
 */
public class SnackbarUtil {
	public static void showMessage(View view, String message){
		Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
	}

}
