/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.FPrincipal;

/**
 *
 * @author Eduardo Stahnke
 */
public class ControllerPrincipal {
    private FPrincipal fPrincipal;
    private ControllerCategoria controlCategoria;

    public ControllerPrincipal() {
        fPrincipal = new FPrincipal();
        controlCategoria = new ControllerCategoria();
        inicializarComponentes();
    }
    
    public void executar(){
        fPrincipal.setVisible(true);
    }
    
    public void inicializarComponentes(){
        
        fPrincipal.miCadCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               abrirTelaCadastroCategoria();
            }
        });
                
    }
    
    public void abrirTelaCadastroCategoria(){
        controlCategoria.cadastrarCategoria();
    }
    
    
    
}
