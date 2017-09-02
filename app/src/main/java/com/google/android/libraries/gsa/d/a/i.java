package com.google.android.libraries.gsa.d.a;

import android.os.Build;
import android.util.Log;
import android.view.WindowManager.LayoutParams;

final class i implements t {
    public final /* synthetic */ d uod;

    i(d dVar) {
        this.uod = dVar;
    }

    public final void cnE() {
        Log.d("wo.OverlayController", "Drag event called in transparent mode");
    }

    public final void cnF() {
    }

    public final void oc(boolean z) {
    }

    public final void cnG() {
        this.uod.ob(true);
        d dVar = this.uod;
        LayoutParams attributes = dVar.ark.getAttributes();
        if (Build.VERSION.SDK_INT >= 26) {
            float f = attributes.alpha;
            attributes.alpha = 1.0f;
            if (f != attributes.alpha) {
                dVar.ark.setAttributes(attributes);
            }
        } else {
            attributes.x = 0;
            attributes.flags &= -513;
            dVar.unZ = true;
            dVar.ark.setAttributes(attributes);
        }
        dVar = this.uod;
        f fVar = f.OPEN_AS_LAYER;//Todo: f.uoh was default
        if (dVar.uob != fVar) {
            dVar.uob = fVar;
            dVar.a(dVar.uob);
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
        this.uod.ob(false);
        dVar = this.uod;
        f fVar = f.CLOSED;//Todo: f.uoe was default
        if (dVar.uob != fVar) {
            dVar.uob = fVar;
            dVar.a(dVar.uob);
        }
        this.uod.unU.uoH = this.uod.unV;
    }

    public final void D(float f) {
    }

    public final boolean cnI() {
        return true;
    }
}
