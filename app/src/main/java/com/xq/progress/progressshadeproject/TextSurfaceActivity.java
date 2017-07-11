package com.xq.progress.progressshadeproject;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

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
 * Created by Administrator on 2017/7/11.
 */

public class TextSurfaceActivity extends AppCompatActivity {

    TextSurface text_surface;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_surface);

        text_surface = (TextSurface) findViewById(R.id.text_surface);

        Text textDaai = TextBuilder
                .create("Daai,")
                .setSize(64)
                .setAlpha(0)
                .setColor(Color.WHITE)
                .setPosition(Align.SURFACE_CENTER).build();


        text_surface.play(
                new Sequential(
                        Slide.showFrom(Side.TOP, textDaai, 5500),
                        Delay.duration(500),
                        Alpha.hide(textDaai, 100)
                )
        );

    }
}
