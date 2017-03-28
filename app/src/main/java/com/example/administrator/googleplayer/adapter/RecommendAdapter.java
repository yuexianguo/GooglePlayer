package com.example.administrator.googleplayer.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.googleplayer.widget.StellarMap;

import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/3/28.
 */
public class RecommendAdapter implements StellarMap.Adapter {

    private final static  int PAGE_SIZE = 15;//自己随便定义的一页中的单元的个数
    private Context mContext;
    private List<String> mDataList;


    public RecommendAdapter(Context context, List<String> dataList) {

        mContext = context;
        mDataList = dataList;
    }

    /**
     *  返回组（页面的）个数
     */
    @Override
    public int getGroupCount() {
        int count = mDataList.size()/ PAGE_SIZE;
        if(mDataList.size()% PAGE_SIZE!=0){ //判断，如果不整除，就得多出一页
            count++;
        }
        return count;
    }


    /**
     * 根据小标，返回页面的单元数目
     * @param group 页面的下标
     * @return
     */
    @Override
    public int getCount(int group) {
        if(mDataList.size()%PAGE_SIZE!=0){
            if(group==getGroupCount()- 1){
                return mDataList.size()%PAGE_SIZE;
            }
        }

        return PAGE_SIZE;
    }


    /**
     *
     * @param group 页面的小标
     * @param position
     * @param convertView
     * @return
     */
    @Override
    public View getView(int group, int position, View convertView) {
        if(convertView==null){
            //没有可以复用的
            convertView = new TextView(mContext);
        }
        //设置textview数据
        TextView textView = (TextView) convertView;
        //计算元素在数据集合中对应数据下标
        int pos = group*PAGE_SIZE+position;
        textView.setText(mDataList.get(pos));
        textView.setTextColor(getArgb());
        textView.setTextSize(4+new Random().nextInt(14));
        return textView;
    }

    public int getArgb(){

        int alpha = 255;
        int red = 30+new Random().nextInt(200);
        int green = 30+new Random().nextInt(200);
        int blue = 30+new Random().nextInt(200);

        return Color.argb(alpha,red,green,blue);
    }


    @Override
    public int getNextGroupOnPan(int group, float degree) {
        return 0;
    }


    /**
     *
     * @param group 页面的下标
     * @param isZoomIn 动画是否放大，放大代表是下个页面
     * @return 返回下一个页面的页面的下标
     */
    @Override
    public int getNextGroupOnZoom(int group, boolean isZoomIn) {
        if(isZoomIn){
            return (group+1)%getGroupCount();//取模代，当最大页面下个页面是0，继续；
        }
        //共三个页面
        // 0,  --->2 ：
        // 1， ---->0;
        // 2, -----> 1;

        return (group-1+getGroupCount())%getGroupCount() ;
    }
}
