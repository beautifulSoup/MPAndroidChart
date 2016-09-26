package com.github.mikephil.charting.interfaces.datasets;

import android.graphics.DashPathEffect;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IValueFormatter;

/**
 * Created by philipp on 21/10/15.
 */
public interface IBarLineScatterCandleBubbleDataSet<T extends Entry> extends IDataSet<T> {

    /**
     * Returns the color that is used for drawing the highlight indicators.
     *
     * @return
     */
    int getHighLightColor();

    public IValueFormatter getXAxisHeightValueFormatter();

    public IValueFormatter getLeftYAxisValueFormatter();

    public IValueFormatter getRightYAxisValueFormatter();

    /**
     * Returns true if vertical highlight indicator lines are enabled (drawn)
     * @return
     */
    boolean isVerticalHighlightIndicatorEnabled();

    /**
     * Returns true if vertical highlight indicator lines are enabled (drawn)
     * @return
     */
    boolean isHorizontalHighlightIndicatorEnabled();

    /**
     * Returns the line-width in which highlight lines are to be drawn.
     * @return
     */
    float getHighlightLineWidth();

    /**
     * Returns the DashPathEffect that is used for highlighting.
     * @return
     */
    DashPathEffect getDashPathEffectHighlight();

    float getHighLightRectHorizontalPadding();

    float getHighLightRectVerticalPadding();


    int getHighLightTextColor();

    float getHighLightTextSize();

}
