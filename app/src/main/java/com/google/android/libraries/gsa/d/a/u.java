package com.google.android.libraries.gsa.d.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Log;
import android.view.animation.Interpolator;

final class u extends AnimatorListenerAdapter implements Interpolator {
    public ObjectAnimator mAnimator;
    public int mFinalX;
    public final r uoO;

    public u(r rVar) {
        this.uoO = rVar;
    }

    public final void cnP() {
        if (this.mAnimator != null) {
            this.mAnimator.removeAllListeners();
            this.mAnimator.cancel();
        }
    }

    public final void dt(int i, int i2) {
        cnP();
        this.mFinalX = i;
        if (i2 > 0) {
            this.mAnimator = ObjectAnimator.ofInt(this.uoO, r.uoz, new int[]{i}).setDuration((long) i2);
            this.mAnimator.setInterpolator(this);
            this.mAnimator.addListener(this);
            this.mAnimator.start();
            return;
        }
        onAnimationEnd(null);
    }

    public final boolean isFinished() {
        return this.mAnimator == null;
    }

    public final void onAnimationEnd(Animator animator) {
        this.mAnimator = null;
        this.uoO.BM(this.mFinalX);
        r rVar = this.uoO;
        if (rVar.uoM) {
            rVar.uoM = false;
            if (rVar.uoC == 0) {
                if (r.DEBUG) {
                    Log.d("wo.SlidingPanelLayout", "onPanelClosed");
                }
                rVar.cnO();
                rVar.uoI = false;
                rVar.mIsPageMoving = false;
                if (rVar.uoH != null) {
                    rVar.uoH.cnH();
                }
            } else if (rVar.uoC == rVar.getMeasuredWidth()) {
                rVar.cnG();
            }
        }
    }

    public final float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
    }
}
