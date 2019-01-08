package com.example.mehed.youtubevideoapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import java.util.List;


public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    Context context;
    List<YouTube_Video>youTube_videoList;

    public VideoAdapter(List<YouTube_Video> youTube_videoList) { //VideoAdapter constructor create
        this.youTube_videoList = youTube_videoList;
    }



    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_view,viewGroup,false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder videoViewHolder, int i) {
        videoViewHolder.videoView.loadData(youTube_videoList.get(i).video_URL,"text/html","utf-8");

    }

    @Override
    public int getItemCount() {
        return youTube_videoList.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {
        WebView videoView;
        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView=itemView.findViewById(R.id.videoWebView);
            videoView.getSettings().setJavaScriptEnabled(true);
            videoView.setWebChromeClient(new WebChromeClient(){

            });

        }
    }
}
