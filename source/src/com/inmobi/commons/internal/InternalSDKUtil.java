// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.cache.CacheController;
import com.inmobi.commons.cache.ProductConfig;
import com.inmobi.commons.metric.Logger;
import com.inmobi.commons.thirdparty.Base64;
import com.inmobi.commons.uid.UID;
import java.io.File;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.internal:
//            CommonsConfig, ApiStatCollector, Log, FileOperations, 
//            CommonsException

public class InternalSDKUtil
{
    static class a
    {

        static String a(Context context)
        {
            return WebSettings.getDefaultUserAgent(context);
        }
    }


    public static final String ACTION_CONNECTIVITY_UPDATE = "android.net.conn.CONNECTIVITY_CHANGE";
    public static final String ACTION_RECEIVER_REFERRER = "com.android.vending.INSTALL_REFERRER";
    public static final String ACTION_SHARE_INMID = "com.inmobi.share.id";
    public static final String BASE_LOG_TAG = "[InMobi]";
    public static final String CACHE_DIR_NAME = "im_cached_content";
    public static final String IM_PREF = "impref";
    public static final String INMOBI_SDK_RELEASE_DATE = "20150522";
    public static final String INMOBI_SDK_RELEASE_VERSION = "4.5.5";
    public static final String KEY_LTVID = "ltvid";
    public static final String LOGGING_TAG = "[InMobi]-4.5.5";
    public static final String PRODUCT_COMMONS = "commons";
    private static Map a = new HashMap();
    private static CommonsConfig b = new CommonsConfig();
    private static String c;
    private static Context d = null;
    private static com.inmobi.commons.cache.CacheController.Validator e = new com.inmobi.commons.cache.CacheController.Validator() {

        public boolean validate(Map map)
        {
            return InternalSDKUtil.a(map);
        }

    };
    private static boolean f = true;

    public InternalSDKUtil()
    {
    }

