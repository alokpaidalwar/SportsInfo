package com.sdirect.sports.fragment;



import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roger.catloadinglibrary.CatLoadingView;
import com.sdirect.sports.R;
import com.sdirect.sports.adapter.EventsPastAdapter;
import com.sdirect.sports.adapter.SearchedLeagueAdapter;
import com.sdirect.sports.adapter.SearchedTeamAdapter;
import com.sdirect.sports.adapter.TeamResultAdapter;
import com.sdirect.sports.databinding.FragmentResultBinding;
import com.sdirect.sports.model.AllLeagues;
import com.sdirect.sports.model.AllTeamsInLeague;
import com.sdirect.sports.model.IgetLeagueId;
import com.sdirect.sports.model.IgetLeagueIdandName;
import com.sdirect.sports.model.IgetTeamIdandName;
import com.sdirect.sports.model.Results;
import com.sdirect.sports.model.TeamEventsNext;
import com.sdirect.sports.network.ApiUtils;
import com.sdirect.sports.network.ErrorModel;
import com.sdirect.sports.network.NetworkManager;
import com.sdirect.sports.network.ServiceListener;
import com.sdirect.sports.utils.Util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class ResultFragment extends Fragment implements IgetTeamIdandName,IgetLeagueIdandName {


    private ArrayList<AllLeagues.League> leagueList;
    private ArrayList<AllLeagues.League> filteredLeagueList;
    private EventsPastAdapter mAdapter;
    private Util mUtil;
    private FragmentResultBinding rBinding;
    private CatLoadingView progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_result,container,false);
        rBinding.resultRecycler.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        mAdapter = new EventsPastAdapter();
        rBinding.resultRecycler.setAdapter(mAdapter);
        filteredLeagueList=new ArrayList<>();
        mUtil=new Util(getContext());
        yesterdayDateEvents();
        leaguesListRequest();
        progressDialog = new CatLoadingView();

        rBinding.resultSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selected= rBinding.resultRadioGroup.getCheckedRadioButtonId();
                if(rBinding.resultSearchView.getQuery().toString().isEmpty() || rBinding.resultSearchView.getQuery()==null){
                    mUtil.toastMsg("Please enter the name to search");
                }
                if(selected==R.id.radioButtonLeague){
                    filteredLeagueList.clear();
                    for(int i=0;i<leagueList.size();i++){
                        if(leagueList.get(i).getStrLeague().toLowerCase()
                                .contains(rBinding.resultSearchView.getQuery().toString().toLowerCase())){
                            filteredLeagueList.add(leagueList.get(i));
                        }
                    }
                    if(filteredLeagueList.size()==0){
                        mUtil.toastMsg("League with given name not found");
                        yesterdayDateEvents();
                    }else {
                        SearchedLeagueAdapter searchedLeagueAdapter=new SearchedLeagueAdapter(filteredLeagueList);
                        searchedLeagueAdapter.setOnItemSelected(ResultFragment.this);
                        rBinding.resultRecycler.setAdapter(searchedLeagueAdapter);
                        rBinding.resultTitle.setText(getString(R.string.leagues_head));
                        mUtil.dismissKeyboard(getActivity());
                    }
                }else {
                    findTeamInApi(rBinding.resultSearchView.getQuery().toString());
                }
            }
        });

        return rBinding.getRoot();
    }

    private void yesterdayDateEvents(){

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String todayString = formatter.format(cal.getTime());

        final NetworkManager manager = new NetworkManager();
        manager.createApiRequest((ApiUtils.getAPIService().getDayEvent(todayString)),
                new ServiceListener<TeamEventsNext>() {
                    @Override
                    public void getServerResponse(TeamEventsNext teamEventsNext, int requestcode) {
                        if(teamEventsNext.getEvents()!=null){
                            mAdapter.setDataList(teamEventsNext.getEvents());
                            rBinding.resultTitle.setText(getString(R.string.yesterday_events));
                            mUtil.dismissKeyboard(getActivity());
                        }else {
                            mUtil.toastMsg("No pasts result of yesterday available");
                        }
                    }

                    @Override
                    public void getError(ErrorModel error, int requestcode) {
                        Log.e("error in getEventbyTeam", error.error_message + "");
                        mUtil.toastMsg(error.error_message);
                    }
                });
    }

    private void leaguesListRequest() {
        NetworkManager manager = new NetworkManager();
        manager.createApiRequest((ApiUtils.getAPIService().getAllLeaguesList()),
                new ServiceListener<AllLeagues>() {
                    @Override
                    public void getServerResponse(AllLeagues allLeagues, int requestcode) {
                        leagueList=allLeagues.getLeagues();
                    }

                    @Override
                    public void getError(ErrorModel error, int requestcode) {
                        Log.e("error in login", error.error_message + "");
                        mUtil.toastMsg(error.error_message);
                    }
                });
    }

    private void getEventsByLeague(final String id, final String leagueName){
        progressDialog.show(getFragmentManager(),"league");
        NetworkManager manager = new NetworkManager();
        manager.createApiRequest((ApiUtils.getAPIService().getLeagueEventPast(id)),
                new ServiceListener<TeamEventsNext>() {
                    @Override
                    public void getServerResponse(TeamEventsNext teamEventsNext, int requestcode) {
                        if(teamEventsNext.getEvents()!=null){
                            mAdapter.setDataList(teamEventsNext.getEvents());
                            rBinding.resultRecycler.setAdapter(mAdapter);
                            rBinding.resultTitle.setText(getString(R.string.result_past15)+leagueName);
                            mUtil.dismissKeyboard(getActivity());
                            rBinding.resultSearchView.clearFocus();
                        }else {
                            mUtil.toastMsg("No past results of "+leagueName+" available");
                        }
                        progressDialog.onDismiss(null);
                    }

                    @Override
                    public void getError(ErrorModel error, int requestcode) {
                        Log.e("error in login", error.error_message + "");
                        mUtil.toastMsg(error.error_message);
                        progressDialog.onDismiss(null);
                    }
                });
    }

    private void findTeamInApi(String teamName) {
        NetworkManager manager = new NetworkManager();
        manager.createApiRequest((ApiUtils.getAPIService().findTeam(teamName)),
                new ServiceListener<AllTeamsInLeague>() {
                    @Override
                    public void getServerResponse(AllTeamsInLeague allTeamsInLeague, int requestcode) {
                        if(allTeamsInLeague.getTeams()!=null){
                            SearchedTeamAdapter searchedTeamAdapter=new SearchedTeamAdapter(allTeamsInLeague.getTeams());
                            searchedTeamAdapter.setOnItemSelected(ResultFragment.this);
                            rBinding.resultRecycler.setAdapter(searchedTeamAdapter);
                            rBinding.resultTitle.setText(R.string.result_selectteam);
                            mUtil.dismissKeyboard(getActivity());
                        }else {
                            mUtil.toastMsg("No team found with given name");
                        }
                    }

                    @Override
                    public void getError(ErrorModel error, int requestcode) {
                        Log.e("error in findTeamApi", error.error_message + "");
                        mUtil.toastMsg(error.error_message);
                    }
                });
    }

    private void getEventsByTeam(String id, final String teamName){
        progressDialog.show(getFragmentManager(),"team");
        NetworkManager manager = new NetworkManager();
        manager.createApiRequest((ApiUtils.getAPIService().getTeamEventPast(id)),
                new ServiceListener<Results>() {
                    @Override
                    public void getServerResponse(Results results, int requestcode) {
                        if(results.getResults()!=null){
                            TeamResultAdapter teamResultAdapter=new TeamResultAdapter(results.getResults());
                            rBinding.resultRecycler.setAdapter(teamResultAdapter);
                            rBinding.resultTitle.setText(getString(R.string.result_past5)+teamName);
                            mUtil.dismissKeyboard(getActivity());
                            rBinding.resultSearchView.clearFocus();
                        }else {
                            mUtil.toastMsg("No past results of "+teamName+" available");
                        }
                        progressDialog.onDismiss(null);
                    }

                    @Override
                    public void getError(ErrorModel error, int requestcode) {
                        Log.e("error in getEventbyTeam", error.error_message + "");
                        mUtil.toastMsg(error.error_message);
                        progressDialog.onDismiss(null);
                    }
                });
    }

    @Override
    public void onTeamIdandName(String id,String name) {
        getEventsByTeam(id,name);
    }

    @Override
    public void onLeagueIdandName(String id,String name) {
        getEventsByLeague(id,name);
    }

}
