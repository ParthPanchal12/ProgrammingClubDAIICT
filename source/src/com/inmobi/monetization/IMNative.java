// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;

import android.os.Handler;
import android.view.ViewGroup;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.AdErrorCode;
import com.inmobi.monetization.internal.IMAdListener;
import com.inmobi.monetization.internal.NativeAd;
import com.inmobi.monetization.internal.NativeAdObject;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.inmobi.monetization:
//            IMNativeListener, IMErrorCode

public class IMNative
{

    NativeAd a;
    private String b;
    private String c;
    private String d;
    private IMNativeListener e;
    private String f;
    private IMAdListener g = new IMAdListener() {

        final IMNative a;

        public void onAdInteraction(Map map)
        {
        }

        public void onAdRequestFailed(AdErrorCode aderrorcode)
        {
            try
            {
                a.a.getHandler().post(new Runnable(this, aderrorcode) {

                    final AdErrorCode a;
                    final _cls1 b;

                    public void run()
                    {
                        if (IMNative.a(b.a) != null)
                        {
                            IMNative.a(b.a).onNativeRequestFailed(IMErrorCode.a(a));
                        }
                    }

            
            {
                b = _pcls1;
                a = aderrorcode;
                super();
            }
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (AdErrorCode aderrorcode)
            {
                Log.debug("[InMobi]-[Monetization]", "Failed to give callback");
            }
        }

        public void onAdRequestSucceeded()
        {
            try
            {
                NativeAdObject nativeadobject = a.a.getNativeAdObject();
                IMNative.a(a, nativeadobject.getPubContent());
                IMNative.b(a, nativeadobject.getContextCode());
                IMNative.c(a, nativeadobject.getNameSpace());
                a.a.getHandler().post(new Runnable(this) {

                    final _cls1 a;

                    public void run()
                    {
                        try
                        {
                            if (IMNative.a(a.a) != null)
                            {
                                IMNative.a(a.a).onNativeRequestSucceeded(a.a);
                            }
                            return;
                        }
                        catch (Exception exception)
                        {
                            exception.printStackTrace();
                        }
                        Log.debug("[InMobi]-[Monetization]", "Failed to give callback");
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
                return;
            }
            catch (Exception exception)
            {
                Log.debug("[InMobi]-[Monetization]", "Failed to give callback");
            }
        }

        public void onDismissAdScreen()
        {
        }

        public void onIncentCompleted(Map map)
        {
        }

        public void onLeaveApplication()
        {
        }

        public void onShowAdScreen()
        {
        }

            
            {
                a = IMNative.this;
                super();
            }
    };

    public IMNative(IMNativeListener imnativelistener)
    {
        b = null;
        c = null;
        d = null;
        e = null;
        f = InMobi.getAppId();
        a(imnativelistener);
    }

    public IMNative(String s, IMNativeListener imnativelistener)
    {
        b = null;
        c = null;
        d = null;
        e = null;
        f = s;
        a(imnativelistener);
    }

    protected IMNative(String s, String s1, String s2)
    {
        b = null;
        c = null;
        d = null;
        e = null;
        b = s;
        c = s1;
        d = s2;
    }

    static IMNativeListener a(IMNative imnative)
    {
        return imnative.e;
    }

    static String a(IMNative imnative, String s)
    {
        imnative.b = s;
        return s;
    }

    private void a(IMNativeListener imnativelistener)
    {
        new NativeAdObject(null, null, null);
        e = imnativelistener;
        a = new NativeAd(f);
        a.setAdListener(g);
    }

    static String b(IMNative imnative, String s)
    {
        imnative.c = s;
        return s;
    }

    static String c(IMNative imnative, String s)
    {
        imnative.d = s;
        return s;
    }

    public void attachToView(ViewGroup viewgroup)
    {
        if (a != null)
        {
            a.attachToView(viewgroup, c, d);
        }
    }

    public void detachFromView()
    {
        if (a != null)
        {
            a.detachFromView();
        }
    }

    public String getContent()
    {
        return b;
    }

    public void handleClick(HashMap hashmap)
    {
        if (a != null)
        {
            a.handleClick(hashmap);
        }
    }

    public void loadAd()
    {
        if (a != null)
        {
            a.loadAd();
        }
    }

    public void setKeywords(String s)
    {
        if (s == null || "".equals(s.trim()))
        {
            Log.debug("[InMobi]-[Monetization]", "Keywords cannot be null or blank.");
        } else
        if (a != null)
        {
            a.setKeywords(s);
            return;
        }
    }

    public void setRefTagParam(String s, String s1)
    {
        if (s == null || s1 == null)
        {
            Log.debug("[InMobi]-[Monetization]", "Key or Value cannot be null");
        } else
        {
            if (s.trim().equals("") || s1.trim().equals(""))
            {
                Log.debug("[InMobi]-[Monetization]", "Key or Value cannot be empty");
                return;
            }
            HashMap hashmap = new HashMap();
            hashmap.put(s, s1);
            if (a != null)
            {
                a.setRequestParams(hashmap);
                return;
            }
        }
    }

    public void setRequestParams(Map map)
    {
        if (map == null || map.isEmpty())
        {
            Log.debug("[InMobi]-[Monetization]", "Request params cannot be null or empty.");
        } else
        if (a != null)
        {
            a.setRequestParams(map);
            return;
        }
    }
}
