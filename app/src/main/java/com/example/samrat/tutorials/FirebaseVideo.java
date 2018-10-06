package com.example.samrat.tutorials;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.VideoView;

import java.util.ArrayList;

public class FirebaseVideo extends AppCompatActivity {

    private Uri videoUri;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_video);

        videoView = findViewById(R.id.videoView2);

        final Intent intent = getIntent();

        String url = intent.getStringExtra("URL");
       // String type = intent.getStringExtra("TYPE");

        //if(type.length()==3){

          //  Intent intent1 = new Intent(getApplicationContext(),PDFActivity.class);
           // intent1.putExtra("LINK",url);
            //startActivity(intent1);

        //}else if(type.length() == 5){

            videoUri = Uri.parse(url);

            videoView.setVideoURI(videoUri);
            videoView.requestFocus();
            videoView.start();
        //}
    }
}
