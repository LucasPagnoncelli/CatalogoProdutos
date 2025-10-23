package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.produto;

public class modelProduto extends AbstractTableModel {

    private List<produto> produtos = new ArrayList<produto>();

    @Override
    public int getRowCount() {
        return produtos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 -> {
                return "Id";
            }

            case 1 -> {
                return "Descrição";
            }

            case 2 -> {
                return "Categoria";
            }

            case 3 -> {
                return "Valor";
            }
        }
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                return produtos.get(rowIndex).getIdProduto();
            }
            case 1 -> {
                return produtos.get(rowIndex).getDescricao();
            }
            case 2 -> {
                return produtos.get(rowIndex).getC();
            }
            case 3-> {
                return produtos.get(rowIndex).getValor();
            }
        }
        return "";
    }

    public void adiconarProduto(produto c) {
        produtos.add(c);
        fireTableRowsInserted(produtos.size() - 1, produtos.size() - 1);
    }

    public void limparTabela() {
        produtos.clear();
    }

    public produto pegarProduto(int indice) {
        return produtos.get(indice);
    }

    public void excluir(int indice) {
        produtos.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }
}