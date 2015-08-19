package com.yll.exception;

import java.util.concurrent.Callable;

public class NewException implements Callable<Boolean> {

	@Override
	public Boolean call() throws Exception {
	long start = System.currentTimeMillis();
	for (int i = 0; i < NewExceptionTester.LOOP; i++) {
	new CustomException("");
	}
	NewExceptionTester.newExceptionTimes.add(System.currentTimeMillis() - start);
	return true;
	}
}
