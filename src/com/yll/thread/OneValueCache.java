package com.yll.thread;

import java.math.BigInteger;
import java.util.Arrays;

import jdk.nashorn.internal.ir.annotations.Immutable;

/**
 * 就像名字一样，这些注解是针对类的。主有要以下三个：
 * @Immutable
 * @ThreadSafe
 * @NotThreadSafe
 * 
 * 
 * @ThreadSafe 是表示这个类是线程安全的。具体是否真安全，那要看实现者怎么实现的了，反正打上这个标签只是表示一下。不线程安全的类打上这个注解也没事儿。
 * @Immutable 表示，类是不可变的，包含了　@ThreadSafe　的意思。
 * @NotThreadSafe 表示这个类不是线程安全的。如果是线程安全的非要打上这个注解，那也不会报错。
 * 这三个注解，对用户和维护者是有益的，用户可以立即看出来这个类是否是线程安全的，维护者则是可以根据这个注解，重点检查线程安全方面。另外，代码分析工具可能会利用这个注解。
 * 
 * @author Yuelili
 *
 */
@Immutable
public class OneValueCache {
	
	private final BigInteger lastNumber;
	private final BigInteger[] lastFactors;
	
	public OneValueCache(BigInteger i, BigInteger[] arrays) {
		lastNumber = i;
		lastFactors = Arrays.copyOf(arrays, arrays.length);
	}
	public BigInteger[] getFactors(BigInteger i) {
		if(lastNumber == null || !lastNumber.equals(i)) 
			return null;
		else 
			return Arrays.copyOf(lastFactors, lastFactors.length);
		
	}
}
