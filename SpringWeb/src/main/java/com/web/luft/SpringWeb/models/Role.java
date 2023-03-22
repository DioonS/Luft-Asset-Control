package com.web.luft.SpringWeb.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotEmpty
    private String funcao;

    public Role() {
        this.funcao = "ADMIN";
    }

    public Role(String funcao) {
        this.funcao = funcao;
    }
}
