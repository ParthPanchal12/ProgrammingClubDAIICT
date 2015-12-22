// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package info.androidhive.proclubDaiict;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import info.androidhive.proclubDaiict.service.Blog;
import java.util.List;

// Referenced classes of package info.androidhive.proclubDaiict:
//            Announcements, MySQLiteHelper

class val.mySQLiteHelper
    implements android.widget.emClickListener
{

    final Announcements this$0;
    final MySQLiteHelper val$mySQLiteHelper;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        List list = val$mySQLiteHelper.getAllAnnouncMent();
        String s = (String)listView.getItemAtPosition(i);
        Object obj = "";
        Object obj1 = null;
        int j = 0;
        do
        {
label0:
            {
                view = obj1;
                adapterview = ((AdapterView) (obj));
                if (!"".equals(s))
                {
                    if (!s.equals(((Blog)list.get(j)).getTitle()))
                    {
                        break label0;
                    }
                    adapterview = ((Blog)list.get(j)).getTitle();
                    view = ((Blog)list.get(j)).getContent();
                }
                obj = new Bundle();
                ((Bundle) (obj)).putString("Title", adapterview);
                ((Bundle) (obj)).putString("Content", view);
                adapterview = new Intent("info.androidhive.slidingmenu.ANNOUNCEMENTVIEW");
                adapterview.putExtras(((Bundle) (obj)));
                startActivity(adapterview);
                Toast.makeText(getActivity().getApplicationContext(), (new StringBuilder()).append("Position :").append(i).append("  ListItem : ").append(s).toString(), 1).show();
                return;
            }
            j++;
        } while (true);
    }

    ()
    {
        this$0 = final_announcements;
        val$mySQLiteHelper = MySQLiteHelper.this;
        super();
    }
}
