package com.xxmassdeveloper.mpchartexample;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextUtils;

import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.renderer.IHighlightRender;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/**
 * Created by kris on 16/9/26.
 */
public class CustomHighlightRender implements IHighlightRender {
    Paint mLinePaint;

    Paint mRectPaint;

    Paint mTextPaint;

    Path linePath = new Path();

    public CustomHighlightRender(){
        mLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mLinePaint.setStyle(Paint.Style.STROKE);
        mRectPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mRectPaint.setStyle(Paint.Style.FILL);
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setStyle(Paint.Style.STROKE);
    }


    @Override
    public void drawHighlightLines(Canvas c, float xPos, float yPos, float x, float y, IBarLineScatterCandleBubbleDataSet set, ViewPortHandler viewPortHandler) {
        //draw line
        mLinePaint.setColor(set.getHighLightColor());
        mLinePaint.setStrokeWidth(set.getHighlightLineWidth());

        // draw highlighted lines (if enabled)
        mLinePaint.setPathEffect(set.getDashPathEffectHighlight());

        // draw vertical highlight lines
        if (set.isVerticalHighlightIndicatorEnabled()) {

            // create vertical path
            linePath.reset();
            linePath.moveTo(xPos, viewPortHandler.contentTop());
            linePath.lineTo(xPos, viewPortHandler.contentBottom());

            c.drawPath(linePath, mLinePaint);
        }

        // draw horizontal highlight lines
        if (set.isHorizontalHighlightIndicatorEnabled()) {

            // create horizontal path
            linePath.reset();
            linePath.moveTo(viewPortHandler.contentLeft(), yPos);
            linePath.lineTo(viewPortHandler.contentRight(), yPos);

            c.drawPath(linePath, mLinePaint);
        }

        IValueFormatter leftValueFormatter = set.getLeftYAxisValueFormatter();
        IValueFormatter rightValueFormatter = set.getRightYAxisValueFormatter();
        IValueFormatter xValueFormatter = set.getXAxisHeightValueFormatter();
        String leftText = leftValueFormatter != null ? leftValueFormatter.getFormattedValue(y, null, 0, viewPortHandler) : "";
        String rightText = rightValueFormatter != null ? rightValueFormatter.getFormattedValue(y, null, 0, viewPortHandler) : "";
        String xText = xValueFormatter != null ? xValueFormatter.getFormattedValue(x, null, 0, viewPortHandler) : "";

        // draw the rect and text
        mTextPaint.setColor(set.getHighLightTextColor());
        mTextPaint.setTextSize(set.getHighLightTextSize());
        mRectPaint.setColor(set.getHighLightColor());

        if(!TextUtils.isEmpty(leftText)) {
            float halfHeightOfText = Utils.calcTextHeight(mTextPaint, leftText) / 2.5f;
            float textWidth = Utils.calcTextWidth(mTextPaint, leftText);

            c.drawRect(viewPortHandler.contentLeft() - 2 * set.getHighLightRectHorizontalPadding() - textWidth,
                    yPos - halfHeightOfText- set.getHighLightRectVerticalPadding(),
                    viewPortHandler.contentLeft(),
                    yPos + halfHeightOfText + set.getHighLightRectVerticalPadding(), mRectPaint);
            mTextPaint.setTextAlign(Paint.Align.RIGHT);
            float baseY = yPos + halfHeightOfText;
            c.drawText(leftText, viewPortHandler.contentLeft() - set.getHighLightRectHorizontalPadding(), baseY, mTextPaint);
        }


        if(!TextUtils.isEmpty(rightText)){
            float halfHeightOfText = Utils.calcTextHeight(mTextPaint, rightText) / 2.5f;
            float textWidth = Utils.calcTextWidth(mTextPaint, rightText);
            c.drawRect(viewPortHandler.contentRight() - 2 * set.getHighLightRectHorizontalPadding() - textWidth,
                    yPos - halfHeightOfText - set.getHighLightRectVerticalPadding(),
                    viewPortHandler.contentRight(),
                    yPos + halfHeightOfText + set.getHighLightRectVerticalPadding(), mRectPaint);

            mTextPaint.setTextAlign(Paint.Align.RIGHT);
            float baseY = yPos + halfHeightOfText;
            c.drawText(rightText, viewPortHandler.contentRight() - set.getHighLightRectHorizontalPadding(), baseY, mTextPaint);
        }

        if(! TextUtils.isEmpty(xText)){
            float textHeight = Utils.calcTextHeight(mTextPaint, xText);
            float halfHeightOfText = textHeight /2.5f;
            float textWidth = Utils.calcTextWidth(mTextPaint, xText);
            c.drawRect(xPos - textWidth / 2 - set.getHighLightRectHorizontalPadding(),
                    viewPortHandler.contentTop() ,
                    xPos + textWidth / 2 + set.getHighLightRectHorizontalPadding(),
                    viewPortHandler.contentTop() + textHeight + 2 * set.getHighLightRectVerticalPadding(), mRectPaint);

            mTextPaint.setTextAlign(Paint.Align.CENTER);
            float baseY = viewPortHandler.contentTop() + textHeight + set.getHighLightRectVerticalPadding();
            c.drawText(xText, xPos, baseY, mTextPaint);
        }



    }
}
