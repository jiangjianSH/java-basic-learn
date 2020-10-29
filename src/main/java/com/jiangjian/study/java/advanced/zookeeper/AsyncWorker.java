package com.jiangjian.study.java.advanced.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Random;

import static org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE;

public class AsyncWorker implements Watcher {
    ZooKeeper zk;

    String serverId = Integer.toHexString(new Random().nextInt());


    String hostPort;

    String status;

    public AsyncWorker(String hostPort) {
        this.hostPort = hostPort;
        this.status = "Idle";
    }

    void startZK() throws IOException {
        zk = new ZooKeeper(hostPort, 5000, this);
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println(event);
    }

    void register() {
        zk.create("/workers/worker-" + serverId, status.getBytes(), OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL, createWorkerCallback, null);
    }

    AsyncCallback.StringCallback createWorkerCallback = new AsyncCallback.StringCallback() {
        @Override
        public void processResult(int rc, String path, Object ctx, String name) {
            switch (KeeperException.Code.get(rc)) {
                case CONNECTIONLOSS:
                    register();
                    break;
                case NODEEXISTS:
                    System.out.println("节点已存在");
                    break;
                default:
                    System.out.println("异常原因:" + KeeperException.create(KeeperException.Code.get(rc), path));
            }
        }
    };

    AsyncCallback.StatCallback statusUpdateCallback = new AsyncCallback.StatCallback() {
        @Override
        public void processResult(int rc, String path, Object ctx, Stat stat) {
            switch (KeeperException.Code.get(rc)) {
                case CONNECTIONLOSS:
                    updateStatus((String) ctx);
            }
        }
    };

    void updateStatus(String status) {
        if (!status.equals(this.status)) {
            zk.setData("/workers/worker-" + serverId, status.getBytes(), -1, statusUpdateCallback, status);
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        AsyncWorker worker = new AsyncWorker("192.168.163.140:2181");
        worker.startZK();
        worker.register();
        Thread.sleep(5000);
        System.out.println("working");
        worker.updateStatus("Working");
        Thread.sleep(10000);
        System.out.println("done");
        worker.updateStatus("done");
        Thread.sleep(20000);
    }
}
