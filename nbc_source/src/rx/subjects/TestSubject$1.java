// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package rx.subjects;

import rx.functions.Action1;

// Referenced classes of package rx.subjects:
//            TestSubject, SubjectSubscriptionManager

static final class val.state
    implements Action1
{

    final SubjectSubscriptionManager val$state;

    public volatile void call(Object obj)
    {
        call((ptionManager.SubjectObserver)obj);
    }

    public void call(ptionManager.SubjectObserver subjectobserver)
    {
        subjectobserver.emitFirst(val$state.get(), val$state.nl);
    }

    ptionManager(SubjectSubscriptionManager subjectsubscriptionmanager)
    {
        val$state = subjectsubscriptionmanager;
        super();
    }
}