    public static Map JSONToMap(JSONObject jsonobject)
    {
        HashMap hashmap;
        Iterator iterator;
        hashmap = new HashMap();
        iterator = jsonobject.keys();
_L1:
        String s;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_52;
        }
        s = (String)iterator.next();
        try
        {
            hashmap.put(s, jsonobject.get(s));
        }
        catch (JSONException jsonexception) { }
          goto _L1
        return hashmap;
        jsonobject;
        return null;
    }

    private static void a()
    {
        a = UID.getInstance().getMapForEncryption(null);
    }

    static boolean a(Map map)
    {
        a();
        try
        {
            CommonsConfig commonsconfig = new CommonsConfig();
            commonsconfig.setFromMap(map);
            b = commonsconfig;
            ApiStatCollector.getLogger().setMetricConfigParams(commonsconfig.getApiStatsConfig());
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            map.printStackTrace();
            return false;
        }
        return true;
    }

    private static byte[] a(byte abyte0[], int i, Cipher cipher)
        throws IllegalBlockSizeException, BadPaddingException
    {
        if (i != 1);
        int k = abyte0.length;
        byte abyte3[] = new byte[64];
        byte abyte1[] = new byte[0];
        i = 0;
        while (i < k) 
        {
            byte abyte4[] = abyte3;
            byte abyte2[] = abyte1;
            if (i > 0)
            {
                abyte4 = abyte3;
                abyte2 = abyte1;
                if (i % 64 == 0)
                {
                    abyte2 = a(abyte1, cipher.doFinal(abyte3));
                    int j;
                    if (i + 64 > k)
                    {
                        j = k - i;
                    } else
                    {
                        j = 64;
                    }
                    abyte4 = new byte[j];
                }
            }
            abyte4[i % 64] = abyte0[i];
            i++;
            abyte3 = abyte4;
            abyte1 = abyte2;
        }
        return a(abyte1, cipher.doFinal(abyte3));
    }

    private static byte[] a(byte abyte0[], byte abyte1[])
    {
        byte abyte2[] = new byte[abyte0.length + abyte1.length];
        System.arraycopy(abyte0, 0, abyte2, 0, abyte0.length);
        System.arraycopy(abyte1, 0, abyte2, abyte0.length, abyte1.length);
        return abyte2;
    }

    public static String byteToHex(byte byte0)
    {
        String s;
        try
        {
            char ac[] = new char[16];
            char[] _tmp = ac;
            ac[0] = '0';
            ac[1] = '1';
            ac[2] = '2';
            ac[3] = '3';
            ac[4] = '4';
            ac[5] = '5';
            ac[6] = '6';
            ac[7] = '7';
            ac[8] = '8';
            ac[9] = '9';
            ac[10] = 'a';
            ac[11] = 'b';
            ac[12] = 'c';
            ac[13] = 'd';
            ac[14] = 'e';
            ac[15] = 'f';
            s = new String(new char[] {
                ac[byte0 >> 4 & 0xf], ac[byte0 & 0xf]
            });
        }
        catch (Exception exception)
        {
            return null;
        }
        return s;
    }

    public static boolean checkNetworkAvailibility(Context context)
    {
        if (context == null)
        {
            return false;
        }
        context = (ConnectivityManager)context.getSystemService("connectivity");
        if (context.getActiveNetworkInfo() == null)
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = context.getActiveNetworkInfo().isConnected();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.internal("[InMobi]-4.5.5", "Cannot check network state", context);
            return false;
        }
        return flag;
    }

    public static void clearSdkCacheDirectory(File file, String s)
    {
        if (s == null || s.trim().length() == 0)
        {
            FileOperations.deleteDirectory(file);
            return;
        } else
        {
            FileOperations.deleteDirectory(new File(file, s));
            return;
        }
    }

    public static String convertListToDelimitedString(List list, String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        int i = 0;
        while (i < list.size()) 
        {
            try
            {
                if (stringbuilder.length() > 0)
                {
                    stringbuilder.append(s);
                }
                stringbuilder.append(list.get(i));
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-4.5.5", (new StringBuilder()).append("Exception Converting map to deliminated string ").append(list.toString()).toString(), exception);
            }
            i++;
        }
        return stringbuilder.toString();
    }

    public static String encodeMapAndconvertToDelimitedString(Map map, String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();)
        {
            String s1 = (String)iterator.next();
            try
            {
                if (stringbuilder.length() > 0)
                {
                    stringbuilder.append(s);
                }
                stringbuilder.append(String.format("%s=%s", new Object[] {
                    getURLEncoded(s1), getURLEncoded(map.get(s1).toString())
                }));
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-4.5.5", (new StringBuilder()).append("Exception Converting map to deliminated string ").append(map.toString()).toString(), exception);
            }
        }

        return stringbuilder.toString();
    }

    public static String encryptRSA(String s)
    {
        if (s == null || "".equals(s))
        {
            return null;
        }
        try
        {
            Object obj = new BigInteger("C10F7968CFE2C76AC6F0650C877806D4514DE58FC239592D2385BCE5609A84B2A0FBDAF29B05505EAD1FDFEF3D7209ACBF34B5D0A806DF18147EA9C0337D6B5B", 16);
            Object obj1 = new BigInteger("010001", 16);
            obj = (RSAPublicKey)KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(((BigInteger) (obj)), ((BigInteger) (obj1))));
            obj1 = Cipher.getInstance("RSA/ECB/nopadding");
            ((Cipher) (obj1)).init(1, ((java.security.Key) (obj)));
            s = new String(Base64.encode(a(s.getBytes("UTF-8"), 1, ((Cipher) (obj1))), 0));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.debug("[InMobi]-4.5.5", "Exception in encryptRSA", s);
            return null;
        }
        return s;
    }

    public static boolean getBooleanFromJSON(JSONObject jsonobject, String s, boolean flag)
    {
        boolean flag1;
        try
        {
            flag1 = jsonobject.getBoolean(s);
        }
        catch (Exception exception)
        {
            try
            {
                Log.debug("[InMobi]-4.5.5", (new StringBuilder()).append("JSON with property ").append(s).append(" found but has bad datatype(").append(jsonobject.get(s).getClass()).append("). Reverting to ").append(flag).toString());
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                return flag;
            }
            return flag;
        }
        return flag1;
    }

    public static boolean getBooleanFromMap(Map map, String s)
    {
        map = ((Map) (map.get(s)));
        if (map instanceof Boolean)
        {
            return ((Boolean)map).booleanValue();
        } else
        {
            Log.internal("[InMobi]-4.5.5", (new StringBuilder()).append("Key ").append(s).append(" has illegal value").toString());
            throw new IllegalArgumentException();
        }
    }

    public static CommonsConfig getConfig()
    {
        return b;
    }

    public static String getConnectivityType(Context context)
    {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) goto _L2; else goto _L1
