package com.google.android.libraries.gsa.d.a;

import android.os.Build;
import android.util.Log;
import android.view.WindowManager.LayoutParams;

final class g implements t {
    public final /* synthetic */ d uod;

    g(d dVar) {
        this.uod = dVar;
    }

    public final void cnE() {
        d dVar = this.uod;
        f fVar = f.DRAGGING;//Todo: f.uof was default
        if (dVar.uob != fVar) {
            dVar.uob = fVar;
            dVar.a(dVar.uob);
        }
        dVar = this.uod;
        LayoutParams attributes = dVar.ark.getAttributes();
        if (Build.VERSION.SDK_INT >= 26) {
            float f = attributes.alpha;
            attributes.alpha = 1.0f;
            if (f != attributes.alpha) {
                dVar.ark.setAttributes(attributes);
                return;
            }
            return;
        }
        attributes.x = 0;
        attributes.flags &= -513;
        dVar.unZ = true;
        dVar.ark.setAttributes(attributes);
    }

    public final void cnF() {
        d dVar = this.uod;
        f fVar = f.DRAGGING;//Todo: f.uof was default
        if (dVar.uob != fVar) {
            dVar.uob = fVar;
            dVar.a(dVar.uob);
        }
        this.uod.ob(true);
        dVar = this.uod;
        LayoutParams attributes = dVar.ark.getAttributes();
        if (Build.VERSION.SDK_INT >= 26) {
            float f = attributes.alpha;
            attributes.alpha = 1.0f;
            if (f != attributes.alpha) {
                dVar.ark.setAttributes(attributes);
                return;
            }
            return;
        }
        attributes.x = 0;
        attributes.flags &= -513;
        dVar.unZ = true;
        dVar.ark.setAttributes(attributes);
    }

    public final void oc(boolean z) {
        if (z) {
            this.uod.Hn();
        }
        d dVar = this.uod;
        f fVar = f.DRAGGING;//Todo: f.uof was default
        if (dVar.uob != fVar) {
            dVar.uob = fVar;
            dVar.a(dVar.uob);
        }
        this.uod.ob(false);
    }

    public final void cnG() {
        d dVar = this.uod;
        f fVar = f.OPEN_AS_DRAWER;//Todo: f.uog was default
        if (dVar.uob != fVar) {
            dVar.uob = fVar;
            dVar.a(dVar.uob);
        }
    }

    public final void D(float f) {
        if (this.uod.uoa != null && !Float.isNaN(f)) {
            try {
                this.uod.uoa.aK(f);
                this.uod.D(f);
            } catch (Throwable e) {
                Log.e("wo.OverlayController", "Error notfying client", e);
            }
        }
    }

    public final void cnH() {
        d dVar = this.uod;
        LayoutParams attributes = dVar.ark.getAttributes();
        if (Build.VERSION.SDK_INT >= 26) {
            float f = attributes.alpha;
            attributes.alpha = 0.0f;
            if (f != attributes.alpha) {
                dVar.ark.setAttributes(attributes);
            }
        } else {
            attributes.x = dVar.unO;
            attributes.flags |= 512;
            dVar.unZ = false;
            dVar.ark.setAttributes(attributes);
        }
        dVar = this.uod;
        f fVar = f.CLOSED;//Todo: f.uoe was default
        if (dVar.uob != fVar) {
            dVar.uob = fVar;
            dVar.a(dVar.uob);
        }
    }

    public final boolean cnI() {
        return this.uod.Ho();
    }
}
