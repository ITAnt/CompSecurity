// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            mb, md, ma, lz, 
//            mi, mf

public interface d
{
    public static final class a extends mb
    {

        private static volatile a fM[];
        public String fN;
        public a fO[];
        public a fP[];
        public a fQ[];
        public String fR;
        public String fS;
        public long fT;
        public boolean fU;
        public a fV[];
        public int fW[];
        public boolean fX;
        public int type;

        public static a[] r()
        {
            if (fM == null)
            {
                synchronized (md.amX)
                {
                    if (fM == null)
                    {
                        fM = new a[0];
                    }
                }
            }
            return fM;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void a(ma ma1)
            throws IOException
        {
            boolean flag = false;
            ma1.p(1, type);
            if (!fN.equals(""))
            {
                ma1.b(2, fN);
            }
            if (fO != null && fO.length > 0)
            {
                for (int i = 0; i < fO.length; i++)
                {
                    a a1 = fO[i];
                    if (a1 != null)
                    {
                        ma1.a(3, a1);
                    }
                }

            }
            if (fP != null && fP.length > 0)
            {
                for (int j = 0; j < fP.length; j++)
                {
                    a a2 = fP[j];
                    if (a2 != null)
                    {
                        ma1.a(4, a2);
                    }
                }

            }
            if (fQ != null && fQ.length > 0)
            {
                for (int k = 0; k < fQ.length; k++)
                {
                    a a3 = fQ[k];
                    if (a3 != null)
                    {
                        ma1.a(5, a3);
                    }
                }

            }
            if (!fR.equals(""))
            {
                ma1.b(6, fR);
            }
            if (!fS.equals(""))
            {
                ma1.b(7, fS);
            }
            if (fT != 0L)
            {
                ma1.b(8, fT);
            }
            if (fX)
            {
                ma1.a(9, fX);
            }
            if (fW != null && fW.length > 0)
            {
                for (int i1 = 0; i1 < fW.length; i1++)
                {
                    ma1.p(10, fW[i1]);
                }

            }
            if (fV != null && fV.length > 0)
            {
                for (int j1 = ((flag) ? 1 : 0); j1 < fV.length; j1++)
                {
                    a a4 = fV[j1];
                    if (a4 != null)
                    {
                        ma1.a(11, a4);
                    }
                }

            }
            if (fU)
            {
                ma1.a(12, fU);
            }
            super.a(ma1);
        }

        public mf b(lz lz1)
            throws IOException
        {
            return l(lz1);
        }

        protected int c()
        {
            boolean flag = false;
            int j = super.c() + ma.r(1, type);
            int i = j;
            if (!fN.equals(""))
            {
                i = j + ma.h(2, fN);
            }
            j = i;
            if (fO != null)
            {
                j = i;
                if (fO.length > 0)
                {
                    for (j = 0; j < fO.length;)
                    {
                        a a1 = fO[j];
                        int k = i;
                        if (a1 != null)
                        {
                            k = i + ma.b(3, a1);
                        }
                        j++;
                        i = k;
                    }

                    j = i;
                }
            }
            i = j;
            if (fP != null)
            {
                i = j;
                if (fP.length > 0)
                {
                    i = j;
                    for (j = 0; j < fP.length;)
                    {
                        a a2 = fP[j];
                        int i1 = i;
                        if (a2 != null)
                        {
                            i1 = i + ma.b(4, a2);
                        }
                        j++;
                        i = i1;
                    }

                }
            }
            j = i;
            if (fQ != null)
            {
                j = i;
                if (fQ.length > 0)
                {
                    for (j = 0; j < fQ.length;)
                    {
                        a a3 = fQ[j];
                        int j1 = i;
                        if (a3 != null)
                        {
                            j1 = i + ma.b(5, a3);
                        }
                        j++;
                        i = j1;
                    }

                    j = i;
                }
            }
            i = j;
            if (!fR.equals(""))
            {
                i = j + ma.h(6, fR);
            }
            j = i;
            if (!fS.equals(""))
            {
                j = i + ma.h(7, fS);
            }
            i = j;
            if (fT != 0L)
            {
                i = j + ma.d(8, fT);
            }
            j = i;
            if (fX)
            {
                j = i + ma.b(9, fX);
            }
            i = j;
            if (fW != null)
            {
                i = j;
                if (fW.length > 0)
                {
                    i = 0;
                    int k1 = 0;
                    for (; i < fW.length; i++)
                    {
                        k1 += ma.eE(fW[i]);
                    }

                    i = j + k1 + fW.length * 1;
                }
            }
            j = i;
            if (fV != null)
            {
                j = i;
                if (fV.length > 0)
                {
                    int l1 = ((flag) ? 1 : 0);
                    do
                    {
                        j = i;
                        if (l1 >= fV.length)
                        {
                            break;
                        }
                        a a4 = fV[l1];
                        j = i;
                        if (a4 != null)
                        {
                            j = i + ma.b(11, a4);
                        }
                        l1++;
                        i = j;
                    } while (true);
                }
            }
            i = j;
            if (fU)
            {
                i = j + ma.b(12, fU);
            }
            return i;
        }

        public boolean equals(Object obj)
        {
            boolean flag1 = false;
            if (obj != this) goto _L2; else goto _L1
_L1:
            boolean flag = true;
_L4:
            return flag;
_L2:
            flag = flag1;
            if (!(obj instanceof a)) goto _L4; else goto _L3
_L3:
            obj = (a)obj;
            flag = flag1;
            if (type != ((a) (obj)).type) goto _L4; else goto _L5
_L5:
            if (fN != null) goto _L7; else goto _L6
_L6:
            flag = flag1;
            if (((a) (obj)).fN != null) goto _L4; else goto _L8
_L8:
            flag = flag1;
            if (!md.equals(fO, ((a) (obj)).fO)) goto _L4; else goto _L9
_L9:
            flag = flag1;
            if (!md.equals(fP, ((a) (obj)).fP)) goto _L4; else goto _L10
_L10:
            flag = flag1;
            if (!md.equals(fQ, ((a) (obj)).fQ)) goto _L4; else goto _L11
_L11:
            if (fR != null) goto _L13; else goto _L12
_L12:
            flag = flag1;
            if (((a) (obj)).fR != null) goto _L4; else goto _L14
_L14:
            if (fS != null) goto _L16; else goto _L15
_L15:
            flag = flag1;
            if (((a) (obj)).fS != null) goto _L4; else goto _L17
_L17:
            flag = flag1;
            if (fT != ((a) (obj)).fT) goto _L4; else goto _L18
_L18:
            flag = flag1;
            if (fU != ((a) (obj)).fU) goto _L4; else goto _L19
_L19:
            flag = flag1;
            if (!md.equals(fV, ((a) (obj)).fV)) goto _L4; else goto _L20
_L20:
            flag = flag1;
            if (!md.equals(fW, ((a) (obj)).fW)) goto _L4; else goto _L21
_L21:
            flag = flag1;
            if (fX != ((a) (obj)).fX) goto _L4; else goto _L22
_L22:
            if (amU != null && !amU.isEmpty())
            {
                break MISSING_BLOCK_LABEL_296;
            }
            if (((a) (obj)).amU == null)
            {
                break; /* Loop/switch isn't completed */
            }
            flag = flag1;
            if (!((a) (obj)).amU.isEmpty()) goto _L4; else goto _L23
_L23:
            return true;
_L7:
            if (!fN.equals(((a) (obj)).fN))
            {
                return false;
            }
              goto _L8
_L13:
            if (!fR.equals(((a) (obj)).fR))
            {
                return false;
            }
              goto _L14
_L16:
            if (!fS.equals(((a) (obj)).fS))
            {
                return false;
            }
              goto _L17
            return amU.equals(((a) (obj)).amU);
              goto _L8
        }

        public int hashCode()
        {
            char c2 = '\u04CF';
            boolean flag = false;
            int j1 = type;
            int i;
            int j;
            int k;
            char c1;
            int i1;
            int k1;
            int l1;
            int i2;
            int j2;
            int k2;
            int l2;
            if (fN == null)
            {
                i = 0;
            } else
            {
                i = fN.hashCode();
            }
            k1 = md.hashCode(fO);
            l1 = md.hashCode(fP);
            i2 = md.hashCode(fQ);
            if (fR == null)
            {
                j = 0;
            } else
            {
                j = fR.hashCode();
            }
            if (fS == null)
            {
                k = 0;
            } else
            {
                k = fS.hashCode();
            }
            j2 = (int)(fT ^ fT >>> 32);
            if (fU)
            {
                c1 = '\u04CF';
            } else
            {
                c1 = '\u04D5';
            }
            k2 = md.hashCode(fV);
            l2 = md.hashCode(fW);
            if (!fX)
            {
                c2 = '\u04D5';
            }
            i1 = ((flag) ? 1 : 0);
            if (amU != null)
            {
                if (amU.isEmpty())
                {
                    i1 = ((flag) ? 1 : 0);
                } else
                {
                    i1 = amU.hashCode();
                }
            }
            return ((((c1 + ((k + (j + ((((i + (j1 + 527) * 31) * 31 + k1) * 31 + l1) * 31 + i2) * 31) * 31) * 31 + j2) * 31) * 31 + k2) * 31 + l2) * 31 + c2) * 31 + i1;
        }

        public a l(lz lz1)
            throws IOException
        {
_L16:
            int i = lz1.nw();
            i;
            JVM INSTR lookupswitch 14: default 132
        //                       0: 142
        //                       8: 144
        //                       18: 212
        //                       26: 223
        //                       34: 354
        //                       42: 485
        //                       50: 616
        //                       58: 627
        //                       64: 638
        //                       72: 649
        //                       80: 660
        //                       82: 904
        //                       90: 1222
        //                       96: 1353;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L1:
            if (a(lz1, i)) goto _L16; else goto _L2
_L2:
            return this;
_L3:
            i = lz1.nz();
            switch (i)
            {
            case 1: // '\001'
            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
            case 6: // '\006'
            case 7: // '\007'
            case 8: // '\b'
                type = i;
                break;
            }
            continue; /* Loop/switch isn't completed */
_L4:
            fN = lz1.readString();
            continue; /* Loop/switch isn't completed */
_L5:
            int k = mi.b(lz1, 26);
            a aa[];
            if (fO == null)
            {
                i = 0;
            } else
            {
                i = fO.length;
            }
            aa = new a[k + i];
            k = i;
            if (i != 0)
            {
                System.arraycopy(fO, 0, aa, 0, i);
                k = i;
            }
            for (; k < aa.length - 1; k++)
            {
                aa[k] = new a();
                lz1.a(aa[k]);
                lz1.nw();
            }

            aa[k] = new a();
            lz1.a(aa[k]);
            fO = aa;
            continue; /* Loop/switch isn't completed */
_L6:
            int i1 = mi.b(lz1, 34);
            a aa1[];
            if (fP == null)
            {
                i = 0;
            } else
            {
                i = fP.length;
            }
            aa1 = new a[i1 + i];
            i1 = i;
            if (i != 0)
            {
                System.arraycopy(fP, 0, aa1, 0, i);
                i1 = i;
            }
            for (; i1 < aa1.length - 1; i1++)
            {
                aa1[i1] = new a();
                lz1.a(aa1[i1]);
                lz1.nw();
            }

            aa1[i1] = new a();
            lz1.a(aa1[i1]);
            fP = aa1;
            continue; /* Loop/switch isn't completed */
_L7:
            int j1 = mi.b(lz1, 42);
            a aa2[];
            if (fQ == null)
            {
                i = 0;
            } else
            {
                i = fQ.length;
            }
            aa2 = new a[j1 + i];
            j1 = i;
            if (i != 0)
            {
                System.arraycopy(fQ, 0, aa2, 0, i);
                j1 = i;
            }
            for (; j1 < aa2.length - 1; j1++)
            {
                aa2[j1] = new a();
                lz1.a(aa2[j1]);
                lz1.nw();
            }

            aa2[j1] = new a();
            lz1.a(aa2[j1]);
            fQ = aa2;
            continue; /* Loop/switch isn't completed */
_L8:
            fR = lz1.readString();
            continue; /* Loop/switch isn't completed */
_L9:
            fS = lz1.readString();
            continue; /* Loop/switch isn't completed */
_L10:
            fT = lz1.ny();
            continue; /* Loop/switch isn't completed */
_L11:
            fX = lz1.nA();
            continue; /* Loop/switch isn't completed */
_L12:
            int ai[];
            int k1;
            int k2;
            k2 = mi.b(lz1, 80);
            ai = new int[k2];
            k1 = 0;
            i = 0;
_L22:
            if (k1 >= k2) goto _L18; else goto _L17
_L17:
            int l2;
            if (k1 != 0)
            {
                lz1.nw();
            }
            l2 = lz1.nz();
            l2;
            JVM INSTR tableswitch 1 17: default 788
        //                       1 797
        //                       2 797
        //                       3 797
        //                       4 797
        //                       5 797
        //                       6 797
        //                       7 797
        //                       8 797
        //                       9 797
        //                       10 797
        //                       11 797
        //                       12 797
        //                       13 797
        //                       14 797
        //                       15 797
        //                       16 797
        //                       17 797;
               goto _L19 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20
_L19:
            k1++;
            continue; /* Loop/switch isn't completed */
_L20:
            int i2 = i + 1;
            ai[i] = l2;
            i = i2;
            if (true) goto _L19; else goto _L18
_L18:
            if (i != 0)
            {
                if (fW == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = fW.length;
                }
                if (k1 == 0 && i == ai.length)
                {
                    fW = ai;
                } else
                {
                    int ai1[] = new int[k1 + i];
                    if (k1 != 0)
                    {
                        System.arraycopy(fW, 0, ai1, 0, k1);
                    }
                    System.arraycopy(ai, 0, ai1, k1, i);
                    fW = ai1;
                }
            }
            continue; /* Loop/switch isn't completed */
            if (true) goto _L22; else goto _L21
_L21:
_L13:
            int j2;
            j2 = lz1.ex(lz1.nD());
            i = lz1.getPosition();
            k1 = 0;
_L28:
            if (lz1.nI() > 0)
            {
                switch (lz1.nz())
                {
                case 1: // '\001'
                case 2: // '\002'
                case 3: // '\003'
                case 4: // '\004'
                case 5: // '\005'
                case 6: // '\006'
                case 7: // '\007'
                case 8: // '\b'
                case 9: // '\t'
                case 10: // '\n'
                case 11: // '\013'
                case 12: // '\f'
                case 13: // '\r'
                case 14: // '\016'
                case 15: // '\017'
                case 16: // '\020'
                case 17: // '\021'
                    k1++;
                    break;
                }
                continue; /* Loop/switch isn't completed */
            }
            if (k1 == 0) goto _L24; else goto _L23
_L23:
            lz1.ez(i);
            if (fW == null)
            {
                i = 0;
            } else
            {
                i = fW.length;
            }
            ai = new int[k1 + i];
            k1 = i;
            if (i != 0)
            {
                System.arraycopy(fW, 0, ai, 0, i);
                k1 = i;
            }
_L26:
            if (lz1.nI() > 0)
            {
                i = lz1.nz();
                switch (i)
                {
                case 1: // '\001'
                case 2: // '\002'
                case 3: // '\003'
                case 4: // '\004'
                case 5: // '\005'
                case 6: // '\006'
                case 7: // '\007'
                case 8: // '\b'
                case 9: // '\t'
                case 10: // '\n'
                case 11: // '\013'
                case 12: // '\f'
                case 13: // '\r'
                case 14: // '\016'
                case 15: // '\017'
                case 16: // '\020'
                case 17: // '\021'
                    ai[k1] = i;
                    k1++;
                    break;
                }
                continue; /* Loop/switch isn't completed */
            }
            fW = ai;
_L24:
            lz1.ey(j2);
            continue; /* Loop/switch isn't completed */
            if (true) goto _L26; else goto _L25
_L25:
            if (true) goto _L28; else goto _L27
_L27:
_L14:
            int l1 = mi.b(lz1, 90);
            a aa3[];
            int j;
            if (fV == null)
            {
                j = 0;
            } else
            {
                j = fV.length;
            }
            aa3 = new a[l1 + j];
            l1 = j;
            if (j != 0)
            {
                System.arraycopy(fV, 0, aa3, 0, j);
                l1 = j;
            }
            for (; l1 < aa3.length - 1; l1++)
            {
                aa3[l1] = new a();
                lz1.a(aa3[l1]);
                lz1.nw();
            }

            aa3[l1] = new a();
            lz1.a(aa3[l1]);
            fV = aa3;
            continue; /* Loop/switch isn't completed */
_L15:
            fU = lz1.nA();
            if (true) goto _L16; else goto _L29
_L29:
        }

        public a s()
        {
            type = 1;
            fN = "";
            fO = r();
            fP = r();
            fQ = r();
            fR = "";
            fS = "";
            fT = 0L;
            fU = false;
            fV = r();
            fW = mi.ana;
            fX = false;
            amU = null;
            amY = -1;
            return this;
        }

        public a()
        {
            s();
        }
    }

}
