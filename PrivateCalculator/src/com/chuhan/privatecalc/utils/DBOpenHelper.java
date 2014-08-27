package com.chuhan.privatecalc.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * 负责数据库操作
 * @author lifen
 *
 */
public class DBOpenHelper extends SQLiteOpenHelper{

	public DBOpenHelper(Context context) {
		super(context, "privacycalc.db", null, 2);//<包>/databases/
	}

	@Override
	public void onCreate(SQLiteDatabase db) {//数据库每一次被创建的时候调用
		db.beginTransaction();//开启事务
		try{
			db.execSQL("CREATE TABLE cryptinfo(hashid integer primary key, filename varchar(50), filepath varchar(255), filesize integer, filetype varchar(20), move varchar(10), destpath varchar(255) NULL, cryptdate varchar(255))");
//			db.execSQL("CREATE TABLE cryptinfo(hashid integer primary key, filename varchar(255), filepath varchar(255), filesize integer, filetype varchar(20), move varchar(10), destpath varchar(255))");
			db.setTransactionSuccessful();//设置事务的标志为True
		}finally{
			db.endTransaction();//结束事务,有两种情况：commit,rollback,
		//事务的提交或回滚是由事务的标志决定的,如果事务的标志为True，事务就会提交，否侧回滚,默认情况下事务的标志为False
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("ALTER TABLE cryptinfo ADD msg varchar(255)");
	}

	@Override
	public synchronized void close() {
		super.close();
	}

	
	

}
