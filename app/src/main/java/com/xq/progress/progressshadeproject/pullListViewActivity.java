package com.xq.progress.progressshadeproject;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.comutils.pulltorefresh.PullToRefreshBase;
import com.comutils.pulltorefresh.PullToRefreshListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by xxq on 2017/7/18.
 */

public class pullListViewActivity extends Activity {

    PullToRefreshListView m_pv;
    ListView m_lv;
    SimpleAdapter simpleAdapter =null;
    List<HashMap<String ,Object>> mList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pull_listview);
        initPullListViews();

    }

    private void initPullListViews() {
        m_pv = (PullToRefreshListView) findViewById(R.id.m_pv);
        m_pv.setPullLoadEnabled(true);
        // 滚动到底自动加载可用
        m_pv.setScrollLoadEnabled(false);
        // 得到实际的ListView
        m_lv = m_pv.getRefreshableView();
        m_lv.setSelector(getResources().getDrawable(android.R.color.transparent));
        m_lv.setDescendantFocusability(ListView.FOCUS_AFTER_DESCENDANTS);
        m_lv.setFocusable(false);
        m_lv.setVerticalScrollBarEnabled(true);
        m_lv.setDividerHeight(0);
        m_lv.setDivider(new ColorDrawable(getResources().getColor(R.color.cr_gray1)));
        m_lv.setDividerHeight((int) (getResources().getDisplayMetrics().density * 5));
        m_lv.setDivider(new ColorDrawable(getResources().getColor(R.color.cr_gray1)));

        mList = new ArrayList<HashMap<String, Object>>();

        simpleAdapter = new SimpleAdapter(pullListViewActivity.this, mList ,R.layout.pull_list_item,new String[]{ "tv_txt"} , new int[]{R.id.tv_txt
        });
        m_lv.setAdapter(simpleAdapter);

        m_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(pullListViewActivity.this, "第"+position+"个" , Toast.LENGTH_SHORT).show();
            }
        });

        // 设置下拉刷新的listener
        m_pv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
               mList.clear();
                initDatas();
                m_pv.onPullDownRefreshComplete();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                initDatas();
                m_pv.onPullUpRefreshComplete();
            }
        });
        m_pv.doPullRefreshing(true, 1500);

    }

    private void initDatas() {

        for (int i = 0; i<15;i++){
            HashMap<String , Object> hMap = new HashMap<>();
            hMap.put("tv_txt" , "test pull to reflesh listview "+i);
            mList.add(hMap);
        }
        simpleAdapter.notifyDataSetChanged();

    }
}
