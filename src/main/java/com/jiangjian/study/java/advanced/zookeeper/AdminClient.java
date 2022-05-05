package com.jiangjian.study.java.advanced.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import static org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE;

public class AdminClient implements Watcher {
    ZooKeeper zk;

    String serverId = Integer.toHexString(new Random().nextInt());


    String hostPort;


    public AdminClient(String hostPort) {
        this.hostPort = hostPort;
    }

    void startZK() throws IOException {
        zk = new ZooKeeper(hostPort, 5000, this);
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println(event);
    }

    void listState() throws KeeperException, InterruptedException {
        Stat stat = new Stat();
        byte masterData [] = zk.getData("/master", false, stat);
        Date startDate = new Date(stat.getCtime());
        System.out.println("Master: " + new String(masterData) + " since " + startDate);

        System.out.println("Workers:");
        for(String w : zk.getChildren("/workers", false)) {
            byte data[] = zk.getData("/workers/" + w, false, null);
            System.out.println("\t" + w + ":" + new String(data));
        }

        System.out.println("Tasks:");
        for(String t : zk.getChildren("/tasks", false)) {
            byte data[] = zk.getData("/tasks/" + t, false, null);
            System.out.println("\t" + t + ":" + new String(data));
        }
    }
    public static void main(String[] args) throws InterruptedException, IOException, KeeperException {
        AdminClient client = new AdminClient("192.168.163.140:2181");
        client.startZK();
        client.listState();

    }
}
