package com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.data;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;

import java.lang.reflect.Field;

/**
 * Author:111
 * Time:2017/9/18
 * Motto: where my heart get peace,where my self get home.
 */
public class MyTabLayout extends TabLayout {
    private static final int TabViewNumber = 4;
    private static final String SCROLLABLE_TAB_MIN_WIDTH = "mScrollableTabMinWidth";
    public MyTabLayout(Context context) {
        super(context);
        initTabMinWidth();
    }

    public MyTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initTabMinWidth();
    }

    public MyTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initTabMinWidth();
    }
    private void initTabMinWidth() {
        int screenWidth=getResources().getDisplayMetrics().widthPixels;
        int tabMinWidth = screenWidth / TabViewNumber;

        Field field;
        try {
            field = TabLayout.class.getDeclaredField(SCROLLABLE_TAB_MIN_WIDTH);
            field.setAccessible(true);
            field.set(this, tabMinWidth);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
