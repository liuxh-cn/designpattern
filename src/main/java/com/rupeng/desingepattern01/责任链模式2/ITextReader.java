package com.rupeng.desingepattern01.责任链模式2;

import java.io.File;
import java.io.IOException;

public interface ITextReader {

	public boolean accept(File file);
	public String readAsString(File file) throws IOException;
}
