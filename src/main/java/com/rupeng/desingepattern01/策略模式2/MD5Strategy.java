package com.rupeng.desingepattern01.策略模式2;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Strategy implements IDigestStragety{

	@Override
	public String digest(String data) {
		return DigestUtils.md5Hex(data);
	}


}
