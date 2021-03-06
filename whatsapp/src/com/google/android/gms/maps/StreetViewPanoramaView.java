// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

// Referenced classes of package com.google.android.gms.maps:
//            StreetViewPanoramaOptions

public class StreetViewPanoramaView extends FrameLayout
{

    private final b aly;

    public StreetViewPanoramaView(Context context)
    {
        super(context);
        aly = new b(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        aly = new b(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        aly = new b(this, context, null);
    }

    public StreetViewPanoramaView(Context context, StreetViewPanoramaOptions streetviewpanoramaoptions)
    {
        super(context);
        aly = new b(this, context, streetviewpanoramaoptions);
    }

    private class b extends a
    {

        protected f akW;
        private final StreetViewPanoramaOptions alC;
        private final ViewGroup ald;
        private final List alq = new ArrayList();
        private final Context mContext;

        protected void a(f f1)
        {
            akW = f1;
            nO();
        }

        public void nO()
        {
            int i = com.google.android.gms.maps.MapView.a;
            Object obj;
            OnStreetViewPanoramaReadyCallback onstreetviewpanoramareadycallback;
            try
            {
                if (akW == null)
                {
                    break MISSING_BLOCK_LABEL_118;
                }
                obj = je();
            }
            catch (RemoteException remoteexception)
            {
                throw remoteexception;
            }
            if (obj != null)
            {
                break MISSING_BLOCK_LABEL_118;
            }
            obj = x.S(mContext).a(e.k(mContext), alC);
            akW.a(new a(ald, ((IStreetViewPanoramaViewDelegate) (obj))));
            obj = alq.iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                onstreetviewpanoramareadycallback = (OnStreetViewPanoramaReadyCallback)((Iterator) (obj)).next();
                ((a)je()).getStreetViewPanoramaAsync(onstreetviewpanoramareadycallback);
            } while (i == 0);
            alq.clear();
            return;
            Object obj1;
            obj1;
            throw new RuntimeRemoteException(((RemoteException) (obj1)));
            obj1;
        }

        b(ViewGroup viewgroup, Context context, StreetViewPanoramaOptions streetviewpanoramaoptions)
        {
            ald = viewgroup;
            mContext = context;
            alC = streetviewpanoramaoptions;
        }

        private class a
            implements StreetViewLifecycleDelegate
        {

            private final ViewGroup akZ;
            private View alA;
            private final IStreetViewPanoramaViewDelegate alz;

            public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onstreetviewpanoramareadycallback)
            {
                try
                {
                    class _cls1 extends com.google.android.gms.maps.internal.u.a
                    {

                        final a alB;
                        final OnStreetViewPanoramaReadyCallback alo;

                        public void a(IStreetViewPanoramaDelegate istreetviewpanoramadelegate)
                        {
                            alo.onStreetViewPanoramaReady(new StreetViewPanorama(istreetviewpanoramadelegate));
                        }

                    _cls1(OnStreetViewPanoramaReadyCallback onstreetviewpanoramareadycallback)
                    {
                        alB = a.this;
                        alo = onstreetviewpanoramareadycallback;
                        super();
                    }
                    }

                    alz.getStreetViewPanoramaAsync(new _cls1(onstreetviewpanoramareadycallback));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (OnStreetViewPanoramaReadyCallback onstreetviewpanoramareadycallback)
                {
                    throw new RuntimeRemoteException(onstreetviewpanoramareadycallback);
                }
            }

            public void onCreate(Bundle bundle)
            {
                try
                {
                    alz.onCreate(bundle);
                    alA = (View)e.f(alz.getView());
                    akZ.removeAllViews();
                    akZ.addView(alA);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Bundle bundle)
                {
                    throw new RuntimeRemoteException(bundle);
                }
            }

            public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
            {
                throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
            }

            public void onDestroy()
            {
                try
                {
                    alz.onDestroy();
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    throw new RuntimeRemoteException(remoteexception);
                }
            }

            public void onDestroyView()
            {
                throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
            }

            public void onInflate(Activity activity, Bundle bundle, Bundle bundle1)
            {
                throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
            }

            public void onLowMemory()
            {
                try
                {
                    alz.onLowMemory();
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    throw new RuntimeRemoteException(remoteexception);
                }
            }

            public void onPause()
            {
                try
                {
                    alz.onPause();
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    throw new RuntimeRemoteException(remoteexception);
                }
            }

            public void onResume()
            {
                try
                {
                    alz.onResume();
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    throw new RuntimeRemoteException(remoteexception);
                }
            }

            public void onSaveInstanceState(Bundle bundle)
            {
                try
                {
                    alz.onSaveInstanceState(bundle);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Bundle bundle)
                {
                    throw new RuntimeRemoteException(bundle);
                }
            }

            public a(ViewGroup viewgroup, IStreetViewPanoramaViewDelegate istreetviewpanoramaviewdelegate)
            {
                alz = (IStreetViewPanoramaViewDelegate)jx.i(istreetviewpanoramaviewdelegate);
                akZ = (ViewGroup)jx.i(viewgroup);
            }
        }

    }

}
