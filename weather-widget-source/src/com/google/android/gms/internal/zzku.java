// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzw;

// Referenced classes of package com.google.android.gms.internal:
//            zzlf

public final class zzku extends zzlf
{
    public static final class zza
    {

        public final int zzacA;
        public final int zzacz;

        public boolean equals(Object obj)
        {
            boolean flag1 = true;
            if (obj instanceof zza) goto _L2; else goto _L1
_L1:
            boolean flag = false;
_L4:
            return flag;
_L2:
            flag = flag1;
            if (this == obj) goto _L4; else goto _L3
_L3:
            obj = (zza)obj;
            if (((zza) (obj)).zzacz != zzacz)
            {
                break; /* Loop/switch isn't completed */
            }
            flag = flag1;
            if (((zza) (obj)).zzacA == zzacA) goto _L4; else goto _L5
_L5:
            return false;
        }

        public int hashCode()
        {
            return zzw.hashCode(new Object[] {
                Integer.valueOf(zzacz), Integer.valueOf(zzacA)
            });
        }

        public zza(int i, int j)
        {
            zzacz = i;
            zzacA = j;
        }
    }


    public zzku()
    {
        super(10);
    }
}
