package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.PessoaDto;
import com.example.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin(origins = "http://localhost:4200")
public class PessoaRest {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<PessoaDto> listar() {
        return pessoaService.listar();
    }

    @PostMapping
    public PessoaDto inserir(@RequestBody final PessoaDto pessoa) {
        return pessoaService.inserir(pessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> excluir(@PathVariable(value = "id") final Long id) {
        return ResponseEntity.ok(pessoaService.excluir(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> atualizar(@PathVariable(value = "id") final Long id,
            @RequestBody final PessoaDto pessoaDto) {
        return ResponseEntity.ok(pessoaService.atualizar(id, pessoaDto));
    }

}
