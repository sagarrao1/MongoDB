package com.user.mongo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

import org.bson.Document;
import org.bson.json.JsonWriterSettings;

import com.mongodb.Block;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;

public class Aggregation1 {
	public static void main (String args[]) {
		//Creating a Mongo client 
		  MongoClient mongoClient = MongoClients.create();
	      System.out.println("Connected to the database successfully");
	      
	      //Connecting to Database
	      MongoDatabase database = mongoClient.getDatabase("test");
	      System.out.println("Connected to Database test");
	      
	      //Accessing Collection
	      MongoCollection<Document> collection = database.getCollection("restaurants");
	      System.out.println("Accessed Collection restaurants");
	      
	      //Aggregation to find all bakers by stars
	      collection.aggregate(
	    		  Arrays.asList(
	    		          Aggregates.match(Filters.eq("categories", "Bakery")),
	    		          Aggregates.group("$stars", Accumulators.sum("count", 1))
	    		  )
	    		).into(new ArrayList<>()).forEach(printDocuments());
	      }
	      
		//This code prints the results of Aggregation
	      private static Consumer<Document> printDocuments() {
	          return doc -> System.out.println(doc.toJson(JsonWriterSettings.builder().indent(true).build()));
	}

} 