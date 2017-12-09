package com.diegopizzo.moviesbooks.ui;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.view.Window;
import android.view.WindowManager;

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

    public static void setPrimaryColorActionBar(final ActionBar actionBar, final int color) {
        actionBar.setBackgroundDrawable(
                new ColorDrawable(color));
    }

    public static void setPrimaryColorViewPager(final TabLayout tabLayout, final int color) {
        tabLayout.setBackgroundColor(color);
    }
}
