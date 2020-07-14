package com.bing.bingdemo.shape;

import android.graphics.drawable.GradientDrawable;

public class ShapeDrawable extends GradientDrawable {

    public ShapeDrawable(Builder builder) {
        setColor(builder.bgColor);
        setCornerRadius(builder.cornerRadius);
        setStroke(builder.strokeWidth, builder.strokeColor);
    }

    public static class Builder {
        int bgColor;
        float cornerRadius;
        int strokeWidth;
        int strokeColor;

        public Builder setColor(int argb) {
            this.bgColor = argb;
            return this;
        }

        public Builder setCornerRadius(float radius) {
            this.cornerRadius = radius;
            return this;
        }

        public Builder setStrokeWidth(int strokeWidth) {
            this.strokeWidth = strokeWidth;
            return this;
        }

        public Builder setStrokeColor(int strokeColor) {
            this.strokeColor = strokeColor;
            return this;
        }

        public ShapeDrawable build() {
            return new ShapeDrawable(this);
        }
    }
}
