package com.rupeng.desingepattern01.策略模式2;
/**
 * 对扩展开放：增加新的加密算法只要增加新的加密实现子类
 * @author liuxh
 *
 */
public class Test {
	private static String data = "rupeng";
	IDigestStragety stragety = null;
	public Test(IDigestStragety stragety) {
		this.stragety = stragety;
	}
	
	public String calcHash(String data){
		return this.stragety.digest(data);
	}
	
	public boolean check(String hashValue, String data){
		return hashValue.equalsIgnoreCase(calcHash(data));
	}
	public static void main(String[] args) {
		System.out.println(new Test(new MD5Strategy()).calcHash(data));
	}
}
