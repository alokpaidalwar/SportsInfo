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
import com.sdirect.sports.model.IgetTeamIdandName;

import java.util.ArrayList;

public class SearchedTeamAdapter extends RecyclerView.Adapter<SearchedTeamAdapter.MyViewHolder> {

    private ArrayList<AllTeamsInLeague.Team> teamsList;
    private IgetTeamIdandName igetTeamIdandName;

    public SearchedTeamAdapter(ArrayList<AllTeamsInLeague.Team> teamsList) {
        this.teamsList = teamsList;
    }

    @Override
    public SearchedTeamAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate( R.layout.search_team_single, parent, false);
        return new SearchedTeamAdapter .MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final SearchedTeamAdapter.MyViewHolder holder, final int position) {
        holder.mName.setText(teamsList.get(position).getStrTeam());
        holder.mStadium.setText(teamsList.get(position).getStrStadium());
        holder.mYear.setText(teamsList.get(position).getIntFormedYear());

        Glide.with(holder.mLogo.getContext())
                .load(teamsList.get(position).getStrTeamBanner())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .into(holder.mLogo);
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                igetTeamIdandName.onTeamIdandName(teamsList.get(position).getIdTeam(),teamsList.get(position).getStrTeam());
            }
        });

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mName,mStadium,mYear;
        ImageView mLogo;
        CardView mCardView;

        public MyViewHolder(View view) {
            super(view);
            mName=view.findViewById(R.id.searchteam_name);
            mStadium=view.findViewById(R.id.searchteam_stadium);
            mYear=view.findViewById(R.id.searchteam_year);
            mLogo=view.findViewById(R.id.searchteam_logo);
            mCardView=view.findViewById(R.id.searchteam_cardview);
        }
    }

    @Override
    public int getItemCount() {
        return teamsList.size();
    }

    public void setOnItemSelected(IgetTeamIdandName igetTeamIdandName)
    {
        this.igetTeamIdandName = igetTeamIdandName;
    }
}
