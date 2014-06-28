package com.example.artista;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

public class CircleButton extends ImageView {

	Paint circlePaint, focusPaint;
	int centerX,centerY;

	private int outerRadius;
	private int pressedRingRadius;

	private static final int PRESSED_COLOR_LIGHTUP = 255 / 25;
	private static final int PRESSED_RING_ALPHA = 75;
	private static final int DEFAULT_PRESSED_RING_WIDTH_DIP = 16;
	private static final int ANIMATION_TIME_ID = android.R.integer.config_shortAnimTime;
	
	private float animationProgress;

	private int pressedRingWidth;
	private int defaultColor = Color.BLUE;
	private int pressedColor;
	private ObjectAnimator pressedAnimator;

	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// TODO Auto-generated method stub
		centerX = w/2;
		centerY = h/2;
		outerRadius = Math.min(w, h) / 2;
		pressedRingRadius = outerRadius - pressedRingWidth - pressedRingWidth / 2;
		super.onSizeChanged(w, h, oldw, oldh);
	}
	

	private void hidePressedRing() {
		pressedAnimator.setFloatValues(pressedRingWidth, 0f);
		pressedAnimator.start();
	}

	private void showPressedRing() {
		pressedAnimator.setFloatValues(animationProgress, pressedRingWidth);
		pressedAnimator.start();
	}
	
	@Override
	public void setPressed(boolean pressed) {
		super.setPressed(pressed);

		if (circlePaint != null) {
			circlePaint.setColor(pressed ? pressedColor : defaultColor);
		}

		if (pressed) {
			showPressedRing();
		} else {
			hidePressedRing();
		}
	}
	
	public CircleButton(Context context) {
		super(context);
		init();
		// TODO Auto-generated constructor stub
	}
	
	public CircleButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
		// TODO Auto-generated constructor stub
	}
	
	public CircleButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
		// TODO Auto-generated constructor stub
	}


	@Override
	protected void onDraw(Canvas canvas) {
		Log.d("jaycirclebutton","pressedRingRadius = "+pressedRingRadius);
		Log.d("jaycirclebutton","animationProgress = "+animationProgress);
		Log.d("jaycirclebutton","pressedRingWidth  = "+pressedRingWidth);
		Log.d("jaycirclebutton","outerRadius = "+outerRadius);
		canvas.drawCircle(centerX, centerY, pressedRingRadius + animationProgress, focusPaint);
		canvas.drawCircle(centerX, centerY, outerRadius - pressedRingWidth, circlePaint);
		super.onDraw(canvas);
	}
	

	public float getAnimationProgress() {
		return animationProgress;
	}

	public void setAnimationProgress(float animationProgress) {
		this.animationProgress = animationProgress;
		this.invalidate();
	}
	
	private void init(){
		setClickable(true);
		this.setFocusable(true);
		this.setScaleType(ScaleType.CENTER_INSIDE);
		circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		circlePaint.setStyle(Paint.Style.FILL);

		focusPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		focusPaint.setStyle(Paint.Style.STROKE);
		circlePaint.setColor(defaultColor);
		focusPaint.setColor(defaultColor);
		focusPaint.setAlpha(PRESSED_RING_ALPHA);
		
		pressedRingWidth = DEFAULT_PRESSED_RING_WIDTH_DIP;

		
		
		focusPaint.setStrokeWidth(pressedRingWidth);
		final int pressedAnimationTime = getResources().getInteger(ANIMATION_TIME_ID);
		pressedAnimator = ObjectAnimator.ofFloat(this, "animationProgress", 0f, 0f);
		pressedAnimator.setDuration(pressedAnimationTime);
	}
	

	public void setColor(int color) {
		this.defaultColor = color;
		this.pressedColor = getHighlightColor(color, PRESSED_COLOR_LIGHTUP);

		circlePaint.setColor(defaultColor);
		focusPaint.setColor(defaultColor);
		focusPaint.setAlpha(PRESSED_RING_ALPHA);

		this.invalidate();
	}
	
	private int getHighlightColor(int color, int amount) {
		return Color.argb(Math.min(255, Color.alpha(color)), Math.min(255, Color.red(color) + amount),
				Math.min(255, Color.green(color) + amount), Math.min(255, Color.blue(color) + amount));
	}
	
}
