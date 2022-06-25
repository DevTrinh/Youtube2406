package com.example.myapplication;

import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.interfacee.InterfaceDefaultValue;
import com.example.myapplication.item.ItemVideoMain;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class ActivityPlayVideo extends YouTubeBaseActivity
        implements YouTubePlayer.OnInitializedListener, InterfaceDefaultValue {
    YouTubePlayerView ypViewPlay;
    TextView tvTitleVideo, tvTimeUp, tvCountViews, tvCountLiked;
    private String id = "";
    private String countLike = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);

        Toast.makeText(this, "PlayVideo", Toast.LENGTH_SHORT).show();
        mapping();

        Intent getDataInMain = getIntent();
        ItemVideoMain itemData = (ItemVideoMain) getDataInMain.getSerializableExtra(VALUE_ITEM_VIDEO);
        Toast.makeText(this, itemData.getTvTitleVideo()+"", Toast.LENGTH_SHORT).show();
        id = itemData.getIdVideo();
        tvTimeUp.setText(itemData.getTvTimeUp());
        tvTitleVideo.setText(itemData.getTvTitleVideo());
        tvCountViews.setText(itemData.getTvViewCount());
        tvCountLiked.setText(itemData.getLikeCount());
        ypViewPlay.initialize(API_KEY, this);
    }

    public void mapping(){
        tvCountLiked = findViewById(R.id.tv_like_toolbar);
        tvCountViews = findViewById(R.id.tv_play_video_count_viewer);
        tvTitleVideo = findViewById(R.id.tv_title_video_play);
        tvTimeUp = findViewById(R.id.tv_play_video_count_time);
        ypViewPlay = findViewById(R.id.yp_video_main);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                        @NonNull YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.loadVideo(id);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this,youTubeInitializationResult+ "", Toast.LENGTH_SHORT).show();
    }
}