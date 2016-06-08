package com.example.texansapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import org.timfey.texansapp.C0041R;

public class Texans extends Activity {

    /* renamed from: com.example.texansapp.Texans.1 */
    class C00321 implements OnClickListener {
        C00321() {
        }

        public void onClick(View v) {
            Texans.this.startActivityForResult(new Intent(v.getContext(), About.class), 0);
        }
    }

    /* renamed from: com.example.texansapp.Texans.2 */
    class C00332 implements OnClickListener {
        C00332() {
        }

        public void onClick(View v) {
            Texans.this.startActivityForResult(new Intent(v.getContext(), RSSReaderESPN.class), 0);
        }
    }

    /* renamed from: com.example.texansapp.Texans.3 */
    class C00343 implements OnClickListener {
        C00343() {
        }

        public void onClick(View v) {
            Texans.this.startActivityForResult(new Intent(v.getContext(), Roster.class), 0);
        }
    }

    /* renamed from: com.example.texansapp.Texans.4 */
    class C00354 implements OnClickListener {
        C00354() {
        }

        public void onClick(View v) {
            Texans.this.startActivityForResult(new Intent(v.getContext(), Schedule.class), 0);
        }
    }

    /* renamed from: com.example.texansapp.Texans.5 */
    class C00365 implements OnClickListener {
        C00365() {
        }

        public void onClick(View v) {
            Texans.this.startActivityForResult(new Intent(v.getContext(), RSSReaderNFLN.class), 0);
        }
    }

    /* renamed from: com.example.texansapp.Texans.6 */
    class C00376 implements OnClickListener {
        C00376() {
        }

        public void onClick(View v) {
            Texans.this.startActivityForResult(new Intent(v.getContext(), RSSReaderCHRON.class), 0);
        }
    }

    /* renamed from: com.example.texansapp.Texans.7 */
    class C00387 implements OnClickListener {
        C00387() {
        }

        public void onClick(View v) {
            Texans.this.startActivityForResult(new Intent(v.getContext(), RSSReaderTVideo.class), 0);
        }
    }

    /* renamed from: com.example.texansapp.Texans.8 */
    class C00398 implements OnClickListener {
        C00398() {
        }

        public void onClick(View v) {
            Texans.this.startActivityForResult(new Intent(v.getContext(), RSSReaderPFT.class), 0);
        }
    }

    /* renamed from: com.example.texansapp.Texans.9 */
    class C00409 implements OnClickListener {
        C00409() {
        }

        public void onClick(View v) {
            Texans.this.startActivityForResult(new Intent(v.getContext(), RSSReaderTPOD.class), 0);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0041R.layout.activity_texans);
        ((Button) findViewById(C0041R.id.about_button)).setOnClickListener(new C00321());
        ((Button) findViewById(C0041R.id.espn_button)).setOnClickListener(new C00332());
        ((Button) findViewById(C0041R.id.roster_button)).setOnClickListener(new C00343());
        ((Button) findViewById(C0041R.id.schedule_button)).setOnClickListener(new C00354());
        ((Button) findViewById(C0041R.id.nflnews_button)).setOnClickListener(new C00365());
        ((Button) findViewById(C0041R.id.chron_button)).setOnClickListener(new C00376());
        ((Button) findViewById(C0041R.id.texansvideo_button)).setOnClickListener(new C00387());
        ((Button) findViewById(C0041R.id.pft_button)).setOnClickListener(new C00398());
        ((Button) findViewById(C0041R.id.texanspod_button)).setOnClickListener(new C00409());
        ((Button) findViewById(C0041R.id.texansnews_button)).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Texans.this.startActivityForResult(new Intent(v.getContext(), RSSReaderTNEWS.class), 0);
            }
        });
        ((Button) findViewById(C0041R.id.khou_button)).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Texans.this.startActivityForResult(new Intent(v.getContext(), RSSReaderKHOU.class), 0);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0041R.menu.texans, menu);
        return true;
    }
}
