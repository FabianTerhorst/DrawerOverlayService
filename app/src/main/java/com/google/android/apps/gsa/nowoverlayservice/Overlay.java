package com.google.android.apps.gsa.nowoverlayservice;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.libraries.gsa.d.a.OverlayController;

import io.fabianterhorst.launcheroverlay.R;

public class Overlay extends OverlayController {

    private final Context context;

    public Overlay(Context context, int i, int i2) {
        super(context, R.style.AppTheme, R.style.Theme_SearchNow);
        this.context = context;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.container.setFitsSystemWindows(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        View rowView = LayoutInflater.from(context).inflate(R.layout.activity_second, this.container, true);
        TextView textView = rowView.findViewById(R.id.textView);
        textView.setText("Hello Window");
    }
}
