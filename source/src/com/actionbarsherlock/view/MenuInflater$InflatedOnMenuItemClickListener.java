// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.view;

import android.view.InflateException;
import java.lang.reflect.Method;

// Referenced classes of package com.actionbarsherlock.view:
//            MenuInflater, MenuItem

private static class PARAM_TYPES
    implements PARAM_TYPES
{

    private static final Class PARAM_TYPES[] = {
        com/actionbarsherlock/view/MenuItem
    };
    private Method mMethod;
    private Object mRealOwner;

    public boolean onMenuItemClick(MenuItem menuitem)
    {
        try
        {
            if (mMethod.getReturnType() == Boolean.TYPE)
            {
                return ((Boolean)mMethod.invoke(mRealOwner, new Object[] {
                    menuitem
                })).booleanValue();
            }
            mMethod.invoke(mRealOwner, new Object[] {
                menuitem
            });
        }
        // Misplaced declaration of an exception variable
        catch (MenuItem menuitem)
        {
            throw new RuntimeException(menuitem);
        }
        return true;
    }


    public (Object obj, String s)
    {
        mRealOwner = obj;
        Class class1 = obj.getClass();
        try
        {
            mMethod = class1.getMethod(s, PARAM_TYPES);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            s = new InflateException((new StringBuilder("Couldn't resolve menu item onClick handler ")).append(s).append(" in class ").append(class1.getName()).toString());
        }
        s.initCause(((Throwable) (obj)));
        throw s;
    }
}
