package com.example.rotate;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.core.view.GestureDetectorCompat;

public class TouchListener implements View.OnTouchListener {

    MainActivity mainActivity;
    GestureDetectorCompat gestureDetectorCompat;

    public TouchListener(MainActivity ma) {
        this.mainActivity = ma;
        gestureDetectorCompat = new GestureDetectorCompat(this.mainActivity, new MyGestureListener());
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        gestureDetectorCompat.onTouchEvent(motionEvent);
        int maskedAction = motionEvent.getActionMasked();
        switch(maskedAction){

        }
        return true;
    }



    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;
            try {
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            onSwipeRight();
                        } else {
                            onSwipeLeft();
                        }
                        result = true;
                    }
                }
                else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffY > 0) {
                        onSwipeBottom();
                    } else {
                        onSwipeTop();
                    }
                    result = true;
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            return result;
        }
        void onSwipeRight() {
            Toast.makeText(mainActivity, "Swiped Left", Toast.LENGTH_SHORT).show();
            //this.onSwipe.swipeRight();
        }
        void onSwipeLeft() {
            Toast.makeText(mainActivity, "Swiped Left", Toast.LENGTH_SHORT).show();
            //this.onSwipe.swipeLeft();
        }
        void onSwipeTop() {
            Toast.makeText(mainActivity, "Swiped Up", Toast.LENGTH_SHORT).show();
            //this.onSwipe.swipeTop();
        }
        void onSwipeBottom() {
            Toast.makeText(mainActivity, "Swiped Down", Toast.LENGTH_SHORT).show();
            //this.onSwipe.swipeBottom();
        }
    }



}
