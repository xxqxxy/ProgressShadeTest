package com.xq.progress.progressshadeproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.michaldrabik.tapbarmenulib.TapBarMenu;

/**
 * http://www.jcodecraeer.com/a/opensource/2015/1210/3763.html 文章网址
 *
 * Created by Administrator on 2017/7/6.
 */

public class BottomMiddleMenuActivity extends Activity {

    TapBarMenu tapBarMenu;

    ImageView item1,item2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_midlle_menu);
        tapBarMenu  =(TapBarMenu) findViewById(R.id.tapBarMenu);
        tapBarMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tapBarMenu.toggle();
            }
        });

        item1 =(ImageView) findViewById(R.id.item1);
        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tapBarMenu.toggle();
                Toast.makeText(BottomMiddleMenuActivity.this,"on click item1", Toast.LENGTH_SHORT).show();
            }
        });
        item2 =(ImageView) findViewById(R.id.item2);
        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tapBarMenu.toggle();
                Toast.makeText(BottomMiddleMenuActivity.this,"on click item2", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
