package com.example.myapplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class demo {
    private void getJsonYoutube() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                InterfaceValueDefault.URL_JSON_API, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonItems = response.getJSONArray("items");
                            String titleVideo = "";
                            String urlThumbnail = "";
                            String idVideo = "";
                            String titleChanel= "";
                            for (int i = 0; i < jsonItems.length(); i++) {
                                JSONObject jsonItem = jsonItems.getJSONObject(i);
                                JSONObject jsonSnippet = jsonItem.getJSONObject("snippet");
                                titleVideo = jsonSnippet.getString("title");
                                titleChanel = jsonSnippet.getString("videoOwnerChannelTitle");
                                JSONObject jsonThumbnail = jsonSnippet.getJSONObject("thumbnails");
                                JSONObject jsonMedium = jsonThumbnail.getJSONObject("medium");
                                urlThumbnail = jsonMedium.getString("url");
//                                RESOURCE ID
                                JSONObject jsonResourceId = jsonSnippet.getJSONObject("resourceId");
                                idVideo = (String) jsonResourceId.get("videoId");
//                                 GET DATA
                                listItemVideo.add(new ItemVideoYoutube(titleVideo, urlThumbnail, idVideo ,titleChanel));
//                                Toast.makeText(ListVideoYoutube.this, idVideo+"",
//                                        Toast.LENGTH_SHORT).show();
                            }
                            adapterVideo.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}
