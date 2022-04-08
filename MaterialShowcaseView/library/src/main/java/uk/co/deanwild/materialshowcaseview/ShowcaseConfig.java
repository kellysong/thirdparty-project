package uk.co.deanwild.materialshowcaseview;

import android.graphics.Color;
import android.graphics.Typeface;

import uk.co.deanwild.materialshowcaseview.shape.Shape;


public class ShowcaseConfig {

    public static final String DEFAULT_MASK_COLOUR = "#dd335075";

    private long mDelay = -1;
    private int mMaskColour;
    private Typeface mDismissTextStyle;

    private int mContentTextColor;
    private int mDismissTextColor;
    private long mFadeDuration = -1;
    private Shape mShape = null;
    private int mLeftPadding = -1, mTopPadding = -1, mRightPadding = -1, mBottomPadding = -1;
    private Boolean renderOverNav;

    public ShowcaseConfig() {
        mMaskColour = Color.parseColor(ShowcaseConfig.DEFAULT_MASK_COLOUR);
        mContentTextColor = Color.parseColor("#ffffff");
        mDismissTextColor = Color.parseColor("#ffffff");
    }

    public long getDelay() {
        return mDelay;
    }

    public void setDelay(long delay) {
        this.mDelay = delay;
    }

    public int getMaskColor() {
        return mMaskColour;
    }

    public void setMaskColor(int maskColor) {
        mMaskColour = maskColor;
    }

    public int getContentTextColor() {
        return mContentTextColor;
    }

    public void setContentTextColor(int mContentTextColor) {
        this.mContentTextColor = mContentTextColor;
    }

    public int getDismissTextColor() {
        return mDismissTextColor;
    }

    public void setDismissTextColor(int dismissTextColor) {
        this.mDismissTextColor = dismissTextColor;
    }

    public Typeface getDismissTextStyle() {
        return mDismissTextStyle;
    }

    public void setDismissTextStyle(Typeface dismissTextStyle) {
        this.mDismissTextStyle = dismissTextStyle;
    }

    public long getFadeDuration() {
        return mFadeDuration;
    }

    public void setFadeDuration(long fadeDuration) {
        this.mFadeDuration = fadeDuration;
    }

    public Shape getShape() {
        return mShape;
    }

    public void setShape(Shape shape) {
        this.mShape = shape;
    }

    public void setShapePadding(int left, int top, int right, int bottom) {
        this.mLeftPadding = left;
        this.mTopPadding = top;
        this.mRightPadding = right;
        this.mBottomPadding = bottom;
    }


    public static String getDefaultMaskColour() {
        return DEFAULT_MASK_COLOUR;
    }

    public int getLeftPadding() {
        return mLeftPadding;
    }

    public int getTopPadding() {
        return mTopPadding;
    }

    public int getRightPadding() {
        return mRightPadding;
    }

    public int getBottomPadding() {
        return mBottomPadding;
    }

    public Boolean getRenderOverNavigationBar() {
        return renderOverNav;
    }

    public void setRenderOverNavigationBar(boolean renderOverNav) {
        this.renderOverNav = renderOverNav;
    }
}
