// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.google.ads.internal.a;
import com.google.ads.util.b;
import com.google.ads.util.f;
import java.lang.ref.WeakReference;
import java.util.Date;

// Referenced classes of package com.google.ads:
//            as

public final class at
{
    private static class a
        implements Runnable
    {

        private final WeakReference a;
        private final android.content.SharedPreferences.Editor b;

        private android.content.SharedPreferences.Editor a(Context context)
        {
            if (b == null)
            {
                return PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext()).edit();
            } else
            {
                return b;
            }
        }

        public void run()
        {
            Object obj1 = (Activity)a.get();
            Object obj;
            if (obj1 == null)
            {
                try
                {
                    com.google.ads.util.b.a("Activity was null while making a doritos cookie request.");
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    com.google.ads.util.b.d("An unknown error occurred while sending a doritos request.", ((Throwable) (obj)));
                }
                return;
            }
            obj = ((Activity) (obj1)).getContentResolver().query(com.google.ads.as.a, com.google.ads.as.b, null, null, null);
            if (obj == null) goto _L2; else goto _L1
_L1:
            if (!((Cursor) (obj)).moveToFirst() || ((Cursor) (obj)).getColumnNames().length <= 0) goto _L2; else goto _L3
_L3:
            obj = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex(((Cursor) (obj)).getColumnName(0)));
_L4:
            obj1 = a(((Context) (obj1)));
            if (TextUtils.isEmpty(((CharSequence) (obj))))
            {
                break MISSING_BLOCK_LABEL_149;
            }
            ((android.content.SharedPreferences.Editor) (obj1)).putString("drt", ((String) (obj)));
            ((android.content.SharedPreferences.Editor) (obj1)).putLong("drt_ts", (new Date()).getTime());
_L5:
            ((android.content.SharedPreferences.Editor) (obj1)).commit();
            return;
_L2:
            com.google.ads.util.b.a("Google+ app not installed, not storing doritos cookie");
            obj = null;
              goto _L4
            ((android.content.SharedPreferences.Editor) (obj1)).putString("drt", "");
            ((android.content.SharedPreferences.Editor) (obj1)).putLong("drt_ts", 0L);
              goto _L5
        }

        public a(Activity activity)
        {
            this(activity, null);
        }

        a(Activity activity, android.content.SharedPreferences.Editor editor)
        {
            a = new WeakReference(activity);
            b = editor;
        }
    }


    private static final com.google.ads.internal.a a;

    public static void a(Activity activity)
    {
        (new Thread(new a(activity))).start();
    }

    public static boolean a(Context context, long l)
    {
        if (!a(context, l, PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext())))
        {
            return false;
        } else
        {
            (new Thread(new Runnable(context) {

                final Context a;

                public void run()
                {
                    android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(a.getApplicationContext()).edit();
                    editor.putString("drt", "");
                    editor.putLong("drt_ts", 0L);
                    editor.commit();
                }

            
            {
                a = context;
                super();
            }
            })).start();
            return true;
        }
    }

    static boolean a(Context context, long l, SharedPreferences sharedpreferences)
    {
        return !sharedpreferences.contains("drt") || !sharedpreferences.contains("drt_ts") || sharedpreferences.getLong("drt_ts", 0L) < (new Date()).getTime() - l;
    }

    static 
    {
        a = (com.google.ads.internal.a)com.google.ads.internal.a.a.b();
    }
}
