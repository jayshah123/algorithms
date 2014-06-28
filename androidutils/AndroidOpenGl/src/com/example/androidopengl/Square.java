package com.example.androidopengl;

import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import android.opengl.GLES20;

public class Square {

	static float squareCoords[] = {
        -0.5f,  0.5f, 0.0f,   // top left
        -0.5f, -0.5f, 0.0f,   // bottom left
         0.5f, -0.5f, 0.0f,   // bottom right
         0.5f,  0.5f, 0.0f }; // top right
	
	 private short drawOrder[] = { 0, 1, 2, 0, 2, 3 }; // order to draw vertices

	 float color[] = { 0.2f, 0.709803922f, 0.898039216f, 1.0f };

	 private final int vertexStride = COORDS_PER_VERTEX * 4; // 4 bytes per vertex

	 
	private FloatBuffer vertexbuffer;
    private ShortBuffer shortBuffer;
	private int mProgram;
	private int mPositionHandle;
	private int mColorHandle;
    
	static final int COORDS_PER_VERTEX = 3;

	public Square() {
		// TODO Auto-generated constructor stub
		vertexbuffer = MyGLUtils.createFloatBuffer(squareCoords);
		shortBuffer = MyGLUtils.createShortBuffer(drawOrder);
		mProgram = MyGLUtils.setupProgram(MyGLUtils.vertexShaderCodeRegular, MyGLUtils.fragmentShaderCode);
		
	}
	
	public void draw(){
		
		 GLES20.glUseProgram(mProgram);

	        // get handle to vertex shader's vPosition member
	        mPositionHandle = GLES20.glGetAttribLocation(mProgram, "vPosition");

	        // Enable a handle to the triangle vertices
	        GLES20.glEnableVertexAttribArray(mPositionHandle);

	        // Prepare the triangle coordinate data
	        GLES20.glVertexAttribPointer(
	                mPositionHandle, COORDS_PER_VERTEX,
	                GLES20.GL_FLOAT, false,
	                vertexStride, vertexbuffer);

	        // get handle to fragment shader's vColor member
	        mColorHandle = GLES20.glGetUniformLocation(mProgram, "vColor");

	        // Set color for drawing the triangle
	        GLES20.glUniform4fv(mColorHandle, 1, color, 0);


	        // Draw the square
	        GLES20.glDrawElements(
	                GLES20.GL_TRIANGLES, drawOrder.length,
	                GLES20.GL_UNSIGNED_SHORT, shortBuffer);

	        // Disable vertex array
	        GLES20.glDisableVertexAttribArray(mPositionHandle);
		
	}
	
}
