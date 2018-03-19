package com.rupeng.desingepattern01.访问者模式2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;
import org.junit.Test;

public class Test1 {

	private Document doc = null;

	{
		try {
			doc = Jsoup.parse(new URL("http://www.rupeng.com"), 3000);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 打印html中所有图片地址
	 */
	@Test
	public void test1() {
		ParseImgVisitor imgVisitor = new ParseImgVisitor();
		NodeTraversor.traverse(imgVisitor, doc);
		for (String url : imgVisitor.getImgUrls()) {
			System.out.println(url);
		}
	}

	/**
	 * 下载html中所有图片
	 * 
	 * @throws MalformedURLException
	 */
	@Test
	public void test2() throws MalformedURLException {
		ParseImgVisitor imgVisitor = new ParseImgVisitor();
		NodeTraversor.traverse(imgVisitor, doc);
		int i = 0;
		for (String imgUrl : imgVisitor.getImgUrls()) {
			System.out.println(imgUrl);
			URL url = new URL(imgUrl);
			try (InputStream inStream = url.openStream();
				 OutputStream outStream = new FileOutputStream(
						new File("C:\\Users\\liuxh\\rupeng\\Java高级版\\设计模式\\resource\\downloadImg\\" + i++ + ".png"))) {
				IOUtils.copy(inStream, outStream);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
}

class ParseImgVisitor implements NodeVisitor {
	private List<String> imgUrls = new LinkedList();

	@Override
	public void head(Node node, int depth) {
		if (node.nodeName().equals("img")) {
			imgUrls.add(node.attr("src"));
		}
	}

	@Override
	public void tail(Node node, int depth) {
		// TODO Auto-generated method stub

	}

	public String[] getImgUrls() {
		return imgUrls.toArray(new String[imgUrls.size()]);
	}

}

class DownloadImgVisitor implements NodeVisitor {

	@Override
	public void head(Node node, int depth) {
		if (node.nodeName().equals("img")) {

		}
	}

	@Override
	public void tail(Node node, int depth) {
		// TODO Auto-generated method stub

	}

}
