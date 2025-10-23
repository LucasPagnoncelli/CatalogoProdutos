package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import view.FPrincipal;

public class ControllerPrincipal {
    private FPrincipal FPrincipal;
    private controllerCategoria controlCategoria;
    private controllerProduto controlProduto;
    
    public ControllerPrincipal () {
        this.FPrincipal = new FPrincipal();
        controlCategoria = new controllerCategoria();
        controlProduto = new controllerProduto();
        inicializarComponentes();
    }
    
    public void executar () {
        FPrincipal.setVisible(true);
    }
    public void inicializarComponentes() {
        
        FPrincipal.miCadCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastroCategoria();
            }
        });
        
        FPrincipal.miConsulta.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaConsulta();
            }
        });
        
        FPrincipal.btSair.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                FPrincipal.dispose();
                System.exit(0);
            }
        });
        
        FPrincipal.miCadProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastroProduto();
            }
        });
        
        FPrincipal.miConsultaProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlProduto.abrirTelaConsulta(true);
            }
        });
    }
    
    public void abrirTelaCadastroCategoria() {
        controlCategoria.cadastrarCategoria();
    }
    
    public void abrirTelaConsulta() {
        controlCategoria.consultarCategorias();
    }
    
    public void abrirTelaCadastroProduto() {
        controlProduto.abrirTelaProduto(true);
    }
}
