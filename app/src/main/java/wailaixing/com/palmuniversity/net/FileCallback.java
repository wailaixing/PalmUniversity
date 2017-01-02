package wailaixing.com.palmuniversity.net;


import wailaixing.com.palmuniversity.AppException;

public abstract class FileCallback extends AbsCallBack<String> {

    @Override
    protected String bindData(String path) throws AppException {
        return path;
    }
}
