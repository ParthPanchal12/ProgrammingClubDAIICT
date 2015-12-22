// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;


// Referenced classes of package com.umeng.message.proguard:
//            X

static class l extends l
{

    public static final int c = 19;
    static final boolean h;
    private static final byte i[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 43, 47
    };
    private static final byte j[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 45, 95
    };
    int d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    private final byte k[] = new byte[2];
    private int l;
    private final byte m[];

    public int a(int i1)
    {
        return (i1 * 8) / 5 + 10;
    }

    public boolean a(byte abyte0[], int i1, int j1, boolean flag)
    {
        byte abyte1[];
        byte abyte2[];
        int k1;
        int i2;
        int j2;
        int i3;
        abyte1 = m;
        abyte2 = a;
        k1 = 0;
        j2 = l;
        i3 = j1 + i1;
        i2 = -1;
        d;
        JVM INSTR tableswitch 0 2: default 60
    //                   0 352
    //                   1 357
    //                   2 419;
           goto _L1 _L2 _L3 _L4
_L1:
        j1 = i1;
_L10:
        int l1;
        i1 = j2;
        l1 = j1;
        if (i2 == -1) goto _L6; else goto _L5
_L5:
        abyte2[0] = abyte1[i2 >> 18 & 0x3f];
        abyte2[1] = abyte1[i2 >> 12 & 0x3f];
        abyte2[2] = abyte1[i2 >> 6 & 0x3f];
        k1 = 4;
        abyte2[3] = abyte1[i2 & 0x3f];
        i2 = j2 - 1;
        i1 = i2;
        l1 = j1;
        if (i2 != 0) goto _L6; else goto _L7
_L7:
        byte abyte3[];
        int k2;
        int l2;
        if (g)
        {
            i1 = 5;
            abyte2[4] = 13;
        } else
        {
            i1 = 4;
        }
        abyte2[i1] = 10;
        l1 = 19;
        i1++;
        if (j1 + 3 > i3) goto _L9; else goto _L8
_L8:
        k1 = (abyte0[j1] & 0xff) << 16 | (abyte0[j1 + 1] & 0xff) << 8 | abyte0[j1 + 2] & 0xff;
        abyte2[i1] = abyte1[k1 >> 18 & 0x3f];
        abyte2[i1 + 1] = abyte1[k1 >> 12 & 0x3f];
        abyte2[i1 + 2] = abyte1[k1 >> 6 & 0x3f];
        abyte2[i1 + 3] = abyte1[k1 & 0x3f];
        j1 += 3;
        i2 = i1 + 4;
        k2 = l1 - 1;
        i1 = k2;
        k1 = i2;
        l1 = j1;
        if (k2 == 0)
        {
            if (g)
            {
                i1 = i2 + 1;
                abyte2[i2] = 13;
            } else
            {
                i1 = i2;
            }
            abyte2[i1] = 10;
            l1 = 19;
            i1++;
            break MISSING_BLOCK_LABEL_180;
        }
          goto _L6
_L2:
        j1 = i1;
          goto _L10
_L3:
        if (i1 + 2 > i3) goto _L1; else goto _L11
_L11:
        l1 = k[0];
        j1 = i1 + 1;
        i2 = (l1 & 0xff) << 16 | (abyte0[i1] & 0xff) << 8 | abyte0[j1] & 0xff;
        d = 0;
        j1++;
          goto _L10
_L4:
        if (i1 + 1 > i3) goto _L1; else goto _L12
_L12:
        l1 = k[0];
        i2 = k[1];
        j1 = i1 + 1;
        i2 = (l1 & 0xff) << 16 | (i2 & 0xff) << 8 | abyte0[i1] & 0xff;
        d = 0;
          goto _L10
_L9:
        if (!flag) goto _L14; else goto _L13
_L13:
        if (j1 - d != i3 - 1) goto _L16; else goto _L15
_L15:
        if (d > 0)
        {
            abyte0 = k;
            k1 = 1;
            i2 = abyte0[0];
        } else
        {
            i2 = abyte0[j1];
            j1++;
            k1 = 0;
        }
        i2 = (i2 & 0xff) << 4;
        d = d - k1;
        k2 = i1 + 1;
        abyte2[i1] = abyte1[i2 >> 6 & 0x3f];
        k1 = k2 + 1;
        abyte2[k2] = abyte1[i2 & 0x3f];
        i1 = k1;
        if (e)
        {
            i2 = k1 + 1;
            abyte2[k1] = 61;
            i1 = i2 + 1;
            abyte2[i2] = 61;
        }
        k1 = i1;
        if (f)
        {
            k1 = i1;
            if (g)
            {
                abyte2[i1] = 13;
                k1 = i1 + 1;
            }
            abyte2[k1] = 10;
            k1++;
        }
        i2 = j1;
_L18:
        if (!h && d != 0)
        {
            throw new AssertionError();
        }
        break; /* Loop/switch isn't completed */
_L16:
        if (j1 - d == i3 - 2)
        {
            if (d > 1)
            {
                abyte3 = k;
                k2 = 1;
                i2 = abyte3[0];
                k1 = j1;
                j1 = k2;
            } else
            {
                i2 = abyte0[j1];
                k1 = j1 + 1;
                j1 = 0;
            }
            if (d > 0)
            {
                k2 = k[j1];
                l2 = j1 + 1;
                j1 = k1;
                k1 = l2;
            } else
            {
                k2 = abyte0[k1];
                l2 = k1 + 1;
                k1 = j1;
                j1 = l2;
            }
            i2 = (k2 & 0xff) << 2 | (i2 & 0xff) << 10;
            d = d - k1;
            k1 = i1 + 1;
            abyte2[i1] = abyte1[i2 >> 12 & 0x3f];
            k2 = k1 + 1;
            abyte2[k1] = abyte1[i2 >> 6 & 0x3f];
            i1 = k2 + 1;
            abyte2[k2] = abyte1[i2 & 0x3f];
            if (e)
            {
                k1 = i1 + 1;
                abyte2[i1] = 61;
                i1 = k1;
            }
            k1 = i1;
            if (f)
            {
                k1 = i1;
                if (g)
                {
                    abyte2[i1] = 13;
                    k1 = i1 + 1;
                }
                abyte2[k1] = 10;
                k1++;
            }
            i2 = j1;
        } else
        {
            i2 = j1;
            k1 = i1;
            if (f)
            {
                i2 = j1;
                k1 = i1;
                if (i1 > 0)
                {
                    i2 = j1;
                    k1 = i1;
                    if (l1 != 19)
                    {
                        if (g)
                        {
                            k1 = i1 + 1;
                            abyte2[i1] = 13;
                            i1 = k1;
                        }
                        k1 = i1 + 1;
                        abyte2[i1] = 10;
                        i2 = j1;
                    }
                }
            }
        }
        if (true) goto _L18; else goto _L17
_L17:
        k2 = k1;
        if (!h)
        {
            k2 = k1;
            if (i2 != i3)
            {
                throw new AssertionError();
            }
        }
          goto _L19
_L14:
        if (j1 != i3 - 1) goto _L21; else goto _L20
_L20:
        abyte1 = k;
        k1 = d;
        d = k1 + 1;
        abyte1[k1] = abyte0[j1];
        k2 = i1;
_L19:
        b = k2;
        l = l1;
        return true;
_L21:
        k2 = i1;
        if (j1 == i3 - 2)
        {
            abyte1 = k;
            k1 = d;
            d = k1 + 1;
            abyte1[k1] = abyte0[j1];
            abyte1 = k;
            k1 = d;
            d = k1 + 1;
            abyte1[k1] = abyte0[j1 + 1];
            k2 = i1;
        }
        if (true) goto _L19; else goto _L6
_L6:
        i2 = i1;
        i1 = k1;
        j1 = l1;
        l1 = i2;
        break MISSING_BLOCK_LABEL_180;
    }

    static 
    {
        boolean flag;
        if (!com/umeng/message/proguard/X.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        h = flag;
    }

    public (int i1, byte abyte0[])
    {
        boolean flag1 = true;
        super();
        a = abyte0;
        boolean flag;
        if ((i1 & 1) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        e = flag;
        if ((i1 & 2) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f = flag;
        if ((i1 & 4) != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        g = flag;
        if ((i1 & 8) == 0)
        {
            abyte0 = i;
        } else
        {
            abyte0 = j;
        }
        m = abyte0;
        d = 0;
        if (f)
        {
            i1 = 19;
        } else
        {
            i1 = -1;
        }
        l = i1;
    }
}
