package com.rupeng.desingepattern01.策略模式1;

import org.apache.commons.codec.digest.DigestUtils;
/**
 * 如果增加新的散列算法，需要增加新的ifelse进行判断，破坏了开闭原则
 * @author liuxh
 *
 */
public class Test {
	
	private String salt="rupeng.com";
	private HashType hashType;
	public Test(HashType hashType) {
		this.hashType = hashType;
	}

	public static void main(String[] args) {		
		Test t = new Test(HashType.MD5);
		String hash = t.calcStringHash("123456");
		System.out.println(hash);
		System.out.println(t.checkStringHash("d318dcc7b247780e119e0f5d3e687989", "123456"));
		System.out.println(t.checkStringHash("d318dcc7b2x7780e119e0f5d3e687989", "123456"));
	}
	
	public String calcStringHash(String value)
	{
		if(hashType==HashType.MD5)
		{
			return DigestUtils.md5Hex(value+salt);
		}
		else if(hashType==HashType.SHA1)
		{
			return DigestUtils.sha1Hex(value+salt);
		}
		else if(hashType==HashType.SHA256)
		{
			return DigestUtils.sha256Hex(value+salt);
		}
		else
		{
			throw new RuntimeException("未知的散列算法");
		}
	}
	
	public boolean checkStringHash(String hashValue,String value)
	{
		String hashValue2 = calcStringHash(value);
		return hashValue2.equalsIgnoreCase(hashValue);
	}
}

