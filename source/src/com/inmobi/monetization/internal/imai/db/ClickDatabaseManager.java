// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal.imai.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.inmobi.commons.db.ColumnData;
import com.inmobi.commons.db.DatabaseHandler;
import com.inmobi.commons.db.TableData;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.imai.IMAIClickEventList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

// Referenced classes of package com.inmobi.monetization.internal.imai.db:
//            ClickData

public class ClickDatabaseManager extends DatabaseHandler
{

    public static final String COLUMN_CLICK_ID = "clickid";
    public static final String COLUMN_CLICK_URL = "clickurl";
    public static final String COLUMN_FOLLOW_REDIRECT = "followredirect";
    public static final String COLUMN_PINGWV = "pingwv";
    public static final String COLUMN_RETRY_COUNT = "retrycount";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final String TABLE_CLICK = "clickevent";
    private static ClickDatabaseManager a;
    private int b;

    protected ClickDatabaseManager(Context context, ArrayList arraylist)
    {
        super(context, arraylist);
        b = 1000;
    }

    private static TableData a()
    {
        TableData tabledata = new TableData();
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        ColumnData columndata = new ColumnData();
        columndata.setPrimaryKey(true);
        columndata.setDataType(com.inmobi.commons.db.ColumnData.ColumnType.INTEGER);
        columndata.setMandatory(true);
        linkedhashmap.put("clickid", columndata);
        columndata = new ColumnData();
        columndata.setDataType(com.inmobi.commons.db.ColumnData.ColumnType.VARCHAR);
        columndata.setMandatory(true);
        linkedhashmap.put("clickurl", columndata);
        columndata = new ColumnData();
        columndata.setDataType(com.inmobi.commons.db.ColumnData.ColumnType.INTEGER);
        columndata.setMandatory(true);
        linkedhashmap.put("pingwv", columndata);
        columndata = new ColumnData();
        columndata.setDataType(com.inmobi.commons.db.ColumnData.ColumnType.INTEGER);
        columndata.setMandatory(true);
        linkedhashmap.put("followredirect", columndata);
        columndata = new ColumnData();
        columndata.setDataType(com.inmobi.commons.db.ColumnData.ColumnType.INTEGER);
        columndata.setMandatory(true);
        linkedhashmap.put("retrycount", columndata);
        columndata = new ColumnData();
        columndata.setDataType(com.inmobi.commons.db.ColumnData.ColumnType.INTEGER);
        columndata.setMandatory(true);
        linkedhashmap.put("timestamp", columndata);
        tabledata.setmColumns(linkedhashmap);
        tabledata.setmTableName("clickevent");
        return tabledata;
    }

    public static ClickDatabaseManager getInstance()
    {
        com/inmobi/monetization/internal/imai/db/ClickDatabaseManager;
        JVM INSTR monitorenter ;
        ClickDatabaseManager clickdatabasemanager;
        if (a == null)
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add(a());
            a = new ClickDatabaseManager(InternalSDKUtil.getContext(), arraylist);
        }
        clickdatabasemanager = a;
_L2:
        com/inmobi/monetization/internal/imai/db/ClickDatabaseManager;
        JVM INSTR monitorexit ;
        return clickdatabasemanager;
        Object obj;
        obj;
        Log.internal("[InMobi]-[Monetization]", "Exception getting DB Manager Instance", ((Throwable) (obj)));
        obj = null;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        throw obj;
    }

    public boolean deleteClickEvents(ArrayList arraylist)
    {
        this;
        JVM INSTR monitorenter ;
        if (arraylist == null) goto _L2; else goto _L1
_L1:
        if (arraylist.isEmpty()) goto _L2; else goto _L3
_L3:
        open();
        long l;
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); delete("clickevent", (new StringBuilder()).append("clickid = ").append(l).toString(), null))
        {
            l = ((Long)arraylist.next()).longValue();
        }

          goto _L4
        arraylist;
        Log.internal("[InMobi]-[Monetization]", "Exception deleting click events", arraylist);
        boolean flag = false;
