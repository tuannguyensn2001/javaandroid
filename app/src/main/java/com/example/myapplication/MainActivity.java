package com.example.myapplication;

import androidx.annotation.ColorLong;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.*;
public class MainActivity extends AppCompatActivity {
    private HashMap<Button, ListView> list;
    private Button activeButton;
    private ListView activeContent;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.mapping();

        Set<Button> keySet = list.keySet();


        for(final Button key: keySet){

            key.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (activeButton != null){
                        activeButton.setBackgroundColor(Color.parseColor("#3F51B5"));
                    }

                    if (activeContent != null){
                        activeContent.setVisibility(View.INVISIBLE);
                    }
                   activeButton = key;
                   activeButton.setBackgroundColor(Color.YELLOW);

                   activeContent = list.get(key);
                   activeContent.setVisibility(View.VISIBLE);
                }
            });
        }





    }

    private void mapping()
    {
        this.list = new HashMap<Button, ListView>();
        Button bt1 = (Button) findViewById(R.id.button1);
        Button bt2 = (Button) findViewById(R.id.button2);
        ListView content1 = (ListView) findViewById(R.id.content1);
        ListView content2 = (ListView) findViewById(R.id.content2);

        this.activeButton = bt1;
        this.activeContent= content1;
        list.put(bt1,content1);
        list.put(bt2,content2);

        ArrayList<String> listCategory = new ArrayList<String>();

        listCategory.add("Sport");
        listCategory.add("News");
        listCategory.add("Education");
        listCategory.add("Social");
        listCategory.add("Music");
        listCategory.add("A");
        listCategory.add("B");


        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,listCategory);

        content1.setAdapter(adapter);
    }
















}