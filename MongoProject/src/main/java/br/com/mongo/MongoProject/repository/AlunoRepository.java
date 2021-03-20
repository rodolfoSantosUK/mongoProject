package br.com.mongo.MongoProject.repository;

import br.com.mongo.MongoProject.entity.Aluno;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.stereotype.Repository;

@Repository
public class AlunoRepository {

    public void salvar(Aluno aluno) {
        MongoClient  mongoClient = new MongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase("local");
        MongoCollection<Aluno> collectionAlunos = mongoDatabase.getCollection("alunos", Aluno.class);
        collectionAlunos.insertOne(aluno);
    }


}
