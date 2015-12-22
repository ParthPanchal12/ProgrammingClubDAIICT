// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;

import android.os.Handler;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.AdErrorCode;
import com.inmobi.monetization.internal.IMAdListener;
import com.inmobi.monetization.internal.NativeAd;
import com.inmobi.monetization.internal.NativeAdObject;
import java.util.Map;

// Referenced classes of package com.inmobi.monetization:
//            IMNative, IMErrorCode, IMNativeListener

class a
    implements Runnable
{

    final AdErrorCode a;
    final rorCode b;

    public void run()
    {
        if (IMNative.a(b.b) != null)
        {
            IMNative.a(b.b).onNativeRequestFailed(IMErrorCode.a(a));
        }
    }

    rorCode(rorCode rorcode, AdErrorCode aderrorcode)
    {
        b = rorcode;
        a = aderrorcode;
        super();
    }

    // Unreferenced inner class com/inmobi/monetization/IMNative$1

/* anonymous class */
    class IMNative._cls1
        implements IMAdListener
    {

        final IMNative a;

        public void onAdInteraction(Map map)
        {
        }

        public void onAdRequestFailed(AdErrorCode aderrorcode)
        {
            try
            {
                a.a.getHandler().post(new IMNative._cls1._cls1(this, aderrorcode));
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
                a.a.getHandler().post(new IMNative._cls1._cls2());
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
                a = imnative;
                super();
            }

        // Unreferenced inner class com/inmobi/monetization/IMNative$1$2

/* anonymous class */
        class IMNative._cls1._cls2
            implements Runnable
        {

            final IMNative._cls1 a;

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
                        a = IMNative._cls1.this;
                        super();
                    }
        }

    }

}
