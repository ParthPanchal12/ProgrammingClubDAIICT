// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update.net;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.animation.Animation;
import android.widget.ImageView;
import java.io.File;
import u.upd.b;

// Referenced classes of package com.umeng.update.net:
//            j

static class h extends AsyncTask
{

    private Context a;
    private String b;
    private ImageView c;
    private d d;
    private boolean e;
    private d f;
    private Animation g;
    private boolean h;
    private File i;

    protected transient Drawable a(Object aobj[])
    {
        if (j.a)
        {
            try
            {
                Thread.sleep(3000L);
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                ((InterruptedException) (aobj)).printStackTrace();
            }
        }
        if (i != null && i.exists())
        {
            aobj = j.a(i.getAbsolutePath());
            if (aobj == null)
            {
                i.delete();
            }
            u.upd.b.c(j.a(), "get drawable from cacheFile.");
            return ((Drawable) (aobj));
        }
        try
        {
            j.a(a, b);
            aobj = com.umeng.update.net.j.b(a, b);
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            u.upd.b.e(j.a(), ((Exception) (aobj)).toString(), ((Exception) (aobj)));
            return null;
        }
        if (aobj == null)
        {
            break MISSING_BLOCK_LABEL_137;
        }
        if (!((File) (aobj)).exists())
        {
            break MISSING_BLOCK_LABEL_137;
        }
        aobj = j.a(((File) (aobj)).getAbsolutePath());
_L1:
        u.upd.b.c(j.a(), "get drawable from net else file.");
        return ((Drawable) (aobj));
        aobj = null;
          goto _L1
    }

    protected void a(Drawable drawable)
    {
        j.a(a, c, drawable, e, f, g, h, b);
    }

    protected transient Object doInBackground(Object aobj[])
    {
        return a((Object[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Drawable)obj);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (f != null)
        {
            f.a(d);
        }
    }

    public imation(Context context, ImageView imageview, String s, imation imation, File file, boolean flag, imation imation1, 
            Animation animation, boolean flag1)
    {
        i = file;
        a = context;
        b = s;
        f = imation1;
        d = imation;
        e = flag;
        g = animation;
        c = imageview;
        h = flag1;
    }
}
