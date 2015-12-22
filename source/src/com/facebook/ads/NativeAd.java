// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.ads.internal.adapters.o;
import com.facebook.ads.internal.adapters.p;
import com.facebook.ads.internal.c;
import com.facebook.ads.internal.e;
import com.facebook.ads.internal.h;
import com.facebook.ads.internal.util.k;
import com.facebook.ads.internal.util.l;
import com.facebook.ads.internal.util.m;
import com.facebook.ads.internal.view.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

// Referenced classes of package com.facebook.ads:
//            Ad, AdListener, ImpressionListener

public class NativeAd
    implements Ad
{
    public static class Image
    {

        private final String a;
        private final int b;
        private final int c;

        public static Image fromJSONObject(JSONObject jsonobject)
        {
            String s1;
            if (jsonobject != null)
            {
                if ((s1 = jsonobject.optString("url")) != null)
                {
                    return new Image(s1, jsonobject.optInt("width", 0), jsonobject.optInt("height", 0));
                }
            }
            return null;
        }

        public int getHeight()
        {
            return c;
        }

        public String getUrl()
        {
            return a;
        }

        public int getWidth()
        {
            return b;
        }

        private Image(String s1, int i1, int j1)
        {
            a = s1;
            b = i1;
            c = j1;
        }
    }

    public static final class MediaCacheFlag extends Enum
    {

        public static final EnumSet ALL = EnumSet.allOf(com/facebook/ads/NativeAd$MediaCacheFlag);
        public static final MediaCacheFlag ICON;
        public static final MediaCacheFlag IMAGE;
        public static final MediaCacheFlag NONE;
        private static final MediaCacheFlag b[];
        private final long a;

        public static MediaCacheFlag valueOf(String s1)
        {
            return (MediaCacheFlag)Enum.valueOf(com/facebook/ads/NativeAd$MediaCacheFlag, s1);
        }

        public static MediaCacheFlag[] values()
        {
            return (MediaCacheFlag[])b.clone();
        }

        public long getCacheFlagValue()
        {
            return a;
        }

        static 
        {
            NONE = new MediaCacheFlag("NONE", 0, 0L);
            ICON = new MediaCacheFlag("ICON", 1, 1L);
            IMAGE = new MediaCacheFlag("IMAGE", 2, 2L);
            b = (new MediaCacheFlag[] {
                NONE, ICON, IMAGE
            });
        }

        private MediaCacheFlag(String s1, int i1, long l1)
        {
            super(s1, i1);
            a = l1;
        }
    }

    public static class Rating
    {

        private final double a;
        private final double b;

        public static Rating fromJSONObject(JSONObject jsonobject)
        {
            if (jsonobject != null)
            {
                double d1 = jsonobject.optDouble("value", 0.0D);
                double d2 = jsonobject.optDouble("scale", 0.0D);
                if (d1 != 0.0D && d2 != 0.0D)
                {
                    return new Rating(d1, d2);
                }
            }
            return null;
        }

        public double getScale()
        {
            return b;
        }

        public double getValue()
        {
            return a;
        }

        private Rating(double d1, double d2)
        {
            a = d1;
            b = d2;
        }
    }

    private class a
        implements android.view.View.OnClickListener, android.view.View.OnTouchListener
    {

        final NativeAd a;
        private int b;
        private int c;
        private int d;
        private int e;
        private float f;
        private float g;
        private int h;
        private int i;
        private boolean j;

        public Map a()
        {
            HashMap hashmap = new HashMap();
            hashmap.put("clickX", Integer.valueOf(b));
            hashmap.put("clickY", Integer.valueOf(c));
            hashmap.put("width", Integer.valueOf(d));
            hashmap.put("height", Integer.valueOf(e));
            hashmap.put("adPositionX", Float.valueOf(f));
            hashmap.put("adPositionY", Float.valueOf(g));
            hashmap.put("visibleWidth", Integer.valueOf(i));
            hashmap.put("visibleHeight", Integer.valueOf(h));
            return hashmap;
        }

        public void onClick(View view)
        {
            if (NativeAd.a(a) != null)
            {
                NativeAd.a(a).onAdClicked(a);
            }
            if (!j)
            {
                Log.e("FBAudienceNetworkLog", "No touch data recorded, please ensure touch events reach the ad View by returning false if you intercept the event.");
            }
            com.facebook.ads.NativeAd.e(a).b(a());
        }

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            boolean flag = false;
            if (motionevent.getAction() == 0 && com.facebook.ads.NativeAd.h(a) != null)
            {
                d = com.facebook.ads.NativeAd.h(a).getWidth();
                e = com.facebook.ads.NativeAd.h(a).getHeight();
                int ai[] = new int[2];
                com.facebook.ads.NativeAd.h(a).getLocationInWindow(ai);
                f = ai[0];
                g = ai[1];
                Rect rect = new Rect();
                com.facebook.ads.NativeAd.h(a).getGlobalVisibleRect(rect);
                i = rect.width();
                h = rect.height();
                int ai1[] = new int[2];
                view.getLocationInWindow(ai1);
                b = ((int)motionevent.getX() + ai1[0]) - ai[0];
                int i1 = (int)motionevent.getY();
                c = (ai1[1] + i1) - ai[1];
                j = true;
            }
            if (NativeAd.i(a) != null)
            {
                flag = NativeAd.i(a).onTouch(view, motionevent);
            }
            return flag;
        }

        private a()
        {
            a = NativeAd.this;
            super();
        }

    }

    private class b extends BroadcastReceiver
    {

        final NativeAd a;
        private boolean b;

        public void a()
        {
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction((new StringBuilder()).append("com.facebook.ads.native.impression:").append(com.facebook.ads.NativeAd.e(a).j()).toString());
            intentfilter.addAction((new StringBuilder()).append("com.facebook.ads.native.click:").append(com.facebook.ads.NativeAd.e(a).j()).toString());
            LocalBroadcastManager.getInstance(com.facebook.ads.NativeAd.c(a)).registerReceiver(this, intentfilter);
            b = true;
        }

        public void b()
        {
            if (!b)
            {
                return;
            }
            try
            {
                LocalBroadcastManager.getInstance(com.facebook.ads.NativeAd.c(a)).unregisterReceiver(this);
                return;
            }
            catch (Exception exception)
            {
                return;
            }
        }

        public void onReceive(Context context, Intent intent)
        {
            context = intent.getAction().split(":")[0];
            if ("com.facebook.ads.native.impression".equals(context))
            {
                NativeAd.f(a).a();
            } else
            if ("com.facebook.ads.native.click".equals(context))
            {
                context = new HashMap();
                context.put("mil", Boolean.valueOf(true));
                com.facebook.ads.NativeAd.e(a).b(context);
                return;
            }
        }

        private b()
        {
            a = NativeAd.this;
            super();
        }

    }

    private class c extends com.facebook.ads.internal.adapters.c
    {

        final NativeAd a;

        public boolean a()
        {
            return false;
        }

        public void b()
        {
            if (NativeAd.g(a) != null)
            {
                NativeAd.g(a).onLoggingImpression(a);
            }
            if ((NativeAd.a(a) instanceof ImpressionListener) && NativeAd.a(a) != NativeAd.g(a))
            {
                ((ImpressionListener)NativeAd.a(a)).onLoggingImpression(a);
            }
        }

        public void c()
        {
        }

        private c()
        {
            a = NativeAd.this;
            super();
        }

    }


    private static final com.facebook.ads.internal.c a;
    private static final String b = com/facebook/ads/NativeAd.getSimpleName();
    private static WeakHashMap c = new WeakHashMap();
    private final Context d;
    private final String e;
    private AdListener f;
    private ImpressionListener g;
    private h h;
    private volatile boolean i;
    private p j;
    private com.facebook.ads.internal.dto.c k;
    private View l;
    private List m;
    private android.view.View.OnTouchListener n;
    private com.facebook.ads.internal.adapters.e o;
    private o p;
    private a q;
    private b r;
    private com.facebook.ads.internal.view.k s;

    public NativeAd(Context context, p p1, com.facebook.ads.internal.dto.c c1)
    {
        this(context, null);
        k = c1;
        i = true;
        j = p1;
    }

    public NativeAd(Context context, String s1)
    {
        m = new ArrayList();
        d = context;
        e = s1;
    }

    NativeAd(NativeAd nativead)
    {
        this(nativead.d, null);
        k = nativead.k;
        i = true;
        j = nativead.j;
    }

    static AdListener a(NativeAd nativead)
    {
        return nativead.f;
    }

    static p a(NativeAd nativead, p p1)
    {
        nativead.j = p1;
        return p1;
    }

    private void a()
    {
        View view;
        for (Iterator iterator = m.iterator(); iterator.hasNext(); view.setOnTouchListener(null))
        {
            view = (View)iterator.next();
            view.setOnClickListener(null);
        }

        m.clear();
    }

    private void a(View view)
    {
        m.add(view);
        view.setOnClickListener(q);
        view.setOnTouchListener(q);
    }

    private void a(List list, View view)
    {
        list.add(view);
        if (view instanceof ViewGroup)
        {
            view = (ViewGroup)view;
            for (int i1 = 0; i1 < view.getChildCount(); i1++)
            {
                a(list, view.getChildAt(i1));
            }

        }
    }

    static h b(NativeAd nativead)
    {
        return nativead.h;
    }

    private void b()
    {
        if (j != null && j.a())
        {
            r = new b();
            r.a();
            p = new o(d, new com.facebook.ads.internal.adapters.c() {

                final NativeAd a;

                public boolean a()
                {
                    return true;
                }

            
            {
                a = NativeAd.this;
                super();
            }
            }, j);
        }
    }

    static Context c(NativeAd nativead)
    {
        return nativead.d;
    }

    static void d(NativeAd nativead)
    {
        nativead.b();
    }

    public static void downloadAndDisplayImage(Image image, ImageView imageview)
    {
        if (image != null && imageview != null)
        {
            (new k(imageview)).execute(new String[] {
                image.getUrl()
            });
        }
    }

    static p e(NativeAd nativead)
    {
        return nativead.j;
    }

    static o f(NativeAd nativead)
    {
        return nativead.p;
    }

    static ImpressionListener g(NativeAd nativead)
    {
        return nativead.g;
    }

    static View h(NativeAd nativead)
    {
        return nativead.l;
    }

    static android.view.View.OnTouchListener i(NativeAd nativead)
    {
        return nativead.n;
    }

    public void destroy()
    {
        if (r != null)
        {
            r.b();
            r = null;
        }
        if (h != null)
        {
            h.e();
            h = null;
        }
    }

    public String getAdBody()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return j.f();
        }
    }

    public String getAdCallToAction()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return j.g();
        }
    }

    public Image getAdChoicesIcon()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return j.k();
        }
    }

    public String getAdChoicesLinkUrl()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return j.l();
        }
    }

    public Image getAdCoverImage()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return j.c();
        }
    }

    public Image getAdIcon()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return j.b();
        }
    }

    public String getAdSocialContext()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return j.h();
        }
    }

    public Rating getAdStarRating()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return j.i();
        }
    }

    public String getAdSubtitle()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return j.e();
        }
    }

    public String getAdTitle()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return j.d();
        }
    }

    public String getId()
    {
        if (!isAdLoaded())
        {
            return null;
        } else
        {
            return j.j();
        }
    }

    public boolean isAdLoaded()
    {
        return j != null;
    }

    public void loadAd()
    {
        loadAd(EnumSet.of(MediaCacheFlag.NONE));
    }

    public void loadAd(EnumSet enumset)
    {
        if (i)
        {
            throw new IllegalStateException("loadAd cannot be called more than once");
        } else
        {
            i = true;
            e e1 = e.i;
            h = new h(d, e, e1, null, a, 1);
            h.a(new com.facebook.ads.internal.a(enumset) {

                final EnumSet a;
                final NativeAd b;

                public void a()
                {
                    if (NativeAd.b(b) != null)
                    {
                        NativeAd.b(b).d();
                    }
                }

                public void a(p p1)
                {
                    if (p1 == null)
                    {
                        return;
                    }
                    ArrayList arraylist = new ArrayList(2);
                    if (a.contains(MediaCacheFlag.ICON) && p1.b() != null)
                    {
                        arraylist.add(p1.b().getUrl());
                    }
                    if (a.contains(MediaCacheFlag.IMAGE) && p1.c() != null)
                    {
                        arraylist.add(p1.c().getUrl());
                    }
                    com.facebook.ads.internal.util.m.a(com.facebook.ads.NativeAd.c(b), arraylist, new l(this, p1) {

                        final p a;
                        final _cls1 b;

                        public void a()
                        {
                            NativeAd.a(b.b, a);
                            NativeAd.d(b.b);
                            if (NativeAd.a(b.b) != null)
                            {
                                NativeAd.a(b.b).onAdLoaded(b.b);
                            }
                        }

            
            {
                b = _pcls1;
                a = p1;
                super();
            }
                    });
                }

                public void a(com.facebook.ads.internal.b b1)
                {
                    if (NativeAd.a(b) != null)
                    {
                        NativeAd.a(b).onError(b, b1.b());
                    }
                }

                public void b()
                {
                    if (NativeAd.a(b) != null)
                    {
                        NativeAd.a(b).onAdClicked(b);
                    }
                }

                public void c()
                {
                    throw new IllegalStateException("Native ads manager their own impressions.");
                }

            
            {
                b = NativeAd.this;
                a = enumset;
                super();
            }
            });
            h.c();
            return;
        }
    }

    public void registerViewForInteraction(View view)
    {
        ArrayList arraylist = new ArrayList();
        a(arraylist, view);
        registerViewForInteraction(view, ((List) (arraylist)));
    }

    public void registerViewForInteraction(View view, List list)
    {
        boolean flag;
        if (view == null)
        {
            throw new IllegalArgumentException("Must provide a View");
        }
        if (list == null || list.size() == 0)
        {
            throw new IllegalArgumentException("Invalid set of clickable views");
        }
        if (!isAdLoaded())
        {
            Log.e(b, "Ad not loaded");
            return;
        }
        if (l != null)
        {
            Log.w(b, "Native Ad was already registered with a View. Auto unregistering and proceeding.");
            unregisterView();
        }
        if (c.containsKey(view))
        {
            Log.w(b, "View already registered with a NativeAd. Auto unregistering and proceeding.");
            ((NativeAd)((WeakReference)c.get(view)).get()).unregisterView();
        }
        q = new a();
        l = view;
        if (view instanceof ViewGroup)
        {
            s = new com.facebook.ads.internal.view.k(view.getContext(), new j() {

                final NativeAd a;

                public void a(int j1)
                {
                    if (com.facebook.ads.NativeAd.e(a) != null)
                    {
                        com.facebook.ads.NativeAd.e(a).a(j1);
                    }
                }

            
            {
                a = NativeAd.this;
                super();
            }
            });
            ((ViewGroup)view).addView(s);
        }
        for (list = list.iterator(); list.hasNext(); a((View)list.next())) { }
        p = new o(d, new c(), j);
        flag = true;
        if (k == null) goto _L2; else goto _L1
_L1:
        int i1 = k.e();
_L4:
        o = new com.facebook.ads.internal.adapters.e(d, l, i1, new com.facebook.ads.internal.adapters.e.a() {

            final NativeAd a;

            public void a()
            {
                NativeAd.f(a).a();
            }

            
            {
                a = NativeAd.this;
                super();
            }
        });
        o.a();
        c.put(view, new WeakReference(this));
        return;
_L2:
        i1 = ((flag) ? 1 : 0);
        if (h != null)
        {
            i1 = ((flag) ? 1 : 0);
            if (h.b() != null)
            {
                i1 = h.b().e();
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setAdListener(AdListener adlistener)
    {
        f = adlistener;
    }

    public void setImpressionListener(ImpressionListener impressionlistener)
    {
        g = impressionlistener;
    }

    public void setOnTouchListener(android.view.View.OnTouchListener ontouchlistener)
    {
        n = ontouchlistener;
    }

    public void unregisterView()
    {
        if (l == null)
        {
            return;
        }
        if (!c.containsKey(l) || ((WeakReference)c.get(l)).get() != this)
        {
            throw new IllegalStateException("View not registered with this NativeAd");
        }
        if ((l instanceof ViewGroup) && s != null)
        {
            ((ViewGroup)l).removeView(s);
            s = null;
        }
        c.remove(l);
        a();
        l = null;
        if (o != null)
        {
            o.b();
            o = null;
        }
        p = null;
    }

    static 
    {
        a = com.facebook.ads.internal.c.a;
    }
}
