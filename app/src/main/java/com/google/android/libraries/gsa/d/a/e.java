package com.google.android.libraries.gsa.d.a;

import android.os.Build;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.WindowManager.LayoutParams;

final class e implements OnLayoutChangeListener {
    public final /* synthetic */ d uod;

    e(d dVar) {
        this.uod = dVar;
    }

    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.uod.ark.getDecorView().removeOnLayoutChangeListener(this);
        if (this.uod.uob == f.CLOSED) {//Todo: f.uoe was default
            d dVar = this.uod;
            LayoutParams attributes = dVar.ark.getAttributes();
            if (Build.VERSION.SDK_INT >= 26) {
                float f = attributes.alpha;
                attributes.alpha = 0.0f;
                if (f != attributes.alpha) {
                    dVar.ark.setAttributes(attributes);
                    return;
                }
                return;
            }
            attributes.x = dVar.unO;
            attributes.flags |= 512;
            dVar.unZ = false;
            dVar.ark.setAttributes(attributes);
        }
    }
}
