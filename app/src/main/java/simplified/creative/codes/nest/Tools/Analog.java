package simplified.creative.codes.nest.Tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;

import static simplified.creative.codes.nest.TheNest.tintA;

public class Analog extends View {

    private int height, width, padding, radius = 0;
    private int hourHand, minuteHand, secondHand = 0;

    private int[] position = {1,2,3,4,5,6,7,8,9,10,11,12};

    private Paint paint;
    private Rect rect = new Rect();

    private boolean instance;

    public Analog(Context context) {
        super(context);
    }

    public Analog(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Analog(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void setClock() {
        height = getHeight();
        width = getWidth();
        padding =  12;
        radius = Math.min(height, width) / 2 - padding;

        hourHand = Math.min(height, width) / 10;
        minuteHand = Math.min(height, width) / 8;
        secondHand = Math.min(height, width) / 8;

        paint = new Paint();
        instance = true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (!instance) {
            setClock();
        }

        paint();
        dots(canvas);
        hands(canvas);
        canvas.drawCircle(width / 2, height / 2, 10, paint);

        postInvalidateDelayed(1000);
        invalidate();
    }

    private void draw(Canvas canvas, double loc, int handRadius) {
        double angle = Math.PI * loc / 30 - Math.PI / 2;
        canvas.drawLine(width / 2, height / 2,
                (float) (width / 2 + Math.cos(angle) * handRadius),
                (float) (height / 2 + Math.sin(angle) * handRadius),
                paint);
    }

    private void hands(Canvas canvas) {
        Calendar c = Calendar.getInstance();
        draw(canvas, c.get(Calendar.HOUR_OF_DAY) * 5f,
                radius - hourHand - minuteHand);
        draw(canvas, c.get(Calendar.MINUTE), radius - minuteHand);
        draw(canvas, c.get(Calendar.SECOND), radius - secondHand);
    }

    private void dots(Canvas canvas) {
        for (int p : position) {
            String t = ".";
            paint.getTextBounds(t, 0, t.length(), rect);
            double angle = Math.PI / 6 * (p - 3);
            int x = (int) (width / 2 + Math.cos(angle) * radius - rect.width() / 2);
            int y = (int) (height / 2 + Math.sin(angle) * radius + rect.height() / 2);
            canvas.drawCircle(x, y, 10, paint);
        }
    }

    private void paint() {
        paint.reset();
        paint.setColor(ContextCompat.getColor(getContext(), tintA));
        paint.setStrokeWidth(8);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);;
    }
}