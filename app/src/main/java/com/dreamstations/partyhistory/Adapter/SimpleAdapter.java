package com.dreamstations.partyhistory.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.dreamstations.partyhistory.ViewHolder;

import java.util.List;

/**
 * Created by 7YHong on 2015/11/29.
 */
public abstract class SimpleAdapter<T> extends BaseAdapter{
    protected Context context;
    protected List<T> mDatas;
    protected int ItemLayoutID;

    public SimpleAdapter(Context context, List<T> mDatas, int itemLayoutID) {
        this.context = context;
        this.mDatas = mDatas;
        ItemLayoutID = itemLayoutID;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder=ViewHolder.get(context,convertView,parent,ItemLayoutID);
        convert(holder,mDatas.get(position));
        return holder.getmConvertView();
    }

    protected abstract void convert(ViewHolder holder, T item);

}
