// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.inmobi.commons.internal.Base64;
import com.inmobi.commons.internal.Log;
import com.inmobi.re.configs.ConfigParams;
import com.inmobi.re.configs.Initializer;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageProcessing
{

    public ImageProcessing()
    {
    }

    public static String convertMediaUriToPath(Uri uri, Context context)
    {
        uri = context.getContentResolver().query(uri, new String[] {
            "_data"
        }, null, null, null);
        int i = uri.getColumnIndexOrThrow("_data");
        uri.moveToFirst();
        context = uri.getString(i);
        uri.close();
        return context;
    }

    public static String getBase64EncodedImage(Bitmap bitmap, Context context)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        int i = getDefaultImgQuality(context);
        bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, i, bytearrayoutputstream);
        return Base64.encodeToString(bytearrayoutputstream.toByteArray(), 2);
    }

    public static Bitmap getCompressedBitmap(String s, Context context)
    {
        double d;
        Object obj;
        int j;
        int k;
        int l;
        try
        {
            int i = getDefaultImgWidth(context);
            k = getDefaultImgHeight(context) * i;
            context = new FileInputStream(s);
            obj = new android.graphics.BitmapFactory.Options();
            obj.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(context, null, ((android.graphics.BitmapFactory.Options) (obj)));
            context.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.debug("[InMobi]-[RE]-4.5.5", s.getMessage(), s);
            return null;
        }
        j = 1;
        while ((double)(((android.graphics.BitmapFactory.Options) (obj)).outWidth * ((android.graphics.BitmapFactory.Options) (obj)).outHeight) * (1.0D / Math.pow(j, 2D)) > (double)k) 
        {
            j++;
        }
        context = new FileInputStream(s);
        if (j <= 1)
        {
            break MISSING_BLOCK_LABEL_234;
        }
        s = new android.graphics.BitmapFactory.Options();
        s.inSampleSize = j - 1;
        obj = BitmapFactory.decodeStream(context, null, s);
        j = ((Bitmap) (obj)).getHeight();
        l = ((Bitmap) (obj)).getWidth();
        d = Math.sqrt((double)k / ((double)l / (double)j));
        s = Bitmap.createScaledBitmap(((Bitmap) (obj)), (int)((d / (double)j) * (double)l), (int)d, true);
        ((Bitmap) (obj)).recycle();
        System.gc();
_L1:
        context.close();
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("bitmap size - width: ").append(s.getWidth()).append(", height: ").append(s.getHeight()).toString());
        return s;
        s = BitmapFactory.decodeStream(context);
          goto _L1
    }

    public static int getDefaultImgHeight(Context context)
    {
        return Initializer.getConfigParams().getPicHeight();
    }

    public static int getDefaultImgQuality(Context context)
    {
        return Initializer.getConfigParams().getPicQuality();
    }

    public static int getDefaultImgWidth(Context context)
    {
        return Initializer.getConfigParams().getPicWidth();
    }
}
