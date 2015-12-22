// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message;

import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;

// Referenced classes of package com.umeng.message:
//            MsgLogStore

class a
    implements FilenameFilter
{

    final MsgLogStore a;

    public boolean accept(File file, String s)
    {
        return !TextUtils.isEmpty(s) && s.startsWith("umeng_message_log_cache_");
    }

    (MsgLogStore msglogstore)
    {
        a = msglogstore;
        super();
    }
}
