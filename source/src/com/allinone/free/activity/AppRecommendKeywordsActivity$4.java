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

class this._cls0
    implements android.widget.
{

    final AppRecommendKeywordsActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, final int position, long l)
    {
        try
        {
            (new Thread(new Runnable() {

                final AppRecommendKeywordsActivity._cls4 this$1;
                private final int val$position;

                public void run()
                {
                    String s = URLEncoder.encode(((SearchkeywordModel)AppRecommendKeywordsActivity.access$8(this$0).get(position)).getKeyword());
                    publicTools.getUrl((new StringBuilder(String.valueOf("http://android.downloadatoz.com/_201409/market/hits.php?type=search&id=app&title="))).append(s).toString());
                }

            
            {
                this$1 = AppRecommendKeywordsActivity._cls4.this;
                position = i;
                super();
            }
            })).start();
        }
        // Misplaced declaration of an exception variable
        catch (AdapterView adapterview) { }
        adapterview = new Intent(AppRecommendKeywordsActivity.this, com/allinone/free/activity/AppDetailsActivity);
        adapterview.putExtra("myid", ((SearchkeywordModel)AppRecommendKeywordsActivity.access$8(AppRecommendKeywordsActivity.this).get(position)).getId());
        startActivity(adapterview);
    }


    _cls1.val.position()
    {
        this$0 = AppRecommendKeywordsActivity.this;
        super();
    }
}
