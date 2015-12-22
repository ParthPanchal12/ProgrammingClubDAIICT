// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.client;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.message.proguard.aJ;

// Referenced classes of package org.android.agoo.client:
//            MessageService

private static class  extends SQLiteOpenHelper
{

    private String a()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("create table message");
        stringbuffer.append("(");
        stringbuffer.append("id text UNIQUE not null,");
        stringbuffer.append("state integer,");
        stringbuffer.append("body_code integer,");
        stringbuffer.append("report long,");
        stringbuffer.append("target_time long,");
        stringbuffer.append("interval integer,");
        stringbuffer.append("type text,");
        stringbuffer.append("message text,");
        stringbuffer.append("notify integer,");
        stringbuffer.append("create_time date");
        stringbuffer.append(");");
        return stringbuffer.toString();
    }

    private String b()
    {
        return "CREATE INDEX body_code_index ON message(body_code)";
    }

    private String c()
    {
        return "CREATE INDEX id_index ON message(id)";
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        sqlitedatabase.execSQL(a());
        sqlitedatabase.execSQL(c());
        sqlitedatabase.execSQL(b());
        return;
        sqlitedatabase;
        aJ.d("MessageService", "messagedbhelper create", sqlitedatabase);
        return;
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
    }

    public (Context context)
    {
        super(context, "message_db", null, 1);
    }
}
