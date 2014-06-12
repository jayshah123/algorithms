package com.example.parsestrings;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.AssetManager;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	List<String> entries = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		AssetManager am ; 
		try {
			XmlPullParser xmlrp ;
			InputStream istr;
			istr = getAssets().open("strens.xml");
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			factory.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
			xmlrp = factory.newPullParser();
			
			xmlrp.setInput(istr, "UTF-8");
			xmlrp.nextTag();
			
			readResource(xmlrp);
			istr.close();
			for(String s : entries){
				Log.d("jay"," s = "+s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
private void readResource(XmlPullParser parser) throws IOException, XmlPullParserException {
		
		parser.require(XmlPullParser.START_TAG, null, "resources");
		while(parser.next()!=XmlPullParser.END_TAG){
			if(parser.getEventType()!=XmlPullParser.START_TAG){
				continue;
			}
			String name = parser.getName();
			if(name.equals("string")){
				entries.add(readStringTag(parser));
			}
		}
	}
	
	private String readStringTag(XmlPullParser parser) throws IOException, XmlPullParserException {
		
		parser.require(XmlPullParser.START_TAG, null, "string");
		String string = readText(parser);
		parser.require(XmlPullParser.END_TAG, null, "string");
		return string;
	}
	
	private String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
		String result="";
		if(parser.next() == XmlPullParser.TEXT){
			result = parser.getText();
			parser.nextTag();
		}
		return result;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
