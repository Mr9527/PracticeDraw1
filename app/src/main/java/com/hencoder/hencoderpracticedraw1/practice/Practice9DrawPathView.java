package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {
    private Paint mPaint;

    public Practice9DrawPathView(Context context) {
        this(context, null);
    }

    public Practice9DrawPathView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice9DrawPathView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        Path path = new Path();
        int centerPointX = getWidth() / 2;
        int centerPointY = getHeight() / 2;
        path.moveTo(centerPointX, centerPointY);
        path.cubicTo(centerPointX + 150, centerPointY - 200, centerPointX + 250, centerPointY + 100, centerPointX, centerPointY + 200);
        path.cubicTo(centerPointX - 250, centerPointY + 100, centerPointX - 150, centerPointY - 200, centerPointX, centerPointY);
        canvas.drawPath(path, mPaint);
    }
}
