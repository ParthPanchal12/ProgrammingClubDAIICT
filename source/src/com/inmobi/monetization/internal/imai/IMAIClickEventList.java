// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal.imai;

import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.configs.ConfigParams;
import com.inmobi.monetization.internal.configs.IMAIConfigParams;
import com.inmobi.monetization.internal.configs.Initializer;
import com.inmobi.monetization.internal.imai.db.ClickData;
import com.inmobi.monetization.internal.imai.db.ClickDatabaseManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.monetization.internal.imai:
//            RequestResponseManager

public class IMAIClickEventList extends ArrayList
{

    private static final long serialVersionUID = 0xfd0f9c6d52a71745L;

    public IMAIClickEventList()
    {
    }

    public static IMAIClickEventList getLoggedClickEvents()
    {
        com/inmobi/monetization/internal/imai/IMAIClickEventList;
        JVM INSTR monitorenter ;
        Object obj = null;
        ArrayList arraylist;
        if (ClickDatabaseManager.getInstance().getNoOfEvents() == 0)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        int i = Initializer.getConfigParams().getImai().getmDefaultEventsBatch();
        ClickDatabaseManager.getInstance().setDBLimit(Initializer.getConfigParams().getImai().getmMaxDb());
        obj = ClickDatabaseManager.getInstance().getClickEvents(i);
        arraylist = new ArrayList();
        for (Iterator iterator = ((IMAIClickEventList) (obj)).iterator(); iterator.hasNext(); arraylist.add(Long.valueOf(((ClickData)iterator.next()).getClickId()))) { }
        break MISSING_BLOCK_LABEL_98;
        obj;
        throw obj;
        ClickDatabaseManager.getInstance().deleteClickEvents(arraylist);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
_L1:
        com/inmobi/monetization/internal/imai/IMAIClickEventList;
        JVM INSTR monitorexit ;
        return ((IMAIClickEventList) (obj));
        obj = new IMAIClickEventList();
          goto _L1
    }

    public ClickData getClickEvent(long l)
    {
        Iterator iterator = iterator();
_L1:
        ClickData clickdata;
        long l1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_53;
        }
        clickdata = (ClickData)iterator.next();
        l1 = clickdata.getClickId();
        if (l1 == l)
        {
            return clickdata;
        }
          goto _L1
        Exception exception;
        exception;
        Log.internal("[InMobi]-[Monetization]", "Cant get click event", exception);
        return null;
        return null;
    }

    public void reduceRetryCount(int i)
    {
        this;
        JVM INSTR monitorenter ;
        ClickData clickdata;
        int j;
        RequestResponseManager.isSynced.set(false);
        clickdata = getClickEvent(i);
        j = clickdata.getRetryCount();
        removeClickEvent(i);
        if (j <= 1)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        clickdata.setRetryCount(clickdata.getRetryCount() - 1);
        add(clickdata);
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        Log.internal("[InMobi]-[Monetization]", "Cant reduce retry count", ((Throwable) (obj)));
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        throw obj;
    }

    public boolean removeClickEvent(long l)
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        RequestResponseManager.isSynced.set(false);
        remove(getClickEvent(l));
        flag = true;
_L2:
        this;
        JVM INSTR monitorexit ;
        return flag;
        Object obj;
        obj;
        Log.internal("[InMobi]-[Monetization]", "Cant remove click event", ((Throwable) (obj)));
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        throw obj;
    }

    public void saveClickEvents()
    {
        Log.internal("[InMobi]-[Monetization]", "Save ping events");
        if (RequestResponseManager.mDBWriterQueue != null && !RequestResponseManager.mDBWriterQueue.isEmpty())
        {
            ClickData clickdata;
            for (Iterator iterator = RequestResponseManager.mDBWriterQueue.iterator(); iterator.hasNext(); ClickDatabaseManager.getInstance().insertClick(clickdata))
            {
                clickdata = (ClickData)iterator.next();
            }

        }
    }
}
