// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.allinone.free.activity.AppDetailsActivity;
import com.allinone.free.activity.AppSearchResultActivity;
import com.allinone.free.activity.FunGifActivity;
import com.allinone.free.activity.FunImagePagerActivity;
import com.allinone.free.activity.MiniGamePlayActivity;
import com.allinone.free.activity.ShowAideoActivity;
import com.allinone.free.model.FunModel;
import com.allinone.free.mydownload.ContentValue;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.mydownload.MyApplcation;
import com.allinone.free.utils.publicTools;
import java.util.ArrayList;

// Referenced classes of package com.allinone.free.adapter:
//            Home_Gridview_Adapter

public class Home_Listview_Adapter extends BaseAdapter
    implements ContentValue
{
    class ViewHolder
    {

        public ImageView bannerimg;
        private TextView bannerviewtv;
        private LinearLayout bannerviewtvwyc;
        Button bt_gif;
        Button bt_pics;
        Button bt_share;
        Button bt_video;
        private LinearLayout funshouye;
        private TextView gridviewtv;
        ImageView iv_fun;
        private GridView lv_gv_gridview;
        private TextView lv_gv_tvtitle;
        private TextView minigamedetail;
        private ImageView minigameicon;
        private RelativeLayout minigamelist2;
        private Button minigameplaybt;
        private TextView minigametitle;
        RelativeLayout rl_like;
        final Home_Listview_Adapter this$0;
        private RelativeLayout topsearch;
        TextView tv_fun;
        TextView tv_funadult_like;
        TextView tv_funadult_share;
        TextView tv_funadult_time;

























        ViewHolder()
        {
            this$0 = Home_Listview_Adapter.this;
            super();
        }
    }


    private MyApplcation app;
    private String apptag;
    private int biaoshi;
    private Context ctx;
    private ArrayList funarray;
    ViewHolder holder;
    private ArrayList list_fun;
    private ArrayList listdata;
    private int shuliang;
    private Typeface typeFace;
    private Typeface typeFace2;

    public Home_Listview_Adapter(Context context, ArrayList arraylist, String s, ArrayList arraylist1)
    {
        typeFace = null;
        typeFace2 = null;
        holder = null;
        biaoshi = 0;
        shuliang = 5;
        funarray = new ArrayList();
        listdata = arraylist;
        apptag = s;
        ctx = context;
        list_fun = arraylist1;
        try
        {
            typeFace = Typeface.createFromAsset(context.getAssets(), "Roboto-Light.ttf");
            typeFace2 = Typeface.createFromAsset(context.getAssets(), "Roboto-Condensed.ttf");
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
        return listdata.size();
    }

    public Object getItem(int i)
    {
        return listdata.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, final ViewGroup list)
    {
        list = (ArrayList)listdata.get(i);
        Home_Gridview_Adapter home_gridview_adapter;
        int j;
        if (view == null)
        {
            holder = new ViewHolder();
            view = View.inflate(ctx, 0x7f030063, null);
            holder.lv_gv_tvtitle = (TextView)view.findViewById(0x7f06019c);
            holder.lv_gv_gridview = (GridView)view.findViewById(0x7f06019e);
            holder.bannerimg = (ImageView)view.findViewById(0x7f0601a0);
            holder.minigamelist2 = (RelativeLayout)view.findViewById(0x7f0601a3);
            holder.minigametitle = (TextView)view.findViewById(0x7f0601ce);
            holder.minigameicon = (ImageView)view.findViewById(0x7f060141);
            holder.minigamedetail = (TextView)view.findViewById(0x7f0601cf);
            holder.minigameplaybt = (Button)view.findViewById(0x7f0601d0);
            holder.topsearch = (RelativeLayout)view.findViewById(0x7f06019b);
            holder.minigameplaybt = (Button)view.findViewById(0x7f0601d0);
            holder.gridviewtv = (TextView)view.findViewById(0x7f06019f);
            holder.bannerviewtv = (TextView)view.findViewById(0x7f0601a2);
            holder.funshouye = (LinearLayout)view.findViewById(0x7f0601a4);
            holder.tv_fun = (TextView)view.findViewById(0x7f060122);
            holder.iv_fun = (ImageView)view.findViewById(0x7f060123);
            holder.tv_funadult_like = (TextView)view.findViewById(0x7f060124);
            holder.tv_funadult_share = (TextView)view.findViewById(0x7f060126);
            holder.tv_funadult_time = (TextView)view.findViewById(0x7f060127);
            holder.bt_share = (Button)view.findViewById(0x7f060129);
            holder.rl_like = (RelativeLayout)view.findViewById(0x7f060128);
            holder.bt_pics = (Button)view.findViewById(0x7f06012a);
            holder.bt_gif = (Button)view.findViewById(0x7f06012b);
            holder.bt_video = (Button)view.findViewById(0x7f06012c);
            holder.bannerviewtvwyc = (LinearLayout)view.findViewById(0x7f0601a1);
            view.setTag(holder);
        } else
        {
            holder = (ViewHolder)view.getTag();
        }
        holder.lv_gv_tvtitle.setText(((DownloadMovieItem)list.get(0)).getInfotitle());
        home_gridview_adapter = new Home_Gridview_Adapter(ctx, list, apptag);
        holder.lv_gv_gridview.setAdapter(home_gridview_adapter);
        if (((DownloadMovieItem)list.get(0)).getBannerstatus().equals("1"))
        {
            holder.bannerimg.setVisibility(0);
            app.asyncLoadImage(((DownloadMovieItem)list.get(0)).getBannericon(), holder.bannerimg);
            holder.gridviewtv.setVisibility(0);
        } else
        {
            holder.bannerimg.setVisibility(8);
            holder.gridviewtv.setVisibility(8);
        }
        if (((DownloadMovieItem)list.get(0)).getMinigamestatus().equals("1"))
        {
            holder.minigamelist2.setVisibility(0);
            holder.bannerviewtv.setVisibility(0);
            holder.bannerviewtvwyc.setVisibility(0);
        } else
        {
            holder.minigamelist2.setVisibility(8);
            holder.bannerviewtvwyc.setVisibility(8);
        }
        holder.minigametitle.setText(((DownloadMovieItem)list.get(0)).getMinigametitle());
        app.asyncLoadImage(((DownloadMovieItem)list.get(0)).getMinigameicon(), holder.minigameicon);
        holder.minigamedetail.setText(((DownloadMovieItem)list.get(0)).getDetail());
        holder.topsearch.setOnClickListener(new android.view.View.OnClickListener() {

            final Home_Listview_Adapter this$0;
            private final ArrayList val$list;

            public void onClick(View view1)
            {
                view1 = new Intent(ctx, com/allinone/free/activity/AppSearchResultActivity);
                view1.putExtra("searchkeywords", ((DownloadMovieItem)list.get(0)).getSearch_keyword());
                ctx.startActivity(view1);
            }

            
            {
                this$0 = Home_Listview_Adapter.this;
                list = arraylist;
                super();
            }
        });
        holder.lv_gv_gridview.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final Home_Listview_Adapter this$0;
            private final ArrayList val$list;

            public void onItemClick(AdapterView adapterview, View view1, int k, long l)
            {
                adapterview = new Intent(ctx, com/allinone/free/activity/AppDetailsActivity);
                adapterview.putExtra("myid", ((DownloadMovieItem)list.get(k)).getId());
                ctx.startActivity(adapterview);
            }

            
            {
                this$0 = Home_Listview_Adapter.this;
                list = arraylist;
                super();
            }
        });
        holder.bannerimg.setOnClickListener(new android.view.View.OnClickListener() {

            final Home_Listview_Adapter this$0;
            private final ArrayList val$list;

            public void onClick(View view1)
            {
                view1 = new Intent(ctx, com/allinone/free/activity/AppDetailsActivity);
                view1.putExtra("myid", ((DownloadMovieItem)list.get(0)).getBannerid());
                ctx.startActivity(view1);
            }

            
            {
                this$0 = Home_Listview_Adapter.this;
                list = arraylist;
                super();
            }
        });
        holder.minigameplaybt.setOnClickListener(new android.view.View.OnClickListener() {

            final Home_Listview_Adapter this$0;
            private final ArrayList val$list;

            public void onClick(View view1)
            {
                view1 = new Intent(ctx, com/allinone/free/activity/MiniGamePlayActivity);
                view1.putExtra("playurl", ((DownloadMovieItem)list.get(0)).getLink());
                view1.putExtra("proc", "");
                view1.putExtra("sound", "");
                ctx.startActivity(view1);
            }

            
            {
                this$0 = Home_Listview_Adapter.this;
                list = arraylist;
                super();
            }
        });
        j = (i + 1) / 4 - 1;
        if ((i + 1) % 4 == 0 && j < 20)
        {
            holder.funshouye.setVisibility(0);
            jiexie(j);
            Log.e("eee", (new StringBuilder("biaoshi=")).append(biaoshi).toString());
            return view;
        } else
        {
            holder.funshouye.setVisibility(8);
            return view;
        }
    }

    void jiexie(final int ppp)
    {
        Log.e("www", (new StringBuilder("in_fo.getTitle()=")).append(((FunModel)list_fun.get(ppp)).getTitle()).toString());
        holder.tv_fun.setText(((FunModel)list_fun.get(ppp)).getTitle());
        holder.tv_funadult_like.setText((new StringBuilder(String.valueOf(((FunModel)list_fun.get(ppp)).getLike_count()))).append(" likes").toString());
        holder.tv_funadult_share.setText((new StringBuilder(String.valueOf(((FunModel)list_fun.get(ppp)).getShare_count()))).append(" share").toString());
        long l = Long.parseLong(((FunModel)list_fun.get(ppp)).getCreate_time()) * 1000L;
        Log.e("www", (new StringBuilder("time=")).append(l).toString());
        String s1 = (String)DateFormat.format("MM", l);
        String s;
        if (s1.equals("01"))
        {
            s = "January";
        } else
        if (s1.equals("02"))
        {
            s = "February";
        } else
        if (s1.equals("03"))
        {
            s = "March";
        } else
        if (s1.equals("04"))
        {
            s = "April";
        } else
        if (s1.equals("05"))
        {
            s = "May";
        } else
        if (s1.equals("06"))
        {
            s = "June";
        } else
        if (s1.equals("07"))
        {
            s = "July";
        } else
        if (s1.equals("08"))
        {
            s = "August";
        } else
        if (s1.equals("09"))
        {
            s = "September";
        } else
        if (s1.equals("10"))
        {
            s = "October";
        } else
        if (s1.equals("11"))
        {
            s = "November";
        } else
        {
            s = s1;
            if (s1.equals("12"))
            {
                s = "December";
            }
        }
        try
        {
            holder.tv_funadult_time.setText((new StringBuilder(String.valueOf(s))).append(DateFormat.format(" dd, yyyy", l)).toString());
        }
        catch (Exception exception) { }
        if (((FunModel)list_fun.get(ppp)).getCat().equals("adult"))
        {
            holder.bt_pics.setText((new StringBuilder(String.valueOf(((FunModel)list_fun.get(ppp)).getImg_count()))).append(" pics").toString());
            holder.bt_gif.setVisibility(8);
            holder.bt_video.setVisibility(8);
            holder.bt_pics.setVisibility(0);
            holder.iv_fun.setOnClickListener(new android.view.View.OnClickListener() {

                final Home_Listview_Adapter this$0;
                private final int val$ppp;

                public void onClick(View view)
                {
                    Log.e("www", (new StringBuilder("(Serializable) Myutils.list_fun_array=")).append(((FunModel)list_fun.get(ppp)).getFunlist()).toString());
                    view = (new StringBuilder("http://welaf.com/fun/stat.php?serial=")).append(((FunModel)list_fun.get(ppp)).getSerial()).append("&type=hit").toString();
                    Log.e("www", (new StringBuilder("url=+")).append(view).toString());
                    publicTools.getUrl(view);
                    view = new Intent(ctx, com/allinone/free/activity/FunImagePagerActivity);
                    view.putExtra("screenshotlist", ((FunModel)list_fun.get(ppp)).getFunlist());
                    view.putExtra("detailtitle", ((FunModel)list_fun.get(ppp)).getTitle());
                    view.putExtra("detailcount", ((FunModel)list_fun.get(ppp)).getImg_count());
                    ctx.startActivity(view);
                }

            
            {
                this$0 = Home_Listview_Adapter.this;
                ppp = i;
                super();
            }
            });
            holder.bt_pics.setOnClickListener(new android.view.View.OnClickListener() {

                final Home_Listview_Adapter this$0;
                private final int val$ppp;

                public void onClick(View view)
                {
                    Log.e("www", (new StringBuilder("(Serializable) Myutils.list_array=")).append(((FunModel)list_fun.get(ppp)).getFunlist()).toString());
                    view = (new StringBuilder("http://welaf.com/fun/stat.php?serial=")).append(((FunModel)list_fun.get(ppp)).getSerial()).append("&type=hit").toString();
                    Log.e("www", (new StringBuilder("url=+")).append(view).toString());
                    publicTools.getUrl(view);
                    view = new Intent(ctx, com/allinone/free/activity/FunImagePagerActivity);
                    view.putExtra("screenshotlist", ((FunModel)list_fun.get(ppp)).getFunlist());
                    view.putExtra("detailtitle", ((FunModel)list_fun.get(ppp)).getTitle());
                    view.putExtra("detailcount", ((FunModel)list_fun.get(ppp)).getImg_count());
                    ctx.startActivity(view);
                }

            
            {
                this$0 = Home_Listview_Adapter.this;
                ppp = i;
                super();
            }
            });
        } else
        if (((FunModel)list_fun.get(ppp)).getCat().equals("gif"))
        {
            holder.bt_pics.setVisibility(8);
            holder.bt_video.setVisibility(8);
            holder.bt_gif.setVisibility(0);
            holder.iv_fun.setOnClickListener(new android.view.View.OnClickListener() {

                final Home_Listview_Adapter this$0;
                private final int val$ppp;

                public void onClick(View view)
                {
                    view = (new StringBuilder("http://welaf.com/fun/stat.php?serial=")).append(((FunModel)list_fun.get(ppp)).getSerial()).append("&type=hit").toString();
                    Log.e("www", (new StringBuilder("url=+")).append(view).toString());
                    publicTools.getUrl(view);
                    view = new Intent(ctx, com/allinone/free/activity/FunGifActivity);
                    view.putExtra("fullpath", ((FunModel)list_fun.get(ppp)).getImg_src());
                    view.putExtra("apath", ((FunModel)list_fun.get(ppp)).getThu_path());
                    view.putExtra("detailtitle", ((FunModel)list_fun.get(ppp)).getTitle());
                    view.putExtra("detailcount", ((FunModel)list_fun.get(ppp)).getImg_count());
                    ctx.startActivity(view);
                }

            
            {
                this$0 = Home_Listview_Adapter.this;
                ppp = i;
                super();
            }
            });
            holder.bt_gif.setOnClickListener(new android.view.View.OnClickListener() {

                final Home_Listview_Adapter this$0;
                private final int val$ppp;

                public void onClick(View view)
                {
                    view = (new StringBuilder("http://welaf.com/fun/stat.php?serial=")).append(((FunModel)list_fun.get(ppp)).getSerial()).append("&type=hit").toString();
                    Log.e("www", (new StringBuilder("url=+")).append(view).toString());
                    publicTools.getUrl(view);
                    view = new Intent(ctx, com/allinone/free/activity/FunGifActivity);
                    view.putExtra("fullpath", ((FunModel)list_fun.get(ppp)).getImg_src());
                    view.putExtra("apath", ((FunModel)list_fun.get(ppp)).getThu_path());
                    view.putExtra("detailtitle", ((FunModel)list_fun.get(ppp)).getTitle());
                    view.putExtra("detailcount", ((FunModel)list_fun.get(ppp)).getImg_count());
                    ctx.startActivity(view);
                }

            
            {
                this$0 = Home_Listview_Adapter.this;
                ppp = i;
                super();
            }
            });
        } else
        if (((FunModel)list_fun.get(ppp)).getCat().equals("video"))
        {
            holder.bt_gif.setVisibility(8);
            holder.bt_pics.setVisibility(8);
            holder.bt_video.setVisibility(0);
            holder.iv_fun.setOnClickListener(new android.view.View.OnClickListener() {

                final Home_Listview_Adapter this$0;
                private final int val$ppp;

                public void onClick(View view)
                {
                    view = (new StringBuilder("http://welaf.com/fun/stat.php?serial=")).append(((FunModel)list_fun.get(ppp)).getSerial()).append("&type=hit").toString();
                    Log.e("www", (new StringBuilder("url=+")).append(view).toString());
                    publicTools.getUrl(view);
                    view = new Intent(ctx, com/allinone/free/activity/ShowAideoActivity);
                    view.putExtra("strurl", ((FunModel)list_fun.get(ppp)).getVideo_src());
                    ctx.startActivity(view);
                }

            
            {
                this$0 = Home_Listview_Adapter.this;
                ppp = i;
                super();
            }
            });
            holder.bt_video.setOnClickListener(new android.view.View.OnClickListener() {

                final Home_Listview_Adapter this$0;
                private final int val$ppp;

                public void onClick(View view)
                {
                    view = (new StringBuilder("http://welaf.com/fun/stat.php?serial=")).append(((FunModel)list_fun.get(ppp)).getSerial()).append("&type=hit").toString();
                    Log.e("www", (new StringBuilder("url=+")).append(view).toString());
                    publicTools.getUrl(view);
                    view = new Intent(ctx, com/allinone/free/activity/ShowAideoActivity);
                    view.putExtra("strurl", ((FunModel)list_fun.get(ppp)).getVideo_src());
                    ctx.startActivity(view);
                }

            
            {
                this$0 = Home_Listview_Adapter.this;
                ppp = i;
                super();
            }
            });
        } else
        if (((FunModel)list_fun.get(ppp)).getCat().equals("gag"))
        {
            holder.bt_gif.setVisibility(8);
            holder.bt_pics.setVisibility(8);
            holder.bt_video.setVisibility(8);
            holder.iv_fun.setOnClickListener(new android.view.View.OnClickListener() {

                final Home_Listview_Adapter this$0;
                private final int val$ppp;

                public void onClick(View view)
                {
                    Log.e("www", (new StringBuilder("(Serializable) Myutils.list_array=")).append(((FunModel)list_fun.get(ppp)).getFunlist()).toString());
                    view = (new StringBuilder("http://welaf.com/fun/stat.php?serial=")).append(((FunModel)list_fun.get(ppp)).getSerial()).append("&type=hit").toString();
                    Log.e("www", (new StringBuilder("url=+")).append(view).toString());
                    publicTools.getUrl(view);
                    view = new Intent(ctx, com/allinone/free/activity/FunImagePagerActivity);
                    view.putExtra("screenshotlist", ((FunModel)list_fun.get(ppp)).getFunlist());
                    view.putExtra("detailtitle", ((FunModel)list_fun.get(ppp)).getTitle());
                    view.putExtra("detailcount", ((FunModel)list_fun.get(ppp)).getImg_count());
                    ctx.startActivity(view);
                }

            
            {
                this$0 = Home_Listview_Adapter.this;
                ppp = i;
                super();
            }
            });
        }
        holder.rl_like.setOnClickListener(new android.view.View.OnClickListener() {

            final Home_Listview_Adapter this$0;
            private final int val$ppp;

            public void onClick(View view)
            {
                String s2 = (new StringBuilder("http://welaf.com/fun/stat.php?serial=")).append(((FunModel)list_fun.get(ppp)).getSerial()).append("&type=like").toString();
                Log.e("www", (new StringBuilder("url=+")).append(s2).toString());
                publicTools.getUrl(s2);
                ((RelativeLayout)view).setBackgroundResource(0x7f08002c);
            }

            
            {
                this$0 = Home_Listview_Adapter.this;
                ppp = i;
                super();
            }
        });
        holder.bt_share.setOnClickListener(new android.view.View.OnClickListener() {

            final Home_Listview_Adapter this$0;
            private final int val$ppp;

            public void onClick(View view)
            {
                String s2 = (new StringBuilder("http://welaf.com/fun/stat.php?serial=")).append(((FunModel)list_fun.get(ppp)).getSerial()).append("&type=share").toString();
                Log.e("www", (new StringBuilder("url=+")).append(s2).toString());
                publicTools.getUrl(s2);
                ((Button)view).setBackgroundResource(0x7f08002c);
                view = new Intent("android.intent.action.SEND");
                view.setType("text/plain");
                view.putExtra("android.intent.extra.TEXT", "http://tinyurl.com/allinone-downloader");
                ctx.startActivity(Intent.createChooser(view, "AIO Downloaded"));
            }

            
            {
                this$0 = Home_Listview_Adapter.this;
                ppp = i;
                super();
            }
        });
        app.asyncLoadImage(((FunModel)list_fun.get(ppp)).getThu_path(), holder.iv_fun);
    }


}
