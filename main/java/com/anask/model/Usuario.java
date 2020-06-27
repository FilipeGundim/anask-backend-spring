package com.anask.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name= "tbl_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_usuario", nullable = false)
    private int id;
    private String nome;
    private Date datanasc;
    private String sexo;
    private String email;
    private String senha;

    @OneToMany(mappedBy="usuario", fetch = FetchType.LAZY)
    private List<Atividade> atividades = new ArrayList<>();

    public Usuario(int id, String nome, Date datanasc, String sexo, String email, String senha, List<Atividade> atividades) {
        this.id = id;
        this.nome = nome;
        this.datanasc = datanasc;
        this.sexo = sexo;
        this.email = email;
        this.senha = senha;
        this.atividades = atividades;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    public void addAtividade(Atividade atividade){
        this.atividades.add(atividade);
    }

    public void removeAtividade(Atividade atividade){
        this.atividades.remove(atividade);
    }

    public Usuario(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
