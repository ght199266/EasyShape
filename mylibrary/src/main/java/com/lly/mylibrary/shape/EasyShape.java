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
 * @description
 */
public class EasyShape {

    private EasyShapeParams P;

    public EasyShape() {
        P = new EasyShapeParams();
    }

    /**
     * 设置四周的边框
     *
     * @param width 宽度
     * @param color 颜色
     */
    public EasyShape setStroke(int width, @ColorInt int color) {
        P.mStrokeWidth = width;
        P.mStrokeColor = color;
        return this;
    }

    /**
     * 设置颜色
     *
     * @param colorStateList 不同状态view的颜色
     */
    public EasyShape setStateColor(ColorStateList colorStateList) {
        P.mColorStateList = colorStateList;
        return this;
    }

    /**
     * 简单设置普通和按下的颜色
     *
     * @param defaultColor 默认颜色
     * @param pressedColor 手指按下颜色
     */
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

    /**
     * 设置单个颜色
     *
     * @param argb argb
     */
    public EasyShape setColor(@ColorInt int argb) {
        P.mColor = argb;
        return this;
    }

    /**
     * 圆角
     *
     * @param radius
     */
    public EasyShape setRadius(int radius) {
        P.mRadius = radius;
        return this;
    }


    /**
     * 设置虚线的
     *
     * @param strokeWidth //线宽度
     * @param color       // 线颜色
     * @param lineWidth   //虚线长度
     * @param lineGap     //虚线之间的间隔
     */
    public EasyShape setLineParams(int strokeWidth, int color, int lineWidth, int lineGap) {
        P.mStrokeWidth = strokeWidth;
        P.mStrokeColor = color;
        P.dashWidth = lineWidth;
        P.dashGap = lineGap;
        return this;
    }


    /**
     * 设置单独四周圆角（左上右下）
     */
    public EasyShape setRadius(int leftTop, int rightTop, int leftBottom, int rightBottom) {
        P.mFloatRadius = getCornerRadii(leftTop, rightTop, leftBottom, rightBottom);
        return this;
    }


    /**
     * 目标view
     */
    public void target(View targetView) {
        if (targetView == null || P == null) {
            return;
        }
        P.context = targetView.getContext();

        final GradientDrawable drawable = new GradientDrawable();

        if (P.mColorStateList != null) {
            drawable.setColor(P.mColorStateList);
        } else {
            drawable.setColor(P.mColor);
        }
        if (P.mFloatRadius != null) {
            drawable.setCornerRadii(P.getFloatRadius());
        } else {
            drawable.setCornerRadius(P.getRadius());
        }
        if (P.shape == GradientDrawable.LINE) {
            drawable.setStroke(P.getStrokeWidth(), P.mStrokeColor, P.getDashWidth(), P.getDashGap());
        } else {
            drawable.setShape(P.shape);
            if (P.mStrokeWidth > 0) {
                drawable.setStroke(P.getStrokeWidth(), P.mStrokeColor);
            }
        }
        targetView.setBackground(drawable);
    }

    private float[] getCornerRadii(int leftTop, int rightTop, int leftBottom, int rightBottom) {
        return new float[]{leftTop, leftTop, rightTop, rightTop, rightBottom, rightBottom, leftBottom, leftBottom};
    }


    public EasyShape line() {
        P.shape = GradientDrawable.LINE;
        return this;
    }

    public EasyShape rectangle() {
        P.shape = GradientDrawable.RECTANGLE;
        return this;
    }

    public EasyShape oval() {
        P.shape = GradientDrawable.OVAL;
        return this;
    }

    public static class EasyShapeParams {

        Context context = null;

        ColorStateList mColorStateList = null;

        int shape;
        //背景颜色
        int mColor;
        //角度
        int mRadius;
        //四周角度
        float[] mFloatRadius;
        //边框的宽度
        int mStrokeWidth;
        //边框的颜色
        int mStrokeColor;
        //线的宽度
        int dashWidth = 6;
        //虚线的间距
        int dashGap = 6;


        int getRadius() {
            return dPtoPX(mRadius);
        }

        float[] getFloatRadius() {
            for (int i = 0; i < mFloatRadius.length; i++) {
                mFloatRadius[i] = dPtoPX(mFloatRadius[i]);
            }
            return mFloatRadius;
        }

        int getStrokeWidth() {
            return dPtoPX(mStrokeWidth);
        }


        int getDashWidth() {
            return dPtoPX(dashWidth);
        }

        int getDashGap() {
            return dPtoPX(dashGap);
        }

        private int dPtoPX(float dpValue) {
            float scale = context.getResources().getDisplayMetrics().density;
            return (int) (dpValue * scale + 0.5f);
        }
    }

}
