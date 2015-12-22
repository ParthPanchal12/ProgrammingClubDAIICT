// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package com.umeng.message.proguard:
//            ah, aj, ak

private static final class g
    implements ah
{
    public final class a
        implements ah.a
    {

        final aj.a a;
        private final Map b = new HashMap();
        private boolean c;

        public ah.a a()
        {
            this;
            JVM INSTR monitorenter ;
            c = true;
            this;
            JVM INSTR monitorexit ;
            return this;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public ah.a a(String s)
        {
            this;
            JVM INSTR monitorenter ;
            b.put(s, this);
            this;
            JVM INSTR monitorexit ;
            return this;
            s;
            this;
            JVM INSTR monitorexit ;
            throw s;
        }

        public ah.a a(String s, float f1)
        {
            this;
            JVM INSTR monitorenter ;
            b.put(s, Float.valueOf(f1));
            this;
            JVM INSTR monitorexit ;
            return this;
            s;
            this;
            JVM INSTR monitorexit ;
            throw s;
        }

        public ah.a a(String s, int i)
        {
            this;
            JVM INSTR monitorenter ;
            b.put(s, Integer.valueOf(i));
            this;
            JVM INSTR monitorexit ;
            return this;
            s;
            this;
            JVM INSTR monitorexit ;
            throw s;
        }

        public ah.a a(String s, long l)
        {
            this;
            JVM INSTR monitorenter ;
            b.put(s, Long.valueOf(l));
            this;
            JVM INSTR monitorexit ;
            return this;
            s;
            this;
            JVM INSTR monitorexit ;
            throw s;
        }

        public ah.a a(String s, String s1)
        {
            this;
            JVM INSTR monitorenter ;
            b.put(s, s1);
            this;
            JVM INSTR monitorexit ;
            return this;
            s;
            this;
            JVM INSTR monitorexit ;
            throw s;
        }

        public ah.a a(String s, boolean flag)
        {
            this;
            JVM INSTR monitorenter ;
            b.put(s, Boolean.valueOf(flag));
            this;
            JVM INSTR monitorexit ;
            return this;
            s;
            this;
            JVM INSTR monitorexit ;
            throw s;
        }

        public boolean b()
        {
            boolean flag = false;
            Object obj1 = aj.a();
            obj1;
            JVM INSTR monitorenter ;
            if (aj.a.a(a).size() > 0)
            {
                flag = true;
            }
            if (!flag) goto _L2; else goto _L1
_L1:
            ArrayList arraylist = new ArrayList();
            Object obj = new HashSet(aj.a.a(a).keySet());
_L6:
            this;
            JVM INSTR monitorenter ;
            Iterator iterator;
            if (c)
            {
                aj.a.b(a).clear();
                c = false;
            }
            iterator = b.entrySet().iterator();
_L4:
            String s1;
            Object obj2;
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_209;
            }
            obj2 = (java.util.Map.Entry)iterator.next();
            s1 = (String)((java.util.Map.Entry) (obj2)).getKey();
            obj2 = ((java.util.Map.Entry) (obj2)).getValue();
            if (obj2 != this)
            {
                break MISSING_BLOCK_LABEL_189;
            }
            aj.a.b(a).remove(s1);
_L5:
            if (!flag) goto _L4; else goto _L3
_L3:
            arraylist.add(s1);
              goto _L4
            obj;
            this;
            JVM INSTR monitorexit ;
            throw obj;
            obj;
            obj1;
            JVM INSTR monitorexit ;
            throw obj;
            aj.a.b(a).put(s1, obj2);
              goto _L5
            b.clear();
            this;
            JVM INSTR monitorexit ;
            boolean flag1 = aj.a.c(a);
            if (!flag1)
            {
                break MISSING_BLOCK_LABEL_242;
            }
            a.a(true);
            obj1;
            JVM INSTR monitorexit ;
            if (flag)
            {
label0:
                for (int i = arraylist.size() - 1; i >= 0; i--)
                {
                    String s = (String)arraylist.get(i);
                    Iterator iterator1 = ((Set) (obj)).iterator();
                    do
                    {
                        if (!iterator1.hasNext())
                        {
                            continue label0;
                        }
                        ah.b b1 = (ah.b)iterator1.next();
                        if (b1 != null)
                        {
                            b1.a(a, s);
                        }
                    } while (true);
                }

            }
            return flag1;
_L2:
            obj = null;
            arraylist = null;
              goto _L6
        }

        public a()
        {
            a = aj.a.this;
            super();
            c = false;
        }
    }


    private static final Object f = new Object();
    private final File a;
    private final File b;
    private final int c;
    private Map d;
    private boolean e;
    private WeakHashMap g;

    private FileOutputStream a(File file)
    {
        FileOutputStream fileoutputstream;
        try
        {
            fileoutputstream = new FileOutputStream(file);
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            if (!file.getParentFile().mkdir())
            {
                return null;
            }
            try
            {
                file = new FileOutputStream(file);
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                return null;
            }
            return file;
        }
        return fileoutputstream;
    }

    static WeakHashMap a(a.a a1)
    {
        return a1.g;
    }

    static Map b(g g1)
    {
        return g1.d;
    }

    static boolean c(d d1)
    {
        return d1.e();
    }

    private boolean e()
    {
        if (!a.exists()) goto _L2; else goto _L1
_L1:
        if (b.exists()) goto _L4; else goto _L3
_L3:
        if (a.renameTo(b)) goto _L2; else goto _L5
_L5:
        return false;
_L4:
        FileOutputStream fileoutputstream;
        a.delete();
_L2:
        if ((fileoutputstream = a(a)) == null) goto _L5; else goto _L6
_L6:
        ak.a(d, fileoutputstream);
        fileoutputstream.close();
        b.delete();
        return true;
        Object obj;
        obj;
_L7:
        if (a.exists() && !a.delete())
        {
            return false;
        }
          goto _L5
        obj;
          goto _L7
    }

    public float a(String s, float f1)
    {
        this;
        JVM INSTR monitorenter ;
        s = (Float)d.get(s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        f1 = s.floatValue();
        this;
        JVM INSTR monitorexit ;
        return f1;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public int a(String s, int i)
    {
        this;
        JVM INSTR monitorenter ;
        s = (Integer)d.get(s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        i = s.intValue();
        this;
        JVM INSTR monitorexit ;
        return i;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public long a(String s, long l)
    {
        this;
        JVM INSTR monitorenter ;
        s = (Long)d.get(s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        l = s.longValue();
        this;
        JVM INSTR monitorexit ;
        return l;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public String a(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        s = (String)d.get(s);
        if (s == null)
        {
            s = s1;
        }
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void a(d d1)
    {
        this;
        JVM INSTR monitorenter ;
        g.put(d1, f);
        this;
        JVM INSTR monitorexit ;
        return;
        d1;
        this;
        JVM INSTR monitorexit ;
        throw d1;
    }

    public void a(Map map)
    {
        if (map == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        this;
        JVM INSTR monitorenter ;
        d = map;
        this;
        JVM INSTR monitorexit ;
        return;
        map;
        this;
        JVM INSTR monitorexit ;
        throw map;
    }

    public void a(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        e = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean a()
    {
        return a != null && (new File(a.getAbsolutePath())).exists();
    }

    public boolean a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = d.containsKey(s);
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public boolean a(String s, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        s = (Boolean)d.get(s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        flag = s.booleanValue();
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public Map b()
    {
        this;
        JVM INSTR monitorenter ;
        HashMap hashmap = new HashMap(d);
        this;
        JVM INSTR monitorexit ;
        return hashmap;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void b(d d1)
    {
        this;
        JVM INSTR monitorenter ;
        g.remove(d1);
        this;
        JVM INSTR monitorexit ;
        return;
        d1;
        this;
        JVM INSTR monitorexit ;
        throw d1;
    }

    public g c()
    {
        return new a();
    }

    public boolean d()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = e;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }


    a.c(File file, int i, Map map)
    {
        e = false;
        a = file;
        b = aj.a(file);
        c = i;
        if (map == null)
        {
            map = new HashMap();
        }
        d = map;
        g = new WeakHashMap();
    }
}
