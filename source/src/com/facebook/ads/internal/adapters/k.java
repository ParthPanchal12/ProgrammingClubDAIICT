// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.adapters;

import android.content.Context;
import com.facebook.ads.AdError;
import com.facebook.ads.internal.util.b;
import com.facebook.ads.internal.util.f;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.facebook.ads.internal.adapters:
//            p, n, q

public class k extends p
{

    private Context a;
    private q b;
    private n c;

    public k()
    {
    }

    public void a(int i1)
    {
        if (c == null)
        {
            return;
        } else
        {
            c.a(i1);
            return;
        }
    }

    public void a(Context context, q q1, Map map)
    {
        c = n.a("com.facebook.ads.internal.adapters.FacebookNativeAdapter", (JSONObject)map.get("data"));
        a = context;
        b = q1;
        if (c == null || com.facebook.ads.internal.util.f.a(context, c))
        {
            b.a(this, AdError.NO_FILL);
            return;
        }
        if (b != null)
        {
            b.a(this);
        }
        b.a = c.p();
    }

    public void a(Map map)
    {
        if (c == null)
        {
            return;
        } else
        {
            c.a(map);
            return;
        }
    }

    public boolean a()
    {
        if (!m())
        {
            return false;
        } else
        {
            return c.l();
        }
    }

    public com.facebook.ads.NativeAd.Image b()
    {
        if (!m())
        {
            return null;
        } else
        {
            return c.d();
        }
    }

    public void b(Map map)
    {
        if (c == null)
        {
            return;
        } else
        {
            c.a(a, map);
            return;
        }
    }

    public com.facebook.ads.NativeAd.Image c()
    {
        if (!m())
        {
            return null;
        } else
        {
            return c.e();
        }
    }

    public String d()
    {
        if (!m())
        {
            return null;
        } else
        {
            return c.f();
        }
    }

    public String e()
    {
        if (!m())
        {
            return null;
        } else
        {
            return c.g();
        }
    }

    public String f()
    {
        if (!m())
        {
            return null;
        } else
        {
            return c.h();
        }
    }

    public String g()
    {
        if (!m())
        {
            return null;
        } else
        {
            return c.i();
        }
    }

    public String h()
    {
        if (!m())
        {
            return null;
        } else
        {
            return c.j();
        }
    }

    public com.facebook.ads.NativeAd.Rating i()
    {
        if (!m())
        {
            return null;
        } else
        {
            return c.k();
        }
    }

    public String j()
    {
        if (!m())
        {
            return null;
        } else
        {
            return c.m();
        }
    }

    public com.facebook.ads.NativeAd.Image k()
    {
        if (!m())
        {
            return null;
        } else
        {
            return c.n();
        }
    }

    public String l()
    {
        if (!m())
        {
            return null;
        } else
        {
            return c.o();
        }
    }

    public boolean m()
    {
        return c != null;
    }

    public void onDestroy()
    {
    }
}
