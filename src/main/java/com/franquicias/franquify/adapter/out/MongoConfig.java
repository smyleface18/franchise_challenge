package com.franquicias.franquify.adapter.out;


import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import java.util.Arrays;


@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.franquicias.franquify.adapter.out.repositories")
public class MongoConfig {

    @Value("${spring.mongodb.uri}")
    private String uri;

    @Value("${spring.mongodb.database}")
    private String database;


    @Bean
    public MongoClient reactiveMongoClient() {

        return MongoClients.create(uri);
    }

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate(MongoClient mongoClient) {
        return new ReactiveMongoTemplate(mongoClient, database);
    }
}