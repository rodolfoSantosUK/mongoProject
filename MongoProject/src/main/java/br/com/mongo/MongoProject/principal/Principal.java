package br.com.mongo.MongoProject.principal;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.Arrays;

public class Principal {

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase("local");
        MongoCollection<Document> alunos = mongoDatabase.getCollection("alunos");
        Document aluno = alunos.find().first();
        System.out.println(aluno);

        Document novoAluno =    new Document("nome", "Rodolfo")
                .append("curso", new Document("nome", "Historia"))
                .append("notas", Arrays.asList(10, 9, 8))
                .append("habilidades", Arrays.asList(new Document().append("nome", "Ingles").append("nivel", "Básico"),
                        new Document().append("nome", "Espanhol").append("nivel", "Básico")));
        alunos.insertOne(novoAluno);

        alunos.updateOne(Filters.eq("nome", "Rodolfo"),
                new Document("$set", new Document("nome", "Rodolfo Santos")));

        mongoClient.close();
    }

}
