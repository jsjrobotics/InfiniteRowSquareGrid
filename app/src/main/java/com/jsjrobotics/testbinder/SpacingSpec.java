package com.jsjrobotics.testbinder;


import android.content.Context;

public class SpacingSpec {
    public final int span;
    public final int marginDp;
    private final int paddingDp;

    public SpacingSpec(int span, int marginDp, int paddingDp) {
        this.span = span;
        this.marginDp = marginDp;
        this.paddingDp = paddingDp;

    }

    public int getContentSizePx(Context context) {
        int displayArea = ViewUtils.getScreenWidthPx(context) - (2 * getMarginPx(context));
        return displayArea / span;
    }

    public int getMarginPx(Context context) {
        return (int) ViewUtils.pxFromDp(context, marginDp);
    }

    public int getPaddingPx(Context context) {
        return (int) ViewUtils.pxFromDp(context, paddingDp);
    }
}
