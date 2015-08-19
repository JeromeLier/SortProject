package com.yll.memchache;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

/**
 * Oct 15, 2011
 */
public class MemTest {
	// 创建一个 memcached 客户端对象

	protected static MemCachedClient mcc = new MemCachedClient();

	// 创建 memcached连接池

	static

	{ // 指定memcached服务地址

	String[] servers =

	{ "127.0.0.1:11211","127.0.0.1:11211", "127.0.0.1:11211" };

	// 指定memcached服务器负载量

	Integer[] weights ={ 3, 3, 2 };

	// 从连接池获取一个连接实例

	SockIOPool pool = SockIOPool.getInstance();

	// 设置服务器和服务器负载量

	pool.setServers( servers );

	pool.setWeights( weights );

	// 设置一些基本的参数

	//设置初始连接数5 最小连接数 5 最大连接数 250

	//设置一个连接最大空闲时间6小时

	pool.setInitConn( 5 );

	pool.setMinConn( 5 );

	pool.setMaxConn( 250 );

	pool.setMaxIdle( 1000 * 60 * 60 * 6 );

	// 设置主线程睡眠时间

	// 每隔30秒醒来 然后

	// 开始维护 连接数大小

	pool.setMaintSleep( 30 );

	// 设置tcp 相关的树形

	// 关闭nagle算法

	// 设置 读取 超时3秒钟 set the read timeout to 3 secs

	// 不设置连接超时

	pool.setNagle( false );

	pool.setSocketTO( 3000 );

	pool.setSocketConnectTO( 0 );

	// 开始初始化 连接池

	pool.initialize();

	// 设置压缩模式

	//如果超过64k压缩数据

	//mcc.setCompressEnable( true );

	//mcc.setCompressThreshold( 64 * 1024 );

	}

	public static void main(String args[]) {
		User u1 = new User();
        u1.setUserName("frady");
        u1.setEmail("weimengiq@126.com");
        mcc.add("fradyt", u1);
 
        User u2 = (User) mcc.get("fradyt");
        System.out.println("email=" + u2.getEmail());
        u2.setEmail("weimengiq@gmail.com");
        mcc.replace("fradyt", u2);
        mcc.add("hello1", "fun@@d");
        //mcc.get("");
        //mcc.flushAll();
        //mcc
        String[] tsrarray = {"hello1"};
       // mcc.flushAll(tsrarray);
        u2 = (User) mcc.get("fradyt");
        System.out.println(u2);
        System.out.println("email=" + u2.getEmail());
       

	}

	}

