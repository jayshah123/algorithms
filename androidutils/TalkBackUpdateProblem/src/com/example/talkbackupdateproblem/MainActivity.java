package com.example.talkbackupdateproblem;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnHoverListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	
	ListView list;
	Button btn;
	
	class MyAdapter extends BaseAdapter{

		int cnt[];
		Context mContext;
		String[] items = {" 1update "," 2update "," 3update "};
		
		
		public MyAdapter(Context ctxt) {
			// TODO Auto-generated constructor stub
		cnt = new int[items.length];
		mContext = ctxt;
		}
		
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return items.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return items[position];
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			 LayoutInflater mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View v = mInflater.inflate(android.R.layout.simple_list_item_1, null);
			TextView t = (TextView)v.findViewById(android.R.id.text1);
			TypedValue tv = new TypedValue();
			getTheme().resolveAttribute(android.R.attr.activatedBackgroundIndicator, tv, true);
			v.setBackgroundResource(tv.resourceId);
			//v.setBackground(getResources().getDrawable(android.R.attr.activatedBackgroundIndicator));
			
			t.setText(items[position]+" = "+cnt[position]++);
			Log.d("jay","getview returns"+cnt[position]);
			return v;
		}

		
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn = (Button)findViewById(R.id.update);
		list = (ListView)findViewById(R.id.list);
		
		MyAdapter mAdapter = new MyAdapter(this);
		
		list.setAdapter(mAdapter);
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				list.setItemChecked(position, true);
				// TODO Auto-generated method stub
				
			}
		});
		btn.setOnClickListener(new OnClickListener() {
				
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//list.requestLayout();
				//list.invalidateViews();
				list.setItemChecked(0, true);
				list.setSelection(1);

			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
