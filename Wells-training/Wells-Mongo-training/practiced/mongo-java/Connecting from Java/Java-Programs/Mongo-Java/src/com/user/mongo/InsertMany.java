package com.user.mongo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class InsertMany {
	public static void main(String args[]) {
		//Creating a Mongo client 
		  MongoClient mongoClient = MongoClients.create();
	      System.out.println("Connected to the database successfully");
	      
	      //Connecting to Database
	      MongoDatabase database = mongoClient.getDatabase("test");
	      System.out.println("Connected to Database test");
	      
	      //Accessing Collection
	      MongoCollection<Document> collection = database.getCollection("big");
	      System.out.println("Accessed Collection big");
	      
	      //Insert Multiple Documents
	      List<Document> documents = new ArrayList<Document>();
	      for (int i = 0; i < 100; i++) {
	          documents.add(new Document("i", i));
	      }
	      collection.insertMany(documents);  //inserts multiple docs
	      System.out.println("Inserted multiple documents");
	}

}
