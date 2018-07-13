package com.example.murtaza.robo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
WebView wv,wv2,wv3;
    Button fw,bw,l,r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wv3= (WebView) findViewById(R.id.wv3);
        wv2=new WebView(this);
        wv= new WebView(this);
        fw= (Button) findViewById(R.id.fd);
        bw= (Button) findViewById(R.id.bw);
        l= (Button) findViewById(R.id.l);
        r= (Button) findViewById(R.id.r);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new MyBrowser());

        wv2.getSettings().setJavaScriptEnabled(true);
        wv2.setWebViewClient(new MyBrowser());
        wv3.loadUrl("http://192.168.43.94:8081");
        fw.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                wv.loadUrl("http://192.168.43.94/forward.php");

            } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {

                wv.loadUrl("http://192.168.43.94/forwardstop.php");
            }
            return false;
        }
    });
    bw.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                wv.loadUrl("http://192.168.43.94/backward.php");
            } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                wv.loadUrl("http://192.168.43.94/backwardstop.php");
            }
            return false;
        }
    });

    l.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                wv.loadUrl("http://192.168.43.94/left.php");
            } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                wv.loadUrl("http://192.168.43.94/backwardstop.php");
            }
            return false;
        }
    });

    r.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {

                wv.loadUrl("http://192.168.43.94/right.php");
            }  if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                wv.loadUrl("http://192.168.43.94/backwardstop.php");

            }
            return false;
        }
    });
    }
    

    private class MyBrowser extends WebViewClient {
        @SuppressWarnings("Deprecation")
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, url);
        }
    }


}
