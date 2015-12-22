// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package org.android.agoo.service:
//            IElectionService

private static class a
    implements IElectionService
{

    private IBinder a;

    public IBinder asBinder()
    {
        return a;
    }

    public void election(String s, long l, String s1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("org.android.agoo.service.IElectionService");
        parcel.writeString(s);
        parcel.writeLong(l);
        parcel.writeString(s1);
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public String getInterfaceDescriptor()
    {
        return "org.android.agoo.service.IElectionService";
    }

    (IBinder ibinder)
    {
        a = ibinder;
    }
}
