package com.example.androidopengl;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.SystemClock;
import android.util.Log;

public class MyRenderer implements GLSurfaceView.Renderer{

	int cnt=0;
	Context mContext;
	private static final String TAG="MyRenderer";
	float[] mProjectionMatrix=new float[16];
	float[] mViewMatrix=new float[16];
	float[] mModelMatrix = new float[16];
	float[] mMVMatrix = new float[16];
	float[] mMVPMatrix=new float[16];
	Triangle mTriangle;
	Square mSquare;
	int mAngledirection=1;
	
	public MyRenderer(Context context) {
		// TODO Auto-generated constructor stub
		mContext = context;
	}
	
	@Override
	public void onDrawFrame(GL10 gl) {
		// TODO Auto-generated method stub
		   // Set the background frame color
		
		GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
       Log.d(TAG,"onDrawFraame - cnt = "+cnt++);
       
       // Set the camera position (View matrix)
       Matrix.setLookAtM(mViewMatrix, 0, 0, 0, -2, 0f, 0f, 0f, 0f, 1.0f, 0.0f);

       //modeling operations start
       Matrix.setIdentityM(mModelMatrix, 0);
       long time = SystemClock.uptimeMillis() % 10000L;
       float angleInDegrees = (360.0f / 10000.0f) * ((int) time);
       Matrix.setRotateM(mModelMatrix, 0, mAngledirection*angleInDegrees, 0, 0, 1f);
       //modeling operations end
       
       
       Matrix.multiplyMM(mMVMatrix, 0, mViewMatrix, 0, mModelMatrix, 0);
       
       // Calculate the projection and view transformation
       Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0,mMVMatrix, 0);

       // Draw shape
       mSquare.draw();
       //mTriangle.draw(mMVPMatrix);
       mTriangle.drawTexture(mMVPMatrix);
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		// TODO Auto-generated method stub
		
		GLES20.glViewport(0, 0, width, height);
		float ratio = (float)width/height;
		Log.d(TAG,"Myrenderer surface changwed");
		Matrix.frustumM(mProjectionMatrix, 0, -ratio, ratio, -1, 1, 0.5f, 9);
		mTriangle.loadTexture(mContext, R.drawable.robot, gl);
	}

	public void setAngleDirection(int i){
		mAngledirection*=i;
	}
	
	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		// TODO Auto-generated method stub
		 GLES20.glClearColor(0.0f, 1.0f, 0.0f, 1.0f);
		 Log.d(TAG,"MyRenderer surface created!!");
		 mTriangle = new Triangle();
		 mSquare = new Square();
	}


    /**
    * Utility method for debugging OpenGL calls. Provide the name of the call
    * just after making it:
    *
    * <pre>
    * mColorHandle = GLES20.glGetUniformLocation(mProgram, "vColor");
    * MyGLRenderer.checkGlError("glGetUniformLocation");</pre>
    *
    * If the operation is not successful, the check throws an error.
    *
    * @param glOperation - Name of the OpenGL call to check.
    */
    public static void checkGlError(String glOperation) {
        int error;
        while ((error = GLES20.glGetError()) != GLES20.GL_NO_ERROR) {
            Log.e(TAG, glOperation + ": glError " + error);
            throw new RuntimeException(glOperation + ": glError " + error);
        }
    }
	
}
