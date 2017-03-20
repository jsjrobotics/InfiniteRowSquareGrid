package com.jsjrobotics.testbinder;


import android.content.Context;

public class SpacingSpec {
    public final int span;
    public final int marginDp;

    public SpacingSpec(int span, int marginDp) {
        this.span = span;
        this.marginDp = marginDp;

    }

    public int getContentSizePx(Context context) {
        int displayArea = ViewUtils.getScreenWidthPx(context) - (2 * getMarginPx(context));
        return displayArea / span;
    }

    public int getMarginPx(Context context) {
        return (int) ViewUtils.pxFromDp(context, marginDp);
    }
}
