package wailaixing.com.palmuniversity.utils;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

import wailaixing.com.palmuniversity.MyApplication;

/**
 * Created by shiyanqi on 16/12/15.
 */

public class ShareUtil {
	public static String WX_APIID = "";
	public static String QQ_APIID = "";

	static {
		ApplicationInfo appInfo = null;
		try {
			appInfo = MyApplication.getInstance().getPackageManager()
					.getApplicationInfo(MyApplication.getInstance().getPackageName(),
							PackageManager.GET_META_DATA);
		} catch (Exception e) {
			e.printStackTrace();
		}
		WX_APIID =appInfo.metaData.getString("WX_APPKEY");
		QQ_APIID =appInfo.metaData.getString("QQ_APPKEY");
	}

	public static IWXAPI getWXApi(String WX_APIID){
		IWXAPI api = WXAPIFactory.createWXAPI(MyApplication.getInstance(), WX_APIID, true);
		api.registerApp(WX_APIID);
		return api;
	}



}


