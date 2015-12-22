// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package info.androidhive.proclubDaiict;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import java.io.PrintStream;

public class AnnouncementView extends Activity
{

    String array;

    public AnnouncementView()
    {
        array = "";
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030003);
        if (getIntent().getExtras() != null)
        {
            System.out.println("hi");
        }
        Object obj = getIntent().getExtras();
        bundle = (String)((Bundle) (obj)).get("Title");
        obj = (String)((Bundle) (obj)).get("Content");
        TextView textview = (TextView)(TextView)findViewById(0x7f0a0007);
        TextView textview1 = (TextView)(TextView)findViewById(0x7f0a0008);
        textview1.setMovementMethod(new ScrollingMovementMethod());
        textview1.setMovementMethod(LinkMovementMethod.getInstance());
        textview.setTextAlignment(4);
        if (textview == null)
        {
            System.out.println("1");
        }
        if (textview1 == null)
        {
            System.out.println("2");
        }
        textview.setTextColor(0xff000000);
        textview1.setTextColor(0xff000000);
        textview.setText(bundle);
        textview1.setText(((CharSequence) (obj)));
    }
}
