package com.sdirect.sports.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.sdirect.sports.R;
import com.sdirect.sports.model.AllSports;
import com.yarolegovich.lovelydialog.LovelyInfoDialog;

import java.util.ArrayList;

public class AllSportsAdapter extends RecyclerView.Adapter<AllSportsAdapter.MyViewHolder> {

    private ArrayList<AllSports.Sport> sportsList;
    private Context mContext;

    public AllSportsAdapter(Context mContext,ArrayList<AllSports.Sport> sportsList) {
        this.mContext=mContext;
        this.sportsList =sportsList;
    }

    @Override
    public AllSportsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate( R.layout.allsports_single, parent, false);

        return new AllSportsAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AllSportsAdapter.MyViewHolder holder, final int position) {
        holder.mTitle.setText(sportsList.get(position).getStrSport());
        Glide.with(holder.mIcon.getContext())
                .load(sportsList.get(position).getStrSportThumb())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .into(holder.mIcon);
        holder.mDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LovelyInfoDialog(mContext)
                        .setTopColorRes(R.color.colorListBtnClick)
                        .setIcon(R.drawable.ic_info_outline_white_24dp)
                        .setTitle(sportsList.get(position).getStrSport())
                        .setMessage(sportsList.get(position).getStrSportDescription())
                        .show();
            }
        });
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mTitle;
        ImageView mIcon,mDescription;

        public MyViewHolder(View view) {
            super(view);
            mTitle=view.findViewById(R.id.allsport_title);
            mDescription=view.findViewById(R.id.allsport_details);
            mIcon=view.findViewById(R.id.allsport_icon);
        }
    }

    @Override
    public int getItemCount() {
        return sportsList.size();
    }


}
