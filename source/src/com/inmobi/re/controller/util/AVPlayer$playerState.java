// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller.util;


// Referenced classes of package com.inmobi.re.controller.util:
//            AVPlayer

public static final class  extends Enum
{

    public static final RELEASED COMPLETED;
    public static final RELEASED HIDDEN;
    public static final RELEASED INIT;
    public static final RELEASED PAUSED;
    public static final RELEASED PLAYING;
    public static final RELEASED RELEASED;
    public static final RELEASED SHOWING;
    private static final RELEASED a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/re/controller/util/AVPlayer$playerState, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        INIT = new <init>("INIT", 0);
        PLAYING = new <init>("PLAYING", 1);
        PAUSED = new <init>("PAUSED", 2);
        HIDDEN = new <init>("HIDDEN", 3);
        SHOWING = new <init>("SHOWING", 4);
        COMPLETED = new <init>("COMPLETED", 5);
        RELEASED = new <init>("RELEASED", 6);
        a = (new a[] {
            INIT, PLAYING, PAUSED, HIDDEN, SHOWING, COMPLETED, RELEASED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
