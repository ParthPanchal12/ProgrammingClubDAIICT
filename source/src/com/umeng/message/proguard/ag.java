// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import org.xmlpull.v1.XmlSerializer;

class ag
    implements XmlSerializer
{

    private static final String a[] = {
        null, null, null, null, null, null, null, null, null, null, 
        null, null, null, null, null, null, null, null, null, null, 
        null, null, null, null, null, null, null, null, null, null, 
        null, null, null, null, "&quot;", null, null, null, "&amp;", null, 
        null, null, null, null, null, null, null, null, null, null, 
        null, null, null, null, null, null, null, null, null, null, 
        "&lt;", null, "&gt;", null
    };
    private static final int b = 8192;
    private final char c[] = new char[8192];
    private int d;
    private Writer e;
    private OutputStream f;
    private CharsetEncoder g;
    private ByteBuffer h;
    private boolean i;

    ag()
    {
        h = ByteBuffer.allocate(8192);
    }

    private void a()
        throws IOException
    {
        int j = h.position();
        if (j > 0)
        {
            h.flip();
            f.write(h.array(), 0, j);
            h.clear();
        }
    }

    private void a(char c1)
        throws IOException
    {
        int k = d;
        int j = k;
        if (k >= 8191)
        {
            flush();
            j = d;
        }
        c[j] = c1;
        d = j + 1;
    }

    private void a(String s)
        throws IOException
    {
        a(s, 0, s.length());
    }

    private void a(String s, int j, int k)
        throws IOException
    {
        if (k > 8192)
        {
            int j1 = j + k;
            while (j < j1) 
            {
                int l = j + 8192;
                if (l < j1)
                {
                    k = 8192;
                } else
                {
                    k = j1 - j;
                }
                a(s, j, k);
                j = l;
            }
        } else
        {
            int k1 = d;
            int i1 = k1;
            if (k1 + k > 8192)
            {
                flush();
                i1 = d;
            }
            s.getChars(j, j + k, c, i1);
            d = i1 + k;
        }
    }

    private void a(char ac[], int j, int k)
        throws IOException
    {
        if (k > 8192)
        {
            int j1 = j + k;
            while (j < j1) 
            {
                int l = j + 8192;
                if (l < j1)
                {
                    k = 8192;
                } else
                {
                    k = j1 - j;
                }
                a(ac, j, k);
                j = l;
            }
        } else
        {
            int k1 = d;
            int i1 = k1;
            if (k1 + k > 8192)
            {
                flush();
                i1 = d;
            }
            System.arraycopy(ac, j, c, i1, k);
            d = i1 + k;
        }
    }

    private void b(String s)
        throws IOException
    {
        char c1 = '\0';
        int l = s.length();
        char c2 = (char)a.length;
        String as[] = a;
        int j = 0;
        while (j < l) 
        {
            int k = s.charAt(j);
            if (k >= c2)
            {
                k = c1;
            } else
            {
                String s1 = as[k];
                k = c1;
                if (s1 != null)
                {
                    if (c1 < j)
                    {
                        a(s, c1, j - c1);
                    }
                    k = j + 1;
                    a(s1);
                }
            }
            j++;
            c1 = k;
        }
        if (c1 < j)
        {
            a(s, c1, j - c1);
        }
    }

    private void b(char ac[], int j, int k)
        throws IOException
    {
        char c1 = (char)a.length;
        String as[] = a;
        int i1 = j;
        int l = j;
        do
        {
            int j1 = l;
            if (j1 < j + k)
            {
                l = ac[j1];
                if (l >= c1)
                {
                    l = i1;
                } else
                {
                    String s = as[l];
                    l = i1;
                    if (s != null)
                    {
                        if (i1 < j1)
                        {
                            a(ac, i1, j1 - i1);
                        }
                        l = j1 + 1;
                        a(s);
                    }
                }
                j1++;
                i1 = l;
                l = j1;
            } else
            {
                if (i1 < j1)
                {
                    a(ac, i1, j1 - i1);
                }
                return;
            }
        } while (true);
    }

    public XmlSerializer attribute(String s, String s1, String s2)
        throws IOException, IllegalArgumentException, IllegalStateException
    {
        a(' ');
        if (s != null)
        {
            a(s);
            a(':');
        }
        a(s1);
        a("=\"");
        b(s2);
        a('"');
        return this;
    }

    public void cdsect(String s)
        throws IOException, IllegalArgumentException, IllegalStateException
    {
        throw new UnsupportedOperationException();
    }

    public void comment(String s)
        throws IOException, IllegalArgumentException, IllegalStateException
    {
        throw new UnsupportedOperationException();
    }

    public void docdecl(String s)
        throws IOException, IllegalArgumentException, IllegalStateException
    {
        throw new UnsupportedOperationException();
    }

    public void endDocument()
        throws IOException, IllegalArgumentException, IllegalStateException
    {
        flush();
    }

    public XmlSerializer endTag(String s, String s1)
        throws IOException, IllegalArgumentException, IllegalStateException
    {
        if (i)
        {
            a(" />\n");
        } else
        {
            a("</");
            if (s != null)
            {
                a(s);
                a(':');
            }
            a(s1);
            a(">\n");
        }
        i = false;
        return this;
    }

    public void entityRef(String s)
        throws IOException, IllegalArgumentException, IllegalStateException
    {
        throw new UnsupportedOperationException();
    }

    public void flush()
        throws IOException
    {
        if (d > 0)
        {
            if (f != null)
            {
                CharBuffer charbuffer = CharBuffer.wrap(c, 0, d);
                CoderResult coderresult = g.encode(charbuffer, h, true);
                do
                {
                    if (coderresult.isError())
                    {
                        throw new IOException(coderresult.toString());
                    }
                    if (!coderresult.isOverflow())
                    {
                        break;
                    }
                    a();
                    coderresult = g.encode(charbuffer, h, true);
                } while (true);
                a();
                f.flush();
            } else
            {
                e.write(c, 0, d);
                e.flush();
            }
            d = 0;
        }
    }

    public int getDepth()
    {
        throw new UnsupportedOperationException();
    }

    public boolean getFeature(String s)
    {
        throw new UnsupportedOperationException();
    }

    public String getName()
    {
        throw new UnsupportedOperationException();
    }

    public String getNamespace()
    {
        throw new UnsupportedOperationException();
    }

    public String getPrefix(String s, boolean flag)
        throws IllegalArgumentException
    {
        throw new UnsupportedOperationException();
    }

    public Object getProperty(String s)
    {
        throw new UnsupportedOperationException();
    }

    public void ignorableWhitespace(String s)
        throws IOException, IllegalArgumentException, IllegalStateException
    {
        throw new UnsupportedOperationException();
    }

    public void processingInstruction(String s)
        throws IOException, IllegalArgumentException, IllegalStateException
    {
        throw new UnsupportedOperationException();
    }

    public void setFeature(String s, boolean flag)
        throws IllegalArgumentException, IllegalStateException
    {
        if (s.equals("http://xmlpull.org/v1/doc/features.html#indent-output"))
        {
            return;
        } else
        {
            throw new UnsupportedOperationException();
        }
    }

    public void setOutput(OutputStream outputstream, String s)
        throws IOException, IllegalArgumentException, IllegalStateException
    {
        if (outputstream == null)
        {
            throw new IllegalArgumentException();
        }
        try
        {
            g = Charset.forName(s).newEncoder();
        }
        // Misplaced declaration of an exception variable
        catch (OutputStream outputstream)
        {
            throw (UnsupportedEncodingException)(UnsupportedEncodingException)(new UnsupportedEncodingException(s)).initCause(outputstream);
        }
        // Misplaced declaration of an exception variable
        catch (OutputStream outputstream)
        {
            throw (UnsupportedEncodingException)(UnsupportedEncodingException)(new UnsupportedEncodingException(s)).initCause(outputstream);
        }
        f = outputstream;
    }

    public void setOutput(Writer writer)
        throws IOException, IllegalArgumentException, IllegalStateException
    {
        e = writer;
    }

    public void setPrefix(String s, String s1)
        throws IOException, IllegalArgumentException, IllegalStateException
    {
        throw new UnsupportedOperationException();
    }

    public void setProperty(String s, Object obj)
        throws IllegalArgumentException, IllegalStateException
    {
        throw new UnsupportedOperationException();
    }

    public void startDocument(String s, Boolean boolean1)
        throws IOException, IllegalArgumentException, IllegalStateException
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("<?xml version='1.0' encoding='utf-8' standalone='");
        if (boolean1.booleanValue())
        {
            s = "yes";
        } else
        {
            s = "no";
        }
        a(stringbuilder.append(s).append("' ?>\n").toString());
    }

    public XmlSerializer startTag(String s, String s1)
        throws IOException, IllegalArgumentException, IllegalStateException
    {
        if (i)
        {
            a(">\n");
        }
        a('<');
        if (s != null)
        {
            a(s);
            a(':');
        }
        a(s1);
        i = true;
        return this;
    }

    public XmlSerializer text(String s)
        throws IOException, IllegalArgumentException, IllegalStateException
    {
        if (i)
        {
            a(">");
            i = false;
        }
        b(s);
        return this;
    }

    public XmlSerializer text(char ac[], int j, int k)
        throws IOException, IllegalArgumentException, IllegalStateException
    {
        if (i)
        {
            a(">");
            i = false;
        }
        b(ac, j, k);
        return this;
    }

}
