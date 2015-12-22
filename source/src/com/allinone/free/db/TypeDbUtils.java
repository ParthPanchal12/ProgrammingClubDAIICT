// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.db;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.RemoteViews;
import com.allinone.free.activity.AppDownloadedActivity;
import com.allinone.free.mydownload.ContentValue;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.utils.MD5;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.publicTools;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.allinone.free.db:
//            TypeDb

public class TypeDbUtils
    implements ContentValue
{

    public static NotificationManager mNotificationManager;
    private TypeDb db;
    private FinalDBChen finalDBChen;
    private Context mContext;
    private PackageInfo packageInfo;
    public publicTools puTools;

    public TypeDbUtils(Context context)
    {
        packageInfo = null;
        db = new TypeDb(context);
        mContext = context;
        mNotificationManager = (NotificationManager)context.getSystemService("notification");
        finalDBChen = new FinalDBChen(context, context.getDatabasePath("download2.db").getAbsolutePath());
        puTools = new publicTools(context);
    }

    public void deleteallfile(String s)
    {
        db.getWritableDatabase().delete("file_list", "typ=?", new String[] {
            (new StringBuilder(String.valueOf(s))).toString()
        });
    }

    public void deletefile(String s)
    {
        db.getWritableDatabase().delete("file_list", "id=?", new String[] {
            (new StringBuilder(String.valueOf(s))).toString()
        });
    }

    public void insertApk(String s, String s1, String s2, String s3, String s4, String s5, int i, 
            Long long1)
    {
        SQLiteDatabase sqlitedatabase = db.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("id", s);
        contentvalues.put("typ", s1);
        contentvalues.put("title", s2);
        contentvalues.put("icon", s3);
        contentvalues.put("size", s4);
        contentvalues.put("path", s5);
        contentvalues.put("serial", Integer.valueOf(i));
        contentvalues.put("create_time", long1);
        sqlitedatabase.insert("file_list", null, contentvalues);
        sqlitedatabase.close();
    }

    public List queryApk(String s, String s1)
    {
        Cursor cursor;
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = db.getWritableDatabase();
        cursor = null;
        if (!s1.equals("timesort")) goto _L2; else goto _L1
_L1:
        cursor = sqlitedatabase.query("file_list", null, (new StringBuilder("typ='")).append(s).append("'").toString(), null, null, null, "create_time DESC");
_L8:
        s = new ArrayList();
        if (cursor == null) goto _L4; else goto _L3
_L3:
        if (cursor.moveToNext()) goto _L5; else goto _L4
_L4:
        if (cursor == null)
        {
            return null;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (s1.equals("zimusort"))
        {
            cursor = sqlitedatabase.query("file_list", null, (new StringBuilder("typ='")).append(s).append("'").toString(), null, null, null, "title ASC");
        }
        continue; /* Loop/switch isn't completed */
_L5:
        s1 = new DownloadMovieItem();
        s1.setFile_id(cursor.getString(cursor.getColumnIndex("id")));
        s1.setType(cursor.getString(cursor.getColumnIndex("typ")));
        s1.setMovieName(cursor.getString(cursor.getColumnIndex("title")));
        s1.setMovieHeadImagePath(cursor.getString(cursor.getColumnIndex("icon")));
        s1.setFileSize(cursor.getString(cursor.getColumnIndex("size")));
        s1.setFilePath(cursor.getString(cursor.getColumnIndex("path")));
        s1.setSerial(cursor.getInt(cursor.getColumnIndex("serial")));
        s1.setCreate_time(Long.valueOf(cursor.getLong(cursor.getColumnIndex("create_time"))));
        s.add(s1);
        if (true) goto _L3; else goto _L6
_L6:
        if (cursor.getCount() == 0)
        {
            sqlitedatabase.close();
            return null;
        }
        sqlitedatabase.close();
        return s;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public String querydownloading(String s)
    {
        SQLiteDatabase sqlitedatabase;
        ArrayList arraylist;
        sqlitedatabase = finalDBChen.getDatabase();
        s = sqlitedatabase.query("downloadtask", null, (new StringBuilder("file_id='")).append(s).append("'").toString(), null, null, null, null);
        arraylist = new ArrayList();
        if (s == null) goto _L2; else goto _L1
_L1:
        if (s.moveToNext()) goto _L3; else goto _L2
_L2:
        if (s == null)
        {
            return null;
        }
        break; /* Loop/switch isn't completed */
_L3:
        DownloadMovieItem downloadmovieitem = new DownloadMovieItem();
        downloadmovieitem.setFile_id(s.getString(s.getColumnIndex("file_id")));
        arraylist.add(downloadmovieitem);
        if (true) goto _L1; else goto _L4
_L4:
        if (s.getCount() == 0)
        {
            sqlitedatabase.close();
            return null;
        } else
        {
            sqlitedatabase.close();
            return ((DownloadMovieItem)arraylist.get(0)).getFile_id();
        }
    }

    public String queryfile(String s)
    {
        ArrayList arraylist;
        s = db.getWritableDatabase().query("file_list", null, (new StringBuilder("id='")).append(s).append("'").toString(), null, null, null, null);
        arraylist = new ArrayList();
        if (s == null) goto _L2; else goto _L1
_L1:
        if (s.moveToNext()) goto _L3; else goto _L2
_L2:
        if (s == null)
        {
            return null;
        }
        break; /* Loop/switch isn't completed */
_L3:
        DownloadMovieItem downloadmovieitem = new DownloadMovieItem();
        downloadmovieitem.setFile_id(s.getString(s.getColumnIndex("id")));
        arraylist.add(downloadmovieitem);
        if (true) goto _L1; else goto _L4
_L4:
        if (s.getCount() == 0)
        {
            db.close();
            return null;
        } else
        {
            return ((DownloadMovieItem)arraylist.get(0)).getFile_id();
        }
    }

    public List queryfile2()
    {
        Cursor cursor;
        ArrayList arraylist;
        cursor = db.getWritableDatabase().query("file_list", null, null, null, null, null, null);
        arraylist = new ArrayList();
        if (cursor == null) goto _L2; else goto _L1
_L1:
        if (cursor.moveToNext()) goto _L3; else goto _L2
_L2:
        if (cursor == null)
        {
            return null;
        }
        break; /* Loop/switch isn't completed */
_L3:
        DownloadMovieItem downloadmovieitem = new DownloadMovieItem();
        downloadmovieitem.setFile_id(cursor.getString(cursor.getColumnIndex("id")));
        downloadmovieitem.setTitle(cursor.getString(cursor.getColumnIndex("title")));
        downloadmovieitem.setSerial(cursor.getInt(cursor.getColumnIndex("serial")));
        downloadmovieitem.setType(cursor.getString(cursor.getColumnIndex("typ")));
        downloadmovieitem.setIcon(cursor.getString(cursor.getColumnIndex("icon")));
        try
        {
            Log.v("vfvf", (new StringBuilder("/////")).append(downloadmovieitem.getFile_id()).append("//////").append(downloadmovieitem.getTitle()).append("////////").append(downloadmovieitem.getSerial()).toString());
            packageInfo = mContext.getPackageManager().getPackageInfo(downloadmovieitem.getFile_id(), 0);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            packageInfo = null;
            namenotfoundexception.printStackTrace();
        }
        if (packageInfo == null && downloadmovieitem.getType().equals("app"))
        {
            Notification notification = new Notification();
            notification.flags = 16;
            notification.icon = 0x7f020115;
            Object obj = new Intent(mContext, com/allinone/free/activity/AppDownloadedActivity);
            ((Intent) (obj)).setFlags(0x10000000);
            Bundle bundle = new Bundle();
            bundle.putString("saomiao", "ok");
            ((Intent) (obj)).putExtras(bundle);
            notification.contentIntent = PendingIntent.getActivity(mContext, downloadmovieitem.getSerial(), ((Intent) (obj)), 0x8000000);
            obj = new RemoteViews(mContext.getPackageName(), 0x7f03007b);
            ((RemoteViews) (obj)).setTextViewText(0x7f0601fb, downloadmovieitem.getTitle());
            ((RemoteViews) (obj)).setTextViewText(0x7f0601fc, DateFormat.format("kk:mm", System.currentTimeMillis()));
            ((RemoteViews) (obj)).setImageViewBitmap(0x7f060193, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(downloadmovieitem.getIcon())).toString()));
            notification.contentView = ((RemoteViews) (obj));
            mNotificationManager.notify(downloadmovieitem.getSerial(), notification);
        }
        arraylist.add(downloadmovieitem);
        if (true) goto _L1; else goto _L4
_L4:
        if (cursor.getCount() == 0)
        {
            db.close();
            return null;
        } else
        {
            return null;
        }
    }
}
