package com.opslab.zookeeper.curator;

import com.opslab.zookeeper.App;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.RetryUntilElapsed;

/**
 * 节点监听
 *
 * @author jerome_s@qq.com
 */
public class _7NodeListener {

	public static void main(String[] args) throws Exception {

		RetryPolicy retryPolicy = new RetryUntilElapsed(5000,1000);

		CuratorFramework client = CuratorFrameworkFactory.builder().connectString(App.HOST)
				.sessionTimeoutMs(App.TIME_OUT)
				.retryPolicy(retryPolicy)
				.build();

		client.start();

		@SuppressWarnings("resource")
		final NodeCache cache = new NodeCache(client, "/node1");
		cache.start();
		cache.getListenable().addListener(new NodeCacheListener() {
			public void nodeChanged() throws Exception {
				byte[] ret = cache.getCurrentData().getData();
				System.out.println("new data:" + new String(ret));
			}
		});

		Thread.sleep(Integer.MAX_VALUE);
	}
	


}
