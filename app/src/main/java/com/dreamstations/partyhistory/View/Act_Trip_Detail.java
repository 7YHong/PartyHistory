package com.dreamstations.partyhistory.View;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dreamstations.partyhistory.Adapter.CommonPagerAdapter;
import com.dreamstations.partyhistory.R;

import java.util.Arrays;

/**
 * Created by 7YHong on 2015/11/29.
 */
public class Act_Trip_Detail extends AppCompatActivity {
    final static Integer[] imgs = {R.drawable.item_trip_img, R.drawable.trip_detail_img, R.drawable.item_trip_img, R.drawable.trip_detail_img};
    ViewPager gallery;
    float density;//屏幕密度，用来进行dp的转化

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.act_trip_detail);
        gallery = (ViewPager) findViewById(R.id.trip_detail_gallery);
        ((LinearLayout)gallery.getParent()).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gallery.dispatchTouchEvent(event);
            }
        });
        CommonPagerAdapter adapter = new CommonPagerAdapter<Integer>(getApplicationContext(), Arrays.asList(imgs)) {
            @Override
            public View instantiateView( Integer item) {
                ImageView v = new ImageView(getApplicationContext());
                v.setAdjustViewBounds(true);
                v.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
                v.setScaleType(ImageView.ScaleType.FIT_XY);
                v.setImageResource(item);
                return v;
            }
        };
        adapter.setEnableCirculatedScroll(true);   //开启滚动循环模式
        gallery.setOffscreenPageLimit(3);
        gallery.setPageMargin(8);
        gallery.setAdapter(adapter);
        gallery.setCurrentItem(401);               //开始就能向左滑动
        gallery.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                gallery.invalidate();
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
