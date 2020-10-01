package com.example.facemakerwarren23;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceView;
import androidx.annotation.RequiresApi;
import java.util.Random;

/**
 * Class to create a face
 * @author Lindsey Warren
 */
public class Face extends SurfaceView {
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle;

    private Paint facePaint = new Paint();
    private Paint eyePaint = new Paint();
    private Paint mouthPaint = new Paint();
    private Paint hairPaint = new Paint();

    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        this.setBackgroundColor(Color.WHITE);
        randomize();
        this.facePaint.setColor(skinColor);
        this.eyePaint.setColor(eyeColor);
        this.mouthPaint.setColor(Color.RED);
        this.hairPaint.setColor(hairColor);
    }

    /**
     * Method to initialize variables to random values
     */
    public void randomize() {
        skinColor = Color.rgb((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
        eyeColor = Color.rgb((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
        hairColor = Color.rgb((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
        Random random = new Random();
        hairStyle = random.nextInt(3) + 1;
    }
    /**
     * External Citation
     *   Date: 1 October 2020
     *   Problem: Wanted to make a random color from three integers
     *   Resource: Example code from class on Moodle
     *   Solution: Used example
     */

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onDraw(Canvas canvas) {
        int height = canvas.getHeight() / 2;
        int width = canvas.getWidth() / 2;
        // hair length depends on hairstyle randomized or selected
        int length = height;
        if (hairStyle == 1 ) {
            length = length + 700;
        }
        else if (hairStyle == 2) {
            length = length + 800;
        }
        else if (hairStyle == 3) {
            length = length + 900;
        }
        // draw hair
        RectF rectF = new RectF(width - 280, height - 250, width + 280, length);
        canvas.drawArc(rectF, 0, -180, true, hairPaint);
        // draw face
        canvas.drawCircle(width, height, 200.0f, facePaint);
        // draw mouth
        RectF rectF2 = new RectF(width - 100, height - 10, width + 100, height + 100);
        canvas.drawArc(rectF2, 0, 180, true, mouthPaint);
        // draw two eyes
        canvas.drawCircle(width - 100, height - 50, 38.0f, eyePaint);
        canvas.drawCircle(width + 100, height - 50, 38.0f, eyePaint);
    }
    /**
     * External Citation
     *   Date: 1 October 2020
     *   Problem: Didn't understand how to use drawArc
     *   Resource: https://gamedev.stackexchange.com/questions/95433/how-can-i-draw-arc-in-center-of-the-screen-on-canvas-in-android
     *   Solution: Looked at example and did it similarly
     */
}
