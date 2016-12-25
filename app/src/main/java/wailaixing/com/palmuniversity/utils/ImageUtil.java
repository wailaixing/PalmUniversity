package wailaixing.com.palmuniversity.utils;

import org.apache.commons.lang3.StringUtils;

import wailaixing.com.palmuniversity.AppConst;

/**
 * Created by shiyanqi on 16/12/1.
 */

public class ImageUtil {
	public static String getImageUrlHost(String url){
		if(StringUtils.startsWith(url, "/")){
			//url = AppConst.BASE_HOST + url;
		}
		return url;
	}


}
