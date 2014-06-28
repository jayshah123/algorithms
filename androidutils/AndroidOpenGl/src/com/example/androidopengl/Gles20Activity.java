package com.example.androidopengl;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

public class Gles20Activity extends Activity {

	private GLSurfaceView mGLView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create a GLSurfaceView instance and set it
        // as the ContentView for this Activity.
        mGLView = new MyGlSurfaceView(this);
        setContentView(mGLView);
    }
	
}
