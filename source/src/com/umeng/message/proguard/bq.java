// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;

public class bq
{

    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 0;
    public static final int d = 2;
    public static final int e = 8;
    public static final int f = 16;
    public static final int g = 32;
    private static final int h = 76;
    private static final byte i = 61;
    private static final byte j = 10;
    private static final String k = "UTF-8";
    private static final byte l = -5;
    private static final byte m = -1;
    private static final byte n[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 43, 47
    };
    private static final byte o[] = {
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, 
        -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 
        54, 55, 56, 57, 58, 59, 60, 61, -9, -9, 
        -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
        49, 50, 51, -9, -9, -9, -9
    };
    private static final byte p[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 45, 95
    };
    private static final byte q[] = {
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, 
        -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 
        54, 55, 56, 57, 58, 59, 60, 61, -9, -9, 
        -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
        49, 50, 51, -9, -9, -9, -9
    };
    private static final byte r[] = {
        45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 
        57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 
        74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 
        84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 
        99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 
        109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 
        119, 120, 121, 122
    };
    private static final byte s[] = {
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, 
        -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 
        3, 4, 5, 6, 7, 8, 9, 10, -9, -9, 
        -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 
        16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 
        26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 
        36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 
        41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 
        51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 
        61, 62, 63, -9, -9, -9, -9
    };

    public bq()
    {
    }

    private static int a(byte abyte0[], int i1, byte abyte1[], int j1, int k1)
    {
        byte abyte2[] = b(k1);
        if (abyte0[i1 + 2] == 61)
        {
            k1 = abyte2[abyte0[i1]];
            abyte1[j1] = (byte)(((abyte2[abyte0[i1 + 1]] & 0xff) << 12 | (k1 & 0xff) << 18) >>> 16);
            return 1;
        }
        if (abyte0[i1 + 3] == 61)
        {
            k1 = abyte2[abyte0[i1]];
            byte byte0 = abyte2[abyte0[i1 + 1]];
            i1 = (abyte2[abyte0[i1 + 2]] & 0xff) << 6 | ((k1 & 0xff) << 18 | (byte0 & 0xff) << 12);
            abyte1[j1] = (byte)(i1 >>> 16);
            abyte1[j1 + 1] = (byte)(i1 >>> 8);
            return 2;
        } else
        {
            k1 = abyte2[abyte0[i1]];
            byte byte1 = abyte2[abyte0[i1 + 1]];
            byte byte2 = abyte2[abyte0[i1 + 2]];
            i1 = abyte2[abyte0[i1 + 3]] & 0xff | ((k1 & 0xff) << 18 | (byte1 & 0xff) << 12 | (byte2 & 0xff) << 6);
            abyte1[j1] = (byte)(i1 >> 16);
            abyte1[j1 + 1] = (byte)(i1 >> 8);
            abyte1[j1 + 2] = (byte)i1;
            return 3;
        }
    }

    public static String a(byte abyte0[])
    {
        if (abyte0 == null)
        {
            return null;
        } else
        {
            return a(abyte0, 0, abyte0.length, 0);
        }
    }

    public static String a(byte abyte0[], int i1)
    {
        return a(abyte0, 0, abyte0.length, i1);
    }

    public static String a(byte abyte0[], int i1, int j1)
    {
        return a(abyte0, i1, j1, 0);
    }

