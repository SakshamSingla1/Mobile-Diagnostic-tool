package com.example.mdt;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Sound extends AppCompatActivity {
    private SeekBar seekBar;
    private AudioManager audioManager;
    private Button button;
    private MediaPlayer mediaPlayer;
    private boolean isPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);
        seekBar = findViewById(R.id.seekBar);
        audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
        seekBar.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        seekBar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        mediaPlayer = MediaPlayer.create(this, R.raw.music);
        isPlaying = false;
    }

    public void upButton(View view) {
        audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        seekBar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        Toast.makeText(this, "Volume Increasing", Toast.LENGTH_SHORT).show();
    }

    public void downButton(View view) {
        audioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND);
        seekBar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        Toast.makeText(this, "Volume Decreasing", Toast.LENGTH_SHORT).show();
    }

    public void playPause(View view) {
        if (isPlaying) {
            mediaPlayer.pause();
            isPlaying = false;
            Toast.makeText(this, "Music Paused", Toast.LENGTH_SHORT).show();
        } else {
            mediaPlayer.start();
            isPlaying = true;
            Toast.makeText(this, "Music Playing", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }
}
