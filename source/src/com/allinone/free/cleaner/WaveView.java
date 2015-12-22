// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.cleaner;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

// Referenced classes of package com.allinone.free.cleaner:
//            Wave, Solid

public class WaveView extends LinearLayout
{
    private static class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel, null);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public SavedState[] newArray(int i)
            {
                return new SavedState[i];
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


        private SavedState(Parcel parcel)
        {
            super(parcel);
            progress = parcel.readInt();
        }

        SavedState(Parcel parcel, SavedState savedstate)
        {
            this(parcel);
        }

        SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }


    protected static final int LARGE = 1;
    protected static final int LITTLE = 3;
    protected static final int MIDDLE = 2;
    private final int DEFAULT_ABOVE_WAVE_COLOR = -1;
    private final int DEFAULT_BLOW_WAVE_COLOR = -1;
    private final int DEFAULT_PROGRESS = 80;
    private int mAboveWaveColor;
    private int mBlowWaveColor;
    private int mProgress;
    private Solid mSolid;
    private Wave mWave;
    private int mWaveHeight;
    private int mWaveHz;
    private int mWaveMultiple;
    private int mWaveToTop;

    public WaveView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        setOrientation(1);
        attributeset = context.getTheme().obtainStyledAttributes(attributeset, com.allinone.free.R.styleable.WaveView, 0x7f010088, 0);
        mAboveWaveColor = attributeset.getColor(0, -1);
        mBlowWaveColor = attributeset.getColor(1, -1);
        mProgress = attributeset.getInt(2, 80);
        mWaveHeight = attributeset.getInt(4, 2);
        mWaveMultiple = attributeset.getInt(3, 1);
        mWaveHz = attributeset.getInt(5, 2);
        attributeset.recycle();
        mWave = new Wave(context, null);
        mWave.initializeWaveSize(mWaveMultiple, mWaveHeight, mWaveHz);
        mWave.setAboveWaveColor(mAboveWaveColor);
        mWave.setBlowWaveColor(mBlowWaveColor);
        mWave.initializePainters();
        mSolid = new Solid(context, null);
        mSolid.setAboveWavePaint(mWave.getAboveWavePaint());
        mSolid.setBlowWavePaint(mWave.getBlowWavePaint());
        addView(mWave);
        addView(mSolid);
        setProgress(mProgress);
    }

    private void computeWaveToTop()
    {
        mWaveToTop = (int)((float)getHeight() * (1.0F - (float)mProgress / 100F));
        android.view.ViewGroup.LayoutParams layoutparams = mWave.getLayoutParams();
        if (layoutparams != null)
        {
            ((android.widget.LinearLayout.LayoutParams)layoutparams).topMargin = mWaveToTop;
        }
        mWave.setLayoutParams(layoutparams);
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        setProgress(((SavedState) (parcelable)).progress);
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.progress = mProgress;
        return savedstate;
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        if (flag)
        {
            computeWaveToTop();
        }
    }

    public void setProgress(int i)
    {
        int j = i;
        if (i > 100)
        {
            j = 100;
        }
        mProgress = j;
        computeWaveToTop();
    }
}
