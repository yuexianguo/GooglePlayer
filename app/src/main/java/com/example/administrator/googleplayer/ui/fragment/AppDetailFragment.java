package com.example.administrator.googleplayer.ui.fragment;


import android.view.View;
import android.widget.Toast;

import com.example.administrator.googleplayer.R;
import com.example.administrator.googleplayer.bean.AppDetailBean;
import com.example.administrator.googleplayer.network.HeiMaRetrofit;
import com.example.administrator.googleplayer.widget.AppDetailInfoView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/3/31.
 */

public  class AppDetailFragment extends BaseFragment {

    private AppDetailBean mAppDetailBean;

    @Override
    protected void startLoadData() {
        String packageName = getActivity().getIntent().getExtras().getString("package_name");
        Call<AppDetailBean> appDetailCall = HeiMaRetrofit.getInstrance().getApi().getAppDetail(packageName);
        appDetailCall.enqueue(new Callback<AppDetailBean>() {
            @Override
            public void onResponse(Call<AppDetailBean> call, Response<AppDetailBean> response) {
                Toast.makeText(getContext(),response.body().getName(),Toast.LENGTH_SHORT).show();
                mAppDetailBean =  response.body();
                onDataLoadSuccess();
            }

            @Override
            public void onFailure(Call<AppDetailBean> call, Throwable t) {
                onDataLoadFailed();
            }
        });

    }



    @Override
    protected View onCreateContentView(){

        View view = View.inflate(getContext(), R.layout.app_detail_content, null);
        //应用信息
        AppDetailInfoView appDetailInfoView = (AppDetailInfoView) view.findViewById(R.id.app_detail_info);
        appDetailInfoView.bindView(mAppDetailBean);

        

        return view;
    }


}
