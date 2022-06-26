package com.example.myapplication.interfacee;

public interface InterfaceDefaultValue {
    String hihi= "";
    String jaha = "a";
//    String API_YOUTUBE_MAIN_VIDEO_VN = "https://youtube.googleapis.com/youtube/v3/videos?part=snippet%2CcontentDetails%2Cstatistics&chart=mostPopular&maxResults=50&regionCode=VN&key=AIzaSyDA2oRYCsTyVd6u5y1ypfda19b-fQZ_7VQ";
    String API_YOUTUBE_MAIN_VIDEO = "https://youtube.googleapis.com/youtube/v3/videos?part=id&part=liveStreamingDetails&part=snippet&part=statistics&chart=mostPopular&maxResults=50&key=AIzaSyDA2oRYCsTyVd6u5y1ypfda19b-fQZ_7VQ";
    String API_IMAGE_CHANNEL_YOUTUBE = "https://www.googleapis.com/youtube/v3/channels?part=snippet&id=UCwppdrjsBPAZg5_cUwQjfMQ&fields=items%2Fsnippet%2Fthumbnails&key=AIzaSyDA2oRYCsTyVd6u5y1ypfda19b-fQZ_7VQ";
//    String infovideo  ... https://youtube.googleapis.com/youtube/v3/commentThreads?part=snippet%2Creplies&maxResults=100&videoId=_VB39Jo8mAQ&key=AIzaSyDA2oRYCsTyVd6u5y1ypfda19b-fQZ_7VQ
    String API_KEY = "AIzaSyDA2oRYCsTyVd6u5y1ypfda19b-fQZ_7VQ";
    String ITEMS = "items";
    String ID = "id";
    String SNIPPET = "snippet";
    String THUMBNAIL = "thumbnails";
    String STANDARD = "standard";
    String CHANNEL_TITLE ="channelTitle";
    String VIEW_COUNT = "viewCount";
    String LIKED_COUNT = "likeCount";
    String URL = "url";
    String TITLE = "title";
    String PUBLISHED_AT = "publishedAt";
    String STATISTICS = "statistics";
    String VALUE_ITEM_VIDEO = "valueItemVideo";
    String COMMENT_COUNT = "commentCount";
    String CHANNEL_ID = "channelId";
}
