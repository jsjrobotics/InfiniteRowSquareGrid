package com.jsjrobotics.testbinder.spacingSpecRecycler;


import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

class ViewUtils {

    static int getScreenWidthPx(Context context) {
        return getDisplayMetrics(context).widthPixels;
    }

    public static int getScreenHeightPx(Context context) {
        return getDisplayMetrics(context).heightPixels;
    }

    private static DisplayMetrics getDisplayMetrics(Context context) {
        final DisplayMetrics metrics = new DisplayMetrics();
        final WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        windowManager.getDefaultDisplay().getMetrics(metrics);
        return metrics;
    }

    static float pxFromDp(final Context context, final float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }
}
