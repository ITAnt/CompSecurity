// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.uploader.client;


// Referenced classes of package com.google.uploader.client:
//            HttpHeaders, DataStream, TransferOptions, Transfer

public interface UploadClient
{

    public abstract Transfer createTransfer(String s, String s1, HttpHeaders httpheaders, DataStream datastream, String s2, TransferOptions transferoptions);
}