_L1:
        context = (ConnectivityManager)context.getSystemService("connectivity");
        if (context == null) goto _L2; else goto _L3
_L3:
        int i;
        int j;
        try
        {
            context = context.getActiveNetworkInfo();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.internal("[InMobi]-4.5.5", "Error getting the network info", context);
            return null;
        }
        if (context == null) goto _L2; else goto _L4
_L4:
        i = context.getType();
        j = context.getSubtype();
        if (i == 1)
        {
            return "wifi";
        }
        if (i != 0) goto _L2; else goto _L5
_L8:
        if (j == 0)
        {
            return "carrier";
        }
          goto _L6
_L2:
        context = null;
_L6:
        return context;
_L5:
        context = "carrier";
        if (j == 1)
        {
            return "gprs";
        }
        if (j == 2)
        {
            return "edge";
        }
        if (j == 3)
        {
            return "umts";
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static Context getContext()
    {
        return d;
    }

    public static String getDigested(String s, String s1)
    {
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        if ("".equals(s.trim()))
        {
            break MISSING_BLOCK_LABEL_105;
        }
        int i;
        try
        {
            s1 = MessageDigest.getInstance(s1);
            s1.update(s.getBytes());
            s = s1.digest();
            s1 = new StringBuffer();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.debug("[InMobi]-4.5.5", "Exception in getting ODIN-1", s);
            return null;
        }
        i = 0;
        if (i >= s.length)
        {
            break; /* Loop/switch isn't completed */
        }
        s1.append(Integer.toString((s[i] & 0xff) + 256, 16).substring(1));
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_48;
_L1:
        s = s1.toString();
        return s;
        return "TEST_EMULATOR";
    }

    public static Map getEncodedMap(Map map)
    {
        HashMap hashmap = new HashMap();
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            try
            {
                hashmap.put(getURLEncoded(s), getURLEncoded(map.get(s).toString()));
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-4.5.5", (new StringBuilder()).append("Exception Map encoding ").append(map.toString()).toString(), exception);
            }
        }

        return hashmap;
    }

    public static String getFinalRedirectedUrl(String s)
    {
        int i = 0;
_L7:
        HttpURLConnection httpurlconnection;
        int j;
        httpurlconnection = (HttpURLConnection)(new URL(s)).openConnection();
        httpurlconnection.setRequestProperty("User-Agent", getUserAgent());
        httpurlconnection.setUseCaches(false);
        httpurlconnection.setRequestMethod("GET");
        j = httpurlconnection.getResponseCode();
        if (j < 300 || j >= 400) goto _L2; else goto _L1
_L1:
        String s1 = httpurlconnection.getHeaderField("Location");
        if (s1 != null) goto _L3; else goto _L2
_L2:
        String s2 = s;
        httpurlconnection.disconnect();
        return s;
_L3:
        s2 = s1;
        j = httpurlconnection.getResponseCode();
        s = s1;
        if (j == 200) goto _L2; else goto _L4
_L4:
        s = s1;
        if (i >= 5) goto _L2; else goto _L5
_L5:
        i++;
        s = s1;
        if (true) goto _L7; else goto _L6
_L6:
        Exception exception;
        exception;
_L9:
        Log.internal("[InMobi]-4.5.5", "Cannot get redirect url", exception);
        return s;
        exception;
        s = s2;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public static String getInMobiInternalVersion(String s)
    {
        s = s.split("[.]");
        StringBuffer stringbuffer = new StringBuffer("");
        int i = 0;
        while (i < s.length) 
        {
            try
            {
                int j = Integer.valueOf(s[i]).intValue();
                stringbuffer.append("T").append((char)(j + 65));
            }
            catch (NumberFormatException numberformatexception) { }
            i++;
        }
        if (stringbuffer.equals(""))
        {
            return "";
        } else
        {
            return stringbuffer.substring(1).toString();
        }
    }

    public static int getIntFromJSON(JSONObject jsonobject, String s, int i)
    {
        int j;
        try
        {
            j = jsonobject.getInt(s);
        }
        catch (Exception exception)
        {
            try
            {
                Log.debug("[InMobi]-4.5.5", (new StringBuilder()).append("JSON with property ").append(s).append(" found but has bad datatype(").append(jsonobject.get(s).getClass()).append("). Reverting to ").append(i).toString());
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                return i;
            }
            return i;
        }
        return j;
    }

    public static int getIntFromMap(Map map, String s, int i, long l)
    {
        map = ((Map) (map.get(s)));
        if (map instanceof Integer)
        {
            int j = ((Integer)map).intValue();
            if ((long)j <= l && j >= i)
            {
                return j;
            }
        }
        Log.internal("[InMobi]-4.5.5", (new StringBuilder()).append("Key ").append(s).append(" has illegal value").toString());
        throw new IllegalArgumentException();
    }

    public static long getLongFromJSON(JSONObject jsonobject, String s, long l)
    {
        long l1;
        try
        {
            l1 = jsonobject.getLong(s);
        }
        catch (Exception exception)
        {
            try
            {
                Log.debug("[InMobi]-4.5.5", (new StringBuilder()).append("JSON with property ").append(s).append(" found but has bad datatype(").append(jsonobject.get(s).getClass()).append("). Reverting to ").append(l).toString());
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                return l;
            }
            return l;
        }
        return l1;
    }

    public static long getLongFromMap(Map map, String s, long l, long l1)
    {
        Object obj = map.get(s);
        if (obj instanceof Long)
        {
            long l2 = ((Long)obj).longValue();
            if (l2 <= l1 && l2 >= l)
            {
                return l2;
            }
        }
        long l3 = l;
        if (l < 0xffffffff80000000L)
        {
            l3 = 0xffffffff80000000L;
        }
        int i = (int)l3;
        l = l1;
        if (l1 > 0x7fffffffL)
        {
            l = 0x7fffffffL;
        }
        return (long)getIntFromMap(map, s, i, (int)l);
    }

    public static String getLtvpSessionId()
    {
        return getContext().getSharedPreferences("inmobiAppAnalyticsSession", 0).getString("APP_SESSION_ID", null);
    }

    public static Object getObjectFromMap(Map map, String s)
    {
        map = ((Map) (map.get(s)));
        if (map != null && (map instanceof Map))
        {
            if (((Map)map).isEmpty())
            {
                Log.internal("[InMobi]-4.5.5", (new StringBuilder()).append("Key ").append(s).append(" has empty object as value.").toString());
                throw new IllegalArgumentException();
            } else
            {
                return map;
            }
        } else
        {
            Log.internal("[InMobi]-4.5.5", (new StringBuilder()).append("Key ").append(s).append(" has illegal value").toString());
            throw new IllegalArgumentException();
        }
    }

    public static String getSavedUserAgent()
    {
        return c;
    }

    public static File getSdkCacheDirectory(Context context)
    {
        return new File(context.getCacheDir(), "im_cached_content");
    }

    public static String getStringFromJSON(JSONObject jsonobject, String s, String s1)
    {
        String s2;
        try
        {
            s2 = jsonobject.getString(s);
        }
        catch (Exception exception)
        {
            try
            {
                Log.debug("[InMobi]-4.5.5", (new StringBuilder()).append("JSON with property ").append(s).append(" found but has bad datatype(").append(jsonobject.get(s).getClass()).append("). Reverting to ").append(s1).toString());
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                return s1;
            }
            return s1;
        }
        return s2;
    }

    public static String getStringFromMap(Map map, String s)
    {
        map = ((Map) (map.get(s)));
        if (map instanceof String)
        {
            return (String)map;
        } else
        {
            Log.internal("[InMobi]-4.5.5", (new StringBuilder()).append("Key ").append(s).append(" has illegal value").toString());
            throw new IllegalArgumentException();
        }
    }

    public static String getURLDecoded(String s, String s1)
    {
        try
        {
            s1 = URLDecoder.decode(s, s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.internal("[InMobi]-4.5.5", (new StringBuilder()).append("Exception URL decoding ").append(s).toString(), s1);
            return "";
        }
        return s1;
    }

    public static String getURLEncoded(String s)
    {
        String s1;
        try
        {
            s1 = URLEncoder.encode(s, "UTF-8");
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.5.5", (new StringBuilder()).append("Exception URL encoding ").append(s).toString(), exception);
            return "";
        }
        return s1;
    }

    public static String getUserAgent()
    {
        try
        {
            if (c == null)
            {
                if (android.os.Build.VERSION.SDK_INT >= 17)
                {
                    c = a.a(d);
                } else
                {
                    c = (new WebView(d)).getSettings().getUserAgentString();
                }
            }
            return c;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.5.5", "Cannot get user agent", exception);
        }
        return c;
    }

    public static void initialize(Context context)
    {
        if (getContext() == null)
        {
            if (context == null)
            {
                d.getApplicationContext();
            } else
            {
                d = context.getApplicationContext();
            }
        }
        if (InMobi.getAppId() == null)
        {
            return;
        }
        if (f)
        {
            f = false;
            a();
        }
        try
        {
            a(CacheController.getConfig("commons", context, a, e).getData());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.internal("[InMobi]-4.5.5", (new StringBuilder()).append("IMCommons config init: IMCommonsException caught. Reason: ").append(context.toString()).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.internal("[InMobi]-4.5.5", "Exception while getting commons config data.");
        }
    }

    public static boolean isHexString(String s)
    {
        return s.matches("[0-9A-F]+");
    }

    public static boolean isInitializedSuccessfully()
    {
        return isInitializedSuccessfully(true);
    }

    public static boolean isInitializedSuccessfully(boolean flag)
    {
        if (getContext() == null || InMobi.getAppId() == null)
        {
            if (flag)
            {
                Log.debug("[InMobi]-4.5.5", "InMobi not initialized. Call InMobi.initialize before using any InMobi API");
            }
            return false;
        } else
        {
            return true;
        }
    }

    public static String mapToJSONs(Map map)
    {
        if (map != null)
        {
            JSONObject jsonobject = new JSONObject();
            for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();)
            {
                String s = (String)iterator.next();
                try
                {
                    jsonobject.put(s, map.get(s));
                }
                catch (JSONException jsonexception)
                {
                    Log.internal("[InMobi]-4.5.5", (new StringBuilder()).append("Unable to convert map to JSON for key ").append(s).toString());
                }
            }

            return jsonobject.toString();
        } else
        {
            return null;
        }
    }

    public static void populate(Map map, Map map1, boolean flag)
    {
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            if (map1.get(s) == null)
            {
                map1.put(s, map.get(s));
            }
            Object obj = map.get(s);
            Object obj1 = map1.get(s);
            if ((obj instanceof Map) && (obj1 instanceof Map))
            {
                if (!flag)
                {
                    map1.put(s, obj);
                } else
                {
                    populate((Map)obj, (Map)obj1, true);
                }
            } else
            {
                map1.put(s, obj);
            }
        }

    }

    public static void populate(JSONObject jsonobject, JSONObject jsonobject1, boolean flag)
        throws JSONException
    {
        Iterator iterator = jsonobject.keys();
_L2:
        Object obj;
        Object obj1;
        Object obj2;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (String)iterator.next();
        try
        {
            jsonobject1.get(((String) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            jsonobject1.put(((String) (obj)), jsonobject.get(((String) (obj))));
            continue; /* Loop/switch isn't completed */
        }
        obj1 = jsonobject.get(((String) (obj)));
        obj2 = jsonobject1.get(((String) (obj)));
        if (!(obj1 instanceof JSONObject) || !(obj2 instanceof JSONObject))
        {
            break MISSING_BLOCK_LABEL_130;
        }
        if (!flag)
        {
            try
            {
                jsonobject1.put(((String) (obj)), obj1);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.internal("[InMobi]-4.5.5", "Cannot populate to json exception", ((Throwable) (obj)));
            }
            continue; /* Loop/switch isn't completed */
        }
        populate((JSONObject)obj1, (JSONObject)obj2, true);
        continue; /* Loop/switch isn't completed */
        jsonobject1.put(((String) (obj)), obj1);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static JSONObject populateToNewJSON(JSONObject jsonobject, JSONObject jsonobject1, boolean flag)
        throws JSONException
    {
        JSONObject jsonobject2 = new JSONObject();
        populate(jsonobject1, jsonobject2, false);
        populate(jsonobject, jsonobject2, flag);
        return jsonobject2;
    }

    public static Map populateToNewMap(Map map, Map map1, boolean flag)
    {
        HashMap hashmap = new HashMap();
        populate(map1, hashmap, false);
        populate(map, hashmap, flag);
        return hashmap;
    }

    public static void resetMediaCache(Context context)
    {
        context = getSdkCacheDirectory(context);
        clearSdkCacheDirectory(context, null);
        if (!context.mkdir() && !context.isDirectory())
        {
            Log.debug(com/inmobi/commons/internal/InternalSDKUtil.getSimpleName(), "Cannot create media cache directory");
        }
    }

    public static void setContext(Context context)
    {
label0:
        {
            if (d == null)
            {
                d = context.getApplicationContext();
                if (InMobi.getAppId() != null)
                {
                    break label0;
                }
            }
            return;
        }
        a();
        try
        {
            CacheController.getConfig("commons", context, a, e);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.internal("commons", "Unable retrive config for commons product");
        }
    }

    public static String union(String s, String s1)
    {
        String as[] = s.split(",");
        for (int i = 0; i < as.length;)
        {
            s = s1;
            if (!s1.contains(as[i]))
            {
                s = (new StringBuilder()).append(s1).append(",").append(as[i]).toString();
            }
            i++;
            s1 = s;
        }

        return s1;
    }

    public static boolean validateAppId(String s)
    {
        if (s == null)
        {
            Log.debug("[InMobi]-4.5.5", "appId is null");
            return false;
        }
        if (s.matches("(x)+"))
        {
            Log.debug("[InMobi]-4.5.5", "appId is all xxxxxxx");
            return false;
        }
        if ("".equals(s.trim()))
        {
            Log.debug("[InMobi]-4.5.5", "appId is all blank");
            return false;
        } else
        {
            return true;
        }
    }

    public static String xorWithKey(String s, String s1)
    {
        byte abyte0[];
        int i;
        try
        {
            s = s.getBytes("UTF-8");
            abyte0 = new byte[s.length];
            s1 = s1.getBytes("UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.debug("[InMobi]-4.5.5", "Exception in xor with random integer", s);
            return "";
        }
        i = 0;
        if (i >= s.length)
        {
            break; /* Loop/switch isn't completed */
        }
        abyte0[i] = (byte)(s[i] ^ s1[i % s1.length]);
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_23;
_L1:
        s = new String(Base64.encode(abyte0, 2), "UTF-8");
        return s;
    }

}
