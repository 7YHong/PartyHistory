package com.dreamstations.partyhistory;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 7YHong on 2015/11/29.
 */
public class ViewHolder {
    private final SparseArray<View> mViews;
    private View mConvertView;

    private ViewHolder(Context context, ViewGroup parent, int ItemLayoutID) {
        this.mViews = new SparseArray<View>();
        this.mConvertView = LayoutInflater.from(context).inflate(ItemLayoutID, parent, false);
        mConvertView.setTag(this);
    }

    public static ViewHolder get(Context context, View convertView, ViewGroup parent, int ItemLayoutID) {
        if (convertView == null)
            return new ViewHolder(context, parent, ItemLayoutID);
        return (ViewHolder) convertView.getTag();
    }

    public View getmConvertView() {
        return mConvertView;
    }

    public <T extends View> T getView(int viewID) {
        View view = mViews.get(viewID);
        if (view == null) {
            view = mConvertView.findViewById(viewID);
            mViews.put(viewID, view);
        }
        return (T) view;
    }
}
