package com.rupeng.desingepattern01.责任链模式1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

public class TxtTextReader implements ITextReader{

	@Override
	public boolean accept(File file) {
		return "txt".equals(FilenameUtils.getExtension(file.getName()));
	}

	@Override
	public String readAsString(File file) throws IOException {
		return FileUtils.readFileToString(file,"UTF-8");
	}

}
