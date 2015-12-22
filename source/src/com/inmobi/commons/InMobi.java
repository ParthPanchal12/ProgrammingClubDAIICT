// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.location.Location;
import com.inmobi.commons.analytics.androidsdk.IMAdTracker;
import com.inmobi.commons.analytics.androidsdk.IMAdTrackerReceiver;
import com.inmobi.commons.analytics.events.AnalyticsEventsWrapper;
import com.inmobi.commons.cache.LocalCache;
import com.inmobi.commons.data.AppInfo;
import com.inmobi.commons.data.DemogInfo;
import com.inmobi.commons.data.DeviceInfo;
import com.inmobi.commons.data.LocationInfo;
import com.inmobi.commons.internal.ActivityRecognitionManager;
import com.inmobi.commons.internal.ApplicationFocusManager;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.ThinICE;
import com.inmobi.commons.uid.UID;
import java.util.Calendar;

// Referenced classes of package com.inmobi.commons:
//            IMIDType, EducationType, EthnicityType, GenderType, 
//            HasChildren, MaritalStatus, SexualOrientation

public final class InMobi
{
    public static final class LOG_LEVEL extends Enum
    {

        public static final LOG_LEVEL DEBUG;
        public static final LOG_LEVEL NONE;
        public static final LOG_LEVEL VERBOSE;
        private static final LOG_LEVEL b[];
        private final int a;

        public static LOG_LEVEL valueOf(String s)
        {
            return (LOG_LEVEL)Enum.valueOf(com/inmobi/commons/InMobi$LOG_LEVEL, s);
        }

        public static LOG_LEVEL[] values()
        {
            return (LOG_LEVEL[])b.clone();
        }

        public int getValue()
        {
            return a;
        }

        static 
        {
            NONE = new LOG_LEVEL("NONE", 0, 0);
            DEBUG = new LOG_LEVEL("DEBUG", 1, 1);
            VERBOSE = new LOG_LEVEL("VERBOSE", 2, 2);
            b = (new LOG_LEVEL[] {
                NONE, DEBUG, VERBOSE
            });
        }

        private LOG_LEVEL(String s, int i, int j)
        {
            super(s, i);
            a = j;
        }
    }


    public static final int EXCLUDE_FB_ID = 4;
    public static final int EXCLUDE_ODIN1 = 2;
    public static final int EXCLUDE_UM5_ID = 8;
    public static final int ID_DEVICE_NONE = 0;
    public static final int INCLUDE_DEFAULT = 1;
    private static String a = null;

    private InMobi()
    {
    }

    static String a()
    {
        return a;
    }

    private static void a(Context context, String s)
    {
        Context context1;
        if (context == null)
        {
            try
            {
                Log.debug("[InMobi]-4.5.5", "Application Context NULL");
                Log.debug("[InMobi]-4.5.5", "context cannot be null");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.internal("[InMobi]-4.5.5", "Exception in initialize", context);
            }
            break MISSING_BLOCK_LABEL_71;
        }
        context1 = context.getApplicationContext();
        if (!InternalSDKUtil.isInitializedSuccessfully())
        {
            InternalSDKUtil.resetMediaCache(context1);
        }
        InternalSDKUtil.setContext(context1);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        if (!"".equals(s.trim()))
        {
            break MISSING_BLOCK_LABEL_72;
        }
        Log.debug("[InMobi]-4.5.5", "appId cannot be blank");
        return;
        return;
        if (InternalSDKUtil.isInitializedSuccessfully())
        {
            ThinICE.start(context);
            return;
        }
        String s1;
        a = s.trim();
        InternalSDKUtil.getUserAgent();
        LocationInfo.collectLocationInfo();
        AppInfo.updateAppInfo();
        DeviceInfo.updateDeviceInfo();
        UID.getInstance().init();
        s1 = FileOperations.getPreferences(context.getApplicationContext(), "impref", "version");
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        if (s1.equals(getVersion()))
        {
            break MISSING_BLOCK_LABEL_153;
        }
        FileOperations.setPreferences(context.getApplicationContext(), "impref", "version", getVersion());
        LocalCache.reset();
        ThinICE.start(context);
        Log.debug("[InMobi]-4.5.5", "InMobi init successful");
        IMAdTracker.getInstance().init(context1, s);
        IMAdTracker.getInstance().reportAppDownloadGoal();
        ApplicationFocusManager.init(context);
        ApplicationFocusManager.addFocusChangedListener(new com.inmobi.commons.internal.ApplicationFocusManager.FocusChangedListener() {

            public void onFocusChanged(boolean flag)
            {
                if (flag)
                {
                    UID.getInstance().refresh();
                    LocationInfo.collectLocationInfo();
                    AnalyticsEventsWrapper.getInstance().startSession(InMobi.a(), null);
                    return;
                } else
                {
                    AnalyticsEventsWrapper.getInstance().endSession(null);
                    return;
                }
            }

        });
        AnalyticsEventsWrapper.getInstance().startSession(a, null);
        ActivityRecognitionManager.init(context.getApplicationContext());
        s = new IntentFilter();
        s.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        s.addAction("com.android.vending.INSTALL_REFERRER");
        s.addAction("com.inmobi.share.id");
        context.getApplicationContext().registerReceiver(new IMAdTrackerReceiver(), s);
        return;
    }

