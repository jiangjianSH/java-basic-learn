package com.jiangjian.study.java.advanced.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Random;

import static org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE;

public class Master implements Watcher {
    ZooKeeper zk;

    String serverId = Integer.toHexString(new Random().nextInt());

    boolean isLeader;

    String hostPort;

    Master(String hostPort) {
        this.hostPort = hostPort;
    }

    void startZK() throws IOException {
        zk = new ZooKeeper(hostPort, 15000, this);
    }

    void runForMaster() throws InterruptedException {
        while(true) {
            try {
                zk.create("/master", serverId.getBytes(), OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            } catch (KeeperException.NodeExistsException e) {
                isLeader = false;
                break;
            } catch (KeeperException.ConnectionLossException e) {

            } catch (KeeperException e) {
                e.printStackTrace();
            }
            if (checkMaster()) {
                break;
            }
        }
    }

    boolean checkMaster() {
        while(true) {
            try {
                Stat stat = new Stat();
                byte data[] = zk.getData("/master", false, stat);
                isLeader = new String(data).equals(serverId);
                return true;
            } catch (KeeperException.NoNodeException e) {
                return false;
            } catch (KeeperException.ConnectionLossException e) {

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (KeeperException e) {
                e.printStackTrace();
            }
        }
    }


    void stopZk() throws InterruptedException {
        zk.close();
    }
    public static void main(String[] args) throws Exception {
        Master m = new Master("192.168.163.140:2181");

        m.startZK();

        m.runForMaster();

        if (m.isLeader) {
            System.out.println("I am leader");
            Thread.sleep(60000000);
        } else {
            System.out.println("Someone else is the leader");
        }

        m.stopZk();
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println("###ENV: " + event);
    }
}
