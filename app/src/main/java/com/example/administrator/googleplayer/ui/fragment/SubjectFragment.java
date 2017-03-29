package com.example.administrator.googleplayer.ui.fragment;

import android.widget.BaseAdapter;

import com.example.administrator.googleplayer.adapter.SubjectAdapter;
import com.example.administrator.googleplayer.bean.SubjectItemBean;
import com.example.administrator.googleplayer.network.HeiMaRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/3/27.
 */

public class SubjectFragment extends BaseLoadmoreListFragment {

    private static final String TAG = "SubjectFragment";

    private List<SubjectItemBean> mDataList;


    @Override
    public BaseAdapter onCreatAdapter() {
        return new SubjectAdapter(getContext(),mDataList);
    }


    @Override
    protected void startLoadData() {

        Call<List<SubjectItemBean>> listCall =  HeiMaRetrofit.getInstrance().getApi().listSubject(0);
        listCall.enqueue(new Callback<List<SubjectItemBean>>() {
            @Override
            public void onResponse(Call<List<SubjectItemBean>> call, Response<List<SubjectItemBean>> response) {
                //Log.d(TAG, "onResponse: "+response.body());
                //Toast.makeText(getContext(),"请求结果"+response.body(),Toast.LENGTH_SHORT).show();
                mDataList=response.body();
                onDataLoadSuccess();

            }

            @Override
            public void onFailure(Call<List<SubjectItemBean>> call, Throwable t) {
                onDataLoadFailed();
            }
        });

    }

    @Override
    protected void startLoadMoreData() {


    }
}
