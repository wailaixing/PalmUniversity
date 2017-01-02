package wailaixing.com.palmuniversity.net;


import com.google.gson.stream.JsonReader;

import wailaixing.com.palmuniversity.AppException;

public interface JsonReaderable {
    void readFromJson(JsonReader reader) throws AppException;

}
