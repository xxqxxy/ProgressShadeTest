package com.xq.progress.progressshadeproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.xq.progressproject.view.MyPtrRefresher;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.header.StoreHouseHeader;

/**
 * Created by xxq on 2017/7/10.
 */

public class pullRefleshActivity extends AppCompatActivity{

    private PtrClassicFrameLayout ptrLayout;
    private ListView lv;

    private ArrayAdapter<String> adapter;
    private List<String> dataSource;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pull_reflesh);
        ptrLayout = (PtrClassicFrameLayout) findViewById(R.id.ptr_layout);
        lv = (ListView) findViewById(R.id.id_main_lv_lv);


    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
        initView();
        initEvent();
    }


    /**
     * 初始化数据
     */
    private void initData() {
        // 初始化ListView中展示的数据
        dataSource = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            dataSource.add("Existed Old List Item " + i);
        }
    }

    /**
     * 初始化布局控件
     */
    private void initView() {
        // 初始化ListView中的数据
        adapter = new ArrayAdapter<String>(pullRefleshActivity.this, android.R.layout.simple_list_item_1, dataSource);
        lv.setAdapter(adapter);
        // 为布局设置头部和底部布局
        ptrLayout.setHeaderView(new MyPtrRefresher(pullRefleshActivity.this));
        // ptrLayout.setFooterView(new MyPtrRefresher(MainActivity.this));
//        ptrLayout.addPtrUIHandler(new MyPtrHandler(pullRefleshActivity.this, ptrLayout));



        StoreHouseHeader footer = new StoreHouseHeader(pullRefleshActivity.this);
        footer.setPadding(0,30, 0, 30);
        footer.setTextColor(getResources().getColor(R.color.cr_green_5));
        footer.initWithString("loading");

        ptrLayout.setFooterView(footer);
        ptrLayout.addPtrUIHandler(footer);


    }

    /**
     * 初始化事件
     */
    private void initEvent() {
        // 为布局设置下拉刷新和上拉加载的回调事件
        ptrLayout.setPtrHandler(new PtrDefaultHandler2() {
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) { // 上拉加载的回调方法
                frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dataSource.add("New Bottom List Item");
                        adapter.notifyDataSetChanged();
                        ptrLayout.refreshComplete();
                        lv.smoothScrollToPosition(dataSource.size() - 1);
                    }
                }, 1000);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) { // 下拉刷新的回调方法
                frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dataSource.add(0, "New Top List Item");
                        adapter.notifyDataSetChanged();
                        ptrLayout.refreshComplete();
                        lv.smoothScrollToPosition(0);
                    }
                }, 1000);
            }
        });
    }
}

