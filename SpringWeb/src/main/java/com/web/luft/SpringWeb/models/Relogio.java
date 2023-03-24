package com.web.luft.SpringWeb.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

// Tabela que registrará os dados pessoais e de contato do colaborador

@Entity
@Table(name = "celular")
@Data
public class Relogio {

    public Relogio() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "modelo", length = 15)
    @NotEmpty
    private String modelo;

    @Column(name = "marca", length = 20)
    @NotEmpty
    private String marca;

    @Column(name = "cor", length = 15)
    @NotEmpty
    private String cor;

    @Column(name = "serialnumber", unique = true, length = 100)
    @NotEmpty
    private String serialnumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "colaborador_id", referencedColumnName = "id")
    private Colaboradores colaborador;
}
