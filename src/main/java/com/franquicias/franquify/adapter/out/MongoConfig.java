package com.franquicias.franquify.adapter.out;


import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import java.util.Arrays;


@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.franquicias.franquify.adapter.out.repositories")
public class MongoConfig {

    @Value("${spring.data.mongodb.host:mongodb}")
    private String host;

    @Value("${spring.data.mongodb.port:27017}")
    private int port;

    @Value("${spring.data.mongodb.username}")
    private String username;

    @Value("${spring.data.mongodb.password}")
    private String password;

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Value("${spring.data.mongodb.auth-database}")
    private String authDatabase;

    @Bean
    public MongoClient reactiveMongoClient() {
        MongoCredential credential = MongoCredential.createScramSha256Credential(
                username,
                authDatabase,
                password.toCharArray()
        );

        return MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(builder ->
                                builder.hosts(Arrays.asList(
                                        new ServerAddress(host, port)
                                ))
                        )
                        .credential(credential)
                        .build()
        );
    }
}