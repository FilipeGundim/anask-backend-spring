package com.anask.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_projeto")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_projeto", nullable = false)
    private int id;
    private String descricao;
    private String titulo;
    private Date data_ini;
    private Date data_fim;
    private int status;
    private int lider;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="tbl_projeto_usuario",
            uniqueConstraints = @UniqueConstraint( columnNames = {"id_usuario", "id_projeto"}),
            joinColumns = @JoinColumn(name = "id_projeto"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario")
    )
    private List<Usuario> usuarios = new ArrayList<>();;

    public Projeto(int id, String descricao, String titulo, Date data_ini, Date data_fim, int status, int lider, List<Usuario> usuarios) {
        this.id = id;
        this.descricao = descricao;
        this.titulo = titulo;
        this.data_ini = data_ini;
        this.data_fim = data_fim;
        this.status = status;
        this.lider = lider;
        this.usuarios = usuarios;
    }

    public Projeto(){}

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData_ini() {
        return data_ini;
    }

    public void setData_ini(Date date) {
        this.data_ini = date;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date date) {
        this.data_fim = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getLider() {
        return lider;
    }

    public void setLider(int lider) {
        this.lider = lider;
    }

}
