// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container.mraidimpl;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.webkit.URLUtil;
import com.inmobi.androidsdk.IMBrowserActivity;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.re.container.IMWebView;

public class MRAIDBasic
{

    private IMWebView a;
    private Activity b;

    public MRAIDBasic(IMWebView imwebview, Activity activity)
    {
        a = imwebview;
        b = activity;
    }

    static Activity a(MRAIDBasic mraidbasic)
    {
        return mraidbasic.b;
    }

    static IMWebView b(MRAIDBasic mraidbasic)
    {
        return mraidbasic.a;
    }

    public void getCurrentPosition()
    {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge F and I\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }

    public void getDefaultPosition()
    {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge F and I\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }

    public void open(String s)
    {
        if (!s.startsWith("http://") && (!s.contains("https") || s.contains("play.google.com") || s.contains("market.android.com") || s.contains("market%3A%2F%2F")))
        {
            break MISSING_BLOCK_LABEL_231;
        }
        if (!URLUtil.isValidUrl(s))
        {
            a.raiseError("Invalid url", "open");
            return;
        }
        Intent intent;
        intent = new Intent(b, com/inmobi/androidsdk/IMBrowserActivity);
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("IMWebView-> open:").append(s).toString());
        intent.putExtra("extra_url", s);
        intent.putExtra("extra_browser_type", 100);
        if (a.getStateVariable() == com.inmobi.re.container.IMWebView.ViewState.DEFAULT && !a.mIsInterstitialAd && !a.mWebViewIsBrowserActivity)
        {
            intent.putExtra("FIRST_INSTANCE", true);
        }
        IMBrowserActivity.setWebViewListener(a.mListener);
        try
        {
            b.startActivity(intent);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            try
            {
                a.raiseError("Invalid url", "open");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.debug("[InMobi]-[RE]-4.5.5", "Failed to perform mraid Open");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                a.raiseError("Invalid url", "open");
            }
            return;
        }
        if (!a.mWebViewIsBrowserActivity)
        {
            a.fireOnShowAdScreen();
            return;
        }
        break MISSING_BLOCK_LABEL_250;
        (new Thread(new Runnable(s) {

            final String a;
            final MRAIDBasic b;

            public void run()
            {
                String s1 = InternalSDKUtil.getFinalRedirectedUrl(a);
                if (s1 != null)
                {
                    Intent intent1 = new Intent();
                    intent1.setAction("android.intent.action.VIEW");
                    intent1.setData(Uri.parse(s1));
                    intent1.addFlags(0x10000000);
                    try
                    {
                        MRAIDBasic.a(b).startActivity(intent1);
                    }
                    catch (Exception exception)
                    {
                        MRAIDBasic.b(b).raiseError("Invalid url", "open");
                        return;
                    }
                    if (MRAIDBasic.b(b).mListener != null)
                    {
                        MRAIDBasic.b(b).mListener.onLeaveApplication();
                    }
                }
            }

            
            {
                b = MRAIDBasic.this;
                a = s;
                super();
            }
        })).start();
    }
}
