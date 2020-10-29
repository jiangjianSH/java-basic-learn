package com.jiangjian.study.java.advanced.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryForever;
import org.apache.zookeeper.CreateMode;

public class Demo {
    private CuratorFramework zkc;

    private String connectString;

    public Demo(String connectString) {
        this.connectString = connectString;
    }

    public void start() {
        zkc =  CuratorFrameworkFactory.newClient(connectString, new RetryForever(5000));
    }

    public void createMaster() throws Exception {
        zkc.create().withMode(CreateMode.EPHEMERAL).forPath("/master", new byte[0]);
    }

    public static void main(String[] args) throws Exception {
        Demo d = new Demo("172.168.163.140:2181");
        d.start();
        d.createMaster();

        Thread.sleep(100000);
    }
}
