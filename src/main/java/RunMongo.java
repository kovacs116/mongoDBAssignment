import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class RunMongo {

    public static void main( String[] args){
        MongoClient mongoClient = new MongoClient();
        ArrayList<Document> laptops = new ArrayList<>();
        MongoDatabase database = mongoClient.getDatabase("LocalDB");
        MongoCollection<Document> collection = database.getCollection("Laptops");
        Laptop asusLaptop = new Laptop("Asus","Laptop", "ZenBook 13");
        asusLaptop.setSpecifications(new Laptop.Specifications(
                "Intel® Core™ i9",
                "NVIDIA® GeForce RTX™ 2060",
                "32 GB",
                "1 TB SSD",
                "2021"
            )
        );

        laptops.add(asusLaptop.LaptopObject());
        Laptop lenovoLaptop = new Laptop("Lenovo","Laptop", "T14s (AMD)");
        lenovoLaptop.setSpecifications(new Laptop.Specifications(
                        "AMD Ryzen™ 7 Pro",
                        "AMD Radeon™ Vega",
                        "32 GB",
                        "1 TB SSD",
                        "2021"
                )
        );
        laptops.add(lenovoLaptop.LaptopObject());


        collection.insertOne(asusLaptop.LaptopObject());
        System.out.println("Added");

        MongoCursor<Document> singleSelectionCursor = collection.find().iterator();
        while (singleSelectionCursor.hasNext()){
            System.out.println(singleSelectionCursor.next());
        }

        collection.deleteOne(new Document("Manufacturer", "Asus"));

        MongoCursor<Document> afterDeleteCursor = collection.find().iterator();
        while (afterDeleteCursor.hasNext()){
            System.out.println(afterDeleteCursor.next());
        }

        System.out.println("Deleted");

        collection.insertMany(laptops);
        MongoCursor<Document> insertManyCursor = collection.find().iterator();
        while (insertManyCursor.hasNext()){
            System.out.println(insertManyCursor.next());
        }
        System.out.println("Added 2");

        Laptop newLaptop = new Laptop("Asus","Notebook", "ZenBook 13");
        newLaptop.setSpecifications(new Laptop.Specifications(
                        "Intel® Core™ i9",
                        "NVIDIA® GeForce RTX™ 2060",
                        "64 GB",
                        "2 TB SSD",
                        "2021"
                )
        );


        collection.replaceOne(asusLaptop.LaptopObject(), new Document(newLaptop.LaptopObject()));
        MongoCursor<Document> updateCursor = collection.find().iterator();
        while (updateCursor.hasNext()){
            System.out.println(updateCursor.next());
        }
        System.out.println("Updated");

        //MongoCursor<Document> conditionalUpdateCursor = collection.updateMany()

    }
}
