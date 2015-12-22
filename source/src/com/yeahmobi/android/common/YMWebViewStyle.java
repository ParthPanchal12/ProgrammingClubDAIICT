// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.common;


public final class YMWebViewStyle extends Enum
{

    private static final YMWebViewStyle $VALUES[];
    public static final YMWebViewStyle DESCRIPTION_ONLY;
    public static final YMWebViewStyle IMAGE_ONLY;
    public static final YMWebViewStyle MIX;
    public static final YMWebViewStyle TITLE_ONLY;

    private YMWebViewStyle(String s, int i)
    {
        super(s, i);
    }

    public static YMWebViewStyle valueOf(String s)
    {
        return (YMWebViewStyle)Enum.valueOf(com/yeahmobi/android/common/YMWebViewStyle, s);
    }

    public static YMWebViewStyle[] values()
    {
        return (YMWebViewStyle[])$VALUES.clone();
    }

    static 
    {
        IMAGE_ONLY = new YMWebViewStyle("IMAGE_ONLY", 0);
        TITLE_ONLY = new YMWebViewStyle("TITLE_ONLY", 1);
        DESCRIPTION_ONLY = new YMWebViewStyle("DESCRIPTION_ONLY", 2);
        MIX = new YMWebViewStyle("MIX", 3);
        $VALUES = (new YMWebViewStyle[] {
            IMAGE_ONLY, TITLE_ONLY, DESCRIPTION_ONLY, MIX
        });
    }
}
