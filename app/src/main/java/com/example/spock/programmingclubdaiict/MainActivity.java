package com.example.spock.programmingclubdaiict;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by spock on 31/7/15.
 */
public class MainActivity extends Activity {

    ImageView blog;
    ImageView announcement;
    ImageView events;
    ImageView categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        blog = (ImageView) findViewById(R.id.blogs);
        blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("com.example.spock.programmingclubdaiict.BLOGLISTVIEW");
                startActivity(i);

            }
        });
        announcement = (ImageView) findViewById(R.id.announcement);
        announcement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent("com.example.spock.programmingclubdaiict.ANNOUNCEMENTLISTVIEW");
                startActivity(i);


            }
        });
        events = (ImageView) findViewById(R.id.event);
        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("com.example.spock.programmingclubdaiict.EVENTLISTVIEW");
                startActivity(i);


            }
        });
        categories = (ImageView) findViewById(R.id.category);
        categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("com.example.spock.programmingclubdaiict.CATEGORYLISTVIEW");
                startActivity(i);


            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_blog_list_view, menu);

        getLayoutInflater().setFactory(new LayoutInflater.Factory() {
            @Override
            public View onCreateView(String name, Context context,
                                     AttributeSet attrs) {

                    try {
                        LayoutInflater f = getLayoutInflater();
                        final View view = f.createView(name, null, attrs);

                        new Handler().post(new Runnable() {
                            public void run() {

// set the background drawable
                                view.setBackgroundResource(R.drawable.card_background_selector);

// set the text color
                                ((TextView) view).setTextColor(Color.WHITE);
                            }
                        });
                        return view;
                    } catch (InflateException e) {
                    } catch (ClassNotFoundException e) {
                    }

                return null;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // toggle nav drawer on selecting action bar app icon/title
        // Handle action bar actions click
        switch (item.getItemId()) {
            case R.id.about:
            {
                Intent in=new Intent("com.example.spock.programmingclubdaiict.ABOUTDEVELOPER");
                startActivity(in);
            }

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}