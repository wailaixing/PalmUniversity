package wailaixing.com.palmuniversity;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by shiyanqi on 16/11/18.
 */

public class MyApplication extends Application {

    //应用实例
    public static MyApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        init();
    }

	/**
     * 获取实例
     * @return
     */
    public static MyApplication getInstance(){
        return mInstance;
    }

    private void init() {
        //com.wanjian.sak.LayoutManager.init(this);
    }


	/**
     * 获取当前app的版本
     * @return
     */
    public static int getAppVersion() {
        try {
            PackageInfo info = getInstance().getPackageManager().getPackageInfo(getInstance().getPackageName(), 0);
            return info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
