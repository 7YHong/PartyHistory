package com.dreamstations.partyhistory.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.dreamstations.partyhistory.R;

/**
 * Created by 7YHong on 2015/11/28.
 */
public class Item_Home extends LinearLayout{
    private static final int[] mAttrs={android.R.attr.src,android.R.attr.text};

    public Item_Home(Context context) {
        this(context, null);

    }

    public Item_Home(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Item_Home(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @SuppressLint("NewApi")
    public Item_Home(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    void init(AttributeSet attrs){
        inflate(getContext(), R.layout.item_home, this);
        LinearLayout layout= (LinearLayout) this.getChildAt(0);
        TypedArray ta=getContext().obtainStyledAttributes(attrs,mAttrs);
        ((ImageView)layout.getChildAt(0)).setImageResource(ta.getResourceId(0,-1));
        ((TextView)layout.getChildAt(1)).setText(ta.getString(1));
        ta.recycle();
    }

}
