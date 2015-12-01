package com.dreamstations.partyhistory.View;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.dreamstations.partyhistory.Adapter.ViewPagerAdapter;
import com.dreamstations.partyhistory.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 7YHong on 2015/11/28.
 */
public class Act_Main extends AppCompatActivity{
    //临时数据
    List<Bitmap> images;

    public void setImages() {
        images=new ArrayList<>();
        for (int i=0;i<2;i++){
            Bitmap b=BitmapFactory.decodeResource(getResources(),R.drawable.home_viewpager_title1);
            images.add(b);
        }
    }

    private DrawerLayout mDrawerLayout;
    ViewPager titlevp;
    LinearLayout dots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        initViews();
    }

    private void initViews() {
        titlevp= (ViewPager) findViewById(R.id.home_vp);
        dots= (LinearLayout) findViewById(R.id.home_vp_dots);
        setImages();
        PagerAdapter vpAdapter=new ViewPagerAdapter(getApplicationContext(),images);
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
