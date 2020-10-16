package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference ref;
    EditText username,phone,email;
    Button submit;
    int maxid = 0;
    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        username = (EditText) findViewById(R.id.usernameInput);
        phone = (EditText) findViewById(R.id.phoneInput);
        email = (EditText) findViewById(R.id.emailInput);
        submit = (Button) findViewById(R.id.submitButton);

        user = new User();
        ref = database.getInstance().getReference().child("User");


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setUsername(username.getText().toString());
                user.setEmail(email.getText().toString());
                user.setPhone(phone.getText().toString());

//                ref.child(String.valueOf(3)).setValue(user);
                Intent intent = new Intent(FirebaseActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }


}