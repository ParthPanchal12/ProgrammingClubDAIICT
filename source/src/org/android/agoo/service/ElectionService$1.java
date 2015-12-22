// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.service;

import android.os.RemoteException;

// Referenced classes of package org.android.agoo.service:
//            ElectionService

class tub extends tub
{

    final ElectionService a;

    public void election(String s, long l, String s1)
        throws RemoteException
    {
        if (ElectionService.a(a))
        {
            return;
        } else
        {
            ElectionService.a(a, s, l);
            return;
        }
    }

    tub(ElectionService electionservice)
    {
        a = electionservice;
        super();
    }
}
