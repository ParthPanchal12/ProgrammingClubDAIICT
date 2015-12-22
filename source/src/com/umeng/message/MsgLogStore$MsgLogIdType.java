// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message;

import android.content.ContentValues;
import android.database.Cursor;

// Referenced classes of package com.umeng.message:
//            MsgLogStore

public class msgType
{

    final MsgLogStore a;
    public String msgId;
    public String msgType;

    public ContentValues getContentValues()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("MsgId", msgId);
        contentvalues.put("MsgType", msgType);
        return contentvalues;
    }

    public (MsgLogStore msglogstore, Cursor cursor)
    {
        a = msglogstore;
        super();
        msgId = cursor.getString(cursor.getColumnIndex("MsgId"));
        msgType = cursor.getString(cursor.getColumnIndex("MsgType"));
    }

    public msgType(MsgLogStore msglogstore, String s, String s1)
    {
        a = msglogstore;
        super();
        msgId = s;
        msgType = s1;
    }
}
