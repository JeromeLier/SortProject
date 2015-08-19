package com.yll.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewExceptionTester {

	public static final int LOOP = 1000000; // 单次循环数量
	public static final int THREADS = 10; // 并发线程数量

	public static final List<Long> newObjectTimes = new ArrayList<Long>(THREADS);
	public static final List<Long> newExceptionTimes = new ArrayList<Long>(
			THREADS);
	public static final List<Long> newExtExceptionTimes = new ArrayList<Long>(
			THREADS);

	public static final ExecutorService POOL = Executors.newFixedThreadPool(30);

	public static void main(String[] args) throws Exception {
		List<Callable<Boolean>> all = new ArrayList<Callable<Boolean>>();
		all.addAll(tasks(new NewObject()));
		all.addAll(tasks(new NewException()));
		all.addAll(tasks(new NewExtException()));

		POOL.invokeAll(all);

		System.out.println("o:\t\t" + total(newObjectTimes));
		System.out.println("e:\t\t" + total(newExceptionTimes));
		System.out.println("exte:\t\t" + total(newExtExceptionTimes));

		POOL.shutdown();
	}

	private static List<Callable<Boolean>> tasks(Callable<Boolean> c) {
		List<Callable<Boolean>> list = new ArrayList<Callable<Boolean>>(THREADS);
		for (int i = 0; i < THREADS; i++) {
			list.add(c);
		}
		return list;
	}

	private static long total(List<Long> list) {
		long sum = 0;
		for (Long v : list) {
			sum += v;
		}
		return sum;
	}
}

