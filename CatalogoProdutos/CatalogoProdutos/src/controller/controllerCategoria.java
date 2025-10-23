package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.categoria;
import model.daoCategoria;
import view.fCadCategoria;
import view.fConsultaCategoria;
import view.modelCategoria;

public class controllerCategoria {

    private fCadCategoria fCadCategoria;
    private fConsultaCategoria fConsultaCategoria;
    private daoCategoria daoCategoria;
    private modelCategoria modelCategoria;
    private categoria categoriaSelecionada;

    public controllerCategoria() {
        fCadCategoria = new fCadCategoria(null, true);
        daoCategoria = new daoCategoria();
        fConsultaCategoria = new fConsultaCategoria(null, true);
        modelCategoria = new modelCategoria();
        categoriaSelecionada = null;
        inicializarComponentes();
    }

    public void cadastrarCategoria() {
        fCadCategoria.setVisible(true);
    }

    public void consultarCategorias() {
        carregarCategorias();
        fConsultaCategoria.setVisible(true);
    }

    public void carregarCategorias() {
        modelCategoria.limparTabela();
        for (categoria c : daoCategoria.listar()) {
            modelCategoria.adiconarCategoria(c);
        }
    }

    public void inicializarComponentes() {
        fCadCategoria.btGravar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inserir();
            }
        }
        );
        fCadCategoria.btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelarCategoria();
            }
        });

        fConsultaCategoria.btVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpar();
                voltarConsulta();
            }
        });

        fConsultaCategoria.tbCategorias.setModel(modelCategoria);

        fConsultaCategoria.btExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluir();
            }
        });

        fConsultaCategoria.btEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editar();
            }
        });

    }

    public void editar() {
        int linhaSelecionada = fConsultaCategoria.tbCategorias.getSelectedRow();
        if (linhaSelecionada >= 0) {
            categoriaSelecionada = modelCategoria.pegarCategoria(linhaSelecionada);
            fCadCategoria.edNome.setText(categoriaSelecionada.getNome());
            fConsultaCategoria.setVisible(false);
            fCadCategoria.setVisible(true);
            fConsultaCategoria.setVisible(true);
        } else {
            JOptionPane.showConfirmDialog(null, "Selecione");
        }
    }

    public void excluir() {
        int linhaSelecionada = fConsultaCategoria.tbCategorias.getSelectedRow();
        if (linhaSelecionada >= 0) {
            if (JOptionPane.showConfirmDialog(null, "Realmente excluir?", "Confirmação", 0) == 0) {
                categoria c = modelCategoria.pegarCategoria(linhaSelecionada);
                if (daoCategoria.excluir(c)) {
                    modelCategoria.excluir(linhaSelecionada);
                    JOptionPane.showMessageDialog(null, "Excluído");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha");

        }
    }

    public void cancelarCategoria() {
        limpar();
        fCadCategoria.setVisible(false);
    }

    public void voltarConsulta() {
        limpar();
        fConsultaCategoria.setVisible(false);
    }

    public void inserir() {
        if (categoriaSelecionada == null) {
            String nome = fCadCategoria.edNome.getText();
            categoria c = new categoria(nome);
            if (daoCategoria.cadastrarCategoria(c)) {
                JOptionPane.showMessageDialog(null, "Gravado");
                limpar();
                fCadCategoria.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Erro");
            }
        }else{
            String nome = fCadCategoria.edNome.getText();
            categoriaSelecionada.setNome(nome);
            if (daoCategoria.editar(categoriaSelecionada)) {
                JOptionPane.showMessageDialog(null, "Editado");
                limpar();
                fCadCategoria.setVisible(false);
            }else
                JOptionPane.showMessageDialog(null, "Erro");
        }
    }
    
    public void limpar() {
        categoriaSelecionada = null;
        fCadCategoria.edNome.setText(" ");
    }
}