package wailaixing.com.palmuniversity.utils;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by shiyanqi on 16/12/2.
 */

public class StackFromNewsOnSubscribe<T> implements Observable.OnSubscribe<T> {
	private Call call = null;

	public StackFromNewsOnSubscribe(Call call) {
		this.call = call;
	}

	@Override
	public void call(Subscriber<? super T> subscriber) {
		call.enqueue(new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {

			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				String html = response.body().string();
				Document doc = Jsoup.parse(html);

				List<String> textList = new ArrayList<String>();
				List<String> urlList = new ArrayList<String>();
				List<String> dateList = new ArrayList<String>();

				Element elementTitle = doc.getElementsByClass("detail-title").get(0);
				String h3 = elementTitle.getElementsByTag("h3").text();
				//System.out.println(h3);

				Element elementList = doc.getElementsByClass("channel-list").get(0);
				Elements childrenEle = elementList.children();
				for(Element child : childrenEle){
					String text = child.getElementsByTag("a").text();
					textList.add(text);

					String url = child.getElementsByTag("a").attr("href");
					urlList.add(url);

					String date = child.getElementsByTag("span").text();
					dateList.add(date);
				}

				if(!StringUtils.isBlank(h3)){
					//exportListInfo.add()
					//mNewUrlInfo = new NewUrlInfo(h3, textList, urlList, dateList);
				}
				//subscriber.onNext((T)mNewUrlInfo);
				//subscriber.onCompleted();

			}
		});

	}

}


