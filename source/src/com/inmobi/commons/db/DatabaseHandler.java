// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.inmobi.commons.internal.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

// Referenced classes of package com.inmobi.commons.db:
//            TableData, ColumnData

public abstract class DatabaseHandler extends SQLiteOpenHelper
{

    public static final String DATABASE_NAME = "im.db";
    private static String c = "CREATE TABLE IF NOT EXISTS ";
    private static String d = "DROP TABLE IF EXISTS ";
    private static String e = " PRIMARY KEY ";
    private static String f = " AUTOINCREMENT ";
    private static String g = " NOT NULL ";
    private static String h = "SELECT * FROM ";
    private static String i = " WHERE ";
    private static String j = " ORDER BY ";
    private static String k = "; ";
    private static String l = " Limit ?";
    private ArrayList a;
    private SQLiteDatabase b;

    protected DatabaseHandler(Context context, ArrayList arraylist)
    {
        super(context, "im.db", null, 1);
        a = arraylist;
    }

    private void a(SQLiteDatabase sqlitedatabase)
    {
        if (a == null || a.isEmpty()) goto _L2; else goto _L1
_L1:
        Iterator iterator = a.iterator();
_L5:
        if (!iterator.hasNext()) goto _L2; else goto _L3
_L3:
        Object obj1;
        Object obj = (TableData)iterator.next();
        obj1 = ((TableData) (obj)).getmTableName();
        obj = ((TableData) (obj)).getmColumns();
        obj1 = new StringBuilder((new StringBuilder()).append(c).append(((String) (obj1))).append(" (").toString());
        for (Iterator iterator1 = ((LinkedHashMap) (obj)).keySet().iterator(); iterator1.hasNext(); ((StringBuilder) (obj1)).append(","))
        {
            String s1 = (String)iterator1.next();
            ColumnData columndata = (ColumnData)((LinkedHashMap) (obj)).get(s1);
            ((StringBuilder) (obj1)).append((new StringBuilder()).append(" ").append(s1).append(" ").append(columndata.getDataType().toString()).toString());
            if (columndata.isPrimaryKey())
            {
                ((StringBuilder) (obj1)).append(e);
            }
            if (columndata.isAutoIncrement())
            {
                ((StringBuilder) (obj1)).append(f);
            }
            if (columndata.isMandatory())
            {
                ((StringBuilder) (obj1)).append(g);
            }
        }

          goto _L4
        sqlitedatabase;
        Log.internal("[InMobi]-4.5.5", "Exception creating table", sqlitedatabase);
_L2:
        return;
_L4:
        String s;
        if (',' != ((StringBuilder) (obj1)).charAt(((StringBuilder) (obj1)).length() - 1))
        {
            break MISSING_BLOCK_LABEL_318;
        }
        s = ((StringBuilder) (obj1)).substring(0, ((StringBuilder) (obj1)).length() - 2);
_L6:
        s = s.concat(" );");
        Log.internal("[InMobi]-4.5.5", (new StringBuilder()).append("Table: ").append(s).toString());
        sqlitedatabase.execSQL(s);
          goto _L5
        s = ((StringBuilder) (obj1)).toString();
          goto _L6
    }

    public void close()
    {
        try
        {
            b.close();
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.5.5", "Failed to close  db", exception);
        }
    }

