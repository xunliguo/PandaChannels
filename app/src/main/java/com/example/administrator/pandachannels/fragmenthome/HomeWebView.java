package com.example.administrator.pandachannels.fragmenthome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.pandachannels.R;

public class HomeWebView extends AppCompatActivity {

    private ImageView hometui;
    private TextView homeTextname;
    private ImageView homefenx;
    private WebView homeWebvi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_web_view);
        initView();
    }

    private void initView() {
        hometui = (ImageView) findViewById(R.id.hometui);
        homeTextname = (TextView) findViewById(R.id.homeTextname);
        homefenx = (ImageView) findViewById(R.id.homefenx);
        homeWebvi = (WebView) findViewById(R.id.homeWebvi);

        String homename = getIntent().getStringExtra("homename");
        String homeurl = getIntent().getStringExtra("homeurl");
        homeTextname.setText(homename);
        hometui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        WebView webView = new WebView(HomeWebView.this);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setDefaultTextEncodingName("utf-8");
        //  webView.loadUrl("file:///android_asset/jstest.html");
        webView.loadUrl(homeurl);
        setContentView(webView);

    }


}
