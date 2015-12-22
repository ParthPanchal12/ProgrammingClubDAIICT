// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.allinone.free.utils.ImageUtil;
import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.IMNative;
import com.inmobi.monetization.IMNativeListener;
import java.util.Locale;
import org.json.JSONObject;

// Referenced classes of package com.allinone.free.activity:
//            MyMainActivity

class this._cls1
    implements android.view.
{

    final is._cls0 this$1;

    public void onClick(View view)
    {
        view = new Intent("android.intent.action.VIEW", Uri.parse(wnloadurl));
        startActivity(view);
        if (MyMainActivity.access$45(_fld0) != null)
        {
            MyMainActivity.access$45(_fld0).handleClick(null);
        }
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/allinone/free/activity/MyMainActivity$15

/* anonymous class */
    class MyMainActivity._cls15
        implements IMNativeListener
    {

        private String downloadurl;
        final MyMainActivity this$0;

        public void onNativeRequestFailed(IMErrorCode imerrorcode)
        {
            Log.e("ppp", (new StringBuilder("errorCode=")).append(imerrorcode.name()).toString());
            MyMainActivity.access$36(MyMainActivity.this).setVisibility(8);
        }

        public void onNativeRequestSucceeded(IMNative imnative)
        {
            if (getResources().getConfiguration().locale.getCountry().equals("US") || getResources().getConfiguration().locale.getCountry().equals("ID"))
            {
                MyMainActivity.access$36(MyMainActivity.this).setVisibility(0);
            }
            MyMainActivity.access$37(MyMainActivity.this, imnative);
            if (imnative != null)
            {
                imnative.attachToView(MyMainActivity.access$36(MyMainActivity.this));
            }
            imnative = imnative.getContent();
            Log.e("ppp", imnative);
            try
            {
                imnative = new JSONObject(imnative);
                String s = imnative.getString("screenshots");
                downloadurl = imnative.getString("landingURL");
                imnative = (new JSONObject(s)).getString("url");
                if (!imnative.equals(""))
                {
                    String s1 = ImageUtil.getCacheImgPath().concat(ImageUtil.md5(imnative));
                    MyMainActivity.access$43(MyMainActivity.this, ImageUtil.loadImage(s1, imnative, new MyMainActivity._cls15._cls1(), 0));
                    if (MyMainActivity.access$44(MyMainActivity.this) != null)
                    {
                        MyMainActivity.access$39(MyMainActivity.this, MyMainActivity.access$44(MyMainActivity.this).getWidth());
                        MyMainActivity.access$40(MyMainActivity.this, MyMainActivity.access$44(MyMainActivity.this).getHeight());
                        imnative = new android.widget.LinearLayout.LayoutParams(-1, getHeight(MyMainActivity.access$41(MyMainActivity.this), MyMainActivity.access$42(MyMainActivity.this)));
                        MyMainActivity.access$38(MyMainActivity.this).setLayoutParams(imnative);
                        MyMainActivity.access$38(MyMainActivity.this).setImageBitmap(MyMainActivity.access$44(MyMainActivity.this));
                    }
                }
                MyMainActivity.access$38(MyMainActivity.this).setOnClickListener(new MyMainActivity._cls15._cls2());
            }
            // Misplaced declaration of an exception variable
            catch (IMNative imnative)
            {
                imnative.printStackTrace();
            }
            Log.e("ppp", "success");
        }



            
            {
                this$0 = MyMainActivity.this;
                super();
            }

        // Unreferenced inner class com/allinone/free/activity/MyMainActivity$15$1

/* anonymous class */
        class MyMainActivity._cls15._cls1
            implements com.allinone.free.utils.ImageUtil.ImageCallback
        {

            final MyMainActivity._cls15 this$1;

            public void loadImage(Bitmap bitmap, String s)
            {
                if (MyMainActivity.access$38(this$0) != null)
                {
                    MyMainActivity.access$39(this$0, bitmap.getWidth());
                    MyMainActivity.access$40(this$0, bitmap.getHeight());
                    s = new android.widget.LinearLayout.LayoutParams(-1, getHeight(MyMainActivity.access$41(this$0), MyMainActivity.access$42(this$0)));
                    MyMainActivity.access$38(this$0).setLayoutParams(s);
                    MyMainActivity.access$38(this$0).setImageBitmap(bitmap);
                }
            }

                    
                    {
                        this$1 = MyMainActivity._cls15.this;
                        super();
                    }
        }

    }

}
