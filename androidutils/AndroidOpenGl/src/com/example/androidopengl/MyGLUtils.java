package com.example.androidopengl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;

public class MyGLUtils {

	private final static String TAG="MyGlUtils";
	
	public final static String vertexShaderCodeRegular =
		// This matrix member variable provides a hook to manipulate
		// the coordinates of the objects that use this vertex shader
		"attribute vec4 vPosition;" + "void main() {"
				+ "  gl_Position = vPosition;" + "}";
	
	public final static String fragmentShaderCode = "precision mediump float;"
		+ "uniform vec4 vColor;" + "void main() {"
		+ "  gl_FragColor = vColor;" + "}";

	public static int loadShader(int type, String shaderCode) {

		// create a vertex shader type (GLES20.GL_VERTEX_SHADER)
		// or a fragment shader type (GLES20.GL_FRAGMENT_SHADER)
		int shader = GLES20.glCreateShader(type);

		// add the source code to the shader and compile it
		GLES20.glShaderSource(shader, shaderCode);
		GLES20.glCompileShader(shader);

		return shader;
	}
	
	public static int setupProgram(String vxShaderCode, String frShaderCode){
        int mProgram;
		int vertexShader = loadShader(GLES20.GL_VERTEX_SHADER, vxShaderCode);
		int fragmentShader = loadShader(GLES20.GL_FRAGMENT_SHADER,
				frShaderCode);
       if(vertexShader==0||fragmentShader==0){
    	   throw new RuntimeException("shader not loaded");
       }
		mProgram = GLES20.glCreateProgram(); // create empty OpenGL ES Program
		GLES20.glAttachShader(mProgram, vertexShader); // add the vertex shader
														// to program
		GLES20.glAttachShader(mProgram, fragmentShader); // add the fragment
															// shader to program
		GLES20.glLinkProgram(mProgram);

		  int[] linkStatus = new int[1];
          GLES20.glGetProgramiv(mProgram, GLES20.GL_LINK_STATUS, linkStatus, 0);
          if (linkStatus[0] != GLES20.GL_TRUE) {
              Log.e("jay", "Could not link program: ");
              Log.e("jay", GLES20.glGetProgramInfoLog(mProgram));
              GLES20.glDeleteProgram(mProgram);
              mProgram = 0;
          }
          
         return mProgram;
	}
	
	public static FloatBuffer createFloatBuffer(float[] triangleCoords){
		FloatBuffer vertexbuffer ;
		ByteBuffer bb = ByteBuffer.allocateDirect(triangleCoords.length * 4);// 9*4
		bb.order(ByteOrder.nativeOrder());
		vertexbuffer = bb.asFloatBuffer();
		vertexbuffer.put(triangleCoords);
		vertexbuffer.position(0);
		return vertexbuffer;
	}
	
	public static ShortBuffer createShortBuffer(short[] shortData){
		 ShortBuffer drawListBuffer;
		 ByteBuffer dlb = ByteBuffer.allocateDirect(
			        // (# of coordinate values * 2 bytes per short)
			                shortData.length * 2);
			        dlb.order(ByteOrder.nativeOrder());
			        drawListBuffer = dlb.asShortBuffer();
			        drawListBuffer.put(shortData);
			        drawListBuffer.position(0);
		return drawListBuffer;
	}

	public static void loadTexture(final Context context, int resId, GL10 gl,int[] textures) {

		Bitmap bmp = BitmapFactory
				.decodeResource(context.getResources(), resId);

		gl.glGenTextures(1, textures, 0);
		gl.glBindTexture(GLES20.GL_TEXTURE_2D, textures[0]);

        GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER,
                GLES20.GL_NEAREST);
        GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D,
                GLES20.GL_TEXTURE_MAG_FILTER,
                GLES20.GL_LINEAR);

        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_S,
                GLES20.GL_REPEAT);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_T,
                GLES20.GL_REPEAT);
        
		GLUtils.texImage2D(GLES20.GL_TEXTURE_2D, 0, bmp, 0);
		bmp.recycle();

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
