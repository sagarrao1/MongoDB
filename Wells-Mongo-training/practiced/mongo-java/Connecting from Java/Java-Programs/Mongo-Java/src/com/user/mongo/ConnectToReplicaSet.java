package com.user.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class ConnectToReplicaSet {
	public static void main (String args[]) {
		 MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017,localhost:27018,localhost:27019");
		 // MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017,localhost:27018,localhost:27019/?replicaSet=myReplicaSet");
		 /*
		    MongoClient mongoClient = MongoClients.create(
            MongoClientSettings.builder()
                    .applyToClusterSettings(builder ->
                            builder.hosts(Arrays.asList(
                                    new ServerAddress("localhost", 27017),
                                    new ServerAddress("localhost", 27018),
                                    new ServerAddress("localhost", 27019))))
                    .build());
		  */
		 System.out.println("Connected to the Replica Set");
	}

}
