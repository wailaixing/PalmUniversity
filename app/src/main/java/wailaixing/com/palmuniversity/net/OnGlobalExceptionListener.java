package wailaixing.com.palmuniversity.net;

import wailaixing.com.palmuniversity.AppException;

/**
 * Created by shiyanqi on 16/12/26.
 */

public interface OnGlobalExceptionListener {
	boolean handleException(AppException exception);
}
