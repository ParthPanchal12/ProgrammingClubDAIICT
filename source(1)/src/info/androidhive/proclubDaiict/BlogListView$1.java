// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package info.androidhive.proclubDaiict;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import info.androidhive.proclubDaiict.service.Blog;
import java.util.List;
import java.util.concurrent.ExecutionException;

// Referenced classes of package info.androidhive.proclubDaiict:
//            BlogListView, MySQLiteHelper, Card

class val.mySQLiteHelper
    implements android.widget.temClickListener
{

    final BlogListView this$0;
    final MySQLiteHelper val$mySQLiteHelper;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        List list = val$mySQLiteHelper.getAllBlog();
        Card card = (Card)listView.getItemAtPosition(i);
        Object obj = "";
        String s1 = "";
        Object obj1 = null;
        boolean flag = false;
        int j = 0;
        do
        {
label0:
            {
                String s = obj1;
                view = s1;
                adapterview = ((AdapterView) (obj));
                int k = ((flag) ? 1 : 0);
                if (!"".equals(card.getLine1()))
                {
                    if (!card.getLine1().equals(((Blog)list.get(j)).getTitle()))
                    {
                        break label0;
                    }
                    adapterview = ((Blog)list.get(j)).getUsrername();
                    view = ((Blog)list.get(j)).getTitle();
                    k = ((Blog)list.get(j)).getId();
                    s = ((Blog)list.get(j)).getContent();
                    ((Blog)list.get(j)).getComment();
                    ((Blog)list.get(j)).getTag();
                }
                obj = new Bundle();
                ((Bundle) (obj)).putString("Author", adapterview);
                ((Bundle) (obj)).putString("Title", view);
                ((Bundle) (obj)).putString("Content", s);
                try
                {
                    ((Bundle) (obj)).putString("comment", (String)(new yncex(BlogListView.this)).execute(new String[] {
                        (new StringBuilder()).append("https://public-api.wordpress.com/rest/v1.1/sites/proclubdaiict.wordpress.com/posts/").append(k).append("/replies/").toString()
                    }).get());
                }
                // Misplaced declaration of an exception variable
                catch (AdapterView adapterview)
                {
                    adapterview.printStackTrace();
                }
                // Misplaced declaration of an exception variable
                catch (AdapterView adapterview)
                {
                    adapterview.printStackTrace();
                }
                adapterview = new Intent("info.androidhive.slidingmenu.BLOGVIEW");
                adapterview.putExtras(((Bundle) (obj)));
                startActivity(adapterview);
                Toast.makeText(getActivity().getApplicationContext(), (new StringBuilder()).append("Position :").append(i).append("  ListItem : ").append(card).toString(), 1).show();
                return;
            }
            j++;
        } while (true);
    }

    yncex()
    {
        this$0 = final_bloglistview;
        val$mySQLiteHelper = MySQLiteHelper.this;
        super();
    }
}
