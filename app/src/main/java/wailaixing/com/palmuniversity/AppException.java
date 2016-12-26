package wailaixing.com.palmuniversity;

/**
 * Created by shiyanqi on 16/12/26.
 */

public class AppException extends Exception{
	public int responseCode;
	public String responseMessage;

	public AppException(String detailMessage){
		super(detailMessage);
	}

	public AppException(int responseCode, String responseMessage){
		super(responseMessage);
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}

}
