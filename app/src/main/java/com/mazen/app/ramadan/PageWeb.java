package com.mazen.app.ramadan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class PageWeb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_web);

        AdView adView = (AdView) findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder() .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);

        WebView webView = (WebView)findViewById(R.id.web);
        Intent data = this.getIntent();
        int page = data.getExtras().getInt("page");
            page++;
        webView.loadUrl("file:///android_asset/html/"+page+".html");

    }
}
