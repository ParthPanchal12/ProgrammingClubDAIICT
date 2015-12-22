// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.yeahmobi.android.common.util.AsyncTasks;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.yeahmobi.android.common:
//            UrlBuilder, AdClickHandler, GpsHelper, OnAdReceiveListener, 
//            AbsAdTask, AdFetchTask

public class AdManager
{
    protected static final class AdManagerGpsHelperListener
        implements GpsHelper.GpsHelperListener
    {

        private final SoftReference mControl;

        public void onFetchAdInfoCompleted()
        {
            String s = ((AdManager)mControl.get()).mUrlBuilder.buildUrlString();
            Log.d("YeahMobi", (new StringBuilder()).append("start to load ad url=").append(s).toString());
            if (((AdManager)mControl.get()).mAdFetchTask != null)
            {
                ((AdManager)mControl.get()).mAdFetchTask.cancel(true);
            }
            ((AdManager)mControl.get()).mAdFetchTask = new AdFetchTask((AdManager)mControl.get());
            try
            {
                AsyncTasks.safeExecuteOnExecutor(((AdManager)mControl.get()).mAdFetchTask, new String[] {
                    s
                });
                return;
            }
            catch (Exception exception)
            {
                Log.d("AdViewController", "Error executing AdFetchTask", exception);
            }
        }

        public AdManagerGpsHelperListener(AdManager admanager)
        {
            mControl = new SoftReference(admanager);
        }
    }


    private final AdClickHandler mAdClickHandler;
    private AbsAdTask mAdFetchTask;
    OnAdReceiveListener mAdReceiveListener;
    private List mAdResponses;
    private final Context mContext;
    private final GpsHelper.GpsHelperListener mGpsHelperListener = new AdManagerGpsHelperListener(this);
    private UrlBuilder mUrlBuilder;

    public AdManager(Context context)
    {
        mContext = context;
        mUrlBuilder = new UrlBuilder(context);
        mAdClickHandler = new AdClickHandler(context);
    }

    public static boolean checkExistApp(Context context, String s)
    {
        boolean flag1 = false;
        context = context.getPackageManager().getInstalledPackages(0).iterator();
        boolean flag;
        do
        {
            flag = flag1;
            if (!context.hasNext())
            {
                break;
            }
            if (!s.equalsIgnoreCase(((PackageInfo)context.next()).packageName))
            {
                continue;
            }
            flag = true;
            break;
        } while (true);
        return flag;
    }

    private boolean isNetworkAvailable()
    {
        NetworkInfo networkinfo;
        if (mContext.checkCallingPermission("android.permission.ACCESS_NETWORK_STATE") != -1)
        {
            if ((networkinfo = ((ConnectivityManager)mContext.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !networkinfo.isConnected())
            {
                return false;
            }
        }
        return true;
    }

    public int getAdNum()
    {
        return mUrlBuilder.getAdNum();
    }

    public List getAdResponses()
    {
        return mAdResponses;
    }

    public long getAppId()
    {
        return mUrlBuilder.getAppId();
    }

    public float getMaxPackageSize()
    {
        return mUrlBuilder.getMaxPkgSize();
    }

    public float getMinPackageSize()
    {
        return mUrlBuilder.getMinPkgSize();
    }

    public String getPackageName()
    {
        return mUrlBuilder.getPackageName();
    }

    public long getSlotId()
    {
        return mUrlBuilder.getSlotId();
    }

    public boolean isDebug()
    {
        return mUrlBuilder.isDebug();
    }

    public boolean isNGP()
    {
        return mUrlBuilder.isNGP();
    }

    public void loadAd()
    {
        if (0L == mUrlBuilder.getSlotId() || 0L == mUrlBuilder.getAppId())
        {
            Log.d("YeahMobi", "cannot load yeahmobi ads, because you forget set slotId or appId");
            return;
        }
        if (!isNetworkAvailable())
        {
            Log.d("YeahMobi", "Can't load an ad because there is no network connectivity.");
            return;
        } else
        {
            GpsHelper.asyncFetchAdvertisingInfoIfNotCached(mContext, mGpsHelperListener);
            return;
        }
    }

    public void setAdNum(int i)
    {
        mUrlBuilder.setAdNum(i);
    }

    public void setAdReceiveListener(OnAdReceiveListener onadreceivelistener)
    {
        mAdReceiveListener = onadreceivelistener;
    }

    public void setAdResponses(List list)
    {
        if (list == null)
        {
            Log.i("YeahMobi", "adResponse is null in setAdResponse of AdViewController");
        }
        mAdResponses = list;
        if (mAdReceiveListener != null)
        {
            mAdReceiveListener.onAdReceive(list);
        }
    }

    public void setAppId(long l)
    {
        mUrlBuilder.setAppId(l);
    }

    public void setCallType(int i)
    {
        mUrlBuilder.setCallType(i);
    }

    public void setIsDebug(boolean flag)
    {
        mUrlBuilder.setIsDebug(flag);
    }

    public void setIsNGP(boolean flag)
    {
        mUrlBuilder.setIsNGP(flag);
    }

    public void setMaxPackageSize(float f)
    {
        mUrlBuilder.setMaxPkgSize(f);
    }

    public void setMinPackageSize(float f)
    {
        mUrlBuilder.setMinPkgSize(f);
    }

    public void setPackageName(String s)
    {
        mUrlBuilder.setPackageName(s);
    }

    public void setShowType(int i)
    {
        mUrlBuilder.setShowType(i);
    }

    public void setSlotId(long l)
    {
        mUrlBuilder.setSlotId(l);
    }




/*
    static AbsAdTask access$102(AdManager admanager, AbsAdTask absadtask)
    {
        admanager.mAdFetchTask = absadtask;
        return absadtask;
    }

*/
}
