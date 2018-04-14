package com.sdirect.sports.fragment;


import android.databinding.DataBindingUtil;
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
import com.sdirect.sports.adapter.AllPlayersInTeamAdapter;
import com.sdirect.sports.adapter.NewsAdapter;
import com.sdirect.sports.databinding.FragmentHomeBinding;
import com.sdirect.sports.model.AllPlayers;
import com.sdirect.sports.model.News;
import com.sdirect.sports.network.ApiUtils;
import com.sdirect.sports.network.ErrorModel;
import com.sdirect.sports.network.NetworkManager;
import com.sdirect.sports.network.ServiceListener;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding hBinding;
    private CatLoadingView progressDialog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        hBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false);
        hBinding.homeRecycler.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        progressDialog = new CatLoadingView();
        getLatestNews();
        return hBinding.getRoot();
    }

    public void getLatestNews(){
        progressDialog.show(getFragmentManager(),"home");
        NetworkManager manager = new NetworkManager();
        manager.createApiRequest((ApiUtils.getAPIService().getNews()),
                new ServiceListener<News>() {
                    @Override
                    public void getServerResponse(News news, int requestcode) {
                        NewsAdapter newsAdapter=new NewsAdapter(getContext(),news.getArticles());
                        hBinding.homeRecycler.setAdapter(newsAdapter);
                        progressDialog.onDismiss(null);
                    }

                    @Override
                    public void getError(ErrorModel error, int requestcode) {
                        Log.e("error getLatestnews", error.error_message + "");
                        Toast.makeText(getContext(), error.error_message, Toast.LENGTH_LONG).show();
                        progressDialog.onDismiss(null);
                    }
                });
    }
}
