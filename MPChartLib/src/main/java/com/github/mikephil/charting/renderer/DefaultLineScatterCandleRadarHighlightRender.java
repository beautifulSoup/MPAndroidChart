package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

/**
 * Created by kris on 16/9/26.
 */
public class DefaultLineScatterCandleRadarHighlightRender implements IHighlightRender {

    Paint mHighlightPaint;

    /**
     * path that is used for drawing highlight-lines (drawLines(...) cannot be used because of dashes)
     */
    private Path mHighlightLinePath = new Path();

    public DefaultLineScatterCandleRadarHighlightRender(){
        mHighlightPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mHighlightPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    public void drawHighlightLines(Canvas c, float xPos, float yPos, float xValue, float yValue, IBarLineScatterCandleBubbleDataSet set, ViewPortHandler viewPortHandler) {
        // set color and stroke-width
        mHighlightPaint.setColor(set.getHighLightColor());
        mHighlightPaint.setStrokeWidth(set.getHighlightLineWidth());

        // draw highlighted lines (if enabled)
        mHighlightPaint.setPathEffect(set.getDashPathEffectHighlight());

        // draw vertical highlight lines
        if (set.isVerticalHighlightIndicatorEnabled()) {

            // create vertical path
            mHighlightLinePath.reset();
            mHighlightLinePath.moveTo(xPos, viewPortHandler.contentTop());
            mHighlightLinePath.lineTo(xPos, viewPortHandler.contentBottom());

            c.drawPath(mHighlightLinePath, mHighlightPaint);
        }

        // draw horizontal highlight lines
        if (set.isHorizontalHighlightIndicatorEnabled()) {

            // create horizontal path
            mHighlightLinePath.reset();
            mHighlightLinePath.moveTo(viewPortHandler.contentLeft(), yPos);
            mHighlightLinePath.lineTo(viewPortHandler.contentRight(), yPos);

            c.drawPath(mHighlightLinePath, mHighlightPaint);
        }
    }
}
