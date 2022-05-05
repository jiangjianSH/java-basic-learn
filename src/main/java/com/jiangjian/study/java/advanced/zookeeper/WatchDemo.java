package com.jiangjian.study.java.advanced.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class WatchDemo implements Watcher {
    ZooKeeper zk;

    String hostPort;

    WatchDemo(String hostPort) {
        this.hostPort = hostPort;
    }
    private static final Logger LOG = LoggerFactory.getLogger(WatchDemo.class);

    @Override
    public void process(WatchedEvent event) {
        System.out.println(event);
        if (event.getType() == Event.EventType.NodeCreated) {
            System.out.println(event.getPath());
        } else if (event.getType() == Event.EventType.NodeDataChanged) {
            LOG.info("[Watcher]NodeDataChanged:" + event);
        } else if (event.getType() == Event.EventType.NodeChildrenChanged
                || event.getType() == Event.EventType.NodeDeleted
                || event.getType() == Event.EventType.NodeCreated) {
            LOG.info("[Watcher]NodeChanged:" + event);
        } else {
            LOG.warn("Unhandled event:" + event);
        }
    }

    void startZK() throws IOException {
        zk = new ZooKeeper(hostPort, 15000, this);
    }
    public static void main(String args[])
            throws Exception {
        WatchDemo m = new WatchDemo("192.168.163.140:2181");
        m.startZK();

        Thread.sleep(30000);
    }

}
