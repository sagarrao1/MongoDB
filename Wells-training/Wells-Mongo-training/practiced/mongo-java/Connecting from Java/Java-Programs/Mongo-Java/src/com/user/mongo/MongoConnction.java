package com.user.mongo;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;


public class MongoConnction {
	public static void main( String args[] ) {  
	      
	      // Creating a Mongo client 
		  MongoClient mongoClient = MongoClients.create();
		  //MongoClient mongoClient = MongoClients.create("mongodb://host1:27017");
	      System.out.println("Connected to the database successfully");

	}
}
