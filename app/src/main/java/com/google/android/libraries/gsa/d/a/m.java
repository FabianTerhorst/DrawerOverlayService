package com.google.android.libraries.gsa.d.a;

import android.os.Handler.Callback;
import android.os.Message;
import java.io.PrintWriter;

class m implements Callback {
    m() {
    }

    public boolean handleMessage(Message message) {
        return true;
    }

    public void a(PrintWriter printWriter, String str) {
        printWriter.println(String.valueOf(str).concat("BaseCallback: nothing to dump"));
    }
}
