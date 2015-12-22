// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.client;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.message.proguard.aI;
import com.umeng.message.proguard.aJ;
import com.umeng.message.proguard.bs;
import com.umeng.message.proguard.bw;
import org.android.agoo.net.mtop.IMtopSynClient;
import org.android.agoo.net.mtop.MtopRequest;
import org.android.agoo.net.mtop.MtopSyncClientV3;

// Referenced classes of package org.android.agoo.client:
//            BaseRegistrar, AgooSettings

class MessageService
{
    private static class MessageDBHelper extends SQLiteOpenHelper
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

        public void onUpgrade(SQLiteDatabase sqlitedatabase, int i1, int j1)
        {
        }

        public MessageDBHelper(Context context)
        {
            super(context, "message_db", null, 1);
        }
    }


    private static final String a = "MessageService";
    private static final String b = "message_db";
    private static final String c = "message";
    private static final int d = 1;
    private static final String e = "id";
    private static final String f = "type";
    private static final String g = "message";
    private static final String h = "notify";
    private static final String i = "report";
    private static final String j = "interval";
    private static final String k = "target_time";
    private static final String l = "create_time";
    private static final String m = "state";
    private static final String n = "body_code";
    private static final int o = 1;
    private static final int p = 0;
    private static volatile MessageService r = null;
    private volatile SQLiteOpenHelper q;
    private Context s;

    private MessageService(Context context)
    {
        q = null;
        s = context;
        q = new MessageDBHelper(context);
    }

    private long a(long l1, int i1)
    {
        return (long)bw.a(i1 * 60 * 1000) + l1;
    }

    private void a(String s1, String s2, String s3, int i1, long l1, int j1, 
            int k1)
    {
        String s4;
        Object obj;
        aJ.c("MessageService", (new StringBuilder()).append("add sqlite3--->[").append(s1).append("]").toString());
        obj = null;
        s4 = obj;
        if (!TextUtils.isEmpty(s2)) goto _L2; else goto _L1
_L1:
        String s5;
        int i2;
        s5 = "";
        i2 = -1;
_L8:
        String s6;
        s6 = s3;
        s4 = obj;
        if (TextUtils.isEmpty(s3))
        {
            s6 = "";
        }
        s4 = obj;
        s2 = q.getWritableDatabase();
        s4 = s2;
        s2.execSQL("INSERT INTO message VALUES(?,?,?,?,?,?,?,?,?,date('now'))", new Object[] {
            s1, Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(0), Long.valueOf(l1), Integer.valueOf(j1), s6, s5, Integer.valueOf(k1)
        });
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_166;
        }
        s2.close();
_L4:
        return;
_L2:
        s4 = obj;
        i2 = s2.hashCode();
        s5 = s2;
        continue; /* Loop/switch isn't completed */
        s1;
        if (s4 == null) goto _L4; else goto _L3
_L3:
        try
        {
            s4.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return;
        }
        s1;
        s2 = null;
_L6:
        if (s2 != null)
        {
            try
            {
                s2.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s2) { }
        }
        throw s1;
        s1;
        return;
        s1;
        if (true) goto _L6; else goto _L5
