package com.example.spock.programmingclubdaiict;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.widget.ImageView;




public class Splash extends Activity {

    static Activity a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        a = this;
        setContentView(R.layout.activity_splash);
        ImageView image = (ImageView)findViewById(R.id.splash);
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity

                Intent i = new Intent("com.example.spock.programmingclubdaiict.MAINACTIVITY");
                startActivity(i);
                finish();
            }
        }, 3000);
    }


    public static Activity getInstance()
    {
        return a;
    }
}
