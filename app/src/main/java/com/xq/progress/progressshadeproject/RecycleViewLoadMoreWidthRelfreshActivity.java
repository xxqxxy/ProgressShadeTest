package com.xq.progress.progressshadeproject;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.superrecycleview.superlibrary.recycleview.ProgressStyle;
import com.superrecycleview.superlibrary.recycleview.SuperRecyclerView;
import com.xq.progressproject.adpter.RecyclerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * RecyclerView 的刷新和加载更多
 * Created by xxq on 2017/7/12.
 */

public class RecycleViewLoadMoreWidthRelfreshActivity extends AppCompatActivity implements View.OnClickListener ,SuperRecyclerView.LoadingListener{

    TextView tv_left;
    SuperRecyclerView rv_recycler;
    List<HashMap<String, Object>> mList = null;

//    RecyclerViewAdapter mAdapter = null;

    RecyclerAdapter mAdapter = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_layout);
        initViews();
        initRecycler();
        mList = new ArrayList<>();
        initAdater();
        initDatas();
    }

    private void initViews(){
        tv_left = (TextView) findViewById(R.id.tv_left);
        tv_left.setOnClickListener(this);
    }

   private void  initRecycler(){
       rv_recycler = (SuperRecyclerView) findViewById(R.id.rv_recycler);
       LinearLayoutManager layoutManager = new LinearLayoutManager(this);
       layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
       rv_recycler.setLayoutManager(layoutManager);
       rv_recycler.setRefreshEnabled(true);// 可以定制是否开启下拉刷新
       rv_recycler.setLoadMoreEnabled(true);// 可以定制是否开启加载更多
       rv_recycler.setLoadingListener(this);// 下拉刷新，上拉加载的监听
       rv_recycler.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);// 下拉刷新的样式
       rv_recycler.setLoadingMoreProgressStyle(ProgressStyle.BallClipRotate);// 上拉加载的样式
       rv_recycler.setArrowImageView(R.mipmap.iconfont_downgrey);// 设置下拉箭头

   }

    private void initAdater(){
        mAdapter = new RecyclerAdapter(RecycleViewLoadMoreWidthRelfreshActivity.this, mList);
        rv_recycler.setAdapter(mAdapter);
    }

    private void initDatas(){
        for (int i = 0; i<20; i++){
            HashMap<String,Object> mMap = new HashMap<>();
            mMap.put("tv_txt" , "Recycler item"+i);
            mList.add(mMap);
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                rv_recycler.completeRefresh();
//                mAdapter.notifyDataSetChanged();
            }
        }, 3000);
    }

    @Override
    public void onLoadMore() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                rv_recycler.completeLoadMore();
            }
        }, 3000);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_left:
                finish();
                break;
            default:
                break;
        }
    }
}
