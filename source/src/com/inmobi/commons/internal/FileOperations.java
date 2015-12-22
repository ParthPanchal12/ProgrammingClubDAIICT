// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

// Referenced classes of package com.inmobi.commons.internal:
//            Log

public class FileOperations
{

    public FileOperations()
    {
    }

    public static void deleteDirectory(File file)
    {
        if (file.exists())
        {
            File afile[] = file.listFiles();
            if (afile != null)
            {
                int j = afile.length;
                int i = 0;
                while (i < j) 
                {
                    File file1 = afile[i];
                    if (file1.isDirectory())
                    {
                        deleteDirectory(file1);
                    } else
                    {
                        file1.delete();
                    }
                    i++;
                }
            }
            file.delete();
        }
    }

    public static boolean getBooleanPreferences(Context context, String s, String s1)
    {
        if (context == null || s == null || s1 == null || "".equals(s.trim()) || "".equals(s1.trim()))
        {
            Log.debug("[InMobi]-4.5.5", "Failed to get preferences..App context NULL");
            return false;
        } else
        {
            return context.getSharedPreferences(s, 0).getBoolean(s1, false);
        }
    }

    public static int getIntPreferences(Context context, String s, String s1)
    {
        if (context == null || s == null || s1 == null || "".equals(s.trim()) || "".equals(s1.trim()))
        {
            Log.debug("[InMobi]-4.5.5", "Failed to get preferences..App context NULL");
            return 0;
        } else
        {
            return context.getSharedPreferences(s, 0).getInt(s1, 0);
        }
    }

    public static long getLongPreferences(Context context, String s, String s1)
    {
        if (context == null || s == null || s1 == null || "".equals(s.trim()) || "".equals(s1.trim()))
        {
            Log.debug("[InMobi]-4.5.5", "Failed to get preferences..App context NULL");
            return 0L;
        } else
        {
            return context.getSharedPreferences(s, 0).getLong(s1, 0L);
        }
    }

    public static String getPreferences(Context context, String s, String s1)
    {
        if (context == null || s == null || s1 == null || "".equals(s.trim()) || "".equals(s1.trim()))
        {
            Log.debug("[InMobi]-4.5.5", "Failed to get preferences..App context NULL");
            return null;
        } else
        {
            return context.getSharedPreferences(s, 0).getString(s1, null);
        }
    }

    public static boolean isFileExist(Context context, String s)
    {
        boolean flag = false;
        if ((new File(context.getDir("data", 0), s)).exists())
        {
            flag = true;
        }
        return flag;
    }

    public static String readFileAsString(Context context, String s)
        throws IOException
    {
        context = new File((new StringBuilder()).append(context.getCacheDir().getAbsolutePath()).append(File.separator).append(s).toString());
        context.createNewFile();
        context = new BufferedReader(new FileReader(context));
        s = new StringBuffer();
        do
        {
            String s1 = context.readLine();
            if (s1 == null)
            {
                break;
            }
            s.append("\n").append(s1);
        } while (true);
        context.close();
        if (s.length() >= 1)
        {
            return s.substring(1).toString();
        } else
        {
            return "";
        }
    }

    public static Object readFromFile(Context context, String s)
    {
        String s1;
        Object obj;
        s1 = null;
        obj = null;
        if (context != null && s != null && !"".equals(s.trim())) goto _L2; else goto _L1
_L1:
        Log.internal("[InMobi]-4.5.5", "Cannot read map application context or Filename NULL");
        s1 = obj;
_L4:
        return s1;
_L2:
        context = new File(context.getDir("data", 0), s);
        context = new ObjectInputStream(new FileInputStream(context));
        s = ((String) (context.readObject()));
_L5:
        s1 = s;
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.internal("[InMobi]-4.5.5", "Log File Close Exception");
                return Boolean.valueOf(false);
            }
            return s;
        }
        if (true) goto _L4; else goto _L3
_L3:
        context;
        context = null;
_L10:
        Log.internal("[InMobi]-4.5.5", "End of File reached");
        s = s1;
          goto _L5
        s;
        context = null;
