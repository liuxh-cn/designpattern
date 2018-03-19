package com.rupeng.desingepattern01.责任链模式2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HtmlReader extends AbstractFileExtDetectReader{

	@Override
	public String readAsString(File file) throws IOException {
		Document document = Jsoup.parse(file,null);
		return document.text();
	}

	@Override
	protected String[] getAcceptedFileExtNames() {
		return new String[]{"html","htm"};
	}

}
