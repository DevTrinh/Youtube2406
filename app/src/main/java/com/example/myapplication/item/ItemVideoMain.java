package com.example.myapplication.item;

public class ItemVideoMain {
    private String tvTitleVideo;
    private String ivVideo;
    private String ivAvtChannel;
    private String tvNameChannel;
    private String tvViewCount;
    private String tvTimeUp;
    private String idVideo;

    public ItemVideoMain(String tvTitleVideo, String ivVideo,
                         String ivAvtChannel, String tvNameChannel,
                         String tvViewCount, String tvTimeUp, String idVideo) {
        this.tvTitleVideo = tvTitleVideo;
        this.ivVideo = ivVideo;
        this.ivAvtChannel = ivAvtChannel;
        this.tvNameChannel = tvNameChannel;
        this.tvViewCount = tvViewCount;
        this.tvTimeUp = tvTimeUp;
        this.idVideo = idVideo;
    }

    public String getTvTitleVideo() {
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
