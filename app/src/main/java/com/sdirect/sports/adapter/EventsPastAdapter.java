package com.sdirect.sports.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sdirect.sports.R;
import com.sdirect.sports.model.TeamEventsNext;

import java.util.ArrayList;

public class EventsPastAdapter extends RecyclerView.Adapter<EventsPastAdapter.MyViewHolder>  {

    private ArrayList<TeamEventsNext.Event> eventsList;



    @Override
    public EventsPastAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate( R.layout.event_past_single, parent, false);

        return new EventsPastAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final EventsPastAdapter.MyViewHolder holder, final int position) {
        holder.mHome.setText(eventsList.get(position).getStrHomeTeam());
        holder.mAway.setText(eventsList.get(position).getStrAwayTeam());
        if(eventsList.get(position).getIntAwayScore()!=null){
            holder.mHomeScore.setText(eventsList.get(position).getIntHomeScore());
            holder.mAwayScore.setText(eventsList.get(position).getIntAwayScore());
        }else{
            holder.mNotFound.setText(R.string.result_not_found);
        }
        if(eventsList.get(position).getStrDate()!=null) {
            holder.mDate.setText(eventsList.get(position).getStrDate());
        }else {
            holder.mDate.setText(eventsList.get(position).getStrdateEvent());
        }
        holder.mTime.setText(eventsList.get(position).getStrTime());
        holder.mSports.setText(eventsList.get(position).getStrSport()+" "+eventsList.get(position).getStrLeague());
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mHome,mAway,mHomeScore,mAwayScore,mDate,mTime,mSports,mNotFound;

        public MyViewHolder(View view) {
            super(view);
            mHome=view.findViewById(R.id.result_recycler_home);
            mAway=view.findViewById(R.id.result_recycler_away);
            mHomeScore=view.findViewById(R.id.result_recycler_homescore);
            mAwayScore=view.findViewById(R.id.result_recycler_awayscore);
            mDate=view.findViewById(R.id.result_recycler_date);
            mTime=view.findViewById(R.id.result_recycler_time);
            mSports=view.findViewById(R.id.result_recycler_sportName);
            mNotFound=view.findViewById(R.id.result_recycler_notfound);
        }
    }

    @Override
    public int getItemCount() {
        return (eventsList==null) ? 0 : eventsList.size();
    }

    public void setDataList(ArrayList<TeamEventsNext.Event> eventsList){
        this.eventsList=eventsList;
        notifyDataSetChanged();
    }
}
