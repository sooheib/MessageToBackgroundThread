package com.vivianaranha.messagetobackgroundthread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MyThread myThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//main thread
        Log.d("THREAD_NAME", Thread.currentThread().getName());

        myThread = new MyThread();
        myThread.start();
    }

    //background thread
    public void sendMessage(View view) {
        myThread.handler.post(new Runnable() {
            @Override
            public void run() {
                Log.d("THREAD_NAME", Thread.currentThread().getName());
            }
        });
    }

    class MyThread extends Thread {
        Handler handler;

        @Override
        public void run() {
            Looper.prepare();
            handler = new Handler();
            Looper.loop();
        }
    }
}
