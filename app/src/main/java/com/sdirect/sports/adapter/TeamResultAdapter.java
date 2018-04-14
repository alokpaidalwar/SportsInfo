package com.sdirect.sports.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sdirect.sports.R;
import com.sdirect.sports.model.Results;
import com.sdirect.sports.model.TeamEventsNext;

import java.util.ArrayList;

public class TeamResultAdapter extends RecyclerView.Adapter<TeamResultAdapter.MyViewHolder>  {

    private ArrayList<Results.Result> resultsList;

    public TeamResultAdapter(ArrayList<Results.Result> resultsList) {
        this.resultsList = resultsList;
    }

    @Override
    public TeamResultAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate( R.layout.event_past_single, parent, false);

        return new TeamResultAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final TeamResultAdapter.MyViewHolder holder, final int position) {
        holder.mHome.setText(resultsList.get(position).getStrHomeTeam());
        holder.mAway.setText(resultsList.get(position).getStrAwayTeam());
        holder.mHomeScore.setText(resultsList.get(position).getIntHomeScore());
        holder.mAwayScore.setText(resultsList.get(position).getIntAwayScore());
        if(resultsList.get(position).getStrDate()!=null) {
            holder.mDate.setText(resultsList.get(position).getStrDate());
        }else {
            holder.mDate.setText(resultsList.get(position).getDateEvent());
        }
        holder.mTime.setText(resultsList.get(position).getStrTime());
        holder.mSports.setText(resultsList.get(position).getStrSport()+" "+resultsList.get(position).getStrLeague());
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mHome,mAway,mDate,mTime,mSports,mHomeScore,mAwayScore;

        public MyViewHolder(View view) {
            super(view);
            mHome=view.findViewById(R.id.result_recycler_home);
            mAway=view.findViewById(R.id.result_recycler_away);
            mDate=view.findViewById(R.id.result_recycler_date);
            mTime=view.findViewById(R.id.result_recycler_time);
            mSports=view.findViewById(R.id.result_recycler_sportName);
            mHomeScore=view.findViewById(R.id.result_recycler_homescore);
            mAwayScore=view.findViewById(R.id.result_recycler_awayscore);
        }
    }

    @Override
    public int getItemCount() {
        return resultsList.size();
    }

}
