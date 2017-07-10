package com.xq.progress.progressshadeproject;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ListView;

import com.xq.progressproject.progressproject.utils.comFunction;

/**
 * Created by Administrator on 2017/7/6.
 */

public class CoordinatorLayoutActivity extends AppCompatActivity {

    NestedScrollView ns_view;
   Toolbar toolbar;
    boolean isFabOpened = false;//FloatActionBar 是否点击
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
                        }).setActionTextColor(getResources().getColor(R.color.colorAccent))
                        .show();

            }
        });


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("如此美好的天气啊");

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        setSupportActionBar(toolbar);


        ns_view = (NestedScrollView) findViewById(R.id.ns_view);
        ListView listView;


        /**滑动监听设置返回键是否可见**/
        ns_view.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                float alpha =  toolbar.getAlpha();
                Log.d("TAG" , "[onScrollChange] : oldScrollY = " + oldScrollY + " scrollY = "+scrollY);
                int height  =  comFunction.dip2px(CoordinatorLayoutActivity.this, 280);
                if(scrollY >=1 ){
                    toolbar.setLogo(getResources().getDrawable(R.mipmap.icon_black_back));
                }else{
                    toolbar.setLogo(null);
                }



            }
        });

    }

    public void openMenu(View view){
        ObjectAnimator animator = ObjectAnimator.ofFloat(view,"rotation",0,-155,-135);
        animator.setDuration(500);
        animator.start();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0,0.7f);
        alphaAnimation.setDuration(500);
        alphaAnimation.start();
        alphaAnimation.setFillAfter(true);
        //
    }



}
