package br.com.mongo.MongoProject.controller;

import br.com.mongo.MongoProject.entity.Aluno;
import br.com.mongo.MongoProject.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/aluno/cadastrar")
    public String cadastrar(Model model) {

        alunoRepository.salvar(new Aluno());

        return "aluno/cadastrar";
    }

}
