// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.umeng.message.proguard.aI;
import com.umeng.message.proguard.aJ;
import com.umeng.message.proguard.by;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.android.agoo.client.AgooSettings;
import org.android.agoo.client.BaseRegistrar;
import org.android.agoo.net.mtop.MtopAsyncClientV3;
import org.android.agoo.net.mtop.MtopRequest;
import org.android.agoo.net.mtop.MtopResponseHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class ElectionService extends Service
    implements android.os.Handler.Callback
{
    public static class ElectionResult
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public ElectionResult createFromParcel(Parcel parcel)
            {
                return new ElectionResult(parcel);
            }

            public volatile Object[] newArray(int i1)
            {
                return newArray(i1);
            }

            public ElectionResult[] newArray(int i1)
            {
                return null;
            }

        };
        private long a;
        private String b;
        private HashMap c;

        public int describeContents()
        {
            return 0;
        }

        public String getElectionSource()
        {
            return b;
        }

        public HashMap getSudoMap()
        {
            return c;
        }

        public long getTimeout()
        {
            return a;
        }

        public void putSudo(String s1, String s2)
        {
            c.put(s1, s2);
        }

        public void setElectionSource(String s1)
        {
            b = s1;
        }

        public void setSudoMap(HashMap hashmap)
        {
            c = hashmap;
        }

        public void setTimeout(long l1)
        {
            a = l1;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            parcel.writeLong(a);
            parcel.writeMap(c);
            parcel.writeString(b);
        }


        public ElectionResult()
        {
            a = -1L;
            c = new HashMap();
        }

        private ElectionResult(Parcel parcel)
        {
            a = -1L;
            c = new HashMap();
            a = parcel.readLong();
            c = parcel.readHashMap(java/util/HashMap.getClassLoader());
            b = parcel.readString();
        }

    }


    private static final String a = "ElectionService";
    private static final int e = 100;
    private static final int f = 101;
    private static final int g = 102;
    private static final int h = 103;
    private static Random s = new Random();
    private volatile Map b;
    private volatile Map c;
    private volatile Map d;
    private volatile String i;
    private Handler j;
    private volatile List k;
    private volatile long l;
    private volatile boolean m;
    private HandlerThread n;
    private AtomicInteger o;
    private volatile long p;
    private volatile Context q;
    private final IElectionService.Stub r = new IElectionService.Stub() {

        final ElectionService a;

        public void election(String s1, long l1, String s2)
            throws RemoteException
        {
            if (ElectionService.a(a))
            {
                return;
            } else
            {
                ElectionService.a(a, s1, l1);
                return;
            }
        }

            
            {
                a = ElectionService.this;
                super();
            }
    };
    private ElectionResult t;

    public ElectionService()
    {
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
        i = "local";
        j = null;
        k = null;
        l = -1L;
        m = false;
        n = null;
        o = new AtomicInteger(0);
        p = -1L;
    }

    static long a(ElectionService electionservice, long l1)
    {
        electionservice.p = l1;
        return l1;
    }

    private String a(List list)
    {
        String s1 = null;
        if (list != null)
        {
            int i1 = list.size();
            int j1 = s.nextInt(10000);
            int k1 = j1 % i1;
            aJ.c("ElectionService", (new StringBuilder()).append("random [").append(j1).append("][").append(i1).append("]").toString());
            aJ.c("ElectionService", (new StringBuilder()).append("random index[").append(list.toString()).append("][").append(k1).append("]").toString());
            s1 = (String)list.get(k1);
        }
        list = s1;
        if (TextUtils.isEmpty(s1))
        {
            list = q.getPackageName();
        }
        return list;
    }

    private void a()
    {
        String s1 = a((List)b.get(Long.valueOf(l)));
        String s2;
        for (Iterator iterator = d.keySet().iterator(); iterator.hasNext(); c.put(s2, s1))
        {
            s2 = (String)iterator.next();
        }

        a("local");
    }

    private void a(String s1)
    {
        Message message = Message.obtain();
        message.what = 102;
        i = s1;
        j.sendMessage(message);
        j.sendEmptyMessageDelayed(103, 0x927c0L);
    }

    private void a(String s1, long l1)
    {
        this;
        JVM INSTR monitorenter ;
        if (TextUtils.isEmpty(s1) || l1 <= -1L)
        {
            break MISSING_BLOCK_LABEL_164;
        }
        d.put(s1, Long.valueOf(l1));
        aJ.c("ElectionService", (new StringBuilder()).append("addElection[pack:").append(s1).append("][priority:").append(l1).append("]").toString());
        if (l1 > l)
        {
            l = l1;
        }
        k = (List)b.get(Long.valueOf(l1));
        if (k == null)
        {
            k = new ArrayList();
        }
        if (!k.contains(s1))
        {
            k.add(s1);
        }
        b.put(Long.valueOf(l1), k);
        if (o.get() < 1)
        {
            o.incrementAndGet();
            s1 = Message.obtain();
            s1.what = 100;
            j.removeMessages(103);
            j.sendMessageDelayed(s1, 10000L);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    static void a(ElectionService electionservice, String s1)
    {
        electionservice.a(s1);
    }

    static void a(ElectionService electionservice, String s1, long l1)
    {
        electionservice.a(s1, l1);
    }

    static boolean a(ElectionService electionservice)
    {
        return electionservice.m;
    }

    private void b()
    {
        String s1 = aI.n(q);
        String s2 = aI.o(q);
        if (!BaseRegistrar.isRegistered(q) || TextUtils.isEmpty(s1) || TextUtils.isEmpty(s2))
        {
            aJ.c("ElectionService", "remote registered==null");
            c();
            return;
        } else
        {
            MtopRequest mtoprequest = new MtopRequest();
            mtoprequest.setApi("mtop.push.channel.vote");
            mtoprequest.setV("6.0");
            mtoprequest.setTtId(aI.o(q));
            mtoprequest.setDeviceId(BaseRegistrar.getRegistrationId(q));
            mtoprequest.putParams("vote_factors", (new JSONObject(d)).toString());
            MtopAsyncClientV3 mtopasyncclientv3 = new MtopAsyncClientV3();
            mtopasyncclientv3.setDefaultAppkey(aI.n(q));
            mtopasyncclientv3.setDefaultAppSecret(aI.p(q));
            mtopasyncclientv3.setBaseUrl(AgooSettings.getPullUrl(q));
            mtopasyncclientv3.getV3(q, mtoprequest, new MtopResponseHandler() {

                final ElectionService a;

                public void onFailure(String s3, String s4)
                {
                    aJ.d("ElectionService", (new StringBuilder()).append("errCode[").append(s3).append("]errDesc[").append(s4).append("]").toString());
                    ElectionService.b(a);
                }

                public void onSuccess(String s3)
                {
                    if (TextUtils.isEmpty(s3))
                    {
                        aJ.c("ElectionService", "remote content==null");
                        ElectionService.b(a);
                        return;
                    }
                    aJ.c("ElectionService", (new StringBuilder()).append("remote election result[").append(s3).append("] ").toString());
                    s3 = new JSONObject(s3);
                    ElectionService.a(a, Long.parseLong(s3.getString("time_out")));
                    s3 = s3.getJSONArray("vote_list");
                    if (s3 == null)
                    {
                        try
                        {
                            aJ.c("ElectionService", "remote vote_list==null");
                            ElectionService.b(a);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (String s3)
                        {
                            aJ.d("ElectionService", "remote--JSONException", s3);
                        }
                        ElectionService.b(a);
                        return;
                    }
                    int k1 = s3.length();
                    if (k1 > 0) goto _L2; else goto _L1
_L1:
                    aJ.c("ElectionService", "remote vote_list.length==0");
                    ElectionService.b(a);
                    return;
_L10:
                    int i1;
                    if (i1 >= k1) goto _L4; else goto _L3
_L3:
                    Object obj = s3.getJSONObject(i1);
                    if (obj != null)
                    {
                        break MISSING_BLOCK_LABEL_172;
                    }
                    ElectionService.b(a);
                    return;
                    String s4;
                    s4 = ((JSONObject) (obj)).getString("package_name");
                    if (TextUtils.isEmpty(s4))
                    {
                        aJ.c("ElectionService", "sudoPack==null");
                        ElectionService.b(a);
                        return;
                    }
                    if (ElectionService.c(a).get(s4) == null)
                    {
                        aJ.c("ElectionService", (new StringBuilder()).append("elctionResults not found[").append(s4).append("]").toString());
                        ElectionService.b(a);
                        return;
                    }
                    obj = ((JSONObject) (obj)).getJSONArray("package_name_list");
                    if (obj != null)
                    {
                        break MISSING_BLOCK_LABEL_280;
                    }
                    aJ.c("ElectionService", "remote package_name_list==null");
                    ElectionService.b(a);
                    return;
                    int l1 = ((JSONArray) (obj)).length();
                    if (l1 > 0) goto _L6; else goto _L5
_L5:
                    aJ.c("ElectionService", "remote package_name_list.length==0");
                    ElectionService.b(a);
                    return;
_L8:
                    int j1;
                    if (j1 >= l1)
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    String s5 = ((JSONArray) (obj)).getString(j1);
                    ElectionService.d(a).put(s5, s4);
                    j1++;
                    continue; /* Loop/switch isn't completed */
_L4:
                    ElectionService.a(a, "remote");
                    return;
_L2:
                    i1 = 0;
                    continue; /* Loop/switch isn't completed */
_L6:
                    j1 = 0;
                    if (true) goto _L8; else goto _L7
_L7:
                    i1++;
                    if (true) goto _L10; else goto _L9
_L9:
                }

            
            {
                a = ElectionService.this;
                super();
            }
            });
            return;
        }
    }

    static void b(ElectionService electionservice)
    {
        electionservice.c();
    }

    static Map c(ElectionService electionservice)
    {
        return electionservice.d;
    }

    private void c()
    {
        j.sendEmptyMessage(101);
    }

    static Map d(ElectionService electionservice)
    {
        return electionservice.c;
    }

    private void d()
    {
        Iterator iterator = c.entrySet().iterator();
        t = new ElectionResult();
        t.setTimeout(p);
        t.setElectionSource(i);
        while (iterator.hasNext()) 
        {
            Object obj = (java.util.Map.Entry)iterator.next();
            String s1 = (String)((java.util.Map.Entry) (obj)).getKey();
            obj = (String)((java.util.Map.Entry) (obj)).getValue();
            try
            {
                aJ.c("ElectionService", (new StringBuilder()).append("finish[clientPack:").append(s1).append("][sudo:").append(((String) (obj))).append("][electionSource:").append(i).append("]").toString());
                t.putSudo(s1, ((String) (obj)));
            }
            catch (Throwable throwable)
            {
                aJ.d("ElectionService", "finish--Exception", throwable);
            }
        }
        c.clear();
        d.clear();
        b.clear();
    }

    private void e()
    {
        if (q != null)
        {
            Intent intent = new Intent();
            intent.setAction("org.agoo.android.intent.action.RE_ELECTION_V2");
            intent.putExtra("election_result", t);
            intent.putExtra("election_type", "election_notice");
            intent.addFlags(32);
            q.sendBroadcast(intent);
        }
    }

    public boolean handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 100 103: default 115
    //                   100 36
    //                   101 67
    //                   102 86
    //                   103 109;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        o.set(0);
        m = true;
        b();
        return true;
_L3:
        try
        {
            o.set(0);
            m = true;
            a();
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            aJ.d("ElectionService", "destroy  exception", message);
            return true;
        }
        return true;
_L4:
        o.set(0);
        d();
        e();
        m = false;
        return true;
_L5:
        stopSelf();
        return true;
_L1:
        return true;
    }

    public IBinder onBind(Intent intent)
    {
        intent = intent.getAction();
        if (!TextUtils.isEmpty(intent) && TextUtils.equals(intent, "org.agoo.android.intent.action.ELECTION_V2"))
        {
            return r;
        } else
        {
            return null;
        }
    }

    public void onCreate()
    {
        super.onCreate();
        q = this;
        aJ.a(q);
        aJ.c("ElectionService", "create");
        try
        {
            n = new HandlerThread("election_service");
            n.start();
            j = new Handler(n.getLooper(), this);
            return;
        }
        catch (Throwable throwable)
        {
            aJ.d("ElectionService", "election_service_handlerthread", throwable);
        }
    }

    public void onDestroy()
    {
        try
        {
            aJ.c("ElectionService", "destroy");
            super.onDestroy();
            b.clear();
            o.set(0);
            l = -1L;
            m = false;
            by.a(q);
            return;
        }
        catch (Throwable throwable)
        {
            return;
        }
    }

    public int onStartCommand(Intent intent, int i1, int j1)
    {
        return super.onStartCommand(intent, i1, j1);
    }

    public boolean onUnbind(Intent intent)
    {
        return super.onUnbind(intent);
    }

}
