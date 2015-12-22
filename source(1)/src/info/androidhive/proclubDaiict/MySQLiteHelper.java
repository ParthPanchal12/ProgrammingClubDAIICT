// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package info.androidhive.proclubDaiict;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import info.androidhive.proclubDaiict.service.Blog;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class MySQLiteHelper extends SQLiteOpenHelper
{

    private static final String COMMENT = "COMMENT";
    private static final String CONTENT = "CONTENT";
    private static final String CREATE_TABLE_ANNOUNCEMETS = "CREATE TABLE announcement(ID INTEGER PRIMARY KEY,USERNAME TEXT,TITLE TEXT,COMMENT TEXT,CONTENT TEXT, TAG TEXT)";
    private static final String CREATE_TABLE_BLOG = "CREATE TABLE blog(ID INTEGER PRIMARY KEY,USERNAME TEXT,TITLE TEXT,COMMENT TEXT,CONTENT TEXT, TAG TEXT)";
    private static final String CREATE_TABLE_CONTEST = "CREATE TABLE todo_tags(TITLE TEXT,DESCRIPTION TEXT,LINK TEXT,START TEXT,END TEXT)";
    private static final String DATABASE_NAME = "ProgrammingClubDAIICT";
    private static final int DATABASE_VERSION = 1;
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final String END = "END";
    private static final String ID = "ID";
    private static final String KEY_CREATED_AT = "created_at";
    private static final String KEY_STATUS = "status";
    private static final String KEY_TAG_ID = "tag_id";
    private static final String KEY_TAG_NAME = "tag_name";
    private static final String KEY_TODO = "todo";
    private static final String KEY_TODO_ID = "todo_id";
    private static final String LINK = "LINK";
    private static final String LOG = "DatabaseHelper";
    private static final String START = "START";
    private static final String TABLE_ANNOUNCEMENT = "announcement";
    private static final String TABLE_BLOG = "blog";
    private static final String TABLE_CONTEST = "todo_tags";
    private static final String TAG = "TAG";
    private static final String TITLE = "TITLE";
    private static final String USERNAME = "USERNAME";

    public MySQLiteHelper(Context context)
    {
        super(context, "ProgrammingClubDAIICT", null, 1);
    }

    public void createAnnouncement(Blog blog)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("ID", Integer.valueOf(blog.getId()));
        contentvalues.put("USERNAME", blog.getUsrername());
        contentvalues.put("TITLE", blog.getTitle());
        contentvalues.put("COMMENT", blog.getComment());
        contentvalues.put("CONTENT", blog.getContent());
        contentvalues.put("TAG", blog.getTag());
        sqlitedatabase.insert("announcement", null, contentvalues);
    }

    public void createBlog(Blog blog)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("ID", Integer.valueOf(blog.getId()));
        contentvalues.put("USERNAME", blog.getUsrername());
        contentvalues.put("TITLE", blog.getTitle());
        contentvalues.put("COMMENT", blog.getComment());
        contentvalues.put("CONTENT", blog.getContent());
        contentvalues.put("TAG", blog.getTag());
        sqlitedatabase.insert("blog", null, contentvalues);
    }

    public void createEvent()
    {
    }

    public List getAllAnnouncMent()
    {
        ArrayList arraylist = new ArrayList();
        Log.e("DatabaseHelper", "SELECT  * FROM announcement");
        Cursor cursor = getReadableDatabase().rawQuery("SELECT  * FROM announcement", null);
        if (cursor.moveToFirst())
        {
            do
            {
                Blog blog = new Blog();
                blog.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                blog.setComment(cursor.getString(cursor.getColumnIndex("COMMENT")));
                blog.setContent(cursor.getString(cursor.getColumnIndex("CONTENT")));
                blog.setUsrername(cursor.getString(cursor.getColumnIndex("USERNAME")));
                blog.setTitle(cursor.getString(cursor.getColumnIndex("TITLE")));
                blog.setTag(cursor.getString(cursor.getColumnIndex("TAG")));
                arraylist.add(blog);
            } while (cursor.moveToNext());
        }
        return arraylist;
    }

    public List getAllBlog()
    {
        ArrayList arraylist = new ArrayList();
        Log.e("DatabaseHelper", "SELECT  * FROM blog");
        Cursor cursor = getReadableDatabase().rawQuery("SELECT  * FROM blog", null);
        if (cursor.moveToFirst())
        {
            do
            {
                Blog blog = new Blog();
                blog.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                blog.setComment(cursor.getString(cursor.getColumnIndex("COMMENT")));
                blog.setContent(cursor.getString(cursor.getColumnIndex("CONTENT")));
                blog.setUsrername(cursor.getString(cursor.getColumnIndex("USERNAME")));
                blog.setTitle(cursor.getString(cursor.getColumnIndex("TITLE")));
                blog.setTag(cursor.getString(cursor.getColumnIndex("TAG")));
                arraylist.add(blog);
            } while (cursor.moveToNext());
        }
        return arraylist;
    }

    public Blog getBlog(String s)
    {
        Blog blog;
        Cursor cursor;
        blog = new Blog();
        Log.e("DatabaseHelper", "SELECT  * FROM blog");
        cursor = getReadableDatabase().rawQuery("SELECT  * FROM blog", null);
        if (!cursor.moveToFirst()) goto _L2; else goto _L1
_L1:
        if (!cursor.getString(cursor.getColumnIndex("TITLE")).equals(s))
        {
            continue; /* Loop/switch isn't completed */
        }
        blog.setId(cursor.getInt(cursor.getColumnIndex("ID")));
        blog.setComment(cursor.getString(cursor.getColumnIndex("COMMENT")));
        blog.setContent(cursor.getString(cursor.getColumnIndex("CONTENT")));
        blog.setUsrername(cursor.getString(cursor.getColumnIndex("USERNAME")));
        blog.setTitle(cursor.getString(cursor.getColumnIndex("TITLE")));
        blog.setTag(cursor.getString(cursor.getColumnIndex("TAG")));
_L2:
        return blog;
        if (cursor.moveToNext()) goto _L1; else goto _L3
_L3:
        return blog;
    }

    public List getBlogCategory(String s)
    {
        ArrayList arraylist = new ArrayList();
        Log.e("DatabaseHelper", "SELECT  * FROM blog");
        Cursor cursor = getReadableDatabase().rawQuery("SELECT  * FROM blog", null);
        if (cursor.moveToFirst())
        {
            do
            {
                if (cursor.getString(cursor.getColumnIndex("TAG")).equals(s))
                {
                    arraylist.add(cursor.getString(cursor.getColumnIndex("TITLE")));
                }
            } while (cursor.moveToNext());
        }
        return arraylist;
    }

    public List getCategories()
    {
        ArrayList arraylist = new ArrayList();
        System.out.print("skjsk");
        Log.e("DatabaseHelper", "SELECT  * FROM blog");
        Cursor cursor = getReadableDatabase().rawQuery("SELECT  * FROM blog", null);
        if (cursor.moveToFirst())
        {
            do
            {
                if (!arraylist.contains(cursor.getString(cursor.getColumnIndex("TAG"))) && cursor.getString(cursor.getColumnIndex("TAG")) != null)
                {
                    arraylist.add(cursor.getString(cursor.getColumnIndex("TAG")));
                    System.out.println((new StringBuilder()).append(arraylist.size()).append(" ").append(cursor.getString(cursor.getColumnIndex("TAG"))).toString());
                }
            } while (cursor.moveToNext());
        }
        return arraylist;
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE blog(ID INTEGER PRIMARY KEY,USERNAME TEXT,TITLE TEXT,COMMENT TEXT,CONTENT TEXT, TAG TEXT)");
        sqlitedatabase.execSQL("CREATE TABLE announcement(ID INTEGER PRIMARY KEY,USERNAME TEXT,TITLE TEXT,COMMENT TEXT,CONTENT TEXT, TAG TEXT)");
        sqlitedatabase.execSQL("CREATE TABLE todo_tags(TITLE TEXT,DESCRIPTION TEXT,LINK TEXT,START TEXT,END TEXT)");
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS blog");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS announcement");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS todo_tags");
        onCreate(sqlitedatabase);
    }
}
