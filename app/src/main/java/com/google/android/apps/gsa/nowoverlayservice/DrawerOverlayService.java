package com.google.android.apps.gsa.nowoverlayservice;

import android.content.Intent;
import android.os.IBinder;
import com.google.android.apps.gsa.shared.t.b;
import com.google.android.libraries.gsa.d.a.k;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class DrawerOverlayService extends b {
    public k dzU;

    public void onCreate() {
        super.onCreate();
        this.dzU = new an(this);
    }

    public void onDestroy() {
        this.dzU.onDestroy();
        super.onDestroy();
    }

    public IBinder onBind(Intent intent) {
        return this.dzU.onBind(intent);
    }

    public boolean onUnbind(Intent intent) {
        this.dzU.bR(intent);
        return false;
    }

    protected void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.dzU.a(printWriter);
    }
}
