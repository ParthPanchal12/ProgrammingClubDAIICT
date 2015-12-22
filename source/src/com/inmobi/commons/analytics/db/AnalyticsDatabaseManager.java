// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Handler;
import com.inmobi.commons.analytics.net.AnalyticsNetworkManager;
import com.inmobi.commons.analytics.util.AnalyticsUtils;
import com.inmobi.commons.analytics.util.SessionInfo;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.inmobi.commons.analytics.db:
//            AnalyticsEvent, AnalyticsSQLiteHelper

public final class AnalyticsDatabaseManager
{

    private static AnalyticsDatabaseManager c;
    private static final String d[] = {
        "_id", "eventid", "type", "sid", "ts", "ssts", "am"
    };
    private static final String e[] = {
        "_id", "levelid", "levelname"
    };
    private static final String f[] = {
        "_id", "levelid", "levelname", "levelstatus", "timetaken", "attemptcount", "attempttime"
    };
    private static final String g[] = {
        "_id", "eventname"
    };
    private static final String h[] = {
        "_id", "attributename", "attributevalue"
    };
    private static final String i[] = {
        "_id", "levelid", "begintime", "totalcount", "totaltime"
    };
    private static final String j[] = {
        "_id", "itemName", "itemType", "itemCount", "itemDescription", "itemPrice", "currencyCode", "productId", "transactionId", "transactionStatus"
    };
    private AnalyticsSQLiteHelper a;
    private SQLiteDatabase b;

    private AnalyticsDatabaseManager()
    {
    }

