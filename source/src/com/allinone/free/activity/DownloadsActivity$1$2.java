// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.allinone.free.cleaner.RubActivity;
import com.allinone.free.dialog.CleanerDialog;

// Referenced classes of package com.allinone.free.activity:
//            DownloadsActivity

class val.dialog1
    implements android.view.sActivity._cls1._cls2
{

    final  this$1;
    private final CleanerDialog val$dialog1;

    public void onClick(View view)
    {
        view = null;
        android.content.pm.PackageInfo packageinfo = getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
        view = packageinfo;
_L1:
        android.content.pm.FoundException foundexception;
        if (view == null)
        {
            DownloadsActivity.access$1(_fld0);
        } else
        {
            view = getPackageManager().getLaunchIntentForPackage("com.evzapp.cleanmaster");
            startActivity(view);
        }
        val$dialog1.dismiss();
        return;
        foundexception;
        foundexception.printStackTrace();
          goto _L1
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$dialog1 = CleanerDialog.this;
        super();
    }

    // Unreferenced inner class com/allinone/free/activity/DownloadsActivity$1

/* anonymous class */
    class DownloadsActivity._cls1
        implements android.view.View.OnClickListener
    {

        final DownloadsActivity this$0;

        public void onClick(final View dialog1)
        {
            dialog1 = new CleanerDialog(DownloadsActivity.this, 0x7f0c0064);
            dialog1.setCanceledOnTouchOutside(false);
            dialog1.show();
            Button button = (Button)dialog1.findViewById(0x7f0600e6);
            Button button1 = (Button)dialog1.findViewById(0x7f0600e7);
            ((TextView)dialog1.findViewById(0x7f060081)).setText(Html.fromHtml("Activate <font color='#3261b4'> <b>AIO Cleaner</b></font> function to remove more old junk files and system cache."));
            button.setOnClickListener(new DownloadsActivity._cls1._cls1());
            button1.setOnClickListener(dialog1. new DownloadsActivity._cls1._cls2());
        }


            
            {
                this$0 = DownloadsActivity.this;
                super();
            }

        // Unreferenced inner class com/allinone/free/activity/DownloadsActivity$1$1

/* anonymous class */
        class DownloadsActivity._cls1._cls1
            implements android.view.View.OnClickListener
        {

            final DownloadsActivity._cls1 this$1;
            private final CleanerDialog val$dialog1;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/allinone/free/cleaner/RubActivity);
                startActivity(view);
                dialog1.dismiss();
            }

                    
                    {
                        this$1 = DownloadsActivity._cls1.this;
                        dialog1 = cleanerdialog;
                        super();
                    }
        }

    }

}
