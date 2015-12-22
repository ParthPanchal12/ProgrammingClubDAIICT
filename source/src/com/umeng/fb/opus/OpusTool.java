// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.opus;

import android.content.Context;
import com.umeng.fb.common.b;
import com.umeng.fb.util.Log;
import java.io.File;

public class OpusTool
{

    private static final String a = com/umeng/fb/opus/OpusTool.getName();
    private static Context b;

    public OpusTool(Context context)
    {
        b = context;
    }

    public static boolean a()
    {
        return com.umeng.fb.common.b.a(b).d();
    }

    private native int decode_opus_file(String s, String s1);

    private native int encode_wav_file(String s, String s1);

    private native String nativeGetString();

    public int a(String s, String s1)
    {
        if (!(new File(s)).exists())
        {
            Log.c(a, "opus is not exists");
            return -1;
        } else
        {
            return decode_opus_file(s, s1);
        }
    }

    public int b(String s, String s1)
    {
        if (!(new File(s)).exists())
        {
            Log.c(a, "wave is not exists");
            return -1;
        } else
        {
            return encode_wav_file(s, s1);
        }
    }

    static 
    {
        System.loadLibrary("umeng_opustool");
_L1:
        return;
        UnsatisfiedLinkError unsatisfiedlinkerror;
        unsatisfiedlinkerror;
        Log.b(a, "Could not load library of opustool");
        if (com.umeng.fb.common.b.a(b).d())
        {
            com.umeng.fb.common.b.a(b).c(false);
        }
          goto _L1
    }
}
