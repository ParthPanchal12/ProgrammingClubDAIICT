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

public class CommentView extends Activity
{

    public CommentView()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030005);
        bundle = getIntent().getExtras().getString("comments");
        if (bundle != null && !bundle.equals(""))
        {
            TextView textview = (TextView)findViewById(0x7f0a000d);
            textview.setMovementMethod(new ScrollingMovementMethod());
            textview.setMovementMethod(LinkMovementMethod.getInstance());
            System.out.println((new StringBuilder()).append(bundle).append("  kkkkkk").toString());
            textview.setText(bundle);
            return;
        } else
        {
            bundle = (TextView)findViewById(0x7f0a000d);
            System.out.println("ggggg");
            bundle.setText("No Comments");
            return;
        }
    }
}
