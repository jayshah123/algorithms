package com.example.androidopengl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES10;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;

public class Triangle {

	int mProgram, mPositionHandle, mColorHandle, mMVPMatrixHandle;

	int[] textures = new int[1];

	private final String vertexShaderCode =
	// This matrix member variable provides a hook to manipulate
	// the coordinates of the objects that use this vertex shader
	"uniform mat4 uMVPMatrix;" + "attribute vec4 vPosition;" + "void main() {" +
	// the matrix must be included as a modifier of gl_Position
	// Note that the uMVPMatrix factor *must be first* in order
	// for the matrix multiplication product to be correct.
			"  gl_Position = uMVPMatrix * vPosition;" + "}";

	private final String texturevertexshadercode = 
		"attribute vec2 a_TexCoordinate;" //pervertex tex coord info we will pass in
		+"varying vec2 v_TexCoordinate;" // this will be passed to frag shader
		+"uniform mat4 uMVPMatrix;" + "attribute vec4 vPosition;" + "void main() {" +
	// the matrix must be included as a modifier of gl_Position
	// Note that the uMVPMatrix factor *must be first* in order
	// for the matrix multiplication product to be correct.
			"  gl_Position = uMVPMatrix * vPosition;" + 
			"  v_TexCoordinate = a_TexCoordinate;"+
			"}";

	
	private final String vertexShaderCodeRegular =
	// This matrix member variable provides a hook to manipulate
	// the coordinates of the objects that use this vertex shader
	"attribute vec4 vPosition;" + "void main() {"
			+ "  gl_Position = vPosition;" + "}";

	private final String texturefragmentShaderCode =
		"precision mediump float;"+
		"uniform sampler2D u_Texture;"+
		"varying vec2 v_TexCoordinate;"+
		"void main() {"
		+ "  gl_FragColor = texture2D(u_Texture,v_TexCoordinate);" + 
		"}";

	
	private final String fragmentShaderCode = "precision mediump float;"
			+ "uniform vec4 vColor;" + "void main() {"
			+ "  gl_FragColor = vColor;" + "}";

	private FloatBuffer vertexbuffer;
	private FloatBuffer texcoordbuffer;

	static final int COORDS_PER_VERTEX = 3;

	static float triangleCoords[] = { // in counterclockwise order:
		-1f,-0.5f,0f,
		1f,-0.5f,0f,
		0.0f,  1.11803399f,0f
	//	0.0f, 0.622008459f, 0.0f, // top
	//		-0.5f, -0.311004243f, 0.0f, // bottom left
	//		0.5f, -0.311004243f, 0.0f // bottom right
	};
	
	static float texCoords[]={
		-0.5f,0f,
		1.5f,0f,
		0.5f,  1.61803399f	
	};

	// Set color with red, green, blue and alpha (opacity) values
	float color[] = { 0.63671875f, 0.76953125f, 0.22265625f, 1.0f };

	public Triangle() {

		
		
		int vertexShader = loadShader(GLES20.GL_VERTEX_SHADER, texturevertexshadercode);
		int fragmentShader = loadShader(GLES20.GL_FRAGMENT_SHADER,
				texturefragmentShaderCode);
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
		
		ByteBuffer bb = ByteBuffer.allocateDirect(triangleCoords.length * 4);// 9*4
		bb.order(ByteOrder.nativeOrder());
		vertexbuffer = bb.asFloatBuffer();
		vertexbuffer.put(triangleCoords);
		vertexbuffer.position(0);

	
		ByteBuffer bbt = ByteBuffer.allocateDirect(texCoords.length * 4);// 9*4
		bbt.order(ByteOrder.nativeOrder());
		texcoordbuffer = bbt.asFloatBuffer();
		texcoordbuffer.put(texCoords);
		texcoordbuffer.position(0);
		
	}

	public static int loadShader(int type, String shaderCode) {

		// create a vertex shader type (GLES20.GL_VERTEX_SHADER)
		// or a fragment shader type (GLES20.GL_FRAGMENT_SHADER)
		int shader = GLES20.glCreateShader(type);

		// add the source code to the shader and compile it
		GLES20.glShaderSource(shader, shaderCode);
		GLES20.glCompileShader(shader);

		return shader;
	}

	public void loadTexture(final Context context, int resId, GL10 gl) {

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

	public void drawTexture(float[] mvpMatrix) {

		// Add program to OpenGL ES environment
		GLES20.glUseProgram(mProgram);

		// get handle to vertex shader's vPosition member
		mPositionHandle = GLES20.glGetAttribLocation(mProgram, "vPosition");

		int mTexHandle;
		//repeating for texcoordinates
		// get handle to vertex shader's vPosition member
		mTexHandle = GLES20.glGetAttribLocation(mProgram, "a_TexCoordinate");

		// Enable a handle to the triangle vertices
		GLES20.glEnableVertexAttribArray(mPositionHandle);
		GLES20.glEnableVertexAttribArray(mTexHandle);

		// Prepare the triangle coordinate data
		GLES20.glVertexAttribPointer(mPositionHandle, COORDS_PER_VERTEX,
				GLES20.GL_FLOAT, false, 12, vertexbuffer);
		
		// Prepare the triangle coordinate data
		GLES20.glVertexAttribPointer(mTexHandle, 2,
				GLES20.GL_FLOAT, false, 0, texcoordbuffer);
		
		int mTextureUniformHandle = GLES20.glGetUniformLocation(mProgram, "u_Texture");
		   
		// Tell the texture uniform sampler to use this texture in the shader by binding to texture unit 0.
	    GLES20.glUniform1i(mTextureUniformHandle, 0);

		// This code is useful when manipulating with mvp, see two shaders above
		// and use relevant one
		// get handle to shape's transformation matrix
		mMVPMatrixHandle = GLES20.glGetUniformLocation(mProgram, "uMVPMatrix");

		// Pass the projection and view transformation to the shader
		GLES20.glUniformMatrix4fv(mMVPMatrixHandle, 1, false, mvpMatrix, 0);

		// Draw the triangle
		GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, 3);

		// Disable vertex array
		GLES20.glDisableVertexAttribArray(mPositionHandle);
		GLES20.glDisableVertexAttribArray(mTexHandle);
	}
	
	public void draw(float[] mvpMatrix) {

		// Add program to OpenGL ES environment
		GLES20.glUseProgram(mProgram);

		// get handle to vertex shader's vPosition member
		mPositionHandle = GLES20.glGetAttribLocation(mProgram, "vPosition");

		// Enable a handle to the triangle vertices
		GLES20.glEnableVertexAttribArray(mPositionHandle);

		// Prepare the triangle coordinate data
		GLES20.glVertexAttribPointer(mPositionHandle, COORDS_PER_VERTEX,
				GLES20.GL_FLOAT, false, 12, vertexbuffer);

		// get handle to fragment shader's vColor member
		mColorHandle = GLES20.glGetUniformLocation(mProgram, "vColor");

		// Set color for drawing the triangle
		GLES20.glUniform4fv(mColorHandle, 1, color, 0);

		// Draw the triangle
		// GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, 3);

		// This code is useful when manipulating with mvp, see two shaders above
		// and use relevant one
		// get handle to shape's transformation matrix
		mMVPMatrixHandle = GLES20.glGetUniformLocation(mProgram, "uMVPMatrix");

		// Pass the projection and view transformation to the shader
		GLES20.glUniformMatrix4fv(mMVPMatrixHandle, 1, false, mvpMatrix, 0);

		// Draw the triangle
		GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, 3);

		// Disable vertex array
		GLES20.glDisableVertexAttribArray(mPositionHandle);

	}

}
