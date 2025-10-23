package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.categoria;

public class modelCategoria extends AbstractTableModel {
    private List<categoria> categorias = new ArrayList<categoria>();

    @Override
    public int getRowCount() {
         return categorias.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0-> {
                return "Id";
            }
            
            case 1-> {
                return "Nome";
            }
        }
        return "";
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 -> {
                return categorias.get(rowIndex).getId();
        }
            case 1 -> {
                return categorias.get(rowIndex).getNome();
            }
        }
        return "";
    }
    
    public void adiconarCategoria (categoria c) {
        categorias.add(c);
        fireTableRowsInserted(categorias.size() - 1, categorias.size()-1);
    }
    public void limparTabela() {
        categorias.clear();
    }
    public categoria pegarCategoria(int indice) {
        return categorias.get(indice);
    }
    
    public void excluir(int indice) {
        categorias.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }
}