package com.example.s151304064;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class NoteSQLiteOpenHelper extends SQLiteOpenHelper {


	private static final String TAG = "NoteSQLiteOpenHelper";
	public NoteSQLiteOpenHelper(Context context) {
		super(context,"note.db",null,3);
		// TODO �Զ����ɵĹ��캯�����
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO �Զ����ɵķ������
		db.execSQL("create table note (id integer primary key autoincrement,title varchar(20),content varchar(100)) ");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO �Զ����ɵķ������
		Log.i(TAG, "���ݿ�İ汾�仯��");
	}

}
