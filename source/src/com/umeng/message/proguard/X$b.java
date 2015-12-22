// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;


// Referenced classes of package com.umeng.message.proguard:
//            X

static class h extends h
{

    private static final int c[] = {
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 
        54, 55, 56, 57, 58, 59, 60, 61, -1, -1, 
        -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
        49, 50, 51, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1
    };
    private static final int d[] = {
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 
        54, 55, 56, 57, 58, 59, 60, 61, -1, -1, 
        -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
        49, 50, 51, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1
    };
    private static final int e = -1;
    private static final int f = -2;
    private int g;
    private int h;
    private final int i[];

    public int a(int j)
    {
        return (j * 3) / 4 + 10;
    }

    public boolean a(byte abyte0[], int j, int k, boolean flag)
    {
        byte abyte1[];
        int ai[];
        int l;
        int i1;
        int k2;
        if (g == 6)
        {
            return false;
        }
        k2 = k + j;
        i1 = g;
        k = h;
        l = 0;
        abyte1 = a;
        ai = i;
        break MISSING_BLOCK_LABEL_42;
        k = ai[abyte0[j2] & 0xff];
        i1;
        JVM INSTR tableswitch 0 5: default 292
    //                   0 313
    //                   1 342
    //                   2 379
    //                   3 446
    //                   4 556
    //                   5 590;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        j = i1;
        k = l1;
        l = j1;
_L8:
        i1 = j;
        j = j2 + 1;
        continue; /* Loop/switch isn't completed */
_L2:
        if (k < 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        j = i1 + 1;
        l = j1;
          goto _L8
        if (k == -1) goto _L1; else goto _L9
_L9:
        g = 6;
        return false;
_L3:
        if (k < 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        k = l1 << 6 | k;
        j = i1 + 1;
        l = j1;
          goto _L8
        if (k == -1) goto _L1; else goto _L10
_L10:
        g = 6;
        return false;
_L4:
        if (k >= 0)
        {
            k = l1 << 6 | k;
            j = i1 + 1;
            l = j1;
        } else
        {
            if (k != -2)
            {
                continue; /* Loop/switch isn't completed */
            }
            abyte1[j1] = (byte)(l1 >> 4);
            j = 4;
            l = j1 + 1;
            k = l1;
        }
          goto _L8
        if (k == -1) goto _L1; else goto _L11
_L11:
        g = 6;
        return false;
_L5:
        if (k >= 0)
        {
            k = l1 << 6 | k;
            abyte1[j1 + 2] = (byte)k;
            abyte1[j1 + 1] = (byte)(k >> 8);
            abyte1[j1] = (byte)(k >> 16);
            l = j1 + 3;
            j = 0;
        } else
        {
            if (k != -2)
            {
                continue; /* Loop/switch isn't completed */
            }
            abyte1[j1 + 1] = (byte)(l1 >> 2);
            abyte1[j1] = (byte)(l1 >> 10);
            l = j1 + 2;
            j = 5;
            k = l1;
        }
          goto _L8
        if (k == -1) goto _L1; else goto _L12
_L12:
        g = 6;
        return false;
_L6:
        if (k != -2)
        {
            continue; /* Loop/switch isn't completed */
        }
        j = i1 + 1;
        l = j1;
        k = l1;
          goto _L8
        if (k == -1) goto _L1; else goto _L13
_L13:
        g = 6;
        return false;
_L7:
        if (k == -1) goto _L1; else goto _L14
_L14:
        g = 6;
        return false;
_L23:
        int j1;
        int l1;
        int j2;
        if (j < k2)
        {
            j1 = l;
            l1 = k;
            j2 = j;
            if (i1 != 0)
            {
                break MISSING_BLOCK_LABEL_238;
            }
            int i2 = j;
            j = k;
            do
            {
                if (i2 + 4 > k2)
                {
                    break;
                }
                k = ai[abyte0[i2] & 0xff] << 18 | ai[abyte0[i2 + 1] & 0xff] << 12 | ai[abyte0[i2 + 2] & 0xff] << 6 | ai[abyte0[i2 + 3] & 0xff];
                j = k;
                if (k < 0)
                {
                    break;
                }
                abyte1[l + 2] = (byte)k;
                abyte1[l + 1] = (byte)(k >> 8);
                abyte1[l] = (byte)(k >> 16);
                l += 3;
                i2 += 4;
                j = k;
            } while (true);
            j1 = l;
            l1 = j;
            j2 = i2;
            if (i2 < k2)
            {
                break MISSING_BLOCK_LABEL_238;
            }
            k = j;
        }
        if (!flag)
        {
            g = i1;
            h = k;
            b = l;
            return true;
        }
        j = l;
        i1;
        JVM INSTR tableswitch 0 4: default 644
    //                   0 647
    //                   1 660
    //                   2 668
    //                   3 685
    //                   4 718;
           goto _L15 _L16 _L17 _L18 _L19 _L20
_L16:
        break; /* Loop/switch isn't completed */
_L15:
        j = l;
_L21:
        g = i1;
        b = j;
        return true;
_L17:
        g = 6;
        return false;
_L18:
        abyte1[l] = (byte)(k >> 4);
        j = l + 1;
        continue; /* Loop/switch isn't completed */
_L19:
        int k1 = l + 1;
        abyte1[l] = (byte)(k >> 10);
        j = k1 + 1;
        abyte1[k1] = (byte)(k >> 2);
        if (true) goto _L21; else goto _L20
_L20:
        g = 6;
        return false;
        if (true) goto _L23; else goto _L22
_L22:
    }


    public (int j, byte abyte0[])
    {
        a = abyte0;
        if ((j & 8) == 0)
        {
            abyte0 = c;
        } else
        {
            abyte0 = d;
        }
        i = abyte0;
        g = 0;
        h = 0;
    }
}
