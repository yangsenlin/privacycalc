package com.chuhan.privatecalc.model.watcher;

public class WatcherCenter {

	private final static ConcurrentWatcherList<DemoCryptWatcher> demoWatchers = new ConcurrentWatcherList<DemoCryptWatcher>(DemoCryptWatcher.class);
	
	/**
	 * 绑定和解绑事件
	 * @param watcher
	 * @param register
	 */
	public final static void bindDemoCryptListener(DemoCryptWatcher watcher, 
			boolean register) {
		demoWatchers.bind(register, watcher);
	}
	
	/**
	 *  回调进度
	 * @param uin
	 * @param fid
	 * @param current
	 * @param total
	 */
	public final static void triggerDemoCryptProgress(String uin, long fid, long current, long total) {
		demoWatchers.trigger("onProgress", uin, fid, current, total);
	}
	
	/**
	 * 回调加密成功
	 * @param uin
	 * @param result
	 */
	public final static void triggerDemoCryptSuccess(String uin, Object result) {
		demoWatchers.trigger("onSuccess", uin, result);
	}
	
}
