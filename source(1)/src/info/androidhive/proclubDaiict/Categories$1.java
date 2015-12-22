// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package info.androidhive.proclubDaiict;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

// Referenced classes of package info.androidhive.proclubDaiict:
//            Categories, Card

class val.list
    implements android.widget.nItemClickListener
{

    final Categories this$0;
    final ListView val$list;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent("info.androidhive.proclubDaiict.CATEGORYLISTVIEW");
        view = new Bundle();
        view.putString("category", ((Card)val$list.getItemAtPosition(i)).getLine1());
        adapterview.putExtras(view);
        startActivity(adapterview);
    }

    er()
    {
        this$0 = final_categories;
        val$list = ListView.this;
        super();
    }
}
