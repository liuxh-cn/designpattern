package com.rupeng.desingepattern01.适配器模式2;

import org.junit.Test;
/**
 * 这里才是狭义上的适配器模式，也是用的最多的情况
 * @author liuxh
 *
 */
public class Test1 {

	/**
	 * 适配器模式在不修改Computer代码的情况下使用try-with-resource
	 * 把一个没有实现closeable接口的类转换成实现了closeable接口的类
	 * @param args
	 */
	public static void main(String[] args) {
		Computer c = new Computer();
		try(ComputerAdapter computer = new ComputerAdapter(c);) {
			c.play();
		} catch (Exception e) {

		}
	}
	
	@Test
	public void test2(){
		try(ComputerAdapter2 computer2 = new ComputerAdapter2()){
			computer2.play();
		} catch (Exception e){
			
		}
	}
}
