package com.xq.progress.progressshadeproject;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by Administrator on 2017/7/6.
 */

public class CoordinatorLayoutActivity extends AppCompatActivity {


   Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coord_layout);

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view,getString(R.string.tv_eg),Snackbar.LENGTH_LONG)
                        .setAction(getString(R.string.tv_cancel), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //这里的单击事件代表点击消除Action后的响应事件

                            }
                        })
                        .show();
            }
        });


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("如此美好的天气啊");
        toolbar.setLogo(getResources().getDrawable(R.mipmap.ic_launcher));

        setSupportActionBar(toolbar);

    }
}
