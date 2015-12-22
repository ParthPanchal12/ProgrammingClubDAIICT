// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package info.androidhive.proclubDaiict;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import info.androidhive.proclubDaiict.service.Blog;
import java.util.concurrent.ExecutionException;

// Referenced classes of package info.androidhive.proclubDaiict:
//            CategoryListView, Card, MySQLiteHelper

class val.listView
    implements android.widget.lickListener
{

    final CategoryListView this$0;
    final ListView val$listView;
    final MySQLiteHelper val$mySQLiteHelper;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent("info.androidhive.slidingmenu.BLOGVIEW");
        Blog blog = val$mySQLiteHelper.getBlog(((Card)val$listView.getItemAtPosition(i)).getLine1());
        view = new Bundle();
        view.putString("Author", blog.getUsrername());
        view.putString("Title", blog.getTitle());
        view.putString("Content", blog.getContent());
        try
        {
            view.putString("comment", (String)(new yncex(CategoryListView.this)).execute(new String[] {
                (new StringBuilder()).append("https://public-api.wordpress.com/rest/v1.1/sites/proclubdaiict.wordpress.com/posts/").append(blog.getId()).append("/replies/").toString()
            }).get());
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
        catch (ExecutionException executionexception)
        {
            executionexception.printStackTrace();
        }
        adapterview.putExtras(view);
        startActivity(adapterview);
    }

    yncex()
    {
        this$0 = final_categorylistview;
        val$mySQLiteHelper = mysqlitehelper;
        val$listView = ListView.this;
        super();
    }
}
