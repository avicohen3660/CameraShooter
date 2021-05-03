package com.example.camerashooter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class Scope extends View {

    public Scope(Context context) {
        super(context);
    }

    public Scope(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Scope(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Scope(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        int centerX = (int)getWidth()/2;
        int centerY = (int)getHeight()/2;
        int length = 50;
        canvas.drawLine(centerX-length,centerY,centerX+length,centerY,paint);
        canvas.drawLine(centerX,centerY-length,centerX,centerY+length,paint);

    }
}
