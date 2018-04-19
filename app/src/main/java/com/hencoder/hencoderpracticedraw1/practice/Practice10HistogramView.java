package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Practice10HistogramView extends View {
    public static final int CHUNK_PADDING = 10;
    public static final int STROKE_WIDTH = 3;
    private Paint mPaint;
    private Paint mWhitePaint;
    private Rect mRect;
    private List<RectData> mRectData;

    public Practice10HistogramView(Context context) {
        this(context, null);
    }

    public Practice10HistogramView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice10HistogramView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        mRect = new Rect();
        mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
        mPaint.setAntiAlias(true);
        mWhitePaint = new Paint();
        mWhitePaint.setTextSize(30);
        mWhitePaint.setColor(Color.WHITE);
        mWhitePaint.setAntiAlias(true);
        mWhitePaint.setStrokeWidth(STROKE_WIDTH);
        mRectData = new ArrayList<>();

        List<RectData> list = new ArrayList<>();
        list.add(new RectData("Froyo", 0.1));
        list.add(new RectData("GB", 1));
        list.add(new RectData("ICS", 1));
        list.add(new RectData("JB", 3));
        list.add(new RectData("Kitkat", 5));
        list.add(new RectData("L", 7));
        list.add(new RectData("M", 2));
        setData(list);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        int bottomY = getHeight() - getHeight() / 3;
        int padding = getHeight() / 10;
        canvas.drawLine(padding, bottomY, getWidth() - padding, bottomY, mWhitePaint);
        canvas.drawLine(padding, bottomY, padding, padding, mWhitePaint);
        int rectWidth = ((getWidth() - padding * 2) - mRectData.size() * 10) / mRectData.size();
        for (int i = 0; i < mRectData.size(); i++) {
            RectData data = mRectData.get(i);
            float top = (float) ((bottomY - padding * 2) * data.getRatio());
            Log.i("rect", "chunk top = " + top);
            int left = (CHUNK_PADDING + rectWidth) * i + padding + CHUNK_PADDING;
            int right = left + rectWidth;
            canvas.drawRect(left, bottomY - top - STROKE_WIDTH, right, bottomY - STROKE_WIDTH, mPaint);
            mWhitePaint.getTextBounds(data.getName(), 0, data.getName().length(), mRect);
            int x = right - (rectWidth + mRect.right) / 2;
            canvas.drawText(data.getName(), x, bottomY -mRect.top + STROKE_WIDTH, mWhitePaint);
        }
    }


    public void setData(Collection<RectData> data) {
        double max = 0;
        mRectData.clear();
        for (RectData rect : data) {
            mRectData.add(rect);
            if (max < rect.getValue()) {
                max = rect.getValue();
            }
        }
        for (RectData rectData : mRectData) {
            double value = rectData.getValue();
            rectData.setRatio(value / max);
        }
    }

    class RectData {

        public RectData(String name, double value) {
            this.name = name;
            this.value = value;
        }

        private String name;
        private double value;
        private double ratio;

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public double getRatio() {
            return ratio;
        }

        public void setRatio(double ratio) {
            this.ratio = ratio;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
