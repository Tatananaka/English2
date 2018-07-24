package com.example.a171y041.myapplication.english2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();

        String selectedText1 = intent.getStringExtra("Text1");
        String selectedText2 = intent.getStringExtra("Text2");

        TextView textView1 = (TextView) findViewById(R.id.selected_text1);
        textView1.setText(selectedText1);

        TextView textView2 = (TextView) findViewById(R.id.selected_text2);
        textView2.setText(selectedText2);
    }
}