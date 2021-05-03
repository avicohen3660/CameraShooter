package CameraCanvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class test extends View {
    public Circle(Context context) {
        super(context);
    }

    public Circle(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Circle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Circle(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
//        canvas.drawColor(Color.RED);
        int centerX = (int)getWidth()/2;
        int centerY = (int)getHeight()/2;
        int r = 50;
        canvas.drawLine(centerX-r,centerY,centerX+r,centerY,paint);
        canvas.drawLine(centerX,centerY-r,centerX,centerY+r,paint);
    }
}
