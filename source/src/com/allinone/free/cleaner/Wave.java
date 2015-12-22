// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.cleaner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

class Wave extends View
{
    private class RefreshProgressRunnable
        implements Runnable
    {

        final Wave this$0;

        public void run()
        {
            Wave wave = Wave.this;
            wave;
            JVM INSTR monitorenter ;
            Wave wave1;
            long l2;
            long l = System.currentTimeMillis();
            calculatePath();
            invalidate();
            l2 = 16L - System.currentTimeMillis() - l;
            wave1 = Wave.this;
            long l1;
            l1 = l2;
            if (l2 < 0L)
            {
                l1 = 0L;
            }
            wave1.postDelayed(this, l1);
            wave;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            wave;
            JVM INSTR monitorexit ;
            throw exception;
        }

        private RefreshProgressRunnable()
        {
            this$0 = Wave.this;
            super();
        }

        RefreshProgressRunnable(RefreshProgressRunnable refreshprogressrunnable)
        {
            this();
        }
    }


    public final int DEFAULT_ABOVE_WAVE_ALPHA;
    public final int DEFAULT_BLOW_WAVE_ALPHA;
    private final double PI2;
    private final int WAVE_HEIGHT_LARGE;
    private final int WAVE_HEIGHT_LITTLE;
    private final int WAVE_HEIGHT_MIDDLE;
    private final float WAVE_HZ_FAST;
    private final float WAVE_HZ_NORMAL;
    private final float WAVE_HZ_SLOW;
    private final float WAVE_LENGTH_MULTIPLE_LARGE;
    private final float WAVE_LENGTH_MULTIPLE_LITTLE;
    private final float WAVE_LENGTH_MULTIPLE_MIDDLE;
    private final float X_SPACE;
    private int bottom;
    private int left;
    private float mAboveOffset;
    private int mAboveWaveColor;
    private Paint mAboveWavePaint;
    private Path mAboveWavePath;
    private float mBlowOffset;
    private int mBlowWaveColor;
    private Paint mBlowWavePaint;
    private Path mBlowWavePath;
    private float mMaxRight;
    private RefreshProgressRunnable mRefreshProgressRunnable;
    private int mWaveHeight;
    private float mWaveHz;
    private float mWaveLength;
    private float mWaveMultiple;
    private double omega;
    private int right;

