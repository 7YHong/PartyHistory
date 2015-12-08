package com.dreamstations.partyhistory.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.dreamstations.partyhistory.R;

/**
 * Created by 7YHong on 2015/11/29.
 */
public class Act_Trip_Detail extends AppCompatActivity{
    final static int[] imgs={R.drawable.item_trip_img,R.drawable.trip_detail_img,R.drawable.item_trip_img,R.drawable.trip_detail_img};
    GridView gridView;
    float density;//屏幕密度，用来进行dp的转化
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //获取屏幕信息
//        DisplayMetrics dm = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//        density = dm.density;
        setContentView(R.layout.act_trip_detail);
//        gridView= (GridView) findViewById(R.id.home_trip_grid);
//        ListAdapter adapter=new ImgAdapter();
//        gridView.setAdapter(adapter);
//        int size=imgs.length;
//        //计算每张图的宽度与总的宽度
//        int itemWidth = (int) ((dm.widthPixels-10)/3);
//        int totalWidth = itemWidth*size;
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
//                totalWidth, ViewGroup.LayoutParams.MATCH_PARENT);
//        gridView.setLayoutParams(params);
//        gridView.setColumnWidth(itemWidth);
//        gridView.setHorizontalSpacing(10);
//        gridView.setNumColumns(size);
    }


    private class ImgAdapter extends BaseAdapter{
        SparseArray<View> list=new SparseArray<>();

        @Override
        public int getCount() {
            return imgs.length;
        }

        @Override
        public Object getItem(int position) {
            return imgs[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v=list.get(position);
            System.out.println(position);
            if (v==null){
                v=new ImageView(getApplicationContext());
                v.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int)(160*density)));
//                ((ImageView)v).setImageResource(imgs[position]);
//                ((ImageView)v).setAdjustViewBounds(true);
                v.setBackgroundResource(imgs[position]);
                list.put(position, v);
            }
            return v;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:finish();break;
        }
        return super.onOptionsItemSelected(item);
    }
}
