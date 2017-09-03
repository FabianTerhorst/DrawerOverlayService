package com.google.android.apps.gsa.nowoverlayservice;

import android.content.Context;
import com.google.android.libraries.gsa.d.a.IServiceHolder;


public final class ServiceHolder extends IServiceHolder {

    public boolean dDq = false;
    public boolean dDr = false;

    public ServiceHolder(Context context) {
    }

    public final void k(boolean z, boolean z2) {
        this.dDr = z2;
        if (!this.dDq) {
            if (this.dDr) {
                //g.ma(906);
                //this.dlN.connect();
                //this.dlN.jH(0);
                this.dDq = true;
            } else if (z) {
                /*g.ma(905);
                this.dlN.connect();
                this.dlN.jH(2);*/
                this.dDq = true;
            }
        }
    }

    public final void disconnect() {
        if (this.dDq) {
            /*this.dlN.eG(false);
            this.dlN.disconnect();*/
            this.dDq = false;
        }
    }

    public final void bV(boolean z) {
        if (this.dDr && this.dDq) {
            //this.dlN.bV(z);
        }
    }
}
