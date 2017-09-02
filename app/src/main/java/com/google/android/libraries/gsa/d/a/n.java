package com.google.android.libraries.gsa.d.a;

import android.content.ComponentName;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.google.android.libraries.material.progress.u;
import java.io.PrintWriter;

abstract class n extends m {
    public final p uon;
    public final int uor;
    public d uos;

    abstract d c(Configuration configuration);

    public n(p pVar, int i) {
        this.uon = pVar;
        this.uor = i;
    }

    public boolean handleMessage(Message message) {
        boolean z = false;
        d dVar;
        switch (message.what) {
            case 0:
                if (message.arg1 == 0) {
                    return true;
                }
                d dVar2;
                Bundle bundle;
                if (this.uos != null) {
                    dVar2 = this.uos;
                    Bundle bundle2 = new Bundle();
                    if (dVar2.uob == f.OPEN_AS_DRAWER) {//Todo: f.uog was default
                        bundle2.putBoolean("open", true);
                    }
                    bundle2.putParcelable("view_state", dVar2.ark.saveHierarchyState());
                    this.uos.cnC();
                    this.uos = null;
                    bundle = bundle2;
                } else {
                    bundle = null;
                }
                Pair pair = (Pair) message.obj;
                LayoutParams layoutParams = (LayoutParams) ((Bundle) pair.first).getParcelable("layout_params");
                this.uos = c((Configuration) ((Bundle) pair.first).getParcelable("configuration"));
                try {
                    int i;
                    d dVar3 = this.uos;
                    String str = this.uon.mPackageName;
                    Bundle bundle3 = (Bundle) pair.first;
                    dVar3.mIsRtl = r.isRtl(dVar3.getResources());
                    dVar3.unT = str;
                    dVar3.ark.setWindowManager(null, layoutParams.token, new ComponentName(dVar3, dVar3.getBaseContext().getClass()).flattenToShortString(), true);
                    dVar3.agw = dVar3.ark.getWindowManager();
                    Point point = new Point();
                    dVar3.agw.getDefaultDisplay().getRealSize(point);
                    dVar3.unO = -Math.max(point.x, point.y);
                    dVar3.unU = new j(dVar3);
                    dVar3.unW = new FrameLayout(dVar3);
                    dVar3.unU.el(dVar3.unW);
                    dVar3.unU.uoH = dVar3.unV;
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    layoutParams.flags |= 8650752;
                    layoutParams.dimAmount = 0.0f;
                    layoutParams.gravity = 3;
                    if (VERSION.SDK_INT >= 25) {
                        i = 4;
                    } else {
                        i = 2;
                    }
                    layoutParams.type = i;
                    layoutParams.softInputMode = 16;
                    dVar3.ark.setAttributes(layoutParams);
                    dVar3.ark.clearFlags(1048576);
                    dVar3.onCreate(bundle3);
                    dVar3.ark.setContentView(dVar3.unU);
                    dVar3.unS = dVar3.ark.getDecorView();
                    dVar3.agw.addView(dVar3.unS, dVar3.ark.getAttributes());
                    dVar3.unU.setSystemUiVisibility(1792);
                    dVar3.ob(false);
                    dVar3.ark.getDecorView().addOnLayoutChangeListener(new e(dVar3));
                    if (bundle != null) {
                        dVar = this.uos;
                        dVar.ark.restoreHierarchyState(bundle.getBundle("view_state"));
                        if (bundle.getBoolean("open")) {
                            r rVar = dVar.unU;
                            rVar.uoD = 1.0f;
                            rVar.uoC = rVar.getMeasuredWidth();
                            rVar.uoA.setTranslationX(rVar.mIsRtl ? (float) (-rVar.uoC) : (float) rVar.uoC);
                            rVar.cnF();
                            rVar.cnG();
                        }
                    }
                    dVar2 = this.uos;
                    dVar2.uoa = (com.google.android.libraries.i.d) pair.second;
                    dVar2.bP(true);
                    this.uon.a((com.google.android.libraries.i.d) pair.second, this.uor);
                    return true;
                } catch (Throwable e) {
                    Log.d("OverlaySController", "Error creating overlay window", e);
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    handleMessage(obtain);
                    obtain.recycle();
                    return true;
                }
            case 1:
                if (this.uos == null) {
                    return true;
                }
                this.uos.BJ(((Integer) message.obj).intValue());
                return true;
            case 2:
                if (this.uos == null) {
                    return true;
                }
                com.google.android.libraries.i.d cnC = this.uos.cnC();
                this.uos = null;
                if (message.arg1 != 0) {
                    return true;
                }
                this.uon.a(cnC, 0);
                return true;
            case u.uKQ /*6*/:
                if (this.uos == null) {
                    return true;
                }
                int i2 = message.arg2 & 1;
                if (message.arg1 == 1) {
                    this.uos.BK(i2);
                    return true;
                }
                this.uos.fI(i2);
                return true;
            case u.uKR /*7*/:
                if (this.uos == null) {
                    return true;
                }
                dVar = this.uos;
                if (message.arg1 == 1) {
                    z = true;
                }
                dVar.bP(z);
                return true;
            case 8:
                if (this.uos == null) {
                    return true;
                }
                this.uos.a((h) message.obj);
                return true;
            default:
                return false;
        }
    }

    public void a(PrintWriter printWriter, String str) {
        d dVar = this.uos;
        String valueOf = String.valueOf(dVar);
        printWriter.println(new StringBuilder((String.valueOf(str).length() + 8) + String.valueOf(valueOf).length()).append(str).append(" mView: ").append(valueOf).toString());
        if (dVar != null) {
            dVar.a(printWriter, String.valueOf(str).concat("  "));
        }
    }
}
