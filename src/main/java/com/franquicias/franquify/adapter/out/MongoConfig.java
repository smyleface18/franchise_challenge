package com.franquicias.franquify.adapter.out;



import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.franquicias.franquify.adapter.out.repositories")
@ConfigurationProperties(prefix = "spring.mongodb")
public class MongoConfig {

    private String uri;
    private String database;

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    @Bean
    public MongoClient reactiveMongoClient() {
        return MongoClients.create(uri);
    }

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate(MongoClient mongoClient) {
        return new ReactiveMongoTemplate(mongoClient, database);
    }
}