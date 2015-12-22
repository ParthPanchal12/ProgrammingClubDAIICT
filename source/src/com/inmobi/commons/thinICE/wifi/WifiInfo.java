// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.thinICE.wifi;


public final class WifiInfo
{

    public long bssid;
    public int ip;
    public int rssi;
    public String ssid;

    public WifiInfo()
    {
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(getClass().getSimpleName()).append("[");
        stringbuilder.append("bssid=").append(bssid).append(", ");
        stringbuilder.append("ssid=").append(ssid).append(", ");
        stringbuilder.append("rssi=").append(rssi).append(", ");
        stringbuilder.append("ip=").append(String.format("%d.%d.%d.%d", new Object[] {
            Integer.valueOf(ip & 0xff), Integer.valueOf(ip >> 8 & 0xff), Integer.valueOf(ip >> 16 & 0xff), Integer.valueOf(ip >> 24 & 0xff)
        }));
        stringbuilder.append("]");
        return stringbuilder.toString();
    }
}
