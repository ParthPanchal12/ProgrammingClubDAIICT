package com.example.spock.programmingclubdaiict;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class CategoryListView extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        final MySQLiteHelper mySQLiteHelper = new MySQLiteHelper(this);
        final ListView list = (ListView)findViewById(R.id.card_listViewCategory);
        List<String> category = mySQLiteHelper.getCategories();
        System.out.print(category.size());
        CategoryCardAdapter cardArrayAdapter = new CategoryCardAdapter(this.getApplicationContext(), R.layout.category_card_layout);
        for(int i=0;i<category.size();i++) {
            Card c = new Card(category.get(i), "");
            System.out.println(c.getLine1() + "dfdfdsfff");
            cardArrayAdapter.add(c);
        }
        list.setAdapter(cardArrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in=new Intent("com.example.spock.programmingclubdaiict.BLOGCATEGORYLISTVIEW");
                Bundle b = new Bundle();
                b.putString("category", ((Card) list.getItemAtPosition(position)).getLine1());
                in.putExtras(b);
                startActivity(in);
            }
        });
    }

}
