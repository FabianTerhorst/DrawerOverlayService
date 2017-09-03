package com.google.android.libraries.gsa.d.a;

import android.os.Message;
import android.util.Pair;

import com.google.android.libraries.i.d;
import com.google.android.libraries.material.progress.u;

import java.io.PrintWriter;

final class ApiServiceCallback extends BaseCallback {

    public final boolean mSupportsHotword;
    public int mState = 0;
    public d uoa;
    public final OverlayControllerBinder overlayControllerBinder;
    public final boolean mSupportsPrewarm;
    public IServiceHolder serviceHolder;
    public final /* synthetic */ OverlaysController overlaysController;

    public ApiServiceCallback(OverlaysController overlaysControllerVar, OverlayControllerBinder overlayControllerBinderVar, boolean supportsPrewarm, boolean supportsHotword) {
        this.overlaysController = overlaysControllerVar;
        this.overlayControllerBinder = overlayControllerBinderVar;
        this.mSupportsPrewarm = supportsPrewarm;
        this.mSupportsHotword = supportsHotword;
    }

    private final void ai(int i, boolean z) {
        int i2 = this.mState;
        if (z) {
            this.mState |= i;
        } else {
            this.mState &= i ^ -1;
        }
        if (this.mSupportsHotword || this.mSupportsPrewarm) {
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            if ((i2 & 3) == 3) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((this.mState & 3) == 3) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z2 && (i2 & 4) == 4) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z3 && (this.mState & 4) == 4) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (z2 != z3) {
                if (z3) {
                    if (this.serviceHolder == null) {
                        this.serviceHolder = this.overlaysController.getServiceHolder();
                    }
                    this.serviceHolder.k(this.mSupportsPrewarm, this.mSupportsHotword);
                } else {
                    if (this.mSupportsHotword) {
                        this.serviceHolder.bV(false);
                    }
                    if (this.serviceHolder != null) {
                        this.serviceHolder.disconnect();
                    }
                }
            }
            if (z4 == z5) {
                return;
            }
            if (z5) {
                this.serviceHolder.bV(true);
            } else {
                this.serviceHolder.bV(false);
            }
        }
    }

    public final boolean handleMessage(Message message) {
        int i = 0;
        switch (message.what) {
            case 0:
                ai(1, message.arg1 == 1);
                if (message.arg1 != 1) {
                    return true;
                }
                if (this.mSupportsHotword) {
                    ai(4, true);
                }
                this.uoa = (d) ((Pair) message.obj).second;
                if (this.mSupportsHotword) {
                    i = 2;
                }
                if (this.mSupportsPrewarm) {
                    i |= 4;
                }
                this.overlayControllerBinder.a(this.uoa, i);
                return true;
            case 1:
                ai(2, (((Integer) message.obj).intValue() & 2) != 0);
                return true;
            case 2:
                ai(7, false);
                if (message.arg1 == 0) {
                    this.overlayControllerBinder.a(this.uoa, 0);
                }
                this.uoa = null;
                return true;
            case 3:
            case u.uKO /*4*/:
            case u.uKS /*5*/:
            case u.uKQ /*6*/:
            case 8:
                return true;
            case u.uKR /*7*/:
                boolean z;
                if (message.arg1 == 1) {
                    z = true;
                } else {//Todo: modified, else blog was not there but had to instantiate z
                    z = false;
                }
                ai(4, z);
                return true;
            default:
                return false;
        }
    }

    public final void dump(PrintWriter printWriter, String str) {
        printWriter.println(String.valueOf(str).concat("APIServiceCallback"));
        String concat = String.valueOf(str).concat("  ");
        printWriter.println(new StringBuilder(String.valueOf(concat).length() + 23).append(concat).append("mSupportsPrewarm: ").append(this.mSupportsPrewarm).toString());
        printWriter.println(new StringBuilder(String.valueOf(concat).length() + 23).append(concat).append("mSupportsHotword: ").append(this.mSupportsHotword).toString());
        printWriter.println(new StringBuilder(String.valueOf(concat).length() + 19).append(concat).append("mState: ").append(this.mState).toString());
        String valueOf = String.valueOf(this.serviceHolder);
        printWriter.println(new StringBuilder((String.valueOf(concat).length() + 9) + String.valueOf(valueOf).length()).append(concat).append("mClient: ").append(valueOf).toString());
    }
}
