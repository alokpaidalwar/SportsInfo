package com.sdirect.sports.fragment;


import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.roger.catloadinglibrary.CatLoadingView;
import com.sdirect.sports.R;
import com.sdirect.sports.adapter.AllLeagueAdapter;
import com.sdirect.sports.adapter.AllPlayersInTeamAdapter;
import com.sdirect.sports.adapter.AllSportsAdapter;
import com.sdirect.sports.adapter.AllTeamsInLeagueAdapter;
import com.sdirect.sports.databinding.FragmentListBinding;
import com.sdirect.sports.model.AllLeagues;
import com.sdirect.sports.model.AllPlayers;
import com.sdirect.sports.model.AllSports;
import com.sdirect.sports.model.AllTeamsInLeague;
import com.sdirect.sports.model.IgetLeagueId;
import com.sdirect.sports.model.IgetTeamId;
import com.sdirect.sports.model.ScoreDetailsTeamInLeague;
import com.sdirect.sports.network.ApiUtils;
import com.sdirect.sports.network.ErrorModel;
import com.sdirect.sports.network.NetworkManager;
import com.sdirect.sports.network.RetrofitClient;
import com.sdirect.sports.network.ServiceListener;

import static com.sdirect.sports.network.ApiUtils.BASE_URL;


public class ListFragment extends Fragment implements IgetLeagueId,IgetTeamId {

