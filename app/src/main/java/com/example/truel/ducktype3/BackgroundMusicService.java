package com.example.truel.ducktype3;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;


public class BackgroundMusicService extends Service {
    MediaPlayer player;
    int player_length;
    public IBinder onBind(Intent arg0) {

        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();


        player = MediaPlayer.create(this, R.raw.background_music);
        player.setLooping(true);
        player.setVolume(100,100);
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);

    }


    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return Service.START_NOT_STICKY;
    }

    public void Pause() {
        player.pause();
        player_length = player.getCurrentPosition();
    }

    public void Resume() {
        player.seekTo(player_length);
        player.start();
    }

    @Override
    public void onDestroy() {
        player.stop();
        player.release();
    }

}