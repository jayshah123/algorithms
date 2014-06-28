package com.example.artista;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class CanvasPlayActivity extends Activity {

	ImageView iv;
	View v;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.canvas_play);
		iv = (ImageView)findViewById(R.id.ivid);
		v = (View)findViewById(R.id.vid);
		Log.d("jay","iv layer type - "+iv.getLayerType());
		Log.d("jay","v layer type - "+v.getLayerType());
		
		
	}
	
	
}
