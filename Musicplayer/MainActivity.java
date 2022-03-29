package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.security.acl.NotOwnerException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageButton play;
    TextView title;
    NotificationManager notificationManager;
    List<Track> trackList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateTracks();

        play = findViewById(R.id.play);
        title =findViewById(R.id.title);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            createChannel();
        }
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateNofitication.createNotification(MainActivity.this,trackList.get(1),R.drawable.ic_baseline_pause_24,1,trackList.size() -1);
            }
        });

    }

    private void createChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(CreateNofitication.CHANNEL_ID,"Mymusic", NotificationManager.IMPORTANCE_LOW);

            notificationManager = getSystemService(NotificationManager.class);
            if(notificationManager != null){
                notificationManager.createNotificationChannel(channel);
            }

        }
    }

    // populate list with tracks:
    private  void populateTracks(){
        trackList  = new ArrayList<>();

        trackList.add(new Track("Track 1","Artist 1",R.drawable.bg1));
        trackList.add(new Track("Track 2","Artist 2",R.drawable.bg2));
        trackList.add(new Track("Track 3","Artist 3",R.drawable.bg3));
        trackList.add(new Track("Track 4","Artist 4",R.drawable.bg4));

    }
}