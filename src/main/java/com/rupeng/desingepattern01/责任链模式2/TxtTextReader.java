package com.rupeng.desingepattern01.责任链模式2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

public class TxtTextReader extends AbstractFileExtDetectReader{

	@Override
	public String readAsString(File file) throws IOException {
		return FileUtils.readFileToString(file,"UTF-8");
	}

	@Override
	protected String[] getAcceptedFileExtNames() {
		return new String[]{"txt"};
	}

}
