// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.os.Build;
import com.flurry.android.FlurryAgent;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.DigestOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.flurry.sdk:
//            ed, dr, eo, fe, 
//            dh

public class dc
{

    private static final String a = com/flurry/sdk/dc.getSimpleName();
    private byte b[];

    public dc(String s, String s1, boolean flag, boolean flag1, long l, long l1, List list, Map map, Map map1, Map map2, Map map3, long l2)
        throws IOException
    {
        Object obj;
        b = null;
        obj = null;
        DataOutputStream dataoutputstream;
        ed ed1;
        ByteArrayOutputStream bytearrayoutputstream;
        DigestOutputStream digestoutputstream;
        ed1 = new ed();
        bytearrayoutputstream = new ByteArrayOutputStream();
        digestoutputstream = new DigestOutputStream(bytearrayoutputstream, ed1);
        dataoutputstream = new DataOutputStream(digestoutputstream);
        dataoutputstream.writeShort(29);
        dataoutputstream.writeShort(0);
        dataoutputstream.writeLong(0L);
        dataoutputstream.writeShort(0);
        dataoutputstream.writeShort(3);
        dataoutputstream.writeShort(FlurryAgent.getAgentVersion());
        dataoutputstream.writeLong(l2);
        dataoutputstream.writeUTF(s);
        dataoutputstream.writeUTF(s1);
        dataoutputstream.writeShort(map.size());
        for (s = map.entrySet().iterator(); s.hasNext(); dataoutputstream.write(s1))
        {
            s1 = (java.util.Map.Entry)s.next();
            dataoutputstream.writeShort(((dr)s1.getKey()).d);
            s1 = ((ByteBuffer)s1.getValue()).array();
            dataoutputstream.writeShort(s1.length);
        }

          goto _L1
        s1;
        s = dataoutputstream;
_L23:
        eo.a(6, a, "Error when generating report", s1);
        fe.a(s);
        s = null;
_L21:
        b = s;
        return;
_L1:
        dataoutputstream.writeByte(0);
        dataoutputstream.writeBoolean(flag);
        dataoutputstream.writeBoolean(flag1);
        dataoutputstream.writeLong(l);
        dataoutputstream.writeLong(l1);
        dataoutputstream.writeShort(6);
        dataoutputstream.writeUTF("device.model");
        dataoutputstream.writeUTF(Build.MODEL);
        dataoutputstream.writeByte(0);
        dataoutputstream.writeUTF("build.brand");
        dataoutputstream.writeUTF(Build.BRAND);
        dataoutputstream.writeByte(0);
        dataoutputstream.writeUTF("build.id");
        dataoutputstream.writeUTF(Build.ID);
        dataoutputstream.writeByte(0);
        dataoutputstream.writeUTF("version.release");
        dataoutputstream.writeUTF(android.os.Build.VERSION.RELEASE);
        dataoutputstream.writeByte(0);
        dataoutputstream.writeUTF("build.device");
        dataoutputstream.writeUTF(Build.DEVICE);
        dataoutputstream.writeByte(0);
        dataoutputstream.writeUTF("build.product");
        dataoutputstream.writeUTF(Build.PRODUCT);
        dataoutputstream.writeByte(0);
        if (map1 == null) goto _L3; else goto _L2
_L2:
        int i = map1.keySet().size();
_L6:
        dataoutputstream.writeShort(i);
        if (map1 == null) goto _L5; else goto _L4
_L4:
        eo.a(3, a, "sending referrer values because it exists");
        for (s = map1.entrySet().iterator(); s.hasNext();)
        {
            s1 = (java.util.Map.Entry)s.next();
            eo.a(3, a, (new StringBuilder("Referrer Entry:  ")).append((String)s1.getKey()).append("=").append(s1.getValue()).toString());
            dataoutputstream.writeUTF((String)s1.getKey());
            eo.a(3, a, (new StringBuilder("referrer key is :")).append((String)s1.getKey()).toString());
            dataoutputstream.writeShort(((List)s1.getValue()).size());
            s1 = ((List)s1.getValue()).iterator();
            while (s1.hasNext()) 
            {
                map = (String)s1.next();
                dataoutputstream.writeUTF(map);
                eo.a(3, a, (new StringBuilder("referrer value is :")).append(map).toString());
            }
        }

          goto _L5
        s;
        s1 = dataoutputstream;
_L22:
        fe.a(s1);
        throw s;
_L3:
        i = 0;
          goto _L6
_L5:
        dataoutputstream.writeBoolean(false);
        if (map2 == null) goto _L8; else goto _L7
_L7:
        i = map2.keySet().size();
_L24:
        eo.a(3, a, (new StringBuilder("optionsMapSize is:  ")).append(i).toString());
        dataoutputstream.writeShort(i);
        if (map2 == null)
        {
            break MISSING_BLOCK_LABEL_896;
        }
        eo.a(3, a, "sending launch options");
        for (s = map2.entrySet().iterator(); s.hasNext();)
        {
            s1 = (java.util.Map.Entry)s.next();
            eo.a(3, a, (new StringBuilder("Launch Options Key:  ")).append((String)s1.getKey()).toString());
            dataoutputstream.writeUTF((String)s1.getKey());
            dataoutputstream.writeShort(((List)s1.getValue()).size());
            s1 = ((List)s1.getValue()).iterator();
            while (s1.hasNext()) 
            {
                map = (String)s1.next();
                dataoutputstream.writeUTF(map);
                eo.a(3, a, (new StringBuilder("Launch Options value is :")).append(map).toString());
            }
        }

        if (map3 == null) goto _L10; else goto _L9
_L9:
        int j = map3.keySet().size();
_L25:
        eo.a(3, a, (new StringBuilder("numOriginAttributions is:  ")).append(i).toString());
        dataoutputstream.writeShort(j);
        if (map3 == null) goto _L12; else goto _L11
_L11:
        s1 = map3.entrySet().iterator();
_L15:
        if (!s1.hasNext()) goto _L12; else goto _L13
_L13:
        map = (java.util.Map.Entry)s1.next();
        eo.a(3, a, (new StringBuilder("Origin Atttribute Key:  ")).append((String)map.getKey()).toString());
        dataoutputstream.writeUTF((String)map.getKey());
        dataoutputstream.writeShort(((Map)map.getValue()).size());
        eo.a(3, a, (new StringBuilder("Origin Attribute Map Size for ")).append((String)map.getKey()).append(":  ").append(((Map)map.getValue()).size()).toString());
        map1 = ((Map)map.getValue()).entrySet().iterator();
_L18:
        if (!map1.hasNext()) goto _L15; else goto _L14
_L14:
        map2 = (java.util.Map.Entry)map1.next();
        eo.a(3, a, (new StringBuilder("Origin Atttribute for ")).append((String)map.getKey()).append(":  ").append((String)map2.getKey()).append(":").append((String)map2.getValue()).toString());
        if (map2.getKey() == null) goto _L17; else goto _L16
_L16:
        s = (String)map2.getKey();
_L26:
        dataoutputstream.writeUTF(s);
        if (map2.getValue() == null)
        {
            break MISSING_BLOCK_LABEL_1412;
        }
        s = (String)map2.getValue();
_L27:
        dataoutputstream.writeUTF(s);
          goto _L18
_L12:
        j = list.size();
        dataoutputstream.writeShort(j);
        i = 0;
_L20:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        dataoutputstream.write(((dh)list.get(i)).a());
        i++;
        if (true) goto _L20; else goto _L19
_L19:
        dataoutputstream.writeShort(0);
        digestoutputstream.on(false);
        dataoutputstream.write(ed1.a());
        dataoutputstream.close();
        s = bytearrayoutputstream.toByteArray();
        fe.a(dataoutputstream);
          goto _L21
        s;
        s1 = null;
          goto _L22
        list;
        s1 = s;
        s = list;
          goto _L22
        s1;
        s = obj;
          goto _L23
_L8:
        i = 0;
          goto _L24
_L10:
        j = 0;
          goto _L25
_L17:
        s = "";
          goto _L26
        s = "";
          goto _L27
    }

    public byte[] a()
    {
        return b;
    }

}
