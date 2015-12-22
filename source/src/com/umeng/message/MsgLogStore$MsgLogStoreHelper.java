// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// Referenced classes of package com.umeng.message:
//            MsgLogStore

private class tory extends SQLiteOpenHelper
{

    final MsgLogStore a;

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("create table if not exists MsgLogStore ( MsgId varchar, ActionType Integer, Time long, PRIMARY KEY(MsgId, ActionType))");
        sqlitedatabase.execSQL("create table if not exists MsgLogIdTypeStore (MsgId varchar, MsgType varchar, PRIMARY KEY(MsgId))");
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
    }

    public tory(MsgLogStore msglogstore, Context context)
    {
        a = msglogstore;
        super(context, "MsgLogStore.db", null, 2);
    }
}
