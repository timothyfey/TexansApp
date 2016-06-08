package com.example.texansapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.timfey.texansapp.C0041R;

public class Roster extends Activity {
    private WebView webview;

    public class MyWebViewClient extends WebViewClient {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0041R.layout.activity_roster);
        this.webview = (WebView) findViewById(C0041R.id.myWebView);
        this.webview.getSettings().setJavaScriptEnabled(true);
        this.webview.loadUrl("http://m.houstontexans.com/s/30862/Roster?");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0041R.menu.texans, menu);
        return true;
    }
}
