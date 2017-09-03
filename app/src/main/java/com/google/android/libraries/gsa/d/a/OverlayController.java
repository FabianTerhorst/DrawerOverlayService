package com.google.android.libraries.gsa.d.a;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.FrameLayout;
import java.io.PrintWriter;

public class OverlayController extends DialogOverlayController {

    public boolean mIsRtl;
    public long obZ = 0;
    public int unO;
    public String unT;
    public SlidingPanelLayout slidingPanelLayout;
    public t unV = new g(this);
    public FrameLayout unW;
    public int unX = 0;
    public boolean unY = false;
    public boolean unZ = true;
    public com.google.android.libraries.i.d uoa;
    public PanelState panelState = PanelState.CLOSED;
    public int uoc = 0;

    public OverlayController(Context context, int i, int i2) {
        super(context, i, i2);
    }

    final void b(int i, int i2, long j) {
        MotionEvent obtain = MotionEvent.obtain(this.obZ, j, i, this.mIsRtl ? (float) (-i2) : (float) i2, 0.0f, 0);
        obtain.setSource(4098);
        this.slidingPanelLayout.dispatchTouchEvent(obtain);
        obtain.recycle();
    }

    final com.google.android.libraries.i.d cnC() {
        BJ(0);
        try {
            this.windowManager.removeView(this.unS);
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
            if (this.panelState == PanelState.OPEN_AS_LAYER) {
                i2 = 0;
            }
            i4 &= i2;
            SlidingPanelLayout slidingPanelLayoutVar = this.slidingPanelLayout;
            if (i4 != 0) {
                i3 = 750;
            }
            slidingPanelLayoutVar.closePanel(i3);
            cnB();
        }
    }

    public final void BK(int i) {
        int i2 = 0;
        if (this.panelState == PanelState.CLOSED) {
            int i3 = (i & 1) != 0 ? 1 : 0;
            if ((i & 2) != 0) {
                this.slidingPanelLayout.uoH = new TransparentOverlayController(this);
                i3 = 0;
            }
            SlidingPanelLayout slidingPanelLayoutVar = this.slidingPanelLayout;
            if (i3 != 0) {
                i2 = 750;
            }
            slidingPanelLayoutVar.fv(i2);
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
        String valueOf = String.valueOf(this.panelState);
        printWriter.println(new StringBuilder((String.valueOf(str).length() + 14) + String.valueOf(valueOf).length()).append(str).append("mDrawerState: ").append(valueOf).toString());
        printWriter.println(new StringBuilder(String.valueOf(str).length() + 32).append(str).append("mActivityStateFlags: ").append(this.uoc).toString());
        valueOf = String.valueOf(this.slidingPanelLayout);
        printWriter.println(new StringBuilder((String.valueOf(str).length() + 14) + String.valueOf(valueOf).length()).append(str).append("mWrapperView: ").append(valueOf).toString());
        SlidingPanelLayout slidingPanelLayoutVar = this.slidingPanelLayout;
        String concat = String.valueOf(str).concat("  ");
        printWriter.println(new StringBuilder(String.valueOf(concat).length() + 36).append(concat).append("mPanelPositionRatio: ").append(slidingPanelLayoutVar.uoD).toString());
        printWriter.println(new StringBuilder(String.valueOf(concat).length() + 23).append(concat).append("mDownX: ").append(slidingPanelLayoutVar.bdZ).toString());
        printWriter.println(new StringBuilder(String.valueOf(concat).length() + 23).append(concat).append("mDownY: ").append(slidingPanelLayoutVar.bea).toString());
        printWriter.println(new StringBuilder(String.valueOf(concat).length() + 29).append(concat).append("mActivePointerId: ").append(slidingPanelLayoutVar.mActivePointerId).toString());
        printWriter.println(new StringBuilder(String.valueOf(concat).length() + 24).append(concat).append("mTouchState: ").append(slidingPanelLayoutVar.mTouchState).toString());
        printWriter.println(new StringBuilder(String.valueOf(concat).length() + 19).append(concat).append("mIsPanelOpen: ").append(slidingPanelLayoutVar.uoI).toString());
        printWriter.println(new StringBuilder(String.valueOf(concat).length() + 20).append(concat).append("mIsPageMoving: ").append(slidingPanelLayoutVar.mIsPageMoving).toString());
        printWriter.println(new StringBuilder(String.valueOf(concat).length() + 16).append(concat).append("mSettling: ").append(slidingPanelLayoutVar.uoM).toString());
        printWriter.println(new StringBuilder(String.valueOf(concat).length() + 17).append(concat).append("mForceDrag: ").append(slidingPanelLayoutVar.uoJ).toString());
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
        return this.window;
    }

    public final void setTitle(CharSequence charSequence) {
        this.window.setTitle(charSequence);
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
        if (!"window".equals(str) || this.windowManager == null) {
            return super.getSystemService(str);
        }
        return this.windowManager;
    }

    public final boolean cnD() {
        return this.panelState == PanelState.OPEN_AS_DRAWER || this.panelState == PanelState.OPEN_AS_LAYER;
    }

    public final void ob(boolean z) {
        if (z) {
            this.window.clearFlags(24);
        } else {
            this.window.addFlags(24);
        }
    }

    public void a(PanelState panelStateVar) {
    }
}