    public int delete(String s, String s1, String as[])
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = b.delete(s, s1, as);
_L2:
        this;
        JVM INSTR monitorexit ;
        return i1;
        s;
        Log.internal("[InMobi]-4.5.5", "Failed to insert to db", s);
        i1 = -1;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        throw s;
    }

    public Cursor executeQuery(String s, String as[])
    {
        this;
        JVM INSTR monitorenter ;
        s = b.rawQuery(s, as);
_L2:
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        Log.internal("[InMobi]-4.5.5", "Failed to execute db query", s);
        s = null;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        throw s;
    }

    public Cursor getAll(String s, String s1)
    {
        Object obj = null;
        this;
        JVM INSTR monitorenter ;
        if (s1 == null) goto _L2; else goto _L1
_L1:
        if (!"".equals(s1.trim())) goto _L3; else goto _L2
_L2:
        s = b.rawQuery((new StringBuilder()).append(h).append(s).append(k).toString(), null);
_L4:
        s.moveToFirst();
_L5:
        this;
        JVM INSTR monitorexit ;
        return s;
_L3:
        s = b.rawQuery((new StringBuilder()).append(h).append(s).append(j).append(s1).append(k).toString(), null);
          goto _L4
        s;
        Log.internal("[InMobi]-4.5.5", "Failed to all rows", s);
        s = obj;
          goto _L5
        s;
        throw s;
          goto _L4
    }

    public Cursor getNRows(String s, String s1, int i1)
    {
        Object obj = null;
        this;
        JVM INSTR monitorenter ;
        if (s1 == null) goto _L2; else goto _L1
_L1:
        if (!"".equals(s1.trim())) goto _L3; else goto _L2
_L2:
        s = b.rawQuery((new StringBuilder()).append(h).append(s).append(k).toString(), null);
_L4:
        s.moveToFirst();
_L5:
        this;
        JVM INSTR monitorexit ;
        return s;
_L3:
        s = b.rawQuery((new StringBuilder()).append(h).append(s).append(j).append(s1).append(l).append(k).toString(), new String[] {
            String.valueOf(i1)
        });
          goto _L4
        s;
        Log.internal("[InMobi]-4.5.5", "Failed to all rows", s);
        s = obj;
          goto _L5
        s;
        throw s;
          goto _L4
    }

    public int getNoOfRows(String s, String s1, String as[])
    {
        this;
        JVM INSTR monitorenter ;
        if (s1 == null) goto _L2; else goto _L1
_L1:
        if ("".equals(s1.trim())) goto _L2; else goto _L3
_L3:
        s = b.rawQuery((new StringBuilder()).append(h).append(s).append(i).append(s1).toString(), as);
_L4:
        int i1;
        i1 = s.getCount();
        s.close();
_L5:
        this;
        JVM INSTR monitorexit ;
        return i1;
_L2:
        s = b.rawQuery((new StringBuilder()).append(h).append(s).append(k).toString(), null);
          goto _L4
        s;
        Log.internal("[InMobi]-4.5.5", "Failed to get number of rows", s);
        i1 = 0;
          goto _L5
        s;
        throw s;
          goto _L4
    }

    public Cursor getRow(String s, String s1, String as[])
    {
        Object obj = null;
        this;
        JVM INSTR monitorenter ;
        if (s1 == null) goto _L2; else goto _L1
_L1:
        if (!"".equals(s1.trim())) goto _L3; else goto _L2
_L2:
        s = b.rawQuery((new StringBuilder()).append(h).append(s).append(k).toString(), null);
_L4:
        s.moveToFirst();
_L5:
        this;
        JVM INSTR monitorexit ;
        return s;
_L3:
        s = b.rawQuery((new StringBuilder()).append(h).append(s).append(i).append(s1).append(k).toString(), as);
          goto _L4
        s;
        Log.internal("[InMobi]-4.5.5", "Failed to all rows", s);
        s = obj;
          goto _L5
        s;
        throw s;
          goto _L4
    }

    protected int getTableSize(String s)
    {
        this;
        JVM INSTR monitorenter ;
        int i1;
        s = b.rawQuery((new StringBuilder()).append(h).append(s).append(k).toString(), null);
        i1 = s.getCount();
        s.close();
_L2:
        this;
        JVM INSTR monitorexit ;
        return i1;
        s;
        Log.internal("[InMobi]-4.5.5", "Failed to table size ", s);
        i1 = 0;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        throw s;
    }

    public long insert(String s, ContentValues contentvalues)
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = b.insert(s, null, contentvalues);
_L2:
        this;
        JVM INSTR monitorexit ;
        return l1;
        s;
        Log.internal("[InMobi]-4.5.5", "Failed to insert to db", s);
        l1 = -1L;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        throw s;
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        try
        {
            a(sqlitedatabase);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SQLiteDatabase sqlitedatabase)
        {
            Log.internal("[InMobi]-4.5.5", "Exception Creating table", sqlitedatabase);
        }
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i1, int j1)
    {
        try
        {
            String s;
            for (Iterator iterator = a.iterator(); iterator.hasNext(); sqlitedatabase.execSQL((new StringBuilder()).append(d).append(s).toString()))
            {
                s = ((TableData)iterator.next()).getmTableName();
            }

        }
        // Misplaced declaration of an exception variable
        catch (SQLiteDatabase sqlitedatabase)
        {
            Log.internal("[InMobi]-4.5.5", "Exception Deleting table", sqlitedatabase);
            return;
        }
        onCreate(sqlitedatabase);
        return;
    }

    public void open()
    {
        try
        {
            b = getWritableDatabase();
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.5.5", "Failed to open  db", exception);
        }
    }

    public long update(String s, ContentValues contentvalues, String s1, String as[])
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = b.update(s, contentvalues, s1, as);
        long l1 = i1;
_L2:
        this;
        JVM INSTR monitorexit ;
        return l1;
        s;
        Log.internal("[InMobi]-4.5.5", "Failed to insert to db", s);
        l1 = -1L;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        throw s;
    }

}
