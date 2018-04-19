package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class Practice3DrawRectView extends View {
    private Paint mPaint;
    private RectF mRectF;

    public Practice3DrawRectView(Context context) {
        this(context, null);
    }

    public Practice3DrawRectView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice3DrawRectView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mRectF=new RectF(300,300,600,600);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawRect() 方法画矩形
        mPaint.setColor(Color.BLACK);
        canvas.drawRect(100, 100, 200, 200, mPaint);
        canvas.drawRoundRect(mRectF,10,10,mPaint);

    }
}
