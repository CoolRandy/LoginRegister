package com.coolrandy.db;

import android.content.Context;
//import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
//import android.view.View.OnClickListener;
import android.widget.Toast;

public class AccountbaseHelper extends SQLiteOpenHelper{
	
//	public static final String CREATE_ACCOUNT = "create table user(" +
//			"id integer primary key autoincrement," +
//			"username varchar(20)," +
//			"password varchar(20))";
	
	private static final int DATABASE_VISION = 1;
	private static final String DATABASE_NAME = "account.db";
	private Context mContext;
	public AccountbaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VISION);
		// 
		mContext = context;
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// 
		String CREATE_ACCOUNT = "create table account(" +
			"id integer primary key autoincrement," +
			"username varchar(20)," +
			"password varchar(20))";
		
		db.execSQL(CREATE_ACCOUNT);
		Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVision, int newVision) {
		// update the database
		db.execSQL("DROP TABLE ID EXITS user");
		this.onCreate(db);
		
	}

	
	
	
}
