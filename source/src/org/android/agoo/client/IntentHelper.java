// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.client;

import android.content.Context;
import android.content.Intent;

public class IntentHelper
{

    private static final String a = ".intent.action.COMMAND";
    private static final String b = ".intent.action.START";
    private static final String c = ".intent.action.COCKROACH";

    public IntentHelper()
    {
    }

    public static Intent createComandIntent(Context context, String s)
    {
        Intent intent = new Intent();
        intent.setAction(getAgooCommand(context));
        intent.putExtra("command", s);
        return intent;
    }

    public static String getAgooCockroach(Context context)
    {
        if (context != null)
        {
            return (new StringBuilder()).append(context.getPackageName()).append(".intent.action.COCKROACH").toString();
        } else
        {
            return "org.agoo.android.intent.action.COCKROACH";
        }
    }

    public static String getAgooCommand(Context context)
    {
        if (context != null)
        {
            return (new StringBuilder()).append(context.getPackageName()).append(".intent.action.COMMAND").toString();
        } else
        {
            return "org.agoo.android.intent.action.COMMAND";
        }
    }

    public static String getAgooStart(Context context)
    {
        if (context != null)
        {
            return (new StringBuilder()).append(context.getPackageName()).append(".intent.action.START").toString();
        } else
        {
            return "org.agoo.android.intent.action.START";
        }
    }
}
