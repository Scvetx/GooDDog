package ss.scvex.test21_testapp;

import static ss.scvex.test21_testapp.Accessories.ACCESSORIES_NAME;
import static ss.scvex.test21_testapp.Accessories.WEB;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebAccessories extends ActionBarActivity {
	
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview);
		
		Intent intent = getIntent();
		String http = intent.getStringExtra(WEB);
		String name = intent.getStringExtra(ACCESSORIES_NAME);
		
		ActionBar bar = getActionBar();
		bar.setDisplayShowTitleEnabled(true); // показывает текст рядом с кнопкой home
		bar.setDisplayShowHomeEnabled(true); // показывает иконку приложения
		bar.setDisplayHomeAsUpEnabled(true); // добавляет стрелочку возврата на активити вверх
		bar.setTitle(name); // название активности
		
		WebView webView = (WebView) findViewById(R.id.web);
		webView.setWebViewClient(new MyWebViewClient());
		webView.loadUrl(http);		
	}

	//обработчик нажатия меню
	public boolean onOptionsItemSelected (MenuItem item) {
		switch (item.getItemId()) {
		case (android.R.id.home):
			NavUtils.navigateUpFromSameTask (this); // переход к родительской активности
	       	return  true;
		default: return super.onOptionsItemSelected(item);
		}
	}
	
	// переопределение класса WebViewClient, чтобы все последующие ссылки открывались внутри приложения
	private class MyWebViewClient extends WebViewClient {
		public boolean shouldOverrideUrlLoading (WebView view, String url) {
			view.loadUrl(url);
			return true;
	}
		
		
	}
}