package com.example.artista;

import java.lang.reflect.Field;

import android.os.Bundle;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.util.Log;
import android.view.DragEvent;
import android.view.HapticFeedbackConstants;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity {

	ScrollView top;
	LinearLayout ll;
	ImageView infoimageview;
	CustomView cv;
	ImageSwitcher imgswitcher;
	ImageView flipper;
	String IMAGEVIEW_TAG = "info";
	int[] garray = { 0x13, 0x15, 0x31, 0x51 };
	// 3,30,5,50 -> l,t,r,b 11-center
	int cnt = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_scroll);
		ll = (LinearLayout) findViewById(R.id.llid);
		imgswitcher = (ImageSwitcher) findViewById(R.id.imgswitcher);
		imgswitcher.setFactory(new ViewFactory() {

			@Override
			public View makeView() {
				// TODO Auto-generated method stub
				ImageView myView = new ImageView(getApplicationContext());
				myView.setScaleType(ScaleType.FIT_XY);
				
				return myView;

			}
		});
		imgswitcher.setImageResource(R.drawable.ic_launcher);
		imgswitcher.setInAnimation(this, R.anim.slide_in_from_bottom);
		imgswitcher.setOutAnimation(this,R.anim.fade_out);
		imgswitcher.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				imgswitcher.setImageResource(R.drawable.infoimage);
			}
		});
		flipper = (ImageView) findViewById(R.id.flipper);
		// Animation an = AnimationUtils.loadAnimation(this, R.anim.rot);
		final Animator as = AnimatorInflater.loadAnimator(this, R.anim.rot);
		as.setTarget(flipper);

		flipper.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				as.start();
				Log.d("jay", "img flipper clicked");
			}
		});
		// flipper.setAnimation(an);

		infoimageview = (ImageView) findViewById(R.id.infoivid);
		infoimageview.setTag(IMAGEVIEW_TAG);
		/*
		 * ll.setOnTouchListener(new OnTouchListener() {
		 * 
		 * @Override public boolean onTouch(View v, MotionEvent event) { // TODO
		 * Auto-generated method stub
		 * 
		 * if (event.getActionMasked() == MotionEvent.ACTION_DOWN) { ClipData
		 * cdata = ClipData.newPlainText("", ""); DragShadowBuilder dsb = new
		 * DragShadowBuilder(v); v.startDrag(cdata, dsb, v, 0); } return true;
		 * 
		 * } });
		 */
		ll.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(this,
				R.anim.layanim));

		top = (ScrollView) findViewById(R.id.svid);
		cv = (CustomView) findViewById(R.id.cvid);
		cv.setTag(infoimageview.toString());
		cv.setOnLongClickListener(new OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stub
				v.setHapticFeedbackEnabled(true);
				v.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
				ClipData cdata = ClipData.newPlainText("label", "valjueb");
				ClipData.Item citem = new ClipData.Item((String) v.getTag());
				ClipData clipData = new ClipData((CharSequence) v.getTag(),
						new String[] { ClipDescription.MIMETYPE_TEXT_PLAIN },
						citem);
				DragShadowBuilder dsb = new DragShadowBuilder(v);
				v.startDrag(clipData, dsb, v, 0);
				return true;
			}
		});
		/*
		 * cv.setOnTouchListener(new OnTouchListener() {
		 * 
		 * @Override public boolean onTouch(View v, MotionEvent event) { if
		 * (event.getActionMasked() == MotionEvent.ACTION_DOWN) { ClipData cdata
		 * = ClipData.newPlainText("", ""); DragShadowBuilder dsb = new
		 * DragShadowBuilder(v); v.startDrag(cdata, dsb, v, 0); } return true; }
		 * });
		 */FrameLayout fl = (FrameLayout) findViewById(R.id.fl);
		/*
		 * fl.setOnTouchListener(new OnTouchListener() {
		 * 
		 * @Override public boolean onTouch(View v, MotionEvent event) { // TODO
		 * Auto-generated method stub if (event.getActionMasked() ==
		 * MotionEvent.ACTION_DOWN) { ClipData cdata = ClipData.newPlainText("",
		 * ""); DragShadowBuilder dsb = new DragShadowBuilder(v);
		 * v.startDrag(cdata, dsb, v, 0); } return true;
		 * 
		 * } });
		 */
		infoimageview.setOnDragListener(new OnDragListener() {

			@Override
			public boolean onDrag(View v, DragEvent event) {
				final int action = event.getAction();
				switch (action) {
				case DragEvent.ACTION_DRAG_STARTED:
					break;
				case DragEvent.ACTION_DRAG_ENTERED:
					((ImageView) v).setColorFilter(Color.GREEN);
					v.animate().scaleX(1.6f)
							.setInterpolator(new OvershootInterpolator(1.5f))
							.start();
					v.animate().scaleY(1.6f)
							.setInterpolator(new OvershootInterpolator())
							.start();
					// Invalidate the view to force a redraw in the new tint
					v.invalidate();
					return (true);

				case DragEvent.ACTION_DRAG_LOCATION:
					return true;

				case DragEvent.ACTION_DRAG_EXITED:
					v.animate().scaleX(1f).start();
					v.animate().scaleY(1f).start();
					// Re-sets the color tint to blue. Returns true; the return
					// value is ignored.
					((ImageView) v).setColorFilter(Color.BLUE);
					// Invalidate the view to force a redraw in the new tint
					v.invalidate();
					return (true);

				case DragEvent.ACTION_DROP:
					ClipData cdata = event.getClipData();
					ClipDescription cdesc = cdata.getDescription();
					Log.e("jay", "text found = " + cdata.getItemAt(0).getText());

					break;
				case DragEvent.ACTION_DRAG_ENDED:
					v.animate().scaleX(1f).start();
					v.animate().scaleY(1f).start();
					// Turns off any color tinting
					((ImageView) v).clearColorFilter();

					// Invalidates the view to force a redraw
					v.invalidate();
					if (event.getResult()) {
						Toast.makeText(MainActivity.this,
								"The drop was handled.", Toast.LENGTH_LONG)
								.show();

					} else {
						Toast.makeText(MainActivity.this,
								"The drop didn't work.", Toast.LENGTH_LONG)
								.show();
					}

					break;

				}
				return true;
			}
		});
		View v = cv;
		Log.d("jay", "view state - " + cv.toString());
		// PrintFlags.printprivateflags(cv);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onUserInteraction() {
		// TODO Auto-generated method stub
		super.onUserInteraction();
		PrintFlags.printprivateflags(cv);
	}

	@Override
	public void onAttachedToWindow() {
		// TODO Auto-generated method stub
		super.onAttachedToWindow();
		Log.d("jay", "Activity attached to window!!");
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
		// PrintFlags.printprivateflags(cv);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		// PrintFlags.printprivateflags(cv);
		Log.d("jay", "scrollview height - " + top.getHeight()
				+ " child height - " + top.getChildAt(0).getHeight());

	}

	public void dosome(View v) {
		cv.setFocusable(true);
		cv.setFocusableInTouchMode(true);
		cv.setClickable(true);
		cv.requestFocus();
		FrameLayout fl = (FrameLayout) findViewById(R.id.fl);
		FrameLayout.LayoutParams flp = new FrameLayout.LayoutParams(25, 25);
		flp.gravity = garray[cnt++ % 4];
		fl.addView(new Button(this), flp);
		// PrintFlags.printprivateflags(cv);
	}

}