    public Wave(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x7f010088);
    }

    public Wave(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        WAVE_HEIGHT_LARGE = 16;
        WAVE_HEIGHT_MIDDLE = 8;
        WAVE_HEIGHT_LITTLE = 5;
        WAVE_LENGTH_MULTIPLE_LARGE = 1.5F;
        WAVE_LENGTH_MULTIPLE_MIDDLE = 1.0F;
        WAVE_LENGTH_MULTIPLE_LITTLE = 0.5F;
        WAVE_HZ_FAST = 0.13F;
        WAVE_HZ_NORMAL = 0.09F;
        WAVE_HZ_SLOW = 0.05F;
        DEFAULT_ABOVE_WAVE_ALPHA = 50;
        DEFAULT_BLOW_WAVE_ALPHA = 30;
        X_SPACE = 20F;
        PI2 = 6.2831853071795862D;
        mAboveWavePath = new Path();
        mBlowWavePath = new Path();
        mAboveWavePaint = new Paint();
        mBlowWavePaint = new Paint();
        mAboveOffset = 0.0F;
    }

    private void calculatePath()
    {
        float f;
        mAboveWavePath.reset();
        mBlowWavePath.reset();
        getWaveOffset();
        mAboveWavePath.moveTo(left, bottom);
        f = 0.0F;
_L3:
        if (f <= mMaxRight) goto _L2; else goto _L1
_L1:
        mAboveWavePath.lineTo(right, bottom);
        mBlowWavePath.moveTo(left, bottom);
        f = 0.0F;
_L4:
        if (f > mMaxRight)
        {
            mBlowWavePath.lineTo(right, bottom);
            return;
        }
        break MISSING_BLOCK_LABEL_156;
_L2:
        float f1 = (float)((double)mWaveHeight * Math.sin(omega * (double)f + (double)mAboveOffset) + (double)mWaveHeight);
        mAboveWavePath.lineTo(f, f1);
        f += 20F;
          goto _L3
        float f2 = (float)((double)mWaveHeight * Math.sin(omega * (double)f + (double)mBlowOffset) + (double)mWaveHeight);
        mBlowWavePath.lineTo(f, f2);
        f += 20F;
          goto _L4
    }

    private int getWaveHeight(int i)
    {
        switch (i)
        {
        default:
            return 0;

        case 1: // '\001'
            return 16;

        case 2: // '\002'
            return 8;

        case 3: // '\003'
            return 5;
        }
    }

    private float getWaveHz(int i)
    {
        switch (i)
        {
        default:
            return 0.0F;

        case 1: // '\001'
            return 0.13F;

        case 2: // '\002'
            return 0.09F;

        case 3: // '\003'
            return 0.05F;
        }
    }

    private float getWaveMultiple(int i)
    {
        switch (i)
        {
        default:
            return 0.0F;

        case 1: // '\001'
            return 1.5F;

        case 2: // '\002'
            return 1.0F;

        case 3: // '\003'
            return 0.5F;
        }
    }

    private void getWaveOffset()
    {
        if (mBlowOffset > 3.402823E+38F)
        {
            mBlowOffset = 0.0F;
        } else
        {
            mBlowOffset = mBlowOffset + mWaveHz;
        }
        if (mAboveOffset > 3.402823E+38F)
        {
            mAboveOffset = 0.0F;
            return;
        } else
        {
            mAboveOffset = mAboveOffset + mWaveHz;
            return;
        }
    }

    private void startWave()
    {
        if (getWidth() != 0)
        {
            mWaveLength = (float)getWidth() * mWaveMultiple;
            left = getLeft();
            right = getRight();
            bottom = getBottom();
            mMaxRight = (float)right + 20F;
            omega = 6.2831853071795862D / (double)mWaveLength;
        }
    }

    public Paint getAboveWavePaint()
    {
        return mAboveWavePaint;
    }

    public Paint getBlowWavePaint()
    {
        return mBlowWavePaint;
    }

    public void initializePainters()
    {
        mAboveWavePaint.setColor(mAboveWaveColor);
        mAboveWavePaint.setAlpha(50);
        mAboveWavePaint.setStyle(android.graphics.Paint.Style.FILL);
        mAboveWavePaint.setAntiAlias(true);
        mBlowWavePaint.setColor(mBlowWaveColor);
        mBlowWavePaint.setAlpha(30);
        mBlowWavePaint.setStyle(android.graphics.Paint.Style.FILL);
        mBlowWavePaint.setAntiAlias(true);
    }

    public void initializeWaveSize(int i, int j, int k)
    {
        mWaveMultiple = getWaveMultiple(i);
        mWaveHeight = getWaveHeight(j);
        mWaveHz = getWaveHz(k);
        mBlowOffset = (float)mWaveHeight * 0.4F;
        setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, mWaveHeight * 2));
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.drawPath(mBlowWavePath, mBlowWavePaint);
        canvas.drawPath(mAboveWavePath, mAboveWavePaint);
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        if (flag && mWaveLength == 0.0F)
        {
            startWave();
        }
    }

    protected void onWindowVisibilityChanged(int i)
    {
        super.onWindowVisibilityChanged(i);
        if (8 == i)
        {
            removeCallbacks(mRefreshProgressRunnable);
            return;
        } else
        {
            removeCallbacks(mRefreshProgressRunnable);
            mRefreshProgressRunnable = new RefreshProgressRunnable(null);
            post(mRefreshProgressRunnable);
            return;
        }
    }

    public void setAboveWaveColor(int i)
    {
        mAboveWaveColor = i;
    }

    public void setBlowWaveColor(int i)
    {
        mBlowWaveColor = i;
    }

}
