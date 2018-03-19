package com.rupeng.desingepattern01.解释器模式;

import java.io.File;
import java.io.InputStream;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
/**
 * Java中调用js脚本
 * @author liuxh
 *
 */
public class Test1 {
	
	ScriptEngineManager engineManager = new ScriptEngineManager();
	ScriptEngine engine;
	String js;
	{
		engine = engineManager.getEngineByName("JavaScript");
		
		try(InputStream inStream = Test1.class.getResourceAsStream("rule2.txt")) {
			js = IOUtils.toString(inStream,"UTF-8");

		} catch (Exception e) {
		}
	}
	
	/**
	 * Java调用js脚本
	 * @throws ScriptException
	 */
	@Test
	public void test1() throws ScriptException{
		 engine.put("基本工资", 3600);//给变量赋值
		 engine.put("招生人数", 1);
		 engine.put("迟到天数", 0);
		 
		 engine.eval(js);
		 
		 Object salary = engine.get("工资");
		 System.out.println("salary : " + salary);
	}
	
	/**
	 * Java调用的js脚本中可以调用Java方法
	 * @throws ScriptException 
	 */
	@Test
	public void test2() throws ScriptException{
		engine.put("age", 6);
		engine.put("sys", new People());
		engine.eval(js);
		
	}
}
