
package com.github.mikephil.charting.data;

import android.graphics.Color;
import android.graphics.DashPathEffect;

import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.utils.Utils;

import java.util.List;

/**
 * Baseclass of all DataSets for Bar-, Line-, Scatter- and CandleStickChart.
 * 
 * @author Philipp Jahoda
 */
public abstract class BarLineScatterCandleBubbleDataSet<T extends Entry> extends DataSet<T> implements IBarLineScatterCandleBubbleDataSet<T> {

    /** default highlight color */
    protected int mHighLightColor = Color.parseColor("#000000");

    protected int mHighLightTextColor = Color.parseColor("#ffffff");

    protected float mHighLightTextSize = 20f;

    IValueFormatter xAxisHeightValueFormatter;

    IValueFormatter leftYAxisValueFormatter;

    IValueFormatter rightYAxisValueFormatter;

    float mHighLightHorizontalPadding = 2;
    float mHighLightVerticalPadding = 3;

    float textSize;


    protected boolean mDrawVerticalHighlightIndicator = true;
    protected boolean mDrawHorizontalHighlightIndicator = true;

    /** the width of the highlight indicator lines */
    protected float mHighlightLineWidth = 0.5f;

    /** the path effect for dashed highlight-lines */
    protected DashPathEffect mHighlightDashPathEffect = null;


    public BarLineScatterCandleBubbleDataSet(List<T> yVals, String label) {
        super(yVals, label);
        xAxisHeightValueFormatter = new DefaultValueFormatter(1);
        leftYAxisValueFormatter = new DefaultValueFormatter(1);
        rightYAxisValueFormatter = new DefaultValueFormatter(1);
        mHighlightLineWidth = Utils.convertDpToPixel(0.5f);
    }

    /**
     * Sets the color that is used for drawing the highlight indicators. Dont
     * forget to resolve the color using getResources().getColor(...) or
     * Color.rgb(...).
     * 
     * @param color
     */
    public void setHighLightColor(int color) {
        mHighLightColor = color;
    }

    @Override
    public int getHighLightColor() {
        return mHighLightColor;
    }


    public void setXAxisHeightValueFormatter(IValueFormatter formatter){
        xAxisHeightValueFormatter = formatter;
    }

    @Override
    public IValueFormatter getXAxisHeightValueFormatter(){
        return xAxisHeightValueFormatter;
    }

    public void setLeftYAxisValueFormatter(IValueFormatter formatter){
        leftYAxisValueFormatter = formatter;
    }

    @Override
    public IValueFormatter getLeftYAxisValueFormatter(){
        return leftYAxisValueFormatter;
    }

    public void setRightYAxisValueFormatter(IValueFormatter formatter){
        rightYAxisValueFormatter = formatter;
    }

    @Override
    public IValueFormatter getRightYAxisValueFormatter(){
        return rightYAxisValueFormatter;
    }



    /**
     * Enables / disables the horizontal highlight-indicator. If disabled, the indicator is not drawn.
     * @param enabled
     */
    public void setDrawHorizontalHighlightIndicator(boolean enabled) {
        this.mDrawHorizontalHighlightIndicator = enabled;
    }

    /**
     * Enables / disables the vertical highlight-indicator. If disabled, the indicator is not drawn.
     * @param enabled
     */
    public void setDrawVerticalHighlightIndicator(boolean enabled) {
        this.mDrawVerticalHighlightIndicator = enabled;
    }

    /**
     * Enables / disables both vertical and horizontal highlight-indicators.
     * @param enabled
     */
    public void setDrawHighlightIndicators(boolean enabled) {
        setDrawVerticalHighlightIndicator(enabled);
        setDrawHorizontalHighlightIndicator(enabled);
    }

    @Override
    public boolean isVerticalHighlightIndicatorEnabled() {
        return mDrawVerticalHighlightIndicator;
    }

    @Override
    public boolean isHorizontalHighlightIndicatorEnabled() {
        return mDrawHorizontalHighlightIndicator;
    }

    /**
     * Sets the width of the highlight line in dp.
     * @param width
     */
    public void setHighlightLineWidth(float width) {
        mHighlightLineWidth = Utils.convertDpToPixel(width);
    }

    @Override
    public float getHighlightLineWidth() {
        return mHighlightLineWidth;
    }

    /**
     * Enables the highlight-line to be drawn in dashed mode, e.g. like this "- - - - - -"
     *
     * @param lineLength the length of the line pieces
     * @param spaceLength the length of space inbetween the line-pieces
     * @param phase offset, in degrees (normally, use 0)
     */
    public void enableDashedHighlightLine(float lineLength, float spaceLength, float phase) {
        mHighlightDashPathEffect = new DashPathEffect(new float[] {
                lineLength, spaceLength
        }, phase);
    }

    /**
     * Disables the highlight-line to be drawn in dashed mode.
     */
    public void disableDashedHighlightLine() {
        mHighlightDashPathEffect = null;
    }

    /**
     * Returns true if the dashed-line effect is enabled for highlight lines, false if not.
     * Default: disabled
     *
     * @return
     */
    public boolean isDashedHighlightLineEnabled() {
        return mHighlightDashPathEffect == null ? false : true;
    }

    @Override
    public DashPathEffect getDashPathEffectHighlight() {
        return mHighlightDashPathEffect;
    }

    @Override
    public int getHighLightTextColor() {
        return mHighLightTextColor;
    }

    public void setHighLightTextColor(int textColor){
        mHighLightTextColor = textColor;
    }

    @Override
    public float getHighLightTextSize(){
        return mHighLightTextSize;
    }

    public void setHighLightTextSize(float textSize){
        mHighLightTextSize = textSize;
    }

    @Override
    public float getHighLightRectHorizontalPadding() {
        return mHighLightHorizontalPadding;
    }

    public void setHighLightRectHorizontalPadding(float horizontalPadding){
        mHighLightHorizontalPadding = horizontalPadding;
    }
    @Override
    public float getHighLightRectVerticalPadding() {
        return mHighLightVerticalPadding;
    }

    public void setHighLightRectVerticalPadding(float verticalPadding){
        mHighLightVerticalPadding = verticalPadding;
    }
}
