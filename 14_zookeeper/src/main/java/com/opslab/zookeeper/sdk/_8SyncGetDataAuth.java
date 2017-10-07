package com.opslab.zookeeper.sdk;

import java.io.IOException;

import com.opslab.zookeeper.App;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * 根据权限获取数据
 *
 * @author jerome_s@qq.com
 */
public class _8SyncGetDataAuth implements Watcher {

	private static ZooKeeper zooKeeper;
	private static Stat stat = new Stat();





	@Override
	public void process(WatchedEvent event) {

		if (event.getState() == KeeperState.SyncConnected) {
			if (event.getType() == EventType.None && null == event.getPath()) {
				zooKeeper.addAuthInfo("digest", "jerome:1234".getBytes());
				try {
					//zooKeeper.delete("/node1", -1);
					System.out.println(new String(zooKeeper.getData("/node1", true, stat)));
				} catch (KeeperException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				if (event.getType() == EventType.NodeDataChanged) {
					try {
						System.out.println(new String(zooKeeper.getData(event.getPath(), true, stat)));
						System.out.println("stat:" + stat);
					} catch (KeeperException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
		zooKeeper = new ZooKeeper(App.HOST, App.TIME_OUT, new _8SyncGetDataAuth());
		Thread.sleep(Integer.MAX_VALUE);
	}

}
