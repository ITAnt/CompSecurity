// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package rx.internal.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.SerialSubscription;

public final class OnSubscribeJoin
    implements rx.Observable.OnSubscribe
{
    final class ResultSink
    {

        final CompositeSubscription group = new CompositeSubscription();
        final Object guard = new Object();
        boolean leftDone;
        int leftId;
        final Map leftMap = new HashMap();
        boolean rightDone;
        int rightId;
        final Map rightMap = new HashMap();
        final Subscriber subscriber;
        final OnSubscribeJoin this$0;

        public void run()
        {
            subscriber.add(group);
            LeftSubscriber leftsubscriber = new LeftSubscriber();
            RightSubscriber rightsubscriber = new RightSubscriber();
            group.add(leftsubscriber);
            group.add(rightsubscriber);
            left.unsafeSubscribe(leftsubscriber);
            right.unsafeSubscribe(rightsubscriber);
        }

        public ResultSink(Subscriber subscriber1)
        {
            this$0 = OnSubscribeJoin.this;
            super();
            subscriber = subscriber1;
        }
    }

    final class ResultSink.LeftSubscriber extends Subscriber
    {

        final ResultSink this$1;

        protected void expire(int i, Subscription subscription)
        {
            boolean flag1 = false;
            Object obj = guard;
            obj;
            JVM INSTR monitorenter ;
            boolean flag = flag1;
            if (leftMap.remove(Integer.valueOf(i)) == null)
            {
                break MISSING_BLOCK_LABEL_72;
            }
            flag = flag1;
            if (!leftMap.isEmpty())
            {
                break MISSING_BLOCK_LABEL_72;
            }
            flag = flag1;
            if (leftDone)
            {
                flag = true;
            }
            obj;
            JVM INSTR monitorexit ;
            if (flag)
            {
                subscriber.onCompleted();
                subscriber.unsubscribe();
                return;
            } else
            {
                group.remove(subscription);
                return;
            }
            subscription;
            obj;
            JVM INSTR monitorexit ;
            throw subscription;
        }

        public void onCompleted()
        {
            boolean flag = false;
            Object obj = guard;
            obj;
            JVM INSTR monitorenter ;
            leftDone = true;
            Exception exception;
            if (rightDone || leftMap.isEmpty())
            {
                flag = true;
            }
            obj;
            JVM INSTR monitorexit ;
            if (flag)
            {
                subscriber.onCompleted();
                subscriber.unsubscribe();
                return;
            } else
            {
                group.remove(this);
                return;
            }
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void onError(Throwable throwable)
        {
            subscriber.onError(throwable);
            subscriber.unsubscribe();
        }

        public void onNext(Object obj)
        {
            int i;
            int j;
            synchronized (guard)
            {
                ResultSink resultsink = ResultSink.this;
                i = resultsink.leftId;
                resultsink.leftId = i + 1;
                leftMap.put(Integer.valueOf(i), obj);
                j = rightId;
            }
            Object obj2;
            obj1 = (Observable)leftDurationSelector.call(obj);
            obj2 = new LeftDurationSubscriber(i);
            group.add(((Subscription) (obj2)));
            ((Observable) (obj1)).unsafeSubscribe(((Subscriber) (obj2)));
            obj2 = new ArrayList();
            obj1 = guard;
            obj1;
            JVM INSTR monitorenter ;
            Iterator iterator1 = rightMap.entrySet().iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator1.next();
                if (((Integer)entry.getKey()).intValue() < j)
                {
                    ((List) (obj2)).add(entry.getValue());
                }
            } while (true);
              goto _L1
            obj;
            obj1;
            JVM INSTR monitorexit ;
            try
            {
                throw obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                onError(((Throwable) (obj)));
            }
_L2:
            return;
            obj;
            obj1;
            JVM INSTR monitorexit ;
            throw obj;
_L1:
            obj1;
            JVM INSTR monitorexit ;
            Iterator iterator = ((List) (obj2)).iterator();
            while (iterator.hasNext()) 
            {
                Object obj3 = iterator.next();
                obj3 = resultSelector.call(obj, obj3);
                subscriber.onNext(obj3);
            }
              goto _L2
        }

        ResultSink.LeftSubscriber()
        {
            this$1 = ResultSink.this;
            super();
        }
    }

    final class ResultSink.LeftSubscriber.LeftDurationSubscriber extends Subscriber
    {

        final int id;
        boolean once;
        final ResultSink.LeftSubscriber this$2;

        public void onCompleted()
        {
            if (once)
            {
                once = false;
                expire(id, this);
            }
        }

        public void onError(Throwable throwable)
        {
            ResultSink.LeftSubscriber.this.onError(throwable);
        }

        public void onNext(Object obj)
        {
            onCompleted();
        }

        public ResultSink.LeftSubscriber.LeftDurationSubscriber(int i)
        {
            this$2 = ResultSink.LeftSubscriber.this;
            super();
            once = true;
            id = i;
        }
    }

    final class ResultSink.RightSubscriber extends Subscriber
    {

        final ResultSink this$1;

        void expire(int i, Subscription subscription)
        {
            boolean flag1 = false;
            Object obj = guard;
            obj;
            JVM INSTR monitorenter ;
            boolean flag = flag1;
            if (rightMap.remove(Integer.valueOf(i)) == null)
            {
                break MISSING_BLOCK_LABEL_72;
            }
            flag = flag1;
            if (!rightMap.isEmpty())
            {
                break MISSING_BLOCK_LABEL_72;
            }
            flag = flag1;
            if (rightDone)
            {
                flag = true;
            }
            obj;
            JVM INSTR monitorexit ;
            if (flag)
            {
                subscriber.onCompleted();
                subscriber.unsubscribe();
                return;
            } else
            {
                group.remove(subscription);
                return;
            }
            subscription;
            obj;
            JVM INSTR monitorexit ;
            throw subscription;
        }

        public void onCompleted()
        {
            boolean flag = false;
            Object obj = guard;
            obj;
            JVM INSTR monitorenter ;
            rightDone = true;
            Exception exception;
            if (leftDone || rightMap.isEmpty())
            {
                flag = true;
            }
            obj;
            JVM INSTR monitorexit ;
            if (flag)
            {
                subscriber.onCompleted();
                subscriber.unsubscribe();
                return;
            } else
            {
                group.remove(this);
                return;
            }
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void onError(Throwable throwable)
        {
            subscriber.onError(throwable);
            subscriber.unsubscribe();
        }

        public void onNext(Object obj)
        {
            int i;
            int j;
            synchronized (guard)
            {
                ResultSink resultsink = ResultSink.this;
                i = resultsink.rightId;
                resultsink.rightId = i + 1;
                rightMap.put(Integer.valueOf(i), obj);
                j = leftId;
            }
            obj1 = new SerialSubscription();
            group.add(((Subscription) (obj1)));
            Object obj2;
            obj1 = (Observable)rightDurationSelector.call(obj);
            obj2 = new RightDurationSubscriber(i);
            group.add(((Subscription) (obj2)));
            ((Observable) (obj1)).unsafeSubscribe(((Subscriber) (obj2)));
            obj2 = new ArrayList();
            obj1 = guard;
            obj1;
            JVM INSTR monitorenter ;
            Iterator iterator1 = leftMap.entrySet().iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator1.next();
                if (((Integer)entry.getKey()).intValue() < j)
                {
                    ((List) (obj2)).add(entry.getValue());
                }
            } while (true);
              goto _L1
            obj;
            obj1;
            JVM INSTR monitorexit ;
            try
            {
                throw obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                onError(((Throwable) (obj)));
            }
_L2:
            return;
            obj;
            obj1;
            JVM INSTR monitorexit ;
            throw obj;
_L1:
            obj1;
            JVM INSTR monitorexit ;
            Iterator iterator = ((List) (obj2)).iterator();
            while (iterator.hasNext()) 
            {
                Object obj3 = iterator.next();
                obj3 = resultSelector.call(obj3, obj);
                subscriber.onNext(obj3);
            }
              goto _L2
        }

        ResultSink.RightSubscriber()
        {
            this$1 = ResultSink.this;
            super();
        }
    }

    final class ResultSink.RightSubscriber.RightDurationSubscriber extends Subscriber
    {

        final int id;
        boolean once;
        final ResultSink.RightSubscriber this$2;

        public void onCompleted()
        {
            if (once)
            {
                once = false;
                expire(id, this);
            }
        }

        public void onError(Throwable throwable)
        {
            ResultSink.RightSubscriber.this.onError(throwable);
        }

        public void onNext(Object obj)
        {
            onCompleted();
        }

        public ResultSink.RightSubscriber.RightDurationSubscriber(int i)
        {
            this$2 = ResultSink.RightSubscriber.this;
            super();
            once = true;
            id = i;
        }
    }


    final Observable left;
    final Func1 leftDurationSelector;
    final Func2 resultSelector;
    final Observable right;
    final Func1 rightDurationSelector;

    public OnSubscribeJoin(Observable observable, Observable observable1, Func1 func1, Func1 func1_1, Func2 func2)
    {
        left = observable;
        right = observable1;
        leftDurationSelector = func1;
        rightDurationSelector = func1_1;
        resultSelector = func2;
    }

    public volatile void call(Object obj)
    {
        call((Subscriber)obj);
    }

    public void call(Subscriber subscriber)
    {
        (new ResultSink(new SerializedSubscriber(subscriber))).run();
    }
}
