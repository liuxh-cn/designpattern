package com.rupeng.desingepattern01.策略模式3;

import java.util.Arrays;
import java.util.Comparator;

import javax.management.RuntimeErrorException;

import org.junit.Test;

/**
 * 策略模式在JDK中的应用：Arrays.sort(Object[],Comparator)指定策略（Comparator封装策略）排序
 * @author liuxh
 *
 */

public class Test1 {
	@Test
	public void test1() {
		int[] nums = {3,1,5,6,23,4};
		Arrays.sort(nums);
		for(int num : nums){
			System.out.println(num);
		}
	}
	
	@Test
	public void test2(){
		People p01 = new People("liuxh01",25);
		People p02 = new People("liuxh02",23);
		People p03 = new People("liuxh03",26);
		People[] peoples = {p01,p02,p03};
		Arrays.sort(peoples,new Comparator(){

			@Override
			public int compare(Object o1, Object o2) {
				if(o1 instanceof People && o2 instanceof People){
					People p1 = (People)o1;
					People p2 = (People)o2;
					return p1.age - p2.age;
				}else{
					throw new RuntimeException();
				}
			}
			
		});
		
		for(People p : peoples){
			System.out.println(p.name);
		}
	}
	
	class People{
		String name;
		int age;
		public People(String name,int age) {
			this.name = name;
			this.age = age;
		}
	}
}
