package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.interfacee.InterfaceDefaultValue;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements InterfaceDefaultValue {

    private ImageView ivEndNavHome, ivEndNavExplore, ivEndNavSubscriptions, ivEndNavNotification, ivEndNavLibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        startActivity(new Intent(this, StarUp.class));

        mapping();

        getJsonApiYoutube();

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

    public void getJsonApiYoutube(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, API_YOUTUBE_MAIN_VIDEO, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
    }

    public void setDisplayEndNavOff(){
        ivEndNavExplore.setImageResource(R.drawable.ic_explore_off);
        ivEndNavHome.setImageResource(R.drawable.ic_home_off);
        ivEndNavSubscriptions.setImageResource(R.drawable.ic_subscrip_off);
        ivEndNavLibrary.setImageResource(R.drawable.ic_library_off);
        ivEndNavNotification.setImageResource(R.drawable.ic_notification_off);
    }

    public void mapping(){
        ivEndNavExplore = findViewById(R.id.iv_end_bar_explore);
        ivEndNavHome = findViewById(R.id.iv_end_bar_home);
        ivEndNavSubscriptions = findViewById(R.id.iv_end_bar_subscriptions);
        ivEndNavLibrary = findViewById(R.id.iv_end_bar_library);
        ivEndNavNotification = findViewById(R.id.iv_end_bar_notifications);
    }
}