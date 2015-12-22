// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.fragment;


// Referenced classes of package com.umeng.fb.fragment:
//            FeedbackFragment

private static final class _cls9 extends Enum
{

    public static final AudioRecordErr AudioRecordErr;
    public static final AudioRecordErr CuntDown;
    public static final AudioRecordErr NoRecordPermission;
    public static final AudioRecordErr ReleaseCancel;
    public static final AudioRecordErr SlideUpCancel;
    public static final AudioRecordErr TimeShort;
    private static final AudioRecordErr a[];

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(com/umeng/fb/fragment/FeedbackFragment$DialogStatus, s);
    }

    public static _cls9[] values()
    {
        return (_cls9[])a.clone();
    }

    static 
    {
        SlideUpCancel = new <init>("SlideUpCancel", 0);
        ReleaseCancel = new <init>("ReleaseCancel", 1);
        CuntDown = new <init>("CuntDown", 2);
        TimeShort = new <init>("TimeShort", 3);
        NoRecordPermission = new <init>("NoRecordPermission", 4);
        AudioRecordErr = new <init>("AudioRecordErr", 5);
        a = (new a[] {
            SlideUpCancel, ReleaseCancel, CuntDown, TimeShort, NoRecordPermission, AudioRecordErr
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
