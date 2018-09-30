package com.example.truel.ducktype3;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;


public class BackgroundMusicFail extends Service {
    private MediaPlayer player;
    public IBinder onBind(Intent arg0) {

        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this, R.raw.fire_background);
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        player.setLooping(true);
        player.setVolume(100,100);


    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return Service.START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        player.stop();
        player.release();
    }


}