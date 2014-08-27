package com.chuhan.privatecalc.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * �������ݿ����
 * @author lifen
 *
 */
public class DBOpenHelper extends SQLiteOpenHelper{

	public DBOpenHelper(Context context) {
		super(context, "privacycalc.db", null, 2);//<��>/databases/
	}

	@Override
	public void onCreate(SQLiteDatabase db) {//���ݿ�ÿһ�α�������ʱ�����
		db.beginTransaction();//��������
		try{
			db.execSQL("CREATE TABLE cryptinfo(hashid integer primary key, filename varchar(50), filepath varchar(255), filesize integer, filetype varchar(20), move varchar(10), destpath varchar(255) NULL, cryptdate varchar(255))");
//			db.execSQL("CREATE TABLE cryptinfo(hashid integer primary key, filename varchar(255), filepath varchar(255), filesize integer, filetype varchar(20), move varchar(10), destpath varchar(255))");
			db.setTransactionSuccessful();//��������ı�־ΪTrue
		}finally{
			db.endTransaction();//��������,�����������commit,rollback,
		//������ύ��ع���������ı�־������,�������ı�־ΪTrue������ͻ��ύ�����ع�,Ĭ�����������ı�־ΪFalse
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
