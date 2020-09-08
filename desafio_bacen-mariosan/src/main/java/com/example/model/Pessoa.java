package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_pessoa")
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nu_cpf", nullable = true)
    private String cpf;

    @Column(name = "no_pessoa", nullable = true)
    private String nome;

    @Column(name = "ds_email", nullable = true)
    private String email;

    @Column(name = "ds_endereco", nullable = true)
    private String endereco;

    @Column(name = "ds_bairro", nullable = true)
    private String bairro;

    @Column(name = "no_cidade", nullable = true)
    private String cidade;

    @Column(name = "no_estado", nullable = true)
    private String estado;

}
