// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.start_welcome;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.allinone.free.utils.ImageUtil;
import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.IMNative;
import com.inmobi.monetization.IMNativeListener;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.allinone.free.start_welcome:
//            MainActivity

class this._cls0
    implements IMNativeListener
{

    private String landingURL;
    final MainActivity this$0;

    public int getHeight(int i, int j)
    {
        return (getResources().getDisplayMetrics().widthPixels * j) / i;
    }

    public void onNativeRequestFailed(IMErrorCode imerrorcode)
    {
        Log.e("ppp", (new StringBuilder("errorCode=")).append(imerrorcode.name()).toString());
        MainActivity.access$3(MainActivity.this).setBackgroundResource(0x7f02007e);
        MainActivity.access$11(MainActivity.this, AnimationUtils.loadAnimation(MainActivity.this, 0x7f040000));
        MainActivity.access$3(MainActivity.this).startAnimation(MainActivity.access$12(MainActivity.this));
    }

    public void onNativeRequestSucceeded(IMNative imnative)
    {
        MainActivity.access$0(MainActivity.this, imnative);
        Log.e("frfr", (new StringBuilder()).append(imnative).append("//////////").toString());
        MainActivity.access$1(MainActivity.this).setVisibility(0);
        if (imnative != null)
        {
            imnative.attachToView(MainActivity.access$2(MainActivity.this));
        }
        imnative = imnative.getContent();
        Log.e("ppp", (new StringBuilder("kaiji..content=")).append(imnative).toString());
        try
        {
            imnative = new JSONObject(imnative);
            String s = imnative.getString("icon");
            String s2 = imnative.getString("screenshots");
            landingURL = imnative.getString("landingURL");
            new JSONObject(s);
            imnative = (new JSONObject(s2)).getString("url");
            Log.e("ppp", (new StringBuilder("url=")).append(imnative).append("landingURL=").append(landingURL).toString());
            if (!imnative.equals(""))
            {
                String s1 = ImageUtil.getCacheImgPath().concat(ImageUtil.md5(imnative));
                MainActivity.access$8(MainActivity.this, ImageUtil.loadImage(s1, imnative, new com.allinone.free.utils.ImageUtil.ImageCallback() {

                    final MainActivity._cls2 this$1;

                    public void loadImage(Bitmap bitmap, String s3)
                    {
                        if (MainActivity.access$3(this$0) != null)
                        {
                            MainActivity.access$4(this$0, bitmap.getWidth());
                            MainActivity.access$5(this$0, bitmap.getHeight());
                            s3 = new android.widget.LinearLayout.LayoutParams(-1, getHeight(MainActivity.access$6(this$0), MainActivity.access$7(this$0)));
                            MainActivity.access$3(this$0).setLayoutParams(s3);
                            MainActivity.access$3(this$0).setImageBitmap(bitmap);
                        }
                    }

            
            {
                this$1 = MainActivity._cls2.this;
                super();
            }
                }, 0));
                if (MainActivity.access$9(MainActivity.this) != null)
                {
                    MainActivity.access$4(MainActivity.this, MainActivity.access$9(MainActivity.this).getWidth());
                    MainActivity.access$5(MainActivity.this, MainActivity.access$9(MainActivity.this).getHeight());
                    imnative = new android.widget.youtParams(-1, getHeight(MainActivity.access$6(MainActivity.this), MainActivity.access$7(MainActivity.this)));
                    MainActivity.access$3(MainActivity.this).setLayoutParams(imnative);
                    MainActivity.access$3(MainActivity.this).setImageBitmap(MainActivity.access$9(MainActivity.this));
                }
            }
            MainActivity.access$3(MainActivity.this).setOnClickListener(new android.view.View.OnClickListener() {

                final MainActivity._cls2 this$1;

                public void onClick(View view)
                {
                    view = new Intent("android.intent.action.VIEW", Uri.parse(landingURL));
                    startActivity(view);
                    if (MainActivity.access$10(this$0) != null)
                    {
                        MainActivity.access$10(this$0).handleClick(null);
                    }
                }

            
            {
                this$1 = MainActivity._cls2.this;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IMNative imnative)
        {
            imnative.printStackTrace();
        }
    }



    _cls2.this._cls1()
    {
        this$0 = MainActivity.this;
        super();
    }
}
