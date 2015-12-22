// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.refresh;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

// Referenced classes of package com.allinone.free.refresh:
//            Pullable

public class PullableListView extends ListView
    implements Pullable
{
    public static interface OnLoadListener
    {

        public abstract void onLoad(PullableListView pullablelistview);
    }


    public static final int INIT = 0;
    public static final int LOADING = 1;
    public static final int NO_MORE_DATA = 2;
    private boolean autoLoad;
    private boolean canLoad;
    private boolean hasMoreData;
    private AnimationDrawable mLoadAnim;
    private ImageView mLoadingView;
    private View mLoadmoreView;
    private OnLoadListener mOnLoadListener;
    private TextView mStateTextView;
    private int state;

    public PullableListView(Context context)
    {
        super(context);
        state = 0;
        canLoad = true;
        autoLoad = true;
        hasMoreData = true;
        init(context);
    }

    public PullableListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        state = 0;
        canLoad = true;
        autoLoad = true;
        hasMoreData = true;
        init(context);
    }

    public PullableListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        state = 0;
        canLoad = true;
        autoLoad = true;
        hasMoreData = true;
        init(context);
    }

    private void changeState(int i)
    {
        state = i;
        switch (i)
        {
        default:
            return;

        case 0: // '\0'
            mLoadAnim.stop();
            mLoadingView.setVisibility(4);
            mStateTextView.setText(0x7f0b006a);
            return;

        case 1: // '\001'
            mLoadingView.setVisibility(0);
            mLoadAnim.start();
            mStateTextView.setText(0x7f0b006b);
            return;

        case 2: // '\002'
            mLoadAnim.stop();
            break;
        }
        mLoadingView.setVisibility(4);
        mStateTextView.setText("No More Data");
    }

    private void checkLoad()
    {
        if (reachBottom() && mOnLoadListener != null && state != 1 && canLoad && autoLoad && hasMoreData)
        {
            load();
        }
    }

    private void init(Context context)
    {
        mLoadmoreView = LayoutInflater.from(context).inflate(0x7f030064, null);
        mLoadingView = (ImageView)mLoadmoreView.findViewById(0x7f0601a7);
        mLoadingView.setBackgroundResource(0x7f040013);
        mLoadAnim = (AnimationDrawable)mLoadingView.getBackground();
        mStateTextView = (TextView)mLoadmoreView.findViewById(0x7f0601a8);
        mLoadmoreView.setOnClickListener(new android.view.View.OnClickListener() {

            final PullableListView this$0;

            public void onClick(View view)
            {
                if (state != 1 && hasMoreData)
                {
                    load();
                }
            }

            
            {
                this$0 = PullableListView.this;
                super();
            }
        });
        addFooterView(mLoadmoreView, null, false);
    }

    private void load()
    {
        changeState(1);
        mOnLoadListener.onLoad(this);
    }

    private boolean reachBottom()
    {
        while (getCount() == 0 || getLastVisiblePosition() == getCount() - 1 && getChildAt(getLastVisiblePosition() - getFirstVisiblePosition()) != null && getChildAt(getLastVisiblePosition() - getFirstVisiblePosition()).getTop() < getMeasuredHeight() && !canPullDown()) 
        {
            return true;
        }
        return false;
    }

    public boolean canPullDown()
    {
        while (getCount() == 0 || getFirstVisiblePosition() == 0 && getChildAt(0).getTop() >= 0) 
        {
            return true;
        }
        return false;
    }

    public boolean canPullUp()
    {
        return false;
    }

    public void enableAutoLoad(boolean flag)
    {
        autoLoad = flag;
    }

    public void finishLoading()
    {
        changeState(0);
    }

    public boolean isHasMoreData()
    {
        return hasMoreData;
    }

    protected void onScrollChanged(int i, int j, int k, int l)
    {
        super.onScrollChanged(i, j, k, l);
        checkLoad();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        motionevent.getActionMasked();
        JVM INSTR tableswitch 0 1: default 28
    //                   0 34
    //                   1 42;
           goto _L1 _L2 _L3
_L1:
        return super.onTouchEvent(motionevent);
_L2:
        canLoad = false;
        continue; /* Loop/switch isn't completed */
_L3:
        canLoad = true;
        checkLoad();
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void setHasMoreData(boolean flag)
    {
        hasMoreData = flag;
        if (!flag)
        {
            changeState(2);
            return;
        } else
        {
            changeState(0);
            return;
        }
    }

    public void setLoadmoreVisible(boolean flag)
    {
        if (flag)
        {
            if (getFooterViewsCount() == 0)
            {
                addFooterView(mLoadmoreView, null, false);
            }
            return;
        } else
        {
            removeFooterView(mLoadmoreView);
            return;
        }
    }

    public void setOnLoadListener(OnLoadListener onloadlistener)
    {
        mOnLoadListener = onloadlistener;
    }



}
