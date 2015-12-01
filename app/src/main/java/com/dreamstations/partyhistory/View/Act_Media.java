package com.dreamstations.partyhistory.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dreamstations.partyhistory.R;

/**
 * Created by 7YHong on 2015/12/1.
 */
public class Act_Media extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_media);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
