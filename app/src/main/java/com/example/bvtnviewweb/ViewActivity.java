package com.example.bvtnviewweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class ViewActivity extends AppCompatActivity {

    private WebView View;

    private static final  String TEXT = "text";

    private static final int TIME_INTERVAL = 2000;
    private long mBackPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        View = (WebView) findViewById(R.id.WbView);
        View.setWebViewClient(new WebViewClient());
//        View.loadUrl("http://"+UrlModel.murl);

        View.loadUrl("http://"+getSharedPreferences(MainActivity.SHARED_PREFS,MODE_PRIVATE).getString(TEXT,""));

        WebSettings websetting = View.getSettings();
        websetting.setJavaScriptEnabled(true);



    }


    @Override
    public void onBackPressed() {
        if(mBackPressed + TIME_INTERVAL > System.currentTimeMillis()){
            Intent intent = new Intent(ViewActivity.this, LoginActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(ViewActivity.this, "Tap back button in oder to exit", Toast.LENGTH_SHORT).show();
        }
        mBackPressed = System.currentTimeMillis();
    }
}