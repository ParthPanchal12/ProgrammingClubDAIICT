// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller;

import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.mraidimpl.AudioTriggerCallback;

// Referenced classes of package com.inmobi.re.controller:
//            JSUtilityController

class a
    implements AudioTriggerCallback
{

    final JSUtilityController a;

    public void audioLevel(double d)
    {
        a.imWebView.raiseMicEvent(d);
    }

    allback(JSUtilityController jsutilitycontroller)
    {
        a = jsutilitycontroller;
        super();
    }
}
