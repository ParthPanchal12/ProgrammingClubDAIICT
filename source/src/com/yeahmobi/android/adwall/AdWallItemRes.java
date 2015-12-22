// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.adwall;

import android.os.Parcel;
import android.os.Parcelable;

public class AdWallItemRes
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public AdWallItemRes createFromParcel(Parcel parcel)
        {
            return new AdWallItemRes(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public AdWallItemRes[] newArray(int i)
        {
            return new AdWallItemRes[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    final int artistRes;
    final int id;
    final int thumbRes;
    final int titleRes;

    public AdWallItemRes(int i, int j, int k, int l)
    {
        id = i;
        titleRes = j;
        artistRes = k;
        thumbRes = l;
    }

    public AdWallItemRes(Parcel parcel)
    {
        id = parcel.readInt();
        titleRes = parcel.readInt();
        artistRes = parcel.readInt();
        thumbRes = parcel.readInt();
    }

    public int describeContents()
    {
        return 0;
    }

    public int getArtistRes()
    {
        return artistRes;
    }

    public int getId()
    {
        return id;
    }

    public int getThumbRes()
    {
        return thumbRes;
    }

    public int getTitleRes()
    {
        return titleRes;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(id);
        parcel.writeInt(titleRes);
        parcel.writeInt(artistRes);
        parcel.writeInt(thumbRes);
    }

}
