package com.xq.progressproject.progressproject.utils;

import android.content.Context;

/**
 * Created by Administrator on 2017/7/7.
 */

public class comFunction {
    /**dip转化成px 尺寸单位=>像素单位
     * @param dpValue 要转化的尺寸值
     * @param context
     */
    public static int dip2px(Context context, float dpValue) {
        if(dpValue == 0)return 0;
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
    /**px转化成dip  像素单位=>尺寸单位
     * @param pxValue 要转化的像素值
     * @param context
     */
    public static int px2dip(Context context, float pxValue) {
        if(pxValue == 0)return 0;
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

}
