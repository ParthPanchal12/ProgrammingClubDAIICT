// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.allinone.free.utils.ImageUtil;
import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.IMNative;
import com.inmobi.monetization.IMNativeListener;
import org.json.JSONObject;

// Referenced classes of package com.allinone.free.fragments:
//            GameFeaturedFragment

class this._cls1
    implements android.view.edFragment._cls4._cls2
{

    final is._cls0 this$1;

    public void onClick(View view)
    {
        view = new Intent("android.intent.action.VIEW", Uri.parse(wnloadurl));
        startActivity(view);
        if (GameFeaturedFragment.access$13(_fld0) != null)
        {
            GameFeaturedFragment.access$13(_fld0).handleClick(null);
        }
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/allinone/free/fragments/GameFeaturedFragment$4

/* anonymous class */
    class GameFeaturedFragment._cls4
        implements IMNativeListener
    {

        private String downloadurl;
        final GameFeaturedFragment this$0;

        public void onNativeRequestFailed(IMErrorCode imerrorcode)
        {
            try
            {
                GameFeaturedFragment.access$4(GameFeaturedFragment.this).setVisibility(8);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (IMErrorCode imerrorcode)
            {
                return;
            }
        }

        public void onNativeRequestSucceeded(IMNative imnative)
        {
            try
            {
                GameFeaturedFragment.access$4(GameFeaturedFragment.this).setVisibility(0);
            }
            catch (Exception exception) { }
            GameFeaturedFragment.access$5(GameFeaturedFragment.this, imnative);
            if (imnative != null)
            {
                imnative.attachToView(GameFeaturedFragment.access$4(GameFeaturedFragment.this));
            }
            imnative = imnative.getContent();
            try
            {
                imnative = new JSONObject(imnative);
                String s = imnative.getString("screenshots");
                downloadurl = imnative.getString("landingURL");
                imnative = (new JSONObject(s)).getString("url");
                if (!imnative.equals(""))
                {
                    String s1 = ImageUtil.getCacheImgPath().concat(ImageUtil.md5(imnative));
                    GameFeaturedFragment.access$11(GameFeaturedFragment.this, ImageUtil.loadImage(s1, imnative, new GameFeaturedFragment._cls4._cls1(), 0));
                    if (GameFeaturedFragment.access$12(GameFeaturedFragment.this) != null)
                    {
                        GameFeaturedFragment.access$7(GameFeaturedFragment.this, GameFeaturedFragment.access$12(GameFeaturedFragment.this).getWidth());
                        GameFeaturedFragment.access$8(GameFeaturedFragment.this, GameFeaturedFragment.access$12(GameFeaturedFragment.this).getHeight());
                        imnative = new android.widget.LinearLayout.LayoutParams(-1, getHeight(GameFeaturedFragment.access$9(GameFeaturedFragment.this), GameFeaturedFragment.access$10(GameFeaturedFragment.this)));
                        GameFeaturedFragment.access$6(GameFeaturedFragment.this).setLayoutParams(imnative);
                        GameFeaturedFragment.access$6(GameFeaturedFragment.this).setImageBitmap(GameFeaturedFragment.access$12(GameFeaturedFragment.this));
                    }
                }
                GameFeaturedFragment.access$6(GameFeaturedFragment.this).setOnClickListener(new GameFeaturedFragment._cls4._cls2());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (IMNative imnative)
            {
                imnative.printStackTrace();
            }
        }



            
            {
                this$0 = GameFeaturedFragment.this;
                super();
            }

        // Unreferenced inner class com/allinone/free/fragments/GameFeaturedFragment$4$1

/* anonymous class */
        class GameFeaturedFragment._cls4._cls1
            implements com.allinone.free.utils.ImageUtil.ImageCallback
        {

            final GameFeaturedFragment._cls4 this$1;

            public void loadImage(Bitmap bitmap, String s)
            {
                if (GameFeaturedFragment.access$6(this$0) != null)
                {
                    GameFeaturedFragment.access$7(this$0, bitmap.getWidth());
                    GameFeaturedFragment.access$8(this$0, bitmap.getHeight());
                    s = new android.widget.LinearLayout.LayoutParams(-1, getHeight(GameFeaturedFragment.access$9(this$0), GameFeaturedFragment.access$10(this$0)));
                    GameFeaturedFragment.access$6(this$0).setLayoutParams(s);
                    GameFeaturedFragment.access$6(this$0).setImageBitmap(bitmap);
                }
            }

                    
                    {
                        this$1 = GameFeaturedFragment._cls4.this;
                        super();
                    }
        }

    }

}
