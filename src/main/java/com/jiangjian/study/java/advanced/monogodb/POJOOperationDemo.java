package com.jiangjian.study.java.advanced.monogodb;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.Arrays;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 * @author jiangjian
 */
public class POJOOperationDemo {
    public static void main(String[] args) {
        //设置转换器
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        //设置MongoClient配置
        MongoClient mongoClient = MongoClients.create(MongoClientSettings.builder().codecRegistry(pojoCodecRegistry)
                .applyToClusterSettings(builder ->
                        builder.hosts(Arrays.asList(new ServerAddress("192.168.79.20", 27017))))
                .build());

        //设置数据库
        MongoDatabase testDatabase = mongoClient.getDatabase("test");

        //设置collection名称
        MongoCollection<Person> personColl = testDatabase.getCollection("people", Person.class);

        //清空
        personColl.drop();

        //保存一个新的记录
        Person ada = new Person("jiangjian", 20, new Address("St James Square", "London", "W1"));
        personColl.insertOne(ada);

        //查询
        Person foundedPerson = personColl.find(and(eq("name", "jiangjian"), eq("age", 20))).first();
        System.out.println(foundedPerson);

        //更新
        System.out.println(personColl.updateOne(eq("name", "jiangjian"), set("age", 21)));

        //查询结果
        System.out.println(personColl.find(eq("name", "jiangjian")).first());

        personColl.deleteOne(eq("name", "jiangjian"));

        System.out.println("删除后，剩余数量为: " + personColl.countDocuments());

        //把数据库给删了
        testDatabase.drop();

        mongoClient.close();

    }
}
