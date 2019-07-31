package com.example.stylemakerapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class MainSplashActivity extends AppCompatActivity {
    private GifImageView gifImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_splash);
        gifImageView = findViewById(R.id.gifimageview);
        //Set GIFImageView resource
        try{
            InputStream inputStream = getAssets().open("logodesign.gif");
            byte[] bytes = IOUtils.toByteArray(inputStream);
            gifImageView.setBytes(bytes);
            gifImageView.startAnimation();
        }
        catch (IOException ex)
        {

        }

        //Wait for 5 seconds and start Activity Main
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MainSplashActivity.this.startActivity(new Intent(MainSplashActivity.this,navigation_Home.class));
                MainSplashActivity.this.finish();
            }
        },9000);
    }
}
