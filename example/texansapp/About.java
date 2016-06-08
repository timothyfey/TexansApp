package com.example.texansapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import org.timfey.texansapp.C0041R;

public class About extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0041R.layout.about);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0041R.menu.texans, menu);
        return true;
    }
}
