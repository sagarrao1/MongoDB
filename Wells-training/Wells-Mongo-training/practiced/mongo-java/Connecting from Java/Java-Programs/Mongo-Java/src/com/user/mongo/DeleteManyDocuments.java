package com.user.mongo;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;

import static com.mongodb.client.model.Filters.gte;

public class DeleteManyDocuments {
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
	      
	      //Delete All Documents that Match a Filter
	      DeleteResult deleteResult = collection.deleteMany(gte("i", 100));
	      System.out.printf("%d %s", deleteResult.getDeletedCount(), "Documents deleted");
	}

}
