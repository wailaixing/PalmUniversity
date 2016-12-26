package wailaixing.com.palmuniversity.module;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.orhanobut.logger.Logger;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;
import wailaixing.com.palmuniversity.AppConst;
import wailaixing.com.palmuniversity.R;
import wailaixing.com.palmuniversity.net.DoParseOnSub;
import wailaixing.com.palmuniversity.net.iOnParse;
import wailaixing.com.palmuniversity.utils.OkHttpUtil;

/**
 * Created by shiyanqi on 16/12/22.
 */

public class TestActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);

	}


	public void test(View view) throws Exception {
//		getRequest();
//		new Thread(() -> {
//			Document document = null;
//			try {
//				document = Jsoup.connect("http://www.baidu.com").get();
//				System.out.println(document.html());
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}).start();

		DoParseOnSub doParseOnSub = new DoParseOnSub(AppConst.HOST_URL);

		doParseOnSub.setIOnParse(new iOnParse() {
			@Override
			public void onParse(String htmlEle) {
				Logger.i(htmlEle);

				Document doc = Jsoup.parse(htmlEle);
				Element element = doc.getElementsByClass("kstd_content").get(0);

				Elements childrenEle = element.children();
				for(Element child : childrenEle){
					String url = child.getElementsByTag("img").attr("src");
					String title = child.getElementsByTag("span").text();
					System.out.println(title);
				}

			}
		});

		doParseOnSub.Parse();
	}


	/*
	private void getRequest() {

		final Request request = new Request.Builder()
				.url("http://www.thxy.org")
				.build();

		new Thread(new Runnable() {
			@Override
			public void run() {
				Response response = null;
				try {
					response = OkHttpUtil.getOkHttpClient().newCall(request).execute();
					if (response.isSuccessful()) {
						String html = response.body().string();
						Document doc = Jsoup.parse(html);
						Element element = doc.getElementsByClass("kstd_content").get(0);

						Elements childrenEle = element.children();
						for (Element child : childrenEle) {
							String url = child.getElementsByTag("img").attr("src");
							String title = child.getElementsByTag("span").text();
							Logger.i(title);
						}
					} else {
						throw new IOException("Unexpected code " + response);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	*/
}
