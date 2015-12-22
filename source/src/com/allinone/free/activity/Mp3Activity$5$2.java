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
//            Mp3Activity

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        String s = URLEncoder.encode(Mp3Activity.access$9(_fld0).getText().toString());
        publicTools.getUrl((new StringBuilder(String.valueOf("http://android.downloadatoz.com/_201409/market/hits.php?type=search&id=mp3&title="))).append(s).toString());
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/allinone/free/activity/Mp3Activity$5

/* anonymous class */
    class Mp3Activity._cls5
        implements android.view.View.OnKeyListener
    {

        final Mp3Activity this$0;

        public boolean onKey(View view, int i, KeyEvent keyevent)
        {
            if (keyevent.getAction() == 0 && i == 66 && !Mp3Activity.access$9(Mp3Activity.this).getText().equals(""))
            {
                Mp3Activity.access$8(Mp3Activity.this).setVisibility(8);
                Mp3Activity.access$6(Mp3Activity.this).setVisibility(8);
                if (Mp3Activity.access$10(Mp3Activity.this) == null)
                {
                    Mp3Activity.access$11(Mp3Activity.this, new Mp3Activity.TabFragmentPagerAdapter2(Mp3Activity.this, getSupportFragmentManager()));
                    Mp3Activity.access$12(Mp3Activity.this).setAdapter(Mp3Activity.access$10(Mp3Activity.this));
                }
                Mp3Activity.access$12(Mp3Activity.this).setVisibility(0);
                if (!Mp3Activity.access$9(Mp3Activity.this).getText().equals(""))
                {
                    (new Thread(new Mp3Activity._cls5._cls1())).start();
                    ((InputMethodManager)Mp3Activity.access$9(Mp3Activity.this).getContext().getSystemService("input_method")).hideSoftInputFromWindow(Mp3Activity.access$9(Mp3Activity.this).getWindowToken(), 0);
                }
                try
                {
                    (new Thread(new Mp3Activity._cls5._cls2())).start();
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
                this$0 = Mp3Activity.this;
                super();
            }

        // Unreferenced inner class com/allinone/free/activity/Mp3Activity$5$1

/* anonymous class */
        class Mp3Activity._cls5._cls1
            implements Runnable
        {

            final Mp3Activity._cls5 this$1;

            public void run()
            {
                Object obj = URLEncoder.encode(Mp3Activity.access$9(this$0).getText().toString());
                Myutils.getInstance();
                Myutils.searchkeywords = ((String) (obj));
                obj = new Intent();
                ((Intent) (obj)).setAction("mp3search");
                sendBroadcast(((Intent) (obj)));
            }

                    
                    {
                        this$1 = Mp3Activity._cls5.this;
                        super();
                    }
        }

    }

}
