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

public class WordActivity extends AppCompatActivity  {

    private ListView listView;

/*---リスト項目のもととなる値を準備---------------------------------------------------------------*/

    //単語
    final String[] words = {
            "accept", "achieve", "acquire", "add",
            "advance", "affect", "agree", "allow",
            "appear", "apply", "approach", "argue",
            "avoid", "bear", "beat", "belong",
            "care", "claim", "communicate", "compare",
            "consider", "consume", "contain", "continue",
            "depend", "destroy", "determine", "develop",
    };

    //訳
    final String[] translations = {
            "～を受け入れる", "～を達成する", "～を身につける", "～を付け加える",
            "前進する", "～に影響を与える", "同意する, 賛成する", "～を許可する",
            "現れる", "～を適用する", "～に近づく", "～だと主張する",
            "～を避ける", "～を我慢する", "～を打ち負かす", "属する",
            "気にかける", "～が自分のものだと主張する", "意思を伝える", "～を比較する",
            "～について考える", "～を消費する", "～を含む", "～を続ける",
            "依存する", "～を破壊する", "～を決める", "～を発達させる"
    };
/*------------------------------------------------------------------------------------------------*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);

        //ListViewに表示するリスト項目をArrayListで準備
        List<Map<String, String>> data = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            Map<String, String> item = new HashMap<>();
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
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
/*
        listView.setTextFilterEnabled(true);

        SearchView searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setIconifiedByDefault(false);
        searchView.setSubmitButtonEnabled(true);
        searchView.setQueryHint("a");
*/
/*-------リストビュー内容をクリックしたときの処理-------------------------------------------------*/

        //リスト項目が選択された時のイベントを追加
        //選択したリストの内容を表示
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //クリックしたアイテムを表示
                Intent intent = new Intent(WordActivity.this, SubActivity.class);
                //clickされたpositionのwordsとtranslations
                String selectedText1 = words[position];
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
/*
    public boolean onQueryTextChanged(String queryText) {
        if(TextUtils.isEmpty(queryText)) {
            listView.clearTextFilter();
        } else {
            listView.setFilterText(queryText.toString());
        }
        return true;
    }

    public boolean onSubmitQuery(String queryText) {
        return false;
    }*/
}
