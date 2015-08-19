package com.yll.exception;

import java.util.concurrent.Callable;

public class NewObject implements Callable<Boolean> {

	@Override
	public Boolean call() throws Exception {
		long start = System.currentTimeMillis();
		for (int i = 0; i < NewExceptionTester.LOOP; i++) {
			new CustomObject("");
		}
		NewExceptionTester.newObjectTimes.add(System.currentTimeMillis() - start);
		return true;
	}

}
