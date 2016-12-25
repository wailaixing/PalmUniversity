package wailaixing.com.palmuniversity.net;

import java.util.Map;

/**
 * Created by shiyanqi on 16/12/22.
 */

public class Request {

	public boolean enableProgressUpdate = false;

	public void enableProgressUpdate(boolean b) {
		enableProgressUpdate = b;
	}

	public enum RequestMethod {GET, POST, DELETE};
	private String url;
	private String content;
	private Map<String, String> header;

	public void setContent(String content) {
		this.content = content;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setHeader(Map<String, String> header) {
		this.header = header;
	}

	public Map<String, String> getHeader() {
		return header;
	}

	public RequestMethod getMethod() {
		return method;
	}

	public String getContent() {
		return content;
	}

	public String getUrl() {
		return url;
	}

	public void setMethod(RequestMethod method) {
		this.method = method;
	}

	public RequestMethod method;
}
