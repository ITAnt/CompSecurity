// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.alibaba.api.common.pojo;

import java.util.ArrayList;

public class QualityPicks
{
    public static class Tag
    {

        public String showName;
        public String tagId;

        public Tag()
        {
        }

        public Tag(String s, String s1)
        {
            tagId = s1;
            showName = s;
        }
    }


    public String effectTagId;
    public ArrayList productList;
    public String requestId;
    public ArrayList tagList;
    public String tagRequestId;
    public String title;

    public QualityPicks()
    {
    }
}
