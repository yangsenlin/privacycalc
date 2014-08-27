package com.chuhan.privatecalc.test;

import android.test.AndroidTestCase;
import android.util.Log;

import com.chuhan.privatecalc.model.CryptInfo;
import com.chuhan.privatecalc.utils.DBOpenHelper;
import com.chuhan.privatecalc.utils.PrivacyCalcSQLite;

public class TestSQLite extends AndroidTestCase{
	String tag = "TestSQLite";

	public void testCreateDB() throws Exception{
		DBOpenHelper dbOpenHelper = new DBOpenHelper(getContext());
		dbOpenHelper.getWritableDatabase();
	}
	
	public void testCount() throws Exception{
		PrivacyCalcSQLite service = new PrivacyCalcSQLite(this.getContext());
		long result = service.getCount();
		Log.i(tag, result+"");
	}
	
	public void testSave() throws Exception{
		PrivacyCalcSQLite service = new PrivacyCalcSQLite(this.getContext());
		for(int i = 3 ; i < 4 ; i++){
			CryptInfo ci = new CryptInfo();
//			Log.i(tag,ci.getFilename()+" "+ci.getHashid());
			ci.setHashid(ci.hashCode()+(i*i*i));
			ci.setFilepath("");
			ci.setFilename("hello.jpg");
			ci.setFilesize(15);
			ci.setFiletype("jpg");
			ci.setMove(false);
			ci.setDestpath("");
			ci.setCryptdate(ci.getCryptdate().toString());
			Log.i(tag,ci.getFiletype()+" "+ci.getHashid());
			service.save(ci);
		}
	}
	
	public void testDelete() throws Exception{
		PrivacyCalcSQLite service = new PrivacyCalcSQLite(this.getContext());
		service.delete(5);
	}
	
	public void testFind() throws Exception{
		PrivacyCalcSQLite service = new PrivacyCalcSQLite(this.getContext());
		CryptInfo ci = service.find(10);
		Log.i(tag, ci.toString());
	}
	
	public void testUpdate() throws Exception{
		PrivacyCalcSQLite service = new PrivacyCalcSQLite(this.getContext());
		CryptInfo ci = service.find(10);
		ci.setHashid(ci.hashCode());
		ci.setFilename("hello.jpg");
		ci.setFilepath("hi");
		ci.setDestpath("happy");
		service.update(ci);
		Log.i(tag, ci.toString());
	}
}
