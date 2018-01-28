package com.example.s151304064;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private ListView mListView;
	private List<Note> notes;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageView add = (ImageView)findViewById(R.id.imageView1);
		mListView = (ListView) findViewById(R.id.lv);
		getNotes();
		MyBaseAdapter mAdapter = new MyBaseAdapter();
		mListView.setAdapter(mAdapter);
		
		add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClassName( getApplicationContext(),"com.example.s151304064.EditActivity");
				startActivity(intent);
			}
		});
	
		
	}
	private void getNotes(){
		String path="cn.qztc.db.noteprovider";
		Uri uri = Uri.parse(path);
		ContentResolver contentResolver = getContentResolver();
		Cursor cursor = contentResolver.query(uri, null, null, null, null);
		notes = new ArrayList<Note>();
		if(cursor==null){
			return;
		}
		while(cursor.moveToNext()){
			Long id = cursor.getLong(cursor.getColumnIndex("id")); 
			String title = cursor.getString(cursor.getColumnIndex("title")); 
			String content = cursor.getString(cursor.getColumnIndex("content"));
			Note n = new Note(id,title,content);
		
			notes.add(n);
			
		}
		cursor.close();
	}

	class MyBaseAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return notes.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return notes.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			Note note = notes.get(position);
			View view = View.inflate(MainActivity.this, R.layout.list_item, null);
			TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
			tv_title.setText(note.getTitle());
			return view;
		}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
