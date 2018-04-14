package com.sdirect.sports.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.sdirect.sports.R;
import com.sdirect.sports.activity.NewsDetailActivity;
import com.sdirect.sports.model.AllSports;
import com.sdirect.sports.model.News;
import com.yarolegovich.lovelydialog.LovelyInfoDialog;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    private ArrayList<News.Article> articleList;
    private Context mContext;

    public NewsAdapter(Context mContext,ArrayList<News.Article> articleList) {
        this.mContext=mContext;
        this.articleList =articleList;
    }

    @Override
    public NewsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate( R.layout.news_single, parent, false);

        return new NewsAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final NewsAdapter.MyViewHolder holder, final int position) {
        holder.mTitle.setText(articleList.get(position).getTitle());
        holder.mAuthor.setText(articleList.get(position).getAuthor());
        Glide.with(holder.mIcon.getContext())
                .load(articleList.get(position).getUrlToImage())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.mIcon);
        holder.mCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, NewsDetailActivity.class);
                intent.putExtra("url",articleList.get(position).getUrl());
                mContext.startActivity(intent);
            }
        });
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mTitle,mAuthor;
        ImageView mIcon;
        CardView mCardview;
        public MyViewHolder(View view) {
            super(view);
            mTitle=view.findViewById(R.id.news_title);
            mAuthor=view.findViewById(R.id.news_author);
            mIcon=view.findViewById(R.id.news_icon);
            mCardview=view.findViewById(R.id.news_cardview);
        }
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }


}
