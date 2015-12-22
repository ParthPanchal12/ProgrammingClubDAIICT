// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.data;

import android.location.Location;
import com.inmobi.commons.EducationType;
import com.inmobi.commons.EthnicityType;
import com.inmobi.commons.GenderType;
import com.inmobi.commons.HasChildren;
import com.inmobi.commons.IMIDType;
import com.inmobi.commons.MaritalStatus;
import com.inmobi.commons.SexualOrientation;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.analytics.bootstrapper.AutomaticCaptureConfig;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public final class DemogInfo
{

    private static int a = 1;
    private static Location b;
    private static EducationType c;
    private static EthnicityType d;
    private static GenderType e;
    private static Calendar f;
    private static Integer g = Integer.valueOf(0);
    private static Integer h = Integer.valueOf(0);
    private static String i;
    private static String j;
    private static String k;
    private static String l;
    private static HasChildren m;
    private static MaritalStatus n;
    private static String o;
    private static SexualOrientation p;
    private static Map q = new HashMap();

    public DemogInfo()
    {
    }

    public static void addIDType(IMIDType imidtype, String s)
    {
        if (q != null)
        {
            q.put(imidtype, s);
        }
    }

    public static Integer getAge()
    {
        return h;
    }

    public static String getAreaCode()
    {
        return l;
    }

    public static Location getCurrentLocation()
    {
        return b;
    }

    public static Calendar getDateOfBirth()
    {
        return f;
    }

    public static int getDeviceIDMask()
    {
        return a;
    }

    public static EducationType getEducation()
    {
        return c;
    }

    public static EthnicityType getEthnicity()
    {
        return d;
    }

    public static GenderType getGender()
    {
        return e;
    }

    public static HasChildren getHasChildren()
    {
        return m;
    }

    public static String getIDType(IMIDType imidtype)
    {
        if (q != null)
        {
            return (String)q.get(imidtype);
        } else
        {
            return null;
        }
    }

    public static Integer getIncome()
    {
        return g;
    }

    public static String getInterests()
    {
        return i;
    }

    public static String getLanguage()
    {
        return o;
    }

    public static String getLocationWithCityStateCountry()
    {
        return j;
    }

    public static MaritalStatus getMaritalStatus()
    {
        return n;
    }

    public static String getPostalCode()
    {
        return k;
    }

    public static SexualOrientation getSexualOrientation()
    {
        return p;
    }

    public static boolean isLocationInquiryAllowed()
    {
        return AnalyticsInitializer.getConfigParams().getAutomaticCapture().isAutoLocationCaptureEnabled();
    }

    public static void removeIDType(IMIDType imidtype)
    {
        if (q != null)
        {
            q.remove(imidtype);
        }
    }

    public static void setAge(Integer integer)
    {
        h = integer;
    }

    public static void setAreaCode(String s)
    {
        l = s;
    }

    public static void setCurrentLocation(Location location)
    {
        b = location;
    }

    public static void setDateOfBirth(Calendar calendar)
    {
        f = calendar;
    }

    public static void setDeviceIDMask(int i1)
    {
        a = i1;
    }

    public static void setEducation(EducationType educationtype)
    {
        c = educationtype;
    }

    public static void setEthnicity(EthnicityType ethnicitytype)
    {
        d = ethnicitytype;
    }

    public static void setGender(GenderType gendertype)
    {
        e = gendertype;
    }

    public static void setHasChildren(HasChildren haschildren)
    {
        m = haschildren;
    }

    public static void setIncome(Integer integer)
    {
        g = integer;
    }

    public static void setInterests(String s)
    {
        i = s;
    }

    public static void setLanguage(String s)
    {
        o = s;
    }

    public static void setLocationWithCityStateCountry(String s, String s1, String s2)
    {
        if (s != null && !"".equals(s.trim()))
        {
            j = s;
        }
        if (s1 != null && !"".equals(s1.trim()))
        {
            j = (new StringBuilder()).append(j).append("-").append(s1).toString();
        }
        if (s2 != null && !"".equals(s2.trim()))
        {
            j = (new StringBuilder()).append(j).append("-").append(s2).toString();
        }
    }

    public static void setMaritalStatus(MaritalStatus maritalstatus)
    {
        n = maritalstatus;
    }

    public static void setPostalCode(String s)
    {
        k = s;
    }

    public static void setSexualOrientation(SexualOrientation sexualorientation)
    {
        p = sexualorientation;
    }

}
