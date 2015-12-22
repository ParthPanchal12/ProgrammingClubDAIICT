// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update.net;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Environment;
import android.view.animation.Animation;
import android.widget.ImageView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Stack;
import java.util.WeakHashMap;
import u.upd.a;
import u.upd.b;
import u.upd.n;

public class j
{
    public static interface a
    {

        public abstract void a(b b1);

        public abstract void a(u.upd.f.a a1);
    }

    public static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        private static final b c[];

        public static b valueOf(String s)
        {
            return (b)Enum.valueOf(com/umeng/update/net/j$b, s);
        }

        public static b[] values()
        {
            b ab[] = c;
            int i = ab.length;
            b ab1[] = new b[i];
            System.arraycopy(ab, 0, ab1, 0, i);
            return ab1;
        }

        static 
        {
            a = new b("BIND_FORM_CACHE", 0);
            b = new b("BIND_FROM_NET", 1);
            c = (new b[] {
                a, b
            });
        }

        private b(String s, int i)
        {
            super(s, i);
        }
    }

    static class c extends AsyncTask
    {

        private Context a;
        private String b;
        private ImageView c;
        private b d;
        private boolean e;
        private a f;
        private Animation g;
        private boolean h;
        private File i;

        protected transient Drawable a(Object aobj[])
        {
            if (com.umeng.update.net.j.a)
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
                aobj = com.umeng.update.net.j.a(i.getAbsolutePath());
                if (aobj == null)
                {
                    i.delete();
                }
                u.upd.b.c(com.umeng.update.net.j.a(), "get drawable from cacheFile.");
                return ((Drawable) (aobj));
            }
            try
            {
                com.umeng.update.net.j.a(a, b);
                aobj = com.umeng.update.net.j.b(a, b);
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                u.upd.b.e(com.umeng.update.net.j.a(), ((Exception) (aobj)).toString(), ((Exception) (aobj)));
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
            aobj = com.umeng.update.net.j.a(((File) (aobj)).getAbsolutePath());
_L1:
            u.upd.b.c(com.umeng.update.net.j.a(), "get drawable from net else file.");
            return ((Drawable) (aobj));
            aobj = null;
              goto _L1
        }

        protected void a(Drawable drawable)
        {
            com.umeng.update.net.j.a(a, c, drawable, e, f, g, h, b);
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

        public c(Context context, ImageView imageview, String s, b b1, File file, boolean flag, a a1, 
                Animation animation, boolean flag1)
        {
            i = file;
            a = context;
            b = s;
            f = a1;
            d = b1;
            e = flag;
            g = animation;
            c = imageview;
            h = flag1;
        }
    }


    public static boolean a = false;
    private static final String b = com/umeng/update/net/j.getName();
    private static final long c = 0x3200000L;
    private static final long d = 0xa00000L;
    private static final long e = 0x1b7740L;
    private static final Map f = Collections.synchronizedMap(new WeakHashMap());
    private static Thread g;

    public j()
    {
    }

    private static long a(File file)
    {
        if (file != null && file.exists() && file.isDirectory()) goto _L2; else goto _L1
_L1:
        long l1 = 0L;
_L4:
        return l1;
_L2:
        Stack stack = new Stack();
        stack.clear();
        stack.push(file);
        long l = 0L;
        do
        {
            l1 = l;
            if (stack.isEmpty())
            {
                continue;
            }
            file = ((File)stack.pop()).listFiles();
            int k = file.length;
            int i = 0;
            while (i < k) 
            {
                File file1 = file[i];
                long l2 = l;
                if (!file1.isDirectory())
                {
                    l2 = l + file1.length();
                }
                i++;
                l = l2;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static Bitmap a(Bitmap bitmap)
    {
        Bitmap bitmap1;
        try
        {
            bitmap1 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap1);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            RectF rectf = new RectF(rect);
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(0xff424242);
            canvas.drawRoundRect(rectf, bitmap.getWidth() / 6, bitmap.getHeight() / 6, paint);
            paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect, paint);
            bitmap.recycle();
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            u.upd.b.e(b, "Cant`t create round corner bitmap. [OutOfMemoryError] ");
            return null;
        }
        return bitmap1;
    }

    static Drawable a(String s)
    {
        return c(s);
    }

    public static File a(String s, Context context, boolean aflag[])
        throws IOException
    {
        if (u.upd.a.b())
        {
            s = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getCanonicalPath()))).append("/download/.um").append(s).toString());
            s.mkdirs();
            if (s.exists())
            {
                aflag[0] = true;
                return s;
            }
        }
        s = context.getCacheDir().getAbsolutePath();
        (new File(s)).mkdir();
        a(s, 505, -1, -1);
        s = (new StringBuilder(String.valueOf(s))).append("/umdownload").toString();
        (new File(s)).mkdir();
        a(s, 505, -1, -1);
        s = new File(s);
        aflag[0] = false;
        return s;
    }

    static String a()
    {
        return b;
    }

    public static String a(Context context, String s)
    {
        if (n.d(s))
        {
            return null;
        }
        Object obj = (new StringBuilder(String.valueOf(b(s)))).append(".tmp").toString();
        if (!u.upd.a.b()) goto _L2; else goto _L1
_L1:
        context = Environment.getExternalStorageDirectory().getCanonicalPath();
        long l = 0x3200000L;
_L9:
        context = new File((new StringBuilder(String.valueOf(context))).append("/download/.um").toString());
        a(((File) (context)), l, 0x1b7740L);
        obj = new File(context, ((String) (obj)));
        InputStream inputstream;
        byte abyte0[];
        ((File) (obj)).createNewFile();
        context = new FileOutputStream(((File) (obj)));
        inputstream = (InputStream)(new URL(s)).openConnection().getContent();
        abyte0 = new byte[4096];
_L5:
        int i = inputstream.read(abyte0);
        if (i != -1) goto _L4; else goto _L3
_L3:
        context.flush();
        inputstream.close();
        context.close();
        context = new File(((File) (obj)).getParent(), ((File) (obj)).getName().replace(".tmp", ""));
        ((File) (obj)).renameTo(context);
        u.upd.b.a(b, (new StringBuilder("download img[")).append(s).append("]  to ").append(context.getCanonicalPath()).toString());
        context = context.getCanonicalPath();
        return context;
_L2:
        context = context.getCacheDir().getCanonicalPath();
        l = 0xa00000L;
        continue; /* Loop/switch isn't completed */
_L4:
        context.write(abyte0, 0, i);
          goto _L5
        context;
_L7:
        u.upd.b.a(b, (new StringBuilder(String.valueOf(context.getStackTrace().toString()))).append("\t url:\t").append(n.a).append(s).toString());
        if (obj != null && ((File) (obj)).exists())
        {
            ((File) (obj)).deleteOnExit();
        }
        return null;
        context;
        obj = null;
        if (true) goto _L7; else goto _L6
_L6:
        if (true) goto _L9; else goto _L8
_L8:
    }

    static void a(Context context, ImageView imageview, Drawable drawable, boolean flag, a a1, Animation animation, boolean flag1, String s)
    {
        b(context, imageview, drawable, flag, a1, animation, flag1, s);
    }

    public static void a(Context context, ImageView imageview, String s, boolean flag)
    {
        a(context, imageview, s, flag, null, null, false);
    }

    public static void a(Context context, ImageView imageview, String s, boolean flag, a a1)
    {
        a(context, imageview, s, flag, a1, null, false);
    }

    public static void a(Context context, ImageView imageview, String s, boolean flag, a a1, Animation animation)
    {
        a(context, imageview, s, flag, a1, null, false);
    }

    public static void a(Context context, ImageView imageview, String s, boolean flag, a a1, Animation animation, boolean flag1)
    {
        if (imageview != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        f.put(imageview, s);
        File file = b(context, s);
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        if (!file.exists() || a)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        if (a1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        a1.a(com.umeng.update.net.b.a);
        Drawable drawable = c(file.getAbsolutePath());
        if (drawable != null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        file.delete();
        b(context, imageview, drawable, flag, a1, animation, flag1, s);
        return;
        context;
        u.upd.b.b(b, "", context);
        if (a1 == null) goto _L1; else goto _L3
_L3:
        a1.a(u.upd.f.a.b);
        return;
        (new c(context, imageview, s, com.umeng.update.net.b.b, null, flag, a1, animation, flag1)).execute(new Object[0]);
        return;
    }

    static void a(File file, long l)
    {
        b(file, l);
    }

    public static void a(File file, long l, long l1)
        throws IOException
    {
        if (file.exists())
        {
            if (a(file.getCanonicalFile()) > l)
            {
                if (g == null)
                {
                    g = new Thread(new Runnable(file, l1) {

                        private final File a;
                        private final long b;

                        public void run()
                        {
                            com.umeng.update.net.j.a(a, b);
                            com.umeng.update.net.j.a(null);
                        }

            
            {
                a = file;
                b = l;
                super();
            }
                    });
                }
                synchronized (g)
                {
                    g.start();
                }
                return;
            }
        } else
        if (!file.mkdirs())
        {
            u.upd.b.b(b, (new StringBuilder("Failed to create directory")).append(file.getAbsolutePath()).append(". Check permission. Make sure WRITE_EXTERNAL_STORAGE is added in your Manifest.xml").toString());
        }
        break MISSING_BLOCK_LABEL_105;
        exception;
        file;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static void a(Thread thread)
    {
        g = thread;
    }

    private static boolean a(ImageView imageview, String s)
    {
        imageview = (String)f.get(imageview);
        return imageview != null && !imageview.equals(s);
    }

    public static boolean a(String s, int i)
    {
        char c1 = '\u01B0';
        if ((i & 1) != 0)
        {
            c1 = '\u01B4';
        }
        int k = c1;
        if ((i & 2) != 0)
        {
            k = c1 | 2;
        }
        return a(s, k, -1, -1);
    }

    public static boolean a(String s, int i, int k, int l)
    {
        Class.forName("android.os.FileUtils").getMethod("setPermissions", new Class[] {
            java/lang/String, Integer.TYPE, Integer.TYPE, Integer.TYPE
        }).invoke(null, new Object[] {
            s, Integer.valueOf(i), Integer.valueOf(-1), Integer.valueOf(-1)
        });
        return true;
        s;
        u.upd.b.b(b, "error when set permissions:", s);
_L2:
        return false;
        s;
        u.upd.b.b(b, "error when set permissions:", s);
        continue; /* Loop/switch isn't completed */
        s;
        u.upd.b.b(b, "error when set permissions:", s);
        continue; /* Loop/switch isn't completed */
        s;
        u.upd.b.b(b, "error when set permissions:", s);
        continue; /* Loop/switch isn't completed */
        s;
        u.upd.b.b(b, "error when set permissions:", s);
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected static File b(Context context, String s)
        throws IOException
    {
        s = b(s);
        if (u.upd.a.b())
        {
            context = Environment.getExternalStorageDirectory().getCanonicalPath();
        } else
        {
            context = context.getCacheDir().getCanonicalPath();
        }
        context = new File(new File((new StringBuilder(String.valueOf(context))).append("/download/.um").toString()), s);
        if (context.exists())
        {
            return context;
        } else
        {
            return null;
        }
    }

    private static String b(String s)
    {
        int i = s.lastIndexOf(".");
        String s1 = "";
        if (i >= 0)
        {
            s1 = s.substring(i);
        }
        return (new StringBuilder(String.valueOf(n.a(s)))).append(s1).toString();
    }

    private static void b(Context context, ImageView imageview, Drawable drawable, boolean flag, a a1, Animation animation, boolean flag1, String s)
    {
        com/umeng/update/net/j;
        JVM INSTR monitorenter ;
        context = drawable;
        if (!flag1) goto _L2; else goto _L1
_L1:
        context = drawable;
        if (drawable == null) goto _L2; else goto _L3
_L3:
        context = new BitmapDrawable(a(((BitmapDrawable)drawable).getBitmap()));
          goto _L2
_L11:
        if (a1 == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        a1.a(u.upd.f.a.b);
        u.upd.b.e(b, (new StringBuilder("bind drawable failed. drawable [")).append(context).append("]  imageView[+").append(imageview).append("+]").toString());
_L5:
        com/umeng/update/net/j;
        JVM INSTR monitorexit ;
        return;
_L12:
        if (!a(imageview, s))
        {
            break MISSING_BLOCK_LABEL_157;
        }
        if (a1 == null) goto _L5; else goto _L4
_L4:
        a1.a(u.upd.f.a.b);
          goto _L5
        context;
        u.upd.b.b(b, "bind failed", context);
        if (a1 == null) goto _L5; else goto _L6
_L6:
        a1.a(u.upd.f.a.b);
          goto _L5
        context;
        throw context;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        imageview.setBackgroundDrawable(context);
_L10:
        if (animation == null) goto _L8; else goto _L7
_L7:
        imageview.startAnimation(animation);
_L8:
        if (a1 == null) goto _L5; else goto _L9
_L9:
        a1.a(u.upd.f.a.a);
          goto _L5
        imageview.setImageDrawable(context);
          goto _L10
_L2:
        if (context != null && imageview != null) goto _L12; else goto _L11
    }

    private static void b(File file, long l)
    {
        if (file != null && file.exists() && file.canWrite() && file.isDirectory())
        {
            file = file.listFiles();
            int k = file.length;
            int i = 0;
            while (i < k) 
            {
                File file1 = file[i];
                if (!file1.isDirectory() && (new Date()).getTime() - file1.lastModified() > l)
                {
                    file1.delete();
                }
                i++;
            }
        }
    }

    private static Drawable c(String s)
    {
        try
        {
            s = Drawable.createFromPath(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            u.upd.b.e(b, (new StringBuilder("Resutil fetchImage OutOfMemoryError:")).append(s.toString()).toString());
            return null;
        }
        return s;
    }

    static 
    {
        a = false;
    }
}
