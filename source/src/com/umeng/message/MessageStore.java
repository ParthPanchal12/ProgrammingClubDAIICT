// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.message.entity.UMessage;
import org.json.JSONObject;

public class MessageStore
{
    private class MessageStoreHelper extends SQLiteOpenHelper
    {

        final MessageStore a;

        public void onCreate(SQLiteDatabase sqlitedatabase)
        {
            sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS MessageStore(_id Integer  PRIMARY KEY  AUTOINCREMENT  , MsdId Varchar  , Json Varchar  , SdkVersion Varchar  , ArrivalTime Long  , ActionType Integer )");
        }

        public void onUpgrade(SQLiteDatabase sqlitedatabase, int i1, int j1)
        {
        }

        public MessageStoreHelper(Context context)
        {
            a = MessageStore.this;
            super(context, "MessageStore.db", null, 1);
        }
    }


    public static final String ActionType = "ActionType";
    public static final String ArrivalTime = "ArrivalTime";
    public static final String Id = "_id";
    public static final String Json = "Json";
    public static final String MsgId = "MsdId";
    public static final String SdkVersion = "SdkVersion";
    private static final String d = "MessageStore.db";
    private static final String e = "MessageStore";
    private static final int f = 1;
    private static final String g = " PRIMARY KEY ";
    private static final String h = " AUTOINCREMENT ";
    private static final String i = "CREATE TABLE IF NOT EXISTS ";
    public static MessageStore instance;
    private static final String j = " Integer ";
    private static final String k = " Long ";
    private static final String l = " Varchar ";
    private static final String m = "(";
    private static final String n = ")";
    private static final String o = " , ";
    private static final String p = " And ";
    private static final String q = " desc ";
    private static final String r = " asc ";
    private Context a;
    private SQLiteDatabase b;
    private MessageStoreHelper c;

    private MessageStore(Context context)
    {
        a = context.getApplicationContext();
        c = new MessageStoreHelper(context);
        b = c.getWritableDatabase();
    }

    public static MessageStore getInstance(Context context)
    {
        if (instance == null)
        {
            instance = new MessageStore(context);
        }
        return instance;
    }

    boolean a(UMessage umessage)
    {
        boolean flag;
        flag = false;
        if (umessage == null)
        {
            return false;
        }
        MessageStore messagestore = instance;
        messagestore;
        JVM INSTR monitorenter ;
        ContentValues contentvalues;
        contentvalues = new ContentValues();
        contentvalues.put("MsdId", umessage.msg_id);
        contentvalues.put("Json", umessage.getRaw().toString());
        contentvalues.put("SdkVersion", "1.7.0");
        contentvalues.put("ArrivalTime", Long.valueOf(System.currentTimeMillis()));
        contentvalues.put("ActionType", Integer.valueOf(0));
        if (b.insert("MessageStore", null, contentvalues) != -1L)
        {
            flag = true;
        }
        messagestore;
        JVM INSTR monitorexit ;
        return flag;
        umessage;
        messagestore;
        JVM INSTR monitorexit ;
        throw umessage;
    }

    boolean a(String s)
    {
        return a(s, 1);
    }

    boolean a(String s, int i1)
    {
        boolean flag = true;
        MessageStore messagestore = instance;
        messagestore;
        JVM INSTR monitorenter ;
        ContentValues contentvalues;
        contentvalues = new ContentValues();
        contentvalues.put("ActionType", Integer.valueOf(i1));
        if (b.update("MessageStore", contentvalues, "MsdId=?", new String[] {
    s
}) != 1)
        {
            flag = false;
        }
        return flag;
        s;
        messagestore;
        JVM INSTR monitorexit ;
        throw s;
    }

    boolean b(String s)
    {
        return a(s, 2);
    }
}
