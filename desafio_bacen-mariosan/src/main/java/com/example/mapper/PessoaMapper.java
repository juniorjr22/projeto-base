package com.example.mapper;

import java.util.ArrayList;
import java.util.List;

import com.example.dto.PessoaDto;
import com.example.model.Pessoa;

public class PessoaMapper {

    public static List<PessoaDto> converterPessoasParaPessoasDto(final List<Pessoa> pessoas) {
        final List<PessoaDto> pessoasDto = new ArrayList();
        for (final Pessoa pessoa : pessoas) {
            final PessoaDto pessoaDto = new PessoaDto();
            pessoaDto.setCpf(pessoa.getCpf());
            pessoaDto.setBairro(pessoa.getBairro());
            pessoaDto.setCidade(pessoa.getCidade());
            pessoaDto.setEmail(pessoa.getEmail());
            pessoaDto.setEndereco(pessoa.getEmail());
            pessoaDto.setEstado(pessoa.getEstado());
            pessoaDto.setNome(pessoa.getNome());
            pessoaDto.setId(pessoa.getId());
            pessoasDto.add(pessoaDto);
        }
        return pessoasDto;
    }

    public static PessoaDto converterPessoaParaPessoaDto(final Pessoa pessoa) {
        final PessoaDto pessoaDto = new PessoaDto();
        pessoaDto.setCpf(pessoa.getCpf());
        pessoaDto.setBairro(pessoa.getBairro());
        pessoaDto.setCidade(pessoa.getCidade());
        pessoaDto.setEmail(pessoa.getEmail());
        pessoaDto.setEndereco(pessoa.getEmail());
        pessoaDto.setEstado(pessoa.getEstado());
        pessoaDto.setNome(pessoa.getNome());
        pessoaDto.setId(pessoa.getId());
        return pessoaDto;
    }

    public static Pessoa converterPessoaDtoParaPessoa(final PessoaDto pessoaDto) {
        final Pessoa pessoa = new Pessoa();
        pessoa.setCpf(pessoaDto.getCpf());
        pessoa.setNome(pessoaDto.getNome());
        pessoa.setEmail(pessoaDto.getEmail());
        pessoa.setEndereco(pessoaDto.getEndereco());
        pessoa.setBairro(pessoaDto.getBairro());
        pessoa.setCidade(pessoaDto.getCidade());
        pessoa.setEstado(pessoaDto.getEstado());
        return pessoa;
    }

}
