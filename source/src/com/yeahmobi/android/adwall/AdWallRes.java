// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.adwall;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.yeahmobi.android.adwall:
//            AdWallItemRes

public class AdWallRes
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public AdWallRes createFromParcel(Parcel parcel)
        {
            return new AdWallRes(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public AdWallRes[] newArray(int i)
        {
            return new AdWallRes[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    List itemRes;
    final int layoutRes;
    final int listRes;
    final int processBarRes;

    public AdWallRes(int i, int j, int k, AdWallItemRes adwallitemres)
    {
        layoutRes = i;
        listRes = j;
        processBarRes = k;
        itemRes = new ArrayList();
        itemRes.add(adwallitemres);
    }

    public AdWallRes(Parcel parcel)
    {
        layoutRes = parcel.readInt();
        listRes = parcel.readInt();
        processBarRes = parcel.readInt();
        itemRes = new ArrayList();
        parcel.readTypedList(itemRes, AdWallItemRes.CREATOR);
    }

    public int describeContents()
    {
        return 0;
    }

    public AdWallItemRes getItemRes()
    {
        return (AdWallItemRes)itemRes.get(0);
    }

    public int getLayoutRes()
    {
        return layoutRes;
    }

    public int getListRes()
    {
        return listRes;
    }

    public int getProcessBarRes()
    {
        return processBarRes;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(layoutRes);
        parcel.writeInt(listRes);
        parcel.writeInt(processBarRes);
        parcel.writeTypedList(itemRes);
    }

}
