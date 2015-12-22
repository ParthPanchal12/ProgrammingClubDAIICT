// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.allinone.free.model.SearchkeywordModel;
import com.allinone.free.utils.publicTools;
import java.net.URLEncoder;
import java.util.List;

// Referenced classes of package com.allinone.free.activity:
//            AppRecommendKeywordsActivity, AppDetailsActivity

class val.position
    implements Runnable
{

    final val.position this$1;
    private final int val$position;

    public void run()
    {
        String s = URLEncoder.encode(((SearchkeywordModel)AppRecommendKeywordsActivity.access$8(_fld0).get(val$position)).getKeyword());
        publicTools.getUrl((new StringBuilder(String.valueOf("http://android.downloadatoz.com/_201409/market/hits.php?type=search&id=app&title="))).append(s).toString());
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$position = I.this;
        super();
    }

    // Unreferenced inner class com/allinone/free/activity/AppRecommendKeywordsActivity$4

/* anonymous class */
    class AppRecommendKeywordsActivity._cls4
        implements android.widget.AdapterView.OnItemClickListener
    {

        final AppRecommendKeywordsActivity this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            try
            {
                (new Thread(i. new AppRecommendKeywordsActivity._cls4._cls1())).start();
            }
            // Misplaced declaration of an exception variable
            catch (AdapterView adapterview) { }
            adapterview = new Intent(AppRecommendKeywordsActivity.this, com/allinone/free/activity/AppDetailsActivity);
            adapterview.putExtra("myid", ((SearchkeywordModel)AppRecommendKeywordsActivity.access$8(AppRecommendKeywordsActivity.this).get(i)).getId());
            startActivity(adapterview);
        }


            
            {
                this$0 = AppRecommendKeywordsActivity.this;
                super();
            }
    }

}
