// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.cleaner;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.allinone.free.cleaner:
//            WaveView

private static class <init> extends android.view.w.SavedState
{

    public static final android.os.iew.SavedState.progress CREATOR = new android.os.Parcelable.Creator() {

        public WaveView.SavedState createFromParcel(Parcel parcel)
        {
            return new WaveView.SavedState(parcel, null);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public WaveView.SavedState[] newArray(int i)
        {
            return new WaveView.SavedState[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    int progress;

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeInt(progress);
    }


    private _cls1(Parcel parcel)
    {
        super(parcel);
        progress = parcel.readInt();
    }

    progress(Parcel parcel, progress progress1)
    {
        this(parcel);
    }

    <init>(Parcelable parcelable)
    {
        super(parcelable);
    }
}
