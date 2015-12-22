// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.util.Xml;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.umeng.message.proguard:
//            ag

class ak
{

    ak()
    {
    }

    public static final int a(CharSequence charsequence)
    {
        byte byte0;
        byte byte1;
        int i;
        byte0 = 16;
        byte1 = 1;
        charsequence = charsequence.toString();
        i = charsequence.length();
        if ('0' != charsequence.charAt(0)) goto _L2; else goto _L1
_L1:
        if (i - 1 == 0)
        {
            return 0;
        }
        i = charsequence.charAt(1);
        if ('x' == i || 'X' == i)
        {
            byte1 = 2;
        } else
        {
            byte0 = 8;
        }
_L4:
        return (int)Long.parseLong(charsequence.substring(byte1), byte0);
_L2:
        if ('#' != charsequence.charAt(0))
        {
            byte0 = 10;
            byte1 = 0;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static final int a(CharSequence charsequence, int i)
    {
        int j = 1;
        if (charsequence == null)
        {
            return i;
        }
        charsequence = charsequence.toString();
        int k = charsequence.length();
        byte byte0;
        if ('-' == charsequence.charAt(0))
        {
            byte0 = -1;
            i = j;
        } else
        {
            byte0 = 1;
            i = 0;
        }
        if ('0' == charsequence.charAt(i))
        {
            if (i == k - 1)
            {
                return 0;
            }
            j = charsequence.charAt(i + 1);
            if ('x' == j || 'X' == j)
            {
                j = i + 2;
                i = 16;
            } else
            {
                j = i + 1;
                i = 8;
            }
        } else
        if ('#' == charsequence.charAt(i))
        {
            j = i + 1;
            i = 16;
        } else
        {
            j = i;
            i = 10;
        }
        return Integer.parseInt(charsequence.substring(j), i) * byte0;
    }

    public static final int a(CharSequence charsequence, String as[], int i)
    {
        if (charsequence != null)
        {
            for (int j = 0; j < as.length; j++)
            {
                if (charsequence.equals(as[j]))
                {
                    return j;
                }
            }

        }
        return i;
    }

    public static final int a(String s, int i)
    {
        if (s == null)
        {
            return i;
        } else
        {
            return a(((CharSequence) (s)));
        }
    }

    public static final Object a(XmlPullParser xmlpullparser, String as[])
        throws XmlPullParserException, IOException
    {
        int i = xmlpullparser.getEventType();
        do
        {
            if (i == 2)
            {
                return b(xmlpullparser, as);
            }
            if (i == 3)
            {
                throw new XmlPullParserException((new StringBuilder()).append("Unexpected end tag at: ").append(xmlpullparser.getName()).toString());
            }
            if (i == 4)
            {
                throw new XmlPullParserException((new StringBuilder()).append("Unexpected text: ").append(xmlpullparser.getText()).toString());
            }
            int j;
            try
            {
                j = xmlpullparser.next();
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                throw new XmlPullParserException((new StringBuilder()).append("Unexpected call next(): ").append(xmlpullparser.getName()).toString());
            }
            i = j;
        } while (j != 1);
        throw new XmlPullParserException("Unexpected end of document");
    }

    public static final HashMap a(InputStream inputstream)
        throws XmlPullParserException, IOException
    {
        XmlPullParser xmlpullparser = Xml.newPullParser();
        xmlpullparser.setInput(inputstream, null);
        return (HashMap)a(xmlpullparser, new String[1]);
    }

    public static final HashMap a(XmlPullParser xmlpullparser, String s, String as[])
        throws XmlPullParserException, IOException
    {
        HashMap hashmap;
        int i;
        hashmap = new HashMap();
        i = xmlpullparser.getEventType();
_L2:
        if (i != 2)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        Object obj = b(xmlpullparser, as);
        if (as[0] == null)
        {
            break; /* Loop/switch isn't completed */
        }
        hashmap.put(as[0], obj);
_L3:
        int j = xmlpullparser.next();
        i = j;
        if (j == 1)
        {
            throw new XmlPullParserException((new StringBuilder()).append("Document ended before ").append(s).append(" end tag").toString());
        }
        if (true) goto _L2; else goto _L1
_L1:
        throw new XmlPullParserException((new StringBuilder()).append("Map value without name attribute: ").append(xmlpullparser.getName()).toString());
        if (i == 3)
        {
            if (xmlpullparser.getName().equals(s))
            {
                return hashmap;
            } else
            {
                throw new XmlPullParserException((new StringBuilder()).append("Expected ").append(s).append(" end tag at: ").append(xmlpullparser.getName()).toString());
            }
        }
          goto _L3
    }

    public static final void a(Object obj, String s, XmlSerializer xmlserializer)
        throws XmlPullParserException, IOException
    {
        if (obj == null)
        {
            xmlserializer.startTag(null, "null");
            if (s != null)
            {
                xmlserializer.attribute(null, "name", s);
            }
            xmlserializer.endTag(null, "null");
            return;
        }
        if (obj instanceof String)
        {
            xmlserializer.startTag(null, "string");
            if (s != null)
            {
                xmlserializer.attribute(null, "name", s);
            }
            xmlserializer.text(obj.toString());
            xmlserializer.endTag(null, "string");
            return;
        }
        if (!(obj instanceof Integer)) goto _L2; else goto _L1
_L1:
        String s1 = "int";
_L4:
        xmlserializer.startTag(null, s1);
        if (s != null)
        {
            xmlserializer.attribute(null, "name", s);
        }
        xmlserializer.attribute(null, "value", obj.toString());
        xmlserializer.endTag(null, s1);
        return;
_L2:
        if (obj instanceof Long)
        {
            s1 = "long";
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof Float)
        {
            s1 = "float";
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof Double)
        {
            s1 = "double";
            continue; /* Loop/switch isn't completed */
        }
        if (!(obj instanceof Boolean))
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = "boolean";
        if (true) goto _L4; else goto _L3
_L3:
        if (obj instanceof byte[])
        {
            a((byte[])(byte[])obj, s, xmlserializer);
            return;
        }
        if (obj instanceof int[])
        {
            a((int[])(int[])obj, s, xmlserializer);
            return;
        }
        if (obj instanceof Map)
        {
            a((Map)obj, s, xmlserializer);
            return;
        }
        if (obj instanceof List)
        {
            a((List)obj, s, xmlserializer);
            return;
        }
        if (obj instanceof CharSequence)
        {
            xmlserializer.startTag(null, "string");
            if (s != null)
            {
                xmlserializer.attribute(null, "name", s);
            }
            xmlserializer.text(obj.toString());
            xmlserializer.endTag(null, "string");
            return;
        } else
        {
            throw new RuntimeException((new StringBuilder()).append("writeValueXml: unable to write value ").append(obj).toString());
        }
    }

    public static final void a(List list, OutputStream outputstream)
        throws XmlPullParserException, IOException
    {
        XmlSerializer xmlserializer = Xml.newSerializer();
        xmlserializer.setOutput(outputstream, "utf-8");
        xmlserializer.startDocument(null, Boolean.valueOf(true));
        xmlserializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        a(list, ((String) (null)), xmlserializer);
        xmlserializer.endDocument();
    }

    public static final void a(List list, String s, XmlSerializer xmlserializer)
        throws XmlPullParserException, IOException
    {
        if (list == null)
        {
            xmlserializer.startTag(null, "null");
            xmlserializer.endTag(null, "null");
            return;
        }
        xmlserializer.startTag(null, "list");
        if (s != null)
        {
            xmlserializer.attribute(null, "name", s);
        }
        int j = list.size();
        for (int i = 0; i < j; i++)
        {
            a(list.get(i), ((String) (null)), xmlserializer);
        }

        xmlserializer.endTag(null, "list");
    }

    public static final void a(Map map, OutputStream outputstream)
        throws XmlPullParserException, IOException
    {
        ag ag1 = new ag();
        ag1.setOutput(outputstream, "utf-8");
        ag1.startDocument(null, Boolean.valueOf(true));
        ag1.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        a(map, ((String) (null)), ((XmlSerializer) (ag1)));
        ag1.endDocument();
    }

    public static final void a(Map map, String s, XmlSerializer xmlserializer)
        throws XmlPullParserException, IOException
    {
        if (map == null)
        {
            xmlserializer.startTag(null, "null");
            xmlserializer.endTag(null, "null");
            return;
        }
        map = map.entrySet().iterator();
        xmlserializer.startTag(null, "map");
        if (s != null)
        {
            xmlserializer.attribute(null, "name", s);
        }
        for (; map.hasNext(); a(s.getValue(), (String)s.getKey(), xmlserializer))
        {
            s = (java.util.Map.Entry)map.next();
        }

        xmlserializer.endTag(null, "map");
    }

    public static void a(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        int i = xmlpullparser.getDepth();
        int j;
        do
        {
            j = xmlpullparser.next();
        } while (j != 1 && (j != 3 || xmlpullparser.getDepth() > i));
    }

    public static final void a(XmlPullParser xmlpullparser, String s)
        throws XmlPullParserException, IOException
    {
        int i;
        do
        {
            i = xmlpullparser.next();
        } while (i != 2 && i != 1);
        if (i != 2)
        {
            throw new XmlPullParserException("No start tag found");
        }
        if (!xmlpullparser.getName().equals(s))
        {
            throw new XmlPullParserException((new StringBuilder()).append("Unexpected start tag: found ").append(xmlpullparser.getName()).append(", expected ").append(s).toString());
        } else
        {
            return;
        }
    }

    public static final void a(byte abyte0[], String s, XmlSerializer xmlserializer)
        throws XmlPullParserException, IOException
    {
        if (abyte0 == null)
        {
            xmlserializer.startTag(null, "null");
            xmlserializer.endTag(null, "null");
            return;
        }
        xmlserializer.startTag(null, "byte-array");
        if (s != null)
        {
            xmlserializer.attribute(null, "name", s);
        }
        int k = abyte0.length;
        xmlserializer.attribute(null, "num", Integer.toString(k));
        s = new StringBuilder(abyte0.length * 2);
        int i = 0;
        while (i < k) 
        {
            byte byte0 = abyte0[i];
            int j = byte0 >> 4;
            if (j >= 10)
            {
                j = (j + 97) - 10;
            } else
            {
                j += 48;
            }
            s.append(j);
            j = byte0 & 0xff;
            if (j >= 10)
            {
                j = (j + 97) - 10;
            } else
            {
                j += 48;
            }
            s.append(j);
            i++;
        }
        xmlserializer.text(s.toString());
        xmlserializer.endTag(null, "byte-array");
    }

    public static final void a(int ai[], String s, XmlSerializer xmlserializer)
        throws XmlPullParserException, IOException
    {
        if (ai == null)
        {
            xmlserializer.startTag(null, "null");
            xmlserializer.endTag(null, "null");
            return;
        }
        xmlserializer.startTag(null, "int-array");
        if (s != null)
        {
            xmlserializer.attribute(null, "name", s);
        }
        int j = ai.length;
        xmlserializer.attribute(null, "num", Integer.toString(j));
        for (int i = 0; i < j; i++)
        {
            xmlserializer.startTag(null, "item");
            xmlserializer.attribute(null, "value", Integer.toString(ai[i]));
            xmlserializer.endTag(null, "item");
        }

        xmlserializer.endTag(null, "int-array");
    }

    public static final boolean a(CharSequence charsequence, boolean flag)
    {
label0:
        {
            boolean flag1 = false;
            if (charsequence == null)
            {
                return flag;
            }
            if (!charsequence.equals("1") && !charsequence.equals("true"))
            {
                flag = flag1;
                if (!charsequence.equals("TRUE"))
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    private static final Object b(XmlPullParser xmlpullparser, String as[])
        throws XmlPullParserException, IOException
    {
        Object obj = null;
        String s = xmlpullparser.getAttributeValue(null, "name");
        String s1 = xmlpullparser.getName();
        if (!s1.equals("null"))
        {
            if (s1.equals("string"))
            {
                obj = "";
label0:
                do
                {
                    do
                    {
                        i = xmlpullparser.next();
                        if (i != 1)
                        {
                            if (i == 3)
                            {
                                if (xmlpullparser.getName().equals("string"))
                                {
                                    as[0] = s;
                                    return obj;
                                } else
                                {
                                    throw new XmlPullParserException((new StringBuilder()).append("Unexpected end tag in <string>: ").append(xmlpullparser.getName()).toString());
                                }
                            }
                            if (i != 4)
                            {
                                continue label0;
                            }
                            obj = (new StringBuilder()).append(((String) (obj))).append(xmlpullparser.getText()).toString();
                        } else
                        {
                            throw new XmlPullParserException("Unexpected end of document in <string>");
                        }
                    } while (true);
                } while (i != 2);
                throw new XmlPullParserException((new StringBuilder()).append("Unexpected start tag in <string>: ").append(xmlpullparser.getName()).toString());
            }
            if (s1.equals("int"))
            {
                obj = Integer.valueOf(Integer.parseInt(xmlpullparser.getAttributeValue(null, "value")));
            } else
            if (s1.equals("long"))
            {
                obj = Long.valueOf(xmlpullparser.getAttributeValue(null, "value"));
            } else
            if (s1.equals("float"))
            {
                obj = new Float(xmlpullparser.getAttributeValue(null, "value"));
            } else
            if (s1.equals("double"))
            {
                obj = new Double(xmlpullparser.getAttributeValue(null, "value"));
            } else
            if (s1.equals("boolean"))
            {
                obj = Boolean.valueOf(xmlpullparser.getAttributeValue(null, "value"));
            } else
            {
                if (s1.equals("int-array"))
                {
                    xmlpullparser.next();
                    xmlpullparser = c(xmlpullparser, "int-array", as);
                    as[0] = s;
                    return xmlpullparser;
                }
                if (s1.equals("map"))
                {
                    xmlpullparser.next();
                    xmlpullparser = a(xmlpullparser, "map", as);
                    as[0] = s;
                    return xmlpullparser;
                }
                if (s1.equals("list"))
                {
                    xmlpullparser.next();
                    xmlpullparser = b(xmlpullparser, "list", as);
                    as[0] = s;
                    return xmlpullparser;
                } else
                {
                    throw new XmlPullParserException((new StringBuilder()).append("Unknown tag: ").append(s1).toString());
                }
            }
        }
        do
        {
            int i = xmlpullparser.next();
            if (i != 1)
            {
                if (i == 3)
                {
                    if (xmlpullparser.getName().equals(s1))
                    {
                        as[0] = s;
                        return obj;
                    } else
                    {
                        throw new XmlPullParserException((new StringBuilder()).append("Unexpected end tag in <").append(s1).append(">: ").append(xmlpullparser.getName()).toString());
                    }
                }
                if (i == 4)
                {
                    throw new XmlPullParserException((new StringBuilder()).append("Unexpected text in <").append(s1).append(">: ").append(xmlpullparser.getName()).toString());
                }
                if (i == 2)
                {
                    throw new XmlPullParserException((new StringBuilder()).append("Unexpected start tag in <").append(s1).append(">: ").append(xmlpullparser.getName()).toString());
                }
            } else
            {
                throw new XmlPullParserException((new StringBuilder()).append("Unexpected end of document in <").append(s1).append(">").toString());
            }
        } while (true);
    }

    public static final ArrayList b(InputStream inputstream)
        throws XmlPullParserException, IOException
    {
        XmlPullParser xmlpullparser = Xml.newPullParser();
        xmlpullparser.setInput(inputstream, null);
        return (ArrayList)a(xmlpullparser, new String[1]);
    }

    public static final ArrayList b(XmlPullParser xmlpullparser, String s, String as[])
        throws XmlPullParserException, IOException
    {
        ArrayList arraylist = new ArrayList();
        int i = xmlpullparser.getEventType();
        do
        {
            int j;
            if (i == 2)
            {
                arraylist.add(b(xmlpullparser, as));
            } else
            if (i == 3)
            {
                if (xmlpullparser.getName().equals(s))
                {
                    return arraylist;
                } else
                {
                    throw new XmlPullParserException((new StringBuilder()).append("Expected ").append(s).append(" end tag at: ").append(xmlpullparser.getName()).toString());
                }
            }
            j = xmlpullparser.next();
            i = j;
        } while (j != 1);
        throw new XmlPullParserException((new StringBuilder()).append("Document ended before ").append(s).append(" end tag").toString());
    }

    public static final void b(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        int i;
        do
        {
            i = xmlpullparser.next();
        } while (i != 2 && i != 1);
    }

    public static final int[] c(XmlPullParser xmlpullparser, String s, String as[])
        throws XmlPullParserException, IOException
    {
        int i;
        int j;
        int k;
        int l;
        try
        {
            i = Integer.parseInt(xmlpullparser.getAttributeValue(null, "num"));
        }
        // Misplaced declaration of an exception variable
        catch (XmlPullParser xmlpullparser)
        {
            throw new XmlPullParserException("Need num attribute in byte-array");
        }
        // Misplaced declaration of an exception variable
        catch (XmlPullParser xmlpullparser)
        {
            throw new XmlPullParserException("Not a number in num attribute in byte-array");
        }
        as = new int[i];
        i = xmlpullparser.getEventType();
        j = 0;
        if (i != 2)
        {
            break MISSING_BLOCK_LABEL_202;
        }
        if (!xmlpullparser.getName().equals("item"))
        {
            break; /* Loop/switch isn't completed */
        }
        try
        {
            as[j] = Integer.parseInt(xmlpullparser.getAttributeValue(null, "value"));
        }
        // Misplaced declaration of an exception variable
        catch (XmlPullParser xmlpullparser)
        {
            throw new XmlPullParserException("Need value attribute in item");
        }
        // Misplaced declaration of an exception variable
        catch (XmlPullParser xmlpullparser)
        {
            throw new XmlPullParserException("Not a number in value attribute in item");
        }
        k = j;
_L4:
        l = xmlpullparser.next();
        j = k;
        i = l;
        if (l == 1)
        {
            throw new XmlPullParserException((new StringBuilder()).append("Document ended before ").append(s).append(" end tag").toString());
        }
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_28;
_L1:
        throw new XmlPullParserException((new StringBuilder()).append("Expected item tag at: ").append(xmlpullparser.getName()).toString());
        k = j;
        if (i == 3)
        {
            if (xmlpullparser.getName().equals(s))
            {
                return as;
            }
            if (xmlpullparser.getName().equals("item"))
            {
                k = j + 1;
            } else
            {
                throw new XmlPullParserException((new StringBuilder()).append("Expected ").append(s).append(" end tag at: ").append(xmlpullparser.getName()).toString());
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
