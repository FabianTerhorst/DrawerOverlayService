package com.google.android.libraries.gsa.d.a;

import android.os.Message;
import android.util.Pair;

import com.google.android.libraries.i.d;
import com.google.android.libraries.material.progress.u;

import java.io.PrintWriter;

final class ApiServiceCallback extends BaseCallback {

    public final boolean dDr;
    public int mState = 0;
    public d uoa;
    public final p uon;
    public final boolean uoo;
    public a uop;
    public final /* synthetic */ OverlaysController overlaysController;

    public ApiServiceCallback(OverlaysController overlaysControllerVar, p pVar, boolean z, boolean z2) {
        this.overlaysController = overlaysControllerVar;
        this.uon = pVar;
        this.uoo = z;
        this.dDr = z2;
    }

    private final void ai(int i, boolean z) {
        int i2 = this.mState;
        if (z) {
            this.mState |= i;
        } else {
            this.mState &= i ^ -1;
        }
        if (this.dDr || this.uoo) {
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
                    if (this.uop == null) {
                        this.uop = this.overlaysController.Hz();
                    }
                    this.uop.k(this.uoo, this.dDr);
                } else {
                    if (this.dDr) {
                        this.uop.bV(false);
                    }
                    if (this.uop != null) {
                        this.uop.disconnect();
                    }
                }
            }
            if (z4 == z5) {
                return;
            }
            if (z5) {
                this.uop.bV(true);
            } else {
                this.uop.bV(false);
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
                if (this.dDr) {
                    ai(4, true);
                }
                this.uoa = (d) ((Pair) message.obj).second;
                if (this.dDr) {
                    i = 2;
                }
                if (this.uoo) {
                    i |= 4;
                }
                this.uon.a(this.uoa, i);
                return true;
            case 1:
                ai(2, (((Integer) message.obj).intValue() & 2) != 0);
                return true;
            case 2:
                ai(7, false);
                if (message.arg1 == 0) {
                    this.uon.a(this.uoa, 0);
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

    public final void a(PrintWriter printWriter, String str) {
        printWriter.println(String.valueOf(str).concat("APIServiceCallback"));
        String concat = String.valueOf(str).concat("  ");
        printWriter.println(new StringBuilder(String.valueOf(concat).length() + 23).append(concat).append("mSupportsPrewarm: ").append(this.uoo).toString());
        printWriter.println(new StringBuilder(String.valueOf(concat).length() + 23).append(concat).append("mSupportsHotword: ").append(this.dDr).toString());
        printWriter.println(new StringBuilder(String.valueOf(concat).length() + 19).append(concat).append("mState: ").append(this.mState).toString());
        String valueOf = String.valueOf(this.uop);
        printWriter.println(new StringBuilder((String.valueOf(concat).length() + 9) + String.valueOf(valueOf).length()).append(concat).append("mClient: ").append(valueOf).toString());
    }
}
