package com.example.administrator.googleplayer.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.example.administrator.googleplayer.R;
import com.example.administrator.googleplayer.app.Constant;
import com.example.administrator.googleplayer.bean.AppDetailBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/3/31.
 */

public class AppDetailSecurityView extends RelativeLayout {

    private static final String TAG = "AppDetailSecurityView";
    @BindView(R.id.tag_container)
    LinearLayout mTagContainer;
    @BindView(R.id.security_arrow)
    ImageView mSecurityArrow;
    @BindView(R.id.security_info_container)
    LinearLayout mSecurityInfoContainer;
    private boolean isOpen = false; //展开的标识

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
        for (int i = 0; i < appDetailBean.getSafe().size(); i++) {

            //获得数据里面的每个bean信息
            AppDetailBean.SafeBean safeBean = appDetailBean.getSafe().get(i);
            ImageView imageView = new ImageView(getContext());
            String url = Constant.URL_IMAGE + safeBean.getSafeUrl();
            Glide.with(getContext()).load(url).override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).into(imageView);
            //加入标签视图
            mTagContainer.addView(imageView);

            //添加一行描述
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            //创建一个网络图片checkbox
            ImageView checkBox = new ImageView(getContext());
            String checkUrl = Constant.URL_IMAGE + safeBean.getSafeDesUrl();
            Glide.with(getContext()).load(checkUrl).override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).into(checkBox);
            linearLayout.addView(checkBox);
            TextView textView = new TextView(getContext());
            textView.setText(safeBean.getSafeDes());
            if(safeBean.getSafeDesColor()==0){
                textView.setTextColor(getResources().getColor(R.color.app_detail_safe_normal));

            }else {
                textView.setTextColor(getResources().getColor(R.color.app_detail_safe_warning));
            }
            linearLayout.addView(textView);
            mSecurityInfoContainer.addView(linearLayout);
        }

    }

    @OnClick(R.id.security_arrow)
    public void onClick() {
        toggle();
    }

    private void toggle() {
        if(isOpen){


        }else {
            //开始执行展开如下：
            //高度是从0到原始高度
            //指定期望是不限制大小，用 MeasureSpec.makeMeasureSpec(0,0);

            mSecurityInfoContainer.measure(0,0);
            //获取展开后的高度
            int measuredHeight = mSecurityInfoContainer.getMeasuredHeight();
            Log.d(TAG, "toggle: "+measuredHeight);
            //产生动画数据系列
            ValueAnimator valueAnimator = ValueAnimator.ofInt(0,measuredHeight);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int value = (int) animation.getAnimatedValue();
                    // Log.d(TAG, "onAnimationUpdate: "+value);
                    ViewGroup.LayoutParams layoutParams = mSecurityInfoContainer.getLayoutParams();
                    layoutParams.height = value;
                    mSecurityInfoContainer.setLayoutParams(layoutParams);


                }
            });

            valueAnimator.start();
        }

    }
}
