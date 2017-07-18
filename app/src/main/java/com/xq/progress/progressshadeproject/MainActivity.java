package com.xq.progress.progressshadeproject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends Activity {

    ProgressDialog mPrgoressDialog;
    Context mContext = MainActivity.this;
    private static final String APATCH_PATH = "/fix.apatch"; // 补丁文件名

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //进度条
        ((Button) findViewById(R.id.btn_progress)).setText("别点");
        ((Button) findViewById(R.id.btn_progress)).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                showDialog();

//                showToast();
            }
        });
        //公告滚动
        ((Button) findViewById(R.id.btn_upfipping)).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
              startActivity(new Intent(mContext,FillActivity.class));
            }
        });
        //底部中间悬浮菜单
        ((Button) findViewById(R.id.btn_middle_menu)).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
               startActivity(new Intent(mContext,BottomMiddleMenuActivity.class));
            }
        });

        //悬浮菜单
        ((Button) findViewById(R.id.btn_suspend_menu)).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext,SuspendMenuActivity.class));
            }
        });
        //Android 热修复
        ((Button) findViewById(R.id.btn_fix)).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                update();
            }
        });
        //CoordinatorLayout
        ((Button) findViewById(R.id.btn_cdl)).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext,CoordinatorLayoutActivity.class));
            }
        });
        //列表刷新
       ((Button) findViewById(R.id.btn_pull_refresh)).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext,pullRefleshActivity.class));
            }
        });
        //TextSurfaceAnimation
        ((Button) findViewById(R.id.btn_text_surface)).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext,TextSurfaceActivity.class));
            }
        });

        //RecycleView
        ((Button) findViewById(R.id.btn_recycle)).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext,RecycleViewLoadMoreWidthRelfreshActivity.class));
            }
        });


        ((Button) findViewById(R.id.btn_gallery)).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext,GalleryActivity.class));
            }
        });



        ((Button) findViewById(R.id. btn_pull_listview)).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext,pullListViewActivity.class));
            }
        });




    }


    private void showToast() {
        Toast.makeText(this, "打补丁之后", Toast.LENGTH_LONG).show();
    }

    private void update() {
        String patchFileStr = Environment.getExternalStorageDirectory().getAbsolutePath() + APATCH_PATH;
        try {
            XqApplication.mPatchManager.addPatch(patchFileStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * 选择的编译版本不同Dialog效果也不同
     *
     */
    private void showDialog() {
        if (mPrgoressDialog == null) {
            mPrgoressDialog = new ProgressDialog(MainActivity.this);
            // 设置进度条风格，风格为圆形，旋转的
            mPrgoressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            // 设置ProgressDialog 标题图标
            mPrgoressDialog.setIcon(android.R.drawable.btn_star);
            // 设置ProgressDialog 的进度条是否不明确
            mPrgoressDialog.setIndeterminate(false);
            // 设置ProgressDialog 是否可以按退回按键取消
//            mPrgoressDialog.setCancelable(false);

        }
        //设置ProgressDialog 提示信息
        mPrgoressDialog.setMessage("正在加载...");
        // 让ProgressDialog显示
        mPrgoressDialog.show();

    }
}
