// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.ads.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;

// Referenced classes of package com.inmobi.commons.ads.cache:
//            AdDatabaseHelper, AdData

public class AdDatabaseManager
{

    private static AdDatabaseManager c;
    private AdDatabaseHelper a;
    private SQLiteDatabase b;
    private int d;

    protected AdDatabaseManager()
    {
        d = 1000;
    }

    public static AdDatabaseManager getInstance()
    {
        com/inmobi/commons/ads/cache/AdDatabaseManager;
        JVM INSTR monitorenter ;
        AdDatabaseManager addatabasemanager;
        if (c == null)
        {
            c = new AdDatabaseManager();
            c.a = new AdDatabaseHelper(InternalSDKUtil.getContext());
        }
        addatabasemanager = c;
        com/inmobi/commons/ads/cache/AdDatabaseManager;
        JVM INSTR monitorexit ;
        return addatabasemanager;
        Exception exception;
        exception;
        throw exception;
    }

    protected void close()
    {
        try
        {
            b.close();
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.5.5", "Failed to close ads db", exception);
        }
    }

    public AdData getAd(String s)
    {
        this;
        JVM INSTR monitorenter ;
        open();
        Cursor cursor = b.rawQuery("SELECT * FROM ad WHERE appid = ? Order by timestamp Limit 1;", new String[] {
            s
        });
        cursor.moveToFirst();
        s = new AdData();
        s.setAdId(cursor.getLong(0));
        s.setTimestamp(cursor.getLong(1));
        s.setAppId(cursor.getString(2));
        s.setContent(cursor.getString(3));
        cursor.close();
        b.delete("ad", (new StringBuilder()).append("adid = ").append(s.getAdId()).toString(), null);
        close();
_L2:
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        Log.internal("[InMobi]-4.5.5", "Failed to get native ads from db", s);
        s = null;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        throw s;
    }

    protected int getDBSize()
    {
        int i;
        try
        {
            open();
            i = b.rawQuery("SELECT * FROM ad; ", null).getCount();
            close();
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.5.5", "Failed to get native ads from db", exception);
            return 0;
        }
        return i;
    }

    public int getNoOfAds(String s)
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        open();
        i = b.rawQuery("SELECT * FROM ad WHERE appid = ?; ", new String[] {
            s
        }).getCount();
        close();
_L2:
        this;
        JVM INSTR monitorexit ;
        return i;
        s;
        Log.internal("[InMobi]-4.5.5", "Failed to get native ads from db", s);
        i = 0;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        throw s;
    }

    public void insertAd(AdData addata)
    {
        this;
        JVM INSTR monitorenter ;
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("timestamp", Long.valueOf(addata.getTimestamp()));
        contentvalues.put("appid", addata.getAppId());
        contentvalues.put("content", addata.getContent());
        contentvalues.put("adtype", addata.getAdType());
        if (getDBSize() >= d)
        {
            open();
            addata = b.rawQuery("SELECT adid FROM ad WHERE timestamp= (SELECT MIN(timestamp) FROM ad Limit 1);", null);
            addata.moveToFirst();
            long l = addata.getLong(0);
            addata.close();
            b.delete("ad", (new StringBuilder()).append("adid = ").append(l).toString(), null);
            close();
        }
        open();
        b.insert("ad", null, contentvalues);
        close();
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        addata;
        Log.internal("[InMobi]-4.5.5", "Failed to insert native ads to db", addata);
        if (true) goto _L2; else goto _L1
_L1:
        addata;
        throw addata;
    }

    protected void open()
    {
        try
        {
            b = a.getWritableDatabase();
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.5.5", "Failed to open ads db", exception);
        }
    }

    public void removeExpiredAds(long l, String s)
    {
        try
        {
            open();
            long l1 = System.currentTimeMillis();
            int i = b.delete("ad", "timestamp<? AND adtype=?", new String[] {
                Long.toString(l1 - 1000L * l), s
            });
            close();
            Log.internal("[InMobi]-4.5.5", (new StringBuilder()).append("Deleted ").append(i).append(" expired ads from cache.").toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.internal("[InMobi]-4.5.5", "Failed to remove expired ads from cache", s);
        }
    }

    public void setDBLimit(int i)
    {
        if (i > 0)
        {
            d = i;
        }
    }
}
