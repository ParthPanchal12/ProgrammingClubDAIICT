// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;


public final class g
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        private static final a g[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/google/ads/g$a, s);
        }

        public static a[] values()
        {
            return (a[])g.clone();
        }

        static 
        {
            a = new a("AD", 0);
            b = new a("NO_FILL", 1);
            c = new a("ERROR", 2);
            d = new a("TIMEOUT", 3);
            e = new a("NOT_FOUND", 4);
            f = new a("EXCEPTION", 5);
            g = (new a[] {
                a, b, c, d, e, f
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    public static Object a(String s, Class class1)
        throws ClassNotFoundException, ClassCastException, IllegalAccessException, InstantiationException, LinkageError, ExceptionInInitializerError
    {
        return class1.cast(Class.forName(s).newInstance());
    }

    public static String a(String s, String s1, Boolean boolean1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9)
    {
        s1 = s.replaceAll("@gw_adlocid@", s1).replaceAll("@gw_qdata@", s5).replaceAll("@gw_sdkver@", "afma-sdk-a-v6.4.1").replaceAll("@gw_sessid@", s6).replaceAll("@gw_seqnum@", s7).replaceAll("@gw_devid@", s2);
        s = s1;
        if (s4 != null)
        {
            s = s1.replaceAll("@gw_adnetid@", s4);
        }
        s1 = s;
        if (s3 != null)
        {
            s1 = s.replaceAll("@gw_allocid@", s3);
        }
        s = s1;
        if (s8 != null)
        {
            s = s1.replaceAll("@gw_adt@", s8);
        }
        s1 = s;
        if (s9 != null)
        {
            s1 = s.replaceAll("@gw_aec@", s9);
        }
        if (boolean1 != null)
        {
            if (boolean1.booleanValue())
            {
                s = "1";
            } else
            {
                s = "0";
            }
            return s1.replaceAll("@gw_adnetrefresh@", s);
        } else
        {
            return s1;
        }
    }
}