    public static String a(byte abyte0[], int i1, int j1, int k1)
    {
        byte abyte1[];
        int l1;
        int i2;
        boolean flag;
        int j2;
        if ((k1 & 8) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        j2 = (j1 * 4) / 3;
        if (j1 % 3 > 0)
        {
            l1 = 4;
        } else
        {
            l1 = 0;
        }
        if (flag)
        {
            i2 = j2 / 76;
        } else
        {
            i2 = 0;
        }
        abyte1 = new byte[i2 + (j2 + l1)];
        i2 = 0;
        l1 = 0;
        for (j2 = 0; j2 < j1 - 2; j2 += 3)
        {
            a(abyte0, j2 + i1, 3, abyte1, l1, k1);
            int l2 = i2 + 4;
            i2 = l2;
            int k2 = l1;
            if (flag)
            {
                i2 = l2;
                k2 = l1;
                if (l2 == 76)
                {
                    abyte1[l1 + 4] = 10;
                    k2 = l1 + 1;
                    i2 = 0;
                }
            }
            l1 = k2 + 4;
        }

        i2 = l1;
        if (j2 < j1)
        {
            a(abyte0, j2 + i1, j1 - j2, abyte1, l1, k1);
            i2 = l1 + 4;
        }
        try
        {
            abyte0 = new String(abyte1, 0, i2, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            return new String(abyte1, 0, i2);
        }
        return abyte0;
    }

    private static final byte[] a(int i1)
    {
        if ((i1 & 0x10) == 16)
        {
            return p;
        }
        if ((i1 & 0x20) == 32)
        {
            return r;
        } else
        {
            return n;
        }
    }

    public static byte[] a(String s1)
    {
        return a(s1, 0);
    }

    public static byte[] a(String s1, int i1)
    {
        if (TextUtils.isEmpty(s1))
        {
            return null;
        }
        byte abyte0[] = s1.getBytes("UTF-8");
        s1 = abyte0;
_L2:
        return b(s1, 0, s1.length, i1);
        Throwable throwable;
        throwable;
        s1 = s1.getBytes();
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static byte[] a(byte abyte0[], int i1, int j1, byte abyte1[], int k1, int l1)
    {
        int j2 = 0;
        byte abyte2[] = a(l1);
        int i2;
        if (j1 > 0)
        {
            l1 = (abyte0[i1] << 24) >>> 8;
        } else
        {
            l1 = 0;
        }
        if (j1 > 1)
        {
            i2 = (abyte0[i1 + 1] << 24) >>> 16;
        } else
        {
            i2 = 0;
        }
        if (j1 > 2)
        {
            j2 = (abyte0[i1 + 2] << 24) >>> 24;
        }
        i1 = j2 | (i2 | l1);
        switch (j1)
        {
        default:
            return abyte1;

        case 3: // '\003'
            abyte1[k1] = abyte2[i1 >>> 18];
            abyte1[k1 + 1] = abyte2[i1 >>> 12 & 0x3f];
            abyte1[k1 + 2] = abyte2[i1 >>> 6 & 0x3f];
            abyte1[k1 + 3] = abyte2[i1 & 0x3f];
            return abyte1;

        case 2: // '\002'
            abyte1[k1] = abyte2[i1 >>> 18];
            abyte1[k1 + 1] = abyte2[i1 >>> 12 & 0x3f];
            abyte1[k1 + 2] = abyte2[i1 >>> 6 & 0x3f];
            abyte1[k1 + 3] = 61;
            return abyte1;

        case 1: // '\001'
            abyte1[k1] = abyte2[i1 >>> 18];
            abyte1[k1 + 1] = abyte2[i1 >>> 12 & 0x3f];
            abyte1[k1 + 2] = 61;
            abyte1[k1 + 3] = 61;
            return abyte1;
        }
    }

    private static final byte[] b(int i1)
    {
        if ((i1 & 0x10) == 16)
        {
            return q;
        }
        if ((i1 & 0x20) == 32)
        {
            return s;
        } else
        {
            return o;
        }
    }

    public static byte[] b(byte abyte0[], int i1, int j1, int k1)
    {
        byte abyte1[];
        byte abyte2[];
        byte abyte3[];
        int l1;
        int i2;
        int j2;
        abyte2 = b(k1);
        abyte1 = new byte[(j1 * 3) / 4];
        abyte3 = new byte[4];
        j2 = i1;
        i2 = 0;
        l1 = 0;
_L9:
        byte byte0;
        int k2;
        if (j2 >= i1 + j1)
        {
            break MISSING_BLOCK_LABEL_182;
        }
        byte0 = (byte)(abyte0[j2] & 0x7f);
        k2 = abyte2[byte0];
        if (k2 < -5) goto _L2; else goto _L1
_L1:
        if (k2 < -1) goto _L4; else goto _L3
_L3:
        k2 = i2 + 1;
        abyte3[i2] = byte0;
        if (k2 <= 3) goto _L6; else goto _L5
_L5:
        i2 = a(abyte3, 0, abyte1, l1, k1) + l1;
        if (byte0 != 61) goto _L8; else goto _L7
_L7:
        abyte0 = new byte[i2];
        System.arraycopy(abyte1, 0, abyte0, 0, i2);
        return abyte0;
_L2:
        return null;
_L8:
        l1 = 0;
_L10:
        k2 = j2 + 1;
        j2 = i2;
        i2 = l1;
        l1 = j2;
        j2 = k2;
          goto _L9
_L6:
        i2 = l1;
        l1 = k2;
          goto _L10
_L4:
        int l2 = l1;
        l1 = i2;
        i2 = l2;
          goto _L10
        i2 = l1;
          goto _L7
    }

}
