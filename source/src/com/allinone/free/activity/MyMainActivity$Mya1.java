// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
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

// Referenced classes of package com.allinone.free.activity:
//            MyMainActivity

class this._cls0 extends AsyncTask
{

    final MyMainActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient ArrayList doInBackground(Void avoid[])
    {
        String s = null;
        avoid = publicTools.getUrl(MyMainActivity.access$21(MyMainActivity.this));
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
        MyMainActivity.access$22(MyMainActivity.this, new ArrayList());
        if (s == null) goto _L2; else goto _L1
_L1:
        avoid = new JSONObject(s);
        if (avoid.getInt("status") != 1) goto _L2; else goto _L3
_L3:
        MyMainActivity.access$23(MyMainActivity.this, new DownloadMovieItem());
        int i;
        int j;
        try
        {
            if (MyMainActivity.access$24(MyMainActivity.this) == 1 && !avoid.isNull("pdt"))
            {
                JSONObject jsonobject = avoid.getJSONObject("pdt");
                MyMainActivity.access$15(MyMainActivity.this).setId(jsonobject.getString("id"));
                MyMainActivity.access$15(MyMainActivity.this).setIcon(jsonobject.getString("icon"));
                MyMainActivity.access$15(MyMainActivity.this).setTitle(jsonobject.getString("title"));
                MyMainActivity.access$15(MyMainActivity.this).setAuthor_title(jsonobject.getString("author_title"));
                MyMainActivity.access$15(MyMainActivity.this).setShort_desc(jsonobject.getString("short_desc"));
                MyMainActivity.access$15(MyMainActivity.this).setRating(Float.valueOf(Float.parseFloat(jsonobject.getString("rating"))));
                MyMainActivity.access$15(MyMainActivity.this).setSerial(jsonobject.getInt("serial"));
                MyMainActivity.access$15(MyMainActivity.this).setHas_apk(jsonobject.getString("has_apk"));
                MyMainActivity.access$15(MyMainActivity.this).setIs_official(jsonobject.getString("is_official"));
            }
        }
        catch (Exception exception) { }
        avoid = avoid.getJSONArray("list");
        i = 0;
_L5:
        j = avoid.length();
        if (i < j) goto _L4; else goto _L2
_L2:
        return MyMainActivity.access$25(MyMainActivity.this);
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
        MyMainActivity.access$25(MyMainActivity.this).add(downloadmovieitem);
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
        if (MyMainActivity.access$24(MyMainActivity.this) != 1) goto _L1; else goto _L3
_L3:
        Object obj;
        TextView textview;
        TextView textview1;
        RatingBar ratingbar;
        Button button;
        Button button1;
        final WebFirstDialog dialog1;
        dialog1 = new WebFirstDialog(MyMainActivity.this, 0x7f0c0064);
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

            final MyMainActivity.Mya1 this$1;
            private final WebFirstDialog val$dialog1;

            public void onClick(View view)
            {
                if (MyMainActivity.access$26(this$0).getBoolean("isopen", false) && NetWorkUtil.getAPNType(this$0) != 1)
                {
                    MyMainActivity.access$27(this$0);
                    return;
                }
                if (MyMainActivity.access$28(this$0).queryfile(MyMainActivity.access$15(this$0).getId()) == null)
                {
                    MydownloadApk(MyMainActivity.access$15(this$0).getId(), MyMainActivity.access$15(this$0).getTitle(), MyMainActivity.access$15(this$0).getIcon(), MyMainActivity.access$15(this$0).getSerial());
                } else
                {
                    MyMainActivity.access$14(this$0);
                }
                dialog1.dismiss();
            }

            
            {
                this$1 = MyMainActivity.Mya1.this;
                dialog1 = webfirstdialog;
                super();
            }
        });
        button1.setOnClickListener(new android.view.View.OnClickListener() {

            final MyMainActivity.Mya1 this$1;
            private final WebFirstDialog val$dialog1;

            public void onClick(View view)
            {
                view = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://play.google.com/store/apps/details?id=")).append(MyMainActivity.access$15(this$0).getId()).toString()));
                startActivity(view);
                dialog1.dismiss();
            }

            
            {
                this$1 = MyMainActivity.Mya1.this;
                dialog1 = webfirstdialog;
                super();
            }
        });
        dialog1 = MyMainActivity.access$15(MyMainActivity.this).getHas_apk();
        if (!dialog1.equals("1")) goto _L5; else goto _L4
_L4:
        button.setVisibility(0);
_L7:
        MyMainActivity.access$29(MyMainActivity.this).asyncLoadImage(MyMainActivity.access$15(MyMainActivity.this).getIcon(), ((ImageView) (obj)));
        textview.setText(MyMainActivity.access$15(MyMainActivity.this).getTitle());
        textview1.setText(MyMainActivity.access$15(MyMainActivity.this).getAuthor_title());
        ratingbar.setRating(MyMainActivity.access$15(MyMainActivity.this).getRating().floatValue());
        obj = MyMainActivity.access$15(MyMainActivity.this).getIs_official();
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
        MyMainActivity.access$10(MyMainActivity.this).setVisibility(0);
    }


    _cls2.val.dialog1()
    {
        this$0 = MyMainActivity.this;
        super();
    }
}
