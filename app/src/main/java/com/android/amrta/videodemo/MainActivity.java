package com.android.amrta.videodemo;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    YouTubePlayerView mYouTubePlayer;

    String youtubeApi = "AIzaSyCM9fKxE8-lMMizoPhOU3Vzrs5IqzLToH8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mYouTubePlayer = (YouTubePlayerView) findViewById(R.id.youtube_player);

        String videoUrl = "https://www.youtube.com/watch?v=3G31PM279DA";
//        String videoUrl = "https://youtu.be/3G31PM279DA";
        Uri uri = Uri.parse(videoUrl);


        mYouTubePlayer.initialize(youtubeApi, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.MINIMAL);
                youTubePlayer.cueVideo("3G31PM279DA");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "onInitializationFailure | ");
            }
        });
    }
}
