package com.user.mongo;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class FindAllDocsInCollection {
	public static void main (String argd[]) {
		//Creating a Mongo client 
		  MongoClient mongoClient = MongoClients.create();
	      System.out.println("Connected to the database successfully");
	      
	      //Connecting to Database
	      MongoDatabase database = mongoClient.getDatabase("test");
	      System.out.println("Connected to Database test");
	      
	      //Accessing Collection
	      MongoCollection<Document> collection = database.getCollection("big");
	      System.out.println("Accessed Collection big");
	      
	      //Find All Documents in a Collection
	      MongoCursor<Document> cursor = collection.find().iterator();
	      try {
	          while (cursor.hasNext()) {
	              System.out.println(cursor.next().toJson());
	          }
	      } finally {
	          cursor.close();
	      }
	      
	      for (Document cur : collection.find()) {
	    	    System.out.println(cur.toJson());
	    	}
	}

}
