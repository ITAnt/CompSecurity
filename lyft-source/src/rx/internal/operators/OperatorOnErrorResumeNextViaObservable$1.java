// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;

// Referenced classes of package rx.internal.operators:
//            OperatorOnErrorResumeNextViaObservable

class done extends Subscriber
{

    private boolean done;
    final OperatorOnErrorResumeNextViaObservable this$0;
    final Subscriber val$child;

    public void onCompleted()
    {
        if (done)
        {
            return;
        } else
        {
            done = true;
            val$child.onCompleted();
            return;
        }
    }

    public void onError(Throwable throwable)
    {
        if (done)
        {
            Exceptions.throwIfFatal(throwable);
            return;
        } else
        {
            done = true;
            RxJavaPlugins.getInstance().getErrorHandler().handleError(throwable);
            unsubscribe();
            resumeSequence.unsafeSubscribe(val$child);
            return;
        }
    }

    public void onNext(Object obj)
    {
        if (done)
        {
            return;
        } else
        {
            val$child.onNext(obj);
            return;
        }
    }

    public void setProducer(final Producer producer)
    {
        val$child.setProducer(new Producer() {

            final OperatorOnErrorResumeNextViaObservable._cls1 this$1;
            final Producer val$producer;

            public void request(long l)
            {
                producer.request(l);
            }

            
            {
                this$1 = OperatorOnErrorResumeNextViaObservable._cls1.this;
                producer = producer1;
                super();
            }
        });
    }

    _cls1.val.producer()
    {
        this$0 = final_operatoronerrorresumenextviaobservable;
        val$child = Subscriber.this;
        super();
        done = false;
    }
}
