package com.example.administrator.googleplayer.ui.fragment;

import android.view.View;
import android.widget.Toast;

import com.example.administrator.googleplayer.R;
import com.example.administrator.googleplayer.network.Api;
import com.example.administrator.googleplayer.network.HeiMaRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.id.list;

/**
 * Created by Administrator on 2017/3/27.
 */

public class HotFragment extends BaseFragment {

    private List<String> mDataList;

    @Override
    protected void startLoadData() {

        Api api = HeiMaRetrofit.getInstrance().getApi();
        Call<List<String>> listCall = api.listhot();
        listCall.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String> response) {
                Toast.makeText(getContext(),response.body().toString(),Toast.LENGTH_SHORT).show();
                mDataList=response.body();
                onDataLoadSuccess();
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Toast.makeText(getContext(),"网络失败",Toast.LENGTH_SHORT).show();

            }
        });

    }

    /**
     * 热门界面布局
     * @return
     */
    @Override
    protected View onCreateContentView() {
        int padding = getResources().getDimensionPixelOffset(R.dimen.padding);
        


        return null;
    }
}
