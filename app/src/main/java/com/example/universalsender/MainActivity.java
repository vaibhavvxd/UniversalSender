package com.example.universalsender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button popupbut;
    private Object v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        popupbut =(Button)findViewById(R.id.button);
        popupbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popup = new PopupMenu(MainActivity.this,popupbut);

                popup.getMenuInflater().inflate(R.menu.options, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        if(item.getTitle().equals("SEND SMS")){
                            Intent i = new Intent(MainActivity.this, MainActivitySMS.class);
                            startActivity(i);
                        }
                        else if(item.getTitle().equals("SEND MAIL")){
                            Intent i = new Intent(MainActivity.this, MainActivityMAIL.class);
                            startActivity(i);
                        }
                        else {
                            Intent i = new Intent(MainActivity.this, MainActivitySHARE.class);
                            startActivity(i);
                        }
                        return true;
                    }

                });


//                popup.show();
            }
        });
    }
}