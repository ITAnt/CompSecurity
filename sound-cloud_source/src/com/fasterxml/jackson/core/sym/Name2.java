// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.core.sym;


// Referenced classes of package com.fasterxml.jackson.core.sym:
//            Name

public final class Name2 extends Name
{

    final int mQuad1;
    final int mQuad2;

    Name2(String s, int i, int j, int k)
    {
        super(s, i);
        mQuad1 = j;
        mQuad2 = k;
    }

    public final boolean equals(int i)
    {
        return false;
    }

    public final boolean equals(int i, int j)
    {
        return i == mQuad1 && j == mQuad2;
    }

    public final boolean equals(int ai[], int i)
    {
        return i == 2 && ai[0] == mQuad1 && ai[1] == mQuad2;
    }
}
