package com.rupeng.desingepattern01.命令模式2;

import java.net.URL;

import org.apache.commons.io.IOUtils;

public class Retry {

	public static boolean execute(int maxTimes,RetryRunnable command){
		for(int i=0;i<maxTimes;i++ ){
			try {
				command.run();
				return true;
			} catch (Exception e) {
				System.out.println("第"+ (i+1) +"次执行失败：" + e);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Retry.execute(3, new RetryRunnable() {
			
			public void run() throws Exception {
				URL url = new URL("http://www.rupeng.com");
				String html = IOUtils.toString(url,"UTF-8");
				System.out.println(html.substring(0, 20));
			}
		});
	}
}
