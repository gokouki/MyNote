package com.example.s151304064;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EditActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit);
		ImageView ret = (ImageView)findViewById(R.id.imageView3);
		ImageView confirm = (ImageView)findViewById(R.id.imageView2);
		
		confirm.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				NoteDao2 dao = new NoteDao2(EditActivity.this);
				TextView title = (TextView) findViewById(R.id.textView1);
				TextView content = (TextView) findViewById(R.id.textView2);
				Random random = new Random();
				dao.add(title.getText().toString(), content.getText().toString(), random.nextInt(100));
				Toast.makeText(EditActivity.this, "保存成功", Toast.LENGTH_LONG);
				finish();
				
			}
		});
	
		ret.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) { 
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClassName( getApplicationContext(),"com.example.s151304064.MainActivity");
				startActivity(intent);
			}
		});
	}

	@Override
	public void finish() {
		// TODO 自动生成的方法存根
		super.finish();
	}

}
