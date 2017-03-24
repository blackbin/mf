package com.jzhu.study.mf.ui.adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jzhu.study.datalayer.entities.GankFLEntities;
import com.jzhu.study.mf.R;

import java.util.List;

/**
 * Created by zhujian on 2017/3/24.
 */

public class GankIoFLAdapter extends RecyclerView.Adapter<GankIoFLAdapter.MyViewHolder>{

    private LayoutInflater inflater;

    private List<GankFLEntities> datas;

    public GankIoFLAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(inflater.inflate(R.layout.rv_gankio_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.urlView.setText(datas.get(position).getUrl());
    }

    @Override
    public int getItemCount() {
        return null == datas ? 0 : datas.size();
    }

    public void setData(List<GankFLEntities> datas){
        this.datas = datas;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView urlView;

        public MyViewHolder(View itemView) {
            super(itemView);
            urlView = (TextView) itemView.findViewById(R.id.rv_url);
        }
    }

}
