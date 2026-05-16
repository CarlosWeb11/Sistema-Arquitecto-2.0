/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arquitecto.frontend.renders;

import com.arquitecto.model.Material;
import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Carlos Daniel
 */
public class ComboBoxRenderer implements TableCellRenderer {


    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JComboBox<String> combo = new JComboBox<>();

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

        return combo;

    }
}
