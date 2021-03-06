// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.controller.util.NavigationStringEnum;
import com.inmobi.re.controller.util.TransitionStringEnum;
import java.lang.reflect.Field;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class JSController
{
    public static class Dimensions extends ReflectedParcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public Dimensions a(Parcel parcel)
            {
                return new Dimensions(parcel);
            }

            public Dimensions[] a(int i)
            {
                return new Dimensions[i];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int i)
            {
                return a(i);
            }

        };
        public int height;
        public int width;
        public int x;
        public int y;

        public String toString()
        {
            return (new StringBuilder()).append("x: ").append(x).append(", y: ").append(y).append(", width: ").append(width).append(", height: ").append(height).toString();
        }


        public Dimensions()
        {
            x = -1;
            y = -1;
            width = -1;
            height = -1;
        }

        protected Dimensions(Parcel parcel)
        {
            super(parcel);
        }
    }

    public static class ExpandProperties extends ReflectedParcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public ExpandProperties a(Parcel parcel)
            {
                return new ExpandProperties(parcel);
            }

            public ExpandProperties[] a(int i)
            {
                return new ExpandProperties[i];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int i)
            {
                return a(i);
            }

        };
        public int actualHeightRequested;
        public int actualWidthRequested;
        public int bottomStuff;
        public int currentX;
        public int currentY;
        public int height;
        public boolean isModal;
        public boolean lockOrientation;
        public String orientation;
        public int portraitHeightRequested;
        public int portraitWidthRequested;
        public String rotationAtExpand;
        public int topStuff;
        public boolean useCustomClose;
        public int width;
        public int x;
        public int y;
        public boolean zeroWidthHeight;

        public void reinitializeExpandProperties()
        {
            width = 0;
            height = 0;
            x = -1;
            y = -1;
            useCustomClose = false;
            isModal = true;
            lockOrientation = false;
            orientation = "";
            actualWidthRequested = 0;
            actualHeightRequested = 0;
            topStuff = 0;
            bottomStuff = 0;
            portraitWidthRequested = 0;
            portraitHeightRequested = 0;
            zeroWidthHeight = false;
            rotationAtExpand = "";
            currentX = 0;
            currentY = 0;
        }


        public ExpandProperties()
        {
            reinitializeExpandProperties();
        }

        protected ExpandProperties(Parcel parcel)
        {
            super(parcel);
        }
    }

    public static class OrientationProperties extends ReflectedParcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public OrientationProperties a(Parcel parcel)
            {
                return new OrientationProperties(parcel);
            }

            public OrientationProperties[] a(int i)
            {
                return new OrientationProperties[i];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int i)
            {
                return a(i);
            }

        };
        public boolean allowOrientationChange;
        public String forceOrientation;

        public void initializeOrientationProperties()
        {
            allowOrientationChange = true;
            forceOrientation = "";
        }


        public OrientationProperties()
        {
            initializeOrientationProperties();
        }

        protected OrientationProperties(Parcel parcel)
        {
            super(parcel);
        }
    }

    public static class PlayerProperties extends ReflectedParcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public PlayerProperties a(Parcel parcel)
            {
                return new PlayerProperties(parcel);
            }

            public PlayerProperties[] a(int i)
            {
                return new PlayerProperties[i];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int i)
            {
                return a(i);
            }

        };
        public boolean audioMuted;
        public boolean autoPlay;
        public boolean doLoop;
        public String id;
        public boolean showControl;
        public String startStyle;
        public String stopStyle;

        public boolean doLoop()
        {
            return doLoop;
        }

        public boolean doMute()
        {
            return audioMuted;
        }

        public boolean exitOnComplete()
        {
            return stopStyle.equalsIgnoreCase("exit");
        }

        public boolean isAutoPlay()
        {
            return autoPlay;
        }

        public boolean isFullScreen()
        {
            return startStyle.equalsIgnoreCase("fullscreen");
        }

        public void setFullScreen()
        {
            startStyle = "fullscreen";
        }

        public void setProperties(boolean flag, boolean flag1, boolean flag2, boolean flag3, String s, String s1, String s2)
        {
            autoPlay = flag1;
            showControl = flag2;
            doLoop = flag3;
            audioMuted = flag;
            startStyle = s;
            stopStyle = s1;
            id = s2;
        }

        public void setStopStyle(String s)
        {
            stopStyle = s;
        }

        public boolean showControl()
        {
            return showControl;
        }


        public PlayerProperties()
        {
            showControl = true;
            autoPlay = true;
            audioMuted = false;
            doLoop = false;
            stopStyle = "normal";
            startStyle = "normal";
            id = "";
        }

        public PlayerProperties(Parcel parcel)
        {
            super(parcel);
        }
    }

    public static class Properties extends ReflectedParcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public Properties a(Parcel parcel)
            {
                return new Properties(parcel);
            }

            public Properties[] a(int i)
            {
                return new Properties[i];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int i)
            {
                return a(i);
            }

        };
        public int backgroundColor;
        public float backgroundOpacity;
        public boolean useBackground;


        public Properties()
        {
            useBackground = false;
            backgroundColor = 0;
            backgroundOpacity = 0.0F;
        }

        protected Properties(Parcel parcel)
        {
            super(parcel);
        }
    }

    public static class ReflectedParcelable
        implements Parcelable
    {

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            Field afield[];
            afield = getClass().getDeclaredFields();
            i = 0;
_L2:
            if (i >= afield.length)
            {
                break MISSING_BLOCK_LABEL_106;
            }
            Object obj = afield[i];
            Object obj1;
            obj1 = ((Field) (obj)).getType();
            if (!((Class) (obj1)).isEnum())
            {
                break MISSING_BLOCK_LABEL_107;
            }
            obj1 = ((Class) (obj1)).toString();
            if (((String) (obj1)).equals("class com.mraid.NavigationStringEnum"))
            {
                parcel.writeString(((NavigationStringEnum)((Field) (obj)).get(this)).getText());
                break MISSING_BLOCK_LABEL_138;
            }
            try
            {
                if (((String) (obj1)).equals("class com.mraid.TransitionStringEnum"))
                {
                    parcel.writeString(((TransitionStringEnum)((Field) (obj)).get(this)).getText());
                }
                break MISSING_BLOCK_LABEL_138;
            }
            // Misplaced declaration of an exception variable
            catch (Parcel parcel)
            {
                parcel.printStackTrace();
            }
            // Misplaced declaration of an exception variable
            catch (Parcel parcel)
            {
                parcel.printStackTrace();
                return;
            }
            return;
            obj = ((Field) (obj)).get(this);
            if (!(obj instanceof android.os.Parcelable.Creator))
            {
                parcel.writeValue(obj);
            }
            i++;
            if (true) goto _L2; else goto _L1
_L1:
        }

        public ReflectedParcelable()
        {
        }

        protected ReflectedParcelable(Parcel parcel)
        {
            Field afield[];
            int i;
            afield = getClass().getDeclaredFields();
            i = 0;
_L2:
            if (i >= afield.length)
            {
                break MISSING_BLOCK_LABEL_103;
            }
            Field field = afield[i];
            Object obj;
            obj = field.getType();
            if (!((Class) (obj)).isEnum())
            {
                break MISSING_BLOCK_LABEL_104;
            }
            obj = ((Class) (obj)).toString();
            if (((String) (obj)).equals("class com.mraid.NavigationStringEnum"))
            {
                field.set(this, NavigationStringEnum.fromString(parcel.readString()));
                break MISSING_BLOCK_LABEL_134;
            }
            try
            {
                if (((String) (obj)).equals("class com.mraid.TransitionStringEnum"))
                {
                    field.set(this, TransitionStringEnum.fromString(parcel.readString()));
                }
                break MISSING_BLOCK_LABEL_134;
            }
            // Misplaced declaration of an exception variable
            catch (Parcel parcel)
            {
                parcel.printStackTrace();
            }
            // Misplaced declaration of an exception variable
            catch (Parcel parcel)
            {
                parcel.printStackTrace();
                return;
            }
            return;
            if (!(field.get(this) instanceof android.os.Parcelable.Creator))
            {
                field.set(this, parcel.readValue(null));
            }
            i++;
            if (true) goto _L2; else goto _L1
_L1:
        }
    }

    public static class ResizeProperties extends ReflectedParcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public ResizeProperties a(Parcel parcel)
            {
                return new ResizeProperties(parcel);
            }

            public ResizeProperties[] a(int i)
            {
                return new ResizeProperties[i];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int i)
            {
                return a(i);
            }

        };
        public boolean allowOffscreen;
        public String customClosePosition;
        public int height;
        public int offsetX;
        public int offsetY;
        public int width;

        public void initializeResizeProperties()
        {
            offsetY = 0;
            offsetX = 0;
            height = 0;
            width = 0;
            allowOffscreen = false;
            customClosePosition = "top-right";
        }


        public ResizeProperties()
        {
            initializeResizeProperties();
        }

        protected ResizeProperties(Parcel parcel)
        {
            super(parcel);
        }
    }


    public static final String EXIT = "exit";
    public static final String FULL_SCREEN = "fullscreen";
    public static final String STYLE_NORMAL = "normal";
    protected ExpandProperties expProps;
    protected IMWebView imWebView;
    protected Context mContext;
    protected ExpandProperties temporaryexpProps;

    public JSController(IMWebView imwebview, Context context)
    {
        imWebView = imwebview;
        mContext = context;
        expProps = new ExpandProperties();
        temporaryexpProps = new ExpandProperties();
    }

    protected static Object getFromJSON(JSONObject jsonobject, Class class1)
        throws IllegalAccessException, InstantiationException, NumberFormatException, NullPointerException
    {
        Field afield[];
        int j;
        afield = class1.getDeclaredFields();
        class1 = ((Class) (class1.newInstance()));
        j = 0;
_L9:
        if (j >= afield.length) goto _L2; else goto _L1
_L1:
        Field field;
        String s;
        String s1;
        field = afield[j];
        s = field.getName().replace('_', '-');
        s1 = field.getType().toString();
        if (!s1.equals("int")) goto _L4; else goto _L3
_L3:
        s = jsonobject.getString(s).toLowerCase(Locale.ENGLISH);
        boolean flag = s.startsWith("#");
        if (!flag) goto _L6; else goto _L5
_L5:
        int i = -1;
        if (!s.startsWith("#0x")) goto _L8; else goto _L7
_L7:
        int k = Integer.decode(s.substring(1)).intValue();
        i = k;
_L10:
        NumberFormatException numberformatexception;
        try
        {
            field.set(class1, Integer.valueOf(i));
        }
        catch (JSONException jsonexception) { }
_L11:
        j++;
          goto _L9
_L8:
        k = Integer.parseInt(s.substring(1), 16);
        i = k;
          goto _L10
_L6:
        i = Integer.parseInt(s);
          goto _L10
_L4:
label0:
        {
            if (!s1.equals("class java.lang.String"))
            {
                break label0;
            }
            field.set(class1, jsonobject.getString(s));
        }
          goto _L11
label1:
        {
            if (!s1.equals("boolean"))
            {
                break label1;
            }
            field.set(class1, Boolean.valueOf(jsonobject.getBoolean(s)));
        }
          goto _L11
label2:
        {
            if (!s1.equals("float"))
            {
                break label2;
            }
            field.set(class1, Float.valueOf(Float.parseFloat(jsonobject.getString(s))));
        }
          goto _L11
        if (!s1.equals("class com.mraid.NavigationStringEnum")) goto _L13; else goto _L12
_L12:
        field.set(class1, NavigationStringEnum.fromString(jsonobject.getString(s)));
          goto _L11
_L13:
        if (!s1.equals("class com.mraid.TransitionStringEnum")) goto _L11; else goto _L14
_L14:
        field.set(class1, TransitionStringEnum.fromString(jsonobject.getString(s)));
          goto _L11
_L2:
        return class1;
        numberformatexception;
        i = 0;
          goto _L10
        numberformatexception;
          goto _L10
    }

    public abstract void stopAllListeners();
}
