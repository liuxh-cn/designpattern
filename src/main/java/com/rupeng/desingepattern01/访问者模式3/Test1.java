package com.rupeng.desingepattern01.访问者模式3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.junit.Test;
/**
 * 检查java语法规范：遍历检查java代码变量名大写的变量
 * @author liuxh
 *
 */
public class Test1 {
	private CompilationUnit compilationUnit;
	
	{
		try {
			ASTParser astParser = ASTParser.newParser(AST.JLS9);
			String filePath = "C:\\Users\\liuxh\\workspace\\designpattern01\\src\\main\\java\\com\\rupeng\\desingepattern01\\访问者模式3\\Person.java";
			String source = FileUtils.readFileToString(new File(filePath), Charset.forName("UTF-8"));
			astParser.setSource(source.toCharArray());// 分析源代码
			compilationUnit = (CompilationUnit) astParser.createAST(null);// 解析源代码成CompilationUnit
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test1() {
		CheckVisitor checkVisitor = new CheckVisitor();
		compilationUnit.accept(checkVisitor);
		for(String problem : checkVisitor.getProblems()){
			System.out.println(problem);
		}
	}
}

class CheckVisitor extends ASTVisitor{
	private List<String> problems = new LinkedList<String>();
	
	@Override
	public boolean visit(VariableDeclarationFragment node) {
		String varName = node.getName().getIdentifier();
//		System.out.println(varName);
		char firstChar = varName.charAt(0);
		if(Character.isUpperCase(firstChar)){
			problems.add("变量名大写 ：" + varName);
		}
		return super.visit(node);
	}
	
	public String[] getProblems(){
		return problems.toArray(new String[problems.size()]);
	}
}