_L5:
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void a(String s1, String s2, String s3, long l1, int i1, int j1)
    {
        if (l1 < System.currentTimeMillis())
        {
            aJ.c("MessageService", (new StringBuilder()).append("sendAtTime messageId[").append(s1).append("] targetTime[").append(bs.a(l1)).append("] <=currentTime[").append(bs.a(System.currentTimeMillis())).append("]").toString());
            return;
        } else
        {
            long l2 = a(l1, i1);
            aJ.c("MessageService", (new StringBuilder()).append("sendAtTime message---->[").append(s1).append("]serverTime--->[").append(bs.a(l1)).append(",").append(i1).append(" min]targetTime---->[").append(bs.a(l2)).append("]").toString());
            Bundle bundle = new Bundle();
            bundle.putString("body", s2);
            bundle.putString("id", s1);
            bundle.putString("type", s3);
            bundle.putBoolean("local", true);
            bundle.putString("notify", (new StringBuilder()).append("").append(j1).toString());
            s2 = (AlarmManager)s.getSystemService("alarm");
            s3 = new Intent();
            s3.setAction("org.agoo.android.intent.action.RECEIVE");
            s3.setPackage(s.getPackageName());
            s3.putExtras(bundle);
            s2.set(1, l2, PendingIntent.getBroadcast(s, s1.hashCode(), s3, 0x8000000));
            return;
        }
    }

    public static MessageService getSingleton(Context context)
    {
        org/android/agoo/client/MessageService;
        JVM INSTR monitorenter ;
        if (r == null)
        {
            r = new MessageService(context);
        }
        context = r;
        org/android/agoo/client/MessageService;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public void addMessage(String s1, String s2, String s3, int i1)
    {
        a(s1, s2, s3, 1, -1L, -1, i1);
    }

    public void deleteExpireTimeMessage()
    {
        deleteExpireTimeMessage(30);
    }

    public void deleteExpireTimeMessage(int i1)
    {
        SQLiteDatabase sqlitedatabase1 = null;
        SQLiteDatabase sqlitedatabase = null;
        Object obj;
        Throwable throwable;
        SQLiteDatabase sqlitedatabase2;
        Throwable throwable1;
        if (i1 <= 7)
        {
            i1 = 7;
        }
        sqlitedatabase2 = q.getWritableDatabase();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase2.execSQL((new StringBuilder()).append("delete from message where create_time< date('now','-").append(i1).append(" day')").toString());
        if (sqlitedatabase2 == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        sqlitedatabase2.close();
_L2:
        return;
        throwable1;
        sqlitedatabase1 = sqlitedatabase;
        Log.e("MessageService", "sql Throwable", throwable1);
        if (sqlitedatabase == null) goto _L2; else goto _L1
_L1:
        try
        {
            sqlitedatabase.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
        obj;
        if (sqlitedatabase1 != null)
        {
            try
            {
                sqlitedatabase1.close();
            }
            // Misplaced declaration of an exception variable
            catch (Throwable throwable) { }
        }
        throw obj;
        obj;
    }

    public void handleMessageAtTime(String s1, String s2, String s3, String s4, int i1)
    {
        String as[] = s4.split("_");
        if (as.length != 2) goto _L2; else goto _L1
_L1:
        long l1 = Long.parseLong(as[0]);
        int j1 = Integer.parseInt(as[1]);
_L5:
        if (l1 == -1L || j1 == -1 || l1 < System.currentTimeMillis())
        {
            aJ.e("MessageService", (new StringBuilder()).append("handleMessageAtTime messageId [").append(s1).append("]  targetTime[").append(bs.a(l1)).append("] <=currentTime[").append(bs.a(System.currentTimeMillis())).append("]").toString());
            addMessage(s1, s2, s3, i1);
        }
        if (l1 >= System.currentTimeMillis())
        {
            a(s1, s2, s3, 0, l1, j1, i1);
            a(s1, s2, s3, l1, j1, i1);
        }
        return;
        Throwable throwable;
        throwable;
        l1 = -1L;
_L3:
        aJ.e("MessageService", (new StringBuilder()).append("[").append(s4).append("] to Integer error").toString());
        j1 = -1;
        continue; /* Loop/switch isn't completed */
        throwable;
        if (true) goto _L3; else goto _L2
_L2:
        j1 = -1;
        l1 = -1L;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public boolean hasMessageDuplicate(String s1, int i1)
    {
        String s2;
        String s3;
        Object obj;
        Object obj1;
        boolean flag1;
        boolean flag3;
        s2 = null;
        obj1 = null;
        obj = null;
        s3 = null;
        flag3 = false;
        flag1 = false;
        SQLiteDatabase sqlitedatabase = q.getWritableDatabase();
        s2 = obj1;
        s3 = obj;
        s1 = sqlitedatabase.rawQuery("select count(1) from message where id = ?", new String[] {
            s1
        });
        boolean flag;
        flag = flag1;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        flag = flag1;
        s2 = s1;
        s3 = s1;
        if (!s1.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_102;
        }
        s2 = s1;
        s3 = s1;
        i1 = s1.getInt(0);
        flag = flag1;
        if (i1 > 0)
        {
            flag = true;
        }
        Throwable throwable;
        boolean flag2;
        if (s1 != null)
        {
            try
            {
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                return flag;
            }
        }
        flag2 = flag;
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        sqlitedatabase.close();
        flag2 = flag;
_L2:
        return flag2;
        s1;
        sqlitedatabase = null;
_L5:
        if (s3 != null)
        {
            try
            {
                s3.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                return false;
            }
        }
        flag2 = flag3;
        if (sqlitedatabase == null) goto _L2; else goto _L1
_L1:
        sqlitedatabase.close();
        return false;
        s1;
        sqlitedatabase = null;
_L4:
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_178;
        }
        s2.close();
        if (sqlitedatabase != null)
        {
            try
            {
                sqlitedatabase.close();
            }
            // Misplaced declaration of an exception variable
            catch (Throwable throwable) { }
        }
        throw s1;
        s1;
        if (true) goto _L4; else goto _L3
_L3:
        s1;
          goto _L5
    }

    public void notice(String s1)
    {
        SQLiteDatabase sqlitedatabase;
        SQLiteDatabase sqlitedatabase1;
        sqlitedatabase1 = null;
        sqlitedatabase = null;
        SQLiteDatabase sqlitedatabase2 = q.getWritableDatabase();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase2.execSQL("update message set state=1 where id=?", new Object[] {
            s1
        });
        if (sqlitedatabase2 == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        sqlitedatabase2.close();
_L2:
        return;
        s1;
        sqlitedatabase1 = sqlitedatabase;
        Log.e("MessageService", "sql Throwable", s1);
        if (sqlitedatabase == null) goto _L2; else goto _L1
_L1:
        try
        {
            sqlitedatabase.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return;
        }
        s1;
        if (sqlitedatabase1 != null)
        {
            try
            {
                sqlitedatabase1.close();
            }
            catch (Throwable throwable) { }
        }
        throw s1;
        s1;
    }

    public void reloadMessageAtTime()
    {
        Cursor cursor1 = null;
        aJ.c("MessageService", "reloadMessageAtTime:start");
        Object obj;
        Cursor cursor;
        Object obj1;
        try
        {
            obj = q.getWritableDatabase();
        }
        catch (Throwable throwable)
        {
            throwable = null;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            cursor1 = null;
            obj = null;
        }
_L3:
        ((SQLiteDatabase) (obj)).execSQL("delete from message where create_time< date('now','-7 day')");
        cursor = ((SQLiteDatabase) (obj)).rawQuery("select id,message,type,target_time,interval,notify from message where state= ?", new String[] {
            "0"
        });
        cursor1 = cursor;
        if (cursor1 == null) goto _L2; else goto _L1
_L1:
        for (; cursor1.moveToNext(); a(cursor1.getString(0), cursor1.getString(1), cursor1.getString(2), cursor1.getLong(3), cursor1.getInt(4), cursor1.getInt(5))) { }
          goto _L2
        obj1;
_L6:
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_118;
        }
        cursor1.close();
        if (obj != null)
        {
            try
            {
                ((SQLiteDatabase) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        aJ.c("MessageService", "reloadMessageAtTime:end");
        return;
_L2:
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        cursor1.close();
        if (obj != null)
        {
            try
            {
                ((SQLiteDatabase) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_126;
        }
_L4:
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        cursor1.close();
        if (obj != null)
        {
            try
            {
                ((SQLiteDatabase) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        throw obj1;
        obj1;
        cursor1 = null;
        continue; /* Loop/switch isn't completed */
        obj1;
        if (true) goto _L4; else goto _L3
        Throwable throwable1;
        throwable1;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean report(String s1, String s2, String s3, String s4)
    {
label0:
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (TextUtils.isEmpty(s3))
            {
                break label0;
            }
            flag = flag1;
            try
            {
                if (Integer.parseInt(s3) < -1)
                {
                    break label0;
                }
                MtopRequest mtoprequest = new MtopRequest();
                mtoprequest.setApi("mtop.push.msg.report");
                mtoprequest.setV("1.0");
                mtoprequest.putParams("messageId", (new StringBuilder()).append(s1).append("@").append(s4).toString());
                mtoprequest.putParams("mesgStatus", "4");
                if (!TextUtils.isEmpty(s2))
                {
                    mtoprequest.putParams("taskId", s2);
                }
                mtoprequest.setDeviceId(BaseRegistrar.getRegistrationId(s));
                s1 = new MtopSyncClientV3();
                s1.setDefaultAppkey(aI.n(s));
                s1.setDefaultAppSecret(aI.p(s));
                s1.setBaseUrl(AgooSettings.getPullUrl(s));
                s1.getV3(s, mtoprequest);
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                aJ.e("MessageService", (new StringBuilder()).append("[").append(s3).append("] to Integer error").toString(), s1);
                return false;
            }
            flag = true;
        }
        return flag;
    }

}
