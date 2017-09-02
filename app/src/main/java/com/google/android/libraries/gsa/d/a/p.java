package com.google.android.libraries.gsa.d.a;

import android.content.res.Configuration;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import android.view.WindowManager.LayoutParams;
import com.google.android.libraries.i.b;
import com.google.android.libraries.i.d;

final class p extends b implements Runnable {
    public int blh = 0;
    public final String mPackageName;
    public final /* synthetic */ k uoq;
    public final int uot;
    public final int uou;
    public final int uov;
    public m uow = new m();
    public Handler uox = new Handler(Looper.getMainLooper(), this.uow);
    public boolean uoy;

    public p(k kVar, int i, String str, int i2, int i3) {
        this.uoq = kVar;
        this.uot = i;
        this.mPackageName = str;
        this.uou = i2;
        this.uov = i3;
    }

    private final void cnJ() {
        if (Binder.getCallingUid() != this.uot) {
            //throw new RemoteException("Invalid client");
            throw new RuntimeException("Invalid client");//FIXME: modified, was remote exception and should still be one, realy have to change that
        }
    }

    public final synchronized void cnK() {
        cnJ();
        Message.obtain(this.uox, 3).sendToTarget();
    }

    public final synchronized void aL(float f) {
        cnJ();
        Message.obtain(this.uox, 4, Float.valueOf(f)).sendToTarget();
    }

    public final synchronized void cnL() {
        cnJ();
        Message.obtain(this.uox, 5).sendToTarget();
    }

    public final synchronized void a(LayoutParams layoutParams, d dVar, int i) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("layout_params", layoutParams);
        bundle.putInt("client_options", i);
        a(bundle, dVar);
    }

    public final synchronized void a(Bundle bundle, d dVar) {
        cnJ();
        this.uoq.uom.removeCallbacks(this);
        Configuration configuration = (Configuration) bundle.getParcelable("configuration");
        boolean z = configuration != null && configuration.orientation == 2;
        this.uoy = z;
        BL(bundle.getInt("client_options", 7));
        Message.obtain(this.uox, 0, 1, 0, Pair.create(bundle, dVar)).sendToTarget();
    }

    public final synchronized void od(boolean z) {
        cnJ();
        Message.obtain(this.uox, 0, 0, 0).sendToTarget();
        this.uoq.uom.postDelayed(this, z ? 5000 : 0);
    }

    public final synchronized void BJ(int i) {
        cnJ();
        this.uox.removeMessages(1);
        if ((i & 2) == 0) {
            this.uox.sendMessageDelayed(Message.obtain(this.uox, 1, Integer.valueOf(i)), 100);
        } else {
            Message.obtain(this.uox, 1, Integer.valueOf(i)).sendToTarget();
        }
    }

    public final synchronized void onPause() {
        BJ(0);
    }

    private final synchronized void BL(int i) {
        boolean z = true;
        synchronized (this) {
            int i2 = i & 15;
            if ((i2 & 1) != 0) {
                i2 = 1;
            }
            if (this.blh != i2) {
                m mVar;
                this.uox.removeCallbacksAndMessages(null);
                Message.obtain(this.uox, 0, 0, 0).sendToTarget();
                of(true);
                this.blh = i2;
                switch (this.blh) {
                    case 0:
                        mVar = new m();
                        break;
                    case 1:
                        mVar = new o(this.uoq, this);
                        break;
                    default:
                        if ((this.blh & 8) != 0 && this.uoq.bQ(false)) {
                            mVar = new q(this.uoq, this);
                            break;
                        }
                        k kVar = this.uoq;
                        boolean z2 = (this.blh & 4) != 0;
                        if ((this.blh & 2) == 0) {
                            z = false;
                        }
                        mVar = new l(kVar, this, z2, z);
                        break;
                    //break;Todo: modified, unreachable statement
                }
                this.uow = mVar;
                this.uox = new Handler(Looper.getMainLooper(), this.uow);
            }
        }
    }

    public final synchronized void onResume() {
        BJ(3);
    }

    public final synchronized void fI(int i) {
        cnJ();
        this.uox.removeMessages(6);
        Message.obtain(this.uox, 6, 0, i).sendToTarget();
    }

    public final synchronized void BK(int i) {
        cnJ();
        this.uox.removeMessages(6);
        Message.obtain(this.uox, 6, 1, i).sendToTarget();
    }

    public final synchronized boolean a(byte[] bArr, Bundle bundle) {
        boolean z;
        if (this.uoq.bQ(this.uoy)) {
            Message.obtain(this.uox, 8, new h(bArr, bundle)).sendToTarget();
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public final synchronized void oe(boolean z) {
        int i = 0;
        synchronized (this) {
            cnJ();
            this.uox.removeMessages(7);
            Handler handler = this.uox;
            if (z) {
                i = 1;
            }
            Message.obtain(handler, 7, i, 0).sendToTarget();
        }
    }

    public final String HB() {
        return this.uoq.HA().HB();
    }

    public final boolean HC() {
        return this.uoq.HA().HC();
    }

    public final boolean cnM() {
        return this.uoq.Hw();
    }

    public final void run() {
        destroy();
    }

    final void destroy() {
        synchronized (this.uoq) {
            this.uoq.uom.removeCallbacks(this);
            of(false);
        }
    }

    private final synchronized void of(boolean z) {
        int i = 0;
        synchronized (this) {
            Handler handler = this.uox;
            if (z) {
                i = 1;
            }
            Message.obtain(handler, 2, i, 0).sendToTarget();
        }
    }

    final void a(d dVar, int i) {
        if (dVar != null) {
            try {
                dVar.BI(this.uoq.Hx() | i);
            } catch (Throwable e) {
                Log.e("OverlaySController", "Failed to send status update", e);
            }
        }
    }
}
