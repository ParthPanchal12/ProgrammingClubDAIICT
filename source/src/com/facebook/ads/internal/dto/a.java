// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.dto;

import com.facebook.ads.internal.server.AdPlacementType;
import org.json.JSONObject;

public class a
{

    public final AdPlacementType a;
    public String b;
    public JSONObject c;
    private boolean d;

    public a(AdPlacementType adplacementtype)
    {
        d = false;
        a = adplacementtype;
    }

    public void a(String s)
    {
        b = s;
    }

    public void a(JSONObject jsonobject)
    {
        c = jsonobject;
    }
}
