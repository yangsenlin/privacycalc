package com.chuhan.privatecalc;

import com.chuhan.privatecalc.view.ui.CHTips;
import com.chuhan.privatecalc.view.ui.CHTopbar;

import android.app.Activity;
import android.view.MotionEvent;

public class BaseActivity extends Activity 
	implements BaseActivityImpl.PageProvider {

	@Override
	public boolean isPage(Class<?> clazz) {

		return false;
	}

	@Override
	public boolean onDragBack(MotionEvent event) {

		return false;
	}

	@Override
	public void initTips(CHTips tips) {
		
	}

	@Override
	public Activity getActivity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CHTopbar getTopBar() {
		// TODO Auto-generated method stub
		return null;
	}

}
