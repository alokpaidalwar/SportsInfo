package com.sdirect.sports.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sdirect.sports.R;
import com.sdirect.sports.model.AllLeagues;
import com.sdirect.sports.model.IgetLeagueId;
import com.sdirect.sports.model.IgetLeagueIdandName;

import java.util.ArrayList;

public class SearchedLeagueAdapter extends RecyclerView.Adapter<SearchedLeagueAdapter.MyViewHolder> {

    private ArrayList<AllLeagues.League> leagueList;
    private IgetLeagueIdandName igetLeagueIdandName;

    public SearchedLeagueAdapter(ArrayList<AllLeagues.League> leagueList) {
        this.leagueList = leagueList;
    }

    @Override
    public SearchedLeagueAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate( R.layout.search_league_single, parent, false);
        return new SearchedLeagueAdapter .MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final SearchedLeagueAdapter.MyViewHolder holder, final int position) {
        holder.mName.setText(leagueList.get(position).getStrLeague());
        holder.mSport.setText(leagueList.get(position).getStrSport());
        holder.mAlt.setText(leagueList.get(position).getStrLeagueAlternate());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                igetLeagueIdandName.onLeagueIdandName(leagueList.get(position).getIdLeague(),
                        leagueList.get(position).getStrLeague());
            }
        });

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mName,mSport,mAlt;
        CardView mCardView;

        public MyViewHolder(View view) {
            super(view);
            mName=view.findViewById(R.id.searchleague_name);
            mSport=view.findViewById(R.id.searchleague_sport);
            mAlt=view.findViewById(R.id.searchleague_alternate);
            mCardView=view.findViewById(R.id.searchleague_cardview);
        }
    }

    @Override
    public int getItemCount() {
        return leagueList.size();
    }

    public void setOnItemSelected(IgetLeagueIdandName igetLeagueIdandName)
    {
        this.igetLeagueIdandName = igetLeagueIdandName;
    }
}
