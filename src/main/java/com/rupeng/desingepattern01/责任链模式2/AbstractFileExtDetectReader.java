package com.rupeng.desingepattern01.责任链模式2;

import java.io.File;

import org.apache.commons.io.FilenameUtils;

public abstract class AbstractFileExtDetectReader implements ITextReader{

	@Override
	public boolean accept(File file) {
		String fileExt = FilenameUtils.getExtension(file.getName());
		for(String ext : getAcceptedFileExtNames()){
			if(ext.equalsIgnoreCase(fileExt)){
				return true;
			}
		}
		return false;
	}
	
	protected abstract String[] getAcceptedFileExtNames();
}
