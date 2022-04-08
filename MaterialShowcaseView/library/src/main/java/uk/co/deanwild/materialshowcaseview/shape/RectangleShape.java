package uk.co.deanwild.materialshowcaseview.shape;


import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;

import uk.co.deanwild.materialshowcaseview.target.Target;

public class RectangleShape implements Shape {

    private boolean fullWidth = false;

    private int width = 0;
    private int height = 0;
    private boolean adjustToTarget = true;

    private Rect rect;
    private int left, top, right, bottom;
    public RectangleShape(int width, int height) {
        this.width = width;
        this.height = height;
        init();
    }

    public RectangleShape(Rect bounds) {
        this(bounds, false);
    }

    public RectangleShape(Rect bounds, boolean fullWidth) {
        this.fullWidth = fullWidth;
        height = bounds.height();
        if (fullWidth)
            width = Integer.MAX_VALUE;
        else width = bounds.width();
        init();
    }

    public boolean isAdjustToTarget() {
        return adjustToTarget;
    }

    public void setAdjustToTarget(boolean adjustToTarget) {
        this.adjustToTarget = adjustToTarget;
    }

    private void init() {
        rect = new Rect(-width / 2, -height / 2, width / 2, height / 2);
    }

    @Override
    public void draw(Canvas canvas, Paint paint, int x, int y) {
        if (!rect.isEmpty()) {
          /*  canvas.drawRect(
                    rect.left + x - padding,
                    rect.top + y - padding,
                    rect.right + x + padding,
                    rect.bottom + y + padding,
                    paint
            );*/
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                canvas.drawRoundRect(
                        rect.left + x - left,
                        rect.top + y - top,
                        rect.right + x + right,
                        rect.bottom + y + bottom,20f,20f,
                        paint
                );
            }else {
                canvas.drawRect(
                        rect.left + x - left,
                        rect.top + y - top,
                        rect.right + x + right,
                        rect.bottom + y + bottom,
                        paint
                );
            }
        }
    }

    @Override
    public void updateTarget(Target target) {
        if (adjustToTarget) {
            Rect bounds = target.getBounds();
            height = bounds.height();
            if (fullWidth)
                width = Integer.MAX_VALUE;
            else width = bounds.width();
            init();
        }
    }

    @Override
    public int getTotalRadius() {
        return (height / 2) + left;
    }

    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }


    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}