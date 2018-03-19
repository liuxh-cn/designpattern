package com.rupeng.desingepattern01.模板方法1;

public class JobImpl1 extends Job{

	@Override
	protected boolean job1() {
		return System.currentTimeMillis() % 2 == 0;
	}

	@Override
	protected void job2() {
		System.out.println("早上好");
	}

	@Override
	protected void job3() {
		System.out.println("晚上好");
	}

	public static void main(String[] args) {
		new JobImpl1().execute();
	} 
}
