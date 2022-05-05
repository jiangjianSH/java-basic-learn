package com.jiangjian.study.java.advanced.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE;

public class AsyncMaster implements Watcher {
    ZooKeeper zk;

    String serverId = Integer.toHexString(new Random().nextInt());

    boolean isLeader;

    String hostPort;

    public void bootstrap() {
        createParent("/workers", new byte[0]);
        createParent("/assign", new byte[0]);
        createParent("/tasks", new byte[0]);
        createParent("/status", new byte[0]);

    }

    void createParent(String path, byte[] data) {
        zk.create(path, data, OPEN_ACL_UNSAFE, CreateMode.PERSISTENT, createParentCallback, data);
    }

    AsyncCallback.StringCallback createParentCallback = (rc, path, ctx, name) -> {
        switch (KeeperException.Code.get(rc)) {
            case CONNECTIONLOSS:
                createParent(path, (byte[]) ctx);
                return;
            case OK:
                System.out.println("### path is created: " + path);
                break;
            default:
                System.out.println("Something went wrong: " + KeeperException.create(KeeperException.Code.get(rc), path));
        }
    };

    AsyncCallback.StringCallback masterCreateCallback = new AsyncCallback.StringCallback() {
        @Override
        public void processResult(int rc, String path, Object ctx, String name) {
            switch (KeeperException.Code.get(rc)) {
                case CONNECTIONLOSS:
                    checkMaster();
                    return;
                case OK:
                    isLeader = true;
                    break;
                case NODEEXISTS:
                    masterExists();
                    break;
                default:
                    isLeader = false;
            }
            System.out.println("I'm " + (isLeader ? "" : " not ") + "the leader, id=" + serverId);
        }
    };

    public void masterExists() {
        zk.exists("/master", masterExistsWatcher, masterExistsCallback, null);
    }

    Watcher masterExistsWatcher = new Watcher() {
        @Override
        public void process(WatchedEvent event) {
            if (event.getType() == Event.EventType.NodeDeleted) {
                assert "/master".equals(event.getPath());
                runForMaster();
            }
        }
    };

    AsyncCallback.StatCallback masterExistsCallback = new AsyncCallback.StatCallback() {
        @Override
        public void processResult(int rc, String path, Object ctx, Stat stat) {
            switch (KeeperException.Code.get(rc)) {
                case CONNECTIONLOSS:
                    masterExists();
                    break;
                case OK:
                    if (stat == null) {
                        runForMaster();
                    }
                    break;
                default:
                    checkMaster();
                    break;
            }
        }
    };

    void runForMaster() {
        zk.create("/master", serverId.getBytes(), OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL, masterCreateCallback, null);
    }

    AsyncCallback.DataCallback masterCheckCallback = (rc, path, ctx, data, stat) -> {
        switch (KeeperException.Code.get(rc)) {
            case CONNECTIONLOSS:
                checkMaster();
                return;
            case NONODE:
                runForMaster();
                return;
            case OK:
                if (Objects.equals(ctx, data)) {
                    isLeader = true;
                } else {
                    masterExists();
                }
                break;
            default:
                System.out.println("异常:"+ KeeperException.create(KeeperException.Code.get(rc), path));
        }
    };

    AsyncMaster(String hostPort) {
        this.hostPort = hostPort;
        System.out.println("###id: " + serverId);
    }

    void startZK() throws IOException {
        zk = new ZooKeeper(hostPort, 5000, this);
    }


    void checkMaster() {
       zk.getData("/master", false, masterCheckCallback, serverId);
    }


    void stopZk() throws InterruptedException {
        zk.close();
    }

    Watcher workersChangeWatcher = new Watcher() {
        @Override
        public void process(WatchedEvent event) {
            if (event.getType() == Event.EventType.NodeChildrenChanged) {
                assert "/workers".equals(event.getPath());
                getWorkers();
            }
        }
    };

    void getWorkers() {
        zk.getChildren("/workers",  workersChangeWatcher, workersGetChildrenCallback, null);
    }

    AsyncCallback.ChildrenCallback workersGetChildrenCallback = new AsyncCallback.ChildrenCallback() {
        @Override
        public void processResult(int rc, String path, Object ctx, List<String> children) {
            switch (KeeperException.Code.get(rc)) {
                case CONNECTIONLOSS:
                    getWorkers();
                    break;
                case OK:
                    System.out.println("Sucessfully get Children, size:" + children.size());
                    reassignAndSet(children);
                    break;
                default:
                    System.out.println("getChildren failed, reason:" + KeeperException.create(KeeperException.Code.get(rc), path));
            }
        }
    };



    private void reassignAndSet(List<String> children) {
    }

    public static void main(String[] args) throws Exception {
        AsyncMaster m = new AsyncMaster("192.168.163.140:2181");

        m.startZK();

        m.bootstrap();

        m.runForMaster();

        Thread.sleep(500000);
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println("###ENV: " + event);
    }
}
