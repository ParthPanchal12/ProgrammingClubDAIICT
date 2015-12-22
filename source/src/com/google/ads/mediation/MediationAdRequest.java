// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import com.google.ads.AdRequest;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

public class MediationAdRequest
{

    private AdRequest a;
    private boolean b;
    private boolean c;

    public MediationAdRequest(AdRequest adrequest, Context context, boolean flag)
    {
        a = adrequest;
        c = flag;
        if (context == null)
        {
            b = true;
            return;
        } else
        {
            b = adrequest.isTestDevice(context);
            return;
        }
    }

    public Integer getAgeInYears()
    {
        if (a.getBirthday() != null)
        {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar1 = Calendar.getInstance();
            calendar.setTime(a.getBirthday());
            Integer integer1 = Integer.valueOf(calendar1.get(1) - calendar.get(1));
            Integer integer = integer1;
            if (calendar1.get(6) < calendar.get(6))
            {
                integer = Integer.valueOf(integer1.intValue() - 1);
            }
            return integer;
        } else
        {
            return null;
        }
    }

    public Date getBirthday()
    {
        return a.getBirthday();
    }

    public com.google.ads.AdRequest.Gender getGender()
    {
        return a.getGender();
    }

    public Set getKeywords()
    {
        if (a.getKeywords() == null)
        {
            return null;
        } else
        {
            return Collections.unmodifiableSet(a.getKeywords());
        }
    }

    public Location getLocation()
    {
        if (a.getLocation() == null || !c)
        {
            return null;
        } else
        {
            return new Location(a.getLocation());
        }
    }

    public boolean isTesting()
    {
        return b;
    }
}
