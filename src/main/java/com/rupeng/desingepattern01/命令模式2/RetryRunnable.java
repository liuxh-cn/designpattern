package com.rupeng.desingepattern01.命令模式2;
/**
 * 自动重试框架
 * @author liuxh
 *
 */
public interface RetryRunnable {
	void run() throws Exception;
}
