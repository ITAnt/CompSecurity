// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;
import java.util.Set;

// Referenced classes of package com.google.android.gms.common:
//            ci, g, h, d

public class kb
{

    private static final kb a = new kb();

    private kb()
    {
    }

    public static kb a()
    {
        return a;
    }

    private boolean a(PackageInfo packageinfo, boolean flag)
    {
        if (packageinfo.signatures.length != 1)
        {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return false;
        }
        ci ci1 = new ci(packageinfo.signatures[0].toByteArray());
        if (flag)
        {
            packageinfo = g.a();
        } else
        {
            packageinfo = g.b();
        }
        if (packageinfo.contains(ci1))
        {
            return true;
        }
        if (Log.isLoggable("GoogleSignatureVerifier", 2))
        {
            Log.v("GoogleSignatureVerifier", (new StringBuilder()).append("Signature not valid.  Found: \n").append(Base64.encodeToString(ci1.a(), 0)).toString());
        }
        return false;
    }

    transient h a(PackageInfo packageinfo, h ah[])
    {
        if (packageinfo.signatures.length != 1)
        {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        packageinfo = new ci(packageinfo.signatures[0].toByteArray());
        for (int i = 0; i < ah.length; i++)
        {
            if (ah[i].equals(packageinfo))
            {
                return ah[i];
            }
        }

        if (Log.isLoggable("GoogleSignatureVerifier", 2))
        {
            Log.v("GoogleSignatureVerifier", (new StringBuilder()).append("Signature not valid.  Found: \n").append(Base64.encodeToString(packageinfo.a(), 0)).toString());
        }
        return null;
    }

    public boolean a(PackageManager packagemanager, PackageInfo packageinfo)
    {
        boolean flag = false;
        if (packageinfo != null)
        {
            if (d.b(packagemanager))
            {
                return a(packageinfo, true);
            }
            boolean flag1 = a(packageinfo, false);
            flag = flag1;
            if (!flag1)
            {
                flag = flag1;
                if (a(packageinfo, true))
                {
                    Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
                    return flag1;
                }
            }
        }
        return flag;
    }

    public boolean a(PackageManager packagemanager, String s)
    {
        PackageInfo packageinfo;
        try
        {
            packageinfo = packagemanager.getPackageInfo(s, 64);
        }
        // Misplaced declaration of an exception variable
        catch (PackageManager packagemanager)
        {
            if (Log.isLoggable("GoogleSignatureVerifier", 3))
            {
                Log.d("GoogleSignatureVerifier", (new StringBuilder()).append("Package manager can't find package ").append(s).append(", defaulting to false").toString());
            }
            return false;
        }
        return a(packagemanager, packageinfo);
    }

}
