package com.rupeng.desingepattern01.责任链模式1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class TextParser {

	private static List<ITextReader> readers = new ArrayList();
	static
	{
		try(InputStream inStream = TextParser.class.getResourceAsStream("readers.txt")){
			List<String> lines = IOUtils.readLines(inStream, "UTF-8");
			for(String line : lines){
				Class<ITextReader> clazz = (Class<ITextReader>) Class.forName(line);
				readers.add(clazz.newInstance());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	public static String read(File file) throws Exception{
		for(ITextReader reader : readers){
			if(reader.accept(file)){
				return reader.readAsString(file);
			}
		}
		throw new Exception("没有找到合适的parser");
	}
	
	public static void main(String[] args) throws Exception {
//		System.out.println(read(new File("C:\\Users\\liuxh\\rupeng\\Java高级版\\设计模式\\resource\\1.txt")));
//		System.out.println(read(new File("C:\\Users\\liuxh\\rupeng\\Java高级版\\设计模式\\resource\\rupeng.html")));
		System.out.println(read(new File("C:\\Users\\liuxh\\rupeng\\Java高级版\\设计模式\\resource\\hello.docx")));
	}
}
