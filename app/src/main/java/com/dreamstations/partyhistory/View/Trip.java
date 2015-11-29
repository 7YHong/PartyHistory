package com.dreamstations.partyhistory.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.dreamstations.partyhistory.Adapter.SimpleAdapter;
import com.dreamstations.partyhistory.Model.SingleTrip;
import com.dreamstations.partyhistory.R;
import com.dreamstations.partyhistory.ViewHolder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 7YHong on 2015/11/29.
 */
public class Trip extends AppCompatActivity{
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_trip);
        listView= (ListView) findViewById(R.id.listview);
        List<SingleTrip> singleTrips =new ArrayList<>();
        for (int i=0;i<8;i++){
            singleTrips.add(new SingleTrip());
        }
        ListAdapter adapter=new SimpleAdapter<SingleTrip>(getApplicationContext(), singleTrips,R.layout.item_trip) {
            @Override
            protected void convert(ViewHolder holder, SingleTrip item) {
            }
        };
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getApplicationContext(),Trip_Detail.class));
            }
        });
    }
}