    private CatLoadingView progressDialog;
    private FragmentListBinding lBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        lBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_list,container,false);
        lBinding.listRecycler.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        progressDialog = new CatLoadingView();
        sportsListRequest();
        lBinding.listSportsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sportsListRequest();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    lBinding.listSportsBtn.setElevation(8);
                    lBinding.listLeagueBtn.setElevation(0);
                    lBinding.listSportsBtn.setBackgroundColor(getResources().getColor(R.color.colorListBtnClick));
                    lBinding.listLeagueBtn.setBackgroundColor(getResources().getColor(R.color.colorListBtn));
                    lBinding.listSportsBtn.setTextColor(getResources().getColor(android.R.color.white));
                    lBinding.listLeagueBtn.setTextColor(getResources().getColor(android.R.color.black));
                }
            }
        });

        lBinding.listLeagueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leaguesListRequest();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    lBinding.listLeagueBtn.setElevation(8);
                    lBinding.listSportsBtn.setElevation(0);
                    lBinding.listSportsBtn.setBackgroundColor(getResources().getColor(R.color.colorListBtn));
                    lBinding.listLeagueBtn.setBackgroundColor(getResources().getColor(R.color.colorListBtnClick));
                    lBinding.listSportsBtn.setTextColor(getResources().getColor(android.R.color.black));
                    lBinding.listLeagueBtn.setTextColor(getResources().getColor(android.R.color.white));
                }
            }
        });

        return lBinding.getRoot();
    }

    @Override
    public void onLeagueIdSelected(String id) {
        allTeamsInLeague(id);
    }

    @Override
    public  void onTeamIdSelected(String id){
        allPlayersInteam(id);
    }

    public void sportsListRequest() {
        RetrofitClient.changeBaseUrl(BASE_URL);
        progressDialog.show(getFragmentManager(),"sports");
        NetworkManager manager = new NetworkManager();
        manager.createApiRequest((ApiUtils.getAPIService().getAllSportsList()),
                new ServiceListener<AllSports>() {
                    @Override
                    public void getServerResponse(AllSports allSports, int requestcode) {
                        AllSportsAdapter mAdapter = new AllSportsAdapter(getContext(),allSports.getSports());
                        lBinding.listRecycler.setAdapter(mAdapter);
                        progressDialog.onDismiss(null);
                    }

                    @Override
                    public void getError(ErrorModel error, int requestcode) {
                        Log.e("error in login", error.error_message + "");
                        Toast.makeText(getContext(), error.error_message, Toast.LENGTH_LONG).show();
                        progressDialog.onDismiss(null);
                    }
                });
    }

    public void leaguesListRequest() {
        progressDialog.show(getFragmentManager(),"league");
        NetworkManager manager = new NetworkManager();
        manager.createApiRequest((ApiUtils.getAPIService().getAllLeaguesList()),
                new ServiceListener<AllLeagues>() {
                    @Override
                    public void getServerResponse(AllLeagues allLeagues, int requestcode) {
                        AllLeagueAdapter mAdapter = new AllLeagueAdapter(allLeagues.getLeagues());
                        mAdapter.setOnItemSelected(ListFragment.this);
                        lBinding.listRecycler.setAdapter(mAdapter);
                        progressDialog.onDismiss(null);
                    }

                    @Override
                    public void getError(ErrorModel error, int requestcode) {
                        Log.e("error in login", error.error_message + "");
                        Toast.makeText(getContext(), error.error_message, Toast.LENGTH_LONG).show();
                       progressDialog.onDismiss(null);
                    }
                });
    }

    public void allTeamsInLeague(final String id){
        progressDialog.show(getFragmentManager(),"team");
        NetworkManager manager = new NetworkManager();
        manager.createApiRequest((ApiUtils.getAPIService().getAllTeamsInLeagueList(id)),
                new ServiceListener<AllTeamsInLeague>() {
                    @Override
                    public void getServerResponse(AllTeamsInLeague allTeamsInLeague, int requestcode) {
                       teamsScoreInLeague(id,allTeamsInLeague);
                    }

                    @Override
                    public void getError(ErrorModel error, int requestcode) {
                        Log.e("error teamInLeague", error.error_message + "");
                        Toast.makeText(getContext(), error.error_message, Toast.LENGTH_LONG).show();
                        progressDialog.onDismiss(null);
                    }
                });
    }

    public void allPlayersInteam(String id){
        progressDialog.show(getFragmentManager(),"players");
        NetworkManager manager = new NetworkManager();
        manager.createApiRequest((ApiUtils.getAPIService().getAllPlayersInTeamList(id)),
                new ServiceListener<AllPlayers>() {
                    @Override
                    public void getServerResponse(AllPlayers allPlayers, int requestcode) {
                       AllPlayersInTeamAdapter mAdapter = new AllPlayersInTeamAdapter(getContext()
                                ,allPlayers.getPlayer());
                        lBinding.listRecycler.setAdapter(mAdapter);
                        progressDialog.onDismiss(null);
                    }

                    @Override
                    public void getError(ErrorModel error, int requestcode) {
                        Log.e("error allPlayersInTeam", error.error_message + "");
                        Toast.makeText(getContext(), error.error_message, Toast.LENGTH_LONG).show();
                        progressDialog.onDismiss(null);
                    }
                });
    }

    public  void teamsScoreInLeague(String id, final AllTeamsInLeague allTeamsInLeague){
        NetworkManager manager = new NetworkManager();
        manager.createApiRequest((ApiUtils.getAPIService().getScoreDetailsTeamsInLeagueList(id)),
                new ServiceListener<ScoreDetailsTeamInLeague>() {
                    @Override
                    public void getServerResponse(ScoreDetailsTeamInLeague scoreDetailsTeamInLeague, int requestcode) {
                        AllTeamsInLeagueAdapter mAdapter = new AllTeamsInLeagueAdapter(getContext()
                                ,allTeamsInLeague.getTeams(),scoreDetailsTeamInLeague.getTable());
                        mAdapter.setOnItemSelected(ListFragment.this);
                        lBinding.listRecycler.setAdapter(mAdapter);
                       progressDialog.onDismiss(null);
                    }

                    @Override
                    public void getError(ErrorModel error, int requestcode) {
                        Log.e("error teamscoreleague", error.error_message + "");
                        Toast.makeText(getContext(), error.error_message, Toast.LENGTH_LONG).show();
                         progressDialog.onDismiss(null);
                    }
                });
    }



}
