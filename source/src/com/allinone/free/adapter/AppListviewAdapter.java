// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import com.allinone.free.db.TypeDbUtils;
import com.allinone.free.dialog.LianwangDialog;
import com.allinone.free.mydownload.ContentValue;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.mydownload.MyApplcation;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.NetWorkUtil;
import com.allinone.free.utils.publicTools;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.tsz.afinal.FinalDBChen;

public class AppListviewAdapter extends BaseAdapter
    implements ContentValue
{
    class ViewHolder
    {

        private Button app_download_bt;
        private RatingBar app_ratingbar;
        private TextView appauthortitle;
        private ImageView appicon;
        private TextView appprice;
        private TextView apptitle;
        private ImageView playtop;
        final AppListviewAdapter this$0;
        private TextView xian;
















        ViewHolder()
        {
            this$0 = AppListviewAdapter.this;
            super();
        }
    }


    private MyApplcation app;
    private String apptag;
    private Context ctx;
    private FinalDBChen db;
    private TypeDbUtils dbUtils;
    private HashMap default_options;
    private android.content.SharedPreferences.Editor edit;
    Handler handler;
    private HashMap headers;
    private ViewHolder holder;
    private Boolean istag;
    private List list;
    private Context mContext;
    private MyApplcation myApp;
    private publicTools publictools;
    private SharedPreferences sp;
    private SharedPreferences sp2;
    private SharedPreferences sp3;
    private SharedPreferences spnetworkre;
    private Typeface typeFace;
    private Typeface typeFace2;

    public AppListviewAdapter(Context context, List list1, String s)
    {
        handler = new Handler() {

            final AppListviewAdapter this$0;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                switch (message.what)
                {
                default:
                    return;

                case 1: // '\001'
                    Toast.makeText(ctx, "Failed to connect server.", 0).show();
                    return;

                case 2: // '\002'
                    Mydialog();
                    return;

                case 3: // '\003'
                    istag = Boolean.valueOf(true);
                    break;
                }
                Toast.makeText(ctx, (new StringBuilder("'")).append(sp2.getString("appname", ": this app")).append("' is added to download queue.").toString(), 0).show();
                (new Thread(new Runnable() {

                    final _cls1 this$1;

                    public void run()
                    {
                        publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(sp3.getString("appid", "invalid")).append("&from=apk&add_to_list=1").toString());
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                })).start();
                message = new Intent();
                if (!apptag.equals("app1") && !apptag.equals("app2") && !apptag.equals("app3") && !apptag.equals("app4") && !apptag.equals("app5")) goto _L2; else goto _L1
_L1:
                message.setAction("app");
_L4:
                ctx.sendBroadcast(message);
                return;
_L2:
                if (apptag.equals("game1") || apptag.equals("game2") || apptag.equals("game3") || apptag.equals("game4") || apptag.equals("game5"))
                {
                    message.setAction("game");
                } else
                if (apptag.equals("paid1") || apptag.equals("paid2") || apptag.equals("paid3") || apptag.equals("paid4") || apptag.equals("paid5"))
                {
                    message.setAction("paid");
                } else
                if (apptag.equals("adult1") || apptag.equals("adult2") || apptag.equals("adult3") || apptag.equals("adult4"))
                {
                    message.setAction("adult");
                } else
                if (apptag.equals("homeapp"))
                {
                    message.setAction("homeapp");
                } else
                if (apptag.equals("appsearch"))
                {
                    message.setAction("hideappsearch");
                }
                if (true) goto _L4; else goto _L3
_L3:
            }


            
            {
                this$0 = AppListviewAdapter.this;
                super();
            }
        };
        istag = Boolean.valueOf(false);
        publictools = null;
        dbUtils = null;
        typeFace = null;
        holder = null;
        try
        {
            typeFace = Typeface.createFromAsset(context.getAssets(), "Roboto-Light.ttf");
            typeFace2 = Typeface.createFromAsset(context.getAssets(), "Roboto-Condensed.ttf");
        }
        catch (Exception exception) { }
        ctx = context;
        list = list1;
        apptag = s;
        try
        {
            app = (MyApplcation)context.getApplicationContext();
            initView();
            publictools = new publicTools(context);
            headers = new HashMap();
            headers.put("AIOD", "1");
            headers.put("Referer", publicTools.get_a_random_user_webview());
            default_options = new HashMap();
            default_options.put("save_cookie", Integer.valueOf(0));
            default_options.put("send_cookie", Integer.valueOf(0));
            default_options.put("show_header", Integer.valueOf(0));
            default_options.put("redirect", Integer.valueOf(1));
            if (dbUtils == null)
            {
                dbUtils = new TypeDbUtils(context);
            }
            spnetworkre = context.getSharedPreferences("network", 0);
            db = new FinalDBChen(getmContext(), context.getDatabasePath("download2.db").getAbsolutePath());
            sp2 = context.getSharedPreferences("name", 0);
            sp3 = context.getSharedPreferences("appid", 0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    private void Mydialog()
    {
        (new android.app.AlertDialog.Builder(ctx)).setTitle(ctx.getString(0x7f0b003e)).setMessage("It has been in downloading list already.").setPositiveButton("Ok", new android.content.DialogInterface.OnClickListener() {

            final AppListviewAdapter this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = AppListviewAdapter.this;
                super();
            }
        }).show();
    }

    private void downwifi()
    {
        final LianwangDialog dialog = new LianwangDialog(ctx, 0x7f0c0064);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        Button button = (Button)dialog.findViewById(0x7f06018a);
        Button button1 = (Button)dialog.findViewById(0x7f06018b);
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final AppListviewAdapter this$0;
            private final LianwangDialog val$dialog;

            public void onClick(View view)
            {
                dialog.dismiss();
            }

            
            {
                this$0 = AppListviewAdapter.this;
                dialog = lianwangdialog;
                super();
            }
        });
        button1.setOnClickListener(new android.view.View.OnClickListener() {

            final AppListviewAdapter this$0;
            private final LianwangDialog val$dialog;

            public void onClick(View view)
            {
                ctx.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
                dialog.dismiss();
            }

            
            {
                this$0 = AppListviewAdapter.this;
                dialog = lianwangdialog;
                super();
            }
        });
    }

    public void MydownloadApk(final String id, final String title, String s, int i)
    {
        publicTools.keyid = id;
        final long final_l = (long)Math.floor(System.currentTimeMillis() / 1000L);
        final String final_s1 = publicTools.getCode(id, final_l);
        Log.v("rfrf", (new StringBuilder("111111")).append(final_s1).toString());
        if (final_s1.equals(""))
        {
            Toast.makeText(ctx, "Failed to connect server. Please try again.", 0).show();
            return;
        } else
        {
            (new AsyncTask(s, i) {

                String content;
                DownloadMovieItem d;
                HashMap options;
                final AppListviewAdapter this$0;
                String url;
                private final int val$appserial;
                private final String val$icon;
                private final String val$id;
                private final String val$title;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    options = default_options;
                    options.put("show_header", Integer.valueOf(1));
                    options.put("redirect", Integer.valueOf(0));
                    options.put("send_cookie", Integer.valueOf(0));
                    content = publicTools.getDataFromURL(url, options);
                    if (!content.contains("Location"))
                    {
                        url = (new StringBuilder(String.valueOf(url))).append("&debug=1").toString();
                        options.put("redirect", Integer.valueOf(1));
                        content = publicTools.getDataFromURL(url, options);
                    }
                    avoid = "";
                    Matcher matcher = Pattern.compile("aio_swf_download_link: ([^\n\r\t]+)").matcher(content);
                    if (matcher.find())
                    {
                        avoid = matcher.group(1);
                    } else
                    {
                        Matcher matcher1 = Pattern.compile("Location: ([^\n\r\t]+)").matcher(content);
                        if (matcher1.find())
                        {
                            avoid = matcher1.group(1);
                        }
                    }
                    Log.v("rtyu", (new StringBuilder(String.valueOf(content))).append("*******").toString());
                    Log.v("rfrf", (new StringBuilder("22222")).append(avoid).toString());
                    if (TextUtils.isEmpty(avoid))
                    {
                        avoid = new Message();
                        avoid.what = 1;
                        handler.sendMessage(avoid);
                        if (content.length() > 100)
                        {
                            avoid = content.substring(0, 100);
                        } else
                        {
                            avoid = content;
                        }
                        publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=downloading&id=")).append(id).append("&status=fail_get_url&version=").append("3.0.9").append("&content=").append(avoid).toString());
                    } else
                    if (db.findItemsByWhereAndWhereValue("downloadUrl", avoid, com/allinone/free/mydownload/DownloadMovieItem, "downloadtask2", null).size() > 0)
                    {
                        avoid = new Message();
                        avoid.what = 2;
                        handler.sendMessage(avoid);
                    } else
                    {
                        String s1 = (new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()))).append(File.separator).append(ctx.getPackageName()).toString(), (new StringBuilder(String.valueOf(id))).append(".apk").toString())).getAbsolutePath();
                        d.setDownloadUrl(avoid);
                        d.setFilePath(s1);
                        Log.v("fefe", avoid);
                        d.setDownloadState(Integer.valueOf(4));
                        d.setMovieName(title);
                        d.setMovieHeadImagePath(icon);
                        d.setFile_id(id);
                        d.setTitle(title);
                        d.setSerial(appserial);
                        d.setType("app");
                        d.setCreate_time(Long.valueOf(System.currentTimeMillis()));
                        toDownload(d);
                        Myutils.getInstance();
                        Myutils.list.add(d);
                        avoid = new Message();
                        avoid.what = 3;
                        handler.sendMessage(avoid);
                        istag = Boolean.valueOf(true);
                    }
                    return null;
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Void)obj);
                }

                protected void onPostExecute(Void void1)
                {
                    super.onPostExecute(void1);
                    void1 = new Intent();
                    if (apptag.equals("app1"))
                    {
                        void1.setAction("hideapp1");
                    } else
                    if (apptag.equals("app2"))
                    {
                        void1.setAction("hideapp2");
                    } else
                    if (apptag.equals("app3"))
                    {
                        void1.setAction("hideapp3");
                    } else
                    if (apptag.equals("app4"))
                    {
                        void1.setAction("hideapp4");
                    } else
                    if (apptag.equals("app5"))
                    {
                        void1.setAction("hideapp5");
                    }
                    if (apptag.equals("game1"))
                    {
                        void1.setAction("hidegame1");
                    } else
                    if (apptag.equals("game2"))
                    {
                        void1.setAction("hidegame2");
                    } else
                    if (apptag.equals("game3"))
                    {
                        void1.setAction("hidegame3");
                    } else
                    if (apptag.equals("game4"))
                    {
                        void1.setAction("hidegame4");
                    } else
                    if (apptag.equals("game5"))
                    {
                        void1.setAction("hidegame5");
                    }
                    if (apptag.equals("paid1"))
                    {
                        void1.setAction("hidepaid1");
                    } else
                    if (apptag.equals("paid2"))
                    {
                        void1.setAction("hidepaid2");
                    } else
                    if (apptag.equals("paid3"))
                    {
                        void1.setAction("hidepaid3");
                    } else
                    if (apptag.equals("paid4"))
                    {
                        void1.setAction("hidepaid4");
                    } else
                    if (apptag.equals("paid5"))
                    {
                        void1.setAction("hidepaid5");
                    }
                    if (apptag.equals("adult1"))
                    {
                        void1.setAction("hideadult1");
                    } else
                    if (apptag.equals("adult2"))
                    {
                        void1.setAction("hideadult2");
                    } else
                    if (apptag.equals("adult3"))
                    {
                        void1.setAction("hideadult3");
                    } else
                    if (apptag.equals("adult4"))
                    {
                        void1.setAction("hideadult4");
                    } else
                    if (apptag.equals("homeapp"))
                    {
                        void1.setAction("hidehomeapp");
                    } else
                    if (apptag.equals("appsearch"))
                    {
                        void1.setAction("hideappsearch");
                    }
                    ctx.sendBroadcast(void1);
                }

                protected void onPreExecute()
                {
                    super.onPreExecute();
                    Intent intent = new Intent();
                    if (apptag.equals("app1"))
                    {
                        intent.setAction("showapp1");
                    } else
                    if (apptag.equals("app2"))
                    {
                        intent.setAction("showapp2");
                    } else
                    if (apptag.equals("app3"))
                    {
                        intent.setAction("showapp3");
                    } else
                    if (apptag.equals("app4"))
                    {
                        intent.setAction("showapp4");
                    } else
                    if (apptag.equals("app5"))
                    {
                        intent.setAction("showapp5");
                    }
                    if (apptag.equals("game1"))
                    {
                        intent.setAction("showgame1");
                    } else
                    if (apptag.equals("game2"))
                    {
                        intent.setAction("showgame2");
                    } else
                    if (apptag.equals("game3"))
                    {
                        intent.setAction("showgame3");
                    } else
                    if (apptag.equals("game4"))
                    {
                        intent.setAction("showgame4");
                    } else
                    if (apptag.equals("game5"))
                    {
                        intent.setAction("showgame5");
                    }
                    if (apptag.equals("paid1"))
                    {
                        intent.setAction("showpaid1");
                    } else
                    if (apptag.equals("paid2"))
                    {
                        intent.setAction("showpaid2");
                    } else
                    if (apptag.equals("paid3"))
                    {
                        intent.setAction("showpaid3");
                    } else
                    if (apptag.equals("paid4"))
                    {
                        intent.setAction("showpaid4");
                    } else
                    if (apptag.equals("paid5"))
                    {
                        intent.setAction("showpaid5");
                    }
                    if (apptag.equals("adult1"))
                    {
                        intent.setAction("showadult1");
                    } else
                    if (apptag.equals("adult2"))
                    {
                        intent.setAction("showadult2");
                    } else
                    if (apptag.equals("adult3"))
                    {
                        intent.setAction("showadult3");
                    } else
                    if (apptag.equals("adult4"))
                    {
                        intent.setAction("showadult4");
                    } else
                    if (apptag.equals("homeapp"))
                    {
                        intent.setAction("showhomeapp");
                    } else
                    if (apptag.equals("appsearch"))
                    {
                        intent.setAction("showappsearch");
                    }
                    ctx.sendBroadcast(intent);
                }

            
            {
                this$0 = AppListviewAdapter.this;
                id = s;
                title = s2;
                icon = s3;
                appserial = i;
                super();
                d = new DownloadMovieItem();
                url = (new StringBuilder("http://android.downloadatoz.com/_201409/market/app_get_apk.php?id=")).append(s).append("&stamp=").append(final_s1).append("&time=").append(final_l).append("&version=").append("3.0.9").toString();
                options = new HashMap();
                content = "";
            }
            }).execute(new Void[0]);
            return;
        }
    }

    public void addItem(ArrayList arraylist)
    {
        list.addAll(arraylist);
        notifyDataSetChanged();
    }

    public boolean getBooleanValueByConfigFile(String s)
    {
        return getSp().getBoolean(s, false);
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

    public android.content.SharedPreferences.Editor getEdit()
    {
        return edit;
    }

    public int getIntegerValueByConfigFile(String s)
    {
        return getSp().getInt(s, -1);
    }

    public Object getItem(int i)
    {
        return list.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public MyApplcation getMyApp()
    {
        return myApp;
    }

    public SharedPreferences getSp()
    {
        return sp;
    }

    public String getStringValueByConfigFile(String s)
    {
        return sp.getString(s, "");
    }

    public View getView(int i, View view, final ViewGroup in_fo)
    {
        in_fo = (DownloadMovieItem)list.get(i);
        final String has_apk;
        String s;
        if (view == null)
        {
            holder = new ViewHolder();
            view = View.inflate(ctx, 0x7f030027, null);
            holder.appicon = (ImageView)view.findViewById(0x7f0600b6);
            holder.apptitle = (TextView)view.findViewById(0x7f0600b7);
            holder.playtop = (ImageView)view.findViewById(0x7f0600a7);
            holder.appprice = (TextView)view.findViewById(0x7f0600bb);
            holder.appauthortitle = (TextView)view.findViewById(0x7f0600b8);
            holder.app_ratingbar = (RatingBar)view.findViewById(0x7f0600b9);
            holder.app_download_bt = (Button)view.findViewById(0x7f0600ba);
            holder.xian = (TextView)view.findViewById(0x7f0600bc);
            view.setTag(holder);
        } else
        {
            holder = (ViewHolder)view.getTag();
        }
        holder.apptitle.setText(in_fo.getTitle());
        holder.apptitle.setTypeface(typeFace);
        holder.appauthortitle.setText(in_fo.getAuthor_title());
        holder.appauthortitle.setTypeface(typeFace2);
        holder.appprice.setText(in_fo.getPrice());
        holder.app_ratingbar.setRating(in_fo.getRating().floatValue());
        app.asyncLoadImage(in_fo.getIcon(), holder.appicon);
        if (apptag.equals("paid1") || apptag.equals("paid2") || apptag.equals("paid3") || apptag.equals("paid4") || apptag.equals("paid5"))
        {
            holder.appprice.setTextColor(-23030);
            holder.appprice.getPaint().setFlags(16);
        }
        has_apk = in_fo.getHas_apk();
        s = in_fo.getIs_official();
        if (s.equals("1"))
        {
            holder.playtop.setVisibility(0);
        } else
        if (s.equals("0"))
        {
            holder.playtop.setVisibility(8);
        }
        if (has_apk.equals("1"))
        {
            holder.app_download_bt.setBackgroundResource(0x7f020075);
        } else
        if (has_apk.equals("0"))
        {
            holder.app_download_bt.setBackgroundResource(0x7f0200e1);
        }
        holder.app_download_bt.setOnClickListener(new android.view.View.OnClickListener() {

            final AppListviewAdapter this$0;
            private final String val$has_apk;
            private final DownloadMovieItem val$in_fo;

            public void onClick(View view1)
            {
                sp2.edit().putString("appname", in_fo.getTitle()).commit();
                sp3.edit().putString("appid", in_fo.getId()).commit();
                if (!has_apk.equals("1")) goto _L2; else goto _L1
_L1:
                (new Thread(in_fo. new Runnable() {

                    final _cls2 this$1;
                    private final DownloadMovieItem val$in_fo;

                    public void run()
                    {
                        publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(in_fo.getId()).append("&from=apk").toString());
                    }

            
            {
                this$1 = final__pcls2;
                in_fo = DownloadMovieItem.this;
                super();
            }
                })).start();
                if (!spnetworkre.getBoolean("isopen", false) || NetWorkUtil.getAPNType(ctx) == 1) goto _L4; else goto _L3
_L3:
                downwifi();
_L6:
                return;
_L4:
                if (dbUtils.queryfile(in_fo.getId()) == null)
                {
                    MydownloadApk(in_fo.getId(), in_fo.getTitle(), in_fo.getIcon(), in_fo.getSerial());
                    return;
                } else
                {
                    Mydialog();
                    return;
                }
_L2:
                if (has_apk.equals("0"))
                {
                    (new Thread(in_fo. new Runnable() {

                        final _cls2 this$1;
                        private final DownloadMovieItem val$in_fo;

                        public void run()
                        {
                            try
                            {
                                publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(in_fo.getId()).append("&from=google").toString());
                                return;
                            }
                            catch (Exception exception)
                            {
                                return;
                            }
                        }

            
            {
                this$1 = final__pcls2;
                in_fo = DownloadMovieItem.this;
                super();
            }
                    })).start();
                    view1 = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://play.google.com/store/apps/details?id=")).append(in_fo.getId()).toString()));
                    ctx.startActivity(view1);
                    return;
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            
            {
                this$0 = AppListviewAdapter.this;
                in_fo = downloadmovieitem;
                has_apk = s;
                super();
            }
        });
        return view;
    }

    public Context getmContext()
    {
        return mContext;
    }

    public void initView()
    {
        try
        {
            MyApplcation myapplcation = (MyApplcation)ctx.getApplicationContext();
            setSp(ctx.getSharedPreferences("config", 0));
            edit = getSp().edit();
            setMyApp(myapplcation);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public boolean putBooleanValueToConfigFile(String s, boolean flag)
    {
        android.content.SharedPreferences.Editor editor = getSp().edit();
        editor.putBoolean(s, flag);
        return editor.commit();
    }

    public boolean putStringValueToConfigFile(String s, int i)
    {
        android.content.SharedPreferences.Editor editor = getSp().edit();
        editor.putInt(s, i);
        return editor.commit();
    }

    public boolean putStringValueToConfigFile(String s, String s1)
    {
        android.content.SharedPreferences.Editor editor = getSp().edit();
        editor.putString(s, s1);
        return editor.commit();
    }

    public void setEdit(android.content.SharedPreferences.Editor editor)
    {
        edit = editor;
    }

    public void setMyApp(MyApplcation myapplcation)
    {
        myApp = myapplcation;
    }

    public void setSp(SharedPreferences sharedpreferences)
    {
        sp = sharedpreferences;
    }

    public void setmContext(Context context)
    {
        mContext = context;
    }

    public void toDownload(DownloadMovieItem downloadmovieitem)
    {
        downloadmovieitem.setDownloadState(Integer.valueOf(7));
        getMyApp().setStartDownloadMovieItem(downloadmovieitem);
        ctx.sendBroadcast((new Intent()).setAction("download"));
        if (db.findItemsByWhereAndWhereValue("movieName", downloadmovieitem.getMovieName(), com/allinone/free/mydownload/DownloadMovieItem, "downloadtask2", null).size() == 0)
        {
            db.insertObject(downloadmovieitem, "downloadtask2");
            return;
        } else
        {
            db.updateValuesByJavaBean("downloadtask2", "movieName=?", new String[] {
                downloadmovieitem.getMovieName()
            }, downloadmovieitem);
            return;
        }
    }












}
