/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arquitecto.frontend.editor;

import com.arquitecto.DAO.MaterialDAO;
import com.arquitecto.model.Material;
import java.awt.Color;
import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Carlos Daniel
 */
public class ComboBoxEditor extends AbstractCellEditor implements TableCellEditor {

    private MaterialDAO dao;
    JComboBox<String> combo = new JComboBox<>();

    public ComboBoxEditor(MaterialDAO dao) {
        this.dao = dao;
    }

    @Override
    public Object getCellEditorValue() {

        return combo.getSelectedItem();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

        combo.setOpaque(false);
        combo.setBackground(new Color(0, 0, 0, 0));

        // Lee directamente de las columnas ocultas de la tabla
        Object val1 = table.getValueAt(row, 1); // columna unidad1 oculta
        Object val2 = table.getValueAt(row, 2); // columna unidad2 oculta

        if (val1 != null && !val1.toString().isEmpty()) {
            combo.addItem(val1.toString());
        }
        if (val2 != null && !val2.toString().isEmpty()) {
            combo.addItem(val2.toString());
        }
        
        
        combo.addActionListener(e -> {
            String nombre = table.getValueAt(row, 3).toString(); // columna nombre
            Material material = dao.buscarPorNombre(nombre);

            if (combo.getSelectedIndex() == 0) {
                table.setValueAt(material.getPu(), row, 6);
            } else {
                table.setValueAt(material.getPu2(), row, 6);
            }
        });

        return combo;
    }

}
