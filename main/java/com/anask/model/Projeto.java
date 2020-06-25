package com.anask.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "tbl_projeto")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String descricao;
    private Date data_ini;
    private Date data_fim;
    private int status;
    private int lider;

    public Projeto(int id, String descricao, Date data_ini, Date data_fim, int status, int lider) {
        this.id = id;
        this.descricao = descricao;
        this.data_ini = data_ini;
        this.data_fim = data_fim;
        this.status = status;
        this.lider = lider;
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
