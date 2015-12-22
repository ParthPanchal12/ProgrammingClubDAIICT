// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.inmobi.commons.internal:
//            Log

public class ApplicationFocusManager
{
    public static interface FocusChangedListener
    {

        public abstract void onFocusChanged(boolean flag);
    }

    static class a extends Handler
    {

        private boolean a;

        public void handleMessage(Message message)
        {
            if (message.what == 1001 && a)
            {
                a = false;
                ApplicationFocusManager.a(Boolean.valueOf(a));
            } else
            if (message.what == 1002 && !a)
            {
                a = true;
                ApplicationFocusManager.a(Boolean.valueOf(a));
                return;
            }
        }

        public a(Looper looper)
        {
            super(looper);
            a = false;
        }
    }


    protected static final int MSG_PAUSED = 1001;
    protected static final int MSG_RESUMED = 1002;
    private static List a = new ArrayList();
    private static Object b;
    private static HandlerThread c = null;
    private static Application d;

    public ApplicationFocusManager()
    {
    }

    static HandlerThread a()
    {
        return c;
    }

    static void a(Boolean boolean1)
    {
        b(boolean1);
    }

    public static void addFocusChangedListener(FocusChangedListener focuschangedlistener)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a.add(focuschangedlistener);
            if (a.size() == 1)
            {
                b();
                return;
            }
        }
    }

    private static void b()
    {
        int i;
        Class class1;
        Object obj;
        Class aclass[];
        InvocationHandler invocationhandler;
        int j;
        try
        {
            c = new HandlerThread("InMobiAFM");
            c.start();
            aclass = android/app/Application.getDeclaredClasses();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Log.internal("[InMobi]-4.5.5", "Cannot register activity lifecycle callbacks", exception);
            return;
        }
        class1 = null;
        j = aclass.length;
        i = 0;
_L2:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        obj = aclass[i];
        if (((Class) (obj)).getSimpleName().equalsIgnoreCase("ActivityLifecycleCallbacks"))
        {
            class1 = ((Class) (obj));
        }
        break MISSING_BLOCK_LABEL_135;
        obj = class1.getClassLoader();
        invocationhandler = new InvocationHandler() {

            private final Handler a = new a(ApplicationFocusManager.a().getLooper());

            public void a(Activity activity)
            {
                a.sendEmptyMessageDelayed(1001, 3000L);
            }

            public void b(Activity activity)
            {
                a.removeMessages(1001);
                a.sendEmptyMessage(1002);
            }

            public Object invoke(Object obj1, Method method, Object aobj[])
                throws Throwable
            {
                if (aobj == null)
                {
                    break MISSING_BLOCK_LABEL_61;
                }
                if (!method.getName().equals("onActivityPaused"))
                {
                    break MISSING_BLOCK_LABEL_28;
                }
                a((Activity)aobj[0]);
                return null;
                if (!method.getName().equals("onActivityResumed"))
                {
                    break MISSING_BLOCK_LABEL_61;
                }
                b((Activity)aobj[0]);
                return null;
                obj1;
                Log.internal("[InMobi]-4.5.5", "Unable to invoke method", ((Throwable) (obj1)));
                return null;
            }

        };
        obj = Proxy.newProxyInstance(((ClassLoader) (obj)), new Class[] {
            class1
        }, invocationhandler);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        android/app/Application.getMethod("registerActivityLifecycleCallbacks", new Class[] {
            class1
        }).invoke(d, new Object[] {
            obj
        });
        return;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static void b(Boolean boolean1)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((FocusChangedListener)iterator.next()).onFocusChanged(boolean1.booleanValue())) { }
    }

    private static void c()
    {
        try
        {
            if (b != null)
            {
                android/app/Application.getMethod("unregisterActivityLifecycleCallbacks", (Class[])null).invoke(d, (Object[])(Object[])b);
            }
            c.stop();
            c = null;
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Log.internal("[InMobi]-4.5.5", "Exception unregister app lifecycle callback", exception);
            return;
        }
    }

    public static void init(Context context)
    {
label0:
        {
            if (android.os.Build.VERSION.SDK_INT >= 14 && d == null)
            {
                if (!(context instanceof Activity))
                {
                    break label0;
                }
                d = ((Activity)context).getApplication();
            }
            return;
        }
        d = (Application)context.getApplicationContext();
    }

    public static void removeFocusChangedListener(FocusChangedListener focuschangedlistener)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a.remove(focuschangedlistener);
            if (a.size() == 0)
            {
                c();
                return;
            }
        }
    }

}
