package com.example.a171y041.myapplication.english2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhraseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrase);

        //リスト項目のもととなる値を準備する
        String[] phrases = {"test", "word"};
        String[] translations = {"テスト", "ワード"};

        //ListViewに表示するリスト項目をArrayListで準備
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        for(int i = 0; i < phrases.length; i++) {
            Map<String, String> item = new HashMap<String, String>();
            item.put("Phrase", phrases[i]);
            item.put("Translation", translations[i]);
            data.add(item);
        }

        //リスト項目とListViewを対応付けるArrayAdapterを用意する
        SimpleAdapter adapter = new SimpleAdapter(this, data,
                android.R.layout.simple_list_item_2,
                new String[] {"Phrase", "Translation"},
                new int[] {android.R.id.text1, android.R.id.text2});

        //ListViewにArrayAdapterを設定する
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}
