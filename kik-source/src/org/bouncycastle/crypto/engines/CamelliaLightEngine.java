// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.params.KeyParameter;

public class CamelliaLightEngine
    implements BlockCipher
{

    private static final int g[] = {
        0xa09e667f, 0x3bcc908b, 0xb67ae858, 0x4caa73b2, 0xc6ef372f, 0xe94f82be, 0x54ff53a5, 0xf1d36f1c, 0x10e527fa, 0xde682d1d, 
        0xb05688c2, 0xb3e6c1fd
    };
    private static final byte h[] = {
        112, -126, 44, -20, -77, 39, -64, -27, -28, -123, 
        87, 53, -22, 12, -82, 65, 35, -17, 107, -109, 
        69, 25, -91, 33, -19, 14, 79, 78, 29, 101, 
        -110, -67, -122, -72, -81, -113, 124, -21, 31, -50, 
        62, 48, -36, 95, 94, -59, 11, 26, -90, -31, 
        57, -54, -43, 71, 93, 61, -39, 1, 90, -42, 
        81, 86, 108, 77, -117, 13, -102, 102, -5, -52, 
        -80, 45, 116, 18, 43, 32, -16, -79, -124, -103, 
        -33, 76, -53, -62, 52, 126, 118, 5, 109, -73, 
        -87, 49, -47, 23, 4, -41, 20, 88, 58, 97, 
        -34, 27, 17, 28, 50, 15, -100, 22, 83, 24, 
        -14, 34, -2, 68, -49, -78, -61, -75, 122, -111, 
        36, 8, -24, -88, 96, -4, 105, 80, -86, -48, 
        -96, 125, -95, -119, 98, -105, 84, 91, 30, -107, 
        -32, -1, 100, -46, 16, -60, 0, 72, -93, -9, 
        117, -37, -118, 3, -26, -38, 9, 63, -35, -108, 
        -121, 92, -125, 2, -51, 74, -112, 51, 115, 103, 
        -10, -13, -99, 127, -65, -30, 82, -101, -40, 38, 
        -56, 55, -58, 59, -127, -106, 111, 75, 19, -66, 
        99, 46, -23, 121, -89, -116, -97, 110, -68, -114, 
        41, -11, -7, -74, 47, -3, -76, 89, 120, -104, 
        6, 106, -25, 70, 113, -70, -44, 37, -85, 66, 
        -120, -94, -115, -6, 114, 7, -71, 85, -8, -18, 
        -84, 10, 54, 73, 42, 104, 60, 56, -15, -92, 
        64, 40, -45, 123, -69, -55, 67, -63, 21, -29, 
        -83, -12, 119, -57, -128, -98
    };
    private boolean a;
    private boolean b;
    private int c[];
    private int d[];
    private int e[];
    private int f[];

    public CamelliaLightEngine()
    {
        c = new int[96];
        d = new int[8];
        e = new int[12];
        f = new int[4];
    }

    private int bytes2int(byte abyte0[], int i)
    {
        int j = 0;
        int k = 0;
        for (; j < 4; j++)
        {
            k = (k << 8) + (abyte0[j + i] & 0xff);
        }

        return k;
    }

    private void camelliaF2(int ai[], int ai1[], int i)
    {
        int i1 = ai[0] ^ ai1[i + 0];
        int j = sbox4(i1 & 0xff);
        int k = sbox3(i1 >>> 8 & 0xff);
        int l = sbox2(i1 >>> 16 & 0xff);
        i1 = h[i1 >>> 24 & 0xff];
        int j1 = ai[1] ^ ai1[i + 1];
        int k1 = h[j1 & 0xff];
        int l1 = sbox4(j1 >>> 8 & 0xff);
        int i2 = sbox3(j1 >>> 16 & 0xff);
        j1 = leftRotate(sbox2(j1 >>> 24 & 0xff) << 24 | (k1 & 0xff | l1 << 8 | i2 << 16), 8);
        k = ((i1 & 0xff) << 24 | (j | k << 8 | l << 16)) ^ j1;
        j = leftRotate(j1, 8) ^ k;
        k = rightRotate(k, 8) ^ j;
        l = ai[2];
        ai[2] = leftRotate(j, 16) ^ k ^ l;
        j = ai[3];
        ai[3] = leftRotate(k, 8) ^ j;
        i1 = ai[2] ^ ai1[i + 2];
        j = sbox4(i1 & 0xff);
        k = sbox3(i1 >>> 8 & 0xff);
        l = sbox2(i1 >>> 16 & 0xff);
        i1 = h[i1 >>> 24 & 0xff];
        i = ai[3] ^ ai1[i + 3];
        j1 = h[i & 0xff];
        k1 = sbox4(i >>> 8 & 0xff);
        l1 = sbox3(i >>> 16 & 0xff);
        i = leftRotate(sbox2(i >>> 24 & 0xff) << 24 | (j1 & 0xff | k1 << 8 | l1 << 16), 8);
        j = ((i1 & 0xff) << 24 | (j | k << 8 | l << 16)) ^ i;
        i = leftRotate(i, 8) ^ j;
        j = rightRotate(j, 8) ^ i;
        k = ai[0];
        ai[0] = leftRotate(i, 16) ^ j ^ k;
        i = ai[1];
        ai[1] = leftRotate(j, 8) ^ i;
    }

    private void camelliaFLs(int ai[], int ai1[], int i)
    {
        ai[1] = ai[1] ^ leftRotate(ai[0] & ai1[i + 0], 1);
        ai[0] = ai[0] ^ (ai1[i + 1] | ai[1]);
        ai[2] = ai[2] ^ (ai1[i + 3] | ai[3]);
        ai[3] = ai[3] ^ leftRotate(ai1[i + 2] & ai[2], 1);
    }

    private static void decroldq(int i, int ai[], int j, int ai1[], int k)
    {
        ai1[k + 2] = ai[j + 0] << i | ai[j + 1] >>> 32 - i;
        ai1[k + 3] = ai[j + 1] << i | ai[j + 2] >>> 32 - i;
        ai1[k + 0] = ai[j + 2] << i | ai[j + 3] >>> 32 - i;
        ai1[k + 1] = ai[j + 3] << i | ai[j + 0] >>> 32 - i;
        ai[j + 0] = ai1[k + 2];
        ai[j + 1] = ai1[k + 3];
        ai[j + 2] = ai1[k + 0];
        ai[j + 3] = ai1[k + 1];
    }

    private static void decroldqo32(int i, int ai[], int j, int ai1[], int k)
    {
        ai1[k + 2] = ai[j + 1] << i - 32 | ai[j + 2] >>> 64 - i;
        ai1[k + 3] = ai[j + 2] << i - 32 | ai[j + 3] >>> 64 - i;
        ai1[k + 0] = ai[j + 3] << i - 32 | ai[j + 0] >>> 64 - i;
        ai1[k + 1] = ai[j + 0] << i - 32 | ai[j + 1] >>> 64 - i;
        ai[j + 0] = ai1[k + 2];
        ai[j + 1] = ai1[k + 3];
        ai[j + 2] = ai1[k + 0];
        ai[j + 3] = ai1[k + 1];
    }

    private void int2bytes(int i, byte abyte0[], int j)
    {
        boolean flag = false;
        int k = i;
        for (i = ((flag) ? 1 : 0); i < 4; i++)
        {
            abyte0[(3 - i) + j] = (byte)k;
            k >>>= 8;
        }

    }

    private byte lRot8(byte byte0, int i)
    {
        return (byte)(byte0 << i | (byte0 & 0xff) >>> 8 - i);
    }

    private static int leftRotate(int i, int j)
    {
        return (i << j) + (i >>> 32 - j);
    }

    private int processBlock128(byte abyte0[], int i, byte abyte1[], int j)
    {
        for (int k = 0; k < 4; k++)
        {
            f[k] = bytes2int(abyte0, k * 4 + i);
            int ai[] = f;
            ai[k] = ai[k] ^ d[k];
        }

        camelliaF2(f, c, 0);
        camelliaF2(f, c, 4);
        camelliaF2(f, c, 8);
        camelliaFLs(f, e, 0);
        camelliaF2(f, c, 12);
        camelliaF2(f, c, 16);
        camelliaF2(f, c, 20);
        camelliaFLs(f, e, 4);
        camelliaF2(f, c, 24);
        camelliaF2(f, c, 28);
        camelliaF2(f, c, 32);
        abyte0 = f;
        abyte0[2] = abyte0[2] ^ d[4];
        abyte0 = f;
        abyte0[3] = abyte0[3] ^ d[5];
        abyte0 = f;
        abyte0[0] = abyte0[0] ^ d[6];
        abyte0 = f;
        abyte0[1] = abyte0[1] ^ d[7];
        int2bytes(f[2], abyte1, j);
        int2bytes(f[3], abyte1, j + 4);
        int2bytes(f[0], abyte1, j + 8);
        int2bytes(f[1], abyte1, j + 12);
        return 16;
    }

    private int processBlock192or256(byte abyte0[], int i, byte abyte1[], int j)
    {
        for (int k = 0; k < 4; k++)
        {
            f[k] = bytes2int(abyte0, k * 4 + i);
            int ai[] = f;
            ai[k] = ai[k] ^ d[k];
        }

        camelliaF2(f, c, 0);
        camelliaF2(f, c, 4);
        camelliaF2(f, c, 8);
        camelliaFLs(f, e, 0);
        camelliaF2(f, c, 12);
        camelliaF2(f, c, 16);
        camelliaF2(f, c, 20);
        camelliaFLs(f, e, 4);
        camelliaF2(f, c, 24);
        camelliaF2(f, c, 28);
        camelliaF2(f, c, 32);
        camelliaFLs(f, e, 8);
        camelliaF2(f, c, 36);
        camelliaF2(f, c, 40);
        camelliaF2(f, c, 44);
        abyte0 = f;
        abyte0[2] = abyte0[2] ^ d[4];
        abyte0 = f;
        abyte0[3] = abyte0[3] ^ d[5];
        abyte0 = f;
        abyte0[0] = abyte0[0] ^ d[6];
        abyte0 = f;
        abyte0[1] = abyte0[1] ^ d[7];
        int2bytes(f[2], abyte1, j);
        int2bytes(f[3], abyte1, j + 4);
        int2bytes(f[0], abyte1, j + 8);
        int2bytes(f[1], abyte1, j + 12);
        return 16;
    }

    private static int rightRotate(int i, int j)
    {
        return (i >>> j) + (i << 32 - j);
    }

    private static void roldq(int i, int ai[], int j, int ai1[], int k)
    {
        ai1[k + 0] = ai[j + 0] << i | ai[j + 1] >>> 32 - i;
        ai1[k + 1] = ai[j + 1] << i | ai[j + 2] >>> 32 - i;
        ai1[k + 2] = ai[j + 2] << i | ai[j + 3] >>> 32 - i;
        ai1[k + 3] = ai[j + 3] << i | ai[j + 0] >>> 32 - i;
        ai[j + 0] = ai1[k + 0];
        ai[j + 1] = ai1[k + 1];
        ai[j + 2] = ai1[k + 2];
        ai[j + 3] = ai1[k + 3];
    }

    private static void roldqo32(int i, int ai[], int j, int ai1[], int k)
    {
        ai1[k + 0] = ai[j + 1] << i - 32 | ai[j + 2] >>> 64 - i;
        ai1[k + 1] = ai[j + 2] << i - 32 | ai[j + 3] >>> 64 - i;
        ai1[k + 2] = ai[j + 3] << i - 32 | ai[j + 0] >>> 64 - i;
        ai1[k + 3] = ai[j + 0] << i - 32 | ai[j + 1] >>> 64 - i;
        ai[j + 0] = ai1[k + 0];
        ai[j + 1] = ai1[k + 1];
        ai[j + 2] = ai1[k + 2];
        ai[j + 3] = ai1[k + 3];
    }

    private int sbox2(int i)
    {
        return lRot8(h[i], 1) & 0xff;
    }

    private int sbox3(int i)
    {
        return lRot8(h[i], 7) & 0xff;
    }

    private int sbox4(int i)
    {
        return h[lRot8((byte)i, 1) & 0xff] & 0xff;
    }

    private void setKey(boolean flag, byte abyte0[])
    {
        int ai[];
        int ai1[];
        int ai2[];
        int ai3[];
        ai = new int[8];
        ai1 = new int[4];
        ai2 = new int[4];
        ai3 = new int[4];
        abyte0.length;
        JVM INSTR lookupswitch 3: default 56
    //                   16: 67
    //                   24: 162
    //                   32: 246;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new IllegalArgumentException("key sizes are only 16/24/32 bytes.");
_L2:
        b = true;
        ai[0] = bytes2int(abyte0, 0);
        ai[1] = bytes2int(abyte0, 4);
        ai[2] = bytes2int(abyte0, 8);
        ai[3] = bytes2int(abyte0, 12);
        ai[7] = 0;
        ai[6] = 0;
        ai[5] = 0;
        ai[4] = 0;
_L6:
        for (int i = 0; i < 4; i++)
        {
            ai1[i] = ai[i] ^ ai[i + 4];
        }

        break; /* Loop/switch isn't completed */
_L3:
        ai[0] = bytes2int(abyte0, 0);
        ai[1] = bytes2int(abyte0, 4);
        ai[2] = bytes2int(abyte0, 8);
        ai[3] = bytes2int(abyte0, 12);
        ai[4] = bytes2int(abyte0, 16);
        ai[5] = bytes2int(abyte0, 20);
        ai[6] = ~ai[4];
        ai[7] = ~ai[5];
        b = false;
        continue; /* Loop/switch isn't completed */
_L4:
        ai[0] = bytes2int(abyte0, 0);
        ai[1] = bytes2int(abyte0, 4);
        ai[2] = bytes2int(abyte0, 8);
        ai[3] = bytes2int(abyte0, 12);
        ai[4] = bytes2int(abyte0, 16);
        ai[5] = bytes2int(abyte0, 20);
        ai[6] = bytes2int(abyte0, 24);
        ai[7] = bytes2int(abyte0, 28);
        b = false;
        if (true) goto _L6; else goto _L5
_L5:
        camelliaF2(ai1, g, 0);
        for (int j = 0; j < 4; j++)
        {
            ai1[j] = ai1[j] ^ ai[j];
        }

        camelliaF2(ai1, g, 4);
        if (b)
        {
            if (flag)
            {
                d[0] = ai[0];
                d[1] = ai[1];
                d[2] = ai[2];
                d[3] = ai[3];
                roldq(15, ai, 0, c, 4);
                roldq(30, ai, 0, c, 12);
                roldq(15, ai, 0, ai3, 0);
                c[18] = ai3[2];
                c[19] = ai3[3];
                roldq(17, ai, 0, e, 4);
                roldq(17, ai, 0, c, 24);
                roldq(17, ai, 0, c, 32);
                c[0] = ai1[0];
                c[1] = ai1[1];
                c[2] = ai1[2];
                c[3] = ai1[3];
                roldq(15, ai1, 0, c, 8);
                roldq(15, ai1, 0, e, 0);
                roldq(15, ai1, 0, ai3, 0);
                c[16] = ai3[0];
                c[17] = ai3[1];
                roldq(15, ai1, 0, c, 20);
                roldqo32(34, ai1, 0, c, 28);
                roldq(17, ai1, 0, d, 4);
                return;
            } else
            {
                d[4] = ai[0];
                d[5] = ai[1];
                d[6] = ai[2];
                d[7] = ai[3];
                decroldq(15, ai, 0, c, 28);
                decroldq(30, ai, 0, c, 20);
                decroldq(15, ai, 0, ai3, 0);
                c[16] = ai3[0];
                c[17] = ai3[1];
                decroldq(17, ai, 0, e, 0);
                decroldq(17, ai, 0, c, 8);
                decroldq(17, ai, 0, c, 0);
                c[34] = ai1[0];
                c[35] = ai1[1];
                c[32] = ai1[2];
                c[33] = ai1[3];
                decroldq(15, ai1, 0, c, 24);
                decroldq(15, ai1, 0, e, 4);
                decroldq(15, ai1, 0, ai3, 0);
                c[18] = ai3[2];
                c[19] = ai3[3];
                decroldq(15, ai1, 0, c, 12);
                decroldqo32(34, ai1, 0, c, 4);
                roldq(17, ai1, 0, d, 0);
                return;
            }
        }
        for (int k = 0; k < 4; k++)
        {
            ai2[k] = ai1[k] ^ ai[k + 4];
        }

        camelliaF2(ai2, g, 8);
        if (flag)
        {
            d[0] = ai[0];
            d[1] = ai[1];
            d[2] = ai[2];
            d[3] = ai[3];
            roldqo32(45, ai, 0, c, 16);
            roldq(15, ai, 0, e, 4);
            roldq(17, ai, 0, c, 32);
            roldqo32(34, ai, 0, c, 44);
            roldq(15, ai, 4, c, 4);
            roldq(15, ai, 4, e, 0);
            roldq(30, ai, 4, c, 24);
            roldqo32(34, ai, 4, c, 36);
            roldq(15, ai1, 0, c, 8);
            roldq(30, ai1, 0, c, 20);
            e[8] = ai1[1];
            e[9] = ai1[2];
            e[10] = ai1[3];
            e[11] = ai1[0];
            roldqo32(49, ai1, 0, c, 40);
            c[0] = ai2[0];
            c[1] = ai2[1];
            c[2] = ai2[2];
            c[3] = ai2[3];
            roldq(30, ai2, 0, c, 12);
            roldq(30, ai2, 0, c, 28);
            roldqo32(51, ai2, 0, d, 4);
            return;
        } else
        {
            d[4] = ai[0];
            d[5] = ai[1];
            d[6] = ai[2];
            d[7] = ai[3];
            decroldqo32(45, ai, 0, c, 28);
            decroldq(15, ai, 0, e, 4);
            decroldq(17, ai, 0, c, 12);
            decroldqo32(34, ai, 0, c, 0);
            decroldq(15, ai, 4, c, 40);
            decroldq(15, ai, 4, e, 8);
            decroldq(30, ai, 4, c, 20);
            decroldqo32(34, ai, 4, c, 8);
            decroldq(15, ai1, 0, c, 36);
            decroldq(30, ai1, 0, c, 24);
            e[2] = ai1[1];
            e[3] = ai1[2];
            e[0] = ai1[3];
            e[1] = ai1[0];
            decroldqo32(49, ai1, 0, c, 4);
            c[46] = ai2[0];
            c[47] = ai2[1];
            c[44] = ai2[2];
            c[45] = ai2[3];
            decroldq(30, ai2, 0, c, 32);
            decroldq(30, ai2, 0, c, 16);
            roldqo32(51, ai2, 0, d, 0);
            return;
        }
    }

    public String getAlgorithmName()
    {
        return "Camellia";
    }

    public int getBlockSize()
    {
        return 16;
    }

    public void init(boolean flag, CipherParameters cipherparameters)
    {
        if (!(cipherparameters instanceof KeyParameter))
        {
            throw new IllegalArgumentException("only simple KeyParameter expected.");
        } else
        {
            setKey(flag, ((KeyParameter)cipherparameters).getKey());
            a = true;
            return;
        }
    }

    public int processBlock(byte abyte0[], int i, byte abyte1[], int j)
    {
        if (!a)
        {
            throw new IllegalStateException("Camellia is not initialized");
        }
        if (i + 16 > abyte0.length)
        {
            throw new DataLengthException("input buffer too short");
        }
        if (j + 16 > abyte1.length)
        {
            throw new DataLengthException("output buffer too short");
        }
        if (b)
        {
            return processBlock128(abyte0, i, abyte1, j);
        } else
        {
            return processBlock192or256(abyte0, i, abyte1, j);
        }
    }

    public void reset()
    {
    }

}
