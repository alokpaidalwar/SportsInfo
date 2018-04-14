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
import com.sdirect.sports.model.AllTeamsInLeague;
import com.sdirect.sports.model.IgetTeamId;
import com.sdirect.sports.model.ScoreDetailsTeamInLeague;

import java.util.ArrayList;

public class AllTeamsInLeagueAdapter extends RecyclerView.Adapter<AllTeamsInLeagueAdapter.MyViewHolder> {

    private ArrayList<AllTeamsInLeague.Team> teamsList;
    private ArrayList<ScoreDetailsTeamInLeague.Table> scoreList;
    private Context mContext;
    private IgetTeamId igetTeamId;

    public AllTeamsInLeagueAdapter(Context mContext, ArrayList<AllTeamsInLeague.Team> teamsList,
                                   ArrayList<ScoreDetailsTeamInLeague.Table> scoreList) {
        this.mContext=mContext;
        this.teamsList = teamsList;
        this.scoreList=scoreList;
    }

    @Override
    public AllTeamsInLeagueAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate( R.layout.allteamsinleague_single, parent, false);
        return new AllTeamsInLeagueAdapter .MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AllTeamsInLeagueAdapter.MyViewHolder holder, final int position) {
        holder.mName.setText(teamsList.get(position).getStrTeam());
        holder.mStadium.setText(teamsList.get(position).getStrStadium());
        holder.mYear.setText(teamsList.get(position).getIntFormedYear());
        holder.mPlayed.setText(scoreList.get(position).getPlayed().toString());
        holder.mWin.setText(scoreList.get(position).getWin().toString());
        holder.mLoss.setText(scoreList.get(position).getLoss().toString());
        holder.mDraw.setText(scoreList.get(position).getDraw().toString());
        Glide.with(holder.mLogo.getContext())
                .load(teamsList.get(position).getStrTeamBanner())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .into(holder.mLogo);
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    igetTeamId.onTeamIdSelected(teamsList.get(position).getIdTeam());
            }
        });

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mName,mStadium,mYear,mPlayed,mWin,mLoss,mDraw;
        ImageView mLogo;
        CardView mCardView;

        public MyViewHolder(View view) {
            super(view);
            mName=view.findViewById(R.id.allteamsinleague_name);
            mStadium=view.findViewById(R.id.allteamsinleague_stadium);
            mYear=view.findViewById(R.id.allteamsinleague_year);
            mLogo=view.findViewById(R.id.allteamsinleague_logo);
            mPlayed=view.findViewById(R.id.allteamsinleague_played);
            mWin=view.findViewById(R.id.allteamsinleague_win);
            mLoss=view.findViewById(R.id.allteamsinleague_loss);
            mDraw=view.findViewById(R.id.allteamsinleague_draw);
            mCardView=view.findViewById(R.id.allteamsinleague_cardview);
        }
    }

    @Override
    public int getItemCount() {
        return teamsList.size();
    }

    public void setOnItemSelected(IgetTeamId igetTeamId)
    {
        this.igetTeamId = igetTeamId;
    }
}