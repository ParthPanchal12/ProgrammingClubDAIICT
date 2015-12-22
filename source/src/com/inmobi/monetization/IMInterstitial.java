// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;

import android.app.Activity;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.AdErrorCode;
import com.inmobi.monetization.internal.IMAdListener;
import com.inmobi.monetization.internal.InterstitialAd;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.inmobi.monetization:
//            IMErrorCode, IMInterstitialListener, IMIncentivisedListener

public class IMInterstitial
{
    public static final class State extends Enum
    {

        public static final State ACTIVE;
        public static final State INIT;
        public static final State LOADING;
        public static final State READY;
        public static final State UNKNOWN;
        private static final State a[];

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/inmobi/monetization/IMInterstitial$State, s);
        }

        public static State[] values()
        {
            return (State[])a.clone();
        }

        static 
        {
            INIT = new State("INIT", 0);
            ACTIVE = new State("ACTIVE", 1);
            LOADING = new State("LOADING", 2);
            READY = new State("READY", 3);
            UNKNOWN = new State("UNKNOWN", 4);
            a = (new State[] {
                INIT, ACTIVE, LOADING, READY, UNKNOWN
            });
        }

        private State(String s, int j)
        {
            super(s, j);
        }
    }


    InterstitialAd a;
    boolean b;
    IMAdListener c = new IMAdListener() {

        final IMInterstitial a;

        public void onAdInteraction(Map map)
        {
            IMInterstitial.a(a, 105, null, map);
        }

        public void onAdRequestFailed(AdErrorCode aderrorcode)
        {
            IMInterstitial.a(a, State.INIT);
            IMInterstitial.a(a, 101, aderrorcode, null);
        }

        public void onAdRequestSucceeded()
        {
            IMInterstitial.a(a, State.READY);
            IMInterstitial.a(a, 100, null, null);
        }

        public void onDismissAdScreen()
        {
            IMInterstitial.a(a, State.INIT);
            IMInterstitial.a(a, 103, null, null);
        }

        public void onIncentCompleted(Map map)
        {
            IMInterstitial.a(a, 106, null, map);
        }

        public void onLeaveApplication()
        {
            IMInterstitial.a(a, 104, null, null);
        }

        public void onShowAdScreen()
        {
            IMInterstitial.a(a, State.ACTIVE);
            IMInterstitial.a(a, 102, null, null);
        }

            
            {
                a = IMInterstitial.this;
                super();
            }
    };
    private IMInterstitialListener d;
    private IMIncentivisedListener e;
    private long f;
    private Activity g;
    private State h;
    private String i;

    public IMInterstitial(Activity activity, long l)
    {
        f = -1L;
        h = State.INIT;
        i = null;
        b = false;
        g = activity;
        f = l;
        a();
    }

    public IMInterstitial(Activity activity, String s)
    {
        f = -1L;
        h = State.INIT;
        i = null;
        b = false;
        g = activity;
        i = s;
        a();
    }

    static State a(IMInterstitial iminterstitial, State state)
    {
        iminterstitial.h = state;
        return state;
    }

    static IMInterstitialListener a(IMInterstitial iminterstitial)
    {
        return iminterstitial.d;
    }

    private void a()
    {
        if (f > 0L)
        {
            a = new InterstitialAd(g, f);
        } else
        {
            a = new InterstitialAd(g, i);
        }
        a.setAdListener(c);
    }

    private void a(int j, AdErrorCode aderrorcode, Map map)
    {
        if (d == null)
        {
            return;
        } else
        {
            g.runOnUiThread(new Runnable(j, aderrorcode, map) {

                final int a;
                final AdErrorCode b;
                final Map c;
                final IMInterstitial d;

                public void run()
                {
                    a;
                    JVM INSTR tableswitch 100 106: default 48
                //                               100 61
                //                               101 78
                //                               102 119
                //                               103 102
                //                               104 136
                //                               105 153
                //                               106 174;
                       goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
                    Log.debug("[InMobi]-[Monetization]", b.toString());
_L10:
                    return;
_L2:
                    IMInterstitial.a(d).onInterstitialLoaded(d);
                    return;
_L3:
                    IMInterstitial.a(d).onInterstitialFailed(d, IMErrorCode.a(b));
                    return;
_L5:
                    IMInterstitial.a(d).onDismissInterstitialScreen(d);
                    return;
_L4:
                    IMInterstitial.a(d).onShowInterstitialScreen(d);
                    return;
_L6:
                    IMInterstitial.a(d).onLeaveApplication(d);
                    return;
_L7:
                    IMInterstitial.a(d).onInterstitialInteraction(d, c);
                    return;
_L8:
                    if (IMInterstitial.b(d) != null)
                    {
                        IMInterstitial.b(d).onIncentCompleted(d, c);
                        return;
                    }
                    if (true) goto _L10; else goto _L9
_L9:
                }

            
            {
                d = IMInterstitial.this;
                a = j;
                b = aderrorcode;
                c = map;
                super();
            }
            });
            return;
        }
    }

    static void a(IMInterstitial iminterstitial, int j, AdErrorCode aderrorcode, Map map)
    {
        iminterstitial.a(j, aderrorcode, map);
    }

    static IMIncentivisedListener b(IMInterstitial iminterstitial)
    {
        return iminterstitial.e;
    }

    public void destroy()
    {
    }

    public void disableHardwareAcceleration()
    {
        b = true;
    }

    public State getState()
    {
        return h;
    }

    public void loadInterstitial()
    {
        if (a != null)
        {
            if (h == State.LOADING)
            {
                IMErrorCode imerrorcode = IMErrorCode.INVALID_REQUEST;
                imerrorcode.setMessage("Ad download in progress. Your request cannot be processed at this time. Try again later.");
                Log.debug("[InMobi]-[Monetization]", "Ad download in progress. Your request cannot be processed at this time. Try again later.");
                d.onInterstitialFailed(this, imerrorcode);
                return;
            }
            if (h == State.ACTIVE)
            {
                IMErrorCode imerrorcode1 = IMErrorCode.INVALID_REQUEST;
                imerrorcode1.setMessage("Interstitial ad is in ACTIVE state. Try again after sometime.");
                Log.debug("[InMobi]-[Monetization]", "Interstitial ad is in ACTIVE state. Try again after sometime.");
                d.onInterstitialFailed(this, imerrorcode1);
                return;
            } else
            {
                h = State.LOADING;
                a.loadAd();
                return;
            }
        } else
        {
            IMErrorCode imerrorcode2 = IMErrorCode.INVALID_REQUEST;
            Log.debug("[InMobi]-[Monetization]", "Interstitial ad is in ACTIVE state. Try again after sometime.");
            d.onInterstitialFailed(this, imerrorcode2);
            return;
        }
    }

    public void setAppId(String s)
    {
        if (a != null)
        {
            a.setAppId(s);
        }
    }

    public void setIMIncentivisedListener(IMIncentivisedListener imincentivisedlistener)
    {
        e = imincentivisedlistener;
    }

    public void setIMInterstitialListener(IMInterstitialListener iminterstitiallistener)
    {
        d = iminterstitiallistener;
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

    public void setSlotId(long l)
    {
        if (a != null)
        {
            a.setSlotId(l);
        }
    }

    public void show()
    {
        if (a != null && h == State.READY)
        {
            a.show();
            return;
        } else
        {
            Log.debug("[InMobi]-[Monetization]", (new StringBuilder()).append("Interstitial ad is not in the 'READY' state. Current state: ").append(h).toString());
            return;
        }
    }

    public void show(long l)
    {
        if (a != null)
        {
            a.show(l);
        }
    }

    public void stopLoading()
    {
        if (a != null)
        {
            a.stopLoading();
        }
    }
}
