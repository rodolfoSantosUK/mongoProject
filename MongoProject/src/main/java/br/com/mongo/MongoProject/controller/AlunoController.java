package br.com.mongo.MongoProject.controller;

import br.com.mongo.MongoProject.entity.Aluno;
import br.com.mongo.MongoProject.entity.Curso;
import br.com.mongo.MongoProject.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping("/aluno/cadastrar")
    public String cadastrar(Model model) {
        Aluno aluno = new Aluno();
        aluno.setNome("Fulano de tal");
        Curso curso = new Curso("teste");
        curso.setNome("Ciencias da Computação");
        aluno.setCurso(curso);

        alunoRepository.salvar(aluno);

        return "aluno/cadastrar";
    }
    @GetMapping
    public ResponseEntity<List<Aluno>> obterAlunos() {
        return new ResponseEntity<List<Aluno>>(alunoRepository.listar(), HttpStatus.OK) ;
    }

}
