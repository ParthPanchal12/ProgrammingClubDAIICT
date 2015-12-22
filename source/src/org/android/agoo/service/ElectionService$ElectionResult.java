// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.service;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;

// Referenced classes of package org.android.agoo.service:
//            ElectionService

public static class <init>
    implements Parcelable
{

    public static final android.os.lectionResult.b CREATOR = new android.os.Parcelable.Creator() {

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ElectionService.ElectionResult createFromParcel(Parcel parcel)
        {
            return new ElectionService.ElectionResult(parcel, null);
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        public ElectionService.ElectionResult[] newArray(int i)
        {
            return null;
        }

    };
    private long a;
    private String b;
    private HashMap c;

    public int describeContents()
    {
        return 0;
    }

    public String getElectionSource()
    {
        return b;
    }

    public HashMap getSudoMap()
    {
        return c;
    }

    public long getTimeout()
    {
        return a;
    }

    public void putSudo(String s, String s1)
    {
        c.put(s, s1);
    }

    public void setElectionSource(String s)
    {
        b = s;
    }

    public void setSudoMap(HashMap hashmap)
    {
        c = hashmap;
    }

    public void setTimeout(long l)
    {
        a = l;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(a);
        parcel.writeMap(c);
        parcel.writeString(b);
    }


    public _cls1()
    {
        a = -1L;
        c = new HashMap();
    }

    private c(Parcel parcel)
    {
        a = -1L;
        c = new HashMap();
        a = parcel.readLong();
        c = parcel.readHashMap(java/util/HashMap.getClassLoader());
        b = parcel.readString();
    }

    b(Parcel parcel, b b1)
    {
        this(parcel);
    }
}
