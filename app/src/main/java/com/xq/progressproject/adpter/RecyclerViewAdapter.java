package com.xq.progressproject.adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xq.progress.progressshadeproject.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by xxq on 2017/7/12.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>  {

    private Context mContext;
    private List<HashMap<String, Object>> mList = null;
    LayoutInflater inflater;
    public RecyclerViewAdapter(Context context,  List<HashMap<String, Object>>  list ){
        this.mContext = context;
        this.mList = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = inflater.inflate(R.layout.recycle_item , null);
        ViewHolder holder = new ViewHolder(mView);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mList.get(position).get("tv_txt")+"");
        holder.iv_map.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.ic_launcher));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ImageView iv_map;
        public ViewHolder(View view){
            super(view);
            mTextView = (TextView) view.findViewById(R.id.tv_text);
            iv_map =  (ImageView)view.findViewById(R.id.iv_map);
        }
    }

}
