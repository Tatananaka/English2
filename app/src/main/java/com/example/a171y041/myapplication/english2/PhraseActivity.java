package com.example.a171y041.myapplication.english2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PhraseActivity extends AppCompatActivity {

    private ListView listView;

/*---リスト項目のもととなる値を準備---------------------------------------------------------------*/

    //フレーズ
    final String[] phrases = {
            "test", "word"
    };

    //訳
    final String[] translations = {
            "テスト", "ワード"
    };
/*------------------------------------------------------------------------------------------------*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrase);

        //ListViewに表示するリスト項目をArrayListで準備
        List<Map<String, String>> data = new ArrayList<>();
        for(int i = 0; i < phrases.length; i++) {
            Map<String, String> item = new HashMap<>();
            item.put("Phrase", phrases[i]);
            item.put("Translation", translations[i]);
            data.add(item);
        }

        //リスト項目とListViewを対応付けるArrayAdapterを用意する
        final SimpleAdapter adapter = new SimpleAdapter(this, data,
                android.R.layout.simple_list_item_2,
                new String[] {"Phrase", "Translation"},
                new int[] {android.R.id.text1, android.R.id.text2});

        //ListViewにArrayAdapterを設定する
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);


/*-------リストビュー内容をクリックしたときの処理-------------------------------------------------*/

        //リスト項目が選択された時のイベントを追加
        //選択したリストの内容を表示
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //クリックしたアイテムを表示
                Intent intent = new Intent(PhraseActivity.this, SubActivity.class);

                //clickされたpositionのphrasesとtranslations
                String selectedText1 = phrases[position];
                String selectedText2 = translations[position];

                //インテントにセット
                intent.putExtra("Text1", selectedText1);
                intent.putExtra("Text2", selectedText2);

                //Activityをスイッチする
                startActivity(intent);
            }
        });

        //リスト項目が長押しされた時のイベント追加
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent,
                                           View view, int position, long id) {
                String msg = position + "が長押しされました";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                return false;
            }
        });
/*------------------------------------------------------------------------------------------------*/

    }
}
