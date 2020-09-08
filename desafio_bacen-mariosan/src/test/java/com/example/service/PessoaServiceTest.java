package com.example.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.example.model.Pessoa;

public class PessoaServiceTest {

    private PessoaService pessoaService;
    private Pessoa pessoa;

    @Before
    public void setup() {
        pessoaService = new PessoaService();
    }

    @Test
    public void cpfJaExiste() {
        pessoa = new Pessoa();
        pessoa.setId(1L);

        final Boolean isCpfJaExiste = pessoaService.isCpfJaExiste(pessoa);

        Assert.assertTrue(isCpfJaExiste);
    }

    @Test
    public void cpfNaoExiste() {
        pessoa = null;

        final Boolean isCpfJaExiste = pessoaService.isCpfJaExiste(pessoa);

        Assert.assertFalse(isCpfJaExiste);
    }

}
