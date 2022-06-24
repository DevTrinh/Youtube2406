package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.item.ItemVideoMain;
import com.google.android.youtube.player.YouTubeThumbnailView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterMainVideoYoutube extends
        RecyclerView.Adapter<AdapterMainVideoYoutube.ItemVideoMainViewHolder> {

    private ArrayList<ItemVideoMain> listItemVideoMain;

    public AdapterMainVideoYoutube(ArrayList<ItemVideoMain> listItemVideoMain) {
        this.listItemVideoMain = listItemVideoMain;
    }

    @NonNull
    @Override
    public ItemVideoMainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_main_video, parent, false);
        return new ItemVideoMainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemVideoMainViewHolder holder, int position) {
        ItemVideoMain itemVideoMain = listItemVideoMain.get(position);
        if (itemVideoMain == null) {
            return;
        }
        holder.tvTitleMainItem.setText(itemVideoMain.getTvTitleVideo());
        holder.tvTimeUp.setText(itemVideoMain.getTvTimeUp());
        holder.tvNameChannel.setText(itemVideoMain.getTvNameChannel());
        holder.tvViewer.setText(itemVideoMain.getTvViewCount());
//        Picasso.get().load(item.getThumbnail()).into(holder.ivThumbnail);
        Picasso.get().load(itemVideoMain.getIvAvtChannel()).into(holder.ivAvtChannel);
        Picasso.get().load(itemVideoMain.getIvVideo()).into(holder.youTubeThumbnailView);
    }

    @Override
    public int getItemCount() {
        if (listItemVideoMain == null){
            return 0;
        }
        return listItemVideoMain.size();
    }

    public class ItemVideoMainViewHolder extends RecyclerView.ViewHolder{
        YouTubeThumbnailView youTubeThumbnailView;
        ImageView ivAvtChannel;
        TextView tvTitleMainItem, tvNameChannel, tvViewer, tvTimeUp;

        public ItemVideoMainViewHolder(@NonNull View itemView) {
            super(itemView);
            mapping(itemView);
        }

        public void mapping(@NonNull View view){
            youTubeThumbnailView = view.findViewById(R.id.iv_item_main_video);
            ivAvtChannel = view.findViewById(R.id.iv_item_main_avt_video);
            tvNameChannel = view.findViewById(R.id.tv_item_main_name_channel);
            tvTimeUp = view.findViewById(R.id.tv_item_main_time_up);
            tvTitleMainItem = view.findViewById(R.id.tv_item_main_title_video);
            tvViewer = view.findViewById(R.id.tv_item_main_view_count);
        }
    }
}
