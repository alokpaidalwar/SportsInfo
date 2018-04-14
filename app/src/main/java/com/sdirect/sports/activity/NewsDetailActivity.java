package com.sdirect.sports.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.sdirect.sports.R;
import com.sdirect.sports.databinding.ActivityMainBinding;
import com.sdirect.sports.databinding.ActivityNewsDetailBinding;

public class NewsDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityNewsDetailBinding nBinding = DataBindingUtil.setContentView(this, R.layout.activity_news_detail);
        Intent intent=getIntent();
        String url=intent.getStringExtra("url");
        nBinding.webView.setWebViewClient(new MyBrowser());
        nBinding.webView.getSettings().setLoadsImagesAutomatically(true);
        nBinding.webView.getSettings().setJavaScriptEnabled(true);
        nBinding.webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        nBinding.webView.loadUrl(url);
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
