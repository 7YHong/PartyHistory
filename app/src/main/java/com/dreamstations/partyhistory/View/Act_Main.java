package com.dreamstations.partyhistory.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dreamstations.partyhistory.Adapter.CommonPagerAdapter;
import com.dreamstations.partyhistory.R;

import junit.runner.Version;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 7YHong on 2015/11/28.
 */
public class Act_Main extends AppCompatActivity{
    //临时数据
    List<Integer> images=new ArrayList<>();

    ViewPager titlevp;
    LinearLayout dots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        //初始化xUtils
        x.Ext.init(getApplication());
        x.Ext.setDebug(true);
        initViews();
    }

    private void initViews() {
        titlevp= (ViewPager) findViewById(R.id.home_vp);
        dots= (LinearLayout) findViewById(R.id.home_vp_dots);
//        setImages();
        for (int i=0;i<2;i++)
            images.add(R.drawable.home_viewpager_title1);
        PagerAdapter vpAdapter=new CommonPagerAdapter<Integer>(getApplicationContext(),images) {
            @Override
            public View instantiateView(Integer item) {
                ImageView iv=new ImageView(getApplicationContext());
                iv.setAdjustViewBounds(true);
                iv.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
                iv.setScaleType(ImageView.ScaleType.FIT_XY);
                iv.setImageResource(item);
                return iv;
            }
        };
        titlevp.setAdapter(vpAdapter);
        findViewById(R.id.home_trip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Act_Trip.class));
            }
        });
        findViewById(R.id.home_media).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Act_Media.class));
            }
        });
    }

}
