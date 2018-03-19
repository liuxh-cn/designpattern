package com.rupeng.desingepattern01.命令模式1;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
/**
 * ThreadPoolExecutor JDK1.5内置线程池
 * @author liuxh
 *
 */
public class Test2 {

	public static void main(String[] args) {
		Runnable r = new Runnable() {
			public void run() {
				System.out.println("run");
			}
		};//做什么
	
		ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
		executor.execute(r);
		
	}
}
