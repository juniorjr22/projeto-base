package com.example.rest;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.dto.PessoaDto;
import com.example.service.PessoaService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PessoaRestTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private PessoaService pessoaServiceMock;

    private PessoaRest pessoaRest;

    @Before
    public void setup() {
        pessoaRest = Mockito.mock(PessoaRest.class);
    }

    @Test
    public void inserirComSucessoTest() {
        final PessoaDto dto = new PessoaDto();
        dto.setCpf("99988877766");

        Mockito.when(pessoaServiceMock.inserir(dto)).thenReturn(new PessoaDto(2L, "99988877766", "Beltrano",
                "beltrano@gmail.com", "Rua 2", "Centro", "Luziânia", "GO"));

        final ResponseEntity<PessoaDto> response = restTemplate.postForEntity("/pessoas", dto, PessoaDto.class);

        Assert.assertNotNull(response.getBody());

    }

    @Test
    public void inserirCpfJaExistenteTest() {
        final PessoaDto dto = new PessoaDto();
        dto.setCpf("99988877766");

        Mockito.when(pessoaServiceMock.inserir(dto)).thenReturn(null);

        final ResponseEntity<PessoaDto> response2 = restTemplate.postForEntity("/pessoas", dto, PessoaDto.class);

        Assert.assertNull(response2.getBody());

    }

    @Test
    public void listarPessoasTest() {
        final List<PessoaDto> pessoas = Arrays.asList(
                new PessoaDto(1L, "00011122233", "Fulano", "fulano@gmail.com", "Rua 1", "Guará", "Brasília", "DF"),
                new PessoaDto(2L, "99988877766", "Beltrano", "beltrano@gmail.com", "Rua 2", "Centro", "Luziânia",
                        "GO"));
        Mockito.when(pessoaServiceMock.listar()).thenReturn(pessoas);

        final ResponseEntity<List> response = restTemplate.getForEntity("/pessoas", List.class);

        Assert.assertNotNull(response.getBody());
    }

//  @Test
//  public void inserirComSucessoTesteDeIntegracao() {
//      final PessoaDto dto = new PessoaDto();
//      dto.setCpf("03641096103");
//
//      final ResponseEntity<PessoaDto> response = restTemplate.postForEntity("/pessoas", dto, PessoaDto.class);
//
//      Assert.assertNotNull(response.getBody());
//
//  }
//
//  @Test
//  public void inserirCpfJaExistenteTesteDeIntegracao() {
//      final PessoaDto dto = new PessoaDto();
//      dto.setCpf("03641096103");
//
//      final ResponseEntity<PessoaDto> response = restTemplate.postForEntity("/pessoas", dto, PessoaDto.class);
//
//      Assert.assertNotNull(response.getBody());
//
//      final ResponseEntity<PessoaDto> response2 = restTemplate.postForEntity("/pessoas", dto, PessoaDto.class);
//
//      Assert.assertNull(response2.getBody());
//
//  }

}
