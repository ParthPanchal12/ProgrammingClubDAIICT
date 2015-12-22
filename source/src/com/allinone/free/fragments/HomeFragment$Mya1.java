// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.allinone.free.adapter.AppGridviewAdapter;
import com.allinone.free.db.TypeDbUtils;
import com.allinone.free.dialog.WebFirstDialog;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.mydownload.MyApplcation;
import com.allinone.free.utils.NetWorkUtil;
import com.allinone.free.utils.ProgressWheel;
import com.allinone.free.utils.publicTools;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.allinone.free.fragments:
//            HomeFragment

class this._cls0 extends AsyncTask
{

    final HomeFragment this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient ArrayList doInBackground(Void avoid[])
    {
        String s = null;
        avoid = publicTools.getUrl(HomeFragment.access$8(HomeFragment.this));
label0:
        {
            s = avoid;
            if (avoid == null)
            {
                return null;
            }
            break label0;
        }
        avoid;
        HomeFragment.access$9(HomeFragment.this, new ArrayList());
        if (s == null) goto _L2; else goto _L1
_L1:
        avoid = new JSONObject(s);
        if (avoid.getInt("status") != 1) goto _L2; else goto _L3
_L3:
        HomeFragment.access$10(HomeFragment.this, new DownloadMovieItem());
        int i;
        int j;
        try
        {
            if (HomeFragment.access$11(HomeFragment.this) == 1 && !avoid.isNull("pdt"))
            {
                JSONObject jsonobject = avoid.getJSONObject("pdt");
                HomeFragment.access$7(HomeFragment.this).setId(jsonobject.getString("id"));
                HomeFragment.access$7(HomeFragment.this).setIcon(jsonobject.getString("icon"));
                HomeFragment.access$7(HomeFragment.this).setTitle(jsonobject.getString("title"));
                HomeFragment.access$7(HomeFragment.this).setAuthor_title(jsonobject.getString("author_title"));
                HomeFragment.access$7(HomeFragment.this).setShort_desc(jsonobject.getString("short_desc"));
                HomeFragment.access$7(HomeFragment.this).setRating(Float.valueOf(Float.parseFloat(jsonobject.getString("rating"))));
                HomeFragment.access$7(HomeFragment.this).setSerial(jsonobject.getInt("serial"));
                HomeFragment.access$7(HomeFragment.this).setHas_apk(jsonobject.getString("has_apk"));
                HomeFragment.access$7(HomeFragment.this).setIs_official(jsonobject.getString("is_official"));
            }
        }
        catch (Exception exception) { }
        avoid = avoid.getJSONArray("list");
        i = 0;
_L5:
        j = avoid.length();
        if (i < j) goto _L4; else goto _L2
_L2:
        return HomeFragment.access$12(HomeFragment.this);
_L4:
        DownloadMovieItem downloadmovieitem = new DownloadMovieItem();
        JSONObject jsonobject1 = avoid.getJSONObject(i);
        downloadmovieitem.setId(jsonobject1.getString("id"));
        downloadmovieitem.setSerial(jsonobject1.getInt("serial"));
        downloadmovieitem.setTitle(jsonobject1.getString("title"));
        downloadmovieitem.setAuthor_title(jsonobject1.getString("author_title"));
        downloadmovieitem.setIcon(jsonobject1.getString("icon"));
        downloadmovieitem.setSize(jsonobject1.getString("size"));
        downloadmovieitem.setRating(Float.valueOf(Float.parseFloat(jsonobject1.getString("rating"))));
        downloadmovieitem.setPrice(jsonobject1.getString("price"));
        downloadmovieitem.setHas_apk(jsonobject1.getString("has_apk"));
        downloadmovieitem.setIs_official(jsonobject1.getString("is_official"));
        HomeFragment.access$12(HomeFragment.this).add(downloadmovieitem);
        i++;
          goto _L5
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
        return;
_L2:
        HomeFragment.access$13(HomeFragment.this, new AppGridviewAdapter(getActivity(), arraylist, "appgvhome"));
        HomeFragment.access$14(HomeFragment.this).setAdapter(HomeFragment.access$15(HomeFragment.this));
        HomeFragment.access$0(HomeFragment.this).setVisibility(8);
        HomeFragment.access$15(HomeFragment.this).notifyDataSetChanged();
        HomeFragment.access$16(HomeFragment.this).setVisibility(0);
        if (HomeFragment.access$11(HomeFragment.this) != 1) goto _L1; else goto _L3
_L3:
        Object obj;
        TextView textview;
        TextView textview1;
        RatingBar ratingbar;
        Button button;
        Button button1;
        final WebFirstDialog dialog1;
        dialog1 = new WebFirstDialog(getActivity(), 0x7f0c0064);
        dialog1.setCanceledOnTouchOutside(true);
        dialog1.show();
        obj = (ImageView)dialog1.findViewById(0x7f060217);
        textview = (TextView)dialog1.findViewById(0x7f060218);
        textview1 = (TextView)dialog1.findViewById(0x7f06021b);
        arraylist = (TextView)dialog1.findViewById(0x7f06021a);
        ratingbar = (RatingBar)dialog1.findViewById(0x7f06021c);
        button = (Button)dialog1.findViewById(0x7f06021d);
        button1 = (Button)dialog1.findViewById(0x7f06021e);
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeFragment.Mya1 this$1;
            private final WebFirstDialog val$dialog1;

            public void onClick(View view)
            {
                if (HomeFragment.access$17(this$0).getBoolean("isopen", false) && NetWorkUtil.getAPNType(getActivity()) != 1)
                {
                    HomeFragment.access$18(this$0);
                    return;
                }
                if (HomeFragment.access$19(this$0).queryfile(HomeFragment.access$7(this$0).getId()) == null)
                {
                    MydownloadApk(HomeFragment.access$7(this$0).getId(), HomeFragment.access$7(this$0).getTitle(), HomeFragment.access$7(this$0).getIcon(), HomeFragment.access$7(this$0).getSerial());
                } else
                {
                    HomeFragment.access$6(this$0);
                }
                dialog1.dismiss();
            }

            
            {
                this$1 = HomeFragment.Mya1.this;
                dialog1 = webfirstdialog;
                super();
            }
        });
        button1.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeFragment.Mya1 this$1;
            private final WebFirstDialog val$dialog1;

            public void onClick(View view)
            {
                view = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://play.google.com/store/apps/details?id=")).append(HomeFragment.access$7(this$0).getId()).toString()));
                startActivity(view);
                dialog1.dismiss();
            }

            
            {
                this$1 = HomeFragment.Mya1.this;
                dialog1 = webfirstdialog;
                super();
            }
        });
        dialog1 = HomeFragment.access$7(HomeFragment.this).getHas_apk();
        if (!dialog1.equals("1")) goto _L5; else goto _L4
_L4:
        button.setVisibility(0);
_L7:
        HomeFragment.access$20(HomeFragment.this).asyncLoadImage(HomeFragment.access$7(HomeFragment.this).getIcon(), ((ImageView) (obj)));
        textview.setText(HomeFragment.access$7(HomeFragment.this).getTitle());
        textview1.setText(HomeFragment.access$7(HomeFragment.this).getAuthor_title());
        ratingbar.setRating(HomeFragment.access$7(HomeFragment.this).getRating().floatValue());
        obj = HomeFragment.access$7(HomeFragment.this).getIs_official();
        if (((String) (obj)).equals("1"))
        {
            arraylist.setVisibility(0);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (dialog1.equals("0"))
        {
            button1.setVisibility(0);
        }
        if (true) goto _L7; else goto _L6
_L6:
        if (!((String) (obj)).equals("0")) goto _L1; else goto _L8
_L8:
        arraylist.setVisibility(8);
        return;
        arraylist;
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        HomeFragment.access$0(HomeFragment.this).setVisibility(0);
    }


    _cls2.val.dialog1()
    {
        this$0 = HomeFragment.this;
        super();
    }
}
