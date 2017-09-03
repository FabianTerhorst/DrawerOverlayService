package com.google.android.apps.gsa.nowoverlayservice;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.apps.gsa.shared.ui.FitsSystemWindowsNotifierFrameLayout;
import com.google.android.libraries.gsa.d.a.d;

import io.fabianterhorst.launcheroverlay.R;

public class x extends d/* implements dy, a*/ {

    private final Context context;

    public x(Context context, int i, int i2, boolean z, boolean z2) {
        super(context, R.style.AppTheme, R.style.AppTheme2);
        this.context = context;
        /*this.mContext = context;
        this.dzV = i;
        this.dzW = i2;
        this.dAw = z;
        this.dAx = z2;*/
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TextView textView = new TextView(context);
        textView.setText("Hello Window");
        ViewGroup fitsSystemWindowsNotifierFrameLayout = new FitsSystemWindowsNotifierFrameLayout(this);
        fitsSystemWindowsNotifierFrameLayout.addView(textView);
        this.unW.addView(fitsSystemWindowsNotifierFrameLayout);
        this.unW.setBackgroundColor(Color.WHITE);
        //this.unW.addView(fitsSystemWindowsNotifierFrameLayout);
    }
}
