package com.example.universalsender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivityMAIL extends AppCompatActivity {

    Button sendbutton;
    EditText textTo;
    EditText textSubject;
    EditText textMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendbutton = (Button)findViewById(R.id.buttonSend);
        textTo = (EditText)findViewById(R.id.editTextTo);
        textSubject = (EditText)findViewById(R.id.editTextSubject);
        textMessage = (EditText)findViewById(R.id.editTextMessage);

        sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String To = textTo.getText().toString();
                String Subject = textSubject.getText().toString();
                String Message = textMessage.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{To});
                email.putExtra(Intent.EXTRA_SUBJECT,Subject);
                email.putExtra(Intent.EXTRA_TEXT,Message);

                email.setType("Message/rfc822");
                startActivity(Intent.createChooser(email, "choose an email client:"));



            }
        });
    }
}