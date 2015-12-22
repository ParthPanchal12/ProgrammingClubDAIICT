// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package org.android.agoo.service:
//            IElectionService

public static abstract class attachInterface extends Binder
    implements IElectionService
{
    private static class Proxy
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

        Proxy(IBinder ibinder)
        {
            a = ibinder;
        }
    }


    private static final String a = "org.android.agoo.service.IElectionService";
    static final int b = 1;

    public static IElectionService asInterface(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("org.android.agoo.service.IElectionService");
        if (iinterface != null && (iinterface instanceof IElectionService))
        {
            return (IElectionService)iinterface;
        } else
        {
            return new Proxy(ibinder);
        }
    }

    public IBinder asBinder()
    {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        throws RemoteException
    {
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("org.android.agoo.service.IElectionService");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("org.android.agoo.service.IElectionService");
            election(parcel.readString(), parcel.readLong(), parcel.readString());
            parcel1.writeNoException();
            return true;
        }
    }

    public Proxy.a()
    {
        attachInterface(this, "org.android.agoo.service.IElectionService");
    }
}
