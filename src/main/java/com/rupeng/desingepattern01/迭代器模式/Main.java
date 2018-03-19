package com.rupeng.desingepattern01.迭代器模式;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
 * 狭义的迭代器模式就是指Iterator
 * Iterable : Iterator iterator();Iterator : boolean hasNext(),next()
 * 所有实现了Iterable接口的集合都可以使用增强for循环来遍历
 * @author liuxh
 *
 */
public class Main {

	public static void main(String[] args) {
		List<String> list = new LinkedList<String>();
		list.add("hello01");
		list.add("hello02");
		list.add("hello03");
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		System.out.println("增强for循环方式遍历：");
		for(String str : list){
			System.out.println(str);
		}
	}
}
