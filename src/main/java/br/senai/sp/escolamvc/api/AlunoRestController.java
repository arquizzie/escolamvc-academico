package br.senai.sp.escolamvc.api;

import br.senai.sp.escolamvc.model.Aluno;
import br.senai.sp.escolamvc.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aluno")


public class AlunoRestController {
    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/listar")
    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }

    @PostMapping("/inserir")
    public Aluno inserir(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @PutMapping("/alterar")
    public Aluno alterar(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Aluno aluno) {
        alunoRepository.delete(aluno);
    }

    @PostMapping("/inserir-varios")
    public void inserirVarios(@RequestBody List<Aluno> aluno) {
        alunoRepository.saveAll(aluno);
    }

    @GetMapping("/buscar/{id}")
    public Aluno buscarPorId(@PathVariable Long id) {
        return alunoRepository.findById(id).get();
    }

    @GetMapping("/buscar-por-nome/nome}")
    public List<Aluno> buscarPorNome(@PathVariable String nome) {
        return alunoRepository.findAlunosByNomeContaining(nome);
    }

    @GetMapping("/buscar/{cpf}")
    public Aluno buscarPorId(@PathVariable String cpf) {
        return alunoRepository.findAlunoByCpf(cpf);
    }
}

