package com.google.android.libraries.gsa.d.a;

import android.content.res.Configuration;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import android.view.WindowManager.LayoutParams;

import com.google.android.libraries.i.LauncherOverlayInterfaceBinder;
import com.google.android.libraries.i.d;

final class OverlayControllerBinder extends LauncherOverlayInterfaceBinder implements Runnable {

    public int blh = 0;
    public final String mPackageName;
    public final /* synthetic */ OverlaysController overlaysController;
    public final int uot;
    public final int uou;
    public final int uov;
    public BaseCallback baseCallback = new BaseCallback();
    public Handler mainThreadHandler = new Handler(Looper.getMainLooper(), this.baseCallback);
    public boolean uoy;

    public OverlayControllerBinder(OverlaysController overlaysControllerVar, int i, String str, int i2, int i3) {
        this.overlaysController = overlaysControllerVar;
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
        Message.obtain(this.mainThreadHandler, 3).sendToTarget();
    }

    public final synchronized void aL(float f) {
        cnJ();
        Message.obtain(this.mainThreadHandler, 4, f).sendToTarget();
    }

    public final synchronized void cnL() {
        cnJ();
        Message.obtain(this.mainThreadHandler, 5).sendToTarget();
    }

    public final synchronized void a(LayoutParams layoutParams, d dVar, int i) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("layout_params", layoutParams);
        bundle.putInt("client_options", i);
        a(bundle, dVar);
    }

    public final synchronized void a(Bundle bundle, d dVar) {
        cnJ();
        this.overlaysController.handler.removeCallbacks(this);
        Configuration configuration = (Configuration) bundle.getParcelable("configuration");
        boolean z = configuration != null && configuration.orientation == 2;
        this.uoy = z;
        BL(bundle.getInt("client_options", 7));
        Message.obtain(this.mainThreadHandler, 0, 1, 0, Pair.create(bundle, dVar)).sendToTarget();
    }

    public final synchronized void od(boolean z) {
        cnJ();
        Message.obtain(this.mainThreadHandler, 0, 0, 0).sendToTarget();
        this.overlaysController.handler.postDelayed(this, z ? 5000 : 0);
    }

    public final synchronized void BJ(int i) {
        cnJ();
        this.mainThreadHandler.removeMessages(1);
        if ((i & 2) == 0) {
            this.mainThreadHandler.sendMessageDelayed(Message.obtain(this.mainThreadHandler, 1, i), 100);
        } else {
            Message.obtain(this.mainThreadHandler, 1, i).sendToTarget();
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
                BaseCallback baseCallbackVar;
                this.mainThreadHandler.removeCallbacksAndMessages(null);
                Message.obtain(this.mainThreadHandler, 0, 0, 0).sendToTarget();
                of(true);
                this.blh = i2;
                switch (this.blh) {
                    case 0:
                        baseCallbackVar = new BaseCallback();
                        break;
                    case 1:
                        baseCallbackVar = new MinusOneOverlayCallback(this.overlaysController, this);
                        break;
                    default:
                        if ((this.blh & 8) != 0) {
                            baseCallbackVar = new SearchOverlayCallback(this.overlaysController, this);
                            break;
                        }
                        OverlaysController overlaysControllerVar = this.overlaysController;
                        boolean z2 = (this.blh & 4) != 0;
                        if ((this.blh & 2) == 0) {
                            z = false;
                        }
                        baseCallbackVar = new ApiServiceCallback(overlaysControllerVar, this, z2, z);
                        break;
                    //break;Todo: modified, unreachable statement
                }
                this.baseCallback = baseCallbackVar;
                this.mainThreadHandler = new Handler(Looper.getMainLooper(), this.baseCallback);
            }
        }
    }

    public final synchronized void onResume() {
        BJ(3);
    }

    public final synchronized void fI(int i) {
        cnJ();
        this.mainThreadHandler.removeMessages(6);
        Message.obtain(this.mainThreadHandler, 6, 0, i).sendToTarget();
    }

    public final synchronized void BK(int i) {
        cnJ();
        this.mainThreadHandler.removeMessages(6);
        Message.obtain(this.mainThreadHandler, 6, 1, i).sendToTarget();
    }

    public final synchronized boolean a(byte[] bArr, Bundle bundle) {
        Message.obtain(this.mainThreadHandler, 8, new h(bArr, bundle)).sendToTarget();
        return true;
    }

    public final synchronized void oe(boolean z) {
        int i = 0;
        synchronized (this) {
            cnJ();
            this.mainThreadHandler.removeMessages(7);
            Handler handler = this.mainThreadHandler;
            if (z) {
                i = 1;
            }
            Message.obtain(handler, 7, i, 0).sendToTarget();
        }
    }

    public final String HB() {
        return this.overlaysController.HA().HB();
    }

    public final boolean HC() {
        return this.overlaysController.HA().HC();
    }

    //Todo: always true, remove
    public final boolean cnM() {
        return true;
    }

    public final void run() {
        destroy();
    }

    final void destroy() {
        synchronized (this.overlaysController) {
            this.overlaysController.handler.removeCallbacks(this);
            of(false);
        }
    }

    private final synchronized void of(boolean z) {
        int i = 0;
        synchronized (this) {
            Handler handler = this.mainThreadHandler;
            if (z) {
                i = 1;
            }
            Message.obtain(handler, 2, i, 0).sendToTarget();
        }
    }

    final void a(d dVar, int i) {
        if (dVar != null) {
            try {
                dVar.BI(this.overlaysController.Hx() | i);
            } catch (Throwable e) {
                Log.e("OverlaySController", "Failed to send status update", e);
            }
        }
    }
}
