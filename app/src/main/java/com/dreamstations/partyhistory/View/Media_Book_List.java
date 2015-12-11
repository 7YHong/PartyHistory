package com.dreamstations.partyhistory.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dreamstations.partyhistory.Adapter.CommonAdapter;
import com.dreamstations.partyhistory.Model.BookItem;
import com.dreamstations.partyhistory.R;
import com.dreamstations.partyhistory.ViewHolder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;

/**
 * Created by QYH on 2015/12/11.
 */
public class Media_Book_List extends AppCompatActivity{
    public final static int[] imageId = {R.drawable.bookimage1, R.drawable.bookimage2, R.drawable.bookimage3, R.drawable.bookimage4, R.drawable.bookimage5};
    List<BookItem> bookItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_book_list);
        loadData();
        initView();
//        reSaveData();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /**
     * 重新把书籍列表导出到内存卡
     */
    private void reSaveData() {
        Gson gson=new Gson();
        File dir=getExternalFilesDir(null);
        File outfile=new File(dir,"bookdata.json");
        try{
            if (!outfile.exists())
                outfile.createNewFile();
            PrintWriter printWriter=new PrintWriter(outfile,"UTF-8");
            String data=gson.toJson(bookItemList);
            printWriter.write(data);
            printWriter.flush();
            printWriter.close();
            Toast.makeText(getApplicationContext(),"数据已保存到:"+dir.getPath(),Toast.LENGTH_LONG).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void initView() {
        ListView listView= (ListView) findViewById(R.id.media_book_list);
        ListAdapter adapter=new CommonAdapter<BookItem>(getApplicationContext(),bookItemList,R.layout.item_book) {
            @Override
            protected void convert(ViewHolder holder, BookItem item) {
                ((TextView)holder.getView(R.id.book_title)).setText(item.getTitle());
                ((TextView)holder.getView(R.id.book_author)).setText(item.getAuthor());
                ((TextView)holder.getView(R.id.book_introduction)).setText(item.getIntroduction());
                ((ImageView)holder.getView(R.id.book_image)).setImageResource(imageId[item.getId()]);
            }
        };
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),Media_Book_Detail.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("bookitem", (BookItem) parent.getItemAtPosition(position));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void loadData() {
        Gson gson=new Gson();
        InputStream dataInput=getResources().openRawResource(R.raw.bookdata);
        try {
            BufferedReader reader=new BufferedReader(new InputStreamReader(dataInput,"UTF-8"));
            bookItemList=gson.fromJson(reader,new TypeToken<List<BookItem>>(){}.getType());
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
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
