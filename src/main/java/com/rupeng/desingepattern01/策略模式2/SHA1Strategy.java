package com.rupeng.desingepattern01.策略模式2;

import org.apache.commons.codec.digest.DigestUtils;

public class SHA1Strategy implements IDigestStragety{

	@Override
	public String digest(String data) {
		return DigestUtils.sha1Hex(data);
	}

}
