package com.fu.timershaftview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Fu.
 * QQ:908323236
 * 2018/1/10 14:32
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<LogisticsBean> mDatas;

    public MyAdapter(Context context, ArrayList<LogisticsBean> datas) {
        this.mContext = context;
        this.mDatas = datas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_timer, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        LogisticsBean data = mDatas.get(position);
        holder.tv_date.setText(data.getDate());
        holder.tv_time.setText(data.getTime());
        holder.tv_title.setText(data.getTitle());
        holder.tv_content.setText(data.getContent());

        if (position == 0) {
            //最上面的一条颜色是橙色,其他的是灰色了
            holder.tv_date.setTextColor(mContext.getResources().getColor(R.color.orange));
            holder.tv_time.setTextColor(mContext.getResources().getColor(R.color.orange));
            holder.tv_title.setTextColor(mContext.getResources().getColor(R.color.orange));
            holder.tv_content.setTextColor(mContext.getResources().getColor(R.color.orange));
        }

        //控制图片的显示
        if (data.getState() == 1) {
            //1完成
            holder.iv_state.setImageResource(R.mipmap.ok_orange);
        } else {
            if (TextUtils.isEmpty(data.getTitle())) {
                holder.iv_state.setImageResource(R.mipmap.dot);
            } else {
                if (position == 0) {
                    holder.iv_state.setImageResource(R.mipmap.arrow_orange);
                } else {
                    holder.iv_state.setImageResource(R.mipmap.arrow_gray);
                }
            }
        }

        //控制日期字体大小的显示
        if (TextUtils.isEmpty(data.getTitle())) {
            holder.tv_title.setVisibility(View.GONE);
            holder.tv_date.setTextSize(10);
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_date;
        TextView tv_time;
        ImageView iv_state;
        TextView tv_title;
        TextView tv_content;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_time = itemView.findViewById(R.id.tv_time);
            iv_state = itemView.findViewById(R.id.iv_state);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_content = itemView.findViewById(R.id.tv_content);
        }
    }

}
