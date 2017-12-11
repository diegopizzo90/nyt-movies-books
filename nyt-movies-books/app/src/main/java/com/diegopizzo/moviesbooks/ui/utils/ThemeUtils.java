package com.diegopizzo.moviesbooks.ui.utils;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by diegopizzo on 09/12/2017.
 */

public class ThemeUtils {

    public static void setStatusBarColor(final int color, final Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            final Window window = activity.getWindow();
            if (color == Color.BLACK && window.getNavigationBarColor() == Color.BLACK) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            } else {
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            }
            window.setStatusBarColor(color);
        }
    }

    public static void setPrimaryColorAppBar(final AppBarLayout appBarLayout, final int color) {
        appBarLayout.setBackgroundColor(color);
    }

    public static void setColorsButton(final Button button, final int colorPrimary, final int colorPrimaryDark) {
        button.setHighlightColor(colorPrimaryDark);
        button.setBackgroundResource(colorPrimary);
    }
}
