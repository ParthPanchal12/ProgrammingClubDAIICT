// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.adwall;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.WebView;
import com.yeahmobi.android.common.AdManager;
import com.yeahmobi.android.common.AdResponse;
import com.yeahmobi.android.common.IconSize;
import com.yeahmobi.android.common.OnAdReceiveListener;
import com.yeahmobi.android.common.YMWebViewStyle;
import com.yeahmobi.android.utils.DataUtil;
import com.yeahmobi.android.utils.StringUtils;
import java.util.List;

public class YMAdWallWebView extends WebView
{

    private String TAG;
    private AdManager adManager;
    String html_dom_body_contents_templeate;
    String html_dom_style_css;
    String html_dom_ul_li_template;
    String html_templeate;
    private IconSize iconSize;
    OnAdReceiveListener onAdReceiveListener = new OnAdReceiveListener() {

        final YMAdWallWebView this$0;

        public void onAdFail(String s)
        {
            Log.e(TAG, (new StringBuilder()).append("[load ad fial]:").append(s).toString());
        }

        public void onAdReceive(List list)
        {
            StringBuilder stringbuilder = new StringBuilder("");
            Log.e(TAG, (new StringBuilder()).append("[onAdReceive]").append(list.size()).toString());
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
                Log.e(TAG, (new StringBuilder()).append("Loading with pkg_name[").append(s).append("]").toString());
                s = html_dom_ul_li_template.replaceAll(DataUtil.macroNameWrapper2("click_track_url"), ((String) (obj))).replaceAll(DataUtil.macroNameWrapper2("img_url"), s1).replaceAll(DataUtil.macroNameWrapper2("target_url"), s2).replaceAll(DataUtil.macroNameWrapper2("title"), s3).replaceAll(DataUtil.macroNameWrapper2("description"), "1280 download   2.216M").replaceAll(DataUtil.macroNameWrapper2("btn_txt"), "Install");
                if (i % 2 == 0)
                {
                    s = s.replaceAll(DataUtil.macroNameWrapper2("css_class_halving_line_vertical"), " halving-line-vertical");
                } else
                {
                    s = s.replaceAll(DataUtil.macroNameWrapper2("css_class_halving_line_vertical"), "");
                }
                stringbuilder.append(s);
                Log.e(TAG, (new StringBuilder()).append("html_dom_ul_li=").append(s).toString());
                i++;
            }
            list = html_dom_body_contents_templeate.replaceAll(DataUtil.macroNameWrapper2("html_dom_ul_li"), stringbuilder.toString()).replaceAll(DataUtil.macroNameWrapper2("page_title"), "H5 ads demo");
            list = html_templeate.replaceAll(DataUtil.macroNameWrapper2("html_dom_style_css"), html_dom_style_css).replaceAll(DataUtil.macroNameWrapper2("page_title"), page_title).replaceAll(DataUtil.macroNameWrapper2("html_dom_body_contents"), list);
            Log.e(TAG, (new StringBuilder()).append("html_code=").append(list).toString());
            loadFromHtml(list);
        }

            
            {
                this$0 = YMAdWallWebView.this;
                super();
            }
    };
    String page_title;
    private YMWebViewStyle style;

    public YMAdWallWebView(Context context)
    {
        super(context);
        TAG = com/yeahmobi/android/adwall/YMAdWallWebView.getSimpleName();
        page_title = "";
        html_templeate = "<!DOCTYPE html><html lang=\"zh-cn\"><head><meta charset=\"utf-8\"><meta name=\"viewport\" content=\"width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no\"/><title>${page_title}</title>${html_dom_style_css}</head><body>${html_dom_body_contents}</body></html>";
        html_dom_style_css = "<style type=\"text/css\">@charset \"utf-8\";*{margin:0;padding:0}.list-cont img{border:0}.list-cont{width:100%}.list-cont-head{background-color:#f8f8f8;border-bottom:1px solid #ddd;padding:10px}.list-cont-head h3{color:#000;font-weight:normal;font-size:12px}.list-cont-body{background-color:#FFF}.app-list-item{display:block;float:left;width:50%}.app-list-item-link{display:block;padding:12px 10px;text-decoration:none}.app-list-item-icon{float:left}.app-list-item-icon,.app-list-item-icon img{width:60px;height:60px;overflow:hidden;border-radius:5px}.app-list-item-cont{margin-left:70px;overflow:hidden;height:60px;position:relative}.app-list-item-cont h3,.app-list-item-cont h4{font-weight:normal}.app-list-item-cont h3{font-size:14px;color:#000}.app-list-item-cont h4{font-size:12px;color:#999;margin-top:3px}.app-list-download-btn{position:absolute;right:10px;bottom:0;font-size:12px;color:#74b000;border-radius:5px;border:1px solid #74b000;padding:4px 20px}.halving-line-vertical{border-right:1px #dfdfdf dotted}.halving-line-horizontal{border-bottom:1px #dfdfdf dotted}.clearfix:after{visibility:hidden;display:block;font-size:0;content:\" \";clear:both;height:0}.clearfix{display:block;overflow:hidden}@media(max-width:600px){.list-cont{width:100%;margin-left:0}.halving-line-horizontal{border-bottom:0}.halving-line-vertical{border-right:0}.app-list-item-link{border-bottom:1px #dfdfdf dotted}.app-list-item{float:none}.app-list-item{width:100%}}@media(max-width:320px){.list-cont{width:320px}}</style>";
        html_dom_ul_li_template = "<li class=\"app-list-item\"> <a href=\"${target_url}\" onclick=\"document.getElementById('track_click_img').src='${click_track_url}';\" class=\"app-list-item-link  halving-line-horizontal${css_class_halving_line_vertical}\"><div class=\"app-list-item-icon\"><img src=\"${img_url}\"></div><div class=\"app-list-item-cont clearfix\"><h3>${title}</h3><h4>${description}</h4><div class=\"app-list-download-btn\">${btn_txt}</div></div></a></li>";
        html_dom_body_contents_templeate = "<div id=\"list-cont\" class=\"list-cont\"><div class=\"list-cont-head\"><h3>${page_title}</h3></div><div class=\"list-cont-body\"><img id=\"track_click_img\" style=\"display:none;\" /><ul class=\"app-list clearfix\">${html_dom_ul_li}</ul></div></div>";
    }

    public YMAdWallWebView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        TAG = com/yeahmobi/android/adwall/YMAdWallWebView.getSimpleName();
        page_title = "";
        html_templeate = "<!DOCTYPE html><html lang=\"zh-cn\"><head><meta charset=\"utf-8\"><meta name=\"viewport\" content=\"width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no\"/><title>${page_title}</title>${html_dom_style_css}</head><body>${html_dom_body_contents}</body></html>";
        html_dom_style_css = "<style type=\"text/css\">@charset \"utf-8\";*{margin:0;padding:0}.list-cont img{border:0}.list-cont{width:100%}.list-cont-head{background-color:#f8f8f8;border-bottom:1px solid #ddd;padding:10px}.list-cont-head h3{color:#000;font-weight:normal;font-size:12px}.list-cont-body{background-color:#FFF}.app-list-item{display:block;float:left;width:50%}.app-list-item-link{display:block;padding:12px 10px;text-decoration:none}.app-list-item-icon{float:left}.app-list-item-icon,.app-list-item-icon img{width:60px;height:60px;overflow:hidden;border-radius:5px}.app-list-item-cont{margin-left:70px;overflow:hidden;height:60px;position:relative}.app-list-item-cont h3,.app-list-item-cont h4{font-weight:normal}.app-list-item-cont h3{font-size:14px;color:#000}.app-list-item-cont h4{font-size:12px;color:#999;margin-top:3px}.app-list-download-btn{position:absolute;right:10px;bottom:0;font-size:12px;color:#74b000;border-radius:5px;border:1px solid #74b000;padding:4px 20px}.halving-line-vertical{border-right:1px #dfdfdf dotted}.halving-line-horizontal{border-bottom:1px #dfdfdf dotted}.clearfix:after{visibility:hidden;display:block;font-size:0;content:\" \";clear:both;height:0}.clearfix{display:block;overflow:hidden}@media(max-width:600px){.list-cont{width:100%;margin-left:0}.halving-line-horizontal{border-bottom:0}.halving-line-vertical{border-right:0}.app-list-item-link{border-bottom:1px #dfdfdf dotted}.app-list-item{float:none}.app-list-item{width:100%}}@media(max-width:320px){.list-cont{width:320px}}</style>";
        html_dom_ul_li_template = "<li class=\"app-list-item\"> <a href=\"${target_url}\" onclick=\"document.getElementById('track_click_img').src='${click_track_url}';\" class=\"app-list-item-link  halving-line-horizontal${css_class_halving_line_vertical}\"><div class=\"app-list-item-icon\"><img src=\"${img_url}\"></div><div class=\"app-list-item-cont clearfix\"><h3>${title}</h3><h4>${description}</h4><div class=\"app-list-download-btn\">${btn_txt}</div></div></a></li>";
        html_dom_body_contents_templeate = "<div id=\"list-cont\" class=\"list-cont\"><div class=\"list-cont-head\"><h3>${page_title}</h3></div><div class=\"list-cont-body\"><img id=\"track_click_img\" style=\"display:none;\" /><ul class=\"app-list clearfix\">${html_dom_ul_li}</ul></div></div>";
    }

    public YMAdWallWebView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        TAG = com/yeahmobi/android/adwall/YMAdWallWebView.getSimpleName();
        page_title = "";
        html_templeate = "<!DOCTYPE html><html lang=\"zh-cn\"><head><meta charset=\"utf-8\"><meta name=\"viewport\" content=\"width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no\"/><title>${page_title}</title>${html_dom_style_css}</head><body>${html_dom_body_contents}</body></html>";
        html_dom_style_css = "<style type=\"text/css\">@charset \"utf-8\";*{margin:0;padding:0}.list-cont img{border:0}.list-cont{width:100%}.list-cont-head{background-color:#f8f8f8;border-bottom:1px solid #ddd;padding:10px}.list-cont-head h3{color:#000;font-weight:normal;font-size:12px}.list-cont-body{background-color:#FFF}.app-list-item{display:block;float:left;width:50%}.app-list-item-link{display:block;padding:12px 10px;text-decoration:none}.app-list-item-icon{float:left}.app-list-item-icon,.app-list-item-icon img{width:60px;height:60px;overflow:hidden;border-radius:5px}.app-list-item-cont{margin-left:70px;overflow:hidden;height:60px;position:relative}.app-list-item-cont h3,.app-list-item-cont h4{font-weight:normal}.app-list-item-cont h3{font-size:14px;color:#000}.app-list-item-cont h4{font-size:12px;color:#999;margin-top:3px}.app-list-download-btn{position:absolute;right:10px;bottom:0;font-size:12px;color:#74b000;border-radius:5px;border:1px solid #74b000;padding:4px 20px}.halving-line-vertical{border-right:1px #dfdfdf dotted}.halving-line-horizontal{border-bottom:1px #dfdfdf dotted}.clearfix:after{visibility:hidden;display:block;font-size:0;content:\" \";clear:both;height:0}.clearfix{display:block;overflow:hidden}@media(max-width:600px){.list-cont{width:100%;margin-left:0}.halving-line-horizontal{border-bottom:0}.halving-line-vertical{border-right:0}.app-list-item-link{border-bottom:1px #dfdfdf dotted}.app-list-item{float:none}.app-list-item{width:100%}}@media(max-width:320px){.list-cont{width:320px}}</style>";
        html_dom_ul_li_template = "<li class=\"app-list-item\"> <a href=\"${target_url}\" onclick=\"document.getElementById('track_click_img').src='${click_track_url}';\" class=\"app-list-item-link  halving-line-horizontal${css_class_halving_line_vertical}\"><div class=\"app-list-item-icon\"><img src=\"${img_url}\"></div><div class=\"app-list-item-cont clearfix\"><h3>${title}</h3><h4>${description}</h4><div class=\"app-list-download-btn\">${btn_txt}</div></div></a></li>";
        html_dom_body_contents_templeate = "<div id=\"list-cont\" class=\"list-cont\"><div class=\"list-cont-head\"><h3>${page_title}</h3></div><div class=\"list-cont-body\"><img id=\"track_click_img\" style=\"display:none;\" /><ul class=\"app-list clearfix\">${html_dom_ul_li}</ul></div></div>";
    }

    private void setAdManager(AdManager admanager)
    {
        adManager = admanager;
    }

    public AdManager getAdManager()
    {
        return adManager;
    }

    public IconSize getIconSize()
    {
        return iconSize;
    }

    public YMWebViewStyle getStyle()
    {
        return style;
    }

    public void loadFromAdManager(AdManager admanager)
        throws Exception
    {
        if (admanager != null)
        {
            setAdManager(admanager);
            admanager.setAdReceiveListener(onAdReceiveListener);
            admanager.loadAd();
            Log.d(TAG, "loadFromAdManager works!");
            return;
        } else
        {
            throw new Exception("Exception caused by adManager is null");
        }
    }

    public void loadFromHtml(String s)
    {
        if (StringUtils.isNotNullOrEmpty(s))
        {
            loadDataWithBaseURL(null, s, "text/html", "UTF-8", null);
        }
    }

    public void setIconSize(IconSize iconsize)
    {
        iconSize = iconsize;
    }

    public void setStyle(YMWebViewStyle ymwebviewstyle)
    {
        style = ymwebviewstyle;
    }

}
