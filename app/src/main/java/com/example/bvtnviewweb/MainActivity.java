package com.example.bvtnviewweb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View = (WebView) findViewById(R.id.WbView);
        View.setWebViewClient(new WebViewClient());
        View.loadUrl("http://192.168.1.10:8081/client");
        WebSettings websetting = View.getSettings();
        websetting.setJavaScriptEnabled(true);

    }
}