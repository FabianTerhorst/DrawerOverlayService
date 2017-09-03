package com.google.android.libraries.gsa.d.a;

import android.content.res.Configuration;
import android.os.Message;

import com.google.android.libraries.material.progress.u;

import java.io.PrintWriter;

public final class MinusOneOverlayCallback extends OverlayControllerCallback {

    public final OverlaysController overlaysController;

    public MinusOneOverlayCallback(OverlaysController overlaysControllerVar, OverlayControllerBinder overlayControllerBinderVar) {
        super(overlayControllerBinderVar, 3);
        this.overlaysController = overlaysControllerVar;
    }

    final OverlayController c(Configuration configuration) {
        return this.overlaysController.createController(configuration, this.overlayControllerBinder.uou, this.overlayControllerBinder.uov, true, true);
    }

    public final void a(PrintWriter printWriter, String str) {
        printWriter.println(String.valueOf(str).concat("MinusOneOverlayCallback"));
        super.a(printWriter, str);
    }

    public final boolean handleMessage(Message message) {
        if (super.handleMessage(message)) {
            return true;
        }
        OverlayController overlayControllerVar;
        long when;
        switch (message.what) {
            case 3:
                if (this.overlayController != null) {
                    overlayControllerVar = this.overlayController;
                    when = message.getWhen();
                    if (!overlayControllerVar.cnD()) {
                        SlidingPanelLayout slidingPanelLayoutVar = overlayControllerVar.slidingPanelLayout;
                        if (slidingPanelLayoutVar.uoC < slidingPanelLayoutVar.mTouchSlop) {
                            overlayControllerVar.slidingPanelLayout.BM(0);
                            overlayControllerVar.unY = true;
                            overlayControllerVar.unX = 0;
                            overlayControllerVar.slidingPanelLayout.uoJ = true;
                            overlayControllerVar.obZ = when - 30;
                            overlayControllerVar.b(0, overlayControllerVar.unX, overlayControllerVar.obZ);
                            overlayControllerVar.b(2, overlayControllerVar.unX, when);
                        }
                    }
                }
                return true;
            case u.uKO /*4*/:
                if (this.overlayController != null) {
                    overlayControllerVar = this.overlayController;
                    float floatValue = (float) message.obj;
                    when = message.getWhen();
                    if (overlayControllerVar.unY) {
                        overlayControllerVar.unX = (int) (floatValue * ((float) overlayControllerVar.slidingPanelLayout.getMeasuredWidth()));
                        overlayControllerVar.b(2, overlayControllerVar.unX, when);
                    }
                }
                return true;
            case u.uKS /*5*/:
                if (this.overlayController != null) {
                    overlayControllerVar = this.overlayController;
                    when = message.getWhen();
                    if (overlayControllerVar.unY) {
                        overlayControllerVar.b(1, overlayControllerVar.unX, when);
                    }
                    overlayControllerVar.unY = false;
                }
                return true;
            default:
                return false;
        }
    }
}
