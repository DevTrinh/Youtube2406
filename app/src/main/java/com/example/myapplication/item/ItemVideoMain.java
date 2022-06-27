package com.example.myapplication.item;

import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.MainActivity;
import com.example.myapplication.interfacee.InterfaceDefaultValue;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class ItemVideoMain implements Serializable, InterfaceDefaultValue {
    private String tvTitleVideo;
    private String ivVideo;
    private String idChannel;
    private String tvNameChannel;
    private String tvViewCount;
    private String tvTimeUp;
    private String idVideo;
    private String tvCommentCount;
    private String likeCount;
    private String avtChannel;
    private String subscriberNumber;

    public ItemVideoMain(String tvTitleVideo, String ivVideo, String idChannel,
                         String tvNameChannel, String tvViewCount, String tvTimeUp,
                         String idVideo, String tvCommentCount, String likeCount) {
        this.tvTitleVideo = tvTitleVideo;
        this.ivVideo = ivVideo;
        this.idChannel = idChannel;
        this.tvNameChannel = tvNameChannel;
        this.tvViewCount = tvViewCount;
        this.tvTimeUp = tvTimeUp;
        this.idVideo = idVideo;
        this.tvCommentCount = tvCommentCount;
        this.likeCount = likeCount;
    }


    public void setIdChannel(String idChannel) {
        this.idChannel = idChannel;
    }

    public String getAvtChannel() {
        return avtChannel;
    }

    public void setAvtChannel(String avtChannel) {
        this.avtChannel = avtChannel;
    }

    public String getSubscriberNumber() {
        return subscriberNumber;
    }

    public void setSubscriberNumber(String subscriberNumber) {
        this.subscriberNumber = subscriberNumber;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }

    public String getTvCommentCount() {
        return tvCommentCount;
    }

    public void setTvCommentCount(String tvCommentCount) {
        this.tvCommentCount = tvCommentCount;
    }

    public String getTvTitleVideo() {
        if (tvTitleVideo.length()>70){
            return tvTitleVideo+"...";
        }
        return tvTitleVideo;
    }

    public void setTvTitleVideo(String tvTitleVideo) {
        this.tvTitleVideo = tvTitleVideo;
    }

    public String getIvVideo() {
        return ivVideo;
    }

    public void setIvVideo(String ivVideo) {
        this.ivVideo = ivVideo;
    }

    public String getIdChannel() {
        return idChannel;
    }

    public void setIvAvtChannel(String idChannel) {
        this.idChannel = idChannel;
    }

    public String getTvNameChannel() {
        return tvNameChannel;
    }

    public void setTvNameChannel(String tvNameChannel) {
        this.tvNameChannel = tvNameChannel;
    }

    public String getTvViewCount() {
        return tvViewCount;
    }

    public void setTvViewCount(String tvViewCount) {
        this.tvViewCount = tvViewCount;
    }

    public String getTvTimeUp() {
        return tvTimeUp;
    }

    public void setTvTimeUp(String tvTimeUp) {
        this.tvTimeUp = tvTimeUp;
    }

    public String getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(String idVideo) {
        this.idVideo = idVideo;
    }
}
