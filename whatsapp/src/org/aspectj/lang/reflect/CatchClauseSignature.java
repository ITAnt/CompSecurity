// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.aspectj.lang.reflect;

import org.aspectj.lang.Signature;

public interface CatchClauseSignature
    extends Signature
{

    public abstract String getParameterName();

    public abstract Class getParameterType();
}
