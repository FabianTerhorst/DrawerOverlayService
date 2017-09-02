package com.google.android.apps.gsa.nowoverlayservice;

import android.content.Context;
/*import com.google.android.apps.gsa.search.shared.service.ClientConfig;
import com.google.android.apps.gsa.search.shared.service.ClientConfig.Builder;
import com.google.android.apps.gsa.search.shared.service.SearchServiceClient;
import com.google.android.apps.gsa.shared.config.ConfigFlags;
import com.google.android.apps.gsa.shared.logger.g;
import com.google.android.apps.gsa.shared.util.concurrent.TaskRunnerUi;*/
import com.google.android.libraries.gsa.d.a.a;
/*import dagger.Lazy;
import javax.inject.Inject;*/

public final class ce extends a {
    /*@Inject
    public TaskRunnerUi bVa;
    @Inject
    public Lazy cah;*/
    public boolean dDq = false;
    public boolean dDr = false;
    //public final SearchServiceClient dlN;

    public ce(Context context) {
        /*Builder builder = new Builder();
        builder.hnr = 35184372121601L;
        ClientConfig build = builder.setClientId("searchapiservice").build();
        ((cg) com.google.android.apps.gsa.inject.a.a(context.getApplicationContext(), cg.class)).a(this);
        cf cfVar = new cf(context);
        this.dlN = new SearchServiceClient(context, cfVar, cfVar, build, this.bVa);*/
    }

    public final void k(boolean z, boolean z2) {
        this.dDr = z2;
        if (!this.dDq) {
            if (this.dDr) {
                //g.ma(906);
                //this.dlN.connect();
                //this.dlN.jH(0);
                this.dDq = true;
            } else if (z/* && ((ConfigFlags) this.cah.get()).getBoolean(2328)*/) {
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
