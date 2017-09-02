package com.google.android.apps.gsa.nowoverlayservice;

import android.app.Service;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
/*import com.google.android.apps.gsa.inject.a;
import com.google.android.apps.gsa.shared.util.k.e;*/
import com.google.android.libraries.gsa.d.a.d;
import com.google.android.libraries.gsa.d.a.k;
import com.google.android.libraries.gsa.d.a.v;
import javax.annotation.Nullable;

public final class an extends k {
    /*@Inject
    public e bOJ;*/
    /*@Inject
    public az dAF;*/
    public final Context mContext;

    public an(Service service) {
        super(service);
        this.mContext = service;
        //((ao) a.a(service.getApplicationContext(), ao.class)).a(this);
    }

    //Todo: was protected
    public final boolean Hw() {
        return true;//this.bOJ.getBoolean("GSAPrefs.should_show_now_cards", false);
    }

    //Todo: was protected
    public final boolean bQ(boolean z) {
        if ((!z || true/*this.bOJ.getBoolean("GSAPrefs.pixel_apps_search_landscape_supported", false)*/) && Hy()) {
            return true;
        }
        return false;
    }

    //Todo: was protected
    public final int Hx() {
        if (!Hy()) {
            return 0;
        }
        if (true/*this.bOJ.getBoolean("GSAPrefs.pixel_apps_search_landscape_supported", false*/) {
            return 24;
        }
        return 8;
    }

    private final boolean Hy() {
        if (/*this.bOJ.getBoolean("GSAPrefs.pixel_apps_search_enabled", false)*/ true && true/*this.bOJ.getBoolean("GSAPrefs.use_search_overlay_for_launcher_client", false)*/ && true/*this.bOJ.getBoolean("GSAPrefs.nom_on_pixel_enabled", false)*/) {
            return true;
        }
        return false;
    }

    public final d a(@Nullable Configuration configuration, int i, int i2, boolean z, boolean z2) {
        Context context = this.mContext;
        if (VERSION.SDK_INT >= 17 && configuration != null) {
            context = context.createConfigurationContext(configuration);
        }
        return new x(context, i, i2, z, z2);
    }

    //Todo: was protected
    public final com.google.android.libraries.gsa.d.a.a Hz() {
        return new ce(this.mContext);
    }

    //Todo: was protected, and return modified
    public final /* synthetic */ v HA() {
        return new v();//this.dAF;
    }
}
