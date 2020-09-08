package com.example.dto;

import lombok.Data;

@Data
public class PessoaDto {

    public PessoaDto() {
        super();
    }

    public PessoaDto(final Long id, final String cpf, final String nome, final String email, final String endereco,
            final String bairro, final String cidade, final String estado) {
        super();
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    private Long id;

    private String cpf;

    private String nome;

    private String email;

    private String endereco;

    private String bairro;

    private String cidade;

    private String estado;

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PessoaDto other = (PessoaDto) obj;
        if (cpf == null) {
            if (other.cpf != null) {
                return false;
            }
        } else if (!cpf.equals(other.cpf)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (cpf == null ? 0 : cpf.hashCode());
        return result;
    }

}
