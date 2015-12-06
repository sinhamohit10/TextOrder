package com.amazon.mohsinha.ccxhack;

/**
 * Created by mohsinha on 12/6/15.
 */

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class SwipeGestureListener implements GestureDetector.OnGestureListener {

    private static final int SWIPE_MIN_DISTANCE = 1;
    private static final int SWIPE_MAX_OFF_PATH = 1000;

    protected MotionEvent mLastOnDownEvent = null;
    private static final int SWIPE_THRESHOLD_VELOCITY = 5;
    private MainActivity activity;
    private Context context;

    public SwipeGestureListener(MainActivity activity) {
        this.activity = activity;
        this.context = activity.getApplicationContext();
        Log.d("GESTURE", "Cons");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.d("GESTURE", "onFling");
        if (e1 == null)
            e1 = mLastOnDownEvent;
        if (e1 == null || e2 == null)
            return false;

        float dX = e2.getX() - e1.getX();
        float dY = e2.getY() - e1.getY();
        Log.d("SWIPE_MAX_OFF_PATH",Math.abs(dY)+"");
        Log.d("SWIPE_MIN_DISTANCE",Math.abs(dX)+"");

        if (Math.abs(dY) < SWIPE_MAX_OFF_PATH && Math.abs(dX) >= SWIPE_MIN_DISTANCE) {
            if (dX > 0) {
                Toast.makeText(context, "Added to cart", Toast.LENGTH_SHORT).show();
                Log.d("GESTURE", "RIGHT");
            } else {
                Toast.makeText(context, "Created Subscribe and Save", Toast.LENGTH_SHORT).show();
                Log.d("GESTURE", "LEFT");
            }

            return true;
        }

        return false;
    }


    @Override
    public void onLongPress(MotionEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        // TODO Auto-generated method stub
        return true;
    }

}