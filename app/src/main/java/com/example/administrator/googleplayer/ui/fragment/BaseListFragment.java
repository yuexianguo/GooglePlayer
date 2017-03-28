package com.example.administrator.googleplayer.ui.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

/**
 * Created by Administrator on 2017/3/28.
 */

public abstract class BaseListFragment extends BaseFragment {


    //返回一个ListView
    @Override
    protected View onCreateContentView() {
        ListView listView = new ListView(getContext());
        listView.setAdapter(onCreatAdapter());
        listView.setOnItemClickListener(mOnItemClickListener);
        return listView;
    }


    /**
     * 子类实现各自的adpter的布局列表给基类，因为每个节目列表不一样；
     * @return
     */
    public abstract  BaseAdapter onCreatAdapter() ;

    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onListItemClick(position);
        }
    };


    /**
     * 子类自己实现Item点击事件
     * @param position
     */
    private void onListItemClick(int position) {

    }

}
