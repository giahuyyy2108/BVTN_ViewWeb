package com.example.bvtnviewweb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ViewActivity extends AppCompatActivity {

    private WebView View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        View = (WebView) findViewById(R.id.WbView);
        View.setWebViewClient(new WebViewClient());
        View.loadUrl("http://"+UrlModel.murl);
        WebSettings websetting = View.getSettings();
        websetting.setJavaScriptEnabled(true);

    }
}