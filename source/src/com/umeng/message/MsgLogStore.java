// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONObject;

// Referenced classes of package com.umeng.message:
//            MessageSharedPrefs

public class MsgLogStore
{
    public class MsgLog
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

        public MsgLog(Cursor cursor)
        {
            a = MsgLogStore.this;
            super();
            msgId = cursor.getString(cursor.getColumnIndex("MsgId"));
            time = cursor.getLong(cursor.getColumnIndex("Time"));
            actionType = cursor.getInt(cursor.getColumnIndex("ActionType"));
        }

        public MsgLog(String s, int l, long l1)
        {
            a = MsgLogStore.this;
            super();
            msgId = s;
            actionType = l;
            time = l1;
        }
    }

    public class MsgLogIdType
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

        public MsgLogIdType(Cursor cursor)
        {
            a = MsgLogStore.this;
            super();
            msgId = cursor.getString(cursor.getColumnIndex("MsgId"));
            msgType = cursor.getString(cursor.getColumnIndex("MsgType"));
        }

        public MsgLogIdType(String s, String s1)
        {
            a = MsgLogStore.this;
            super();
            msgId = s;
            msgType = s1;
        }
    }

    private class MsgLogStoreHelper extends SQLiteOpenHelper
    {

        final MsgLogStore a;

        public void onCreate(SQLiteDatabase sqlitedatabase)
        {
            sqlitedatabase.execSQL("create table if not exists MsgLogStore ( MsgId varchar, ActionType Integer, Time long, PRIMARY KEY(MsgId, ActionType))");
            sqlitedatabase.execSQL("create table if not exists MsgLogIdTypeStore (MsgId varchar, MsgType varchar, PRIMARY KEY(MsgId))");
        }

        public void onUpgrade(SQLiteDatabase sqlitedatabase, int l, int i1)
        {
        }

        public MsgLogStoreHelper(Context context)
        {
            a = MsgLogStore.this;
            super(context, "MsgLogStore.db", null, 2);
        }
    }


    public static final String ActionType = "ActionType";
    public static final String MsgId = "MsgId";
    public static final String MsgType = "MsgType";
    public static final String Time = "Time";
    private static MsgLogStore a;
    private static final String e = " And ";
    private static final String f = " Asc ";
    private static final String g = " Desc ";
    private static final String h = "MsgLogStore.db";
    private static final int i = 2;
    private static final String j = "MsgLogStore";
    private static final String k = "MsgLogIdTypeStore";
    private SQLiteDatabase b;
    private MsgLogStoreHelper c;
    private Context d;

    private MsgLogStore(Context context)
    {
        d = context.getApplicationContext();
        c = new MsgLogStoreHelper(context);
        b = c.getWritableDatabase();
    }

    private void a()
    {
        if (MessageSharedPrefs.getInstance(d).h())
        {
            return;
        }
        File afile[] = d.getCacheDir().listFiles(new FilenameFilter() {

            final MsgLogStore a;

            public boolean accept(File file1, String s)
            {
                return !TextUtils.isEmpty(s) && s.startsWith("umeng_message_log_cache_");
            }

            
            {
                a = MsgLogStore.this;
                super();
            }
        });
        if (afile != null)
        {
            int i1 = afile.length;
            for (int l = 0; l < i1; l++)
            {
                File file = afile[l];
                a(file);
                file.delete();
            }

        }
        MessageSharedPrefs.getInstance(d).i();
    }

    private void a(File file)
    {
        try
        {
            file = new JSONObject(b(file));
            addLog(file.optString("msg_id"), file.optInt("action_type"), file.optLong("ts"));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            file.printStackTrace();
        }
    }

    private String b(File file)
        throws IOException
    {
        Object obj = new BufferedReader(new FileReader(file));
        file = new StringBuilder();
_L3:
        String s = ((BufferedReader) (obj)).readLine();
        if (s == null) goto _L2; else goto _L1
_L1:
        file.append(s);
          goto _L3
        file;
_L5:
        if (obj != null)
        {
            try
            {
                ((BufferedReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
        }
        throw file;
_L2:
        file = file.toString();
        if (obj != null)
        {
            try
            {
                ((BufferedReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
                return file;
            }
        }
        return file;
        file;
        obj = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static MsgLogStore getInstance(Context context)
    {
        if (a == null)
        {
            a = new MsgLogStore(context);
            a.a();
        }
        return a;
    }

    public boolean addLog(String s, int l, long l1)
    {
        if (TextUtils.isEmpty(s))
        {
            return false;
        }
        s = new MsgLog(s, l, l1);
        boolean flag;
        if (b.insert("MsgLogStore", null, s.getContentValues()) != -1L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }

    public boolean addLogIdType(String s, String s1)
    {
        if (!TextUtils.isEmpty(s))
        {
            if (b.insert("MsgLogIdTypeStore", null, (s = new MsgLogIdType(s, s1)).getContentValues()) != -1L)
            {
                return true;
            }
        }
        return false;
    }

    public MsgLog getMsgLog(String s)
    {
        Object obj = null;
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        Cursor cursor = b.query("MsgLogStore", null, "MsgId=?", new String[] {
            s
        }, null, null, null, null);
        s = obj;
        if (cursor.moveToFirst())
        {
            s = new MsgLog(cursor);
        }
        cursor.close();
        return s;
    }

    public ArrayList getMsgLogIdTypes()
    {
        ArrayList arraylist = new ArrayList();
        Cursor cursor = b.query("MsgLogIdTypeStore", null, null, null, null, null, "MsgId Asc ", null);
        for (boolean flag = cursor.moveToFirst(); flag; flag = cursor.moveToNext())
        {
            arraylist.add(new MsgLogIdType(cursor));
        }

        cursor.close();
        return arraylist;
    }

    public ArrayList getMsgLogIdTypes(int l)
    {
        if (l < 1)
        {
            return null;
        }
        ArrayList arraylist = new ArrayList();
        Cursor cursor = b.query("MsgLogIdTypeStore", null, null, null, null, null, "MsgId Asc ", (new StringBuilder()).append(l).append("").toString());
        for (boolean flag = cursor.moveToFirst(); flag; flag = cursor.moveToNext())
        {
            arraylist.add(new MsgLogIdType(cursor));
        }

        cursor.close();
        return arraylist;
    }

    public ArrayList getMsgLogs(int l)
    {
        if (l < 1)
        {
            return null;
        }
        ArrayList arraylist = new ArrayList();
        Cursor cursor = b.query("MsgLogStore", null, null, null, null, null, "Time Asc ", (new StringBuilder()).append(l).append("").toString());
        for (boolean flag = cursor.moveToFirst(); flag; flag = cursor.moveToNext())
        {
            arraylist.add(new MsgLog(cursor));
        }

        cursor.close();
        return arraylist;
    }

    public boolean removeLog(String s, int l)
    {
        boolean flag = true;
        if (TextUtils.isEmpty(s))
        {
            return false;
        }
        String s1 = (new StringBuilder()).append(l).append("").toString();
        if (b.delete("MsgLogStore", "MsgId=? And ActionType=?", new String[] {
    s, s1
}) != 1)
        {
            flag = false;
        }
        return flag;
    }

    public boolean removeLogIdType(String s)
    {
        boolean flag = true;
        if (TextUtils.isEmpty(s))
        {
            return false;
        }
        if (b.delete("MsgLogIdTypeStore", "MsgId=?", new String[] {
    s
}) != 1)
        {
            flag = false;
        }
        return flag;
    }
}
