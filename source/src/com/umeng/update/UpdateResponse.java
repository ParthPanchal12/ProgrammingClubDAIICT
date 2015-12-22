// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update;

import android.content.Context;
import java.io.Serializable;
import org.json.JSONObject;
import u.upd.c;
import u.upd.i;
import u.upd.n;

public class UpdateResponse extends i
    implements Serializable
{

    private static final long a = 0x9430176e7281126aL;
    public boolean delta;
    public boolean hasUpdate;
    public String new_md5;
    public String origin;
    public String patch_md5;
    public String path;
    public String proto_ver;
    public String size;
    public String target_size;
    public String updateLog;
    public String version;

    public UpdateResponse(JSONObject jsonobject)
    {
        super(jsonobject);
        hasUpdate = false;
        updateLog = null;
        version = null;
        delta = false;
        a(jsonobject);
    }

    private void a(JSONObject jsonobject)
    {
        try
        {
            hasUpdate = "Yes".equalsIgnoreCase(jsonobject.optString("update"));
            if (hasUpdate)
            {
                updateLog = jsonobject.getString("update_log");
                version = jsonobject.getString("version");
                path = jsonobject.getString("path");
                target_size = jsonobject.optString("target_size");
                new_md5 = jsonobject.optString("new_md5");
                delta = jsonobject.optBoolean("delta");
                if (delta)
                {
                    patch_md5 = jsonobject.optString("patch_md5");
                    size = jsonobject.optString("size");
                    origin = jsonobject.optString("origin");
                }
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
        }
    }

    public String a(Context context, boolean flag)
    {
        String s = context.getString(c.a(context).f("UMNewVersion"));
        String s1 = context.getString(c.a(context).f("UMTargetSize"));
        String s3 = context.getString(c.a(context).f("UMUpdateSize"));
        String s2 = context.getString(c.a(context).f("UMUpdateContent"));
        context = context.getString(c.a(context).f("UMDialog_InstallAPK"));
        if (flag)
        {
            return String.format("%s %s\n%s\n\n%s\n%s\n", new Object[] {
                s, version, context, s2, updateLog
            });
        }
        if (delta)
        {
            context = String.format("\n%s %s", new Object[] {
                s3, n.c(size)
            });
        } else
        {
            context = "";
        }
        return String.format("%s %s\n%s %s%s\n\n%s\n%s\n", new Object[] {
            s, version, s1, n.c(target_size), context, s2, updateLog
        });
    }
}
