package com.example.administrator.googleplayer.ui.fragment;

/**
 * Created by Administrator on 2017/3/29.
 */

import android.widget.AbsListView;

/**
 * 由于首页，游戏，应用，专题这四个页面公共的加载更多的功能，把这个功能封装到BaseLoadmoreListFragment
 */
public abstract class BaseLoadmoreListFragment extends BaseListFragment {

    @Override
    protected void initListView() {
        super.initListView();
       //监听listview滚动，监听是否滑到了最后
        getListView().setOnScrollListener(mOnScrollListener);
    }

    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            //判断停止滚动
            if(scrollState==SCROLL_STATE_IDLE){
                if(getListView().getLastVisiblePosition()==getBaseAdapter().getCount()-1){
                    startLoadMoreData();
                }
            }
        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        }
    };


    /**
     * 加载更多数据由子类实现，监听是父类b
     */
    protected abstract void startLoadMoreData() ;


}
