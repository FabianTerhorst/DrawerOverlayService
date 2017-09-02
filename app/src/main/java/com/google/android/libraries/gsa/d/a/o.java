package com.google.android.libraries.gsa.d.a;

import android.content.res.Configuration;
import android.os.Message;
import com.google.android.libraries.material.progress.u;
import java.io.PrintWriter;

public final class o extends n {
    public final /* synthetic */ k uoq;

    public o(k kVar, p pVar) {
        super(pVar, 3);
        this.uoq = kVar;
    }

    final d c(Configuration configuration) {
        return this.uoq.a(configuration, this.uon.uou, this.uon.uov, true, this.uoq.bQ(false));
    }

    public final void a(PrintWriter printWriter, String str) {
        printWriter.println(String.valueOf(str).concat("MinusOneOverlayCallback"));
        super.a(printWriter, str);
    }

    public final boolean handleMessage(Message message) {
        if (super.handleMessage(message)) {
            return true;
        }
        d dVar;
        long when;
        switch (message.what) {
            case 3:
                if (this.uos != null) {
                    dVar = this.uos;
                    when = message.getWhen();
                    if (!dVar.cnD()) {
                        r rVar = dVar.unU;
                        if (rVar.uoC < rVar.mTouchSlop) {
                            dVar.unU.BM(0);
                            dVar.unY = true;
                            dVar.unX = 0;
                            dVar.unU.uoJ = true;
                            dVar.obZ = when - 30;
                            dVar.b(0, dVar.unX, dVar.obZ);
                            dVar.b(2, dVar.unX, when);
                        }
                    }
                }
                return true;
            case u.uKO /*4*/:
                if (this.uos != null) {
                    dVar = this.uos;
                    float floatValue = ((Float) message.obj).floatValue();
                    when = message.getWhen();
                    if (dVar.unY) {
                        dVar.unX = (int) (floatValue * ((float) dVar.unU.getMeasuredWidth()));
                        dVar.b(2, dVar.unX, when);
                    }
                }
                return true;
            case u.uKS /*5*/:
                if (this.uos != null) {
                    dVar = this.uos;
                    when = message.getWhen();
                    if (dVar.unY) {
                        dVar.b(1, dVar.unX, when);
                    }
                    dVar.unY = false;
                }
                return true;
            default:
                return false;
        }
    }
}
