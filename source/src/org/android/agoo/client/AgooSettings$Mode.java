// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.client;


// Referenced classes of package org.android.agoo.client:
//            AgooSettings

public static abstract class <init> extends Enum
{

    public static final RELEASE PREVIEW;
    public static final RELEASE RELEASE;
    public static final RELEASE TEST;
    private static final RELEASE b[];
    private int a;

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(org/android/agoo/client/AgooSettings$Mode, s);
    }

    public static <init>[] values()
    {
        return (<init>[])b.clone();
    }

    public abstract String getPushApollIp();

    public abstract int getPushApollPort();

    public int getValue()
    {
        return a;
    }

    static 
    {
        TEST = new AgooSettings.Mode("TEST", 0, -1) {

            public String getPushApollIp()
            {
                return "110.75.120.15";
            }

            public int getPushApollPort()
            {
                return 80;
            }

        };
        PREVIEW = new AgooSettings.Mode("PREVIEW", 1, 0) {

            public String getPushApollIp()
            {
                return "110.75.40.7";
            }

            public int getPushApollPort()
            {
                return 6080;
            }

        };
        RELEASE = new AgooSettings.Mode("RELEASE", 2, 1) {

            public String getPushApollIp()
            {
                return "42.120.111.1";
            }

            public int getPushApollPort()
            {
                return 80;
            }

        };
        b = (new b[] {
            TEST, PREVIEW, RELEASE
        });
    }

    private _cls3(String s, int i, int j)
    {
        super(s, i);
        a = j;
    }

    a(String s, int i, int j, a a1)
    {
        this(s, i, j);
    }
}
