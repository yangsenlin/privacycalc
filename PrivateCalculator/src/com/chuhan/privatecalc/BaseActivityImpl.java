package com.chuhan.privatecalc;

import com.chuhan.privatecalc.view.ui.CHTips;
import com.chuhan.privatecalc.view.ui.CHTopbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class BaseActivityImpl {
	
	private static final String TAG = BaseActivityImpl.class.getSimpleName();
	
	public static final String FROM_ACTIVITY = "fromActivity";
	public static final String REQUEST_CODE = "requestCode";
	
	public static String mCurActivityName;
	
	private PageProvider mPage;
	private PageAccess mAccess;
	
	public BaseActivityImpl(PageProvider page, PageAccess access) {
		this.mPage = page;
		this.mAccess = access;
	}
	
	public interface PageProvider {
		public boolean isPage(Class<?> clazz);
		public boolean onDragBack(MotionEvent event);
		public void onBackPressed();
		public void initTips(CHTips tips);
		public Activity getActivity();
		public CHTopbar getTopBar();
		
		public boolean dispatchTouchEvent(MotionEvent event);
	}
	
	public interface PageAccess {
		public void superOnCreate(Bundle savedInstanceState);
		public void superOnDestory();
		public void superOnStart();
		public void superOnStop();
		public void superOnResume();
		public void superOnPause();
		
		public void superStartActivity(Intent intent);
		public void superStartActivityForResult(Intent intent, int requestCode);
		
		public void superFinish();
		public void superFinishActivity(int requestCode);
		
		public Object getPage();
	}
	
	public void onCreate(Bundle savedInstanceState) {
		//
	}
	
	public void onStart() {
		//
	}
	
	public void onStop() {
		//
	}
	
	public void onResume() {
		//
	}
	
	public void onPause() {
		//
	}
	
	public void startActivity(Intent intent) {
		//
	}
	
	public void startActivityForResult(Intent intent, int requestCode) {
		//
	}
	
	public void finish() {
		//
	}
	
	public void onDestory() {
		//
	}
	
	public void finishActivity(int requestCode) {
		//
	}
	
	public void isDestory() {
		// API 17
	}
	
	private boolean isResumed;
	
	public boolean isActivityResumed() {
		return isResumed;
	}
	
	public void finishWithNoCheck() {
		
	}
	
	public boolean hideKeyBorad() {
		return true;
	}
	
	public void registerNotification(boolean isRegist) {
		
	}
	
	public boolean dispatchTouchEvent(MotionEvent event) {
		return true;
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return true;
	}
	
	public boolean existPage(Class<?> clazz) {
		return true;
	}
}












