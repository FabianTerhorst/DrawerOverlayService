package com.google.android.libraries.gsa.d.a;

import android.content.res.Configuration;
import android.os.Message;
import android.util.Log;
import java.io.PrintWriter;

public final class q extends n {
    public final /* synthetic */ k uoq;

    public q(k kVar, p pVar) {
        super(pVar, 2);
        this.uoq = kVar;
    }

    public final void a(PrintWriter printWriter, String str) {
        printWriter.println(String.valueOf(str).concat("SearchOverlayCallback"));
        super.a(printWriter, str);
    }

    final d c(Configuration configuration) {
        return this.uoq.a(configuration, this.uon.uou, this.uon.uov, false, true);
    }

    public final boolean handleMessage(Message message) {
        if (message.what != 6 || message.arg1 != 1) {
            return super.handleMessage(message);
        }
        Log.d("OverlaySController", "Directly opening overlay is not allowed for search mode");
        return true;
    }
}
