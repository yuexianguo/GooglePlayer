package com.example.administrator.googleplayer.factory;

import android.support.v4.app.Fragment;

import com.example.administrator.googleplayer.ui.fragment.AppFragment;
import com.example.administrator.googleplayer.ui.fragment.CategoriesFragment;
import com.example.administrator.googleplayer.ui.fragment.GameFragment;
import com.example.administrator.googleplayer.ui.fragment.HomeFragment;
import com.example.administrator.googleplayer.ui.fragment.HotFragment;
import com.example.administrator.googleplayer.ui.fragment.RecommendFragment;
import com.example.administrator.googleplayer.ui.fragment.SubjectFragment;

/**
 * Created by Administrator on 2017/3/27.
 */

public class FragmentFactory {


    private static final int FRAGMENT_HOME = 0;
    private static final int FRAGMENT_APP = 1;
    private static final int FRAGMENT_GAME = 2;
    private static final int FRAGMENT_SUBJECT = 3;
    private static final int FRAGMENT_RECOMMEND = 4;
    private static final int FRAGMENT_CATEGORIES = 5;
    private static final int FRAGMENT_HOT = 6;

    //单例模式，一个Appint只一个int工厂
    private static FragmentFactory sFragmentFactory;

    public static FragmentFactory getInstance() {
        if (sFragmentFactory == null) {
            synchronized (FragmentFactory.class) {
                if (sFragmentFactory == null) {
                    sFragmentFactory = new FragmentFactory();
                }

            }
        }
        return sFragmentFactory;

    }


    public Fragment getFragment(int position) {
        switch (position) {
            case FRAGMENT_HOME:
                return new HomeFragment();
            case FRAGMENT_APP:
                return new AppFragment();
            case FRAGMENT_GAME:
                return new GameFragment();
            case FRAGMENT_SUBJECT:
                return new SubjectFragment();
            case FRAGMENT_RECOMMEND:
                return new RecommendFragment();
            case FRAGMENT_CATEGORIES:
                return new CategoriesFragment();
            case FRAGMENT_HOT:
                return new HotFragment();



        }
        return null;
    }
}