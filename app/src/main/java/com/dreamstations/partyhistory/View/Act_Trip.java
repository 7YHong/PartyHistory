package com.dreamstations.partyhistory.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.dreamstations.partyhistory.Adapter.SimpleAdapter;
import com.dreamstations.partyhistory.Model.Trip;
import com.dreamstations.partyhistory.R;
import com.dreamstations.partyhistory.ViewHolder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 7YHong on 2015/11/29.
 */
public class Act_Trip extends AppCompatActivity{
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_trip);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listView= (ListView) findViewById(R.id.listview);
        List<Trip> trips =new ArrayList<>();
        for (int i=0;i<8;i++){
            trips.add(new Trip());
        }
        ListAdapter adapter=new SimpleAdapter<Trip>(getApplicationContext(), trips,R.layout.item_trip) {
            @Override
            protected void convert(ViewHolder holder, Trip item) {
            }
        };
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getApplicationContext(),Act_Trip_Detail.class));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:finish();break;
        }
        return super.onOptionsItemSelected(item);
    }
}
