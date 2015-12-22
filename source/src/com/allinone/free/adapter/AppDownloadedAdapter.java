// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.mydownload.MyApplcation;
import com.allinone.free.utils.publicTools;
import java.util.List;

public class AppDownloadedAdapter extends BaseAdapter
{
    class ViewHolder
    {

        private ImageView my_delete_movie;
        private TextView my_movie_name_item;
        private Button my_stop_download_bt;
        private ImageView my_test_head_image;
        private TextView my_totalsize;
        final AppDownloadedAdapter this$0;











        ViewHolder()
        {
            this$0 = AppDownloadedAdapter.this;
            super();
        }
    }


    private MyApplcation app;
    private Context ctx;
    private List list;
    private PackageInfo packageInfo;
    private Typeface typeFace;

    public AppDownloadedAdapter(Context context, List list1)
    {
        packageInfo = null;
        typeFace = null;
        ctx = context;
        list = list1;
        try
        {
            app = (MyApplcation)context.getApplicationContext();
        }
        // Misplaced declaration of an exception variable
        catch (List list1) { }
        try
        {
            typeFace = Typeface.createFromAsset(context.getAssets(), "Roboto-Light.ttf");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    public int getCount()
    {
        if (list != null && list.size() > 0)
        {
            return list.size();
        } else
        {
            return 0;
        }
    }

    public Object getItem(int i)
    {
        return list.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(final int position, View view, ViewGroup viewgroup)
    {
        Log.v("oiu", "cccccccccc");
        final DownloadMovieItem in_fo = (DownloadMovieItem)list.get(position);
        if (view == null)
        {
            viewgroup = new ViewHolder();
            view = View.inflate(ctx, 0x7f030026, null);
            viewgroup.my_delete_movie = (ImageView)view.findViewById(0x7f0600b0);
            viewgroup.my_test_head_image = (ImageView)view.findViewById(0x7f0600b1);
            viewgroup.my_movie_name_item = (TextView)view.findViewById(0x7f0600b2);
            viewgroup.my_totalsize = (TextView)view.findViewById(0x7f0600b3);
            viewgroup.my_stop_download_bt = (Button)view.findViewById(0x7f0600b4);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        try
        {
            ((ViewHolder) (viewgroup)).my_totalsize.setText(Formatter.formatFileSize(ctx, Long.parseLong(in_fo.getFileSize())));
        }
        catch (Exception exception) { }
        ((ViewHolder) (viewgroup)).my_movie_name_item.setText(in_fo.getMovieName());
        ((ViewHolder) (viewgroup)).my_movie_name_item.setTypeface(typeFace);
        app.asyncLoadImage(in_fo.getMovieHeadImagePath(), ((ViewHolder) (viewgroup)).my_test_head_image);
        try
        {
            packageInfo = ctx.getPackageManager().getPackageInfo(in_fo.getFile_id(), 0);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            packageInfo = null;
            namenotfoundexception.printStackTrace();
        }
        if (packageInfo != null)
        {
            ((ViewHolder) (viewgroup)).my_stop_download_bt.setBackgroundResource(0x7f02016e);
            ((ViewHolder) (viewgroup)).my_stop_download_bt.setText("Open");
        } else
        {
            ((ViewHolder) (viewgroup)).my_stop_download_bt.setBackgroundResource(0x7f02011c);
            ((ViewHolder) (viewgroup)).my_stop_download_bt.setText("Install");
        }
        ((ViewHolder) (viewgroup)).my_stop_download_bt.setOnClickListener(new android.view.View.OnClickListener() {

            final AppDownloadedAdapter this$0;
            private final DownloadMovieItem val$in_fo;

            public void onClick(View view1)
            {
                try
                {
                    packageInfo = ctx.getPackageManager().getPackageInfo(in_fo.getFile_id(), 0);
                }
                // Misplaced declaration of an exception variable
                catch (View view1)
                {
                    packageInfo = null;
                    view1.printStackTrace();
                }
                if (packageInfo != null)
                {
                    try
                    {
                        view1 = ctx.getPackageManager().getLaunchIntentForPackage(in_fo.getFile_id());
                        ctx.startActivity(view1);
                        Log.v("sss", "2222");
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view1)
                    {
                        return;
                    }
                } else
                {
                    publicTools.openimgpath = in_fo.getMovieHeadImagePath();
                    publicTools.opentitle = in_fo.getMovieName();
                    publicTools.openid = in_fo.getFile_id();
                    Log.v("sss", "11111");
                    view1 = new Intent("android.intent.action.VIEW");
                    view1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(in_fo.getFilePath()).toString()), "application/vnd.android.package-archive");
                    ctx.startActivity(view1);
                    return;
                }
            }

            
            {
                this$0 = AppDownloadedAdapter.this;
                in_fo = downloadmovieitem;
                super();
            }
        });
        ((ViewHolder) (viewgroup)).my_delete_movie.setOnClickListener(new android.view.View.OnClickListener() {

            final AppDownloadedAdapter this$0;
            private final int val$position;

            public void onClick(View view1)
            {
                view1 = new Intent();
                view1.setAction("delete");
                view1.putExtra("position", position);
                ctx.sendBroadcast(view1);
            }

            
            {
                this$0 = AppDownloadedAdapter.this;
                position = i;
                super();
            }
        });
        return view;
    }



}
