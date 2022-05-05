package com.example.mutithreadexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1;
    TextView text2;
    Handler handler1;
    Handler handler2;
    int i;
    int j;
    private final String NAME="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.txt1);
        text2 = findViewById(R.id.txt2);
         handler1 = new Handler();
         handler2 = new Handler();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                for(i=1; i<100;i++){
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler1.post(new Runnable() {
                        @Override
                        public void run() {
                            if(i==100){
                                text1.setText("Downloaded");
                            }
                            else{
                                text1.setText("Downloading  "+i+" %");
                            }

                        }
                    });

                    //Log.d(NAME,"i: "+i);
                }

            }
        };
        thread1.start();

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                for(j=1; j<100;j++){
                    try {
                        sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler2.post(new Runnable() {
                        @Override
                        public void run() {
                            if(j==100){
                                text2.setText("Downloaded");
                            }
                            else{
                                text2.setText("Downloading  "+ j +" %");
                            }

                        }
                    });
                   //Log.d(NAME,"j: "+j);
                }

            }
        };
        thread2.start();
    }
}