    public static void addIDType(IMIDType imidtype, String s)
    {
        DemogInfo.addIDType(imidtype, s);
    }

    public static String getAppId()
    {
        return a;
    }

    public static String getVersion()
    {
        return "4.5.5";
    }

    public static void initialize(Activity activity, String s)
    {
        a(activity, s);
    }

    public static void initialize(Context context, String s)
    {
        a(context, s);
    }

    public static void removeIDType(IMIDType imidtype)
    {
        DemogInfo.removeIDType(imidtype);
    }

    public static void setAge(int i)
    {
        DemogInfo.setAge(Integer.valueOf(i));
    }

    public static void setAreaCode(String s)
    {
        if (s != null && !"".equals(s.trim()))
        {
            DemogInfo.setAreaCode(s);
            return;
        } else
        {
            Log.debug("[InMobi]-4.5.5", "Area code cannot be null");
            return;
        }
    }

    public static void setCurrentLocation(Location location)
    {
        if (location != null)
        {
            DemogInfo.setCurrentLocation(location);
            return;
        } else
        {
            Log.debug("[InMobi]-4.5.5", "Location cannot be null");
            return;
        }
    }

    public static void setDateOfBirth(Calendar calendar)
    {
        if (calendar != null)
        {
            DemogInfo.setDateOfBirth(calendar);
            return;
        } else
        {
            Log.debug("[InMobi]-4.5.5", "Date Of Birth cannot be null");
            return;
        }
    }

    public static void setDeviceIDMask(int i)
    {
        DemogInfo.setDeviceIDMask(i);
        UID.getInstance().setPublisherDeviceIdMaskMap(i);
    }

    public static void setEducation(EducationType educationtype)
    {
        if (educationtype != null)
        {
            DemogInfo.setEducation(educationtype);
        }
    }

    public static void setEthnicity(EthnicityType ethnicitytype)
    {
        if (ethnicitytype != null)
        {
            DemogInfo.setEthnicity(ethnicitytype);
        }
    }

    public static void setGender(GenderType gendertype)
    {
        if (gendertype != null)
        {
            DemogInfo.setGender(gendertype);
        }
    }

    public static void setHasChildren(HasChildren haschildren)
    {
        if (haschildren != null)
        {
            DemogInfo.setHasChildren(haschildren);
        }
    }

    public static void setIncome(int i)
    {
        DemogInfo.setIncome(Integer.valueOf(i));
    }

    public static void setInterests(String s)
    {
        if (s != null && !"".equals(s.trim()))
        {
            DemogInfo.setInterests(s);
            return;
        } else
        {
            Log.debug("[InMobi]-4.5.5", "Interests cannot be null");
            return;
        }
    }

    public static void setLanguage(String s)
    {
        if (s != null && !"".equals(s.trim()))
        {
            DemogInfo.setLanguage(s);
            return;
        } else
        {
            Log.debug("[InMobi]-4.5.5", "Language cannot be null");
            return;
        }
    }

    public static void setLocationWithCityStateCountry(String s, String s1, String s2)
    {
        DemogInfo.setLocationWithCityStateCountry(s, s1, s2);
    }

    public static void setLogLevel(LOG_LEVEL log_level)
    {
        if (log_level == LOG_LEVEL.NONE)
        {
            Log.setInternalLogLevel(com.inmobi.commons.internal.Log.INTERNAL_LOG_LEVEL.NONE);
            return;
        }
        if (log_level == LOG_LEVEL.DEBUG)
        {
            Log.setInternalLogLevel(com.inmobi.commons.internal.Log.INTERNAL_LOG_LEVEL.DEBUG);
            return;
        }
        if (log_level == LOG_LEVEL.VERBOSE)
        {
            Log.setInternalLogLevel(com.inmobi.commons.internal.Log.INTERNAL_LOG_LEVEL.VERBOSE);
            return;
        } else
        {
            Log.setInternalLogLevel(com.inmobi.commons.internal.Log.INTERNAL_LOG_LEVEL.INTERNAL);
            return;
        }
    }

    public static void setMaritalStatus(MaritalStatus maritalstatus)
    {
        if (maritalstatus != null)
        {
            DemogInfo.setMaritalStatus(maritalstatus);
        }
    }

    public static void setPostalCode(String s)
    {
        if (s != null && !"".equals(s.trim()))
        {
            DemogInfo.setPostalCode(s);
            return;
        } else
        {
            Log.debug("[InMobi]-4.5.5", "Postal Code cannot be null");
            return;
        }
    }

    public static void setSexualOrientation(SexualOrientation sexualorientation)
    {
        if (sexualorientation != null)
        {
            DemogInfo.setSexualOrientation(sexualorientation);
        }
    }

}
