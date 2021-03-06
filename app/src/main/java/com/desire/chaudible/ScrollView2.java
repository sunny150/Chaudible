package com.desire.chaudible;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

class ScrollView2 extends ScrollView {

   
    public ScrollView2(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	// true if we can scroll (not locked)
    // false if we cannot scroll (locked)
    private boolean mScrollable = true;

    public void setScrollingEnabled(boolean enabled) {
        mScrollable = enabled;
    }

    public boolean isScrollable() {
        return mScrollable;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // if we can scroll pass the event to the superclass
                if (mScrollable) return super.onTouchEvent(ev);
                // only continue to handle the touch event if scrolling enabled
                return mScrollable; // mScrollable is always false at this point
            default:
                return super.onTouchEvent(ev);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // Don't do anything with intercepted touch events if 
        // we are not scrollable
        if (!mScrollable) return false;
        else return super.onInterceptTouchEvent(ev);
    }
    
    /*
    @Override
    public void requestChildFocus (View child, View focused){
    	
    }
    */
    
    /*
    @Override
    public void scrollTo (int x, int y){
    	
    }
    */
    
    /*
    @Override
    public boolean shouldDelayChildPressedState (){	
    	return false;
    }
    */
   
    
    @Override
    public boolean requestChildRectangleOnScreen (View child, Rect rectangle, boolean immediate){
		
    	return true;
    }
    
}