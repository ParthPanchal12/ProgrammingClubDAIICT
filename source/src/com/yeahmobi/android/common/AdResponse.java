// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.common;


// Referenced classes of package com.yeahmobi.android.common:
//            IAdInfo

public class AdResponse
    implements Cloneable, IAdInfo
{

    private int mChargeType;
    private String mClickRecordUrl;
    private String mClickTrackUrl;
    private String mConversionTrackUrl;
    private int mHeight;
    private String mHtmlSnippet;
    private String mIconImageUrl;
    private long mId;
    private String mImpressionTrackUrl;
    private String mMainContent;
    private String mMainImageUrl;
    private String mPackageName;
    private boolean mPreload;
    private String mTargetUrl;
    private String mTitle;
    private int mWidth;

    public AdResponse()
    {
    }

    public Object clone()
        throws CloneNotSupportedException, ClassCastException
    {
        return (IAdInfo)super.clone();
    }

    public String getCallToAction()
    {
        return null;
    }

    public int getChargeType()
    {
        return mChargeType;
    }

    public String getClickDestinationUrl()
    {
        return mClickTrackUrl;
    }

    public String getClickRecordUrl()
    {
        return mClickRecordUrl;
    }

    public String getConversionTrackUrl()
    {
        return mConversionTrackUrl;
    }

    public int getHeight()
    {
        return mHeight;
    }

    public String getHtmlSnippet()
    {
        return mHtmlSnippet;
    }

    public String getIconImageUrl()
    {
        return mIconImageUrl;
    }

    public long getId()
    {
        return mId;
    }

    public String getImpressionTrackUrl()
    {
        return mImpressionTrackUrl;
    }

    public String getMainContent()
    {
        return mMainContent;
    }

    public String getMainImageUrl()
    {
        return mMainImageUrl;
    }

    public String getPackageName()
    {
        return mPackageName;
    }

    public String getText()
    {
        return null;
    }

    public String getTitle()
    {
        return mTitle;
    }

    public int getWidth()
    {
        return mWidth;
    }

    public boolean preload()
    {
        return mPreload;
    }

    public void setChargeType(int i)
    {
        mChargeType = i;
    }

    public void setClickRecordUrl(String s)
    {
        mClickRecordUrl = s;
    }

    public void setClickTrackUrl(String s)
    {
        mClickTrackUrl = s;
    }

    public void setConversionTrackUrl(String s)
    {
        mConversionTrackUrl = s;
    }

    public void setHtmlSnippet(String s)
    {
        mHtmlSnippet = s;
    }

    public void setIconImageUrl(String s)
    {
        mIconImageUrl = s;
    }

    public void setId(long l)
    {
        mId = l;
    }

    public void setImpressionTrackUrl(String s)
    {
        mImpressionTrackUrl = s;
    }

    public void setMainContent(String s)
    {
        mMainContent = s;
    }

    public void setMainImageUrl(String s)
    {
        mMainImageUrl = s;
    }

    public void setPackageName(String s)
    {
        mPackageName = s;
    }

    public void setPreload(boolean flag)
    {
        mPreload = flag;
    }

    public void setTargetUrl(String s)
    {
        mTargetUrl = s;
    }

    public void setTitle(String s)
    {
        mTitle = s;
    }

    public void setWidth(int i)
    {
        mWidth = i;
    }

    public void setmHeight(int i)
    {
        mHeight = i;
    }
}
