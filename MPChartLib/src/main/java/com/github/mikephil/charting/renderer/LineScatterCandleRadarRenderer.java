package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Path;

import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

/**
 * Created by Philipp Jahoda on 11/07/15.
 */
public abstract class LineScatterCandleRadarRenderer extends BarLineScatterCandleBubbleRenderer{

    /**
     * path that is used for drawing highlight-lines (drawLines(...) cannot be used because of dashes)
     */
    private Path mHighlightLinePath = new Path();

    IHighlightRender mDefaultHighlightRender = new DefaultLineScatterCandleRadarHighlightRender();

    public LineScatterCandleRadarRenderer(ChartAnimator animator, ViewPortHandler viewPortHandler) {
        super(animator, viewPortHandler);
    }

    public void setHighlightRender(IHighlightRender render){
        mDefaultHighlightRender = render;
    }


    /**
     * Draws vertical & horizontal highlight-lines if enabled.
     *
     * @param c
     * @param xPos x-position of the highlight line intersection
     * @param yPos y-position of the highlight line intersection
     * @param set the currently drawn dataset
     */
    protected void drawHighlightLines(Canvas c, float xPos, float yPos, float x, float y, ILineScatterCandleRadarDataSet set) {
        IHighlightRender render = set.getHighlightRender();
        if(render != null){
            render.drawHighlightLines(c, xPos, yPos, x, y, set, mViewPortHandler);
        } else {
            mDefaultHighlightRender.drawHighlightLines(c, xPos, yPos, x, y, set, mViewPortHandler);
        }
    }


}
