package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.myapplication.adapter.AdapterListHotKeys;
import com.example.myapplication.adapter.AdapterMainVideoYoutube;
import com.example.myapplication.fragment.FragmentHome;
import com.example.myapplication.interfacee.InterfaceDefaultValue;
import com.example.myapplication.item.ItemVideoMain;
import com.google.android.youtube.player.YouTubeThumbnailLoader;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements InterfaceDefaultValue, YouTubeThumbnailLoader {
    public static ArrayList<ItemVideoMain> listItemVideo = new ArrayList<>();
    private ImageView ivEndNavHome, ivEndNavExplore,
            ivEndNavSubscriptions, ivEndNavNotification, ivEndNavLibrary;
    private ProgressBar pbLoadListVideoMain;
    public RecyclerView rvListVideoMain, rvListHotKeys;
    public static AdapterMainVideoYoutube adapterMainVideoYoutube;
    public static AdapterListHotKeys adapterListHotKeys;
    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        startActivity(new Intent(this, StarUp.class));

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentHome fragmentHome = new FragmentHome();
        //ADD FRAGMENT
        fragmentTransaction.add(R.id.cl_contains_fragment, fragmentHome);
        fragmentTransaction.commit();

        mapping();




        ivEndNavHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDisplayEndNavOff();
                ivEndNavHome.setImageResource(R.drawable.ic_home_on);
            }
        });
        ivEndNavExplore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDisplayEndNavOff();
                ivEndNavExplore.setImageResource(R.drawable.ic_explore_on);
            }
        });

        ivEndNavSubscriptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDisplayEndNavOff();
                ivEndNavSubscriptions.setImageResource(R.drawable.ic_subscrip_on);
            }
        });

        ivEndNavNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDisplayEndNavOff();
                ivEndNavNotification.setImageResource(R.drawable.ic_notification_on);
            }
        });

        ivEndNavLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDisplayEndNavOff();
                ivEndNavLibrary.setImageResource(R.drawable.ic_library_on);
            }
        });
    }


    public void setDisplayEndNavOff() {
        ivEndNavExplore.setImageResource(R.drawable.ic_explore_off);
        ivEndNavHome.setImageResource(R.drawable.ic_home_off);
        ivEndNavSubscriptions.setImageResource(R.drawable.ic_subscrip_off);
        ivEndNavLibrary.setImageResource(R.drawable.ic_library_off);
        ivEndNavNotification.setImageResource(R.drawable.ic_notification_off);
    }

    @SuppressLint("WrongViewCast")
    public void mapping() {
        pbLoadListVideoMain = findViewById(R.id.pb_load_list_video_main);
        ivEndNavExplore = findViewById(R.id.iv_end_bar_explore);
        ivEndNavHome = findViewById(R.id.iv_end_bar_home);
        ivEndNavSubscriptions = findViewById(R.id.iv_end_bar_subscriptions);
        ivEndNavLibrary = findViewById(R.id.iv_end_bar_library);
        ivEndNavNotification = findViewById(R.id.iv_end_bar_notifications);
        rvListHotKeys = findViewById(R.id.lv_hot_keywords);
        rvListVideoMain = findViewById(R.id.rv_list_video_main);
    }

    @Override
    public void setOnThumbnailLoadedListener(OnThumbnailLoadedListener onThumbnailLoadedListener) {

    }

    @Override
    public void setVideo(String s) {

    }

    @Override
    public void setPlaylist(String s) {

    }

    @Override
    public void setPlaylist(String s, int i) {

    }

    @Override
    public void next() {

    }

    @Override
    public void previous() {

    }

    @Override
    public void first() {

    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public void release() {

    }
}