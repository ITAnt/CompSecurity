// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            SnapshotsImpl

private static abstract class <init> extends com.google.android.gms.games.dImpl
{

    public com.google.android.gms.games.snapshot.esult ar(Status status)
    {
        return new com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult(status) {

            final Status CW;
            final SnapshotsImpl.OpenImpl ZX;

            public String getConflictId()
            {
                return null;
            }

            public Snapshot getConflictingSnapshot()
            {
                return null;
            }

            public Contents getResolutionContents()
            {
                return null;
            }

            public SnapshotContents getResolutionSnapshotContents()
            {
                return null;
            }

            public Snapshot getSnapshot()
            {
                return null;
            }

            public Status getStatus()
            {
                return CW;
            }

            
            {
                ZX = SnapshotsImpl.OpenImpl.this;
                CW = status;
                super();
            }
        };
    }

    public Result c(Status status)
    {
        return ar(status);
    }

    private _cls1.CW()
    {
    }

    _cls1.CW(_cls1.CW cw)
    {
        this();
    }
}
