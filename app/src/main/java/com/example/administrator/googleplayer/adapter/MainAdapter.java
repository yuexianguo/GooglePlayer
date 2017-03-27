package com.example.administrator.googleplayer.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.administrator.googleplayer.factory.FragmentFactory;

/**
 * Created by Administrator on 2017/3/27.
 */

public class MainAdapter extends FragmentPagerAdapter {

    private String[] mDataList;

    public MainAdapter(String[] dataList, FragmentManager fm) {
        super(fm);
        this.mDataList = dataList;
    }

    //用工厂模式来生成Fragment，返回对应的Fragment
    @Override
    public Fragment getItem(int position) {

        return FragmentFactory.getInstance().getFragment(position);
    }

    @Override
    public int getCount() {
        return mDataList.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mDataList[position];
    }
}
