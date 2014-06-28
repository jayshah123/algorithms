package com.example.androidopengl;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.MotionEvent;

public class MyGlSurfaceView extends GLSurfaceView {

	MyRenderer mRenderer;
	
	 public MyGlSurfaceView(Context context) {
		super(context);
		 // Set the Renderer for drawing on the GLSurfaceView
		  setEGLContextClientVersion(2);
		  mRenderer = new MyRenderer(context);
		setRenderer(mRenderer);
    
	}

	 
	 @Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		 
		 switch(event.getActionMasked()){
		 case MotionEvent.ACTION_UP :
			 Log.d("jay","touched glsurfaceview"+event);
			 mRenderer.setAngleDirection(-1);
			 break;
		 }
		 
		 return true;
	}

	
}
