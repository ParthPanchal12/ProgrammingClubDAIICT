// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message;

import android.content.ContentValues;
import android.database.Cursor;

// Referenced classes of package com.umeng.message:
//            MsgLogStore

public class time
{

    final MsgLogStore a;
    public int actionType;
    public String msgId;
    public long time;

    public ContentValues getContentValues()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("MsgId", msgId);
        contentvalues.put("Time", Long.valueOf(time));
        contentvalues.put("ActionType", Integer.valueOf(actionType));
        return contentvalues;
    }

    public (MsgLogStore msglogstore, Cursor cursor)
    {
        a = msglogstore;
        super();
        msgId = cursor.getString(cursor.getColumnIndex("MsgId"));
        time = cursor.getLong(cursor.getColumnIndex("Time"));
        actionType = cursor.getInt(cursor.getColumnIndex("ActionType"));
    }

    public x(MsgLogStore msglogstore, String s, int i, long l)
    {
        a = msglogstore;
        super();
        msgId = s;
        actionType = i;
        time = l;
    }
}