    private AnalyticsEvent a(Cursor cursor)
    {
        Object obj;
        AnalyticsEvent analyticsevent;
        String s;
        long l;
        obj = null;
        analyticsevent = new AnalyticsEvent(cursor.getString(2));
        analyticsevent.setEventSessionId(cursor.getString(3));
        analyticsevent.setEventId(cursor.getLong(0));
        analyticsevent.setEventTimeStamp(cursor.getLong(4));
        analyticsevent.setEventSessionTimeStamp(cursor.getLong(5));
        analyticsevent.setEventAttributeMap(cursor.getString(6));
        l = cursor.getLong(1);
        s = Long.toString(l);
        Log.debug("[InMobi]-[Analytics]-4.5.5", (new StringBuilder()).append("IMAppDatabaseManager->").append(analyticsevent.getEventType()).append("-").append(l).toString());
        if (l <= -1L) goto _L2; else goto _L1
_L1:
        if (!analyticsevent.getEventType().equals("lb")) goto _L4; else goto _L3
_L3:
        cursor = b.query("levelbegin", e, "_id = ?", new String[] {
            s
        }, null, null, null);
        cursor.moveToFirst();
        analyticsevent.setEventLevelId(cursor.getString(1));
        analyticsevent.setEventLevelName(cursor.getString(2));
_L6:
        if (cursor != null)
        {
            cursor.close();
        }
_L2:
        return analyticsevent;
_L4:
        if (analyticsevent.getEventType().equals("le"))
        {
            cursor = b.query("levelend", f, "_id = ?", new String[] {
                s
            }, null, null, null);
            cursor.moveToFirst();
            analyticsevent.setEventLevelId(cursor.getString(1));
            analyticsevent.setEventLevelName(cursor.getString(2));
            analyticsevent.setEventLevelStatus(cursor.getString(3));
            analyticsevent.setEventTimeTaken(cursor.getString(4));
            analyticsevent.setEventAttemptCount(cursor.getString(5));
            analyticsevent.setEventAttemptTime(cursor.getString(6));
        } else
        if (analyticsevent.getEventType().equals("ce"))
        {
            cursor = b.query("customevent", g, "_id = ?", new String[] {
                s
            }, null, null, null);
            cursor.moveToFirst();
            analyticsevent.setEventCustomName(cursor.getString(1));
        } else
        if (analyticsevent.getEventType().equals("ae"))
        {
            cursor = b.query("attribute", h, "_id = ?", new String[] {
                s
            }, null, null, null);
            cursor.moveToFirst();
            analyticsevent.setUserAttribute(cursor.getString(1), cursor.getString(2));
        } else
        {
            cursor = obj;
            if (analyticsevent.getEventType().equals("pi"))
            {
                cursor = b.query("transactiondetail", j, "_id = ?", new String[] {
                    s
                }, null, null, null);
                cursor.moveToFirst();
                analyticsevent.setTransactionItemName(cursor.getString(1));
                analyticsevent.setTransactionItemType(cursor.getInt(2));
                analyticsevent.setTransactionItemCount(cursor.getInt(3));
                analyticsevent.setTransactionItemDescription(cursor.getString(4));
                analyticsevent.setTransactionItemPrice(cursor.getDouble(5));
                analyticsevent.setTransactionCurrencyCode(cursor.getString(6));
                analyticsevent.setTransactionProductId(cursor.getString(7));
                analyticsevent.setTransactionId(cursor.getString(8));
                analyticsevent.setTransactionStatus(cursor.getInt(9));
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void a()
    {
        b = a.getWritableDatabase();
    }

    private void a(AnalyticsEvent analyticsevent, long l)
    {
        Log.debug("[InMobi]-[Analytics]-4.5.5", (new StringBuilder()).append("IMAppDatabaseManager->insertEvents-").append(analyticsevent.getEventType()).toString());
        if (l < AnalyticsUtils.getMaxdbcount())
        {
            ContentValues contentvalues2 = new ContentValues();
            l = -1L;
            long l1 = analyticsevent.getEventTimeStamp();
            ContentValues contentvalues1;
            if (analyticsevent.getEventType().equals("lb"))
            {
                ContentValues contentvalues = new ContentValues();
                contentvalues.put("begintime", Long.valueOf(l1));
                if (b.update("attemptdata", contentvalues, "levelid = ?", new String[] {
    analyticsevent.getEventLevelId()
}) <= 0)
                {
                    contentvalues.put("levelid", analyticsevent.getEventLevelId());
                    contentvalues.put("totalcount", Integer.toString(0));
                    contentvalues.put("totaltime", Integer.toString(0));
                    b.insert("attemptdata", null, contentvalues);
                }
                contentvalues2.put("levelid", analyticsevent.getEventLevelId());
                contentvalues2.put("levelname", analyticsevent.getEventLevelName());
                l = b.insert("levelbegin", null, contentvalues2);
            } else
            if (analyticsevent.getEventType().equals("le"))
            {
                Cursor cursor = b.query("attemptdata", i, "levelid = ?", new String[] {
                    analyticsevent.getEventLevelId()
                }, null, null, null, "1");
                String s;
                String s1;
                String s2;
                int k;
                if (cursor.getCount() > 0)
                {
                    cursor.moveToFirst();
                    l = l1 - Long.parseLong(cursor.getString(2));
                    s2 = Long.toString(l);
                    s = Long.toString(l + Long.parseLong(cursor.getString(4)));
                    s1 = Integer.toString(Integer.parseInt(cursor.getString(3)) + 1);
                    ContentValues contentvalues3 = new ContentValues();
                    contentvalues3.put("totalcount", s1);
                    contentvalues3.put("totaltime", s);
                    b.update("attemptdata", contentvalues3, "levelid = ?", new String[] {
                        analyticsevent.getEventLevelId()
                    });
                } else
                {
                    s = "0";
                    s1 = "0";
                    s2 = "0";
                }
                cursor.close();
                contentvalues2.put("levelid", analyticsevent.getEventLevelId());
                contentvalues2.put("levelstatus", analyticsevent.getEventLevelStatus());
                contentvalues2.put("levelname", analyticsevent.getEventLevelName());
                contentvalues2.put("timetaken", s2);
                contentvalues2.put("attemptcount", s1);
                contentvalues2.put("attempttime", s);
                l = b.insert("levelend", null, contentvalues2);
            } else
            if (analyticsevent.getEventType().equals("pi"))
            {
                contentvalues2.put("itemName", analyticsevent.getTransactionItemName());
                k = analyticsevent.getTransactionItemType();
                if (AnalyticsEvent.TRANSACTION_ITEM_TYPE.INVALID.getValue() != k)
                {
                    contentvalues2.put("itemType", Integer.valueOf(k));
                }
                k = analyticsevent.getTransactionItemCount();
                if (k > 0)
                {
                    contentvalues2.put("itemCount", Integer.valueOf(k));
                }
                contentvalues2.put("itemDescription", analyticsevent.getTransactionItemDescription());
                contentvalues2.put("itemPrice", Double.valueOf(analyticsevent.getTransactionItemPrice()));
                contentvalues2.put("currencyCode", analyticsevent.getTransactionCurrencyCode());
                contentvalues2.put("productId", analyticsevent.getTransactionProductId());
                contentvalues2.put("transactionId", analyticsevent.getTransactionId());
                k = analyticsevent.getTransactionStatus();
                if (AnalyticsEvent.TRANSACTION_STATUS_SERVER_CODE.INVALID.getValue() != k)
                {
                    contentvalues2.put("transactionStatus", Integer.valueOf(k));
                }
                l = b.insert("transactiondetail", null, contentvalues2);
            } else
            if (analyticsevent.getEventType().equals("ce"))
            {
                contentvalues2.put("eventname", analyticsevent.getEventCustomName());
                l = b.insert("customevent", null, contentvalues2);
            } else
            if (analyticsevent.getEventType().equals("ae"))
            {
                contentvalues2.put("attributename", analyticsevent.getAttributeName());
                contentvalues2.put("attributevalue", analyticsevent.getAttributeValue());
                l = b.insert("attribute", null, contentvalues2);
            }
            contentvalues1 = new ContentValues();
            contentvalues1.put("eventid", Long.valueOf(l));
            contentvalues1.put("type", analyticsevent.getEventType());
            contentvalues1.put("sid", analyticsevent.getEventSessionId());
            contentvalues1.put("ts", Long.valueOf(analyticsevent.getEventTimeStamp()));
            contentvalues1.put("ssts", Long.valueOf(analyticsevent.getEventSessionTimeStamp()));
            contentvalues1.put("am", analyticsevent.getEventAttributeMap());
            b.insert("eventlist", null, contentvalues1);
        } else
        {
            Log.debug("[InMobi]-[Analytics]-4.5.5", "Database full");
        }
        if (!AnalyticsUtils.getStartHandle() && AnalyticsNetworkManager.getHandler() != null)
        {
            AnalyticsUtils.setStartHandle(true);
            AnalyticsNetworkManager.getHandler().sendEmptyMessageDelayed(1001, AnalyticsUtils.getTimeinterval());
        }
    }

    private void a(List list)
    {
        Log.debug("[InMobi]-[Analytics]-4.5.5", "IMAppDatabaseManager->deleteEvents");
        list = list.iterator();
        while (list.hasNext()) 
        {
            String s = ((Long)list.next()).toString();
            Cursor cursor = b.query("eventlist", d, "_id=?", new String[] {
                s
            }, null, null, null, "1");
            cursor.moveToFirst();
            Long long1 = Long.valueOf(cursor.getLong(1));
            String s1 = long1.toString();
            String s2 = cursor.getString(2);
            if (long1.longValue() > -1L)
            {
                if (s2.equals("lb"))
                {
                    b.delete("levelbegin", "_id = ?", new String[] {
                        s1
                    });
                } else
                if (s2.equals("le"))
                {
                    b.delete("levelend", "_id = ?", new String[] {
                        s1
                    });
                } else
                if (s2.equals("ce"))
                {
                    b.delete("customevent", "_id = ?", new String[] {
                        s1
                    });
                } else
                if (s2.equals("ae"))
                {
                    b.delete("attribute", "_id = ?", new String[] {
                        s1
                    });
                } else
                if (s2.equals("pi"))
                {
                    b.delete("transactiondetail", "_id = ?", new String[] {
                        s1
                    });
                }
            }
            cursor.close();
            b.delete("eventlist", "_id = ?", new String[] {
                s
            });
        }
    }

    private void b()
    {
        a.close();
    }

    private List c()
    {
        Log.debug("[InMobi]-[Analytics]-4.5.5", "IMAppDatabaseManager->getEvents");
        ArrayList arraylist = new ArrayList();
        if (!b.isOpen())
        {
            android.util.Log.v("[InMobi]-[Analytics]-4.5.5", "IMAppDatabaseManager->getEvents()-database is not open");
            return arraylist;
        }
        Cursor cursor = b.query("eventlist", d, null, null, null, null, null, AnalyticsUtils.getMaxevents());
        cursor.moveToFirst();
        for (; !cursor.isAfterLast(); cursor.moveToNext())
        {
            AnalyticsEvent analyticsevent = a(cursor);
            analyticsevent.setEventTableId(cursor.getLong(0));
            arraylist.add(analyticsevent);
        }

        cursor.close();
        return arraylist;
    }

    public static AnalyticsDatabaseManager getInstance()
    {
        com/inmobi/commons/analytics/db/AnalyticsDatabaseManager;
        JVM INSTR monitorenter ;
        AnalyticsDatabaseManager analyticsdatabasemanager;
        if (c == null)
        {
            c = new AnalyticsDatabaseManager();
            File file = InternalSDKUtil.getContext().getDatabasePath("appengage.db");
            if (file.isFile())
            {
                file.renameTo(InternalSDKUtil.getContext().getDatabasePath("ltvp.db"));
                SessionInfo.updatedFromOldSDK(InternalSDKUtil.getContext());
            }
            c.a = new AnalyticsSQLiteHelper(InternalSDKUtil.getContext());
        }
        analyticsdatabasemanager = c;
        com/inmobi/commons/analytics/db/AnalyticsDatabaseManager;
        JVM INSTR monitorexit ;
        return analyticsdatabasemanager;
        Exception exception;
        exception;
        throw exception;
    }

    public void deleteEvents(List list)
    {
        this;
        JVM INSTR monitorenter ;
        a();
        a(list);
        b();
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        list;
        Log.internal("[InMobi]-[Analytics]-4.5.5", "Error deleting from DB.");
        if (true) goto _L2; else goto _L1
_L1:
        list;
        throw list;
    }

    public List getEvents()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        a();
        obj = c();
        b();
_L2:
        this;
        JVM INSTR monitorexit ;
        return ((List) (obj));
        Object obj1;
        obj1;
        Log.internal("[InMobi]-[Analytics]-4.5.5", "Error reading events from DB.");
        obj1 = new ArrayList();
        if (true) goto _L2; else goto _L1
_L1:
        obj1;
        throw obj1;
    }

    public void insertEvents(AnalyticsEvent analyticsevent)
    {
        this;
        JVM INSTR monitorenter ;
        a();
        a(analyticsevent, b.compileStatement("SELECT COUNT(*) FROM eventlist").simpleQueryForLong());
        b();
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        analyticsevent;
        Log.internal("[InMobi]-[Analytics]-4.5.5", "Error in inserting into DB.", analyticsevent);
        analyticsevent.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
        analyticsevent;
        throw analyticsevent;
    }

}
