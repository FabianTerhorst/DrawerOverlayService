package com.google.android.apps.gsa.nowoverlayservice;

import android.app.Service;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;

import com.google.android.libraries.gsa.d.a.OverlayController;
import com.google.android.libraries.gsa.d.a.OverlaysController;
import com.google.android.libraries.gsa.d.a.v;
import javax.annotation.Nullable;

public final class ConfigurationOverlayController extends OverlaysController {

    private final Context mContext;

    public ConfigurationOverlayController(Service service) {
        super(service);
        this.mContext = service;
    }

    //Todo: was protected
    public final int Hx() {
        return 24;
    }

    public final OverlayController createController(@Nullable Configuration configuration, int i, int i2) {
        Context context = this.mContext;
        if (VERSION.SDK_INT >= 17 && configuration != null) {
            context = context.createConfigurationContext(configuration);
        }
        return new Overlay(context, i, i2);
    }

    //Todo: was protected, and return modified
    public final v HA() {
        return new v();
    }
}
