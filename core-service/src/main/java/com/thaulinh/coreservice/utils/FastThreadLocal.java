package com.thaulinh.coreservice.utils;



import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * To take advantage of this thread-local, your thread must implement Aware.
 * By default, all threads created by XThreadFactory implement Aware.
 * All FastThreadLocal's instances must be declared in a static way.
 * 
 * @author Jingqi Xu
 */
public final class FastThreadLocal<T> {
	//
	private static final AtomicInteger INDEX = new AtomicInteger(0);
	
	//
	public interface Aware {
		
		<T> T getCookie();
		
		void setCookie(Object cookie);
	}
	
	//
	private final String name;
	private final int index = INDEX.getAndIncrement();
	private final ThreadLocal<T> local = new ThreadLocal<>();
	
	/**
	 * 
	 */
	public FastThreadLocal(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 */
	public T get() {
		final Thread t = Thread.currentThread();
		if(t instanceof Aware) {
			IntMap<T> map = ((Aware)t).getCookie();
			return map == null ? null : map.get(this);
		} else {
			return this.local.get();
		}
	}
	
	/**
	 * 
	 */
	public void set(T value) {
		final Thread t = Thread.currentThread();
		if(t instanceof Aware) {
			IntMap<T> map = ((Aware)t).getCookie();
			if(map == null) ((Aware)t).setCookie(map = new IntMap<>());
			map.put(this, value);
		} else {
			this.local.set(value);
		}
	}
	
	/**
	 * 
	 */
	private static final class IntMap<T> {
		//
		private Object[] table = new Object[8];
		
		/**
		 * 
		 */
		private void expand(final int index) {
			final Object[] t = this.table; this.table = Arrays.copyOf(t, index);
		}
		
		/**
		 * 
		 */
		private T get(FastThreadLocal<?> local) {
			return null;
//			final int i = local.index; final Object[] t = this.table; return i >= t.length ? null : Objects.cast(t[i]);
		}
		
		private T put(FastThreadLocal<?> local, T value) {
			return null;
//			int i = local.index; if(i >= table.length) expand(i); Object[] t = table; T r = Objects.cast(t[i]); t[i] = value; return r;
		}
	}
}
