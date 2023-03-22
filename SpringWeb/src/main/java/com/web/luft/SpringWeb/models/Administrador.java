package com.web.luft.SpringWeb.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.List;

@Entity
@Table(name = "administradores")
@Data
public class Administrador {

    public Administrador() {}

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome", length = 100)
    @NotEmpty
    private String nome;

    @Column(name = "email", length = 180)
    @NotEmpty
    private String email;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$", message = "A senha deve conter pelo menos 8 caracteres, incluindo uma letra, um número e um caractere especial")
    @Column(name = "senha", length = 255)
    @NotEmpty
    @Lob
    @JsonIgnore
    private String senha;

    @Column(name = "usuario")
    @NotEmpty
    private String usuario;

    @Column(name = "observacao")
    @Type(type = "text")
    @Size(max = 500)
    private String observacao;

    public Administrador(String email, String encode) {}

    public Administrador(String nome, String email, String senha, String usuario, String observacao) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.usuario = usuario;
        this.observacao = observacao;
    }
}

