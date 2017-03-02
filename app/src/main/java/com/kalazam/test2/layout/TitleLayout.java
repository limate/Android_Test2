package com.kalazam.test2.layout;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.kalazam.test2.R;

import java.util.jar.Attributes;

/**
 * Created by Administrator on 2017/2/28.
 */

public class TitleLayout extends LinearLayout {
    public TitleLayout(Context context, AttributeSet attributeset){
        super(context,attributeset);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        Button title_back = (Button) findViewById(R.id.title_back);
        title_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
    }
}
