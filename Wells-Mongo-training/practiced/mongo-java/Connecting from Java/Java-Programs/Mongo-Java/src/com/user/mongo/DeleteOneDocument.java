package com.user.mongo;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.eq;

public class DeleteOneDocument {
	public static void main (String args[]) {
		//Creating a Mongo client 
		  MongoClient mongoClient = MongoClients.create();
	      System.out.println("Connected to the database successfully");
	      
	      //Connecting to Database
	      MongoDatabase database = mongoClient.getDatabase("test");
	      System.out.println("Connected to Database test");
	      
	      //Accessing Collection
	      MongoCollection<Document> collection = database.getCollection("big");
	      System.out.println("Accessed Collection big");
	      
	      //Delete One Document that matches a Filter
	      collection.deleteOne(eq("i", 110));
	      System.out.println("Deleted document with i equal to 10");
	}

}
