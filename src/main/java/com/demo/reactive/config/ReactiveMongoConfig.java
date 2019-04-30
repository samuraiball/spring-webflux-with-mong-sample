package com.demo.reactive.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableReactiveMongoRepositories
public class ReactiveMongoConfig extends AbstractReactiveMongoConfiguration  {
    @Override
    protected String getDatabaseName() {
        return "reactive";
    }

    @Override
    public MongoClient reactiveMongoClient() {
        return MongoClients.create();
    }
}
