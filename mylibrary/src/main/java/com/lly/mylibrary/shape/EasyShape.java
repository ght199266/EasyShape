package com.lly.mylibrary.shape;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorInt;
import android.view.View;

/**
 * EasyShape[v 1.0.0]
 * classes:com.lly.easyshape.shape.EasyShape
 *
 * @author lileiyi
 * @date 2019/4/24
 * @time 10:40
 * @description
 */
public class EasyShape {

    //上下文对象
    private Context mContext;

    private EasyShapeParams P;

    /**
     * 设置边框
     *
     * @param width 宽
     * @param color 颜色
     */
    public EasyShape setStroke(int width, @ColorInt int color) {
        P.mStrokeWidth = dip2px(width);
        P.mStrokeColor = color;
        return this;
    }

    public EasyShape with(Context context) {
        this.mContext = context;
        P = new EasyShapeParams();
        return this;
    }


    public EasyShape setStateColor(ColorStateList colorStateList) {
        P.mColorStateList = colorStateList;
        return this;
    }

    public EasyShape setStateColor(@ColorInt int defaultColor, @ColorInt int pressedColor) {
        int[] colors = new int[]{pressedColor, Color.YELLOW, defaultColor, Color.CYAN, Color.BLUE, Color.GREEN};
        int[][] states = new int[6][];
        states[0] = new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled};
        states[1] = new int[]{android.R.attr.state_enabled, android.R.attr.state_focused};
        states[2] = new int[]{android.R.attr.state_enabled};
        states[3] = new int[]{android.R.attr.state_focused};
        states[4] = new int[]{android.R.attr.state_window_focused};
        states[5] = new int[]{};
        P.mColorStateList = new ColorStateList(states, colors);
        return this;
    }


    public EasyShape setColor(@ColorInt int argb) {
        P.mColor = argb;
        return this;
    }

    public EasyShape setRadius(int radius) {
        P.mRadius = dip2px(radius);
        return this;
    }


    /**
     * 设置虚线的
     *
     * @param strokeWidth //线宽度
     * @param color       // 线颜色
     * @param lineWidth   //虚线长度
     * @param lineGap     //虚线之间的间隔
     * @return
     */
    public EasyShape setLineParams(int strokeWidth, int color, int lineWidth, int lineGap) {
        P.mStrokeWidth = dip2px(strokeWidth);
        P.mStrokeColor = color;
        P.dashWidth = dip2px(lineWidth);
        P.dashGap = dip2px(lineGap);
        return this;
    }


    public EasyShape setDashWidth(int dashWidth) {
        P.dashWidth = dashWidth;
        return this;
    }

    public EasyShape setdashGap(int dashGap) {
        P.dashGap = dashGap;
        return this;
    }

    /**
     * 设置圆角（左上右下）
     */
    public EasyShape setRadius(int leftTop, int rightTop, int leftBottom, int rightBottom) {
        P.mfloatRadius = getCornerRadii(leftTop, rightTop, leftBottom, rightBottom);
        return this;
    }

    public void target(View targetView) {
        if (targetView == null || P == null) {
            return;
        }
        final GradientDrawable drawable = new GradientDrawable();

        if (P.mColorStateList != null) {
            drawable.setColor(P.mColorStateList);
        } else {
            drawable.setColor(P.mColor);
        }
        if (P.mfloatRadius != null) {
            drawable.setCornerRadii(P.mfloatRadius);
        } else {
            drawable.setCornerRadius(P.mRadius);
        }
        if (P.shape == GradientDrawable.LINE) {
            drawable.setStroke(P.mStrokeWidth, P.mStrokeColor, P.dashWidth, P.dashGap);
        } else {
            if (P.mStrokeWidth > 0) {
                drawable.setStroke(P.mStrokeWidth, P.mStrokeColor);
            }
        }
        targetView.setBackground(drawable);
    }

    private float[] getCornerRadii(int leftTop, int rightTop, int leftBottom, int rightBottom) {
        return new float[]{dip2px(leftTop), dip2px(leftTop), dip2px(rightTop), dip2px(rightTop), dip2px(rightBottom), dip2px(rightBottom), dip2px(leftBottom), dip2px(leftBottom)};
    }

    /**
     * 从DP转成PX
     */
    private int dip2px(float dpValue) {
        float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public EasyShape line() {
        P.shape = GradientDrawable.LINE;
        return this;
    }

    public EasyShape rectangle() {
        P.shape = GradientDrawable.RECTANGLE;
        return this;
    }

    public static class EasyShapeParams {


        ColorStateList mColorStateList = null;

        int shape;
        //背景颜色
        int mColor;
        //角度
        int mRadius;
        //四周角度
        float[] mfloatRadius;
        //边框的宽度
        int mStrokeWidth;
        //边框的颜色
        int mStrokeColor;
        //线的宽度
        int dashWidth = 6;
        //虚线的间距
        int dashGap = 6;

    }


}
