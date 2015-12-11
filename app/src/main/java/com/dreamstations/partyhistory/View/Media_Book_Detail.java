package com.dreamstations.partyhistory.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.dreamstations.partyhistory.Model.BookItem;
import com.dreamstations.partyhistory.R;

/**
 * Created by QYH on 2015/12/11.
 */
public class Media_Book_Detail extends AppCompatActivity{
    BookItem bookItem;

    TextView title,author,publisher,publicationdate,introduction;
    ImageView icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_book_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bookItem= (BookItem) getIntent().getSerializableExtra("bookitem");
        initViews();
    }

    private void initViews() {
        title= (TextView) findViewById(R.id.book_detail_title);
        author= (TextView) findViewById(R.id.book_detail_author);
        publisher= (TextView) findViewById(R.id.book_detail_publisher);
        publicationdate= (TextView) findViewById(R.id.book_detail_publicationdate);
        introduction= (TextView) findViewById(R.id.book_detail_introduction);
        icon= (ImageView) findViewById(R.id.book_detail_image);

        setTitle(bookItem.getTitle());

        title.setText(bookItem.getTitle());
        author.setText(bookItem.getAuthor());
        publisher.setText(bookItem.getPublisher());
        publicationdate.setText(bookItem.getPublicationDate());
        introduction.setText(bookItem.getIntroduction());
        icon.setImageResource(Media_Book_List.imageId[bookItem.getId()]);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:finish();break;
        }
        return super.onOptionsItemSelected(item);
    }
}
