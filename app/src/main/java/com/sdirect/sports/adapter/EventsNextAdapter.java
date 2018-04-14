package com.sdirect.sports.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.sdirect.sports.R;
import com.sdirect.sports.model.TeamEventsNext;
import java.util.ArrayList;

public class EventsNextAdapter extends RecyclerView.Adapter<EventsNextAdapter.MyViewHolder>  {

    private ArrayList<TeamEventsNext.Event> eventsList;



    @Override
    public EventsNextAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate( R.layout.event_next_single, parent, false);

        return new EventsNextAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final EventsNextAdapter.MyViewHolder holder, final int position) {
        holder.mHome.setText(eventsList.get(position).getStrHomeTeam());
        holder.mAway.setText(eventsList.get(position).getStrAwayTeam());
        if(eventsList.get(position).getStrDate()!=null) {
            holder.mDate.setText(eventsList.get(position).getStrDate());
        }else {
            holder.mDate.setText(eventsList.get(position).getStrdateEvent());
        }
        holder.mTime.setText(eventsList.get(position).getStrTime());
        holder.mSports.setText(eventsList.get(position).getStrSport()+" "+eventsList.get(position).getStrLeague());
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mHome,mAway,mDate,mTime,mSports;

        public MyViewHolder(View view) {
            super(view);
            mHome=view.findViewById(R.id.schedule_recycler_home);
            mAway=view.findViewById(R.id.schedule_recycler_away);
            mDate=view.findViewById(R.id.schedule_recycler_date);
            mTime=view.findViewById(R.id.schedule_recycler_time);
            mSports=view.findViewById(R.id.schedule_recycler_sportName);
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
