// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.a;
import com.google.ads.internal.b;
import com.google.ads.internal.d;
import com.google.ads.internal.h;
import com.google.ads.internal.k;
import com.google.ads.util.AdUtil;
import com.google.ads.util.f;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.ads:
//            Ad, AdSize, AdRequest, n, 
//            AdActivity, AdListener, AppEventListener, SwipeableAdListener

public class AdView extends RelativeLayout
    implements Ad
{

    private static final a b;
    protected d a;

    public AdView(Activity activity, AdSize adsize, String s)
    {
        super(activity.getApplicationContext());
        try
        {
            a(activity, adsize, ((AttributeSet) (null)));
            b(activity, adsize, null);
            a(activity, adsize, s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            a(activity, s.c("Could not initialize AdView"), adsize, ((AttributeSet) (null)));
        }
        s.a("Could not initialize AdView");
    }

    protected AdView(Activity activity, AdSize aadsize[], String s)
    {
        this(activity, new AdSize(0, 0), s);
        a(aadsize);
    }

    public AdView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context, attributeset);
    }

    public AdView(Context context, AttributeSet attributeset, int i)
    {
        this(context, attributeset);
    }

    private void a(Activity activity, AdSize adsize, String s)
        throws b
    {
        FrameLayout framelayout;
        framelayout = new FrameLayout(activity);
        framelayout.setFocusable(false);
        a = new d(this, activity, adsize, s, framelayout, false);
        setGravity(17);
        activity = k.a(activity, a);
        if (activity != null)
        {
            try
            {
                activity.addView(framelayout, -2, -2);
                addView(activity, -2, -2);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Activity activity)
            {
                com.google.ads.util.b.a("Gestures disabled: Not supported on this version of Android.", activity);
            }
            break MISSING_BLOCK_LABEL_91;
        }
        addView(framelayout, -2, -2);
        return;
        addView(framelayout, -2, -2);
        return;
    }

    private void a(Context context, AttributeSet attributeset)
    {
        if (attributeset != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        Object obj1;
        obj = b("adSize", context, attributeset, true);
        obj1 = a(((String) (obj)));
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        if (obj1.length != 0) goto _L5; else goto _L4
_L4:
        throw new b((new StringBuilder()).append("Attribute \"adSize\" invalid: ").append(((String) (obj))).toString(), true);
        obj;
_L9:
        Object obj2 = ((b) (obj)).c("Could not initialize AdView");
        boolean flag;
        if (obj1 != null && obj1.length > 0)
        {
            obj1 = obj1[0];
        } else
        {
            obj1 = AdSize.BANNER;
        }
        a(context, ((String) (obj2)), ((AdSize) (obj1)), attributeset);
        ((b) (obj)).a("Could not initialize AdView");
        if (isInEditMode()) goto _L1; else goto _L6
_L6:
        ((b) (obj)).b("Could not initialize AdView");
        return;
_L5:
        if (!a("adUnitId", attributeset))
        {
            throw new b("Required XML attribute \"adUnitId\" missing", true);
        }
        if (isInEditMode())
        {
            a(context, "Ads by Google", -1, obj1[0], attributeset);
            return;
        }
        obj = b("adUnitId", context, attributeset, true);
        flag = a("loadAdOnCreate", context, attributeset, false);
        if (!(context instanceof Activity))
        {
            break MISSING_BLOCK_LABEL_333;
        }
        obj2 = (Activity)context;
        a(((Context) (obj2)), obj1[0], attributeset);
        b(((Context) (obj2)), obj1[0], attributeset);
        if (obj1.length != 1)
        {
            break MISSING_BLOCK_LABEL_308;
        }
        a(((Activity) (obj2)), obj1[0], ((String) (obj)));
_L8:
        if (!flag) goto _L1; else goto _L7
_L7:
        obj = c("testDevices", context, attributeset, false);
        if (((Set) (obj)).contains("TEST_EMULATOR"))
        {
            ((Set) (obj)).remove("TEST_EMULATOR");
            ((Set) (obj)).add(AdRequest.TEST_EMULATOR);
        }
        loadAd((new AdRequest()).setTestDevices(((Set) (obj))).setKeywords(c("keywords", context, attributeset, false)));
        return;
        a(((Activity) (obj2)), new AdSize(0, 0), ((String) (obj)));
        a(((AdSize []) (obj1)));
          goto _L8
          goto _L1
        throw new b("AdView was initialized with a Context that wasn't an Activity.", true);
        obj;
        obj1 = null;
          goto _L9
    }

    private void a(Context context, String s, AdSize adsize, AttributeSet attributeset)
    {
        com.google.ads.util.b.b(s);
        a(context, s, 0xffff0000, adsize, attributeset);
    }

    private transient void a(AdSize aadsize[])
    {
        AdSize aadsize1[] = new AdSize[aadsize.length];
        for (int i = 0; i < aadsize.length; i++)
        {
            aadsize1[i] = AdSize.createAdSize(aadsize[i], getContext());
        }

        a.i().n.a(aadsize1);
    }

    private boolean a(Context context, AdSize adsize, AttributeSet attributeset)
    {
        if (!AdUtil.c(context))
        {
            a(context, "You must have AdActivity declared in AndroidManifest.xml with configChanges.", adsize, attributeset);
            return false;
        } else
        {
            return true;
        }
    }

    private boolean a(String s, Context context, AttributeSet attributeset, boolean flag)
        throws b
    {
        String s1 = attributeset.getAttributeValue("http://schemas.android.com/apk/lib/com.google.ads", s);
        flag = attributeset.getAttributeBooleanValue("http://schemas.android.com/apk/lib/com.google.ads", s, flag);
        if (s1 != null)
        {
            attributeset = context.getPackageName();
            context = s1;
            if (s1.matches("^@([^:]+)\\:(.*)$"))
            {
                attributeset = s1.replaceFirst("^@([^:]+)\\:(.*)$", "$1");
                context = s1.replaceFirst("^@([^:]+)\\:(.*)$", "@$2");
            }
            if (context.startsWith("@bool/"))
            {
                String s2 = context.substring("@bool/".length());
                TypedValue typedvalue = new TypedValue();
                try
                {
                    getResources().getValue((new StringBuilder()).append(attributeset).append(":bool/").append(s2).toString(), typedvalue, true);
                }
                // Misplaced declaration of an exception variable
                catch (AttributeSet attributeset)
                {
                    throw new b((new StringBuilder()).append("Could not find resource for ").append(s).append(": ").append(context).toString(), true, attributeset);
                }
                if (typedvalue.type == 18)
                {
                    return typedvalue.data != 0;
                } else
                {
                    throw new b((new StringBuilder()).append("Resource ").append(s).append(" was not a boolean: ").append(typedvalue).toString(), true);
                }
            }
        }
        return flag;
    }

    private boolean a(String s, AttributeSet attributeset)
    {
        return attributeset.getAttributeValue("http://schemas.android.com/apk/lib/com.google.ads", s) != null;
    }

    private String b(String s, Context context, AttributeSet attributeset, boolean flag)
        throws b
    {
label0:
        {
            Object obj = attributeset.getAttributeValue("http://schemas.android.com/apk/lib/com.google.ads", s);
            attributeset = ((AttributeSet) (obj));
            if (obj != null)
            {
                String s1 = context.getPackageName();
                context = ((Context) (obj));
                if (((String) (obj)).matches("^@([^:]+)\\:(.*)$"))
                {
                    s1 = ((String) (obj)).replaceFirst("^@([^:]+)\\:(.*)$", "$1");
                    context = ((String) (obj)).replaceFirst("^@([^:]+)\\:(.*)$", "@$2");
                }
                attributeset = context;
                if (context.startsWith("@string/"))
                {
                    attributeset = context.substring("@string/".length());
                    obj = new TypedValue();
                    try
                    {
                        getResources().getValue((new StringBuilder()).append(s1).append(":string/").append(attributeset).toString(), ((TypedValue) (obj)), true);
                    }
                    // Misplaced declaration of an exception variable
                    catch (AttributeSet attributeset)
                    {
                        throw new b((new StringBuilder()).append("Could not find resource for ").append(s).append(": ").append(context).toString(), true, attributeset);
                    }
                    if (((TypedValue) (obj)).string == null)
                    {
                        break label0;
                    }
                    attributeset = ((TypedValue) (obj)).string.toString();
                }
            }
            if (flag && attributeset == null)
            {
                throw new b((new StringBuilder()).append("Required XML attribute \"").append(s).append("\" missing").toString(), true);
            } else
            {
                return attributeset;
            }
        }
        throw new b((new StringBuilder()).append("Resource ").append(s).append(" was not a string: ").append(obj).toString(), true);
    }

    private boolean b(Context context, AdSize adsize, AttributeSet attributeset)
    {
        if (!AdUtil.b(context))
        {
            a(context, "You must have INTERNET and ACCESS_NETWORK_STATE permissions in AndroidManifest.xml.", adsize, attributeset);
            return false;
        } else
        {
            return true;
        }
    }

    private Set c(String s, Context context, AttributeSet attributeset, boolean flag)
        throws b
    {
        context = b(s, context, attributeset, flag);
        s = new HashSet();
        if (context != null)
        {
            context = context.split(",");
            int j = context.length;
            for (int i = 0; i < j; i++)
            {
                attributeset = context[i].trim();
                if (attributeset.length() != 0)
                {
                    s.add(attributeset);
                }
            }

        }
        return s;
    }

    void a(Context context, String s, int i, AdSize adsize, AttributeSet attributeset)
    {
        AdSize adsize1 = adsize;
        if (adsize == null)
        {
            adsize1 = AdSize.BANNER;
        }
        adsize1 = AdSize.createAdSize(adsize1, context.getApplicationContext());
        if (getChildCount() == 0)
        {
            int j;
            if (attributeset == null)
            {
                adsize = new TextView(context);
            } else
            {
                adsize = new TextView(context, attributeset);
            }
            adsize.setGravity(17);
            adsize.setText(s);
            adsize.setTextColor(i);
            adsize.setBackgroundColor(0xff000000);
            if (attributeset == null)
            {
                s = new LinearLayout(context);
            } else
            {
                s = new LinearLayout(context, attributeset);
            }
            s.setGravity(17);
            if (attributeset == null)
            {
                attributeset = new LinearLayout(context);
            } else
            {
                attributeset = new LinearLayout(context, attributeset);
            }
            attributeset.setGravity(17);
            attributeset.setBackgroundColor(i);
            i = AdUtil.a(context, adsize1.getWidth());
            j = AdUtil.a(context, adsize1.getHeight());
            s.addView(adsize, i - 2, j - 2);
            attributeset.addView(s);
            addView(attributeset, i, j);
        }
    }

    AdSize[] a(String s)
    {
        String as[];
        AdSize aadsize[];
        int i;
        as = s.split(",");
        aadsize = new AdSize[as.length];
        i = 0;
_L9:
        if (i >= as.length)
        {
            break; /* Loop/switch isn't completed */
        }
        s = as[i].trim();
        if (!s.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$"))
        {
            break MISSING_BLOCK_LABEL_143;
        }
        s = s.split("[xX]");
        s[0] = s[0].trim();
        s[1] = s[1].trim();
        if (!"FULL_WIDTH".equals(s[0])) goto _L2; else goto _L1
_L1:
        int j = -1;
_L5:
        int l;
        boolean flag;
        try
        {
            flag = "AUTO_HEIGHT".equals(s[1]);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        if (!flag) goto _L4; else goto _L3
_L3:
        l = -2;
_L6:
        s = new AdSize(j, l);
_L7:
        if (s == null)
        {
            return null;
        }
        break MISSING_BLOCK_LABEL_250;
_L2:
        j = Integer.parseInt(s[0]);
          goto _L5
_L4:
        l = Integer.parseInt(s[1]);
          goto _L6
        if ("BANNER".equals(s))
        {
            s = AdSize.BANNER;
        } else
        if ("SMART_BANNER".equals(s))
        {
            s = AdSize.SMART_BANNER;
        } else
        if ("IAB_MRECT".equals(s))
        {
            s = AdSize.IAB_MRECT;
        } else
        if ("IAB_BANNER".equals(s))
        {
            s = AdSize.IAB_BANNER;
        } else
        if ("IAB_LEADERBOARD".equals(s))
        {
            s = AdSize.IAB_LEADERBOARD;
        } else
        if ("IAB_WIDE_SKYSCRAPER".equals(s))
        {
            s = AdSize.IAB_WIDE_SKYSCRAPER;
        } else
        {
            s = null;
        }
          goto _L7
        aadsize[i] = s;
        i++;
        if (true) goto _L9; else goto _L8
_L8:
        return aadsize;
    }

    public void destroy()
    {
        a.b();
    }

    public boolean isReady()
    {
        if (a == null)
        {
            return false;
        } else
        {
            return a.s();
        }
    }

    public boolean isRefreshing()
    {
        if (a == null)
        {
            return false;
        } else
        {
            return a.t();
        }
    }

    public void loadAd(AdRequest adrequest)
    {
        if (a != null)
        {
            if (isRefreshing())
            {
                a.f();
            }
            a.a(adrequest);
        }
    }

    protected void onMeasure(int i, int j)
    {
        if (!isInEditMode())
        {
            AdWebView adwebview = a.l();
            if (adwebview != null)
            {
                adwebview.setVisibility(0);
            }
        }
        super.onMeasure(i, j);
    }

    protected void onWindowVisibilityChanged(int i)
    {
        super.onWindowVisibilityChanged(i);
        while (isInEditMode() || !((h)a.i().g.a()).b() || i == 0 || a.i().l.a() == null || a.i().e.a() == null) 
        {
            return;
        }
        if (AdActivity.isShowing() && !AdActivity.leftApplication())
        {
            b.a((WebView)a.i().e.a(), "onopeninapp", null);
            return;
        } else
        {
            b.a((WebView)a.i().e.a(), "onleaveapp", null);
            return;
        }
    }

    public void setAdListener(AdListener adlistener)
    {
        a.i().o.a(adlistener);
    }

    protected void setAppEventListener(AppEventListener appeventlistener)
    {
        a.i().p.a(appeventlistener);
    }

    protected transient void setSupportedAdSizes(AdSize aadsize[])
    {
        if (a.i().n.a() == null)
        {
            com.google.ads.util.b.e("Warning: Tried to set supported ad sizes on a single-size AdView. AdSizes ignored. To create a multi-sized AdView, use an AdView constructor that takes in an AdSize[] array.");
            return;
        } else
        {
            a(aadsize);
            return;
        }
    }

    protected void setSwipeableEventListener(SwipeableAdListener swipeableadlistener)
    {
        a.i().q.a(swipeableadlistener);
    }

    public void stopLoading()
    {
        if (a != null)
        {
            a.C();
        }
    }

    static 
    {
        b = (a)a.a.b();
    }
}
