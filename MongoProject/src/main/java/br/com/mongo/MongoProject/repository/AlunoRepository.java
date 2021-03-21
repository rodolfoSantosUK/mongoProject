package br.com.mongo.MongoProject.repository;

import br.com.mongo.MongoProject.codec.AlunoCodec;
import br.com.mongo.MongoProject.entity.Aluno;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlunoRepository {

    private MongoClient mongoClient;

    public void salvar(Aluno aluno) {
        MongoCollection<Aluno> collectionAlunos = getAlunoMongoCollection();
        collectionAlunos.insertOne(aluno);
    }

    public List<Aluno> listar() {

        List<Aluno> alunosEncontrados = new ArrayList<>();
        MongoCursor<Aluno> resultado = getAlunoMongoCollection().find().iterator();

        while (resultado.hasNext()) {
            Aluno alunoNext = resultado.next();
            alunosEncontrados.add(alunoNext);
        }
        mongoClient.close();
        return alunosEncontrados;
    }

    private MongoCollection<Aluno> getAlunoMongoCollection() {
        Codec<Document> codec = MongoClient.getDefaultCodecRegistry().get(Document.class);
        AlunoCodec alunoCodec = new AlunoCodec(codec);
        CodecRegistry registro = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),
                CodecRegistries.fromCodecs(alunoCodec));
        MongoClientOptions opcoes = MongoClientOptions.builder().codecRegistry(registro).build();

        mongoClient = new MongoClient("localhost:27017", opcoes);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("local");
        MongoCollection<Aluno> collectionAlunos = mongoDatabase.getCollection("alunos", Aluno.class);
        return collectionAlunos;
    }


}
