package example.tce.cloud.mongodbJDBC;

import java.net.UnknownHostException;
import java.util.Date;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

public class App {
	public static void main(String[] args) {
		try {

			/**** Connect to MongoDB ****/
			// Since 2.10.0, uses MongoClient
			MongoClient mongo = new MongoClient("localhost", 27017);

			/**** Get database ****/
			// if database doesn't exists, MongoDB will create it for you
			DB db = mongo.getDB("testdb");

			/**** Get collection / table from 'testdb' ****/
			// if collection doesn't exists, MongoDB will create it for you
			DBCollection table = db.getCollection("student");

			/**** Insert ****//*
			// create a document to store key and value
			BasicDBObject document = new BasicDBObject();
			document.put("name", "saravanan");
			document.put("empno", 532);
			document.put("createdDate", new Date());
			table.insert(document);*/

			/**** Update ****/
			// search document where name="saravanan" and update it with new values
			BasicDBObject query = new BasicDBObject();
			query.put("name", "Alice");

			BasicDBObject newDocument = new BasicDBObject();
			newDocument.put("name", "Alex-1");

			BasicDBObject updateObj = new BasicDBObject();
			updateObj.put("$set", newDocument);

			//table.update(query, updateObj);
			table.updateMulti(query, updateObj);
			
			/**** Find and display ****/
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("name", "Alice");

			DBCursor cursor = table.find(searchQuery);

			System.out.println("Search for name" + cursor.count());
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}

			/**** Find and display ****/
			BasicDBObject searchQuery2 = new BasicDBObject().append("name","Alex-1");

			DBCursor cursor2 = table.find(searchQuery2);

			System.out.println("Search for updated name" + cursor2.count());
			while (cursor2.hasNext()) {
				System.out.println(cursor2.next());
			}

			/**** Done ****/
			System.out.println("Done");

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}

	}
}
