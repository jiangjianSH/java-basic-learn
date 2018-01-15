package com.jiangjian.study.java.advanced.monogodb;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Arrays;

public class ConnectionDemo {
    public static void main(String[] args) {
        MongoClient mongoClient = null;
        try {
            MongoCredential credential = MongoCredential.createCredential("jiangjian", "admin", "123456".toCharArray());
            mongoClient = new MongoClient(new ServerAddress("localhost"));
            mongoClient.setWriteConcern(WriteConcern.JOURNALED);
            for(String databaseName : mongoClient.getDatabaseNames()) {
                System.out.println(databaseName);
            }
            DB tutorialDB = mongoClient.getDB("tutorial");
            DBCollection numberCollection = tutorialDB.getCollection("user");
            DBCursor dbCursor = numberCollection.find();
            while(dbCursor.hasNext()) {
                DBObject value = dbCursor.next();
                System.out.println( value);
            }

            BasicDBObject object = new BasicDBObject("name", "fangjuan").append("age", 25).append("favoriates", new BasicDBObject("movies", "TT").append("husband", "jiangjian"));
            numberCollection.insert(object);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }finally {
            if(mongoClient != null) {
                mongoClient.close();
            }
        }
    }
}
