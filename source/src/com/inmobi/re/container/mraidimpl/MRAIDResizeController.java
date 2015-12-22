// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container.mraidimpl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import com.inmobi.re.container.CustomView;
import com.inmobi.re.container.IMWebView;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.re.container.mraidimpl:
//            ResizeDimensions, MRAIDAudioVideoController

public class MRAIDResizeController
{

    protected static final int PLACEHOLDER_ID = 437;
    protected static final int RELATIVELAYOUT_ID = 438;
    private IMWebView a;
    private ResizeDimensions b;
    public com.inmobi.re.controller.JSController.ResizeProperties resizeProperties;

    public MRAIDResizeController(IMWebView imwebview, Activity activity)
    {
        b = null;
        a = imwebview;
    }

    private FrameLayout a(com.inmobi.re.controller.JSController.ResizeProperties resizeproperties)
    {
        FrameLayout framelayout = (FrameLayout)((ViewGroup)a.getOriginalParent()).getRootView().findViewById(0x1020002);
        a();
        FrameLayout framelayout1 = new FrameLayout(a.getContext());
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
        framelayout1.setId(435);
        android.widget.FrameLayout.LayoutParams layoutparams1 = new android.widget.FrameLayout.LayoutParams(resizeproperties.width, resizeproperties.height);
        RelativeLayout relativelayout = new RelativeLayout(a.getContext());
        relativelayout.setId(438);
        android.widget.RelativeLayout.LayoutParams layoutparams2 = new android.widget.RelativeLayout.LayoutParams(resizeproperties.width, resizeproperties.height);
        relativelayout.addView(a, layoutparams2);
        a(((ViewGroup) (relativelayout)), resizeproperties.customClosePosition);
        framelayout1.addView(relativelayout, layoutparams1);
        a(framelayout, framelayout1, a, resizeproperties);
        framelayout.addView(framelayout1, layoutparams);
        a.setFocusable(true);
        a.setFocusableInTouchMode(true);
        a.requestFocus();
        return framelayout1;
    }

    private android.widget.RelativeLayout.LayoutParams a(String s)
    {
        s = b(s);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams((int)(a.getDensity() * 50F), (int)(a.getDensity() * 50F));
        if (s.equals("top-right") || s.equals("bottom-right"))
        {
            layoutparams.addRule(11);
        }
        if (s.equals("bottom-right") || s.equals("bottom-left") || s.equals("bottom-center"))
        {
            layoutparams.addRule(12);
            layoutparams.addRule(4);
        }
        if (s.equals("bottom-center") || s.equals("top-center") || s.equals("center"))
        {
            layoutparams.addRule(13);
        }
        if (s.equals("top-center"))
        {
            layoutparams.addRule(10);
        }
        return layoutparams;
    }

    static IMWebView a(MRAIDResizeController mraidresizecontroller)
    {
        return mraidresizecontroller.a;
    }

    private void a()
    {
        try
        {
            FrameLayout framelayout = new FrameLayout(a.getContext());
            framelayout.setId(437);
            android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(a.getWidth(), a.getHeight());
            ((ViewGroup)a.getOriginalParent()).addView(framelayout, a.getOriginalIndex(), layoutparams);
            ((ViewGroup)a.getParent()).removeView(a);
            return;
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-[RE]-4.5.5", "Exception in replaceByPlaceHolder ", exception);
        }
    }

    private void a(ViewGroup viewgroup, String s)
    {
        s = a(s);
        CustomView customview = new CustomView(a.getContext(), a.getDensity(), com.inmobi.re.container.CustomView.SwitchIconType.CLOSE_TRANSPARENT);
        viewgroup.addView(customview, s);
        customview.setOnClickListener(new android.view.View.OnClickListener() {

            final MRAIDResizeController a;

            public void onClick(View view)
            {
                IMWebView.userInitiatedClose = true;
                MRAIDResizeController.a(a).close();
            }

            
            {
                a = MRAIDResizeController.this;
                super();
            }
        });
    }

    private void a(FrameLayout framelayout, FrameLayout framelayout1, IMWebView imwebview, com.inmobi.re.controller.JSController.ResizeProperties resizeproperties)
    {
        framelayout1 = new int[2];
        int ai[] = new int[2];
        ((View)imwebview.getOriginalParent()).getLocationOnScreen(framelayout1);
        framelayout.getLocationOnScreen(ai);
        framelayout1[1] = framelayout1[1] - ai[1];
        framelayout1[0] = framelayout1[0] - ai[0];
        framelayout1[0] = framelayout1[0] + resizeproperties.offsetX;
        framelayout1[1] = framelayout1[1] + resizeproperties.offsetY;
        if (!resizeproperties.allowOffscreen)
        {
            if (resizeproperties.width > framelayout.getWidth() - framelayout1[0])
            {
                framelayout1[0] = framelayout.getWidth() - resizeproperties.width;
            }
            if (resizeproperties.height > framelayout.getHeight() - framelayout1[1])
            {
                framelayout1[1] = framelayout.getHeight() - resizeproperties.height;
            }
            if (framelayout1[0] < 0)
            {
                framelayout1[0] = 0;
            }
            if (framelayout1[1] < 0)
            {
                framelayout1[1] = 0;
            }
        }
        b = new ResizeDimensions(framelayout1[0], framelayout1[1], resizeproperties.width, resizeproperties.height);
        framelayout = new android.widget.FrameLayout.LayoutParams(resizeproperties.width, resizeproperties.height);
        framelayout.leftMargin = framelayout1[0];
        framelayout.topMargin = framelayout1[1];
        framelayout.gravity = 3;
        ((View)imwebview.getParent()).setLayoutParams(framelayout);
    }

