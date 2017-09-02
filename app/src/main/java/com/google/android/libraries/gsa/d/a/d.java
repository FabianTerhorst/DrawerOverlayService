package com.google.android.libraries.gsa.d.a;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.FrameLayout;
import java.io.PrintWriter;

public class d extends b {
    public boolean mIsRtl;
    public long obZ = 0;
    public int unO;
    public String unT;
    public r unU;
    public t unV = new g(this);
    public FrameLayout unW;
    public int unX = 0;
    public boolean unY = false;
    public boolean unZ = true;
    public com.google.android.libraries.i.d uoa;
    public f uob = f.CLOSED;
    public int uoc = 0;

    public d(Context context, int i, int i2) {
        super(context, i, i2);
    }

    final void b(int i, int i2, long j) {
        MotionEvent obtain = MotionEvent.obtain(this.obZ, j, i, this.mIsRtl ? (float) (-i2) : (float) i2, 0.0f, 0);
        obtain.setSource(4098);
        this.unU.dispatchTouchEvent(obtain);
        obtain.recycle();
    }

    final com.google.android.libraries.i.d cnC() {
        BJ(0);
        try {
            this.agw.removeView(this.unS);
        } catch (Throwable e) {
            Log.e("wo.OverlayController", "Error removing overlay window", e);
        }
        this.unS = null;
        cnB();
        onDestroy();
        return this.uoa;
    }

    final void BJ(int i) {
        int i2 = 1;
        int i3 = 0;
        if (this.uoc != i) {
            int i4;
            int i5;
            int i6;
            int i7 = (this.uoc & 1) != 0 ? 1 : 0;
            if ((this.uoc & 2) != 0) {
                i4 = 1;
            } else {
                i4 = 0;
            }
            if ((i & 1) != 0) {
                i5 = 1;
            } else {
                i5 = 0;
            }
            if ((i & 2) != 0) {
                i6 = 1;
            } else {
                i6 = 0;
            }
            if (i5 == 0 && i6 == 0) {
                i5 = 0;
            } else {
                i5 = 1;
            }
            if (i5 == 0) {
                i2 = 0;
            }
            if (i6 != 0) {
                i3 = 2;
            }
            this.uoc = i2 | i3;
            if (i7 == 0 && i5 != 0) {
                onStart();
            }
            if (i4 == 0 && i6 != 0) {
                onResume();
            }
            if (i4 != 0 && i6 == 0) {
                onPause();
            }
            if (i7 != 0 && i5 == 0) {
                onStop();
            }
        }
    }

    public void fI(int i) {
        int i2 = 1;
        int i3 = 0;
        if (cnD()) {
            int i4 = (i & 1) != 0 ? 1 : 0;
            if (this.uob == f.OPEN_AS_LAYER) {
                i2 = 0;
            }
            i4 &= i2;
            r rVar = this.unU;
            if (i4 != 0) {
                i3 = 750;
            }
            rVar.closePanel(i3);
            cnB();
        }
    }

    public final void BK(int i) {
        int i2 = 0;
        if (this.uob == f.CLOSED) {
            int i3 = (i & 1) != 0 ? 1 : 0;
            if ((i & 2) != 0) {
                this.unU.uoH = new i(this);
                i3 = 0;
            }
            r rVar = this.unU;
            if (i3 != 0) {
                i2 = 750;
            }
            rVar.fv(i2);
        }
    }

    public void a(h hVar) {
    }

    public void onBackPressed() {
        fI(1);
    }

    public void a(PrintWriter printWriter, String str) {
        printWriter.println(new StringBuilder(String.valueOf(str).length() + 25).append(str).append("mWindowShift: ").append(this.unO).toString());
        printWriter.println(new StringBuilder(String.valueOf(str).length() + 26).append(str).append("mAcceptExternalMove: ").append(this.unY).toString());
        String valueOf = String.valueOf(this.uob);
        printWriter.println(new StringBuilder((String.valueOf(str).length() + 14) + String.valueOf(valueOf).length()).append(str).append("mDrawerState: ").append(valueOf).toString());
        printWriter.println(new StringBuilder(String.valueOf(str).length() + 32).append(str).append("mActivityStateFlags: ").append(this.uoc).toString());
        valueOf = String.valueOf(this.unU);
        printWriter.println(new StringBuilder((String.valueOf(str).length() + 14) + String.valueOf(valueOf).length()).append(str).append("mWrapperView: ").append(valueOf).toString());
        r rVar = this.unU;
        String concat = String.valueOf(str).concat("  ");
        printWriter.println(new StringBuilder(String.valueOf(concat).length() + 36).append(concat).append("mPanelPositionRatio: ").append(rVar.uoD).toString());
        printWriter.println(new StringBuilder(String.valueOf(concat).length() + 23).append(concat).append("mDownX: ").append(rVar.bdZ).toString());
        printWriter.println(new StringBuilder(String.valueOf(concat).length() + 23).append(concat).append("mDownY: ").append(rVar.bea).toString());
        printWriter.println(new StringBuilder(String.valueOf(concat).length() + 29).append(concat).append("mActivePointerId: ").append(rVar.mActivePointerId).toString());
        printWriter.println(new StringBuilder(String.valueOf(concat).length() + 24).append(concat).append("mTouchState: ").append(rVar.mTouchState).toString());
        printWriter.println(new StringBuilder(String.valueOf(concat).length() + 19).append(concat).append("mIsPanelOpen: ").append(rVar.uoI).toString());
        printWriter.println(new StringBuilder(String.valueOf(concat).length() + 20).append(concat).append("mIsPageMoving: ").append(rVar.mIsPageMoving).toString());
        printWriter.println(new StringBuilder(String.valueOf(concat).length() + 16).append(concat).append("mSettling: ").append(rVar.uoM).toString());
        printWriter.println(new StringBuilder(String.valueOf(concat).length() + 17).append(concat).append("mForceDrag: ").append(rVar.uoJ).toString());
    }

    public void Hn() {
    }

    public void onCreate(Bundle bundle) {
    }

    public void onPause() {
    }

    public void onStop() {
    }

    public void onStart() {
    }

    public void onResume() {
    }

    public Window getWindow() {
        return this.ark;
    }

    public final void setTitle(CharSequence charSequence) {
        this.ark.setTitle(charSequence);
    }

    public void onDestroy() {
    }

    public void bP(boolean z) {
    }

    public boolean Ho() {
        return false;
    }

    public void D(float f) {
    }

    public Object getSystemService(String str) {
        if (!"window".equals(str) || this.agw == null) {
            return super.getSystemService(str);
        }
        return this.agw;
    }

    public final boolean cnD() {
        return this.uob == f.OPEN_AS_DRAWER || this.uob == f.OPEN_AS_LAYER;
    }

    public final void ob(boolean z) {
        if (z) {
            this.ark.clearFlags(24);
        } else {
            this.ark.addFlags(24);
        }
    }

    public void a(f fVar) {
    }
}
