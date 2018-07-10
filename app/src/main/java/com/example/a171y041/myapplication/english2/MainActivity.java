package com.example.a171y041.myapplication.english2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        if(v.getId() == R.id.buttonWord) {
            Intent intent = new Intent(MainActivity.this, WordActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(MainActivity.this, PhraseActivity.class);
            startActivity(intent);
        }
    }
}
