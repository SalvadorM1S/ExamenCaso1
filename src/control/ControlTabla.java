/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Estudiantes;

/**
 *
 * @author Ismael
 */
public class ControlTabla extends AbstractTableModel{
    private String[] columnas = {"Cedula", "Nombre", "Apellido", "Direccion","Coreeo", "Fecha", "Genero"};
    public static List<Estudiantes> filas;
    private Estudiantes usuarioSelecionado;
    private int indice;

    public ControlTabla() {
        filas = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return filas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        usuarioSelecionado = filas.get(rowIndex);
        this.indice = rowIndex;
        switch (columnIndex) {
            case 0:
                return usuarioSelecionado.getEstCedula();
            case 1:
                return usuarioSelecionado.getEstPnombre();
            case 2:
                return usuarioSelecionado.getEstApellidop();
            case 3:
                return usuarioSelecionado.getEstCorreo();
            case 4:
                return usuarioSelecionado.getEstDireccion();
            case 5:
                return usuarioSelecionado.getEstFecha();
            case 6:
                return usuarioSelecionado.getEstGenero();
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return Date.class;
            case 6:
                return String.class;
            default:
                return Object.class;
        }
    }

    public String[] getColumnas() {
        return columnas;
    }

    public void setColumnas(String[] columnas) {
        this.columnas = columnas;
    }

    public List<Estudiantes> getFilas() {
        return filas;
    }

    public void setFilas(List<Estudiantes> filas) {
        this.filas = filas;
    }

    public Estudiantes getUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    public void setUsuarioSelecionado(Estudiantes usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public void actualizar(Estudiantes u) {
        setUsuarioSelecionado(null);
        if (u != null) {
            filas.add(indice, u);
            fireTableDataChanged();
        }
    }

    public void agregar(Estudiantes u) {
        if (u != null) {
            filas.add(u);
            fireTableDataChanged();
        }
    }

    public void eliminar(Estudiantes u) {
        if (u != null) {
            filas.remove(u);
            fireTableDataChanged();
        }

    }

}
