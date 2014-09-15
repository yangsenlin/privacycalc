package com.chuhan.privatecalc.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashSet<E> implements Set<E> {

	ConcurrentHashMap<E, Object> mHashMap;
	
	private static Object mHolder = new Object();
	
	public ConcurrentHashSet() {
		mHashMap = new ConcurrentHashMap<E, Object>(16, 0.9f, 1);
	}
	
	public ConcurrentHashSet(ConcurrentHashSet<E> source) {
		this();
		mHashMap.putAll(source.mHashMap);
	}
	
	@Override
	public boolean add(E entry) {
		mHashMap.put(entry, mHolder);
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> collection) {
		return mHashMap.keySet().addAll(collection);
	}

	@Override
	public void clear() {
		mHashMap.clear();
	}

	@Override
	public boolean contains(Object object) {
		return mHashMap.keySet().contains(object);
	}

	@Override
	public boolean containsAll(Collection<?> collection) {
		return mHashMap.keySet().containsAll(collection);
	}

	@Override
	public boolean isEmpty() {
		return mHashMap.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		return mHashMap.keySet().iterator();
	}

	@Override
	public boolean remove(Object object) {
		return mHashMap.keySet().remove(object);
	}

	@Override
	public boolean removeAll(Collection<?> collection) {
		return mHashMap.keySet().removeAll(collection);
	}

	@Override
	public boolean retainAll(Collection<?> collection) {
		return mHashMap.keySet().retainAll(collection);
	}

	@Override
	public int size() {
		return mHashMap.keySet().size();
	}

	@Override
	public Object[] toArray() {
		return mHashMap.keySet().toArray();
	}

	@Override
	public <T> T[] toArray(T[] array) {
		return mHashMap.keySet().toArray(array);
	}

}
