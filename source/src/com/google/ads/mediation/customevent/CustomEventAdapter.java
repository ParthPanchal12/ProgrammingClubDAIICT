// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdSize;
import com.google.ads.g;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.ads.util.a;
import com.google.ads.util.b;

// Referenced classes of package com.google.ads.mediation.customevent:
//            CustomEventBanner, CustomEventInterstitial, CustomEventExtras, CustomEventServerParameters, 
//            CustomEventBannerListener, CustomEventInterstitialListener

public class CustomEventAdapter
    implements MediationBannerAdapter, MediationInterstitialAdapter
{
    private class a
        implements CustomEventBannerListener
    {

        final CustomEventAdapter a;
        private View b;
        private final MediationBannerListener c;

        private String b()
        {
            return (new StringBuilder()).append("Banner custom event labeled '").append(com.google.ads.mediation.customevent.CustomEventAdapter.a(a)).append("'").toString();
        }

        public View a()
        {
            this;
            JVM INSTR monitorenter ;
            View view = b;
            this;
            JVM INSTR monitorexit ;
            return view;
            Exception exception;
            exception;
            throw exception;
        }

        public void onClick()
        {
            com.google.ads.util.b.a((new StringBuilder()).append(b()).append(" called onClick().").toString());
            c.onClick(a);
        }

        public void onDismissScreen()
        {
            com.google.ads.util.b.a((new StringBuilder()).append(b()).append(" called onDismissScreen().").toString());
            c.onDismissScreen(a);
        }

        public void onFailedToReceiveAd()
        {
            com.google.ads.util.b.a((new StringBuilder()).append(b()).append(" called onFailedToReceiveAd().").toString());
            c.onFailedToReceiveAd(a, com.google.ads.AdRequest.ErrorCode.NO_FILL);
        }

        public void onLeaveApplication()
        {
            this;
            JVM INSTR monitorenter ;
            com.google.ads.util.b.a((new StringBuilder()).append(b()).append(" called onLeaveApplication().").toString());
            c.onLeaveApplication(a);
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public void onPresentScreen()
        {
            com.google.ads.util.b.a((new StringBuilder()).append(b()).append(" called onPresentScreen().").toString());
            c.onPresentScreen(a);
        }

        public void onReceivedAd(View view)
        {
            this;
            JVM INSTR monitorenter ;
            com.google.ads.util.b.a((new StringBuilder()).append(b()).append(" called onReceivedAd.").toString());
            b = view;
            c.onReceivedAd(a);
            this;
            JVM INSTR monitorexit ;
            return;
            view;
            throw view;
        }

        public a(MediationBannerListener mediationbannerlistener)
        {
            a = CustomEventAdapter.this;
            super();
            c = mediationbannerlistener;
        }
    }

    private class b
        implements CustomEventInterstitialListener
    {

        final CustomEventAdapter a;
        private final MediationInterstitialListener b;

        private String a()
        {
            return (new StringBuilder()).append("Interstitial custom event labeled '").append(com.google.ads.mediation.customevent.CustomEventAdapter.a(a)).append("'").toString();
        }

        public void onDismissScreen()
        {
            com.google.ads.util.b.a((new StringBuilder()).append(a()).append(" called onDismissScreen().").toString());
            b.onDismissScreen(a);
        }

        public void onFailedToReceiveAd()
        {
            com.google.ads.util.b.a((new StringBuilder()).append(a()).append(" called onFailedToReceiveAd().").toString());
            b.onFailedToReceiveAd(a, com.google.ads.AdRequest.ErrorCode.NO_FILL);
        }

        public void onLeaveApplication()
        {
            this;
            JVM INSTR monitorenter ;
            com.google.ads.util.b.a((new StringBuilder()).append(a()).append(" called onLeaveApplication().").toString());
            b.onLeaveApplication(a);
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public void onPresentScreen()
        {
            com.google.ads.util.b.a((new StringBuilder()).append(a()).append(" called onPresentScreen().").toString());
            b.onPresentScreen(a);
        }

        public void onReceivedAd()
        {
            com.google.ads.util.b.a((new StringBuilder()).append(a()).append(" called onReceivedAd.").toString());
            b.onReceivedAd(a);
        }

        public b(MediationInterstitialListener mediationinterstitiallistener)
        {
            a = CustomEventAdapter.this;
            super();
            b = mediationinterstitiallistener;
        }
    }


    private String a;
    private CustomEventBanner b;
    private a c;
    private CustomEventInterstitial d;

    public CustomEventAdapter()
    {
        b = null;
        c = null;
        d = null;
    }

    private Object a(String s, Class class1, String s1)
    {
        s1 = ((String) (g.a(s, class1)));
        return s1;
        class1;
        a((new StringBuilder()).append("Make sure you created a visible class named: ").append(s).append(". ").toString(), ((Throwable) (class1)));
_L2:
        return null;
        s;
        a((new StringBuilder()).append("Make sure your custom event implements the ").append(class1.getName()).append(" interface.").toString(), ((Throwable) (s)));
        continue; /* Loop/switch isn't completed */
        class1;
        a((new StringBuilder()).append("Make sure the default constructor for class ").append(s).append(" is visible. ").toString(), ((Throwable) (class1)));
        continue; /* Loop/switch isn't completed */
        class1;
        a((new StringBuilder()).append("Make sure the name ").append(s).append(" does not denote an abstract class or an interface.").toString(), ((Throwable) (class1)));
        continue; /* Loop/switch isn't completed */
        s;
        a("", ((Throwable) (s)));
        if (true) goto _L2; else goto _L1
_L1:
    }

    static String a(CustomEventAdapter customeventadapter)
    {
        return customeventadapter.a;
    }

    private void a(String s, Throwable throwable)
    {
        com.google.ads.util.b.b((new StringBuilder()).append("Error during processing of custom event with label: '").append(a).append("'. Skipping custom event. ").append(s).toString(), throwable);
    }

    public void destroy()
    {
        if (b != null)
        {
            b.destroy();
        }
        if (d != null)
        {
            d.destroy();
        }
    }

    public Class getAdditionalParametersType()
    {
        return com/google/ads/mediation/customevent/CustomEventExtras;
    }

    public View getBannerView()
    {
        com.google.ads.util.a.b(c);
        return c.a();
    }

    public Class getServerParametersType()
    {
        return com/google/ads/mediation/customevent/CustomEventServerParameters;
    }

    public volatile void requestBannerAd(MediationBannerListener mediationbannerlistener, Activity activity, MediationServerParameters mediationserverparameters, AdSize adsize, MediationAdRequest mediationadrequest, NetworkExtras networkextras)
    {
        requestBannerAd(mediationbannerlistener, activity, (CustomEventServerParameters)mediationserverparameters, adsize, mediationadrequest, (CustomEventExtras)networkextras);
    }

    public void requestBannerAd(MediationBannerListener mediationbannerlistener, Activity activity, CustomEventServerParameters customeventserverparameters, AdSize adsize, MediationAdRequest mediationadrequest, CustomEventExtras customeventextras)
    {
        String s;
        com.google.ads.util.a.a(a);
        a = customeventserverparameters.label;
        String s1 = customeventserverparameters.className;
        s = customeventserverparameters.parameter;
        b = (CustomEventBanner)a(s1, com/google/ads/mediation/customevent/CustomEventBanner, a);
        if (b == null)
        {
            mediationbannerlistener.onFailedToReceiveAd(this, com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
        com.google.ads.util.a.a(c);
        c = new a(mediationbannerlistener);
        CustomEventBanner customeventbanner;
        a a1;
        String s2;
        customeventbanner = b;
        a1 = c;
        s2 = a;
        if (customeventextras != null)
        {
            break MISSING_BLOCK_LABEL_148;
        }
        customeventserverparameters = null;
_L1:
        try
        {
            customeventbanner.requestBannerAd(a1, activity, s2, s, adsize, mediationadrequest, customeventserverparameters);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            a("", activity);
        }
        mediationbannerlistener.onFailedToReceiveAd(this, com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR);
        return;
        customeventserverparameters = ((CustomEventServerParameters) (customeventextras.getExtra(a)));
          goto _L1
    }

    public volatile void requestInterstitialAd(MediationInterstitialListener mediationinterstitiallistener, Activity activity, MediationServerParameters mediationserverparameters, MediationAdRequest mediationadrequest, NetworkExtras networkextras)
    {
        requestInterstitialAd(mediationinterstitiallistener, activity, (CustomEventServerParameters)mediationserverparameters, mediationadrequest, (CustomEventExtras)networkextras);
    }

    public void requestInterstitialAd(MediationInterstitialListener mediationinterstitiallistener, Activity activity, CustomEventServerParameters customeventserverparameters, MediationAdRequest mediationadrequest, CustomEventExtras customeventextras)
    {
        String s;
        com.google.ads.util.a.a(a);
        a = customeventserverparameters.label;
        String s1 = customeventserverparameters.className;
        s = customeventserverparameters.parameter;
        d = (CustomEventInterstitial)a(s1, com/google/ads/mediation/customevent/CustomEventInterstitial, a);
        if (d == null)
        {
            mediationinterstitiallistener.onFailedToReceiveAd(this, com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
        CustomEventInterstitial customeventinterstitial;
        b b1;
        String s2;
        customeventinterstitial = d;
        b1 = new b(mediationinterstitiallistener);
        s2 = a;
        if (customeventextras != null)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        customeventserverparameters = null;
_L1:
        try
        {
            customeventinterstitial.requestInterstitialAd(b1, activity, s2, s, mediationadrequest, customeventserverparameters);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            a("", activity);
        }
        mediationinterstitiallistener.onFailedToReceiveAd(this, com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR);
        return;
        customeventserverparameters = ((CustomEventServerParameters) (customeventextras.getExtra(a)));
          goto _L1
    }

    public void showInterstitial()
    {
        com.google.ads.util.a.b(d);
        try
        {
            d.showInterstitial();
            return;
        }
        catch (Throwable throwable)
        {
            com.google.ads.util.b.b((new StringBuilder()).append("Exception when showing custom event labeled '").append(a).append("'.").toString(), throwable);
        }
    }
}
