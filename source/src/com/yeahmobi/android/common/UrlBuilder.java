// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.common;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.yeahmobi.android.common.util.DateAndTime;
import com.yeahmobi.android.common.util.MathUtils;
import com.yeahmobi.android.common.util.Utils;
import java.text.SimpleDateFormat;

// Referenced classes of package com.yeahmobi.android.common:
//            GpsHelper, LocationService

public class UrlBuilder
{

    private int mAdNum;
    private long mAppId;
    private int mCallType;
    private ConnectivityManager mConnectivityManager;
    private Context mContext;
    private boolean mIsDebug;
    private boolean mIsFirstParam;
    private boolean mIsNGP;
    private Location mLocation;
    private LocationService.LocationAwareness mLocationAwareness;
    private int mLocationPrecision;
    private Float mMaxPkgSize;
    private Float mMinPkgSize;
    private String mPackageName;
    private int mShowType;
    private long mSlotId;
    private StringBuilder mStringBuilder;
    private TelephonyManager mTelephonyManager;

    public UrlBuilder(Context context)
    {
        mLocationAwareness = LocationService.LocationAwareness.NORMAL;
        mLocationPrecision = 6;
        mIsDebug = false;
        mAdNum = 1;
        mIsNGP = false;
        mCallType = 0;
        mShowType = 0;
        mContext = context;
        mTelephonyManager = (TelephonyManager)mContext.getSystemService("phone");
        mConnectivityManager = (ConnectivityManager)mContext.getSystemService("connectivity");
        mSlotId = 0L;
        mAppId = 0L;
    }

    private void addParam(String s, String s1)
    {
        if (s == null || s.length() == 0 || s1 == null || s1.length() == 0)
        {
            return;
        }
        if (mIsFirstParam)
        {
            mIsFirstParam = false;
            mStringBuilder.append("?");
        } else
        {
            mStringBuilder.append("&");
        }
        mStringBuilder.append(s);
        mStringBuilder.append("=");
        mStringBuilder.append(Uri.encode(s1));
    }

    private String getNetworkOperator()
    {
        String s1 = mTelephonyManager.getNetworkOperator();
        String s = s1;
        if (mTelephonyManager.getPhoneType() == 2)
        {
            s = s1;
            if (mTelephonyManager.getSimState() == 5)
            {
                s = mTelephonyManager.getSimOperator();
            }
        }
        return s;
    }

    private String getUdidFromContext(Context context)
    {
        String s = GpsHelper.getAdvertisingId(context);
        if (s != null)
        {
            return (new StringBuilder()).append("ifa:").append(s).toString();
        }
        context = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (context == null)
        {
            return "";
        } else
        {
            return Utils.sha1(context);
        }
    }

    public String buildUrlString()
    {
        mStringBuilder = new StringBuilder("http://native.ymtrack.com/search.php");
        mIsFirstParam = true;
        addParam("av", "1.0.0");
        addParam("sid", String.valueOf(mSlotId));
        addParam("aid", String.valueOf(mAppId));
        Object obj;
        String s;
        int i;
        if (mIsDebug)
        {
            addParam("dg", "1");
        } else
        {
            addParam("dg", "0");
        }
        addParam("sv", "1.5.4");
        addParam("udid", getUdidFromContext(mContext));
        if (GpsHelper.isLimitAdTrackingEnabled(mContext))
        {
            addParam("ilat", "1");
        } else
        {
            addParam("ilat", "0");
        }
        addParam("os", String.valueOf(1));
        addParam("osv", String.valueOf(android.os.Build.VERSION.SDK));
        addParam("dmf", Build.MANUFACTURER);
        addParam("dml", Build.MODEL);
        addParam("dpd", Build.PRODUCT);
        addParam("so", String.valueOf(mContext.getResources().getConfiguration().orientation));
        addParam("ds", String.valueOf(mContext.getResources().getDisplayMetrics().density));
        s = getNetworkOperator();
        if (s == null || TextUtils.isEmpty(s))
        {
            obj = "";
            s = "";
        } else
        {
            i = Math.min(3, s.length());
            if (s == null)
            {
                obj = "";
            } else
            {
                obj = s.substring(0, i);
            }
            if (s == null)
            {
                s = "";
            } else
            {
                s = s.substring(i);
            }
        }
        addParam("mcc", ((String) (obj)));
        addParam("mnc", s);
        addParam("icc", mTelephonyManager.getNetworkCountryIso());
        addParam("cn", mTelephonyManager.getNetworkOperatorName());
        i = 8;
        if (mContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0)
        {
            obj = mConnectivityManager.getActiveNetworkInfo();
            if (obj != null)
            {
                i = ((NetworkInfo) (obj)).getType();
            } else
            {
                i = 8;
            }
        }
        addParam("nt", String.valueOf(i));
        mLocation = LocationService.getLastKnownLocation(mContext, mLocationPrecision, mLocationAwareness);
        if (mLocation != null)
        {
            addParam("lat", String.valueOf(mLocation.getLatitude()));
            addParam("lot", String.valueOf(mLocation.getLongitude()));
            addParam("lac", (new StringBuilder()).append("").append((int)mLocation.getAccuracy()).toString());
        }
        obj = new SimpleDateFormat("Z");
        ((SimpleDateFormat) (obj)).setTimeZone(DateAndTime.localTimeZone());
        addParam("z", ((SimpleDateFormat) (obj)).format(DateAndTime.now()));
        addParam("adnum", String.valueOf(mAdNum));
        if (mPackageName != null)
        {
            addParam("pkg", mPackageName);
        }
        if (mMaxPkgSize != null)
        {
            addParam("hsz", String.valueOf(MathUtils.numberFormat2(mMaxPkgSize, 2)));
        }
        if (mMinPkgSize != null)
        {
            addParam("lsz", String.valueOf(MathUtils.numberFormat2(mMinPkgSize, 2)));
        }
        if (mIsNGP)
        {
            addParam("ngp", "1");
        }
        addParam("ct", String.valueOf(mCallType));
        addParam("st", String.valueOf(mShowType));
        return mStringBuilder.toString();
    }

    public int getAdNum()
    {
        return mAdNum;
    }

    public long getAppId()
    {
        return mAppId;
    }

    public float getMaxPkgSize()
    {
        return mMaxPkgSize.floatValue();
    }

    public float getMinPkgSize()
    {
        return mMinPkgSize.floatValue();
    }

    public String getPackageName()
    {
        return mPackageName;
    }

    public long getSlotId()
    {
        return mSlotId;
    }

    public boolean isDebug()
    {
        return mIsDebug;
    }

    public boolean isNGP()
    {
        return mIsNGP;
    }

    public void setAdNum(int i)
    {
        mAdNum = i;
    }

    public UrlBuilder setAppId(long l)
    {
        mAppId = l;
        return this;
    }

    public UrlBuilder setCallType(int i)
    {
        mCallType = i;
        return this;
    }

    public void setIsDebug(boolean flag)
    {
        mIsDebug = flag;
    }

    public void setIsNGP(boolean flag)
    {
        mIsNGP = flag;
    }

    public void setMaxPkgSize(float f)
    {
        mMaxPkgSize = Float.valueOf(f);
    }

    public void setMinPkgSize(float f)
    {
        mMinPkgSize = Float.valueOf(f);
    }

    public void setPackageName(String s)
    {
        mPackageName = s;
    }

    public UrlBuilder setShowType(int i)
    {
        mShowType = i;
        return this;
    }

    public UrlBuilder setSlotId(long l)
    {
        mSlotId = l;
        return this;
    }
}
