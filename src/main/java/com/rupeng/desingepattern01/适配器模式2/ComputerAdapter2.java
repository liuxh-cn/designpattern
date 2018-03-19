package com.rupeng.desingepattern01.适配器模式2;

public class ComputerAdapter2 extends Computer implements AutoCloseable{

	@Override
	public void close() {
		System.out.println("closed!");
	}

	
}
