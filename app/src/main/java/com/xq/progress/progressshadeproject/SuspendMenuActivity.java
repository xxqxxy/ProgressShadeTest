package com.xq.progress.progressshadeproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.github.yavski.fabspeeddial.FabSpeedDial;
import io.github.yavski.fabspeeddial.SimpleMenuListenerAdapter;


/**
 * Created by xxq on 2017/6/28.
 */
public class SuspendMenuActivity extends Activity  {

    FabSpeedDial fs_menu;
    ListView lv_list;
    List<HashMap<String,Object>> menuList = null;
    SimpleAdapter iAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suspend_menu_layout);

        menuList = new ArrayList<>();

        initFsMenu();
        lv_list = (ListView) findViewById(R.id.lv_list);
        iAdapter = new SimpleAdapter(SuspendMenuActivity.this,menuList,android.R.layout.activity_list_item,new String[]{"icon","title"},
                new int[]{android.R.id.icon,  android.R.id.text1});
        lv_list.setAdapter(iAdapter);
        initListView();

    }

    private void initFsMenu(){
        fs_menu = (FabSpeedDial)findViewById(R.id.fs_menu);
        fs_menu.setMenuListener(new SimpleMenuListenerAdapter(){
            @Override
            public boolean onMenuItemSelected(MenuItem menuItem) {
                Toast.makeText(SuspendMenuActivity.this, "点击了："+menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                return super.onMenuItemSelected(menuItem);
            }
        });
    }

   private void  initListView(){
       initLVData();
   }
    private void initLVData(){
        for (int i = 0;i<=60; i++){
            HashMap<String,Object> menuMap = new HashMap<>();
            menuMap.put("icon",R.mipmap.ic_launcher);
            menuMap.put("title","这是源自AndroidStudio的第"+i+"个数");
            menuList.add(menuMap);
        }
        iAdapter.notifyDataSetChanged();
    }


}
