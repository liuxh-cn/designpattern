package com.rupeng.desingepattern01.访问者模式1;

import java.io.File;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Text;
import org.dom4j.VisitorSupport;
import org.dom4j.io.SAXReader;
import org.junit.Test;
/**
 * 遍历xml
 * 不用关心遍历细节，只需要写遍历到相应节点要做的事即可
 * accept()负责遍历xml节点，Visitor对象负责在相应节点做处理
 * 注意： 内部类应该和class同级，不应该放在class里面
 * @author liuxh
 *
 */
public class Test1 {
	SAXReader reader = new SAXReader();
	Document doc = null;
	//代码块用于初始化成员变量
	{
		try {
			doc = reader.read(new File("C:\\Users\\liuxh\\rupeng\\Java高级版\\设计模式\\resource\\MobileCodeWS.xml"));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 打印每个文本节点的内容
	 * @throws DocumentException
	 */
	@Test
	public void test1() throws DocumentException{
		doc.accept(new Test1Visitor());
	}
	
	/**
	 * 将所有文本内容去除空格组合在一起打印
	 */
	@Test
	public void test2(){
		Test2Visitor visitor2 = new Test2Visitor();
		doc.accept(visitor2);
		System.out.println("text : " + visitor2.getText());
	}
	
	public static void main(String[] args) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("C:\\Users\\liuxh\\rupeng\\Java高级版\\设计模式\\resource\\MobileCodeWS.xml"));
		doc.accept(new Test1Visitor());
	}
	
}

class Test1Visitor extends VisitorSupport{
	@Override
	public void visit(Text node) {
		System.out.println("visit text node : " + node.getStringValue());
	}
	
//	@Override
//	public void visit(Attribute node) {
//		System.out.println("visit attribute node : " + node.getName());
//	}

}

class Test2Visitor extends VisitorSupport{
	private StringBuilder builder = new StringBuilder();
	
	@Override
	public void visit(Text node) {
		String str = node.getText();
		if(str.trim().length() > 0){
			builder.append(str.trim()).append(System.lineSeparator());
		}
	}
	
	public String getText(){
		return builder.toString();
	}
}
