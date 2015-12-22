// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.adwall;

import android.util.Log;
import com.yeahmobi.android.common.AdResponse;
import com.yeahmobi.android.common.OnAdReceiveListener;
import com.yeahmobi.android.utils.DataUtil;
import java.util.List;

// Referenced classes of package com.yeahmobi.android.adwall:
//            YMAdWallWebView

class this._cls0
    implements OnAdReceiveListener
{

    final YMAdWallWebView this$0;

    public void onAdFail(String s)
    {
        Log.e(YMAdWallWebView.access$000(YMAdWallWebView.this), (new StringBuilder()).append("[load ad fial]:").append(s).toString());
    }

    public void onAdReceive(List list)
    {
        StringBuilder stringbuilder = new StringBuilder("");
        Log.e(YMAdWallWebView.access$000(YMAdWallWebView.this), (new StringBuilder()).append("[onAdReceive]").append(list.size()).toString());
        int i = 0;
        while (i < list.size()) 
        {
            Object obj = (AdResponse)list.get(i);
            String s = ((AdResponse) (obj)).getPackageName();
            String s1 = ((AdResponse) (obj)).getIconImageUrl();
            String s2 = ((AdResponse) (obj)).getClickDestinationUrl();
            String s3 = ((AdResponse) (obj)).getTitle();
            ((AdResponse) (obj)).getMainContent();
            obj = ((AdResponse) (obj)).getClickRecordUrl();
            Log.e(YMAdWallWebView.access$000(YMAdWallWebView.this), (new StringBuilder()).append("Loading with pkg_name[").append(s).append("]").toString());
            s = html_dom_ul_li_template.replaceAll(DataUtil.macroNameWrapper2("click_track_url"), ((String) (obj))).replaceAll(DataUtil.macroNameWrapper2("img_url"), s1).replaceAll(DataUtil.macroNameWrapper2("target_url"), s2).replaceAll(DataUtil.macroNameWrapper2("title"), s3).replaceAll(DataUtil.macroNameWrapper2("description"), "1280 download   2.216M").replaceAll(DataUtil.macroNameWrapper2("btn_txt"), "Install");
            if (i % 2 == 0)
            {
                s = s.replaceAll(DataUtil.macroNameWrapper2("css_class_halving_line_vertical"), " halving-line-vertical");
            } else
            {
                s = s.replaceAll(DataUtil.macroNameWrapper2("css_class_halving_line_vertical"), "");
            }
            stringbuilder.append(s);
            Log.e(YMAdWallWebView.access$000(YMAdWallWebView.this), (new StringBuilder()).append("html_dom_ul_li=").append(s).toString());
            i++;
        }
        list = html_dom_body_contents_templeate.replaceAll(DataUtil.macroNameWrapper2("html_dom_ul_li"), stringbuilder.toString()).replaceAll(DataUtil.macroNameWrapper2("page_title"), "H5 ads demo");
        list = html_templeate.replaceAll(DataUtil.macroNameWrapper2("html_dom_style_css"), html_dom_style_css).replaceAll(DataUtil.macroNameWrapper2("page_title"), page_title).replaceAll(DataUtil.macroNameWrapper2("html_dom_body_contents"), list);
        Log.e(YMAdWallWebView.access$000(YMAdWallWebView.this), (new StringBuilder()).append("html_code=").append(list).toString());
        loadFromHtml(list);
    }

    r()
    {
        this$0 = YMAdWallWebView.this;
        super();
    }
}
