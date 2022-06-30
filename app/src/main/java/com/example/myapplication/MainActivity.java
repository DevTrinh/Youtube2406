package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
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
import com.example.myapplication.fragment.FragmentExplore;
import com.example.myapplication.fragment.FragmentHome;
import com.example.myapplication.fragment.FragmentSubscription;
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
    FragmentManager fragmentManager = getSupportFragmentManager();
    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        startActivity(new Intent(this, StarUp.class));


        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentHome fragmentHome = new FragmentHome();
        //ADD FRAGMENT
        fragmentTransaction.add(R.id.cl_contains_fragment, fragmentHome);
        fragmentTransaction.commit();

        mapping();
    }

    public void onClickHome(@NonNull View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = null;
        switch (view.getId()){
            case R.id.iv_end_bar_home:
                setDisplayEndNavOff();
                ivEndNavHome.setImageResource(R.drawable.ic_home_on);
                fragment = new FragmentHome();
                fragmentTransaction.replace(R.id.cl_contains_fragment, fragment);
                fragmentTransaction.addToBackStack("fragmentHome");
                break;
            case R.id.iv_end_bar_explore:
                setDisplayEndNavOff();
                ivEndNavExplore.setImageResource(R.drawable.ic_explore_on);
                fragment = new FragmentExplore();
                fragmentTransaction.replace(R.id.cl_contains_fragment, fragment);
                fragmentTransaction.addToBackStack("fragmentExplore");
                break;
            case R.id.iv_end_bar_subscriptions:
                setDisplayEndNavOff();
                ivEndNavSubscriptions.setImageResource(R.drawable.ic_subscrip_on);
                fragment = new FragmentSubscription();
                fragmentTransaction.replace(R.id.cl_contains_fragment, fragment);
                fragmentTransaction.addToBackStack("fragmentSubscription");
                break;
            case R.id.iv_end_bar_notifications:
                setDisplayEndNavOff();
                ivEndNavNotification.setImageResource(R.drawable.ic_notification_on);

                break;
            case R.id.iv_end_bar_library:
                setDisplayEndNavOff();
                ivEndNavLibrary.setImageResource(R.drawable.ic_library_on);
                break;
        }
        fragmentTransaction.commit();
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