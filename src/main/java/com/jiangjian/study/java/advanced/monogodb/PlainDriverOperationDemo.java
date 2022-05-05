package com.jiangjian.study.java.advanced.monogodb;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Updates.inc;

public class PlainDriverOperationDemo {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create(MongoClientSettings.builder()
                .applyToClusterSettings(builder ->
                        builder.hosts(Arrays.asList(new ServerAddress("192.168.79.20", 27017))))
                .build());

        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> numbers = database.getCollection("numbers");
        System.out.println(numbers.find().first());
//
//        Document doc = new Document("name", "MongoDB")
//                .append("type", "database")
//                .append("count", 1)
//                .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
//                .append("info", new Document("x", 203).append("y", 102));
//        numbers.insertOne(doc);
//
        MongoCollection<Document> serialNums = database.getCollection("serialNums");
        MongoCursor<Document> it = serialNums.find().iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        List<Document> nums = new ArrayList<>();
        IntStream.rangeClosed(0, 100).forEach(num -> nums.add(new Document("value", num)));
        serialNums.insertMany(nums);

        System.out.println(serialNums.countDocuments());

        serialNums.find(eq("value", 10)).iterator().forEachRemaining(System.out::println);

        System.out.println(serialNums.updateOne(eq("value", 10), new Document("$set", new Document("city", "shanghai"))));

        serialNums.find(eq("value", 10)).iterator().forEachRemaining(System.out::println);

        serialNums.updateMany(eq("value", 100), inc("value", 10));

        System.out.println(serialNums.deleteOne(gt("value", 99)));

        serialNums.find(gt("value", 98)).iterator().forEachRemaining(System.out::println);

        serialNums.drop();

        mongoClient.close();

    }
}
