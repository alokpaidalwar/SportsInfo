package com.sdirect.sports.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.sdirect.sports.R;
import com.sdirect.sports.model.AllLeagues;
import com.sdirect.sports.model.IgetLeagueId;

import java.util.ArrayList;

public class AllLeagueAdapter extends RecyclerView.Adapter<AllLeagueAdapter.MyViewHolder> {

    private ArrayList<AllLeagues.League> leagueList;
    private IgetLeagueId igetLeagueId;

    public AllLeagueAdapter(ArrayList<AllLeagues.League> leagueList) {
        this.leagueList = leagueList;
    }

    @Override
    public AllLeagueAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate( R.layout.allleagues_single, parent, false);

        return new AllLeagueAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AllLeagueAdapter.MyViewHolder holder, final int position) {
        holder.mName.setText(leagueList.get(position).getStrLeague());
        holder.mSport.setText(leagueList.get(position).getStrSport());
        holder.mAlternate.setText(leagueList.get(position).getStrLeagueAlternate());
        holder.mDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                igetLeagueId.onLeagueIdSelected(leagueList.get(position).getIdLeague());
            }
        });
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mName,mSport,mAlternate;
        ImageView mDetails;

        public MyViewHolder(View view) {
            super(view);
            mName=view.findViewById(R.id.allleagues_name);
            mSport=view.findViewById(R.id.allleagues_sport);
            mAlternate=view.findViewById(R.id.allleagues_alternate);
            mDetails=view.findViewById(R.id.alleagues_details);
        }
    }

    @Override
    public int getItemCount() {
        return leagueList.size();
    }

    public void setOnItemSelected(IgetLeagueId igetLeagueId)
    {
        this.igetLeagueId = igetLeagueId;
    }
}
