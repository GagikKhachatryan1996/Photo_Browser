package com.aca.photobrowser;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrConfig;
import com.r0adkll.slidr.model.SlidrInterface;
import com.r0adkll.slidr.model.SlidrPosition;

public class Preview extends AppCompatActivity {

    private ImageView nkar2;
    private SlidrInterface slidr;
    private SlidrConfig slidrConfig;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        setTitle("Preview Activity");

        nkar2 = findViewById(R.id.nkar2);

        slidrConfig =new SlidrConfig.Builder().position(SlidrPosition.TOP).build();

        int x=getIntent().getIntExtra("images",0);
        nkar2.setImageResource(x);


        slidr= Slidr.attach(this,slidrConfig);
    }
}
