package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduto;
    private String descricao;
    private double valor;
    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private categoria c;

    public produto(String descricao, double valor, categoria c) {
        this.descricao = descricao;
        this.valor = valor;
        this.c = c;
    }

    public produto() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public categoria getC() {
        return c;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setC(categoria c) {
        this.c = c;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
}