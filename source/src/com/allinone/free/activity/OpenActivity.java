// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.allinone.free.utils.MD5;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.publicTools;
import java.io.File;

public class OpenActivity extends Activity
    implements android.view.View.OnClickListener
{

    private String getopenid;
    private String getopenimgpath;
    private String gettitle;
    private Button openbtn;
    private RelativeLayout openfinish;
    private ImageView openimg;
    private TextView opentitle;

    public OpenActivity()
    {
    }

    private void buindlistener()
    {
        openfinish.setOnClickListener(this);
        openbtn.setOnClickListener(this);
    }

    private void init()
    {
        openfinish = (RelativeLayout)findViewById(0x7f06020f);
        openimg = (ImageView)findViewById(0x7f060210);
        opentitle = (TextView)findViewById(0x7f0601f5);
        openbtn = (Button)findViewById(0x7f060211);
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131100175 2131100177: default 32
    //                   2131100175 38
    //                   2131100176 32
    //                   2131100177 45;
           goto _L1 _L2 _L1 _L3
_L1:
        publicTools.openid = "";
        return;
_L2:
        finish();
        continue; /* Loop/switch isn't completed */
_L3:
        try
        {
            startActivity(getPackageManager().getLaunchIntentForPackage(getopenid));
            finish();
        }
        // Misplaced declaration of an exception variable
        catch (View view) { }
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03007e);
        getopenimgpath = publicTools.openimgpath;
        getopenid = publicTools.openid;
        gettitle = publicTools.opentitle;
        init();
        buindlistener();
        bundle = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(getopenimgpath)).toString();
        opentitle.setText(gettitle);
        openimg.setImageBitmap(Myutils.getImage(bundle));
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            publicTools.openid = "";
        }
        return super.onKeyDown(i, keyevent);
    }
}
