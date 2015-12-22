// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// Referenced classes of package com.umeng.message:
//            MessageStore

private class ry extends SQLiteOpenHelper
{

    final MessageStore a;

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS MessageStore(_id Integer  PRIMARY KEY  AUTOINCREMENT  , MsdId Varchar  , Json Varchar  , SdkVersion Varchar  , ArrivalTime Long  , ActionType Integer )");
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
    }

    public ry(MessageStore messagestore, Context context)
    {
        a = messagestore;
        super(context, "MessageStore.db", null, 1);
    }
}
