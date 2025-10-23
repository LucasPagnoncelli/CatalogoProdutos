/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Categoria;
import model.DaoCategoria;
import view.FCadCategoria;

/**
 *
 * @author Eduardo Stahnke
 */
public class ControllerCategoria {

    private FCadCategoria fCadCategoria;
    private DaoCategoria dao;

    public ControllerCategoria() {
        fCadCategoria = new FCadCategoria(null, true);
        dao = new DaoCategoria();
        inicializarComponentes();
    }
    
    public void cadastrarCategoria(){
        fCadCategoria.setVisible(true);
    }
    
    public void inicializarComponentes(){
     
        fCadCategoria.btGravar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inserir();
            }
        });
        
        fCadCategoria.btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();
            }
        });
        
    }
    
    public void cancelar(){
        limpar();
        fCadCategoria.setVisible(false);
    }
    
    public void limpar(){
        fCadCategoria.edNome.setText("");
    }
    
    public void inserir(){
        String nome = fCadCategoria.edNome.getText();
        Categoria c = new Categoria(nome);
        if(dao.inserir(c)){
            JOptionPane.showMessageDialog(null, "Gravado");
            limpar();
        }else{
            JOptionPane.showMessageDialog(null, "Erro");
        }
    }
    
    

}
