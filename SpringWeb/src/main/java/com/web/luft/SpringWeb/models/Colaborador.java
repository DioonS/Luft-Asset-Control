package com.web.luft.SpringWeb.models;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

// Tabela que registrará os dados pessoais e de contato do colaborador

@Entity
@Table(name = "colaboradores")
@Data
public class Colaborador {

    public Colaborador() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nomecompleto", unique = true, length = 100)
    @NotEmpty
    private String nomecompleto;

    @Column(name = "cpf", unique = true, length = 11) // 11 Caracteres numericos + 3 especiais
    @NotEmpty
    private String cpf;

    @Column(name = "email", unique = true, length = 180)
    @NotEmpty
    private String email;

    @Column(name = "telefone", unique = true, length = 11)
    @NotEmpty
    private String telefone;

    @Column(name = "setor", length = 30)
    @NotEmpty
    private String setor;

    @Column(name = "cargo", length = 50)
    @NotEmpty
    private String cargo; // Cargo / Função do colaborador

    @Column(name = "gestor", length = 100)
    @NotEmpty
    private String gestor; // Superior imediato (Gestor, Supervisor, Gerente, etc.)

    @Column(name = "observacao")
    @Type(type = "text")
    @Size(max = 500)
    private String observacao;

    @OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL)
    private List<Relogio> relogios;

    @OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL)
    private List<Celular> celulares;

    @OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL)
    private List<CarregadorCelular> carregadorCelulares;

    @OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL)
    private List<CarregadorNotebook> carregadorNotebooks;

    @OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL)
    private List<FoneBluetooth> fonesBluetooth;

    @OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL)
    private List<FoneDeOuvido> fonesDeOuvido;

    @OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL)
    private List<Notebook> notebooks;
}