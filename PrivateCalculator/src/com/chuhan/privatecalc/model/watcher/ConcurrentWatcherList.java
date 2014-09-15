package com.chuhan.privatecalc.model.watcher;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

import android.util.Log;

import com.chuhan.privatecalc.utils.ConcurrentHashSet;

public class ConcurrentWatcherList<T> extends ConcurrentHashSet<T> {

	public final static String TAG = "ConcurrentWatcherList";
	
	private final Class<T> clazz;
	private ConcurrentHashMap<String, Method> methodInvoer = new ConcurrentHashMap<String, Method>();
	
	public ConcurrentWatcherList(Class<T> clazz) {
		super();
		this.clazz = clazz;
	}
	
	/**
	 * 绑定或移除事件
	 * @param register
	 * @param watcher
	 */
	public void bind(boolean register, T watcher) {
		if (register) {
			this.add(watcher);
		} else {
			this.remove(watcher);
		}
	}
	
	public void trigger(String eventName, Object...args) {
		Method event = methodInvoer.get(eventName);
		if (event == null) {
			Method[] methods = clazz.getMethods();
			for (Method md : methods) {
				Class<?>[] paramLen = md.getParameterTypes();
				if (md.getName().equals(eventName) && paramLen.length == args.length) {
					event = md;
					break;
				}
			}
			if (event != null) {
				methodInvoer.put(eventName, event);
			}
		}
		
		if (event != null) {
			Log.d(TAG, format(eventName, args));
			for (T t : this) {
				try {
					event.invoke(t, args);
				} catch (Exception e) {
					Log.e(TAG, clazz.getName() + "-" + eventName + ": " + e.toString());
				}
			}
		} else {
			Log.e(TAG, "Cannot find any method named " + eventName);
		}
	}
	
	private String format(String eventName, Object[] args) {
		StringBuilder log = new StringBuilder();
		log.append(clazz.getName()).append("#").append(eventName);
		for (Object obj : args) {
			log.append(" ");
			log.append(obj != null ? obj.toString() : "empty");
		}
		return log.toString();
	}
}
