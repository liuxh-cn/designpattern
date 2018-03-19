package com.rupeng.desingepattern01.责任链模式1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HtmlReader implements ITextReader{

	@Override
	public boolean accept(File file) {
		String filename = FilenameUtils.getExtension(file.getName());
		return "html".equals(filename) || "htm".equals(filename);
	}

	@Override
	public String readAsString(File file) throws IOException {
		Document document = Jsoup.parse(file,null);
		return document.text();
	}

}
