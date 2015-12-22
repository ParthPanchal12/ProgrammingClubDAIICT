// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.mydownload.MyApplcation;
import com.allinone.free.utils.ProgressWheel;
import com.allinone.free.utils.publicTools;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.allinone.free.activity:
//            AppDetailsActivity

class this._cls0 extends AsyncTask
{

    final AppDetailsActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient ArrayList doInBackground(Void avoid[])
    {
        avoid = (new StringBuilder("http://android.downloadatoz.com/_201409/market/app_detail_more.php?url_id=")).append(AppDetailsActivity.access$8(AppDetailsActivity.this)).toString();
        Log.e("www", avoid);
        avoid = publicTools.getUrl(avoid);
        if (avoid == null)
        {
            return null;
        }
        AppDetailsActivity.access$9(AppDetailsActivity.this, new ArrayList());
        avoid = new JSONObject(avoid);
        if (avoid.getInt("status") != 1) goto _L2; else goto _L1
_L1:
        AppDetailsActivity.access$10(AppDetailsActivity.this, new DownloadMovieItem());
        avoid = avoid.getJSONObject("pdt");
        AppDetailsActivity.access$7(AppDetailsActivity.this).setId(avoid.getString("id"));
        AppDetailsActivity.access$7(AppDetailsActivity.this).setTitle(avoid.getString("title"));
        AppDetailsActivity.access$7(AppDetailsActivity.this).setAuthor_title(avoid.getString("author_title"));
        AppDetailsActivity.access$7(AppDetailsActivity.this).setIcon(avoid.getString("icon"));
        AppDetailsActivity.access$7(AppDetailsActivity.this).setRating(Float.valueOf(Float.parseFloat(avoid.getString("rating"))));
        AppDetailsActivity.access$7(AppDetailsActivity.this).setVersion(avoid.getString("version"));
        AppDetailsActivity.access$7(AppDetailsActivity.this).setRelease_date(avoid.getString("release_date"));
        AppDetailsActivity.access$7(AppDetailsActivity.this).setDownloads(avoid.getString("downloads"));
        AppDetailsActivity.access$7(AppDetailsActivity.this).setSize(avoid.getString("size"));
        AppDetailsActivity.access$7(AppDetailsActivity.this).setPrice(avoid.getString("price"));
        AppDetailsActivity.access$7(AppDetailsActivity.this).setDetail(avoid.getString("detail"));
        AppDetailsActivity.access$7(AppDetailsActivity.this).setHas_apk(avoid.getString("has_apk"));
        AppDetailsActivity.access$7(AppDetailsActivity.this).setIs_official(avoid.getString("is_official"));
        AppDetailsActivity.access$7(AppDetailsActivity.this).setSerial(avoid.getInt("serial"));
        avoid = avoid.getJSONArray("screenshots");
        int i = 0;
_L4:
        int j = avoid.length();
        if (i < j) goto _L3; else goto _L2
_L2:
        return AppDetailsActivity.access$11(AppDetailsActivity.this);
_L3:
        DownloadMovieItem downloadmovieitem = new DownloadMovieItem();
        downloadmovieitem.setScreenshots(avoid.getString(i));
        AppDetailsActivity.access$11(AppDetailsActivity.this).add(downloadmovieitem);
        i++;
          goto _L4
        avoid;
        avoid.printStackTrace();
          goto _L2
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ArrayList)obj);
    }

    protected void onPostExecute(ArrayList arraylist)
    {
        super.onPostExecute(arraylist);
        if (arraylist != null) goto _L2; else goto _L1
_L1:
        AppDetailsActivity.access$0(AppDetailsActivity.this).setVisibility(8);
_L8:
        return;
_L2:
        AppDetailsActivity.access$12(AppDetailsActivity.this).setVisibility(0);
        AppDetailsActivity.access$13(AppDetailsActivity.this).setVisibility(0);
        AppDetailsActivity.access$14(AppDetailsActivity.this).setVisibility(0);
        AppDetailsActivity.access$15(AppDetailsActivity.this).setVisibility(0);
        AppDetailsActivity.access$16(AppDetailsActivity.this).setVisibility(0);
        AppDetailsActivity.access$17(AppDetailsActivity.this).setVisibility(0);
        AppDetailsActivity.access$18(AppDetailsActivity.this).asyncLoadImage(AppDetailsActivity.access$7(AppDetailsActivity.this).getIcon(), AppDetailsActivity.access$19(AppDetailsActivity.this));
        AppDetailsActivity.access$20(AppDetailsActivity.this).setText(AppDetailsActivity.access$7(AppDetailsActivity.this).getTitle());
        AppDetailsActivity.access$21(AppDetailsActivity.this).setText(AppDetailsActivity.access$7(AppDetailsActivity.this).getAuthor_title());
        AppDetailsActivity.access$22(AppDetailsActivity.this).setRating(AppDetailsActivity.access$7(AppDetailsActivity.this).getRating().floatValue());
        AppDetailsActivity.access$23(AppDetailsActivity.this).setText((new StringBuilder("Version:")).append(AppDetailsActivity.access$7(AppDetailsActivity.this).getVersion()).toString());
        AppDetailsActivity.access$24(AppDetailsActivity.this).setText(AppDetailsActivity.access$7(AppDetailsActivity.this).getRelease_date());
        AppDetailsActivity.access$25(AppDetailsActivity.this).setText(AppDetailsActivity.access$7(AppDetailsActivity.this).getSize());
        AppDetailsActivity.access$26(AppDetailsActivity.this).setText((new StringBuilder("Downloads:")).append(AppDetailsActivity.access$7(AppDetailsActivity.this).getDownloads()).toString());
        AppDetailsActivity.access$27(AppDetailsActivity.this).setText((new StringBuilder(String.valueOf(AppDetailsActivity.access$7(AppDetailsActivity.this).getDetail()))).append("\n").toString());
        AppDetailsActivity.access$20(AppDetailsActivity.this).setTypeface(AppDetailsActivity.access$28(AppDetailsActivity.this));
        AppDetailsActivity.access$21(AppDetailsActivity.this).setTypeface(AppDetailsActivity.access$29(AppDetailsActivity.this));
        arraylist = AppDetailsActivity.access$7(AppDetailsActivity.this).getIs_official();
        if (!arraylist.equals("1")) goto _L4; else goto _L3
_L3:
        AppDetailsActivity.access$30(AppDetailsActivity.this).setVisibility(0);
_L6:
        try
        {
            AppDetailsActivity.access$31(AppDetailsActivity.this).setAdapter(new GalleryAdapter(AppDetailsActivity.this, AppDetailsActivity.this));
            AppDetailsActivity.access$31(AppDetailsActivity.this).setSelection(1);
        }
        // Misplaced declaration of an exception variable
        catch (ArrayList arraylist) { }
        AppDetailsActivity.access$0(AppDetailsActivity.this).setVisibility(8);
        if (AppDetailsActivity.access$7(AppDetailsActivity.this).getHas_apk().equals("1"))
        {
            AppDetailsActivity.access$32(AppDetailsActivity.this).setVisibility(0);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (!arraylist.equals("0")) goto _L6; else goto _L5
_L5:
        AppDetailsActivity.access$30(AppDetailsActivity.this).setVisibility(8);
          goto _L6
        arraylist;
          goto _L6
        if (!AppDetailsActivity.access$7(AppDetailsActivity.this).getHas_apk().equals("0")) goto _L8; else goto _L7
_L7:
        AppDetailsActivity.access$33(AppDetailsActivity.this).setVisibility(0);
        return;
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        AppDetailsActivity.access$0(AppDetailsActivity.this).setVisibility(0);
    }

    GalleryAdapter()
    {
        this$0 = AppDetailsActivity.this;
        super();
    }
}
