package com.github.mikephil.charting.components;

import android.graphics.Color;
import android.text.TextUtils;

import com.github.mikephil.charting.utils.Utils;

/**
 * Created by kris on 16/9/10.
 */
public class SpecialLabel {

    float lineWidth = 1;

    String text;

    int color = Color.BLACK;

    int backgroundColor = Color.TRANSPARENT;

    int textColor = -1;

    float value;

    float textSize = 20;
    float horizontalPadding = 3;
    float VerticalPadding = 3;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(float lineWidth) {
        this.lineWidth = Utils.convertPixelsToDp(lineWidth);
    }

    public String getText() {
        if(TextUtils.isEmpty(text)){
            return ""+value;
        } else {
            return text;
        }
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTextColor() {
        return textColor != -1 ? textColor : color;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    /**
     * in dp
     * @param textSize
     */
    public void setTextSize(float textSize){
        this.textSize = Utils.convertDpToPixel(textSize);
    }

    public float getTextSize(){
        return textSize;
    }

    public float getHorizontalPadding() {
        return horizontalPadding;
    }

    public void setHorizontalPadding(float horizontalPadding) {
        this.horizontalPadding = Utils.convertDpToPixel(horizontalPadding);
    }

    public float getVerticalPadding() {
        return VerticalPadding;
    }

    public void setVerticalPadding(float verticalPadding) {
        VerticalPadding = Utils.convertDpToPixel(verticalPadding);
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
