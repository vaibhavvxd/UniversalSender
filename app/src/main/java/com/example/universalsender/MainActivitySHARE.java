package com.example.universalsender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivitySHARE extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button share=(Button)findViewById(R.id.button);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_TEXT," Read android Share Function at https://play.google.com/store/apps/details?id=colorsfx.android.smart.courses&hl=en");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "SMART ANDROID COURSE");
                startActivity(Intent.createChooser(sharingIntent, "Share via"));

            }
        });
    }
}