// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.common;

import android.util.Log;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.yeahmobi.android.common:
//            AbsAdTask, AdResponse, AdManager

public final class AdFetchTask extends AbsAdTask
{

    SoftReference mWeakAdManagerController;

    public AdFetchTask(AdManager admanager)
    {
        mWeakAdManagerController = new SoftReference(admanager);
    }

    private void handleSingleJson(JSONObject jsonobject, List list)
        throws JSONException
    {
        int i = 0;
        AdResponse adresponse = new AdResponse();
        String s;
        long l;
        boolean flag;
        if (jsonobject.has("ad_id"))
        {
            l = jsonobject.getLong("ad_id");
        } else
        {
            l = -1L;
        }
        adresponse.setId(l);
        if (jsonobject.has("preload"))
        {
            if (jsonobject.getInt("preload") == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        {
            flag = false;
        }
        adresponse.setPreload(flag);
        if (jsonobject.has("title"))
        {
            s = jsonobject.getString("title");
        } else
        {
            s = "";
        }
        adresponse.setTitle(s);
        if (jsonobject.has("main_content"))
        {
            s = jsonobject.getString("main_content");
        } else
        {
            s = "";
        }
        adresponse.setMainContent(s);
        if (jsonobject.has("main_image_url"))
        {
            s = jsonobject.getString("main_image_url");
        } else
        {
            s = "";
        }
        adresponse.setMainImageUrl(s);
        if (jsonobject.has("icon_image_url"))
        {
            s = jsonobject.getString("icon_image_url");
        } else
        {
            s = "";
        }
        adresponse.setIconImageUrl(s);
        if (jsonobject.has("impression_track_url"))
        {
            s = jsonobject.getString("impression_track_url");
        } else
        {
            s = "";
        }
        adresponse.setImpressionTrackUrl(s);
        if (jsonobject.has("click_track_url"))
        {
            s = jsonobject.getString("click_track_url");
        } else
        {
            s = "";
        }
        adresponse.setClickTrackUrl(s);
        if (jsonobject.has("click_record_url"))
        {
            s = jsonobject.getString("click_record_url");
        } else
        {
            s = "";
        }
        adresponse.setClickRecordUrl(s);
        if (jsonobject.has("conversion_track_url"))
        {
            s = jsonobject.getString("conversion_track_url");
        } else
        {
            s = "";
        }
        adresponse.setConversionTrackUrl(s);
        if (jsonobject.has("target_url"))
        {
            s = jsonobject.getString("target_url");
        } else
        {
            s = "";
        }
        adresponse.setTargetUrl(s);
        if (jsonobject.has("charge_type"))
        {
            i = jsonobject.getInt("charge_type");
        }
        adresponse.setChargeType(i);
        if (jsonobject.has("html_snippet"))
        {
            s = jsonobject.getString("html_snippet");
        } else
        {
            s = "";
        }
        adresponse.setHtmlSnippet(s);
        if (jsonobject.has("app_package_name"))
        {
            jsonobject = jsonobject.getString("app_package_name");
        } else
        {
            jsonobject = "";
        }
        adresponse.setPackageName(jsonobject);
        list.add(adresponse);
    }

    private List parseResponseBody(String s)
        throws Exception
    {
        s = (new JSONObject(s)).getJSONArray("ads");
        int j = s.length();
        ArrayList arraylist = new ArrayList(j);
        for (int i = 0; i < j; i++)
        {
            handleSingleJson(s.getJSONObject(i), arraylist);
        }

        return arraylist;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient List doInBackground(String as[])
    {
        Object obj = null;
        boolean flag;
        as = new HttpGet(as[0]);
        flag = isStateValid();
        if (!flag)
        {
            shutdownHttpClient();
            return null;
        }
        as = mHttpClient.execute(as);
        flag = isResponseValid(as);
        if (!flag)
        {
            shutdownHttpClient();
            return null;
        }
        as = as.getEntity();
        if (as == null) goto _L2; else goto _L1
_L1:
        as = readFromStream(as.getContent());
_L3:
        as = parseResponseBody(as);
        shutdownHttpClient();
_L4:
        return as;
_L2:
        as = "";
          goto _L3
        as;
        as.printStackTrace();
        Log.d("YeahMobi", (new StringBuilder()).append("Exception caught while loading ad: ").append(as).toString());
        shutdownHttpClient();
        as = obj;
          goto _L4
        as;
        shutdownHttpClient();
        throw as;
          goto _L3
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((List)obj);
    }

    protected void onPostExecute(List list)
    {
        AdManager admanager = (AdManager)mWeakAdManagerController.get();
        if (admanager == null)
        {
            Log.i("YeahMobi", "adManager is null!");
            return;
        }
        if (list == null || list.size() <= 0)
        {
            Log.i("YeahMobi", "adResponse is null or size error!");
            return;
        } else
        {
            admanager.setAdResponses(list);
            return;
        }
    }
}
