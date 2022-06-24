package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.adapter.AdapterMainVideoYoutube;
import com.example.myapplication.interfacee.InterfaceDefaultValue;
import com.example.myapplication.item.ItemVideoMain;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity implements InterfaceDefaultValue {
    public static ArrayList<ItemVideoMain> listItemVideo = new ArrayList<>();
    private ImageView ivEndNavHome, ivEndNavExplore,
            ivEndNavSubscriptions, ivEndNavNotification, ivEndNavLibrary;
    public RecyclerView rvListVideoMain;
    public static AdapterMainVideoYoutube adapterMainVideoYoutube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        startActivity(new Intent(this, StarUp.class));
        Toast.makeText(this, "cay vai o", Toast.LENGTH_SHORT).show();
        mapping();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvListVideoMain.setLayoutManager(linearLayoutManager);
        adapterMainVideoYoutube = new AdapterMainVideoYoutube(listItemVideo);
        rvListVideoMain.setAdapter(adapterMainVideoYoutube);

        getJsonApiYoutube();

        Toast.makeText(MainActivity.this, listItemVideo.size() + "aaaaa", Toast.LENGTH_SHORT).show();

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

    private void getJsonApiYoutube() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                API_YOUTUBE_MAIN_VIDEO, null, new Response.Listener<JSONObject>() {
            @SuppressLint("NotifyDataSetChanged")
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonItems = response.getJSONArray(ITEMS);//items
                    String titleVideo = "";
                    String channelName = "";
                    String urlThumbnail = "";
                    String idVideo = "";
                    String viewCount = "";
                    String publishedAt = "";
//                    Toast.makeText(MainActivity.this, jsonItems.length()+"", Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < jsonItems.length(); i++) {
                        JSONObject jsonItem = jsonItems.getJSONObject(i);
                        idVideo = jsonItem.getString(ID);
//                        Toast.makeText(MainActivity.this, idVideo+"", Toast.LENGTH_SHORT).show();
                        JSONObject jsonSnippet = jsonItem.getJSONObject(SNIPPET);
                        titleVideo = jsonSnippet.getString(TITLE);
//                        Toast.makeText(MainActivity.this, titleVideo+"", Toast.LENGTH_SHORT).show();
                        publishedAt = formatTimeUpVideo(jsonSnippet.getString(PUBLISHED_AT)+"");
//                        Toast.makeText(MainActivity.this, publishedAt + "", Toast.LENGTH_SHORT).show();
                        JSONObject jsonThumbnail = jsonSnippet.getJSONObject(THUMBNAIL);
                        JSONObject jsonStandard = jsonThumbnail.getJSONObject("high");
                        urlThumbnail = jsonStandard.getString(URL);
//                        Toast.makeText(MainActivity.this, urlThumbnail+"", Toast.LENGTH_SHORT).show();
                        channelName = jsonSnippet.getString(CHANNEL_TITLE);
//                        Toast.makeText(MainActivity.this, channelName+"", Toast.LENGTH_SHORT).show();
                        JSONObject jsonStatistics = jsonItem.getJSONObject(STATISTICS);
                        viewCount = formatViewer(jsonStatistics.getInt(VIEW_COUNT));
//                        Toast.makeText(MainActivity.this, viewCount+"", Toast.LENGTH_SHORT).show();
                        listItemVideo.add(new ItemVideoMain(titleVideo,
                                urlThumbnail, urlThumbnail, channelName,
                                viewCount, publishedAt, idVideo));
                    }
                    adapterMainVideoYoutube.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error + "", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    public String formatViewer(int value) {
        String arr[] = {"", "K", "M", "B", "T", "P", "E"};
        int index = 0;
        while ((value / 1000) >= 1) {
            value = value / 1000;
            index++;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return String.format("%s %s Views", decimalFormat.format(value), arr[index]);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String formatTimeUpVideo(String time) {
        String timeEnd = java.time.Clock.systemUTC().instant().toString();
        String timeStart = time;
        Instant start = Instant.parse(timeStart);
        Instant end = Instant.parse(timeEnd);

        long duration = Duration.between(start, end).toMillis();
        long minutes = TimeUnit.MILLISECONDS.toMinutes(duration) * 60;

        int hour = (int) TimeUnit.MILLISECONDS.toHours(duration);
        int min = (int) (TimeUnit.MILLISECONDS.toMinutes(duration) - TimeUnit.MILLISECONDS.toHours(duration) * 60);
//        int second = (int) (TimeUnit.MILLISECONDS.toSeconds(duration) - minutes);
        String timeUp = "";
        if (hour > 8760) {
            timeUp = String.valueOf((hour / 8760) + " year ago");
        }
        if (hour > 720 && hour < 8760) {
            timeUp = String.valueOf((hour / 720) + " month ago");
        }
        if (hour > 168 && hour < 720) {
            timeUp = String.valueOf((hour / 168) + " week ago");
        }
        if (hour < 168 && hour > 24) {
            timeUp = String.valueOf((hour / 24) + " day ago");
        }
        if (hour > 1 && hour < 24) {
            timeUp = String.valueOf((hour) + " hour ago");
        }
        if (hour < 1) {
            timeUp = String.valueOf(min + "min ago");
        }
        return timeUp;
    }

    public void setDisplayEndNavOff() {
        ivEndNavExplore.setImageResource(R.drawable.ic_explore_off);
        ivEndNavHome.setImageResource(R.drawable.ic_home_off);
        ivEndNavSubscriptions.setImageResource(R.drawable.ic_subscrip_off);
        ivEndNavLibrary.setImageResource(R.drawable.ic_library_off);
        ivEndNavNotification.setImageResource(R.drawable.ic_notification_off);
    }

    public void mapping() {
        ivEndNavExplore = findViewById(R.id.iv_end_bar_explore);
        ivEndNavHome = findViewById(R.id.iv_end_bar_home);
        ivEndNavSubscriptions = findViewById(R.id.iv_end_bar_subscriptions);
        ivEndNavLibrary = findViewById(R.id.iv_end_bar_library);
        ivEndNavNotification = findViewById(R.id.iv_end_bar_notifications);

        rvListVideoMain = findViewById(R.id.rv_list_video_main);
    }
}