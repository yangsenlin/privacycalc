package com.chuhan.privatecalc.model.watcher;

public interface DemoCryptWatcher {
	
	public void onProgress(String uin, long fid, long current, long total);
	
	public void onSuccess(String uin, Object result);
	
	public void onError(String uin, long fid, Object error);
	
	public void onComplete();
}
