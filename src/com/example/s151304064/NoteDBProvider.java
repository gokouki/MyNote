package com.example.s151304064;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class NoteDBProvider extends ContentProvider {
	private static UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
	private NoteSQLiteOpenHelper helper;
	static{
		matcher.addURI("cn.qztc.db.noteprovider", "insert", 1);
		matcher.addURI("cn.qztc.db.noteprovider", "delete", 2);
		matcher.addURI("cn.qztc.db.noteprovider", "query", 3);
	}
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		if(matcher.match(uri)==2){
			SQLiteDatabase db = helper.getReadableDatabase();
			db.delete("note", selection, selectionArgs);
		}else{
			throw new IllegalArgumentException("路径不匹配，不能删除查询操作");
		}
		return 0;
	}

	@Override
	public String getType(Uri arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		if(matcher.match(uri)==1){
			SQLiteDatabase db = helper.getWritableDatabase();
			db.insert("note", null, values);
			
		}else{
			throw new IllegalArgumentException("路径不匹配，不能执行插入操作");
		}

		return null;
	}

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		helper = new NoteSQLiteOpenHelper(getContext());
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
			String sortOrder) {
		// TODO Auto-generated method stub
		if(matcher.match(uri)==3){
			SQLiteDatabase db = helper.getReadableDatabase();
			Cursor cursor = db.query("note",projection, selection, selectionArgs,null,null, sortOrder);
			return cursor;
		}else{
			throw new IllegalArgumentException("路径不匹配，不能执行查询操作");
		}
	
	}

	@Override
	public int update(Uri arg0, ContentValues arg1, String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		return 0;
	}

}
