// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.upd;


// Referenced classes of package u.upd:
//            f

public static final class String extends Enum
{

    public static final b a;
    public static final b b;
    private static final b c[];

    public static String valueOf(String s)
    {
        return (String)Enum.valueOf(u/upd/f$a, s);
    }

    public static String[] values()
    {
        Object aobj[] = c;
        int i = aobj.length;
        Object aobj1[] = new c[i];
        System.arraycopy(aobj, 0, aobj1, 0, i);
        return aobj1;
    }

    static 
    {
        a = new <init>("SUCCESS", 0);
        b = new <init>("FAIL", 1);
        c = (new c[] {
            a, b
        });
    }

    private String(String s, int i)
    {
        super(s, i);
    }
}
