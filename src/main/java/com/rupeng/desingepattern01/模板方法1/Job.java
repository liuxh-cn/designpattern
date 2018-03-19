package com.rupeng.desingepattern01.模板方法1;
/**
 * 模板方法模式：定义好自己能确定的执行逻辑，具体的执行方式和执行逻辑由子类去填充
 * @author liuxh
 *
 */
public abstract class Job {
	protected abstract boolean job1();
	protected abstract void job2();
	protected abstract void job3();

	/*
	 * 执行逻辑
	 */
	public void execute(){
		if(this.job1()){
			this.job2();
		}
		this.job3();
	}
}
