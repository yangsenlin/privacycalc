package com.chuhan.privatecalc.utils;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.chuhan.privatecalc.model.CryptInfo;

public class PrivacyCalcSQLite {

	private DBOpenHelper dbOpenHelper;

	public PrivacyCalcSQLite(Context context) {
		this.dbOpenHelper = new DBOpenHelper(context);
	}
	
	/**
	 * 获取记录总数
	 * @return
	 */
	public long getCount(){
		SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select count(*) from cryptinfo", null);
		cursor.moveToFirst();
		long result = cursor.getLong(0);
		cursor.close();
		return result;
	}
	/**
	 * 添加记录
	 * @param cryptInfo
	 */
	public void save(CryptInfo cryptInfo){
		SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
		db.execSQL("insert into cryptinfo(hashid, filename, filepath, filesize, filetype, move, destpath, cryptdate) values(?,?,?,?,?,?,?,?)",
//		db.execSQL("insert into cryptinfo(hashid, filename, filepath, filesize, filetype, move, destpath) values(?,?,?,?,?,?,?)",
				new Object[]{cryptInfo.getHashid(),cryptInfo.getFilename(), cryptInfo.getFilesize(), cryptInfo.getFiletype()});
	}
	/**
	 * 删除记录
	 * @param hashid 
	 */
	public void delete(Integer hashid){
		SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
		db.execSQL("delete from cryptInfo where hashid=?", new Object[]{hashid});
	}
	/**
	 * 更新记录
	 * @param CryptInfo
	 */
	public void update(CryptInfo cryptInfo){
		SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
		db.execSQL("update cryptInfo set hashid=?, filename=?, filesize=?, filetype=?, move=?, filepath=?,destpath=? where hashid=?",
				new Object[]{cryptInfo.getHashid(),cryptInfo.getFilename(), cryptInfo.getFilesize(), cryptInfo.getFiletype()});
	}
	/**
	 * 查询记录
	 * @param hashid
	 * @return
	 */
	public CryptInfo find(Integer id){
		SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select * from cryptInfo where hashid=?", new String[]{id.toString()});
		if(cursor.moveToFirst()){
			int hashid = cursor.getInt(cursor.getColumnIndex("hashid"));
			int filesize = cursor.getInt(cursor.getColumnIndex("filesize"));
			String filename = cursor.getString(cursor.getColumnIndex("filename"));
			String filepath = cursor.getString(cursor.getColumnIndex("filepath"));
			String filetype = cursor.getString(cursor.getColumnIndex("filetype"));
			return new CryptInfo(hashid, filename, filepath, filesize, filetype);
		}
		cursor.close();
		return null;
	}
	/**
	 * 分页获取记录
	 * @param offset 跳过前面多少条记录
	 * @param maxResult 每页获取多少条记录
	 * @return
	 */
	public List<CryptInfo> getScrollData(int offset, int maxResult){
		List<CryptInfo> cryptInfos = new ArrayList<CryptInfo>();
		SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select * from cryptInfo order by hashid asc limit ?,?",
				new String[]{String.valueOf(offset), String.valueOf(maxResult)});
		while(cursor.moveToNext()){
			int hashid = cursor.getInt(cursor.getColumnIndex("hashid"));
			int filesize = cursor.getInt(cursor.getColumnIndex("filesize"));
			String filename = cursor.getString(cursor.getColumnIndex("filename"));
			String filepath = cursor.getString(cursor.getColumnIndex("filepath"));
			String filetype = cursor.getString(cursor.getColumnIndex("filetype"));
			cryptInfos.add(new CryptInfo(hashid, filename, filepath, filesize, filetype));
		}
		cursor.close();
		return cryptInfos;
	}
	/**
	 * 分页获取记录
	 * @param offset 跳过前面多少条记录
	 * @param maxResult 每页获取多少条记录
	 * @return
	 */
	public Cursor getCursorScrollData(int offset, int maxResult){
		SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select hashid as _id,filename,filepath,filetype from cryptinfo order by filetype asc limit ?,?",
				new String[]{String.valueOf(offset), String.valueOf(maxResult)});
		return cursor;
	}
}
