// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import java.io.File;
import u.upd.a;
import u.upd.c;

// Referenced classes of package com.umeng.update:
//            UpdateResponse, UmengUpdateAgent

public class UpdateDialogActivity extends Activity
{

    int a;
    UpdateResponse b;
    boolean c;
    File d;

    public UpdateDialogActivity()
    {
        a = 6;
        c = false;
        d = null;
    }

    protected void onCreate(Bundle bundle)
    {
        boolean flag = true;
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(u.upd.c.a(this).d("umeng_update_dialog"));
        b = (UpdateResponse)getIntent().getExtras().getSerializable("response");
        bundle = getIntent().getExtras().getString("file");
        boolean flag1 = getIntent().getExtras().getBoolean("force");
        Object obj;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        if (bundle == null)
        {
            flag = false;
        }
        if (flag)
        {
            d = new File(bundle);
        }
        i = u.upd.c.a(this).b("umeng_update_content");
        j = u.upd.c.a(this).b("umeng_update_wifi_indicator");
        k = u.upd.c.a(this).b("umeng_update_id_ok");
        l = u.upd.c.a(this).b("umeng_update_id_cancel");
        i1 = u.upd.c.a(this).b("umeng_update_id_ignore");
        j1 = u.upd.c.a(this).b("umeng_update_id_close");
        k1 = u.upd.c.a(this).b("umeng_update_id_check");
        bundle = new android.view.View.OnClickListener(k, i1) {

            final UpdateDialogActivity a;
            private final int b;
            private final int c;

            public void onClick(View view)
            {
                if (b != view.getId()) goto _L2; else goto _L1
_L1:
                a.a = 5;
_L4:
                a.finish();
                return;
_L2:
                if (c == view.getId())
                {
                    a.a = 7;
                } else
                if (a.c)
                {
                    a.a = 7;
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = UpdateDialogActivity.this;
                b = i;
                c = j;
                super();
            }
        };
        obj = new android.widget.CompoundButton.OnCheckedChangeListener() {

            final UpdateDialogActivity a;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag2)
            {
                a.c = flag2;
            }

            
            {
                a = UpdateDialogActivity.this;
                super();
            }
        };
        if (j > 0)
        {
            byte byte0;
            if (u.upd.a.k(this))
            {
                byte0 = 8;
            } else
            {
                byte0 = 0;
            }
            findViewById(j).setVisibility(byte0);
        }
        if (flag1)
        {
            findViewById(k1).setVisibility(8);
        }
        findViewById(k).setOnClickListener(bundle);
        findViewById(l).setOnClickListener(bundle);
        findViewById(i1).setOnClickListener(bundle);
        findViewById(j1).setOnClickListener(bundle);
        ((CheckBox)findViewById(k1)).setOnCheckedChangeListener(((android.widget.CompoundButton.OnCheckedChangeListener) (obj)));
        bundle = b.a(this, flag);
        obj = (TextView)findViewById(i);
        ((TextView) (obj)).requestFocus();
        ((TextView) (obj)).setText(bundle);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        com.umeng.update.UmengUpdateAgent.a(a, this, b, d);
    }
}
