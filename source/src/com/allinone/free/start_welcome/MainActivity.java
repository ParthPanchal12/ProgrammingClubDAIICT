// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.start_welcome;

import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.allinone.free.activity.DownloadsActivity;
import com.allinone.free.mydownload.BaseActivity;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.utils.ImageUtil;
import com.inmobi.commons.InMobi;
import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.IMNative;
import com.inmobi.monetization.IMNativeListener;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import net.tsz.afinal.FinalDBChen;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends BaseActivity
{

    private File PRO_DIR;
    private Animation animation;
    private Bitmap bitmap;
    private FinalDBChen db;
    private List ds;
    private int h;
    private String id;
    private LinearLayout ll_start;
    private ImageView loginimg;
    private IMNative nativeAdaio;
    private TextView tv_aio;
    private int w;

    public MainActivity()
    {
        PRO_DIR = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner").toString());
    }

    private File getAssetFile()
    {
        Object obj = getAssets();
        File file;
        PRO_DIR.mkdirs();
        obj = ((AssetManager) (obj)).open("cleaner.apk");
        file = new File(PRO_DIR, "cleaner.apk");
        FileOutputStream fileoutputstream;
        byte abyte0[];
        file.createNewFile();
        fileoutputstream = new FileOutputStream(file);
        abyte0 = new byte[1024];
_L1:
        int i = ((InputStream) (obj)).read(abyte0);
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        fileoutputstream.flush();
        ((InputStream) (obj)).close();
        fileoutputstream.close();
        return file;
        fileoutputstream.write(abyte0, 0, i);
          goto _L1
        IOException ioexception;
        ioexception;
_L3:
        ioexception.printStackTrace();
        return null;
        ioexception;
        if (true) goto _L3; else goto _L2
_L2:
    }

    private void inmobstatt()
    {
        nativeAdaio = new IMNative("c991b6be506b4b29a0832c46d95668d2", new IMNativeListener() {

            private String landingURL;
            final MainActivity this$0;

            public int getHeight(int i, int j)
            {
                return (getResources().getDisplayMetrics().widthPixels * j) / i;
            }

            public void onNativeRequestFailed(IMErrorCode imerrorcode)
            {
                Log.e("ppp", (new StringBuilder("errorCode=")).append(imerrorcode.name()).toString());
                loginimg.setBackgroundResource(0x7f02007e);
                animation = AnimationUtils.loadAnimation(MainActivity.this, 0x7f040000);
                loginimg.startAnimation(animation);
            }

            public void onNativeRequestSucceeded(IMNative imnative)
            {
                nativeAdaio = imnative;
                Log.e("frfr", (new StringBuilder()).append(imnative).append("//////////").toString());
                tv_aio.setVisibility(0);
                if (imnative != null)
                {
                    imnative.attachToView(ll_start);
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
                        bitmap = ImageUtil.loadImage(s1, imnative, new com.allinone.free.utils.ImageUtil.ImageCallback() {

                            final _cls2 this$1;

                            public void loadImage(Bitmap bitmap1, String s)
                            {
                                if (loginimg != null)
                                {
                                    w = bitmap1.getWidth();
                                    h = bitmap1.getHeight();
                                    s = new android.widget.LinearLayout.LayoutParams(-1, getHeight(w, h));
                                    loginimg.setLayoutParams(s);
                                    loginimg.setImageBitmap(bitmap1);
                                }
                            }

            
            {
                this$1 = _cls2.this;
                super();
            }
                        }, 0);
                        if (bitmap != null)
                        {
                            w = bitmap.getWidth();
                            h = bitmap.getHeight();
                            imnative = new android.widget.LinearLayout.LayoutParams(-1, getHeight(w, h));
                            loginimg.setLayoutParams(imnative);
                            loginimg.setImageBitmap(bitmap);
                        }
                    }
                    loginimg.setOnClickListener(new android.view.View.OnClickListener() {

                        final _cls2 this$1;

                        public void onClick(View view)
                        {
                            view = new Intent("android.intent.action.VIEW", Uri.parse(landingURL));
                            startActivity(view);
                            if (nativeAdaio != null)
                            {
                                nativeAdaio.handleClick(null);
                            }
                        }

            
            {
                this$1 = _cls2.this;
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



            
            {
                this$0 = MainActivity.this;
                super();
            }
        });
        nativeAdaio.loadAd();
    }

    public void initView()
    {
        super.initView();
        try
        {
            new FinalDBChen(getmContext(), "download2.db", new DownloadMovieItem(), "downloadtask2", null);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setmContext(this);
        setContentView(0x7f030066);
        getAssetFile();
        ll_start = (LinearLayout)findViewById(0x7f0601a9);
        tv_aio = (TextView)findViewById(0x7f0601ab);
        initView();
        db = new FinalDBChen(getmContext(), getDatabasePath("download2.db").getAbsolutePath());
        ds = db.findItemsByWhereAndWhereValue(null, null, com/allinone/free/mydownload/DownloadMovieItem, "downloadtask2", null);
        loginimg = (ImageView)findViewById(0x7f0601aa);
        InMobi.initialize(this, "c991b6be506b4b29a0832c46d95668d2");
        inmobstatt();
        (new Handler()).postDelayed(new Runnable() {

            final MainActivity this$0;

            public void run()
            {
                Intent intent = new Intent(MainActivity.this, com/allinone/free/activity/DownloadsActivity);
                startActivity(intent);
                finish();
                overridePendingTransition(0x7f04000a, 0x7f04000f);
            }

            
            {
                this$0 = MainActivity.this;
                super();
            }
        }, 5000L);
    }

    protected void onPause()
    {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    public void onResume()
    {
        super.onResume();
        MobclickAgent.onResume(this);
    }













}
