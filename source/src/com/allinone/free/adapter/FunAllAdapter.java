// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.allinone.free.activity.FunGifActivity;
import com.allinone.free.activity.FunImagePagerActivity;
import com.allinone.free.activity.ShowAideoActivity;
import com.allinone.free.model.FunModel;
import com.allinone.free.mydownload.MyApplcation;
import com.allinone.free.utils.publicTools;
import java.util.List;

public class FunAllAdapter extends BaseAdapter
{
    class ViewHolder
    {

        Button bt_gif;
        Button bt_pics;
        Button bt_share;
        Button bt_video;
        ImageView iv_fun;
        RelativeLayout rl_like;
        final FunAllAdapter this$0;
        TextView tv_fun;
        TextView tv_funadult_like;
        TextView tv_funadult_share;
        TextView tv_funadult_time;

        ViewHolder()
        {
            this$0 = FunAllAdapter.this;
            super();
        }
    }


    private MyApplcation app;
    private Bitmap bitmap;
    private Context ctx;
    private int h;
    ViewHolder holder;
    private List list;
    private int w;

    public FunAllAdapter(Context context, List list1)
    {
        holder = null;
        ctx = context;
        list = list1;
        try
        {
            app = (MyApplcation)context.getApplicationContext();
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

    public int getHeight(int i, int j)
    {
        return (ctx.getResources().getDisplayMetrics().widthPixels * j) / i;
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
        String s;
        long l;
        if (view == null)
        {
            holder = new ViewHolder();
            viewgroup = View.inflate(ctx, 0x7f03004f, null);
            holder.tv_fun = (TextView)viewgroup.findViewById(0x7f060122);
            holder.iv_fun = (ImageView)viewgroup.findViewById(0x7f060123);
            holder.tv_funadult_like = (TextView)viewgroup.findViewById(0x7f060124);
            holder.tv_funadult_share = (TextView)viewgroup.findViewById(0x7f060126);
            holder.tv_funadult_time = (TextView)viewgroup.findViewById(0x7f060127);
            holder.bt_share = (Button)viewgroup.findViewById(0x7f060129);
            holder.rl_like = (RelativeLayout)viewgroup.findViewById(0x7f060128);
            holder.bt_pics = (Button)viewgroup.findViewById(0x7f06012a);
            holder.bt_gif = (Button)viewgroup.findViewById(0x7f06012b);
            holder.bt_video = (Button)viewgroup.findViewById(0x7f06012c);
            viewgroup.setTag(holder);
        } else
        {
            holder = (ViewHolder)view.getTag();
            viewgroup = view;
        }
        Log.e("www", (new StringBuilder("in_fo.getTitle()=")).append(((FunModel)list.get(position)).getTitle()).toString());
        holder.tv_fun.setText(((FunModel)list.get(position)).getTitle());
        holder.tv_funadult_like.setText((new StringBuilder(String.valueOf(((FunModel)list.get(position)).getLike_count()))).append(" likes").toString());
        holder.tv_funadult_share.setText((new StringBuilder(String.valueOf(((FunModel)list.get(position)).getShare_count()))).append(" share").toString());
        l = Long.parseLong(((FunModel)list.get(position)).getCreate_time()) * 1000L;
        Log.e("www", (new StringBuilder("time=")).append(l).toString());
        s = (String)DateFormat.format("MM", l);
        if (s.equals("01"))
        {
            view = "January";
        } else
        if (s.equals("02"))
        {
            view = "February";
        } else
        if (s.equals("03"))
        {
            view = "March";
        } else
        if (s.equals("04"))
        {
            view = "April";
        } else
        if (s.equals("05"))
        {
            view = "May";
        } else
        if (s.equals("06"))
        {
            view = "June";
        } else
        if (s.equals("07"))
        {
            view = "July";
        } else
        if (s.equals("08"))
        {
            view = "August";
        } else
        if (s.equals("09"))
        {
            view = "September";
        } else
        if (s.equals("10"))
        {
            view = "October";
        } else
        if (s.equals("11"))
        {
            view = "November";
        } else
        {
            view = s;
            if (s.equals("12"))
            {
                view = "December";
            }
        }
        try
        {
            holder.tv_funadult_time.setText((new StringBuilder(String.valueOf(view))).append(DateFormat.format(" dd, yyyy", l)).toString());
        }
        // Misplaced declaration of an exception variable
        catch (View view) { }
        if (((FunModel)list.get(position)).getCat().equals("adult"))
        {
            holder.bt_pics.setText((new StringBuilder(String.valueOf(((FunModel)list.get(position)).getImg_count()))).append(" pics").toString());
            holder.bt_gif.setVisibility(8);
            holder.bt_video.setVisibility(8);
            holder.bt_pics.setVisibility(0);
            holder.iv_fun.setOnClickListener(new android.view.View.OnClickListener() {

                final FunAllAdapter this$0;
                private final int val$position;

                public void onClick(View view1)
                {
                    Log.e("www", (new StringBuilder("(Serializable) Myutils.list_array=")).append(((FunModel)list.get(position)).getFunlist()).toString());
                    view1 = (new StringBuilder("http://welaf.com/fun/stat.php?serial=")).append(((FunModel)list.get(position)).getSerial()).append("&type=hit").toString();
                    Log.e("www", (new StringBuilder("url=+")).append(view1).toString());
                    publicTools.getUrl(view1);
                    view1 = new Intent(ctx, com/allinone/free/activity/FunImagePagerActivity);
                    view1.putExtra("screenshotlist", ((FunModel)list.get(position)).getFunlist());
                    view1.putExtra("detailtitle", ((FunModel)list.get(position)).getTitle());
                    view1.putExtra("detailcount", ((FunModel)list.get(position)).getImg_count());
                    ctx.startActivity(view1);
                }

            
            {
                this$0 = FunAllAdapter.this;
                position = i;
                super();
            }
            });
            holder.bt_pics.setOnClickListener(new android.view.View.OnClickListener() {

                final FunAllAdapter this$0;
                private final int val$position;

                public void onClick(View view1)
                {
                    Log.e("www", (new StringBuilder("(Serializable) Myutils.list_array=")).append(((FunModel)list.get(position)).getFunlist()).toString());
                    view1 = (new StringBuilder("http://welaf.com/fun/stat.php?serial=")).append(((FunModel)list.get(position)).getSerial()).append("&type=hit").toString();
                    Log.e("www", (new StringBuilder("url=+")).append(view1).toString());
                    publicTools.getUrl(view1);
                    view1 = new Intent(ctx, com/allinone/free/activity/FunImagePagerActivity);
                    view1.putExtra("screenshotlist", ((FunModel)list.get(position)).getFunlist());
                    view1.putExtra("detailtitle", ((FunModel)list.get(position)).getTitle());
                    view1.putExtra("detailcount", ((FunModel)list.get(position)).getImg_count());
                    ctx.startActivity(view1);
                }

            
            {
                this$0 = FunAllAdapter.this;
                position = i;
                super();
            }
            });
        } else
        if (((FunModel)list.get(position)).getCat().equals("gif"))
        {
            holder.bt_pics.setVisibility(8);
            holder.bt_video.setVisibility(8);
            holder.bt_gif.setVisibility(0);
            holder.iv_fun.setOnClickListener(new android.view.View.OnClickListener() {

                final FunAllAdapter this$0;
                private final int val$position;

                public void onClick(View view1)
                {
                    view1 = (new StringBuilder("http://welaf.com/fun/stat.php?serial=")).append(((FunModel)list.get(position)).getSerial()).append("&type=hit").toString();
                    Log.e("www", (new StringBuilder("url=+")).append(view1).toString());
                    publicTools.getUrl(view1);
                    view1 = new Intent(ctx, com/allinone/free/activity/FunGifActivity);
                    view1.putExtra("fullpath", ((FunModel)list.get(position)).getImg_src());
                    view1.putExtra("apath", ((FunModel)list.get(position)).getThu_path());
                    view1.putExtra("detailtitle", ((FunModel)list.get(position)).getTitle());
                    view1.putExtra("detailcount", ((FunModel)list.get(position)).getImg_count());
                    ctx.startActivity(view1);
                }

            
            {
                this$0 = FunAllAdapter.this;
                position = i;
                super();
            }
            });
            holder.bt_gif.setOnClickListener(new android.view.View.OnClickListener() {

                final FunAllAdapter this$0;
                private final int val$position;

                public void onClick(View view1)
                {
                    view1 = (new StringBuilder("http://welaf.com/fun/stat.php?serial=")).append(((FunModel)list.get(position)).getSerial()).append("&type=hit").toString();
                    Log.e("www", (new StringBuilder("url=+")).append(view1).toString());
                    publicTools.getUrl(view1);
                    view1 = new Intent(ctx, com/allinone/free/activity/FunGifActivity);
                    view1.putExtra("fullpath", ((FunModel)list.get(position)).getImg_src());
                    view1.putExtra("apath", ((FunModel)list.get(position)).getThu_path());
                    view1.putExtra("detailtitle", ((FunModel)list.get(position)).getTitle());
                    view1.putExtra("detailcount", ((FunModel)list.get(position)).getImg_count());
                    ctx.startActivity(view1);
                }

            
            {
                this$0 = FunAllAdapter.this;
                position = i;
                super();
            }
            });
        } else
        if (((FunModel)list.get(position)).getCat().equals("video"))
        {
            holder.bt_gif.setVisibility(8);
            holder.bt_pics.setVisibility(8);
            holder.bt_video.setVisibility(0);
            holder.iv_fun.setOnClickListener(new android.view.View.OnClickListener() {

                final FunAllAdapter this$0;
                private final int val$position;

                public void onClick(View view1)
                {
                    view1 = (new StringBuilder("http://welaf.com/fun/stat.php?serial=")).append(((FunModel)list.get(position)).getSerial()).append("&type=hit").toString();
                    Log.e("www", (new StringBuilder("url=+")).append(view1).toString());
                    publicTools.getUrl(view1);
                    view1 = new Intent(ctx, com/allinone/free/activity/ShowAideoActivity);
                    view1.putExtra("strurl", ((FunModel)list.get(position)).getVideo_src());
                    ctx.startActivity(view1);
                }

            
            {
                this$0 = FunAllAdapter.this;
                position = i;
                super();
            }
            });
            holder.bt_video.setOnClickListener(new android.view.View.OnClickListener() {

                final FunAllAdapter this$0;
                private final int val$position;

                public void onClick(View view1)
                {
                    view1 = (new StringBuilder("http://welaf.com/fun/stat.php?serial=")).append(((FunModel)list.get(position)).getSerial()).append("&type=hit").toString();
                    Log.e("www", (new StringBuilder("url=+")).append(view1).toString());
                    publicTools.getUrl(view1);
                    view1 = new Intent(ctx, com/allinone/free/activity/ShowAideoActivity);
                    view1.putExtra("strurl", ((FunModel)list.get(position)).getVideo_src());
                    ctx.startActivity(view1);
                }

            
            {
                this$0 = FunAllAdapter.this;
                position = i;
                super();
            }
            });
        } else
        if (((FunModel)list.get(position)).getCat().equals("gag"))
        {
            holder.bt_gif.setVisibility(8);
            holder.bt_pics.setVisibility(8);
            holder.bt_video.setVisibility(8);
            holder.iv_fun.setOnClickListener(new android.view.View.OnClickListener() {

                final FunAllAdapter this$0;
                private final int val$position;

                public void onClick(View view1)
                {
                    Log.e("www", (new StringBuilder("(Serializable) Myutils.list_array=")).append(((FunModel)list.get(position)).getFunlist()).toString());
                    view1 = (new StringBuilder("http://welaf.com/fun/stat.php?serial=")).append(((FunModel)list.get(position)).getSerial()).append("&type=hit").toString();
                    Log.e("www", (new StringBuilder("url=+")).append(view1).toString());
                    publicTools.getUrl(view1);
                    view1 = new Intent(ctx, com/allinone/free/activity/FunImagePagerActivity);
                    view1.putExtra("screenshotlist", ((FunModel)list.get(position)).getFunlist());
                    view1.putExtra("detailtitle", ((FunModel)list.get(position)).getTitle());
                    view1.putExtra("detailcount", ((FunModel)list.get(position)).getImg_count());
                    ctx.startActivity(view1);
                }

            
            {
                this$0 = FunAllAdapter.this;
                position = i;
                super();
            }
            });
        }
        holder.rl_like.setOnClickListener(new android.view.View.OnClickListener() {

            final FunAllAdapter this$0;
            private final int val$position;

            public void onClick(View view1)
            {
                String s1 = (new StringBuilder("http://welaf.com/fun/stat.php?serial=")).append(((FunModel)list.get(position)).getSerial()).append("&type=like").toString();
                Log.e("www", (new StringBuilder("url=+")).append(s1).toString());
                publicTools.getUrl(s1);
                ((RelativeLayout)view1).setBackgroundResource(0x7f08002c);
            }

            
            {
                this$0 = FunAllAdapter.this;
                position = i;
                super();
            }
        });
        holder.bt_share.setOnClickListener(new android.view.View.OnClickListener() {

            final FunAllAdapter this$0;
            private final int val$position;

            public void onClick(View view1)
            {
                String s1 = (new StringBuilder("http://welaf.com/fun/stat.php?serial=")).append(((FunModel)list.get(position)).getSerial()).append("&type=share").toString();
                Log.e("www", (new StringBuilder("url=+")).append(s1).toString());
                publicTools.getUrl(s1);
                ((Button)view1).setBackgroundResource(0x7f08002c);
                view1 = new Intent("android.intent.action.SEND");
                view1.setType("text/plain");
                view1.putExtra("android.intent.extra.TEXT", "http://tinyurl.com/allinone-downloader");
                ctx.startActivity(Intent.createChooser(view1, "AIO Downloaded"));
            }

            
            {
                this$0 = FunAllAdapter.this;
                position = i;
                super();
            }
        });
        app.asyncLoadImage(((FunModel)list.get(position)).getThu_path(), holder.iv_fun);
        return viewgroup;
    }


}
