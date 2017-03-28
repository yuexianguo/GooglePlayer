package com.example.administrator.googleplayer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.googleplayer.R;
import com.example.administrator.googleplayer.app.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Administrator on 2017/3/28.
 */

public class CategoryItemInfoView extends RelativeLayout {
    private static final String TAG = "CategoryItemInfoView";
    @BindView(R.id.icon)
    ImageView mIcon;
    @BindView(R.id.titile)
    TextView mTitile;

    public CategoryItemInfoView(Context context) {
        this(context, null);
    }


    public CategoryItemInfoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }


    private void init() {
        View.inflate(getContext(), R.layout.view_category_info_item, this);
        ButterKnife.bind(this, this);
    }


    public void bindView(String name, String url) {
        //每个小单位的标题
        mTitile.setText(name);

        String imageUrl = Constant.URL_IMAGE + url;
        Log.d(TAG, "bindView: "+imageUrl);
        //Grid加载图片
        Glide.with(getContext()).load(imageUrl).placeholder(R.drawable.ic_default).centerCrop().into(mIcon);

    }

}
