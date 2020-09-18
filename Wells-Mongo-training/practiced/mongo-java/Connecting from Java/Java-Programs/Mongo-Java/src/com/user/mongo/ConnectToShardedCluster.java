package com.user.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class ConnectToShardedCluster {
	public static void main(String args[]) {
		// Connect to single mongos instance
		 MongoClient mongoClient = MongoClients.create( "mongodb://localhost:27017" );
		 /*
		  *Connect to Multiple mongos
		  *MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017,localhost:27018");
		  */
		 /*
		  *  MongoClient mongoClient = MongoClients.create(
            MongoClientSettings.builder()
                    .applyToClusterSettings(builder ->
                            builder.hosts(Arrays.asList(
                                    new ServerAddress("host1", 27017),
                                    new ServerAddress("host2", 27017))))
                    .build());
		  */
		 System.out.println("Connected to Sharded Cluster");
	}

}
