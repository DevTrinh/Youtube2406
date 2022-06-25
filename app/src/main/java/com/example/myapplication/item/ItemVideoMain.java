package com.example.myapplication.item;

import java.io.Serializable;

public class ItemVideoMain implements Serializable {
    private String tvTitleVideo;
    private String ivVideo;
    private String ivAvtChannel;
    private String tvNameChannel;
    private String tvViewCount;
    private String tvTimeUp;
    private String idVideo;

    private String likeCount;

    public ItemVideoMain(String tvTitleVideo, String ivVideo,
                         String ivAvtChannel, String tvNameChannel,
                         String tvViewCount, String tvTimeUp, String idVideo, String likeCount) {
        this.tvTitleVideo = tvTitleVideo;
        this.ivVideo = ivVideo;
        this.ivAvtChannel = ivAvtChannel;
        this.tvNameChannel = tvNameChannel;
        this.tvViewCount = tvViewCount;
        this.tvTimeUp = tvTimeUp;
        this.idVideo = idVideo;
        this.likeCount = likeCount;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
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

    public String getIvAvtChannel() {
        return ivAvtChannel;
    }

    public void setIvAvtChannel(String ivAvtChannel) {
        this.ivAvtChannel = ivAvtChannel;
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
