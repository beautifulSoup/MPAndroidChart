package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;

import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

/**
 * Created by kris on 16/9/26.
 */
public interface IHighlightRender {
    void drawHighlightLines(Canvas c, float xPos, float yPos, float xValue, float yValue, IBarLineScatterCandleBubbleDataSet set, ViewPortHandler viewPortHandler);
}
