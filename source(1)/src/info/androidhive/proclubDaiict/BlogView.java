// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package info.androidhive.proclubDaiict;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.PrintStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BlogView extends Activity
{

    String array;

    public BlogView()
    {
        array = "";
    }

    protected void onCreate(Bundle bundle)
    {
        String s;
        String s1;
        Object obj;
        super.onCreate(bundle);
        setContentView(0x7f030004);
        if (getIntent().getExtras() != null)
        {
            System.out.println("hi");
        }
        obj = getIntent().getExtras();
        bundle = (String)((Bundle) (obj)).get("Title");
        s = (String)((Bundle) (obj)).get("Author");
        s1 = (String)((Bundle) (obj)).get("Content");
        obj = (new JSONObject((String)((Bundle) (obj)).get("comment"))).getJSONArray("comments");
        int i = 0;
_L2:
        if (i >= ((JSONArray) (obj)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        array = (new StringBuilder()).append(array).append(Html.fromHtml((new StringBuilder()).append(((JSONArray) (obj)).getJSONObject(i).getJSONObject("author").getString("nice_name")).append(": ").append(((JSONArray) (obj)).getJSONObject(i).getString("content")).toString()).toString()).append("\n").toString();
        i++;
        if (true) goto _L2; else goto _L1
        JSONException jsonexception;
        jsonexception;
        jsonexception.printStackTrace();
_L1:
        TextView textview = (TextView)(TextView)findViewById(0x7f0a0009);
        TextView textview1 = (TextView)(TextView)findViewById(0x7f0a000a);
        TextView textview2 = (TextView)(TextView)findViewById(0x7f0a000b);
        textview2.setMovementMethod(new ScrollingMovementMethod());
        textview2.setMovementMethod(LinkMovementMethod.getInstance());
        textview.setTextAlignment(4);
        textview1.setTextAlignment(4);
        ((Button)(Button)findViewById(0x7f0a000c)).setOnClickListener(new android.view.View.OnClickListener() {

            final BlogView this$0;

            public void onClick(View view)
            {
                view = new Intent("info.androidhive.proclubDaiict.COMMENTVIEW");
                Bundle bundle1 = new Bundle();
                bundle1.putString("comments", array);
                view.putExtras(bundle1);
                startActivity(view);
            }

            
            {
                this$0 = BlogView.this;
                super();
            }
        });
        if (textview == null)
        {
            System.out.println("1");
        }
        if (textview1 == null)
        {
            System.out.println("2");
        }
        if (textview2 == null)
        {
            System.out.println("3");
        }
        textview.setTextColor(0xff000000);
        textview1.setTextColor(0xff000000);
        textview2.setTextColor(0xff000000);
        textview.setText(bundle);
        textview1.setText(s);
        textview2.setText(s1);
        return;
    }
}
