package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.categoria;
import model.daoCategoria;
import model.daoProduto;
import model.produto;
import view.fCadProduto;
import view.fConsultaCategoria;
import view.fConsultaProduto;
import view.modelProduto;

public class controllerProduto {

    private daoCategoria daoCategoria;
    private fCadProduto fCadProduto;
    private daoProduto daoProduto;
    private fConsultaProduto fConsultaProduto;
    private modelProduto modelProduto;
    private produto produto;

    public controllerProduto() {
        daoCategoria = new daoCategoria();
        fCadProduto = new fCadProduto(null, true);
        daoProduto = new daoProduto();
        fConsultaProduto = new fConsultaProduto(null, true);
        modelProduto = new modelProduto();
        produto = null;
        inicializarComponentes();
    }

    public void abrirTelaProduto(boolean fos) {
        carregarCategorias();
        fCadProduto.setVisible(fos);
    }

    public void inicializarComponentes() {
        fCadProduto.btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpar();
                abrirTelaProduto(false);
            }
        });

        fCadProduto.btGravar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inserir();
            }
        });
        
        fConsultaProduto.tbConsultaProduto.setModel(modelProduto);
        
        fConsultaProduto.btVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaConsulta(false);
            }
        });
        
        fConsultaProduto.btExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluir();
            }
        });
    }

    public void cadastrarProduto() {
        carregarCategorias();
        fCadProduto.setVisible(true);
    }

    public void carregarCategorias() {
        fCadProduto.cbCategoria.removeAllItems();
        for (categoria c : daoCategoria.listar()) {
            fCadProduto.cbCategoria.addItem(c);
        }

    }

    public void inserir() {
        String descricao = fCadProduto.edDescricao.getText();
        double valor = Double.parseDouble(fCadProduto.edValor.getText());
        categoria c = (categoria) fCadProduto.cbCategoria.getSelectedItem();
        produto = new produto(descricao, valor,c);
        if (daoProduto.inserir(produto)) {
            JOptionPane.showMessageDialog(null, "Gravado");
            abrirTelaProduto(false);
            limpar();
        } else {
            JOptionPane.showMessageDialog(null, "Erro");
            abrirTelaProduto(false);
        }
    }
    
    public void excluir() {
        int linhaSelecionada = fConsultaProduto.tbConsultaProduto.getSelectedRow();
        if (linhaSelecionada >= 0) {
            if (JOptionPane.showConfirmDialog(null, "Realmente excluir?", "Confirmação", 0) == 0) {
                produto p = modelProduto.pegarProduto(linhaSelecionada);
                if (daoProduto.excluir(p)) {
                    modelProduto.excluir(linhaSelecionada);
                    JOptionPane.showMessageDialog(null, "Excluído");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um linha");
        }
    }
    
    public void abrirTelaConsulta(boolean fos){
        carregarProdutos();
        fConsultaProduto.setVisible(fos);
    }
   
    
    public void limpar() {
        fCadProduto.edDescricao.setText(" ");
        fCadProduto.edValor.setText(" ");
        fCadProduto.cbCategoria.setSelectedIndex(-1);
    }
    
    public void carregarProdutos() {
        modelProduto.limparTabela();
        for (produto p : daoProduto.listar()) {
            modelProduto.adiconarProduto(p);
        }
    }
}