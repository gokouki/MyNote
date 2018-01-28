package com.example.s151304064;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class NoteDao2 {

	private NoteSQLiteOpenHelper helper;
	public NoteDao2(Context context){
		helper = new NoteSQLiteOpenHelper(context);
	}
	public long add(String title,String content,int money){
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("title", title);
		values.put("content", content);
		long id = db.insert("note", null, values);
		db.close();
		return id;
	}
	
}
