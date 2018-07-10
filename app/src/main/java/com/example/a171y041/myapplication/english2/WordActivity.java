package com.example.a171y041.myapplication.english2;

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

public class WordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);

        //リスト項目のもととなる値を準備する
        String[] words = {
                "accept", "achieve", "acquire", "add",
                "advance", "affect", "agree", "allow",
                "appear", "apply", "approach", "argue",
                "avoid", "bear", "beat", "belong",
                "care", "claim", "communicate", "compare",
                "consider", "consume", "contain", "continue",
                "depend", "destroy", "determine", "develop",
        };

        String[] translations = {
                "～を受け入れる", "～を達成する", "～を身につける", "～を付け加える",
                "前進する", "～に影響を与える", "同意する, 賛成する", "～を許可する",
                "現れる", "～を適用する", "～に近づく", "～だと主張する",
                "～を避ける", "～を我慢する", "～を打ち負かす", "属する",
                "気にかける", "～が自分のものだと主張する", "意思を伝える", "～を比較する",
                "～について考える", "～を消費する", "～を含む", "～を続ける",
                "依存する", "～を破壊する", "～を決める", "～を発達させる"
        };

        //ListViewに表示するリスト項目をArrayListで準備
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        for(int i = 0; i < words.length; i++) {
            Map<String, String> item = new HashMap<String, String>();
            item.put("Word", words[i]);
            item.put("Translation", translations[i]);
            data.add(item);
        }

        //リスト項目とListViewを対応付けるArrayAdapterを用意する
        SimpleAdapter adapter = new SimpleAdapter(this, data,
                android.R.layout.simple_list_item_2,
                new String[] {"Word", "Translation"},
                new int[] {android.R.id.text1, android.R.id.text2});

        //ListViewにArrayAdapterを設定
        ListView listView = (ListView)findViewById(R.id.listView);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Item = position + "がクリックされました。";
                Toast.makeText(WordActivity.this, Item, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

/*
                //リストビューの項目を取得
                ListView listview = (ListView) parent;
                String item = (String) listview.getItemAtPosition(position);
                Intent intent = new Intent(WordActivity.this, PhraseActivity.class);
                intent.putExtra("list_item", item);
                startActivity(intent);

*/