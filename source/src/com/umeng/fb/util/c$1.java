// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.util;

import java.io.File;

// Referenced classes of package com.umeng.fb.util:
//            c

static final class >
    implements Runnable
{

    final String a;

    public void run()
    {
        File file = new File(a);
        if (file.exists()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (file.isFile())
        {
            file.delete();
            return;
        }
        if (file.isDirectory())
        {
            File afile[] = file.listFiles();
            int j = afile.length;
            int i = 0;
            while (i < j) 
            {
                afile[i].delete();
                i++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    (String s)
    {
        a = s;
        super();
    }
}
