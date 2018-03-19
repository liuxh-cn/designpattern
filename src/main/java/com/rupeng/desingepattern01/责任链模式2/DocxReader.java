package com.rupeng.desingepattern01.责任链模式2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class DocxReader extends AbstractFileExtDetectReader{

	@Override
	public String readAsString(File file) throws IOException {
		try(FileInputStream fis = new FileInputStream(file);
			XWPFDocument xdoc = new XWPFDocument(fis);
			XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
				) {
			return extractor.getText();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected String[] getAcceptedFileExtNames() {
		return new String[]{"docx","doc"};
	}

}
