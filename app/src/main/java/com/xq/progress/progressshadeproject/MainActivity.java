package com.xq.progress.progressshadeproject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import static android.view.View.X;

public class MainActivity extends Activity {

    ProgressDialog mPrgoressDialog;
    Context mContext = MainActivity.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //进度条
        ((Button) findViewById(R.id.btn_progress)).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
        //公告滚动
        ((Button) findViewById(R.id.btn_upfipping)).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
              startActivity(new Intent(mContext,FillActivity.class));
            }
        });
        //悬浮菜单
        ((Button) findViewById(R.id.btn_suspend_menu)).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
               startActivity(new Intent(mContext,SuspendMenuActivity.class));
            }
        });



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