_L6:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L4:
        close();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L2:
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
        arraylist;
        throw arraylist;
    }

    public IMAIClickEventList getClickEvents(int i)
    {
        this;
        JVM INSTR monitorenter ;
        IMAIClickEventList imaiclickeventlist = new IMAIClickEventList();
        Cursor cursor;
        open();
        cursor = getNRows("clickevent", "timestamp", i);
        cursor.moveToFirst();
_L4:
        ClickData clickdata;
        clickdata = new ClickData();
        clickdata.setClickId(cursor.getLong(0));
        clickdata.setClickUrl(cursor.getString(1));
        if (1 != cursor.getInt(2)) goto _L2; else goto _L1
_L1:
        clickdata.setPingWv(true);
_L5:
        if (1 != cursor.getInt(3))
        {
            break MISSING_BLOCK_LABEL_178;
        }
        clickdata.setFollowRedirect(true);
_L7:
        clickdata.setRetryCount(cursor.getInt(4));
        clickdata.setTimestamp(cursor.getLong(5));
        imaiclickeventlist.add(clickdata);
        if (cursor.moveToNext()) goto _L4; else goto _L3
_L3:
        cursor.close();
        close();
_L6:
        this;
        JVM INSTR monitorexit ;
        return imaiclickeventlist;
_L2:
        clickdata.setPingWv(false);
          goto _L5
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-[Monetization]", "Failed to get clicks from db", exception1);
          goto _L6
        Exception exception;
        exception;
        throw exception;
        clickdata.setFollowRedirect(false);
          goto _L7
    }

    public int getNoOfEvents()
    {
        int i;
        try
        {
            open();
            i = getInstance().getNoOfRows("clickevent", null, null);
            close();
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Monetization]", "Exception getting no of click events", exception);
            return 0;
        }
        return i;
    }

    public void insertClick(ClickData clickdata)
    {
        this;
        JVM INSTR monitorenter ;
        open();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("timestamp", Long.valueOf(clickdata.getTimestamp()));
        contentvalues.put("clickurl", clickdata.getClickUrl());
        contentvalues.put("pingwv", Boolean.valueOf(clickdata.isPingWv()));
        contentvalues.put("retrycount", Integer.valueOf(clickdata.getRetryCount()));
        contentvalues.put("followredirect", Boolean.valueOf(clickdata.isFollowRedirects()));
        if (getTableSize("clickevent") >= b)
        {
            clickdata = executeQuery("SELECT clickid FROM clickevent WHERE timestamp= (SELECT MIN(timestamp) FROM clickevent Limit 1);", null);
            clickdata.moveToFirst();
            long l = clickdata.getLong(0);
            clickdata.close();
            delete("clickevent", (new StringBuilder()).append("clickid = ").append(l).toString(), null);
        }
        insert("clickevent", contentvalues);
        close();
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        clickdata;
        Log.internal("[InMobi]-[Monetization]", "Failed to insert click event to db", clickdata);
        if (true) goto _L2; else goto _L1
_L1:
        clickdata;
        throw clickdata;
    }

    public void setDBLimit(int i)
    {
        if (i > 0)
        {
            b = i;
        }
    }

    public boolean updateRetryCount(ArrayList arraylist)
    {
        this;
        JVM INSTR monitorenter ;
        if (arraylist == null) goto _L2; else goto _L1
_L1:
        if (arraylist.isEmpty()) goto _L2; else goto _L3
_L3:
        open();
        ClickData clickdata;
        ContentValues contentvalues;
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); update("clickevent", contentvalues, "clickid= ?", new String[] {
    String.valueOf(clickdata.getClickId())
}))
        {
            clickdata = (ClickData)arraylist.next();
            contentvalues = new ContentValues();
            contentvalues.put("clickid", Long.valueOf(clickdata.getClickId()));
            contentvalues.put("clickurl", clickdata.getClickUrl());
            contentvalues.put("followredirect", Boolean.valueOf(clickdata.isFollowRedirects()));
            contentvalues.put("pingwv", Boolean.valueOf(clickdata.isPingWv()));
            contentvalues.put("retrycount", Integer.valueOf(clickdata.getRetryCount() + 1));
            contentvalues.put("timestamp", Long.valueOf(clickdata.getTimestamp()));
        }

          goto _L4
        arraylist;
        Log.internal("[InMobi]-[Monetization]", "Exception updating retry count", arraylist);
        boolean flag = false;
_L6:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L4:
        close();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L2:
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
        arraylist;
        throw arraylist;
    }
}
