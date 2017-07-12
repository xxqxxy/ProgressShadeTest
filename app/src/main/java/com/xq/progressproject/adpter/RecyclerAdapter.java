package com.xq.progressproject.adpter;

import android.content.Context;

import com.superrecycleview.superlibrary.adapter.BaseViewHolder;
import com.superrecycleview.superlibrary.adapter.SuperBaseAdapter;
import com.xq.progress.progressshadeproject.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by xxq on 2017/7/12.
 */

public class RecyclerAdapter extends SuperBaseAdapter<HashMap<String,Object>> {

    public RecyclerAdapter(Context context, List<HashMap<String, Object>> data){
        super(context, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, HashMap<String, Object> item, int position) {
        holder.setText(R.id.tv_text, item.get("tv_txt")+"");

//       ImageView iv_map = (ImageView)holder.itemView;



//        holder.itemView.setImageResource(R.mipmap.ic_launcher);
//        holder.setImageURI(R.id.iv_map , Uri.parse("http://pic6.huitu.com/res/20130116/84481_20130116142820494200_1.jpg"));
    }

    @Override
    protected int getItemViewLayoutId(int position, HashMap<String, Object> item) {
        return R.layout.recycle_item;
    }


}
