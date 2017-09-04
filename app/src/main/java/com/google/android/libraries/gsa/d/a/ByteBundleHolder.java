package com.google.android.libraries.gsa.d.a;

import android.os.Bundle;

public final class ByteBundleHolder {

    public final Bundle extras;
    public final byte[] bytes;

    public ByteBundleHolder(byte[] bArr, Bundle bundle) {
        this.bytes = bArr;
        this.extras = bundle;
    }
}
