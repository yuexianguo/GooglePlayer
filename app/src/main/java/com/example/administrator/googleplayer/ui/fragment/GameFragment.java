package com.example.administrator.googleplayer.ui.fragment;

import android.widget.Toast;

import com.example.administrator.googleplayer.bean.AppListItemBean;
import com.example.administrator.googleplayer.network.HeiMaRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/3/27.
 */

public class GameFragment extends BaseAppListFragment {




    @Override
    protected void startLoadData() {
        super.startLoadData();
        Call<List<AppListItemBean>> listCall = HeiMaRetrofit.getInstrance().getApi().listGame(0);
        listCall.enqueue(new Callback<List<AppListItemBean>>() {
            @Override
            public void onResponse(Call<List<AppListItemBean>> call, Response<List<AppListItemBean>> response) {
                Toast.makeText(getContext(),""+response.body(),Toast.LENGTH_SHORT).show();
                getDataList().addAll(response.body());
                onDataLoadSuccess();

            }

            @Override
            public void onFailure(Call<List<AppListItemBean>> call, Throwable t) {

            }
        });

    }



    @Override
    protected void startLoadMoreData() {

    }



}
