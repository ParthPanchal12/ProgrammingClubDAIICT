// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package org.android.agoo.service:
//            IMessageService

public static abstract class attachInterface extends Binder
    implements IMessageService
{
    private static class Proxy
        implements IMessageService
    {

        private IBinder a;

        public IBinder asBinder()
        {
            return a;
        }

        public String getInterfaceDescriptor()
        {
            return "org.android.agoo.service.IMessageService";
        }

        public boolean ping()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag;
            flag = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("org.android.agoo.service.IMessageService");
            a.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            i = parcel1.readInt();
            if (i == 0)
            {
                flag = false;
            }
            parcel1.recycle();
            parcel.recycle();
            return flag;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public void probe()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("org.android.agoo.service.IMessageService");
            a.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        Proxy(IBinder ibinder)
        {
            a = ibinder;
        }
    }


    private static final String a = "org.android.agoo.service.IMessageService";
    static final int b = 1;
    static final int c = 2;

    public static IMessageService asInterface(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("org.android.agoo.service.IMessageService");
        if (iinterface != null && (iinterface instanceof IMessageService))
        {
            return (IMessageService)iinterface;
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
            parcel1.writeString("org.android.agoo.service.IMessageService");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("org.android.agoo.service.IMessageService");
            boolean flag = ping();
            parcel1.writeNoException();
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel1.writeInt(i);
            return true;

        case 2: // '\002'
            parcel.enforceInterface("org.android.agoo.service.IMessageService");
            probe();
            parcel1.writeNoException();
            return true;
        }
    }

    public Proxy.a()
    {
        attachInterface(this, "org.android.agoo.service.IMessageService");
    }
}
