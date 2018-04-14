package com.sdirect.sports.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.sdirect.sports.R;
import com.sdirect.sports.model.AllPlayers;
import com.yarolegovich.lovelydialog.LovelyCustomDialog;
import com.yarolegovich.lovelydialog.LovelyInfoDialog;

import java.util.ArrayList;

public class AllPlayersInTeamAdapter extends RecyclerView.Adapter<AllPlayersInTeamAdapter.MyViewHolder> {

    private ArrayList<AllPlayers.Player> playersList;
    private Context mContext;

    public AllPlayersInTeamAdapter(Context mContext, ArrayList<AllPlayers.Player> playersList) {
        this.mContext=mContext;
        this.playersList = playersList;
    }

    @Override
    public AllPlayersInTeamAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.allplayersinteam_single, parent, false);
        return new AllPlayersInTeamAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AllPlayersInTeamAdapter.MyViewHolder holder, final int position) {
      holder.mName.setText(playersList.get(position).getStrPlayer());
        holder.mCountry.setText(playersList.get(position).getStrNationality());
        holder.mPosition.setText(playersList.get(position).getStrPosition());
        if(playersList.get(position).getStrCutout()!=null){
            Glide.with(holder.mLogo.getContext())
                    .load(playersList.get(position).getStrCutout())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .override(300,300)
                    .fitCenter()
                    .into(holder.mLogo);
        }else {
            Glide.with(holder.mLogo.getContext())
                    .load(R.drawable.footballplayer)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .override(300, 300)
                    .fitCenter()
                    .into(holder.mLogo);
        }

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view=LayoutInflater.from(mContext)
                        .inflate(R.layout.custom_info_dialog,null,false);
                TextView message=view.findViewById(R.id.custominfo_message);
                ImageView image=view.findViewById(R.id.custominfo_img);
                message.setText(playersList.get(position).getStrDescriptionEN());
                Glide.with(mContext)
                        .load(playersList.get(position).getStrFanart1())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .fitCenter()
                        .into(image);
                new LovelyCustomDialog(mContext)
                        .setTopColorRes(R.color.colorListBtnClick)
                        .setIcon(R.drawable.ic_info_outline_white_24dp)
                        .setView(view)
                        .setCancelable(true)
                        .setListener(R.id.custominfo_ll, true, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        })
                        .show();
            }
        });
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mName, mCountry,mPosition;
        ImageView mLogo;
        CardView mCardView;

        public MyViewHolder(View view) {
            super(view);
            mName=view.findViewById(R.id.allplayersinteam_name);
            mCountry =view.findViewById(R.id.allplayersinteam_country);
            mPosition=view.findViewById(R.id.allplayersinteam_position);
            mLogo=view.findViewById(R.id.allplayersinteam_logo);
            mCardView=view.findViewById(R.id.allplayersinteam_card);
        }
    }

    @Override
    public int getItemCount() {
        return playersList.size();
    }

}