    static ResizeDimensions b(MRAIDResizeController mraidresizecontroller)
    {
        return mraidresizecontroller.b;
    }

    private String b(String s)
    {
        String s1 = s;
        if (!s.equals("top-left"))
        {
            s1 = s;
            if (!s.equals("top-right"))
            {
                s1 = s;
                if (!s.equals("bottom-left"))
                {
                    s1 = s;
                    if (!s.equals("bottom-right"))
                    {
                        s1 = s;
                        if (!s.equals("top-center"))
                        {
                            s1 = s;
                            if (!s.equals("bottom-center"))
                            {
                                s1 = s;
                                if (!s.equals("center"))
                                {
                                    s1 = "top-right";
                                }
                            }
                        }
                    }
                }
            }
        }
        return s1;
    }

    private void b()
    {
        ((ViewGroup)a.getParent().getParent().getParent()).removeView((View)a.getParent().getParent());
        ((ViewGroup)a.getParent()).removeView(a);
        View view = ((View)a.getOriginalParent()).findViewById(437);
        ((ViewGroup)view.getParent()).removeView(view);
        ((ViewGroup)a.getOriginalParent()).addView(a, a.getOriginalIndex());
        a.resetLayout();
    }

    public void closeResized()
    {
        if (a.getViewState().compareTo(com.inmobi.re.container.IMWebView.ViewState.DEFAULT) == 0)
        {
            return;
        }
        synchronized (a.mutex)
        {
            a.isMutexAquired.set(false);
            a.mutex.notifyAll();
        }
        a.doNotFireVisibilityChanged.set(true);
        b();
        a.closeResized();
        a.setVisibility(0);
        a.setState(com.inmobi.re.container.IMWebView.ViewState.DEFAULT);
        a.doNotFireVisibilityChanged.set(false);
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void doResize(Bundle bundle)
    {
        a.doNotFireVisibilityChanged.set(true);
        if (a.getOriginalParent() == null)
        {
            a.saveOriginalViewParent();
        }
        if (((FrameLayout)a.getParent().getParent()).getId() != 435)
        {
            break MISSING_BLOCK_LABEL_215;
        }
        a((FrameLayout)a.getParent().getParent().getParent(), (FrameLayout)a.getParent().getParent(), a, resizeProperties);
        android.widget.RelativeLayout.LayoutParams layoutparams = a(resizeProperties.customClosePosition);
        android.widget.RelativeLayout.LayoutParams layoutparams1 = new android.widget.RelativeLayout.LayoutParams(resizeProperties.width, resizeProperties.height);
        a.setLayoutParams(layoutparams1);
        ((ViewGroup)a.getParent()).getChildAt(1).setLayoutParams(layoutparams);
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_173;
        }
        a.setState(com.inmobi.re.container.IMWebView.ViewState.RESIZED);
        a.requestLayout();
        a.invalidate();
        a.postInHandler(new Runnable() {

            final MRAIDResizeController a;

            public void run()
            {
                if (MRAIDResizeController.a(a).mListener != null)
                {
                    MRAIDResizeController.a(a).mListener.onResize(MRAIDResizeController.b(a));
                }
            }

            
            {
                a = MRAIDResizeController.this;
                super();
            }
        });
        a.doNotFireVisibilityChanged.set(false);
        return;
        Exception exception;
        exception;
        a(resizeProperties).setBackgroundColor(0);
        a.mAudioVideoController.videoValidateWidth = resizeProperties.width;
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_258;
        }
        a.setState(com.inmobi.re.container.IMWebView.ViewState.RESIZED);
        synchronized (a.mutex)
        {
            a.isMutexAquired.set(false);
            a.mutex.notifyAll();
        }
        a.requestLayout();
        a.invalidate();
        a.postInHandler(new Runnable() {

            final MRAIDResizeController a;

            public void run()
            {
                if (MRAIDResizeController.a(a).mListener != null)
                {
                    MRAIDResizeController.a(a).mListener.onResize(MRAIDResizeController.b(a));
                }
            }

            
            {
                a = MRAIDResizeController.this;
                super();
            }
        });
_L2:
        a.doNotFireVisibilityChanged.set(false);
        return;
        exception1;
        bundle;
        JVM INSTR monitorexit ;
        try
        {
            throw exception1;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            Log.debug("[InMobi]-[RE]-4.5.5", "Exception in doresize ", bundle);
        }
        a.setState(com.inmobi.re.container.IMWebView.ViewState.DEFAULT);
        synchronized (a.mutex)
        {
            a.isMutexAquired.set(false);
            a.mutex.notifyAll();
        }
        if (true) goto _L2; else goto _L1
_L1:
        exception2;
        bundle;
        JVM INSTR monitorexit ;
        throw exception2;
    }

    public void onOrientationChange()
    {
        if (a.getStateVariable() == com.inmobi.re.container.IMWebView.ViewState.RESIZED && !resizeProperties.allowOffscreen)
        {
            doResize(null);
        }
    }

    public void reset()
    {
        resizeProperties = new com.inmobi.re.controller.JSController.ResizeProperties();
    }
}
