package com.example.administrator.googleplayer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.example.administrator.googleplayer.R;
import com.example.administrator.googleplayer.app.Constant;
import com.example.administrator.googleplayer.bean.AppDetailBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/31.
 */

public class AppDetailSecurityView extends RelativeLayout {

    @BindView(R.id.tag_container)
    LinearLayout mTagContainer;
    @BindView(R.id.security_arrow)
    ImageView mSecurityArrow;
    @BindView(R.id.security_info_container)
    LinearLayout mSecurityInfoContainer;

    public AppDetailSecurityView(Context context) {
        this(context, null);
    }

    public AppDetailSecurityView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {

        View.inflate(getContext(), R.layout.app_detail_security, this);
        ButterKnife.bind(this, this);
    }


    public void bindView(AppDetailBean appDetailBean) {
        //遍历数组
        for (int i = 0; i <appDetailBean.getSafe().size() ; i++) {

            //获得数据里面的每个bean信息
            AppDetailBean.SafeBean safeBean = appDetailBean.getSafe().get(i);
            ImageView imageView = new ImageView(getContext());
            String url = Constant.URL_IMAGE + safeBean.getSafeUrl();
            Glide.with(getContext()).load(url).into(imageView);
            //加入标签视图
            mTagContainer.addView(imageView);





        }

    }
}
