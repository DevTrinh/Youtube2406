package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.adapter.AdapterMainVideoYoutube;
import com.example.myapplication.interfacee.InterfaceClickItemMainVideo;
import com.example.myapplication.interfacee.InterfaceDefaultValue;
import com.example.myapplication.item.ItemVideoMain;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.squareup.picasso.Picasso;

public class ActivityPlayVideo extends YouTubeBaseActivity
        implements YouTubePlayer.OnInitializedListener, InterfaceDefaultValue {

    YouTubePlayerView ypViewPlay;
    TextView tvTitleVideo, tvTimeUp, tvCountViews, tvCountLiked, tvNameChannel,
    tvNumberSubscriber, tvSubscribe, tvNumberComment, tvSubscribed;
    ImageView ivLiked, ivDisliked, ivShare, ivDownload, ivSave, ivAvtChannel;
    RecyclerView rvListVideoPlay;
    AdapterMainVideoYoutube adapterListVideoYoutube = MainActivity.adapterMainVideoYoutube;
    YouTubePlayer ypPlayItemClick;
    ImageView ivOpenDescription;
    CheckBox cbNotificationChannel;

    private boolean numberLikeCheck = true;
    private String id = "";
    private String idPlayListInItemVideo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);

        FragmentManager fragmentManager = getFragmentManager();

        mapping();
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        testDisplayTvSubscribe();
        Intent getDataInMain = getIntent();
        ItemVideoMain itemData = (ItemVideoMain) getDataInMain.getSerializableExtra(VALUE_ITEM_VIDEO);

//        Toast.makeText(this, itemData.getTvTitleVideo()+"", Toast.LENGTH_SHORT).show();
        id = itemData.getIdVideo();
        tvTimeUp.setText(itemData.getTvTimeUp());
        tvTitleVideo.setText(itemData.getTvTitleVideo());
        tvCountViews.setText(itemData.getTvViewCount());
        tvCountLiked.setText(itemData.getLikeCount());
        tvNumberComment.setText(itemData.getTvCommentCount());
        tvNameChannel.setText(itemData.getTvNameChannel());
        tvNumberSubscriber.setText(itemData.getNumberSubscribe());
//        Toast.makeText(this, itemData.getIvVideo()+"", Toast.LENGTH_SHORT).show();
        Picasso.get().load(itemData.getIvVideo()).into(ivAvtChannel);

        ypViewPlay.initialize(API_KEY, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvListVideoPlay.setLayoutManager(linearLayoutManager);
        adapterListVideoYoutube = new AdapterMainVideoYoutube(MainActivity.listItemVideo, new InterfaceClickItemMainVideo() {
            @Override
            public void onClickItemMainVideo(int position) {
                idPlayListInItemVideo = MainActivity.listItemVideo.get(position).getIdVideo();
                tvTimeUp.setText(MainActivity.listItemVideo.get(position).getTvTimeUp());
                tvTitleVideo.setText(MainActivity.listItemVideo.get(position).getTvTitleVideo());
                tvCountViews.setText(MainActivity.listItemVideo.get(position).getTvViewCount());
                tvCountLiked.setText(MainActivity.listItemVideo.get(position).getLikeCount());
                tvNumberComment.setText(MainActivity.listItemVideo.get(position).getTvCommentCount());
                tvNameChannel.setText(MainActivity.listItemVideo.get(position).getTvNameChannel());
//        Toast.makeText(this, MainActivity.listItemVideo.get(position).getIvVideo()+"", Toast.LENGTH_SHORT).show();
                Picasso.get().load(MainActivity.listItemVideo.get(position).getIvVideo()).into(ivAvtChannel);
                ypPlayItemClick.loadVideo(idPlayListInItemVideo);
                Toast.makeText(ActivityPlayVideo.this, idPlayListInItemVideo+"", Toast.LENGTH_SHORT).show();
            }
        });
        rvListVideoPlay.setAdapter(adapterListVideoYoutube);

//        ivOpenDescription.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                FragmentDescription fragmentDescription = new FragmentDescription();
//                fragmentTransaction.add(R.id.sv_description, fragmentDescription);
//                fragmentTransaction.commit();
//            }
//        });



        ivLiked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberLikeCheck){
                    ivLiked.setImageResource(R.drawable.ic_like_on);
                    ivDisliked.setImageResource(R.drawable.ic_dislike);
                    numberLikeCheck = false;
                }
                else{
                    ivLiked.setImageResource(R.drawable.ic_like);
                    numberLikeCheck = true;
                }
            }
        });

        ivDisliked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberLikeCheck == false){
                    ivDisliked.setImageResource(R.drawable.ic_dislike_on);
                    ivLiked.setImageResource(R.drawable.ic_like);
                    numberLikeCheck = true;
                }
                else{
                    ivDisliked.setImageResource(R.drawable.ic_dislike);
                    ivLiked.setImageResource(R.drawable.ic_like);
                    numberLikeCheck = false;
                }
            }
        });

        tvSubscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSubscribe.setVisibility(View.GONE);
                tvSubscribed.setVisibility(View.VISIBLE);
                cbNotificationChannel.setVisibility(View.VISIBLE);
            }
        });

        tvSubscribed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.setMessage("Unsubscribe from pike channel ?");
                alertDialog.setPositiveButton("UNSUBSCRIBE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvSubscribe.setVisibility(View.VISIBLE);
                        tvSubscribed.setVisibility(View.GONE);
                        cbNotificationChannel.setVisibility(View.GONE);
                    }
                });
                alertDialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();
            }
        });
    }

    public void testDisplayTvSubscribe(){
        if (tvSubscribe.getVisibility() == View.VISIBLE){
            tvSubscribed.setVisibility(View.GONE);
            cbNotificationChannel.setVisibility(View.GONE);
        }
        else{
            tvSubscribed.setVisibility(View.VISIBLE);
            tvSubscribe.setVisibility(View.GONE);
            cbNotificationChannel.setVisibility(View.VISIBLE);
        }
    }

    public void mapping(){
        tvSubscribe = findViewById(R.id.tv_play_video_subscribe);
        tvCountLiked = findViewById(R.id.tv_like_toolbar);
        tvCountViews = findViewById(R.id.tv_play_video_count_viewer);
        tvTitleVideo = findViewById(R.id.tv_title_video_play);
        tvTimeUp = findViewById(R.id.tv_play_video_count_time);
        tvNameChannel = findViewById(R.id.tv_play_item_name_channel);
        tvNumberSubscriber = findViewById(R.id.tv_play_item_count_subscribe);
        tvNumberComment = findViewById(R.id.tv_number_comment);
        tvSubscribed = findViewById(R.id.tv_play_video_subscribed);
        ivAvtChannel = findViewById(R.id.iv_avt_channel_play);
        ivLiked = findViewById(R.id.iv_ic_like_play_video);
        ivDisliked = findViewById(R.id.iv_ic_dislike_play_video);
        ivOpenDescription = findViewById(R.id.iv_icon_down_description);
        cbNotificationChannel = findViewById(R.id.cb_on_notification_channel);
        rvListVideoPlay = findViewById(R.id.rv_list_play_video);
        ypViewPlay = findViewById(R.id.yp_video_main);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                        @NonNull YouTubePlayer youTubePlayer, boolean b) {
        ypPlayItemClick = youTubePlayer;
        ypPlayItemClick.loadVideo(id);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this,youTubeInitializationResult+ " LOI ROI CU", Toast.LENGTH_SHORT).show();
    }
}