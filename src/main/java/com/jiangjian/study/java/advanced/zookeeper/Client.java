package com.jiangjian.study.java.advanced.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Random;

import static org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE;

public class Client implements Watcher {
    ZooKeeper zk;

    String serverId = Integer.toHexString(new Random().nextInt());


    String hostPort;


    public Client(String hostPort) {
        this.hostPort = hostPort;
    }

    void startZK() throws IOException {
        zk = new ZooKeeper(hostPort, 5000, this);
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println(event);
    }

    String queueCommand(String command) throws KeeperException.NodeExistsException {
        while(true) {
            try {
                String name = zk.create("/tasks/task-", command.getBytes(), OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
                return name;
            } catch (KeeperException.NodeExistsException e) {
                throw e;
            } catch (KeeperException.ConnectionLossException e) {

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (KeeperException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException, IOException, KeeperException.NodeExistsException {
        Client client = new Client("192.168.163.140:2181");
        client.startZK();
        client.queueCommand("shutdown");

    }
}