_L9:
        Log.internal("[InMobi]-4.5.5", "Event log File doesnot exist", s);
        s = s1;
          goto _L5
        s;
        context = null;
_L8:
        Log.internal("[InMobi]-4.5.5", "Event log File corrupted", s);
        s = s1;
          goto _L5
        s;
        context = null;
_L7:
        Log.internal("[InMobi]-4.5.5", "Event log File IO Exception", s);
        s = s1;
          goto _L5
        s;
        context = null;
_L6:
        Log.internal("[InMobi]-4.5.5", "Error: class not found", s);
        s = s1;
          goto _L5
        s;
          goto _L6
        s;
          goto _L7
        s;
          goto _L8
        s;
          goto _L9
        s;
          goto _L10
    }

    public static boolean saveToFile(Context context, String s, Object obj)
    {
        if (context == null || s == null || "".equals(s.trim()) || obj == null)
        {
            Log.internal("[InMobi]-4.5.5", "Cannot read map application context of Filename NULL");
            return false;
        }
        context = new File(context.getDir("data", 0), s);
        try
        {
            context = new ObjectOutputStream(new FileOutputStream(context, false));
            context.writeObject(obj);
            context.flush();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.internal("[InMobi]-4.5.5", "Log File Not found", context);
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.internal("[InMobi]-4.5.5", "Log File IO Exception", context);
            return false;
        }
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.internal("[InMobi]-4.5.5", "Log File Close Exception");
                return false;
            }
        }
        return true;
    }

    public static void setPreferences(Context context, String s, String s1, float f)
    {
        if (context == null || s == null || s1 == null || "".equals(s.trim()) || "".equals(s1.trim()))
        {
            Log.debug("[InMobi]-4.5.5", "Failed to set preferences..App context NULL");
            return;
        } else
        {
            context = context.getSharedPreferences(s, 0).edit();
            context.putFloat(s1, f);
            context.commit();
            return;
        }
    }

    public static void setPreferences(Context context, String s, String s1, int i)
    {
        if (context == null || s == null || s1 == null || "".equals(s.trim()) || "".equals(s1.trim()))
        {
            Log.debug("[InMobi]-4.5.5", "Failed to set preferences..App context NULL");
            return;
        } else
        {
            context = context.getSharedPreferences(s, 0).edit();
            context.putInt(s1, i);
            context.commit();
            return;
        }
    }

    public static void setPreferences(Context context, String s, String s1, long l)
    {
        if (context == null || s == null || s1 == null || "".equals(s.trim()) || "".equals(s1.trim()))
        {
            Log.debug("[InMobi]-4.5.5", "Failed to set preferences..App context NULL");
            return;
        } else
        {
            context = context.getSharedPreferences(s, 0).edit();
            context.putLong(s1, l);
            context.commit();
            return;
        }
    }

    public static void setPreferences(Context context, String s, String s1, boolean flag)
    {
        if (context == null || s == null || s1 == null || "".equals(s.trim()) || "".equals(s1.trim()))
        {
            Log.debug("[InMobi]-4.5.5", "Failed to set preferences..App context NULL");
            return;
        } else
        {
            context = context.getSharedPreferences(s, 0).edit();
            context.putBoolean(s1, flag);
            context.commit();
            return;
        }
    }

    public static boolean setPreferences(Context context, String s, String s1, String s2)
    {
        if (context == null || s == null || s1 == null || "".equals(s.trim()) || "".equals(s1.trim()))
        {
            Log.internal("[InMobi]-4.5.5", "Failed to set preferences..App context NULL");
            return false;
        } else
        {
            context = context.getSharedPreferences(s, 0).edit();
            context.putString(s1, s2);
            context.commit();
            return true;
        }
    }

    public static void writeStringToFile(Context context, String s, String s1, boolean flag)
        throws IOException
    {
        context = new File((new StringBuilder()).append(context.getCacheDir().getAbsolutePath()).append(File.separator).append(s).toString());
        context.createNewFile();
        context = new BufferedWriter(new FileWriter(context, flag));
        context.write(s1);
        context.close();
    }
}
