package com.xq.progress.progressshadeproject;

/**
 * Created by Administrator on 2017/7/10.
 */

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;
import su.levenetc.android.textsurface.Text;
import su.levenetc.android.textsurface.TextBuilder;
import su.levenetc.android.textsurface.TextSurface;
import su.levenetc.android.textsurface.animations.Alpha;
import su.levenetc.android.textsurface.animations.Delay;
import su.levenetc.android.textsurface.animations.Sequential;
import su.levenetc.android.textsurface.animations.Slide;
import su.levenetc.android.textsurface.contants.Align;
import su.levenetc.android.textsurface.contants.Side;

/**
 * 为Ultra-Pull-To-Refresh设置事件回调
 */
public class MyPtrHandler implements PtrUIHandler {
    private Context context;

//    private ImageView img;
//    private TextView tip;

    TextSurface text_surface;

    Text textDaai;

    public MyPtrHandler(Context context, ViewGroup parent) {
        this.context = context;
        View view = LayoutInflater.from(context).inflate(R.layout.view_ptrrefresher, parent);
//        this.img = (ImageView) view.findViewById(R.id.id_header_iv_img);
//        this.tip = (TextView) view.findViewById(R.id.id_header_tv_tip);
        text_surface = (TextSurface) view.findViewById(R.id.text_surface);

    }

    @Override
    public void onUIReset(PtrFrameLayout frame) {
    }

    @Override
    public void onUIRefreshPrepare(PtrFrameLayout frame) {
//        tip.setText("Pull To Refresh");


    }

    @Override
    public void onUIRefreshBegin(PtrFrameLayout frame) {
//        tip.setText("Loading......");
        /*
        *     android:fromDegrees="0.0"
    android:pivotX="50.0%"
    android:pivotY="50.0%"
    android:toDegrees="360.0"
        * */
//        RotateAnimation animation = new RotateAnimation(90, -90, 0, 0);
//        animation.setFillAfter(true);
//        animation.setDuration(1000);
//        img.startAnimation(animation);

        textDaai = TextBuilder
                .create("Daai,")
                .setSize(64)
                .setAlpha(0)
                .setColor(Color.BLACK)
                .setPosition(Align.SURFACE_CENTER).build();
        text_surface.play(
                new Sequential(
                        Slide.showFrom(Side.TOP, textDaai, 5500),
                        Delay.duration(500),
                        Alpha.hide(textDaai, 100)
                )
        );

    }

    @Override
    public void onUIRefreshComplete(PtrFrameLayout frame, boolean isHeader) {
//        tip.setText("Load Complete");
//        Toast.makeText(context, "Load Complete!!", Toast.LENGTH_SHORT).show();

        text_surface.play(new Sequential(Alpha.hide(textDaai , 500)));
    }



    @Override
    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {
    }
}