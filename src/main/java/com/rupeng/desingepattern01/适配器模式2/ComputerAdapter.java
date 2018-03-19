package com.rupeng.desingepattern01.适配器模式2;

public class ComputerAdapter implements AutoCloseable{
	
	private Computer computer;
	
	public ComputerAdapter(Computer computer) {
		this.computer = computer;
	}
	
	@Override
	public void close() throws Exception {
		computer.close();
	}

}
