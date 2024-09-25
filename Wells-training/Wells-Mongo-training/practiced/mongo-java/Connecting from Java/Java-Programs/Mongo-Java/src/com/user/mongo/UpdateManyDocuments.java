package com.user.mongo;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;

import static com.mongodb.client.model.Filters.lt;
import static com.mongodb.client.model.Updates.inc;

public class UpdateManyDocuments {
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
	      
	      //Update Multiple Documents
	      UpdateResult updateResult = collection.updateMany(lt("i", 100), inc("i", 100));
	      System.out.printf("Updated %d %s", updateResult.getModifiedCount(), "documents");

	}

}
