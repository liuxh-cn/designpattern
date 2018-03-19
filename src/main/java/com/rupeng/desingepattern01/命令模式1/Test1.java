package com.rupeng.desingepattern01.命令模式1;

public class Test1 {

	public static void main(String[] args) {
		Runnable r = new Runnable() {
			public void run() {
				System.out.println("run");
			}
		};//做什么
		
		Thread t = new Thread(r);
		t.start();//什么时候做
	}
}
