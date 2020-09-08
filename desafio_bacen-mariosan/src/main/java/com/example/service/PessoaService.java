package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.PessoaDto;
import com.example.mapper.PessoaMapper;
import com.example.model.Pessoa;
import com.example.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaDto inserir(final PessoaDto pessoaDto) {
        final Pessoa pessoaComCpf = pessoaRepository.findByCpf(pessoaDto.getCpf());
        if (!isCpfJaExiste(pessoaComCpf)) {
            final Pessoa pessoa = PessoaMapper.converterPessoaDtoParaPessoa(pessoaDto);
            return PessoaMapper.converterPessoaParaPessoaDto(pessoaRepository.save(pessoa));
        }
        return null;

    }

    public List<PessoaDto> listar() {
        final List<Pessoa> pessoas = pessoaRepository.findAll();
        return PessoaMapper.converterPessoasParaPessoasDto(pessoas);
    }

    public Boolean excluir(final Long id) {
        final Optional<Pessoa> optional = pessoaRepository.findById(id);
        if (optional.get() != null && optional.get().getId() != null) {
            pessoaRepository.deleteById(id);
            return true;
        }
        return false;

    }

    public Boolean atualizar(final Long id, final PessoaDto pessoaDto) {
        final Pessoa pessoaComCpf = pessoaRepository.findByCpf(pessoaDto.getCpf());
        if (pessoaComCpf == null || pessoaComCpf.getId().equals(pessoaDto.getId())) {
            final Optional<Pessoa> optional = pessoaRepository.findById(id);
            if (optional.get() != null && optional.get().getId() != null) {
                final Pessoa pessoaSalva = optional.get();
                pessoaSalva.setCpf(pessoaDto.getCpf());
                pessoaSalva.setNome(pessoaDto.getNome());
                pessoaSalva.setEmail(pessoaDto.getEmail());
                pessoaSalva.setEndereco(pessoaDto.getEndereco());
                pessoaSalva.setBairro(pessoaDto.getBairro());
                pessoaSalva.setCidade(pessoaDto.getCidade());
                pessoaSalva.setEstado(pessoaDto.getEstado());
                pessoaRepository.save(pessoaSalva);
                return true;
            }
        }
        return null;
    }

    public Boolean isCpfJaExiste(final Pessoa pessoa) {
        if (pessoa == null || pessoa.getId() == null) {
            return false;
        }
        return true;
    }

}
