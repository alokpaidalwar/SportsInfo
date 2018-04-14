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
import com.sdirect.sports.adapter.EventsNextAdapter;
import com.sdirect.sports.adapter.SearchedLeagueAdapter;
import com.sdirect.sports.adapter.SearchedTeamAdapter;
import com.sdirect.sports.databinding.FragmentScheduleBinding;
import com.sdirect.sports.model.AllLeagues;
import com.sdirect.sports.model.AllTeamsInLeague;
import com.sdirect.sports.model.IgetLeagueIdandName;
import com.sdirect.sports.model.IgetTeamIdandName;
import com.sdirect.sports.model.TeamEventsNext;
import com.sdirect.sports.network.ApiUtils;
import com.sdirect.sports.network.ErrorModel;
import com.sdirect.sports.network.NetworkManager;
import com.sdirect.sports.network.ServiceListener;
import com.sdirect.sports.utils.Util;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ScheduleFragment extends Fragment implements IgetTeamIdandName,IgetLeagueIdandName {


    private ArrayList<AllLeagues.League> leagueList;
    private ArrayList<AllLeagues.League> filteredLeagueList;
    private EventsNextAdapter mAdapter;
    private Util mUtil;
    private FragmentScheduleBinding sBinding;
    private CatLoadingView progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        sBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_schedule,container,false);
        sBinding.scheduleRecycler.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        mAdapter = new EventsNextAdapter();
        sBinding.scheduleRecycler.setAdapter(mAdapter);
        mUtil=new Util(getContext());
        filteredLeagueList=new ArrayList<>();
        currentDateEvents();
        leaguesListRequest();
        progressDialog = new CatLoadingView();

        sBinding.scheduleSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selected= sBinding.scheduleRadioGroup.getCheckedRadioButtonId();
                if(sBinding.scheduleSearchView.getQuery().toString().isEmpty() || sBinding.scheduleSearchView.getQuery()==null){
                    mUtil.toastMsg("Please enter the name to search");
                    currentDateEvents();
                }else {
                    if (selected == R.id.radioButtonLeague) {
                        filteredLeagueList.clear();
                        for(int i=0;i<leagueList.size();i++){
                            if(leagueList.get(i).getStrLeague().toLowerCase()
                                    .contains(sBinding.scheduleSearchView.getQuery().toString().toLowerCase())){
                                filteredLeagueList.add(leagueList.get(i));
                            }
                        }
                        if(filteredLeagueList.size()==0){
                            mUtil.toastMsg("League with given name not found");
                        }else {
                            SearchedLeagueAdapter searchedLeagueAdapter=new SearchedLeagueAdapter(filteredLeagueList);
                            searchedLeagueAdapter.setOnItemSelected(ScheduleFragment.this);
                            sBinding.scheduleRecycler.setAdapter(searchedLeagueAdapter);
                            sBinding.scheduleTitle.setText(getString(R.string.leagues_head));
                            mUtil.dismissKeyboard(getActivity());
                        }
                    } else {
                        findTeamInApi(sBinding.scheduleSearchView.getQuery().toString());
                    }
                }
            }
        });

        return sBinding.getRoot();
    }

    private void currentDateEvents(){
        Date todayDate = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String todayString = formatter.format(todayDate);
        final NetworkManager manager = new NetworkManager();
        manager.createApiRequest((ApiUtils.getAPIService().getDayEvent(todayString)),
                new ServiceListener<TeamEventsNext>() {
                    @Override
                    public void getServerResponse(TeamEventsNext teamEventsNext, int requestcode) {
                        if(teamEventsNext.getEvents()!=null){
                            mAdapter.setDataList(teamEventsNext.getEvents());
                            sBinding.scheduleTitle.setText(getString(R.string.todays_events));
                            mUtil.dismissKeyboard(getActivity());
                        }else {
                            mUtil.toastMsg("No upcoming events of today available");
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
        manager.createApiRequest((ApiUtils.getAPIService().getLeagueEventNext(id)),
                new ServiceListener<TeamEventsNext>() {
                    @Override
                    public void getServerResponse(TeamEventsNext teamEventsNext, int requestcode) {
                        if(teamEventsNext.getEvents()!=null){
                            mAdapter.setDataList(teamEventsNext.getEvents());
                            sBinding.scheduleRecycler.setAdapter(mAdapter);
                            sBinding.scheduleTitle.setText(getString(R.string.schedule_next15)+leagueName);
                            mUtil.dismissKeyboard(getActivity());
                            sBinding.scheduleSearchView.clearFocus();
                        }else {
                            mUtil.toastMsg("No upcoming events of "+leagueName+" available");
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
                           searchedTeamAdapter.setOnItemSelected(ScheduleFragment.this);
                           sBinding.scheduleRecycler.setAdapter(searchedTeamAdapter);
                           sBinding.scheduleTitle.setText(R.string.schedule_selectteam);
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
        manager.createApiRequest((ApiUtils.getAPIService().getTeamEventNext(id)),
                new ServiceListener<TeamEventsNext>() {
                    @Override
                    public void getServerResponse(TeamEventsNext teamEventsNext, int requestcode) {
                        if(teamEventsNext.getEvents()!=null){
                            mAdapter.setDataList(teamEventsNext.getEvents());
                            sBinding.scheduleRecycler.setAdapter(mAdapter);
                            sBinding.scheduleTitle.setText(getString(R.string.schedule_next5)+teamName);
                            mUtil.dismissKeyboard(getActivity());
                            sBinding.scheduleSearchView.clearFocus();
                        }else {
                            mUtil.toastMsg("No upcoming events of "+teamName+" available");
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
