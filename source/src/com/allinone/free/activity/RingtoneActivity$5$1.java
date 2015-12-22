// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.publicTools;
import com.allinone.free.views.SyncHorizontalScrollView;
import java.net.URLEncoder;

// Referenced classes of package com.allinone.free.activity:
//            RingtoneActivity

class this._cls1
    implements Runnable
{

    final Broadcast this$1;

    public void run()
    {
        Object obj = URLEncoder.encode(RingtoneActivity.access$9(_fld0).getText().toString());
        Myutils.getInstance();
        Myutils.searchkeywords = ((String) (obj));
        obj = new Intent();
        ((Intent) (obj)).setAction("ringtonesearch");
        sendBroadcast(((Intent) (obj)));
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/allinone/free/activity/RingtoneActivity$5

/* anonymous class */
    class RingtoneActivity._cls5
        implements android.view.View.OnKeyListener
    {

        final RingtoneActivity this$0;

        public boolean onKey(View view, int i, KeyEvent keyevent)
        {
            if (keyevent.getAction() == 0 && i == 66)
            {
                if (!RingtoneActivity.access$9(RingtoneActivity.this).getText().equals(""))
                {
                    RingtoneActivity.access$8(RingtoneActivity.this).setVisibility(8);
                    RingtoneActivity.access$6(RingtoneActivity.this).setVisibility(8);
                    if (RingtoneActivity.access$10(RingtoneActivity.this) == null)
                    {
                        RingtoneActivity.access$11(RingtoneActivity.this, new RingtoneActivity.TabFragmentPagerAdapter2(RingtoneActivity.this, getSupportFragmentManager()));
                        RingtoneActivity.access$12(RingtoneActivity.this).setAdapter(RingtoneActivity.access$10(RingtoneActivity.this));
                    }
                    RingtoneActivity.access$12(RingtoneActivity.this).setVisibility(0);
                    if (!RingtoneActivity.access$9(RingtoneActivity.this).getText().equals(""))
                    {
                        (new Thread(new RingtoneActivity._cls5._cls1())).start();
                        ((InputMethodManager)RingtoneActivity.access$9(RingtoneActivity.this).getContext().getSystemService("input_method")).hideSoftInputFromWindow(RingtoneActivity.access$9(RingtoneActivity.this).getWindowToken(), 0);
                    }
                }
                try
                {
                    (new Thread(new RingtoneActivity._cls5._cls2())).start();
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return false;
                }
            }
            return false;
        }


            
            {
                this$0 = RingtoneActivity.this;
                super();
            }

        // Unreferenced inner class com/allinone/free/activity/RingtoneActivity$5$2

/* anonymous class */
        class RingtoneActivity._cls5._cls2
            implements Runnable
        {

            final RingtoneActivity._cls5 this$1;

            public void run()
            {
                String s = URLEncoder.encode(RingtoneActivity.access$9(this$0).getText().toString());
                publicTools.getUrl((new StringBuilder(String.valueOf("http://android.downloadatoz.com/_201409/market/hits.php?type=search&id=ringtone&title="))).append(s).toString());
            }

                    
                    {
                        this$1 = RingtoneActivity._cls5.this;
                        super();
                    }
        }

    }

}
