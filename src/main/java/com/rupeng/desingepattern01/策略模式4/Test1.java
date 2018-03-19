package com.rupeng.desingepattern01.策略模式4;

import java.io.File;
import java.io.FilenameFilter;

import org.junit.Test;

public class Test1 {
	
	@Test
	public void test1(){
		File dir = new File("C:\\Users\\liuxh\\rupeng\\Java高级版\\设计模式");
		String[] fileNmaes = dir.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".txt");
			}
		});
		System.out.println("全部文件名：");
		for(String filename : dir.list()){
			System.out.println(filename);
		}
		
		System.out.println("-----------------------------");

		System.out.println("过滤后文件名：");
		for(String filename : fileNmaes){
			System.out.println(filename);
		}
	}
}
