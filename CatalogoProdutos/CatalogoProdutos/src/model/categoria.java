package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoria")
    private int id;
    private String nome;

    public categoria(String nome) {
        this.nome = nome;
    }

    public categoria() {
    }
    
    public int getId(){
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setid(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return nome;
    }
}
