package br.com.mongo.MongoProject.principal;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Principal {

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase("local");
        MongoCollection<Document> alunos = mongoDatabase.getCollection("alunos");
        Document aluno =  alunos.find().first();
        System.out.println(aluno);
        mongoClient.close();
    }

}
