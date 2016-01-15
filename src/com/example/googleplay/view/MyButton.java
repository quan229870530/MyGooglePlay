package com.example.googleplay.view;

import android.app.Application;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

public class MyButton extends Button {

	public MyButton(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		
	}
	
	public MyButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		getParent().getParent().getParent().requestDisallowInterceptTouchEvent(true);
		getParent().getParent().requestDisallowInterceptTouchEvent(true);
		getParent().requestDisallowInterceptTouchEvent(true);
		return super.onTouchEvent(event);
	}
}
