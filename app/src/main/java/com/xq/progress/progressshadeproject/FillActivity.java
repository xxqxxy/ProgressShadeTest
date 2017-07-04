package com.xq.progress.progressshadeproject;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xq.progressproject.view.MarqueeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xxq on 2017/6/26.
 */

public class FillActivity extends Activity{

    MarqueeView mv_notice;
    List<View> mList = new ArrayList<>();
    List<String> dataList = new ArrayList<>();
    Context mContext = FillActivity.this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fill);
        initViews();
        initDatas();

        setMarqueeContent();
        mv_notice.setViews(mList);
    }

    private void initViews(){
        mv_notice = (MarqueeView) findViewById(R.id.mv_notice);
    }

    private void initDatas(){
        dataList.add("618节大促，总有你想买的");
        dataList.add("父亲节来临，为父亲准备的礼物");
        dataList.add("各国PS高手同PS一张图，你get了吗？");
        dataList.add("夏天如果选择衣服");
    }

    private void setMarqueeContent(){
        mList.clear();//如果不清零可能会出现重影现象

        for (int i = 0;i <dataList.size();i++){
            final int position = i;

            LinearLayout ll_filling = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.fill_item  , null);
            ((TextView)ll_filling.findViewById(R.id.tv_content)).setText(dataList.get(i).toString());

            ll_filling.findViewById(R.id.ll_filling).setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(),  "你点击了" + dataList.get(position).toString(), Toast.LENGTH_SHORT).show();
                }
            });

            mList.add(ll_filling);

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mv_notice.startFlipping();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mv_notice.stopFlipping();
    }
}
