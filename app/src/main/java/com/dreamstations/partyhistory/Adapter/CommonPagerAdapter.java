package com.dreamstations.partyhistory.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by QYH on 2015/12/11.
 */
public abstract class CommonPagerAdapter<T> extends PagerAdapter {
    Context context;
    List<T> data;
    SparseArray<View> views;
    int count;
    int MAXCOUNT;

    public CommonPagerAdapter(Context context, @NonNull List<T> data) {
        this.context = context;
        this.data = data;
        count = data.size();
        MAXCOUNT=count;
        views = new SparseArray<>();
    }

    public abstract View instantiateView(T item);

    //专门为无限循环设计，配合setCurrentItem可一开始就向左滑动
    public void setEnableCirculatedScroll(boolean isEnableUnlimitScroll){
        if (isEnableUnlimitScroll) MAXCOUNT=Integer.MAX_VALUE;
    }

    public T getItem(int position) {
        return data.get(position % count);
    }

    @Override
    public int getCount() {
        return MAXCOUNT;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View v = views.get(position % count);
        if (v == null) {
            v = instantiateView(getItem(position));
            container.addView(v);
        }
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
